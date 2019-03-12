<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${user.username}的主页 - 网上朋友圈</title>
    <%@include file="link.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="box-body">
    <div class="container" >
        <div class="row clearfix">
            <div class="col-sm-offset-1 col-sm-10" style="padding: 30px 15px;">
                <div class="col-sm-2">
                    <img src="${pageContext.request.contextPath}${user.photo}" class="img-thumbnail" style="width: 100%;margin-top: 20px;">
                </div>
                <div class="col-sm-10">
                    <h2 style="margin-right: 15px;display: inline-block;">${user.username}</h2>
                    <c:if test="${isFriend==false}">
                        <button class="btn btn-success pull-right" id="addFriendBtn" style="width: 150px;margin-top: 20px;"><i class="glyphicon glyphicon-plus"></i> 加为好友</button>
                    </c:if>
                    <c:if test="${isFriend}">
                        <button class="btn btn-danger pull-right" id="delFriendBtn" style="width: 150px;margin-top: 20px;">解除好友关系</button>
                    </c:if>
                    <h4 style="font-size: 17px;margin: 20px 0;"><b>性别：</b>${user.gender} | <b>出生日期：</b><fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday}"/> | <b>地址：</b>${user.address}</h4>
                    <h5 style="line-height: 25px;"><b>个性签名：</b>${user.signature}</h5>
                </div>
            </div>
            <div class="col-sm-offset-1 col-sm-10">
                <div class="page-header"><h4>Ta的留言板</h4></div>
                <ul class="comments"></ul>
                <div class="panel-footer" style="padding-top: 25px;background-color: white;border: none;">
                    <textarea class="form-control" id="leaveBody" style="height: 100px;" placeholder="请输入留言内容"></textarea>
                    <button type="submit" class="btn btn-success" id="addLeavesBtn" style="margin: 15px 0;">给Ta留言</button>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </div>
</div>
<script type="text/javascript">
    var tid = "${user.userid}";
    var loginUserid ="${sessionScope.loginUser.userid}";
    $(function () {
        getMyLeaves();
        $("#addLeavesBtn").click(function () {
           var body = $("#leaveBody").val();
            $.post("${pageContext.request.contextPath}/f/leaveMessage",{tid:tid,verifyMsg:body},function (res) {
                if(res.success){
                    $("#leaveBody").val("");
                    getMyLeaves();
                }
                layer.msg(res.message);
            },"json");
        });
        $("#addFriendBtn").click(function () {
            var obj =$(this);
            layer.prompt({formType: 2,title: '请输入验证信息',area: ['400px', '230px']}, function(value, index, elem){
                $.post("${pageContext.request.contextPath}/f/friendInvite",{tid:tid,verifyMsg:value},function (data) {
                    layer.close(index);
                    layer.msg(data.message);
                    if(data.success){
                        obj.attr("disabled","disabled");
                    }
                },"json");
            });
        });
        $("#delFriendBtn").click(function () {
            layer.confirm("确定要与Ta解除好友关系吗？",function () {
                $.post("${pageContext.request.contextPath}/f/delRelation",{kid:tid,vid:loginUserid,type:"friend"},function (data) {
                    layer.msg(data.message);
                    if(data.success){
                        window.location.reload();
                    }
                },"json");
            });
        });
    });
    function getMyLeaves() {
        $.post("${pageContext.request.contextPath}/f/getUserLeaves/${user.userid}",function (res) {
            //填充留言消息
            var leavesHTML ="<li><p style='text-align: center;'>暂无留言</p></li>";
            if(res.data.length>0){
                leavesHTML="";
                for(var a=0;a<res.data.length;a++){
                    var item = res.data[a];
                    leavesHTML+='<li><img src="${pageContext.request.contextPath}/userphoto/'+item.fromid+'"><div class="comment-header">' +
                        '<a href="${pageContext.request.contextPath}/f/profile/'+item.fromid+'">'+item.fromname+'</a>' +
                        '<cite>'+item.createtime.toLocaleString()+'</cite></div><div class="comment-body">'+item.msgbody+'</div></li>';
                }
            }
            $(".comments").html(leavesHTML);
        },"json");
    }
</script>
</body>
</html>
