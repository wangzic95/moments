package com.wzc.web.controller;

import com.wzc.bean.Topic;
import com.wzc.bean.User;
import com.wzc.service.*;
import com.wzc.utils.JsonT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class TestController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ITopicService topicService;

    @Autowired
    private ICircleService circleService;

    @Autowired
    private IAlbumService albumService;

    @Autowired
    private IUploadFileService uploadFileService;

    @RequestMapping("/a/test/addUsers")
    public void addTestUsers(HttpServletResponse response) throws IOException, ParseException {
        User user =new User();
        Random rand = new Random();
        for(int i=0;i<100;i++){
            user.setPassword("123");
            user.setUsername("测试员"+i+"号");
            user.setEmail(rand.nextInt(1000000000) + 100000000+"@qq.com");
            user.setCreatetime(new Date());
            user.setAddress("哈尔滨");
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            user.setBirthday(df.parse("1996/09/09"));
            if(i%2==0){
                user.setGender("男");
            }else{
                user.setGender("女");
            }
            user.setPhoto("http://p1.qzone.la/upload/20150222/yk961fx2.jpg");
            user.setSignature("没有个性签名");
            user.setState("1");
            user.setUserroles("user");
            userService.insert(user);
        }
        response.getWriter().print("insert success");
    }

    @RequestMapping("/a/test/addTopics")
    public void addTestTopics( HttpServletResponse response) throws IOException {
        Topic topic = new Topic();
        for(int i=0;i<500;i++){
            topic.setUserid(100001);
            topic.setUsername("超哥");
            topic.setState((i%2)+"");
            topic.setCreatetime(new Date());
            topic.setCircleid(0);
            topic.setIsRecom("0");
            topic.setTitle("帖子管理功能第"+(1000000+i)+"条测试数据，该数据用于测试使用标题标题");
            topic.setContent("以下是帖子内容内容内容内容内容内容帖子管理功能测试数据帖子管理功能测试数据帖子管理功能测试数据帖子管理功能测试数据帖子管理功能测试数据帖子管理功能测试数据帖子管理功能测试数据帖子管理功能测试数据");
            topicService.insert(topic);
        }
        JsonT.respJSON(response,true,"测试数据批量插入成功！",null);
    }
}
