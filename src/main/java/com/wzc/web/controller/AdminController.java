package com.wzc.web.controller;

import com.wzc.bean.*;
import com.wzc.service.*;
import com.wzc.utils.JsonT;
import com.wzc.utils.ParamT;
import com.wzc.utils.StrT;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class AdminController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ICircleService circleService;

    @Autowired
    private IRelationMapService mapService;

    @Autowired
    private ITopicService topicService;

    @Autowired
    private INoticeService noticeService;

    @Autowired
    private IAlbumService albumService;

    @Autowired
    private ICommentService commentService;

    @RequestMapping("/a")
    public String toAdminIndex(){
        return "admin/index";
    }

    @RequestMapping("/a/p/{pagename}")
    public String toAdminPage(@PathVariable("pagename") String pagename) throws IOException {
        if(pagename==null){
            return "admin/index";
        }
        return "admin/"+pagename;
    }

    /**
     * 用户管理
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/a/addUser")//后台添加用户
    public void addUser(User user,HttpServletRequest request, HttpServletResponse response){
        user.setCreatetime(new Date());
        user.setState("1");
        user.setPhoto("/upload/default.png");
        if(userService.insert(user)){
            ServletContext context =request.getSession().getServletContext();
            Integer userTotal = (Integer)context .getAttribute("userTotal");
            context.setAttribute("userTotal",userTotal+1);
            JsonT.respJSON(response,true,"添加成功",null);
        }else{
            JsonT.respJSON(response,false,"添加失败",null);
        }
    }

    @RequestMapping("/a/delUser")//后台删除用户
    public void userdel(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer userid =ParamT.getInt(request,"userid");
        if(userid!=0&&userService.deleteByPrimaryKey(userid)){
            ServletContext context =request.getSession().getServletContext();
            context.setAttribute("userTotal",(Integer)context .getAttribute("userTotal")-1);
            JsonT.respJSON(response,true,"删除成功",null);
        }else{
            JsonT.respJSON(response,false,"删除失败",null);
        }
    }

    @RequestMapping("/a/pageUsers")//后台分页查询用户列表
    public void pageusers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pn =ParamT.getInt(request,"page",1);
        Integer ps =ParamT.getInt(request,"limit",10);
        String username = ParamT.getString(request,"username","");
        String userroles = ParamT.getString(request,"userroles","");
        UserExample example =new UserExample();
        if(StringUtils.isNotBlank(username)){
            example.createCriteria().andUsernameLike("%"+username+"%");
        }
        if(StringUtils.isNotBlank(userroles)){
            example.createCriteria().andUserrolesEqualTo(userroles);
        }
        example.setOrderByClause(" createtime desc,username asc ");
        PageInfo<User> pageInfo = userService.queryByPage(pn,ps,example);
        JsonT.layJSON(response,"0","数据获取成功",pageInfo);
    }

    @RequestMapping("/a/edituserphoto")//编辑用户头像
    public void usereditphoto( HttpServletRequest request, HttpServletResponse response) throws IOException {
        String floader ="/upload/";
        String filepath = request.getSession().getServletContext().getRealPath(floader);
        if(!new File(filepath).exists()){ new File(filepath).mkdirs(); }
        List<String> result = new ArrayList<String>();
        MultiValueMap<String, MultipartFile> fMap = null;
        if(request instanceof MultipartHttpServletRequest){
            fMap =((MultipartHttpServletRequest)request).getMultiFileMap();
        }
        if(fMap!=null){
            for(String key: fMap.keySet()){//key==input的name值
                List<MultipartFile> fileList = fMap.get(key);
                for(MultipartFile mFile:fileList){
                    String oldName = mFile.getOriginalFilename();
                    String filename =StrT.genFileName(oldName);
                    try {
                        mFile.transferTo(new File(filepath+ File.separator +filename));
                        User user = (User) request.getSession().getAttribute("loginUser");
                        user.setPhoto(floader+filename);
                        if(userService.updateByPrimaryKeySelective(user)){
                            request.getSession().setAttribute("loginUser",user);
                            JsonT.layJSON(response,"0","修改成功",request.getContextPath()+user.getPhoto());
                        }
                    } catch (IOException e) {
                        result.add(oldName+":上传失败");
                    }
                }
            }
        }else {
            JsonT.layJSON(response,"1","文件不能为空",null);
        }

    }


    /**
     * 帖子管理
     * @param response
     * @param request
     * @throws IOException
     */

    @RequestMapping("/a/pageTopics")
    public void pageTopics(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer pn =ParamT.getInt(request,"page",1);
        Integer ps =ParamT.getInt(request,"limit",10);
        String title = ParamT.getString(request,"title","");
        String username = ParamT.getString(request,"username","");
        String state = ParamT.getString(request,"state","");
        TopicExample example = new TopicExample();
        TopicExample.Criteria criteria =example.createCriteria();
        if(StringUtils.isNotBlank(title)){
            criteria.andTitleLike("%"+title+"%");
        }
        if(StringUtils.isNotBlank(username)){
            criteria.andUsernameLike("%"+username+"%");
        }
        if(StringUtils.isNotBlank(state)){
            criteria.andStateEqualTo(state);
        }
        example.setOrderByClause(" createtime desc,title asc ");
        PageInfo<Topic> pageInfo = topicService.queryByPage(pn,ps,example);
        JsonT.layJSON(response,"0","数据获取成功",pageInfo);
    }

    @RequestMapping("/a/deltopic/{tid}")
    public void atopicdel(@PathVariable int tid,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(topicService.deleteByPrimaryKey(tid)){
            ServletContext context =request.getSession().getServletContext();
            context.setAttribute("circleTotal",(Integer)context .getAttribute("circleTotal")-1);
            JsonT.respJSON(response,true,"删除成功");
        }else{
            JsonT.respJSON(response,false,"删除失败");
        }
    }

    @RequestMapping("/a/getTopic/{tid}")
    public void getTopic(HttpServletResponse response, @PathVariable int tid) throws IOException {
        JsonT.respJSON(response,true,"请求成功",topicService.selectByPrimaryKey(tid));
    }

    @RequestMapping("/a/checkTopic")
    public void checkTopic(HttpServletRequest request,HttpServletResponse response, Topic topic) throws IOException {
        if(topicService.updateByPrimaryKeySelective(topic)){
            ServletContext context =request.getSession().getServletContext();
            context.setAttribute("auditTopicTotal",(Integer)context .getAttribute("auditTopicTotal")-1);
            JsonT.respJSON(response,true,"审核完成");
        }else{
            JsonT.respJSON(response,true,"审核完成");
        }
    }
    /**
     * 公告管理
     * @param response
     * @param id
     * @throws IOException
     */

    @RequestMapping("/a/getNotice/{id}")//获得公告信息
    public void getNotice(HttpServletResponse response, @PathVariable int id) throws IOException {
        JsonT.respJSON(response,true,"请求成功",noticeService.selectByPrimaryKey(id));
    }

    @RequestMapping("/a/delNotice/{id}")//后台删除公告
    public void delNotice(@PathVariable int id,HttpServletResponse response) throws IOException {
        if(noticeService.deleteByPrimaryKey(id)){
            JsonT.respJSON(response,true,"删除成功");
        }else{
            JsonT.respJSON(response,false,"删除失败");
        }
    }

    @RequestMapping("/a/saveNotice")//后台删除公告
    public void updateNotice(Notice notice,HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        notice.setCreatetime(new Date());
        notice.setNoticeUserid(user.getUserid());
        notice.setNoticeUsername(user.getUsername());
        if(notice.getId()!=null&&notice.getId()!=0){
            if(noticeService.updateByPrimaryKey(notice)){
                JsonT.respJSON(response,true,"保存成功");
            }else{
                JsonT.respJSON(response,false,"保存失败");
            }
        }else{
            if(noticeService.insert(notice)){
                JsonT.respJSON(response,true,"保存成功");
            }else{
                JsonT.respJSON(response,false,"保存失败");
            }
        }

    }

    @RequestMapping("/a/pageNotices")//后台管理分页查询
    public void pageNotices(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer pn =ParamT.getInt(request,"page",1);
        Integer ps =ParamT.getInt(request,"limit",10);
        NoticeExample example = new NoticeExample();
        example.setOrderByClause(" createtime desc ");
        PageInfo<Notice> pageInfo = noticeService.queryByPage(pn,ps,example);
        JsonT.layJSON(response,"0","数据获取成功",pageInfo);
    }

    /**
     * 圈子管理
     * @param response
     * @param id
     * @throws IOException
     */

    @RequestMapping("/a/getCircle/{id}")//后台获取圈子信息
    public void getCircle(HttpServletResponse response, @PathVariable int id) throws IOException {
        JsonT.respJSON(response,true,"请求成功",circleService.selectByPrimaryKey(id));
    }

    @RequestMapping("/a/delCircle/{id}")//后台删除圈子
    public void delCircle(@PathVariable int id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(circleService.deleteByPrimaryKey(id)){
            ServletContext context =request.getSession().getServletContext();
            context.setAttribute("circleTotal",(Integer)context .getAttribute("circleTotal")-1);
            JsonT.respJSON(response,true,"删除成功");
        }else{
            JsonT.respJSON(response,false,"删除成功");
        }
//        Circle circle =circleService.selectByPrimaryKey(id);
//        circle.setCircleState("-1");
//        if(circleService.updateByPrimaryKey(circle)){
//            JsonT.respJSON(response,true,"停用成功");
//        }else{
//            JsonT.respJSON(response,false,"停用失败");
//        }
    }

    @RequestMapping("/a/saveCircle")//后台保存圈子信息
    public void saveCircle(Circle circle,HttpServletResponse response) throws IOException {
        if(circle.getId()!=null&&circle.getId()!=0){
            if(circleService.updateByPrimaryKey(circle)){
                JsonT.respJSON(response,true,"保存成功");
            }else{
                JsonT.respJSON(response,false,"保存失败");
            }
        }else{
            if(circleService.insert(circle)){
                JsonT.respJSON(response,true,"保存成功");
            }else{
                JsonT.respJSON(response,false,"保存失败");
            }
        }

    }

    @RequestMapping("/a/pageCircles")//后台管理圈子分页查询
    public void pageCircles(Circle circle, HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer pn =ParamT.getInt(request,"page",1);
        Integer ps =ParamT.getInt(request,"limit",10);
        CircleExample example = new CircleExample();
        CircleExample.Criteria criteria =example.createCriteria();
        if(StringUtils.isNotBlank(circle.getCircleName())){
            criteria.andCircleNameLike("%"+circle.getCircleName()+"%");
        }
        if(StringUtils.isNotBlank(circle.getCircleUsername())){
            criteria.andCircleUsernameLike("%"+circle.getCircleUsername()+"%");
        }
        if(StringUtils.isNotBlank(circle.getCircleState())){
            criteria.andCircleStateEqualTo(circle.getCircleState());
        }
        example.setOrderByClause(" createtime desc ");
        PageInfo<Circle> pageInfo = circleService.queryByPage(pn,ps,example);
        JsonT.layJSON(response,"0","数据获取成功",pageInfo);
    }
    @RequestMapping("/a/checkCircle")
    public void checkCircle(HttpServletRequest request,HttpServletResponse response, Circle circle) throws IOException {
        if(circleService.updateByPrimaryKeySelective(circle)){
            ServletContext context =request.getSession().getServletContext();
            context.setAttribute("auditCircleTotal",(Integer)context .getAttribute("auditCircleTotal")-1);
            JsonT.respJSON(response,true,"审核完成");
        }else{
            JsonT.respJSON(response,true,"审核完成");
        }
    }

}
