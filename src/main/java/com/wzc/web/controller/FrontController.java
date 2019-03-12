package com.wzc.web.controller;

import com.alibaba.fastjson.JSON;
import com.wzc.bean.*;
import com.wzc.service.*;
import com.wzc.utils.JsonT;
import com.wzc.utils.ParamT;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Controller
public class FrontController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUploadFileService uploadFileService;

    @Autowired
    private INoticeService noticeService;

    @Autowired
    private ITopicService topicService;

    @Autowired
    private ICircleService circleService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "front/login";
    }

    @RequestMapping("toRegister")
    public String toRegister(){
        return "front/regist";
    }

    @RequestMapping("circles")
    public String circles(HttpServletRequest request, HttpServletResponse response){
        return "front/circles";
    }

    @RequestMapping("search")
    public String search(String keyword){
        return "front/search";
    }

    @RequestMapping("login")//登录
    public void loginByEmail(HttpServletRequest request, HttpServletResponse response){
        String kaptchaExpected = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        String email = ParamT.getString(request,"email");
        String password = ParamT.getString(request,"password");
        String captchaCode = ParamT.getString(request,"captchaCode");
        if(captchaCode.equals(kaptchaExpected)){
            User user = userService.loginByEmail(email);
            if(user!=null){
                if(password.equals(user.getPassword())){
                    request.getSession().setAttribute("loginUser",user);
                    List<Circle> circles = circleService.selectByUserId(user.getUserid());
                    StringBuilder myCircleIds = new StringBuilder();
                    for(Circle circle: circles){
                        myCircleIds.append("|").append(circle.getId()).append("|");
                    }
                    request.getSession().setAttribute("myCircleIds",myCircleIds.toString());
                    JsonT.respJSON(response,true,"验证成功",user.getUserroles());
                }else{
                    JsonT.respJSON(response,false,"密码错误",null);
                }
            }else{
                JsonT.respJSON(response,false,"邮箱不存在",null);
            }
        }else{
            JsonT.respJSON(response,false,"验证码错误",null);
        }
    }

    @RequestMapping("register")//注册
    public void registerByEmail(User user,HttpServletRequest request, HttpServletResponse response){
        user.setCreatetime(new Date());
        user.setUserroles("user");
        user.setState("1");
        user.setPhoto("/upload/default.png");
        if(userService.insert(user)){
            ServletContext context =request.getSession().getServletContext();
            Integer userTotal = (Integer)context .getAttribute("userTotal");
            context.setAttribute("userTotal",userTotal+1);
            request.getSession().setAttribute("loginUser",user);
            JsonT.respJSON(response,true,"注册成功",user);
        }else{
            JsonT.respJSON(response,false,"注册失败",null);
        }
    }

    @RequestMapping("logout")//退出登录
    public String logout(HttpServletRequest request) throws IOException {
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("myCircleIds");
        return "front/index";
    }

    @RequestMapping("checkUsernameIsExist")//检查用户名是否存在
    public void checkUsernameIsExist(String username,HttpServletResponse response) throws IOException {
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("valid",false);
        if(username!=null&&!username.trim().equals("")){
            res.put("valid",userService.checkUsernameIsExist(username));
        }
        response.getWriter().print(JSON.toJSONString(res));
    }

    @RequestMapping("checkEmailIsExist")//检查邮箱是否注册
    public void checkEmailIsExist(String email,HttpServletResponse response) throws IOException {
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("valid",false);
        if(email!=null&&!email.trim().equals("")){
            res.put("valid",userService.checkEmailIsExist(email));
        }
        response.getWriter().print(JSON.toJSONString(res));
    }

    @RequestMapping("userphoto/{userid}")//根据用户id获取用户头像
    public void userphoto(@PathVariable Integer userid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = userService.selectByPrimaryKey(userid);
        String pathName = request.getSession().getServletContext().getRealPath("/");
        if(user!=null&&StringUtils.isNotBlank(user.getPhoto())&&new File(pathName+user.getPhoto()).exists()){
            pathName = pathName +user.getPhoto();
        }else{
            pathName = pathName +"/upload/default.png";
        }
        FileInputStream fis = new FileInputStream(pathName);
        byte[] bytes = IOUtils.toByteArray(fis);
        response.getOutputStream().write(bytes);
    }

    @RequestMapping("getUpFile/{id}")//获取上传的文件
    public void getUpFile(@PathVariable Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        UploadFile uploadFile = uploadFileService.selectByPrimaryKey(id);
        String pathName=request.getServletContext().getRealPath("/upload/loadfail.png");
        if (uploadFile!=null){
            String pathName2 = request.getServletContext().getRealPath(uploadFile.getPathname());
            if(new File(pathName2).exists()){
                pathName =pathName2;
            }
        }
        FileInputStream fis = new FileInputStream(pathName);
        byte[] bytes = IOUtils.toByteArray(fis);
        response.getOutputStream().write(bytes);
    }

    @RequestMapping("getAllNotices")//检查邮箱是否注册
    public void getAllNotices(HttpServletResponse response) throws IOException {
        JsonT.respJSON(response,true,"数据获取成功",noticeService.selectAll());
    }

    @RequestMapping("notice/{id}")//检查邮箱是否注册
    public void getAllNotices(@PathVariable Integer id ,HttpServletResponse response) throws IOException {
        JsonT.respJSON(response,true,"数据获取成功",noticeService.selectByPrimaryKey(id));
    }

    @RequestMapping("/pageTopics")
    public void fpageTopics( HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer pn =ParamT.getInt(request,"page",1);
        Integer ps =ParamT.getInt(request,"limit",10);
        String keyword = ParamT.getString(request,"keyword","");
        String orderBy = ParamT.getString(request,"orderBy","createtime");
        TopicExample example = new TopicExample();
        TopicExample.Criteria criteria =example.createCriteria();
        criteria.andStateEqualTo("1");
        criteria.andCircleidEqualTo(0);
        if(StringUtils.isNotBlank(keyword)){
            criteria.andTitleLike("%"+keyword+"%");
        }
        if(orderBy.equals("com_total")){
            example.setOrderByClause("com_total desc,view_total desc,title asc ");
        }else{
            example.setOrderByClause("createtime desc,title asc ");
        }
        PageInfo<Topic> pageInfo = topicService.queryByPage(pn,ps,example);
        JsonT.respJSON(response,true,"数据获取成功",pageInfo);
    }

    @RequestMapping("/pagecircles")
    public void pagecircles(HttpServletRequest request, HttpServletResponse response){
        Integer pn =ParamT.getInt(request,"page",1);
        Integer ps =ParamT.getInt(request,"limit",10);
        String cname = ParamT.getString(request,"cname","");
        CircleExample example =new CircleExample();
        CircleExample.Criteria criteria = example.createCriteria();
        criteria.andCircleStateEqualTo("1");
        if(StringUtils.isNotBlank(cname)){
            criteria.andCircleNameLike("%"+cname+"%");
        }
        PageInfo<Circle> pageInfo = circleService.queryByPage(pn,ps,example);
        JsonT.respJSON(response,true,"数据获取成功",pageInfo);
    }

    @RequestMapping("/searchUser")//获取当前登录人的相册列表
    public void searchUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String info =ParamT.getString(request,"info","");
        List<User> list =new ArrayList<User>();
        if(StringUtils.isNotBlank(info)){
            UserExample example =new UserExample();
            UserExample.Criteria criteria1 =example.createCriteria();
            criteria1.andUsernameLike("%"+info+"%");
            UserExample.Criteria criteria2 =example.createCriteria();
            criteria2.andEmailEqualTo(info);
            example.or(criteria2);
            list =userService.selectByExample(example);

        }
        JsonT.respJSON(response,true,"数据获取成功",list);
    }
}
