<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${circle.circleName} - 网上朋友圈</title>
    <%@include file="link.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="box-body">
    <div class="container" >
        <div class="row clearfix">
            <div class="col-md-12 column">
                <ul class="breadcrumb" style="border-radius: 1px;padding:12px 15px;margin: 15px 0;background-color: rgba(248, 249, 250, 0.8);">
                    <li><a href="${pageContext.request.contextPath}/"><i class="glyphicon glyphicon-home"></i></a></li>
                    <li><a href="${pageContext.request.contextPath}/circles">圈子群组</a></li>
                    <li class="active">${circle.circleName}</li>
                </ul>
            </div>
            <div class="col-md-9 column">
                <div class="tabbable" style="border: 1px solid #ddd;border-radius: 4px;background-color: white;">
                    <div style="background: #f1f1f1;height: 45px;">
                        <ul id="sorttab" class="nav nav-tabs col-sm-8" style="padding:4px 0 0 15px;">
                            <li class="active"><a href="#tab_createtime" data-toggle="tab">最新帖子</a></li>
                            <li><a href="#tab_com_total" data-toggle="tab">最热帖子</a></li>
                        </ul>
                        <div class="col-sm-4" style="border-bottom: 1px solid #ddd;">
                            <div class="input-group" style="margin: 5px;">
                                <input type="text" class="form-control" id="keyword" placeholder="关键词">
                                <span class="input-group-btn"><button class="btn btn-default" id="searchBtn" type="button">搜索</button></span>
                            </div>
                        </div>
                    </div>
                    <div class="tab-content">
                        <div class="tab-pane active" id="tab_createtime">
                            <ul class="list-unstyled announces"></ul>
                            <div id="pages1" class="pages_box"></div>
                        </div>
                        <div class="tab-pane" id="tab_com_total">
                            <ul class="list-unstyled announces"></ul>
                            <div id="pages2" class="pages_box"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 column">
                <div class="panel panel-default">
                    <div class="panel-body" style="text-align: center;">
                        <img src="${pageContext.request.contextPath}/${circle.circlePhoto}" class="img-circle" style="width: 80px;height: 80px;">
                        <h4>${circle.circleName}</h4>
                        <p><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${circle.createtime}"/></p>
                        <p style="color: #888;font-size: 13px;">${circle.circleDescription}</p>
                    </div>
                    <div class="panel-footer">
                        <div class="row clearfix" style="font-size: 13px;">
                            <div class="col-md-6" style="text-align: center;"><p style="margin: 0px;">帖子数</p><b>${circleTopicTotal}</b></div>
                            <div class="col-md-6" style="text-align: center;"><p style="margin: 0px;">成员数</p><b id="memberTotal">0</b></div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title" style="display: inline-block;">
                            <i class="glyphicon glyphicon-user"></i> 圈子成员</h3>
                        <c:if test="${circle.circleUserid ==sessionScope.loginUser.userid}">
                            <a href="javascript:;" title="邀请好友" id="inviteFriend" class="glyphicon glyphicon-plus" style="float: right;"></a>
                        </c:if>
                    </div>
                    <div class="panel-body" id="membaersArea">
                        <ul class="membaersul"></ul>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </div>
</div>
<div id="myFriendsDiv" style="display: none;">
    <ul class="friendsul" id="invitFiendul"></ul>
</div>
<script type="text/javascript">
    var circleId ="${circle.id}";
    var circleUserId ="${circle.circleUserid}";
    var loginUserId = "${sessionScope.loginUser.userid}";
    var memberIds ="";
    $(function () {
        $('#membaersArea').slimScroll({ height: '350px' });
        pageData1();
        pageData2();
        getCircleMembers();
        $("#searchBtn").click(function () {
            var href = $("#sorttab>li.active>a").attr("href");
            if(href=="#tab_createtime"){
                pageData1();
            }else{
                pageData2();
            }
        });
        $("#inviteFriend").click(function () {
            layer.open({type:1,title:"邀请好友",move: false,area:["400px","500px"],content:$("#myFriendsDiv")});
            getMyFiends();
        });
        $(".membaersul").on("click","span",function () {
            var uid = $(this).attr("data-uid");
            layer.confirm("确定要从圈子中删除该用户吗？",function () {
                $.post("${pageContext.request.contextPath}/f/delRelation",{kid:circleId,vid:uid,type:"circle"},function (data) {
                    layer.msg(data.message);
                    getCircleMembers();
                },"json");
            });
        });
        $("#invitFiendul").on("click",".invite",function () {
            var tid =$(this).attr("data-uid");
            var obj = $(this);
            $.post("${pageContext.request.contextPath}/f/circleInvite",{tid:tid,cid:circleId},function (data) {
                layer.msg(data.message);
                if(data.success){
                    obj.attr("disabled","disabled");
                    obj.html("已邀请");
                }
            },"json");
        });
    });
    function pageData1(pn) {
        var ps = 10;
        $.ajax({
            url:"${pageContext.request.contextPath}/f/pageCircleTopics/${circle.id}",
            type:"post",
            data:{page:pn||1,limit:ps,orderBy:"createtime",keyword:$("#keyword").val()},
            dataType:"json",
            success:function (data) {
                var conhtml ="<li><p style='text-align: center;'>暂无数据</p></li>";
                if(data.success){
                    var page = data.data;
                    if(page.size>0){
                        var list = data.data.list;
                        conhtml="";
                        for(var i=0;i<list.length;i++){
                            var item = list[i];
                            conhtml+='<li><img src="${pageContext.request.contextPath}/userphoto/'+item.userid+'">' +
                                '<a href="${pageContext.request.contextPath}/f/viewTopic/'+item.tid+'">'+item.title+'</a>' +
                                '<p>发帖人：<a href="${pageContext.request.contextPath}/f/profile/'+item.userid+'">'+item.username+'</a>' +
                                '时间：<i>'+item.createtime+'</i>浏览量：<i>'+(item.viewTotal||0)+'</i>评论：<i>'+(item.comTotal||0)+'</i></p></li>';
                        }
                    }
                    laypage({ cont: ('pages1'),pages:page.pages,curr:pn,skin:'#358bf5',jump: function(obj, first) {if(!first){pageData1(obj.curr);}}});
                }
                $("#tab_createtime").find(".announces").html(conhtml);
            }
        })
    }
    function pageData2(pn) {
        var ps = 10;
        $.ajax({
            url:"${pageContext.request.contextPath}/f/pageCircleTopics/${circle.id}",
            type:"post",
            data:{page:pn||1,limit:ps,orderBy:"com_total",keyword:$("#keyword").val()},
            dataType:"json",
            success:function (data) {
                var conhtml ="<li><p style='text-align: center;'>暂无数据</p></li>";
                if(data.success){
                    var page = data.data;
                    if(page.size>0){
                        var list = data.data.list;
                        conhtml="";
                        for(var i=0;i<list.length;i++){
                            var item = list[i];
                            conhtml+='<li><img src="${pageContext.request.contextPath}/userphoto/'+item.userid+'">' +
                                '<a href="${pageContext.request.contextPath}/f/viewTopic/'+item.tid+'">'+item.title+'</a>' +
                                '<p>发帖人：<a href="${pageContext.request.contextPath}/f/profile/'+item.userid+'">'+item.username+'</a>' +
                                '时间：<i>'+item.createtime+'</i>浏览量：<i>'+(item.viewTotal||0)+'</i>评论：<i>'+(item.comTotal||0)+'</i></p></li>';
                        }
                    }
                    laypage({ cont: ('pages2'),pages:page.pages,curr:pn,skin:'#358bf5',jump: function(obj, first) {if(!first){pageData2(obj.curr);}}});
                }
                $("#tab_com_total").find(".announces").html(conhtml);
            }
        })
    }
    function getMyFiends() {
        $.post("${pageContext.request.contextPath}/f/getMyFriends",function (data) {
            var conhtml ="<li><p style='text-align: center;'>暂无好友</p></li>";
            if(data.data.length>0){
                conhtml="";
                for(var i=0;i<data.data.length;i++){
                    var item = data.data[i];
                    var btn = '<button class="btn btn-xs btn-success pull-right invite" data-uid="'+item.userid+'">邀请加入</button>';
                    if(memberIds.indexOf("|"+item.userid+"|")>-1){
                        btn = '<button class="btn btn-xs btn-success pull-right invite" disabled data-uid="'+item.userid+'">已加入</button>';
                    }
                    conhtml+='<li class="col-sm-12"><div><img src="${pageContext.request.contextPath}/userphoto/'+item.userid+'">' +
                        '<a href="${pageContext.request.contextPath}/f/profile/'+item.userid+'">'+item.username+'</a>' +btn+
                        '<p>'+(item.signature||"这个家伙很懒，没有留下个性签名")+'</p></div></li>';
                }
            }
            $("#fnum").html("（"+data.data.length+"）");
            $("#invitFiendul").html(conhtml);
        },"json");
    }
    function getCircleMembers() {
        $.post("${pageContext.request.contextPath}/f/getCircleMembers/"+circleId,function (data) {
                memberIds =data.message;
                var conhtml="";
                for(var i=0;i<data.data.length;i++){
                    var item = data.data[i];
                    var rig = "";
                    if(circleUserId==item.userid){
                        rig ="<i>创建者</i>";
                    }else {
                        (circleUserId == loginUserId)&&(rig = "<span data-uid='"+item.userid+"'>删除</span>");
                    }
                    conhtml+='<li><img src="${pageContext.request.contextPath}/userphoto/'+item.userid+'">' +rig+
                        '<a href="${pageContext.request.contextPath}/f/profile/'+item.userid+'">'+item.username+'</a></li>'
                }
            $("#memberTotal").html(data.data.length);
            $(".membaersul").html(conhtml);
        },"json");
    }
</script>
</body>
</html>
