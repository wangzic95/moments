package com.wzc.web.controller;

import com.wzc.bean.*;
import com.wzc.service.ICircleService;
import com.wzc.service.IMessageService;
import com.wzc.service.IRelationMapService;
import com.wzc.service.IUserService;
import com.wzc.utils.JsonT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ICircleService circleService;

    @Autowired
    private IRelationMapService mapService;

    //好友邀请消息
    @RequestMapping("/f/friendInvite")
    public void friendInvite(Integer tid,String verifyMsg,HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        User invitee =userService.selectByPrimaryKey(tid);
        Message message =new Message();
        message.setCreatetime(new Date());
        message.setFromid(user.getUserid());
        message.setFromname(user.getUsername());
        message.setMsgbody(verifyMsg);
        message.setMsgtype("friendInvite");
        message.setResult("0");
        message.setTargetid(invitee.getUserid());
        message.setTargetname(invitee.getUsername());
        if(messageService.insert(message)){
            JsonT.respJSON(response,true,"发送成功");
        }else{
            JsonT.respJSON(response,false,"发送失败");
        }
    }

    //入群申请消息
    @RequestMapping("/f/circleApply")
    public void circleApply(Integer tid,String verifyMsg,HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        Circle circle =circleService.selectByPrimaryKey(tid);
        User invitee =userService.selectByPrimaryKey(circle.getCircleUserid());
        if(invitee!=null){
            Message message =new Message();
            message.setCreatetime(new Date());
            message.setFromid(user.getUserid());
            message.setFromname(user.getUsername());
            message.setMsgbody(verifyMsg);
            message.setMsgtype("circleApply");
            message.setResult("0");
            message.setTargetid(invitee.getUserid());
            message.setTargetname(invitee.getUsername());
            message.setMsgextras(circle.getId()+":"+circle.getCircleName());
            if(messageService.insert(message)){
                JsonT.respJSON(response,true,"发送成功");
            }else{
                JsonT.respJSON(response,false,"发送失败");
            }
        }else{
            JsonT.respJSON(response,false,"发送失败,圈子群主已被删除，无法加入该圈子。");
        }

    }
    //群主邀请加入消息
    @RequestMapping("/f/circleInvite")
    public void circleInvite(Integer tid,Integer cid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        Circle circle =circleService.selectByPrimaryKey(cid);
        Message message =new Message();
        message.setFromid(user.getUserid());
        message.setFromname(user.getUsername());
        message.setMsgbody("");
        message.setMsgtype("circleInvite");
        message.setResult("0");
        message.setMsgextras(circle.getId()+":"+circle.getCircleName());
        User invitee =userService.selectByPrimaryKey(tid);
        message.setCreatetime(new Date());
        message.setTargetid(invitee.getUserid());
        message.setTargetname(invitee.getUsername());
        if(messageService.insert(message)){
            JsonT.respJSON(response,true,"发送成功");
        }else{
            JsonT.respJSON(response,false,"发送失败");
        }
    }
    //接受结果并处理
    @RequestMapping("/f/handlerResult")
    public void handlerResult(Integer id,String res, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        Message message = messageService.selectByPrimaryKey(id);
        message.setResult(res);//同意 agree; 拒绝 refuse;
        if(messageService.updateByPrimaryKey(message)){
            if(res.equals("agree")){
                RelationMap relation =new RelationMap();
                relation.setCreatetime(new Date());
                String errorResult ="操作失败";
                if(message.getMsgtype().equals("friendInvite")){
                    relation.setType("friend");
                    relation.setKid(message.getFromid());
                    relation.setVid(message.getTargetid());
                    errorResult ="操作失败,您们已经是好友";
                }else if(message.getMsgtype().equals("circleApply")){
                    relation.setType("circle");
                    String cid =message.getMsgextras().split(":")[0];
                    relation.setKid(Integer.parseInt(cid));
                    relation.setVid(message.getFromid());
                    errorResult ="操作失败,对方已是该圈子成员";
                }else if(message.getMsgtype().equals("circleInvite")){
                    relation.setType("circle");
                    String cid =message.getMsgextras().split(":")[0];
                    relation.setKid(Integer.parseInt(cid));
                    relation.setVid(message.getTargetid());
                    errorResult ="操作失败,您已是该圈子成员";
                }
                if(mapService.cheackRelationIsExist(relation.getKid(),relation.getVid(),relation.getType())>0){
                    JsonT.respJSON(response,true,errorResult);
                }else{
                    if(mapService.insert(relation)){
                        JsonT.respJSON(response,true,"处理完成");
                    }else{
                        JsonT.respJSON(response,true,"操作失败");
                    }
                }
            }else{
                JsonT.respJSON(response,true,"处理完成");
            }
        }
    }

    //给别人留言
    @RequestMapping("/f/leaveMessage")//给别人留言
    public void leaveMessage(Integer tid,String verifyMsg,HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        User invitee =userService.selectByPrimaryKey(tid);
        Message message =new Message();
        message.setCreatetime(new Date());
        message.setFromid(user.getUserid());
        message.setFromname(user.getUsername());
        message.setMsgbody(verifyMsg);
        message.setMsgtype("leaveMessage");
        message.setResult("0");
        message.setTargetid(invitee.getUserid());
        message.setTargetname(invitee.getUsername());
        if(messageService.insert(message)){
            JsonT.respJSON(response,true,"留言成功");
        }else{
            JsonT.respJSON(response,false,"留言失败");
        }
    }
    //我的消息
    @RequestMapping("/f/getMyMessages")//获取当前登录人的消息列表
    public void getMyLeaveMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        MessageExample example =new MessageExample();
        example.createCriteria().andMsgtypeEqualTo("leaveMessage").andTargetidEqualTo(user.getUserid());
        example.setOrderByClause(" createtime desc ");
        List<Message> leaves =messageService.selectByExample(example);

        Map<String,List<Message>> myMessages= new HashMap<String,List<Message>>();
        myMessages.put("invites",messageService.selectByUserId(user.getUserid()));
        myMessages.put("leaves",leaves);
        JsonT.respJSON(response,true,"获取成功",myMessages);
    }

    //我的留言
    @RequestMapping("/f/getUserLeaves/{userid}")
    public void getMyLeaves(@PathVariable Integer userid , HttpServletRequest request, HttpServletResponse response) throws IOException {
        MessageExample example =new MessageExample();
        example.createCriteria().andMsgtypeEqualTo("leaveMessage").andTargetidEqualTo(userid);
        example.setOrderByClause(" createtime desc ");
        List<Message> leaves =messageService.selectByExample(example);
        JsonT.respJSON(response,true,"获取成功",leaves);
    }

    //删除留言
    @RequestMapping("/f/delMessage/{id}")
    public void delMessage(@PathVariable Integer id , HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(messageService.deleteByPrimaryKey(id)){
            JsonT.respJSON(response,true,"删除成功");
        }else{
            JsonT.respJSON(response,false,"删除失败");
        }

    }

    //删除好友关系或圈子关系
    @RequestMapping("/f/delRelation")
    public void delRelation(RelationMap map,HttpServletRequest request, HttpServletResponse response) throws IOException {
        RelationMapExample example =new RelationMapExample();
        example.createCriteria().andKidEqualTo(map.getKid()).andVidEqualTo(map.getVid()).andTypeEqualTo(map.getType());
        RelationMapExample example1 =new RelationMapExample();
        example1.createCriteria().andKidEqualTo(map.getVid()).andVidEqualTo(map.getKid()).andTypeEqualTo(map.getType());
        if(mapService.deleteByExample(example)>0||mapService.deleteByExample(example1)>0){
            JsonT.respJSON(response,true,"操作成功");
        }else{
            JsonT.respJSON(response,false,"操作失败");
        }

    }
}
