<%@ page import="com.wzc.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation" style="background-color: #393D49;box-shadow: 0 1px 4px 0 rgba(0,0,0,0.15);">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/" style="font-size: 21px;">网上朋友圈</a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#index-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="index-collapse" >
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/">公开帖子</a></li>
                <li><a href="${pageContext.request.contextPath}/f/topublish">发表帖子</a></li>
                <li><a href="${pageContext.request.contextPath}/circles">圈子群组</a></li>
                <li><a href="javascript:void(0);" id="searchUserBtn">用户搜索</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <% User user=(User)session.getAttribute("loginUser");
                if(user!=null){%>
                 <li class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${pageContext.request.contextPath}<%=user.getPhoto()%>" class="img-circle" style="width: 31px;height: 31px;margin: -6px 5px;">
                        <%=user.getUsername()%><strong class="caret"></strong></a>
                    <ul class="dropdown-menu" style="min-width: 130px">
                        <%  if(user.getUserroles().equals("admin")){%>
                        <li><a href="${pageContext.request.contextPath}/a/p/index" style="font-size: 14px;line-height: 2.1;">
                            <i class="glyphicon glyphicon-asterisk"></i> 后台管理</a> </li>
                        <%  }else {%>
                        <li><a href="${pageContext.request.contextPath}/f/profile/<%=user.getUserid()%>" style="font-size: 14px;line-height: 2.1;">
                            <i class="glyphicon glyphicon-user"></i> 个人中心</a> </li>
                        <%  }%>
                        <li><a href="javascript:;" id="logoutBtn" style="font-size: 14px;line-height:2.1;">
                            <i class="glyphicon glyphicon-off"></i> 注销登录</a></li>
                    </ul>
                 </li>
                <% }else{%>
                <li><a href="${pageContext.request.contextPath}/toRegister">
                    <i class="glyphicon glyphicon-edit" style="margin-right: 5px;"></i> 注册</a></li>
                <li><a href="${pageContext.request.contextPath}/toLogin">
                    <i class="glyphicon glyphicon-log-in" style="margin-right: 5px;"></i> 登录</a></li>
                <%}%>
            </ul>
        </div>
    </div>
</nav>
<div id="searchUserDiv" style="display: none;">
    <div class="col-sm-12" style="padding: 15px;border-bottom: 1px solid #eee;">
        <div class="input-group" >
            <input type="text" class="form-control" id="searchUser-input" placeholder="邮箱账号/用户名">
            <span class="input-group-btn"><button class="btn btn-primary" id="searchUser-btn" type="submit">搜索</button></span>
        </div>
    </div>
    <%--<div style="border-bottom: 1px solid #eee;padding: 15px 15px 5px;font-size: 15px;" id="sresnum">搜索到0个用户</div>--%>
    <ul class="friendsul" id="searchUserUl"></ul>
</div>
<script type="text/javascript">
    $(function () {
        $(".navbar-right").on("click","#logoutBtn",function () {
            layer.confirm('确定要注销登录？', {btn: ['确定','取消']}, function(){
                window.location.href="${pageContext.request.contextPath}/logout";
            });
        });
        $("#searchUserBtn").click(function () {
            layer.open({type:1,title:"用户搜索",move: false,area:["400px","500px"],content:$("#searchUserDiv")});
        });
        $("#searchUser-btn").click(function () {
            $.post("${pageContext.request.contextPath}/searchUser",{info:$("#searchUser-input").val()},function (data) {
                var conhtml ="<li><p style='text-align: center;'>未搜索到用户</p></li>";
                if(data.data.length>0){
                    conhtml="";
                    for(var i=0;i<data.data.length;i++){
                        var item = data.data[i];
                        conhtml+='<li class="col-sm-12"><div><img src="${pageContext.request.contextPath}/userphoto/'+item.userid+'">' +
                            '<a href="${pageContext.request.contextPath}/f/profile/'+item.userid+'">'+item.username+'</a>' +
                            '<p>'+(item.signature||"这个家伙很懒，没有留下个性签名")+'</p></div></li>';
                    }
                }
                // $("#sresnum").html("搜索到"+data.data.length+"个用户");
                $("#searchUserUl").html(conhtml);
            },"json");
        });
    });

</script>


