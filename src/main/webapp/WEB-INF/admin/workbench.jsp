<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工作台</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lay/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="${pageContext.request.contextPath}/static/lay/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.form.js" charset="UTF-8"></script>
</head>
<body style="height: 100%;overflow: hidden;text-align: center;">
<img src="${pageContext.request.contextPath}/static/common/img/welcome.jpg" style="height: 100%;">
<%--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">--%>
    <%--<legend>卡片面板</legend>--%>
<%--</fieldset>--%>

<%--<div style="padding: 20px; background-color: #F2F2F2;">--%>
    <%--<div class="layui-row layui-col-space15">--%>
        <%--<div class="layui-col-md6">--%>
            <%--<div class="layui-card">--%>
                <%--<div class="layui-card-header">待审核帖子</div>--%>
                <%--<div class="layui-card-body">--%>
                    <%--${applicationScope.auditTopicTotal}--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="layui-col-md6">--%>
            <%--<div class="layui-card">--%>
                <%--<div class="layui-card-header">待审核圈子</div>--%>
                <%--<div class="layui-card-body">--%>
                    <%--${applicationScope.auditCircleTotal}--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="layui-col-md12">--%>
            <%--<div class="layui-card">--%>
                <%--<div class="layui-card-header">标题</div>--%>
                <%--<div class="layui-card-body">--%>
                    <%--内容--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
</body>
</html>
