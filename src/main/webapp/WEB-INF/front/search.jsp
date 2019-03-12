<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索结果 - 网上朋友圈</title>
    <%@include file="link.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="box-body">
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <ul class="breadcrumb" style="border-radius: 1px;padding:12px 15px;margin: 15px 0;background-color: rgba(248, 249, 250, 0.8);">
                    <li><a href="${pageContext.request.contextPath}/"><i class="glyphicon glyphicon-home"></i></a></li>
                    <li class="active">搜索结果</li>
                </ul>
            </div>
            <div class="col-md-12 column">
                <form action="${pageContext.request.contextPath}/searchWithType" method="post" style="margin-bottom: 15px;">
                    <div class="input-group" >
                        <input type="text" class="form-control" name="keyword" placeholder="关键词 ">
                        <span class="input-group-btn"><button class="btn btn-primary" type="submit">搜索</button></span>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="stype" value="topic" checked > 帖子</label>
                        <label><input type="radio" name="stype" value="circle"> 圈子</label>
                        <label><input type="radio" name="stype" value="user"> 用户</label>
                    </div>
                </form>
            </div>
            <div class="col-md-12 column">
                <div class="panel panel-default">
                    <div class="panel-heading">搜索到250个结果</div>
                    <div class="panel-body">

                    </div>
                    <%--<div class="panel-footer">--%>
                        <%--搜索到250个结果--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </div>
</div>
</body>
</html>
