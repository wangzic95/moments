<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基本资料</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lay/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="${pageContext.request.contextPath}/static/lay/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.form.js" charset="UTF-8"></script>
</head>
<body>
<c:set var="luser" value="${sessionScope.loginUser}"/>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li class="layui-this">基本资料</li>
        <li>更改头像</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show" style="padding:10px 50px;">
            <form class="layui-form layui-form-pane" lay-filter="baseForm">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户ID</label>
                    <div class="layui-input-inline">
                        <input type="text" name="userid" disabled class="layui-input" value="${luser.userid}">
                    </div>
                    <div class="layui-form-mid layui-word-aux">不可修改</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">我的角色</label>
                    <div class="layui-input-inline">
                        <select name="userroles" disabled>
                            <option value="user" <c:if test="${luser.userroles eq 'user'}">selected</c:if> >普通用户</option>
                            <option value="admin" <c:if test="${luser.userroles eq 'admin'}">selected</c:if> >系统管理员</option>
                        </select>
                    </div>
                    <div class="layui-form-mid layui-word-aux">不可修改</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="username"  disabled class="layui-input" value="${luser.username}">
                    </div>
                    <div class="layui-form-mid layui-word-aux">不可修改</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户性别</label>
                    <div class="layui-input-inline">
                        <select name="gender">
                            <option value="男" <c:if test="${luser.gender eq '男'}">selected</c:if> >男</option>
                            <option value="女" <c:if test="${luser.gender eq '女'}">selected</c:if> >女</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户生日</label>
                    <div class="layui-input-inline">
                        <input type="text" name="birthday" id="birthdate"  class="layui-input" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${luser.birthday}"/>">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户地址</label>
                    <div class="layui-input-inline">
                        <input type="text" name="address"  class="layui-input" value="${luser.address}">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">个性签名</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" name="signature" class="layui-textarea">${luser.signature}</textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn" lay-submit lay-filter="alertForm">确认修改</button>
                </div>
            </form>
        </div>
        <div class="layui-tab-item" style="padding: 50px;">
            <div class="layui-upload" style="text-align: center;">
                <div class="layui-upload-list">
                    <img class="layui-upload-img" id="imgpreview" src="${pageContext.request.contextPath}${luser.photo}" style="max-width: 200px;max-height: 500px;">
                    <p id="demoText"></p>
                </div>
                <button type="button" class="layui-btn" id="uploadPhoto">上传图片</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    layui.use(['jquery','element','form','layer','laydate','upload'], function(){
        var element = layui.element,form = layui.form,laydate = layui.laydate,$ = layui.jquery,upload = layui.upload;
        laydate.render({
            elem: '#birthdate'
        });
        form.verify({
            equalpass: function (value, item) { //value：表单的值、item：表单的DOM对象
                var passval = $("input[name='password']").val();
                if (value != passval) {
                    return '两次密码输入不同';
                }
            }
        });
        form.on('submit(alertForm)', function(data){
            $.post('${pageContext.request.contextPath}/f/edituserbase',data.field,function(data){layer.msg(data.message);},"json");
            return false;
        });
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#uploadPhoto'
            ,url: '${pageContext.request.contextPath}/a/edituserphoto/'
            ,accept: '.png,.jpg,.jpeg,.gif'
            ,done: function(res){
                if(res.code > 0){//如果上传失败
                    return layer.msg('上传失败');
                }else{
                    $('#imgpreview').attr('src',res.data);
                    return layer.msg('上传成功');
                }
            },error: function(){
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){uploadInst.upload();});
            }
        });
    });
</script>
</body>
</html>
