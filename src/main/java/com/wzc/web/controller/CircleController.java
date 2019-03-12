package com.wzc.web.controller;

import com.wzc.bean.*;
import com.wzc.service.ICircleService;
import com.wzc.service.IRelationMapService;
import com.wzc.service.ITopicService;
import com.wzc.service.IUserService;
import com.wzc.utils.JsonT;
import com.wzc.utils.StrT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class CircleController {

    @Autowired
    private ICircleService circleService;

    @Autowired
    private IRelationMapService mapService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ITopicService topicService;

    @RequestMapping("/f/circle/{id}")
    public String viewCircle(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response){
        Circle circle = circleService.selectByPrimaryKey(id);

        if(circle!=null){
            boolean isMember = false;
            User loginUser = (User) request.getSession().getAttribute("loginUser");
            List<User> members =userService.selectMembersByCircleId(id);
            for(User user:members){
                if(user.getUserid().equals(loginUser.getUserid())){
                    isMember=true;
                    break;
                }
            }
            if(isMember){
                TopicExample example =new TopicExample();
                example.createCriteria().andCircleidEqualTo(id);
                Integer topicTotal = topicService.countByExample(example);
                request.setAttribute("circle",circle);
                request.setAttribute("circleTopicTotal",topicTotal);
                return "front/circle";
            }else{
                request.setAttribute("error","您不是该圈子成员无法浏览该圈子信息，请先加入。");
                return "front/error";
            }
        }else {
            request.setAttribute("error","该圈子信息不存在或已被删除");
            return "front/error";
        }

    }

    @RequestMapping("/f/addCircle")
    public void addCircle(MultipartFile circlephoto,Circle circle, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        String filename ="";
        if(!circlephoto.isEmpty()) {
            String path = request.getServletContext().getRealPath("/upload/");
            filename = StrT.genFileName(circlephoto.getOriginalFilename());
            File filepath = new File(path,filename);
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            circlephoto.transferTo(new File(path + File.separator + filename));
            circle.setCirclePhoto("/upload/"+filename);
        }
        circle.setCircleUserid(user.getUserid());
        circle.setCircleUsername(user.getUsername());
        circle.setCreatetime(new Date());
        circle.setCircleState("0");
        if(circleService.insert(circle)){
            ServletContext context =request.getSession().getServletContext();
            context.setAttribute("circleTotal",(Integer)context .getAttribute("circleTotal")+1);
            context.setAttribute("auditCircleTotal",(Integer) context.getAttribute("auditCircleTotal")+1);
            RelationMap map = new RelationMap();
            map.setCreatetime(new Date());
            map.setKid(circle.getId());
            map.setVid(user.getUserid());
            map.setType("circle");
            mapService.insert(map);
            JsonT.respJSON(response,true,"创建成功，已提交管理员审核",null);
        }
    }

    @RequestMapping("/f/getMyCircles")
    public void getMyTopics(HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        JsonT.respJSON(response,true,"数据获取成功",circleService.selectByUserId(user.getUserid()));
    }

    @RequestMapping("/f/delCircle/{id}")
    public void delcircle(@PathVariable Integer id, HttpServletResponse response){
        RelationMapExample example =new RelationMapExample();
        example.createCriteria().andKidEqualTo(id).andTypeEqualTo("circle");
        if(circleService.deleteByPrimaryKey(id)&&mapService.deleteByExample(example)>0){
            JsonT.respJSON(response,true,"操作成功");
        }else{
            JsonT.respJSON(response,true,"操作失败");
        }

    }

    @RequestMapping("/f/getCircleInfo/{id}")
    public void getCircleInfo(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response){
        Circle circle = circleService.selectByPrimaryKey(id);
        if(circle!=null){
            JsonT.respJSON(response,true,"获取成功",circle);
        }else{
            JsonT.respJSON(response,false,"未找到该圈子信息");
        }

    }
    @RequestMapping("/f/eidtCircleInfo")
    public void eidtCircleInfo(Circle circle,HttpServletRequest request, HttpServletResponse response){
        circle.setCreatetime(new Date());
        circle.setCircleState("0");
        if(circleService.updateByPrimaryKeySelective(circle)){
            JsonT.respJSON(response,true,"修改成功，已重新提交管理员审核");
        }else{
            JsonT.respJSON(response,false,"修改失败");
        }

    }
}
