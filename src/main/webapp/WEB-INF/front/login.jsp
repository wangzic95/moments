<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登录 - 网上朋友圈</title>
    <%@include file="link.jsp" %>
</head>
<body >
<%@include file="header.jsp" %>
<div class="box-body">
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-offset-4 col-md-4 column " id="login" style="padding: 15px 35px;box-shadow:rgb(146, 128, 128) 0px 0px 10px;margin-top: 50px;margin-bottom: 50px;background-color: white;">
                <div class="page-header" style="margin: 10px 0px;border-bottom: #CCC solid 1px;">
                    <h3>欢迎登录 </h3>
                </div>
                <form class="form-horizontal" role="form" id="loginForm" action="${pageContext.request.contextPath}/login">
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="email" class="form-control"  placeholder="请输入邮箱账号" name="email" style="height: 45px;" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="password" class="form-control"  placeholder="请输入密码" name="password" style="height: 45px;" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="captchaCode" placeholder="请输入验证码" style="height: 45px;" >
                        </div>
                        <div class="col-sm-6">
                            <img onclick="this.src='${pageContext.request.contextPath}/kaptcha.jpg?'+Math.random()" src="${pageContext.request.contextPath}/kaptcha.jpg" style="cursor:pointer;width: 98%;height: 45px;" title="刷新验证码">
                        </div>
                    </div>
                    <div class="form-group">
                        <%--<div class="col-sm-6 checkbox" >--%>
                        <%--<label><input type="checkbox" style="width: 18px;height: 18px;margin-top: 1px;"/>记住账号</label>--%>
                        <%--</div>--%>
                        <%--<div class="checkbox col-sm-6">--%>
                            <%--<a href="#">忘记密码？</a>--%>
                        <%--</div>--%>
                        <div class="checkbox col-sm-6">
                            没有账号？<a href="${pageContext.request.contextPath}/toRegister">立即注册</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input class="btn btn-primary" style="width: 100%;height: 45px;" value="登录" id="loginBtn"  type="submit" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12" id="errorInfo" style="color:#a94442;font-size: 13px;font-weight: bold;"></div>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#loginForm').bootstrapValidator({}).on('success.form.bv', function(e) {
            e.preventDefault();
            var email = $("input[name='email']").val();
            var password = $("input[name='password']").val();
            var captchaCode = $("input[name='captchaCode']").val();
            if(!captchaCode){
                $("#errorInfo").html("登陆失败："+"请输入验证码");
                $("#loginBtn").attr("disabled",false);
                return;
            }
            if(email&&password){
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/login",
                    dataType:"json",
                    data: {email:email,password:password,captchaCode:captchaCode},
                    success: function(data){
                        if(data.success){
                            if(data.data&&data.data=="admin"){
                                window.location.href="${pageContext.request.contextPath}/a/p/index";
                            }else{
                                window.location.href="${pageContext.request.contextPath}/";
                            }
                        }else{
                            $("#errorInfo").html("登陆失败："+data.message);
                            $("#loginBtn").attr("disabled",false);
                        }
                    }
                });
            }else{
                $("#errorInfo").html("账号或密码不能为空");
                $("#loginBtn").attr("disabled",false);
            }

        });
    });
</script>
</body>
</html>

