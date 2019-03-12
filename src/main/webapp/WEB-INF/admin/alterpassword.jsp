<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lay/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="${pageContext.request.contextPath}/static/lay/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.form.js" charset="UTF-8"></script>
</head>
<body>
<div class="layui-fluid" style="padding: 50px;">
    <form class="layui-form layui-form-pane" >
        <div class="layui-form-item">
            <label class="layui-form-label">新密码</label>
            <div class="layui-input-block">
                <input type="password" name="password" lay-verify="required" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-block">
                <input type="password" name="confirmpswd"  lay-verify="required|equalpass" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="alertForm">确认修改</button>
            </div>
        </div>
    </form>
</div>


<script type="text/javascript">
    layui.use(['jquery','element','form','layer'], function(){
        var element = layui.element;
        var form = layui.form;
        form.verify({
            equalpass: function (value, item) { //value：表单的值、item：表单的DOM对象
                var passval = $("input[name='password']").val();
                if (value != passval) {
                    return '两次密码输入不同';
                }
            }
        });
        form.on('submit(alertForm)', function(data){
            $.post('${pageContext.request.contextPath}/f/edituserpswd',data.field,function(data){
                if(data.success){
                    layer.msg(data.message);
                }
            },"json");
            return false;
        });
    });
</script>
</body>
</html>
