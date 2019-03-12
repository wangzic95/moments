<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理 - 网上朋友圈</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lay/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="${pageContext.request.contextPath}/static/lay/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.form.js" charset="UTF-8"></script>
    <style type="text/css">
        .pdl50 .layui-nav-item .layui-nav-child a{padding-left: 50px!important;}
        .layadmin-iframe { position: absolute;width: 100%;height: 100%;left: 0;top: 0;right: 0;bottom: 0;}
        .layui-layout-admin .layui-body{bottom: 0;}
    </style>
    <c:set var="user" value="${sessionScope.loginUser}"/>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><h3>后台管理系统</h3></div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;" ><img src="${pageContext.request.contextPath}${user.photo}" class="layui-nav-img">${user.username}</a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/a/p/baseprofile" target="mainIframe">基本资料</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/a/p/alterpassword"  target="mainIframe">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/"><i class="fa fa-home fa-lg"></i> 网站首页</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out fa-lg"></i> 注销登录</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree pdl50"  lay-filter="test">
                <li class="layui-nav-item layui-this">
                    <a href="${pageContext.request.contextPath}/a/p/workbench" target="mainIframe">
                        <i class="fa fa-desktop fa-fw fa-lg"></i> 欢迎使用</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/a/p/noticeManage" target="mainIframe">
                        <i class="fa fa-bullhorn fa-fw fa-lg "></i> 公告管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/a/p/topicManage" target="mainIframe">
                        <i class="fa fa-leaf fa-fw fa-lg "></i> 帖子管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/a/p/circleManage" target="mainIframe">
                        <i class="fa fa-life-ring fa-fw fa-lg "></i> 圈子管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/a/p/userManage" target="mainIframe">
                        <i class="fa fa-users fa-fw fa-lg "></i> 用户管理</a>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:void(0);"><i class="fa fa-cog fa-fw fa-lg"></i> 系统管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/a/p/baseprofile"  target="mainIframe">基本资料</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/a/p/alterpassword"  target="mainIframe">修改密码</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <iframe class="layadmin-iframe" name="mainIframe" frameborder="0" src="${pageContext.request.contextPath}/a/p/workbench"></iframe>
    </div>
    <%--<div class="layui-footer" style="text-align: center;">Copyright©2018届毕业设计®, All Rights Reserved. 网上朋友圈 - 后台管理</div>--%>
</div>
<script type="text/javascript">
    layui.use('element', function(){var element = layui.element;});
</script>
</body>
</html>
