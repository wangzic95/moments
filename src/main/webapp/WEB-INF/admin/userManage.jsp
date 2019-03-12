<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lay/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="${pageContext.request.contextPath}/static/lay/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.form.js" charset="UTF-8"></script>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-elem-quote layui-form" style="margin-top: 15px;">
        <div class="layui-inline">
            <label class="layui-form-label">用户昵称</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="find_username" >
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">角色类型：</label>
            <div class="layui-input-inline">
                <select id="find_role">
                    <option value="" >请选择</option>
                    <option value="user">普通用户</option>
                    <option value="admin" >系统管理员</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <div class="layui-input-inline">
                <button class="layui-btn" id="findBtn">查询用户</button>
                <button class="layui-btn layui-btn-normal" id="addUserBtn">添加用户</button>
            </div>
        </div>
    </div>
    <table id="demo" lay-filter="test"></table>
</div>
<div id="userdetail" style="display: none;padding: 50px;">
    <form class="layui-form layui-form-pane" >
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱账号</label>
            <div class="layui-input-inline">
                <input type="email" name="email"  lay-verify="required|remoteEmail"  autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">请输入正确的邮箱地址</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户昵称</label>
            <div class="layui-input-inline">
                <input type="text" name="username"  lay-verify="required|remoteusername"  autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">请为该账号设置一个名称</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">设置密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">请为该账号设置一个密码</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-inline">
                <input type="password" name="confirmpswd"  lay-verify="required|equalpass"  autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">请再次输入该密码</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户角色</label>
            <div class="layui-input-inline">
                <select name="userroles" >
                    <option value="user">普通用户</option>
                    <option value="admin" >系统管理员</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="userForm">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script type="text/html" id="photoTpl">
    <img src="${pageContext.request.contextPath}{{d.photo}}" style="height: 70px;width: 70px;border-radius: 5px;" >
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
    layui.use(['jquery','element', 'table','form','layer'], function(){
        var $ = layui.$,element = layui.element,table= layui.table,form = layui.form;
        table.render({
            elem: '#demo'
            ,id:"userList"
            ,height: 'full-115'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,url: '${pageContext.request.contextPath}/a/pageUsers' //数据接口
            ,page: {groups: 10} //是否显示分页
            ,cols: [[ //标题栏
                {field: 'userid', title: 'ID', sort: true,width:80}
                ,{field: 'email', title: '邮箱账号', sort: true}
                ,{field: 'username', title: '用户昵称' }
                ,{field: 'password', title: '用户密码' ,width:130}
                ,{field: 'gender', title: '性别', sort: true,width:80}
                ,{field: 'address', title: '地址',width:120}
                ,{field: 'userroles', title: '用户角色', sort: true,width:100,templet: function(d){
                        return (d.userroles==="admin")?"系统管理员":"普通用户";
                    }}
                ,{field: 'createtime', title: '创建时间', sort: true,width:180}
                ,{fixed: 'right',title: '操作', width:100, align:'center', toolbar: '#barDemo'}
            ]]
        });
        table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if(layEvent === 'del'){ //删除
                layer.confirm('确定要删除吗？', function(index){
                    layer.close(index);
                    $.ajax({
                        type: "POST",
                        url: "${pageContext.request.contextPath}/a/delUser",
                        dataType:"json",
                        data: {userid:data.userid},
                        success: function(res){
                            res.success&&table.reload('userList', {});
                            layer.msg(res.message);
                        }
                    });
                });
            }
        });
        form.verify({
            equalpass: function(value, item){ //value：表单的值、item：表单的DOM对象
                var passval =$("#userdetail input[name='password']").val();
                if(value!=passval){
                    return '两次密码输入不同';
                }
            }
            ,remoteusername: function(value, item){ //value：表单的值、item：表单的DOM对象
                var isExist =true;
                $.ajax({
                    url:"${pageContext.request.contextPath}/checkUsernameIsExist",
                    data:{username:value},
                    dataType:"json",
                    async:false,
                    success:function (data) {
                        isExist=data.valid;
                    }
                });
                if(!isExist){
                    return '用户名已存在';
                }
            }
            ,remoteEmail: function(value, item){ //value：表单的值、item：表单的DOM对象
                var isExist =true;
                $.ajax({
                    url:"${pageContext.request.contextPath}/checkEmailIsExist",
                    data:{email:value},
                    dataType:"json",
                    async:false,
                    success:function (data) {
                        isExist=data.valid;
                    }
                });
                if(!isExist){
                    return '该邮箱已被注册';
                }
            }
        });
        form.on('submit(userForm)', function(data){
            $.post('${pageContext.request.contextPath}/a/addUser',data.field,function(data){
                if(data.success){
                    layer.close(layer.closeAll());
                    table.reload('userList', {});
                }
                layer.msg(data.message);
            },"json");
            return false;
        });
        $("#findBtn").click(function () {
            table.reload('userList', {method:"post", where: {username: $("#find_username").val(), userroles: $("#find_role").val()}});
        });
        $("#addUserBtn").click(function () {
            layer.open({ type: 1,area: "700px",content: $("#userdetail")});
        });
    });
</script>
</body>
</html>
