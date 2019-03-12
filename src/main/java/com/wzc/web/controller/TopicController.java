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
public class TopicController {

    @Autowired
    private ITopicService topicService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IUploadFileService uploadFileService;


    @RequestMapping("/f/topublish")
    public String publishtopic(HttpServletRequest request, HttpServletResponse response) {
        return "front/publish";
    }

    @RequestMapping("/f/addTopic")
    public void addTheme(HttpServletRequest request, HttpServletResponse response, Topic topic) throws IOException {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        topic.setCreatetime(new Date());
        topic.setState("0");
        topic.setComTotal(0);
        topic.setViewTotal(0);
        topic.setUserid(loginUser.getUserid());
        topic.setUsername(loginUser.getUsername());
        if(topicService.insert(topic)){
            ServletContext context =request.getSession().getServletContext();
            context.setAttribute("topicTotal",(Integer) context.getAttribute("topicTotal")+1);
            context.setAttribute("auditTopicTotal",(Integer) context.getAttribute("auditTopicTotal")+1);
            JsonT.respJSON(response,true,"发布成功，请等待管理员审核。",null);
        }else{
            JsonT.respJSON(response,false,"发布失败，请联系管理员进行反馈",null);
        }
    }

    @RequestMapping("/f/viewTopic/{tid}")
    public String viewTopic(HttpServletRequest request, @PathVariable int tid) throws IOException {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        Topic topic = topicService.selectByPrimaryKey(tid);
        if(topic==null){
            request.setAttribute("error","该帖子不存在，或已被删除！");
            return "front/error";
        }
        boolean isMember=false;
        if(topic.getCircleid()==0){
            isMember =true;
        }else{
            List<User> members =userService.selectMembersByCircleId(topic.getCircleid());
            for(User user:members){
                if(user.getUserid().equals(loginUser.getUserid())){
                    isMember =true;
                    break;
                }
            }
        }
        if(isMember){
            User topicUser = userService.selectByPrimaryKey(topic.getUserid());
            if(topicUser==null){
                topicUser = new User();
                topicUser.setPhoto("/upload/default.png");
                topicUser.setUsername("用户已被删除");
                topicUser.setUserid(0);
            }
            topic.setViewTotal(topic.getViewTotal()+1);
            topicService.updateByPrimaryKey(topic);
            request.setAttribute("topicUser",topicUser);
            request.setAttribute("topic",topic);
            return "front/topic";
        }else{
            request.setAttribute("error","对不起，您没有权限访问该帖子。");
            return "front/terror";
        }
    }

    @RequestMapping("/f/topicdel/{id}")
    public void topicdel(@PathVariable Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(topicService.deleteByPrimaryKey(id)){
            JsonT.respJSON(response,true,"删除成功",null);
        }else{
            JsonT.respJSON(response,false,"删除失败",null);
        }
    }

    @RequestMapping("/f/delComment/{id}")
    public void userdel(@PathVariable Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(commentService.deleteByPrimaryKey(id)){
            JsonT.respJSON(response,true,"删除成功",null);
        }else{
            JsonT.respJSON(response,false,"删除失败",null);
        }
    }

    @RequestMapping("/f/pageCircleTopics/{id}")
    public void fpageTopics(@PathVariable Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer pn =ParamT.getInt(request,"page",1);
        Integer ps =ParamT.getInt(request,"limit",10);
        String keyword = ParamT.getString(request,"keyword","");
        String orderBy = ParamT.getString(request,"orderBy","createtime");
        TopicExample example = new TopicExample();
        TopicExample.Criteria criteria =example.createCriteria();
        criteria.andCircleidEqualTo(id).andStateEqualTo("1");
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

    @RequestMapping("/f/getNewsUpdate/{userid}")
    public void getNewsUpdateByUserId(@PathVariable Integer userid,HttpServletRequest request,HttpServletResponse response) throws IOException {
        TopicExample example = new TopicExample();
        example.createCriteria().andUseridEqualTo(userid).andStateEqualTo("1").andCircleidEqualTo(0);
        example.setOrderByClause(" createtime desc,title asc ");
        PageInfo<Topic> pageInfo = topicService.queryByPage(1,10,example);
        JsonT.respJSON(response,true,"数据获取成功",pageInfo);
    }

    @RequestMapping("/f/getMyTopics")
    public void getMyTopics(HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        TopicExample example = new TopicExample();
        example.createCriteria().andUseridEqualTo(user.getUserid());
        example.setOrderByClause(" createtime desc,title asc ");
        JsonT.respJSON(response,true,"数据获取成功",topicService.selectByExample(example));
    }

    @RequestMapping("/f/getCommentsByTid/{tid}")
    public void getCommentsByTid(@PathVariable Integer tid,HttpServletRequest request,HttpServletResponse response) throws IOException {
        CommentsExample example = new CommentsExample();
        example.createCriteria().andCommentAnnidEqualTo(tid);
        example.setOrderByClause(" createtime asc ");
        JsonT.respJSON(response,true,"数据获取成功",commentService.selectByExample(example));
    }

    @RequestMapping("/f/addComment")
    public void addComment(Comments comment, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        comment.setCommentUserid(user.getUserid());
        comment.setCommentUsername(user.getUsername());
        comment.setCreatetime(new Date());

        if(commentService.insert(comment)){
            Topic topic =topicService.selectByPrimaryKey(comment.getCommentAnnid());
            topic.setComTotal(topic.getComTotal()+1);
            topicService.updateByPrimaryKey(topic);
            JsonT.respJSON(response,true,"回复成功");
        }else{
            JsonT.respJSON(response,true,"回复失败");
        }
    }
    @RequestMapping("/f/uploadTopicphoto")//上传帖子图片
    public void uploadphoto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filepath = request.getSession().getServletContext().getRealPath("/upload/");
        if(!new File(filepath).exists()){ new File(filepath).mkdirs(); }
        List<String> result = new ArrayList<String>();
        MultiValueMap<String, MultipartFile> fMap = null;
        if(request instanceof MultipartHttpServletRequest){
            fMap =((MultipartHttpServletRequest)request).getMultiFileMap();
        }
        if(fMap!=null){
            for(String key: fMap.keySet()){
                List<MultipartFile> fileList = fMap.get(key);
                for(MultipartFile mFile:fileList){
                    String oldName = mFile.getOriginalFilename();
                    String filename =StrT.genFileName(oldName);
                    try {
                        mFile.transferTo(new File(filepath+ File.separator +filename));
//                        UploadFile file = new UploadFile();
//                        file.setCreatetime(new Date());
//                        file.setOriginalname(oldName);
//                        file.setOwnerid(id);
//                        file.setOwnertype("album");
//                        file.setPathname("/upload/"+filename);
//                        uploadFileService.insert(file);
                        result.add(request.getContextPath()+"/upload/"+filename);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        JsonT.respJSON(response,true,"上传成功",result);
    }
}
