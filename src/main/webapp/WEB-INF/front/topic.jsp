<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>帖子详情 - 网上朋友圈</title>
    <%@include file="link.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="box-body">
    <div class="container">
        <div class="row clearfix">
            <c:if test="${topic ne null}">
                <div class="col-md-12 column">
                    <ul class="breadcrumb" style="border-radius: 1px;padding:12px 15px;margin: 15px 0;background-color: rgba(248, 249, 250, 0.8);">
                        <li><a href="${pageContext.request.contextPath}/"><i class="glyphicon glyphicon-home"></i></a></li>
                        <li><a href="${pageContext.request.contextPath}/">公开帖子</a></li>
                        <li class="active">${topic.title}</li>
                    </ul>
                </div>
                <div class="col-md-9 column">
                    <div class="panel panel-default">
                        <div class="panel-heading" style="background-color: transparent;border-bottom: none;padding-top: 25px;">
                            <img src="${pageContext.request.contextPath}/userphoto/${topic.userid}" style="width:50px;height: 50px; float: left;margin-right: 15px;" class="img-circle">
                            <div style="margin-left: 65px;">
                                <h3 style="margin-top: 0px;"> ${topic.title}</h3>
                                <p style="color: #999;"><a href="${pageContext.request.contextPath}/f/profile/${topic.userid}">${topic.username}</a>
                                    <cite style="margin:0 5px;"><fmt:formatDate pattern="yyyy-MM-dd HH:ss:mm" value="${topic.createtime}" /></cite>
                                    <i class="glyphicon glyphicon-eye-open"></i> ${topic.viewTotal}
                                </p>
                            </div>
                            <hr style="margin-bottom: 0px;">
                        </div>
                        <div class="panel-body" style="padding:15px 30px;">${topic.content}</div>
                        <div class="panel-footer" style="text-align: right;padding-top: 25px;">
                            <textarea class="form-control" id="commentText" style="height: 100px;" placeholder="请输入回复内容"></textarea>
                            <button type="submit" class="btn btn-success" id="addCommentBtn" style="margin: 15px 0;">添加回复</button>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 style="font-size: 17px;">最新回复(<span id="comNub"></span>)</h4>
                        </div>
                        <div class="panel-body" ><ul class="comments" id="commentsul"></ul></div>
                    </div>
                </div>
                <div class="col-md-3 column">
                    <div class="panel panel-default">
                        <div class="panel-body" style="text-align: center;">
                            <img src="${pageContext.request.contextPath}${topicUser.photo}" class="img-circle" style="width: 80px;height: 80px;">
                            <a style="font-size: 18px;margin: 10px;font-weight: bold;display: block;"
                               href="${pageContext.request.contextPath}/f/profile/${topicUser.userid}">${topicUser.username}</a>
                            <p style="color: #888;font-size: 13px;min-height: 30px;">${topicUser.signature}</p>
                        </div>
                        <%--<div class="panel-footer">--%>
                            <%--<div class="row clearfix" style="font-size: 13px;">--%>
                                <%--<div class="col-md-6" style="text-align: center;"><p style="margin: 0px;">话题数</p><b>19038</b></div>--%>
                                <%--<div class="col-md-6" style="text-align: center;"><p style="margin: 0px;">好友数</p><b>899</b></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="glyphicon glyphicon-star"></i> 作者最近动态</h3>
                        </div>
                        <div class="panel-body" style="min-height: 250px;">
                            <ul class="list-unstyled newsUpdate"></ul>
                        </div>
                        <script type="text/javascript">
                            $(function () {
                                $.get("${pageContext.request.contextPath}/f/getNewsUpdate/${topicUser.userid}",function (data) {
                                    var conhtml ="<li><p style='text-align: center;'>暂无动态</p></li>";
                                    var page = data.data;
                                    if(data.success&&page.size>0){
                                        conhtml="";
                                        var list = data.data.list;
                                        for(var i=0;i<list.length;i++){
                                            var item = list[i];
                                            conhtml+='<li><a href="${pageContext.request.contextPath}/f/viewTopic/'+item.tid+'">'+item.title+'</a></li>';
                                        }
                                    }
                                    $(".newsUpdate").html(conhtml);
                                },"json");
                            });
                        </script>
                    </div>
                </div>
            </c:if>
        </div>
        <%@include file="footer.jsp" %>
    </div>
</div>
<script type="text/javascript">
    var luserid = "${sessionScope.loginUser.userid}";
    var topicUserid = ${topic.userid};
    $(function () {
        getComments();
        $("#addCommentBtn").click(function () {
            var contentText = $("#commentText").val();
            if(contentText&&contentText.trim().length>0){
                $.post("${pageContext.request.contextPath}/f/addComment",{commentBody:contentText,commentAnnid:${topic.tid}},
                    function (data) {
                        if(data.success){
                            $("#commentText").val("");
                            getComments();
                        }
                        layer.msg(data.message);
                    },"json");
            }else{
                layer.msg("回复内容不能为空");
            }

        });
        $("#commentsul").on("click",".btn-link",function () {
            var obj = $(this);
            layer.confirm("确认要删除这条回复？",function () {
                var id =obj.attr("data-cid");
                $.post("${pageContext.request.contextPath}/f/delComment/"+id,function (data) {
                    if(data.success){
                        getComments();
                    }
                    layer.msg(data.message);
                },"json");
            });
        });

    });
    function getComments(){
        $.get("${pageContext.request.contextPath}/f/getCommentsByTid/${topic.tid}",function (res) {
            var conhtml ="<li style='text-align: center;'>暂无回复</li>";
            if(res.success&&res.data.length>0){
                conhtml="";
                for(var i=0;i<res.data.length;i++){
                    var item = res.data[i];
                    var delHTML = '';
                    if(luserid==item.commentUserid||luserid==topicUserid){
                        delHTML = '<button class="btn btn-sm btn-link pull-right" style="color:red;" data-cid="'+item.id+'">删除</button>';
                    }
                    conhtml+='<li><img src="${pageContext.request.contextPath}/userphoto/'+item.commentUserid+'"><div class="comment-header">' +
                        '<a href="${pageContext.request.contextPath}/f/profile/'+item.commentUserid+'">'+item.commentUsername+'</a>' +
                        '<cite>'+item.createtime+'</cite><span>第'+(i+1)+'楼</span>' +delHTML+'</div><div class="comment-body">'+item.commentBody+'</div></li>';
                }
            }
            $("#comNub").html(res.data.length);
            $("#commentsul").html(conhtml);
        },"json");
    }
</script>
</body>
</html>
