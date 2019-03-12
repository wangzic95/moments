<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>活跃圈子 - 网上朋友圈</title>
    <%@include file="link.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="box-body">
    <div class="container">
        <div class="row clearfix" style="padding-top: 15px;">
            <div class="col-md-9 column">
                <div class="tabbable" style="border: 1px solid #ddd;border-radius: 4px;background-color: white;">
                    <div style="background: #f1f1f1;height: 45px;">
                        <ul id="sorttab" class="nav nav-tabs col-sm-8" style="padding:4px 0 0 15px;">
                            <c:if test="${sessionScope.loginUser !=null}">
                                <li class="active"><a href="#tab_myCircles" data-toggle="tab">我的圈子</a></li>
                            </c:if>
                            <li class="<c:if test='${sessionScope.loginUser ==null}'>active</c:if>" >
                                <a href="#tab_allCircles" data-toggle="tab" id="sall">所有圈子</a>
                            </li>
                        </ul>
                        <div class="col-sm-4" style="border-bottom: 1px solid #ddd;">
                            <div class="input-group" style="margin: 5px;">
                                <input type="text" class="form-control" id="cname" placeholder="圈子名称">
                                <span class="input-group-btn"><button class="btn btn-default" id="searchBtn" type="button">搜索</button></span>
                            </div>
                        </div>
                    </div>
                    <div class="tab-content" >
                        <c:if test="${sessionScope.loginUser !=null}">
                        <div class="tab-pane active" id="tab_myCircles" >
                            <ul class="circleul"></ul>
                        </div>
                        </c:if>
                        <div class="tab-pane <c:if test='${sessionScope.loginUser ==null}'>active</c:if>" id="tab_allCircles">
                            <ul class="circleul" ></ul>
                            <div id="pages" class="pages_box"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 column">
                <button class="btn btn-block btn-info" id="createCircleBtn" style="padding:9px 12px;margin-bottom: 15px;">创建圈子</button>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <p style="text-indent: 2em;line-height: 24px;">通信行业的发展，使得人们相互通信越来越方便，使用信息交流平台实现朋友之间、朋友圈人群之间的通信交流、共享信息的功能。为了增加人们
                            沟通交流的方式，使人们更好地享受科技发展为交流沟通带来的便利，故开发此网上朋友圈</p>
                        <p>站长邮箱：403466144@qq.com</p>
                        <p>站长博客：<a href="https://blog.csdn.net/qq_24473141" target="_blank">https://blog.csdn.net/qq_24473141</a></p>
                    </div>
                    <div class="panel-footer">
                        <div class="row clearfix" style="font-size: 13px;">
                            <div class="col-xs-4" style="text-align: center;"><p style="margin: 0px;">帖子数</p><b>${applicationScope.topicTotal}</b></div>
                            <div class="col-xs-4" style="text-align: center;"><p style="margin: 0px;">圈子数</p><b>${applicationScope.circleTotal}</b></div>
                            <div class="col-xs-4" style="text-align: center;"><p style="margin: 0px;">用户数</p><b>${applicationScope.userTotal}</b></div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="glyphicon glyphicon-bullhorn"></i> 网站公告</h3>
                    </div>
                    <div class="panel-body" style="height: 300px;overflow: auto;"><ul class="noticeul"></ul></div>
                </div>
            </div>
        </div>
    <%@include file="footer.jsp" %>
    </div>
</div>
<div style="display: none;" id="createCircleDiv">
    <div class="col-sm-12" style="padding-top: 40px;">
        <form class="form-horizontal" role="form" id="circleForm" enctype="multipart/form-data"
              action="${pageContext.request.contextPath}/f/addCircle" method="post" >
            <div class="form-group">
                <label  class="col-sm-2 control-label">圈子名称</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="circleName" />
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">圈子头像</label>
                <div class="col-sm-9">
                    <input type="file" class="form-control" name="circlephoto" accept=".jpeg,.png,.jpg,.gif"/>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">圈子简介</label>
                <div class="col-sm-9">
                    <textarea class="form-control" style="height: 150px;" name="circleDescription"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-success" >确认创建</button>
                </div>
            </div>
        </form>
    </div>
</div>
<div style="display: none;" id="editCircleDiv">
    <div class="col-sm-12" style="padding-top: 40px;">
        <form class="form-horizontal" role="form" id="circleInfo" enctype="multipart/form-data"
              action="${pageContext.request.contextPath}/f/eidtCircleInfo" method="post" >
            <input type="hidden" name="id"  value="">
            <div class="form-group">
                <label  class="col-sm-2 control-label">圈子名称</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="circleName" />
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">圈子头像</label>
                <div class="col-sm-9">
                    <img src="" style="width:70px;height: 70px;" id="showCover">
                    <input type="hidden" name="circlePhoto" value="">
                    <button type="button" class="btn btn-sm btn-info" onclick="uploadCircleCover()">更换头像</button>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">圈子简介</label>
                <div class="col-sm-9">
                    <textarea class="form-control" style="height: 150px;" name="circleDescription"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-success" >确认修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    var myCircleIds = "${sessionScope.myCircleIds}";
    <c:if test='${sessionScope.loginUser !=null}'>
        var loginUserid ="${sessionScope.loginUser.userid}";
        getMyCircles();
    </c:if>
    $(function () {
        pageData();
        getNotice();
        $(".noticeul").on("click","a",function () {
            var nid =$(this).attr("data-nid");
            $.get("${pageContext.request.contextPath}/notice/"+nid,function (res) {
                if(res.success){
                    layer.open({type: 1,title: false,closeBtn: false,area: '400px;',shade: 0.8,btn: ['好的，我知道了'],btnAlign: 'c'
                        ,content: '<div style="padding: 50px; background-color: #393D49; color: #fff; overflow-y: auto;">' +
                        '<h4 style="line-height: 28px;">'+res.data.noticeTitle+'</h4><p style="line-height: 22px;font-weight: 300;">'+res.data.noticeBody+'</p></div>'
                    });
                }

            },"json");
        });
        //搜索圈子
        $("#searchBtn").click(function () {
            $("#sall").click();
            pageData();
        });
        //显示表单
        $("#createCircleBtn").click(function () {
            <c:if test='${sessionScope.loginUser !=null}'>
            layer.open({type:1,title:"创建圈子",area:["600px","450px"],content:$("#createCircleDiv")});
            </c:if>
            <c:if test='${sessionScope.loginUser ==null}'>
            layer.confirm("您还未登录，是否要前往登录？",function () {
                window.location.href="${pageContext.request.contextPath}/toLogin";
            });
            </c:if>
        });
        //创建圈子
        $('#circleForm').bootstrapValidator({fields: {circleName: {validators: {notEmpty: {}}}}}).on('success.form.bv', function(e) {
            e.preventDefault();
            $("#circleForm").ajaxSubmit({
                dataType:"json",
                type:"post",
                success:function (data) {
                    if(data.success){
                        layer.closeAll();
                    }
                    layer.msg(data.message);
                    $("#circleForm").resetForm();
                    $("#circleForm button[type='submit']").attr("disabled",false);
                }
            });
        });

        $('#circleInfo').bootstrapValidator({fields: {circleName: {validators: {notEmpty: {}}}}}).on('success.form.bv', function(e) {
            e.preventDefault();
            $("#circleInfo").ajaxSubmit({
                dataType:"json",
                type:"post",
                success:function (data) {
                    if(data.success){
                        layer.closeAll();
                        getMyCircles();
                    }
                    layer.msg(data.message);
                    $("#circleInfo button[type='submit']").attr("disabled",false);
                }
            });
        });
        //加入圈子
        $("#tab_allCircles").on("click",".btn-success",function () {
            <c:if test='${sessionScope.loginUser ==null}'>
            layer.confirm("您还未登录，是否要前往登录？",function () {
                window.location.href="${pageContext.request.contextPath}/toLogin";
            });
            </c:if>
            <c:if test='${sessionScope.loginUser !=null}'>
            var cid =$(this).attr("data-cid");
            layer.prompt({formType: 2,title: '请输入验证信息',area: ['400px', '230px']}, function(value, index, elem){
                $.post("${pageContext.request.contextPath}/f/circleApply",{tid:cid,verifyMsg:value},function (data) {
                    layer.close(index);
                    layer.msg(data.message);
                },"json");
            });
            </c:if>
        });
        //退出圈子
        $("#tab_myCircles").on("click",".quitCircle",function () {
            var cid =$(this).attr("data-cid");
            layer.confirm("确定要退出该圈子吗？",function () {
                $.post("${pageContext.request.contextPath}/f/delRelation",{kid:cid,vid:loginUserid,type:"circle"},function (data) {
                    layer.msg(data.message);
                    getMyCircles();
                },"json");
            });
        });
        //解散圈子
        $("#tab_myCircles").on("click",".delCircle",function () {
            var cid =$(this).attr("data-cid");
            layer.confirm("确定要删除(解散)该圈子吗？",function () {
                $.post("${pageContext.request.contextPath}/f/delCircle/"+cid,function (data) {
                    layer.msg(data.message);
                    getMyCircles();
                },"json");
            });
        });
        //编辑圈子
        $("#tab_myCircles").on("click",".editCircle",function () {
            var cid =$(this).attr("data-cid");
            layer.open({type:1,title:"创建圈子",area:["600px","450px"],content:$("#editCircleDiv")});
            $.get("${pageContext.request.contextPath}/f/getCircleInfo/"+cid,function (data) {
                if(data.success){
                    var cInfo = data.data;
                    $("#circleInfo input[name='id']").val(cInfo.id);
                    $("#circleInfo input[name='circleName']").val(cInfo.circleName);
                    $("#circleInfo input[name='circlePhoto']").val(cInfo.circlePhoto);
                    $("#showCover").attr("src","${pageContext.request.contextPath}"+cInfo.circlePhoto);
                    $("#circleInfo textarea[name='circleDescription']").val(cInfo.circleDescription);
                }else{
                    $("#editCircleDiv").html("为查询到该圈子信息，请刷新重试");
                }
            },"json");
        });
    });
    function getNotice() {
        $.get("${pageContext.request.contextPath}/getAllNotices",function (res) {
            var noticeHTML="<li style='text-align: center;'>暂无公告信息</li>";
            if(res.data.length>0){
                noticeHTML="";
                for(var i=0;i<res.data.length;i++){
                    var item =res.data[i];
                    noticeHTML+="<li><a href='javascript:;' data-nid='"+item.id+"'>"+item.noticeTitle+"</a></li>";
                }
            }
            $(".noticeul").html(noticeHTML);
        },"json");
    }
    function tips() {
        <c:if test='${sessionScope.loginUser !=null}'>
        layer.msg("你未加入该圈子<br>不能浏览圈子内帖子");
        </c:if>
        <c:if test='${sessionScope.loginUser ==null}'>
        layer.confirm("您还未登录，是否要前往登录？",function () {
            window.location.href="${pageContext.request.contextPath}/toLogin";
        });
        </c:if>
    }
    function pageData(pn) {
        var ps = 20;
        $.ajax({
            url:"${pageContext.request.contextPath}/pagecircles",
            type:"post",
            data:{page:pn||1,limit:ps,cname:$("#cname").val()},
            dataType:"json",
            success:function (data) {
                var conhtml ="<li><p style='text-align: center;'>暂无圈子信息</p></li>";
                if(data.success){
                    var page = data.data;
                    if(page.size>0){
                        var list = data.data.list;
                        conhtml="";
                        for(var i=0;i<list.length;i++){
                            var item = list[i];
                            if(myCircleIds.indexOf("|"+item.id+"|")>-1){
                                conhtml+='<li><img src="${pageContext.request.contextPath}'+item.circlePhoto+'">'+
                                    '<a class="cir-name" href="${pageContext.request.contextPath}/f/circle/'+item.id+'">'+item.circleName+'</a>' +
                                    '<p class="cir-desc">'+item.circleDescription+'</p></li>';
                            }else{
                                conhtml+='<li><img src="${pageContext.request.contextPath}'+item.circlePhoto+'"><button class="btn btn-sm btn-success" data-cid="'+item.id+'">加入圈子</button>'+
                                    '<a class="cir-name" href="javascript:;" onclick="tips()">'+item.circleName+'</a><p class="cir-desc">'+item.circleDescription+'</p></li>';
                            }
                        }
                    }
                    laypage({ cont: ('pages'),pages:page.pages,curr:pn,skin:'#358bf5',jump: function(obj, first) {if(!first){pageData(obj.curr);}}});
                }
                $("#tab_allCircles>ul").html(conhtml);
            }
        })
    }
    function getMyCircles() {
        $.post("${pageContext.request.contextPath}/f/getMyCircles",function (data) {
            var conhtml ="<li><p style='text-align: center;'>暂未加入任何圈子</p></li>";
            if(data.data.length>0){
                conhtml="";
                for(var i=0;i<data.data.length;i++){
                    var item = data.data[i];
                    var btngroup="";
                    if(item.circleState=="1"){
                        btngroup = '<div class="btn-group"><button type="button" class="btn btn-success dropdown-toggle btn-xs" data-toggle="dropdown">活跃中 <span class="caret"></span></button>' +
                            '  <ul class="dropdown-menu pull-right" role="menu"><li><a href="javascript:;" class="quitCircle" data-cid="'+item.id+'">退出圈子</a></li></ul></div>';
                        if(loginUserid==item.circleUserid){
                            btngroup = '<div class="btn-group"><button type="button" class="btn btn-success dropdown-toggle btn-xs" data-toggle="dropdown">活跃中 <span class="caret"></span></button>' +
                                '<ul class="dropdown-menu pull-right" role="menu"><li><a href="javascript:;" class="delCircle" data-cid="'+item.id+'">解散圈子</a></li></ul></div>';
                        }
                        conhtml+='<li><img src="${pageContext.request.contextPath}'+item.circlePhoto+'">'+btngroup+
                            '<a class="cir-name" href="${pageContext.request.contextPath}/f/circle/'+item.id+'">'+item.circleName+'</a>' +
                            '<p class="cir-desc">'+item.circleDescription+'</p></li>';
                    }else {
                        var btn = '<button type="button" class="btn btn-info dropdown-toggle btn-xs" data-toggle="dropdown">审核中 <span class="caret"></span></button>';
                        if(item.circleState=="2"&&loginUserid==item.circleUserid){
                            btn = '<button type="button" class="btn btn-danger dropdown-toggle btn-xs" data-toggle="dropdown">未通过 <span class="caret"></span></button>';
                        }
                        conhtml+='<li><img src="${pageContext.request.contextPath}'+item.circlePhoto+'"><div class="btn-group">' +btn+
                            '<ul class="dropdown-menu pull-right" role="menu"><li><a href="javascript:;" class="editCircle" data-cid="'+item.id+'">修改圈子</a></li>' +
                            '<li><a href="javascript:;" class="delCircle" data-cid="'+item.id+'">删除圈子</a></li></ul></div>'+
                            '<h4 class="cir-name" style="color:#777;" >'+item.circleName+'</h4><p class="cir-desc">'+item.circleDescription+'</p></li>';
                    }

                }
            }
            $("#tab_myCircles>ul").html(conhtml);
        },"json");
    }
    function uploadCircleCover() {
        var self = this;
        ($("#UploadCoverInput").length>0)&&$("#UploadCoverInput").remove();
        $('body').append('<input type="file" id="UploadCoverInput" style="display: none;" accept=".jpg,.png,.jpeg,.gif" />');
        $("#UploadCoverInput").click();
        $("#UploadCoverInput").change(function () {
            var fData = new FormData();
            var upfiles = $('#UploadCoverInput')[0].files;
            if(upfiles.length>0){
                fData.append("albumCover",upfiles[0]);
                $.ajax({
                    url: "${pageContext.request.contextPath}/f/uploadAlbumCover/",
                    type: 'POST',
                    data: fData,
                    dataType:"json",
                    contentType: false,
                    processData: false,
                    success: function(data){
                        if(data.success){
                            $("#showCover").attr("src","${pageContext.request.contextPath}/"+data.data);
                            $("#circleInfo input[name='circlePhoto']").val(data.data);
                        }else{
                            layer.msg("选择图片时出现了错误，请重新选择");
                        }
                    }
                });
            }
        });
    }
</script>
</body>
</html>
