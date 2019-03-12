<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>注册 - 网上朋友圈</title>
    <%@include file="link.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="box-body">
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column" >
                <div class="page-header">
                    <h3>注册账号 <small>已有账号？<a href="${pageContext.request.contextPath}/toLogin">立即登录</a></small></h3>
                </div>
                <form class="form-horizontal" role="form" id="registForm" action="${pageContext.request.contextPath}/register" method="post" style="padding-top: 30px;" >
                    <div class="form-group">
                        <label class="col-sm-2 control-label">邮箱地址*</label>
                        <div class="col-sm-4">
                            <input type="email" class="form-control" name="email" style="height: 40px;"/>
                        </div>
                        <p class="col-sm-4" style="line-height: 40px;color: #888;">请输入有效的邮箱地址</p>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户昵称*</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="username"  style="height: 40px;"/>
                        </div>
                        <p class="col-sm-4" style="line-height: 40px;color: #888;">请为自己起一个名字来大家认识你</p>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">设置密码*</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" name="password"  style="height: 40px;"/>
                        </div>
                        <p class="col-sm-4" style="line-height: 40px;color: #888;">请为账号设置一个密码</p>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">确认密码*</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" name="confirmpswd"  style="height: 40px;"/>
                        </div>
                        <p class="col-sm-4" style="line-height: 40px;color: #888;">请再次输入该密码</p>
                    </div>
                    <%--<div class="form-group">--%>
                    <%--<label for="verifycode" class="col-sm-2 control-label">验 证 码*</label>--%>
                    <%--<div class="col-sm-4">--%>
                    <%--<input type="text" class="form-control" id="verifycode" />--%>
                    <%--</div>--%>
                    <%--<p for="verifycode" class="col-sm-4" style="line-height: 30px;color: #888;">请输入收到验证码</p>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<div class="col-sm-offset-2 col-sm-10">--%>
                            <%--<div class="checkbox">--%>
                                <%--<label><input type="checkbox" checked />我已阅读并同意<a>《网上朋友圈服务条款》</a></label>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <div class="form-group" style="margin-top: 30px;">
                        <div class="col-sm-offset-2 col-sm-2">
                            <button type="submit" class="btn btn-success btn-lg" >立即注册</button>
                        </div>
                        <div class="col-sm-4" id="reslutInfo"></div>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#registForm').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    username: {
                        validators: {
                            notEmpty: {},
                            stringLength: {min: 3,max: 10},
                            remote: {
                                url: '${pageContext.request.contextPath}/checkUsernameIsExist',
                                message: '该用户昵称已存在'
                            }
                        }
                    },
                    email: {
                        validators: {
                            notEmpty: {},
                            emailAddress: {},
                            remote: {
                                url: '${pageContext.request.contextPath}/checkEmailIsExist',
                                message: '该邮箱已被注册'
                            }
                        }
                    },
                    password: {validators: {notEmpty: {}}},
                    confirmpswd: {validators: {identical: {field: 'password', message: '两次输入的密码不一致。'}}}
                }
            }).on('success.form.bv', function(e) {
                e.preventDefault();
                var $form = $(e.target);
                var bv = $form.data('bootstrapValidator');
                $.post($form.attr('action'), $form.serialize(), function(result) {
                    if(result.success){
                        $("#reslutInfo").html("<h4 style='margin: 0;line-height: 46px;'>注册成功，正在跳转...</h4>");
                        setTimeout(function () {
                            window.location.href="${pageContext.request.contextPath}/f/profile/"+result.data.userid;
                        },2000);
                    }
                }, 'json');
            });
    });

</script>
</body>
</html>
