<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网上朋友圈</title>
    <%@include file="link.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="box-body">
    <div class="container" >
        <div style="display: table;width: 100%;">
            <div style="display: table-cell;vertical-align: middle;text-align: center;height:400px;">
                <h3 style="color: #a94442;">${error}</h3>
                <h3><a href="javascript:history.go(-1);"><i class="glyphicon glyphicon-chevron-left"></i> 返回上一页</a></h3>
            </div>
        </div>
    <%@include file="footer.jsp" %>
    </div>
</div>
</body>
</html>
