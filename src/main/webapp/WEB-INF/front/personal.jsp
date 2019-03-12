<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心 - 网上朋友圈</title>
    <%@include file="link.jsp" %>
    <style type="text/css">
        #profile .nav-tabs>li>a,
        #myAlbums .nav-tabs>li>a,
        #myCircles .nav-tabs>li>a,
        #myMessages .nav-tabs>li>a{border: none;border-bottom: 3px solid transparent;}
        #profile .nav-tabs>li.active>a,
        #myAlbums .nav-tabs>li.active>a,
        #myCircles .nav-tabs>li.active>a,
        #myMessages .nav-tabs>li.active>a{border: none;border-bottom: 3px solid #009688;}
        .form-control{height: 40px;}
    </style>
</head>
<body>
<%@include file="header.jsp" %>
<div class="box-body">
    <div class="container">
        <div class="row clearfix" style="height: 625px;">
            <div class="col-md-12 column">
                <ul class="breadcrumb" style="border-radius: 1px;padding:12px 15px;margin: 15px 0;background-color: rgba(248, 249, 250, 0.8);">
                    <li><a href="${pageContext.request.contextPath}/"><i class="glyphicon glyphicon-home"></i></a></li>
                    <li class="active">个人中心</li>
                </ul>
            </div>
            <div class="col-sm-2 column" style="height: 550px;">
                <ul class="wzc-menu-list">
                    <li data-content="profile" class="active" ><i class="glyphicon glyphicon-user"></i> 账号设置</li>
                    <li data-content="myAlbums"><i class="glyphicon glyphicon-picture"></i> 我的相册</li>
                    <li data-content="myTopics"><i class="glyphicon glyphicon-leaf"></i> 我的帖子</li>
                    <li data-content="myFriends"><i class="glyphicon glyphicon-tower"></i> 我的好友</li>
                    <li data-content="myMessages"><i class="glyphicon glyphicon-bell"></i> 消息通知</li>
                </ul>
            </div>
            <div class="col-sm-10 column" style="height: 550px;">
                <div class="col-sm-12 content-card active" id="profile" >
                    <div class="tabbable" style="margin: 10px">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#editfile" data-toggle="tab">修改资料</a></li>
                            <li><a href="#editphoto" data-toggle="tab">修改头像</a></li>
                            <li><a href="#editpswd" data-toggle="tab">修改密码</a></li>
                        </ul>
                        <div class="tab-content" style="padding-top: 50px;">
                            <div class="tab-pane active" id="editfile">
                                <form class="form-horizontal" role="form" id="baseForm" action="${pageContext.request.contextPath}/f/edituserbase">
                                    <div class="form-group">
                                        <label  class="col-xs-2 control-label">性别</label>
                                        <div class="col-xs-6">
                                            <select class="form-control" name="gender" >
                                                <option value="男" <c:if  test="${user.gender eq '男'}">selected</c:if> >男</option>
                                                <option value="女" <c:if  test="${user.gender eq '女'}">selected</c:if> >女</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-xs-2 control-label">出生日期</label>
                                        <div class="col-xs-6">
                                            <input type="text" class="form-control" name="birthday" id="birthdate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday}"/>"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-xs-2 control-label">所在地</label>
                                        <div class="col-xs-6">
                                            <input type="text" class="form-control" name="address" value="${user.address}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-xs-2 control-label">个性签名</label>
                                        <div class="col-xs-6">
                                            <textarea class="form-control" name="signature" style="min-height: 120px;">${user.signature}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-offset-2 col-xs-10">
                                            <button type="submit" class="btn btn-success">确认修改</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane" id="editphoto">
                                <div class="col-xs-offset-2 col-xs-3" style="text-align: center;">
                                    <img src="${pageContext.request.contextPath}${user.photo}" class="img-circle" style="width: 100%;" id="userphotopreview">
                                    <button type="button" class="btn btn-success btn-lg" style="margin: 25px 0;" id="editPhotoBtn">
                                        <i class="glyphicon glyphicon-cloud-upload"></i>上传头像</button>
                                </div>
                            </div>
                            <div class="tab-pane" id="editpswd">
                                <form class="form-horizontal" role="form" id="pswdForm" action="${pageContext.request.contextPath}/f/edituserpswd">
                                    <div class="form-group">
                                        <label class="col-xs-2 control-label">新密码</label>
                                        <div class="col-xs-6">
                                            <input type="text" class="form-control" name="password" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-xs-2 control-label">确认密码</label>
                                        <div class="col-xs-6">
                                            <input type="text" class="form-control" name="confirmpswd" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-offset-2 col-xs-6">
                                            <button type="submit" class="btn btn-success">确认修改</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 content-card" id="myAlbums">
                    <div class="tabbable" style="margin: 10px;">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#albums" data-toggle="tab" id="allAlbums">全部相册</a></li>
                            <li><a href="#addAlbum" data-toggle="tab">创建相册</a></li>
                        </ul>
                        <div class="tab-content" style="height: 485px;overflow-y: auto;">
                            <div class="tab-pane active" id="albums"></div>
                            <div class="tab-pane" id="addAlbum">
                                <div class="col-sm-12" style="padding-top: 40px;">
                                    <form class="form-horizontal" role="form" id="albumForm" enctype="multipart/form-data"
                                          action="${pageContext.request.contextPath}/f/addAlbum" method="post" >
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label">相册名称</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="albumName" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-2 control-label">选择封面</label>
                                            <div class="col-sm-6">
                                                <input type="file" class="form-control" name="photofile" accept=".jpeg,.png,.jpg,.gif"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-6">
                                                <button type="submit" class="btn btn-success" id="addAlbumBtn">确认创建</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 content-card" id="myTopics">
                    <ul class="announces"></ul>
                </div>
                <div class="col-sm-12 content-card" id="myFriends" style="padding-top: 20px;">
                    <div class="page-header" style="margin: 0;padding:0 15px;">
                        <h4>全部好友 <small id="fnum">（0）</small></h4>
                    </div>
                    <ul class="friendsul" id="myFriendUl"></ul>
                </div>
                <div class="col-sm-12 content-card" id="myMessages">
                    <div class="tabbable" style="margin: 10px;">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#leaveMsg" data-toggle="tab">留言消息</a></li>
                            <li><a href="#inviteMsg" data-toggle="tab">请求消息</a></li>
                        </ul>
                        <div class="tab-content" style="padding-top: 15px;height: 485px;overflow-y: auto;padding-right: 5px;">
                            <div class="tab-pane active" id="leaveMsg" >
                                <ul class="comments"></ul>
                            </div>
                            <div class="tab-pane" id="inviteMsg">
                                <ul class="inviteul"></ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </div>
</div>
<ul class="contextmenu" id="contextmenu-photo" data-url=""><li data-act="delete">删除</li></ul>
<ul class="contextmenu" id="contextmenu-album" data-aid=""><li data-act="edit">修改</li><li data-act="delete">删除</li></ul>
<div id="editAlbumDiv" style="display: none;">
    <div class="col-sm-12" style="padding-top: 30px;">
        <form class="form-horizontal" role="form" id="albumEditForm" >
            <input type="hidden" id="albumId">
            <div class="form-group">
                <label  class="col-sm-2 control-label">相册名称</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="albumName" />
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">封面展示</label>
                <div class="col-sm-6">
                    <img src="${pageContext.request.contextPath}/upload/avatar.jpg" style="width:100%;height: 150px;" id="showCover">
                    <input type="hidden" id="coverpath" value="">
                </div>
                <div class="col-sm-3" style="padding-top: 120px;">
                    <button type="button" class="btn btn-sm btn-info" onclick="uploadAlbumCover()">更换封面</button>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" class="btn btn-success" id="editAlbumBtn">确认修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    var loginUserid = "${user.userid}";
    $(function () {
        getMyAlbums();
        getMyTopics();
        getMyMessages();
        getMyFiends();
        //菜单点击事件
        $(".wzc-menu-list").on("click","li",function () {
            var index = $(this).index();
            $(this).addClass("active").siblings().removeClass("active");
            $(".content-card").eq(index).addClass("active").siblings().removeClass("active");
        });
        laydate.render({elem: '#birthdate'});
        //修改基本资料
        $('#baseForm').bootstrapValidator({}).on('success.form.bv', function(e) {
            e.preventDefault();
            var $form = $(e.target);
            var bv = $form.data('bootstrapValidator');
            $.post($form.attr('action'), $form.serialize(), function(result) {
                layer.msg(result.message);
                $("#baseForm button[type='submit']").attr("disabled",false);
            }, 'json');
        });
        //修改密码
        $('#pswdForm').bootstrapValidator({
            fields: {
                password: {validators: {notEmpty: {}}},
                confirmpswd: {validators: {identical: {field: 'password', message: '两次输入的密码不一致。'}}}
            }
        }).on('success.form.bv', function(e) {
            e.preventDefault();
            var $form = $(e.target);
            var bv = $form.data('bootstrapValidator');
            $.post($form.attr('action'), $form.serialize(), function(result) {
                layer.msg(result.message);
                $("#pswdForm button[type='submit']").attr("disabled",false);
            }, 'json');
        });
        //更改头像
        $("#editPhotoBtn").click(function (e) {
            uploadFile("${pageContext.request.contextPath}/f/edituserphoto",".jpg,.png,.jpeg,.gif",function (result) {
                layer.msg(result.message);
                if(result.success){
                    $("#userphotopreview").attr("src",result.data);
                }
                $("#editPhotoBtn").attr("disabled",false);
            });
        });
        //创建相册
        $("#addAlbumBtn").click(function (e) {
            e.preventDefault();
            $("#albumForm").ajaxSubmit({
                dataType:"json",
                type:"post",
                success:function (data) {
                    layer.msg(data.message);
                    if(data.success){
                        getMyAlbums();
                        $("#allAlbums").eq(0).click();
                    }
                },
                error:function () {layer.msg("网络错误！"); }
            });
        });
        //修改相册
        $("#editAlbumBtn").click(function (e) {
            $.post("${pageContext.request.contextPath}/f/editAlbum",
                {id:$("#albumId").val(), albumName:$("#albumName").val(),albumCover:$("#coverpath").val() },
                function (data) {
                layer.closeAll();
                layer.msg(data.message);
                getMyAlbums();
            },"json");
        });
        //展示相册
        $("#albums").on("click",".album",function () {
            var id =$(this).attr("data-aid");
            showAlubm(id);
        });
        //右键相册事件
        $("#albums").on("contextmenu",".album",function(e){
            var id = $(this).attr("data-aid");
            $("#contextmenu-album").attr("data-aid",id);
            return rightMenuEvent(e,$("#contextmenu-album"));
        });

        //删除或编辑相册
        $("#contextmenu-album").on("click","li",function () {
            var aid = $(this).parent().attr("data-aid");
            var act = $(this).attr("data-act");
            if(act=="delete"){
                $.post("${pageContext.request.contextPath}/f/delAlbum/"+aid,function (data) {
                    layer.msg(data.message);
                    getMyAlbums();
                },"json");
            }else if(act=="edit"){
                layer.open({type:1,title:"修改相册",area:["600px","450px"],content:$("#editAlbumDiv")});
                $.get("${pageContext.request.contextPath}/f/getAlbum/"+aid,function (data) {
                    if(data.data){
                        var info = data.data;
                        $("#albumId").val(info.id);
                        $("#albumName").val(info.albumName);
                        $("#coverpath").val(info.albumCover);
                        $("#showCover").attr("src","${pageContext.request.contextPath}"+info.albumCover);
                    }else{
                        layer.msg("未获取到相册信息，请刷新后重试");
                    }
                },"json");
            }

        });
        //右键图片事件
        $("#albums").on("contextmenu",".albumphoto",function(e){
            var id = $(this).attr("data-aid");
            $("#contextmenu-photo").attr("data-url","/f/delUpFile/"+id);
            return rightMenuEvent(e,$("#contextmenu-photo"));
        });
        //删除照片
        $("#contextmenu-photo").on("click","li",function () {
            var url = $(this).parent().attr("data-url");
            var act = $(this).attr("data-act");
            if(act=="delete"){
                $.post("${pageContext.request.contextPath}"+url,function (data) {
                    layer.msg(data.message);
                    showAlubm(data.data);
                },"json");
            }
        });
        //预览图片
        $("#albums").on("click",".albumphoto",function(e){
            var src = $(this).find("img").attr("src");
            if($(".img-view").length===0){
                $("body").append('<div class="img-view"><img src="" ></div>');
            }
            $(".img-view>img").attr("src",src);
            layer.open({type: 1,title: false,skin: 'layui-layer-nobg',closeBtn: 0,shadeClose: true,content: $(".img-view")});
        });
        //删除帖子
        $("#myTopics").on("click",".dela",function () {
            if(confirm("确认要删除此话题？")){
                var id = $(this).attr("data-tid");
                $.post("${pageContext.request.contextPath}/f/topicdel/"+id,function (data) {
                    if(data.success){
                        getMyTopics();
                    }
                    layer.msg(data.message);
                },"json");
            }
        });
        //处理验证申请
        $("#inviteMsg").on("click","button",function () {
            var data = $(this).attr("data-res");
            var id = data.split(":")[0];
            var res = data.split(":")[1];
            var pobj =$(this).parent();
            $.post("${pageContext.request.contextPath}/f/handlerResult",{id:id,res:res},function (data) {
                layer.msg(data.message);
                if(res=="agree"){
                    pobj.html("您已同意该请求");
                }else{
                    pobj.html("您已拒绝该请求");
                }
            },"json");
        });
        $("#leaveMsg>ul").on("click","span",function () {
           var mid = $(this).attr("data-mid");
            $.post("${pageContext.request.contextPath}/f/delMessage/"+mid,function (data) {
                layer.msg(data.message);
                getMyMessages();
            },"json");
        });
        //取消右键事件
        $(document).click(function(){$(".contextmenu").hide();});
    });
    function getMyTopics() {
        $.post("${pageContext.request.contextPath}/f/getMyTopics",function (data) {
            var conhtml ="<li><p style='text-align: center;'>暂无数据</p></li>";
            if(data.data.length>0){
                conhtml="";
                for(var i=0;i<data.data.length;i++){
                    var item = data.data[i];
                    var delHTML = '';
                    conhtml+='<li><img src="${pageContext.request.contextPath}/userphoto/'+item.userid+'">' +
                        '<a href="${pageContext.request.contextPath}/f/viewTopic/'+item.tid+'">'+item.title+'</a>' +
                        '<p>发帖人：<a href="${pageContext.request.contextPath}/f/profile/'+item.userid+'">'+item.username+'</a>' +
                        '时间：<i>'+item.createtime+'</i>浏览量：<i>'+(item.viewTotal||0)+'</i>评论：<i>'+(item.comTotal||0)+'</i>' +
                        '<a href="javascript:;" class="dela" style="color:red;float:right;" data-tid="'+item.tid+'">删除</a></p></li>';
                }
            }
            $("#myTopics").find(".announces").html(conhtml);
        },"json");
    }
    function getMyFiends() {
        $.post("${pageContext.request.contextPath}/f/getMyFriends",function (data) {
            var conhtml ="<li><p style='text-align: center;'>暂无好友</p></li>";
            if(data.data.length>0){
                conhtml="";
                for(var i=0;i<data.data.length;i++){
                    var item = data.data[i];
                    conhtml+='<li class="col-sm-4"><div><img src="${pageContext.request.contextPath}/userphoto/'+item.userid+'">' +
                        '<a href="${pageContext.request.contextPath}/f/profile/'+item.userid+'">'+item.username+'</a>' +
                        '<p>'+(item.signature||"这个家伙很懒，没有留下个性签名")+'</p></div></li>';
                }
            }
            $("#fnum").html("（"+data.data.length+"）");
            $("#myFriendUl").html(conhtml);
        },"json");
    }
    function getMyMessages() {
        $.post("${pageContext.request.contextPath}/f/getMyMessages",function (res) {
            //填充留言消息
            var leaves =res.data.leaves;
            var leavesHTML ="<li><p style='text-align: center;'>暂无留言</p></li>";
            if(leaves.length>0){
                leavesHTML="";
                for(var a=0;a<leaves.length;a++){
                    var item = leaves[a];
                    leavesHTML+='<li><img src="${pageContext.request.contextPath}/userphoto/'+item.fromid+'"><div class="comment-header">' +
                        '<a href="${pageContext.request.contextPath}/f/profile/'+item.fromid+'">'+item.fromname+'</a>' +
                        '<cite>'+item.createtime.toLocaleString()+'</cite><span data-mid="'+item.id+'" style="font-size:12px;cursor: pointer;color:red;">删除</span></div><div class="comment-body">'+item.msgbody+'</div></li>';
                }
            }
            $("#leaveMsg>ul").html(leavesHTML);

            //填充验证申请消息
            var invites =res.data.invites;
            var invitesHTML ="<li><p style='text-align: center;'>暂无请求消息</p></li>";
            if(invites.length>0){
                invitesHTML="";
                for(var b=0;b<invites.length;b++){
                    var item = invites[b];
                    var result="";
                    if(item.fromid==loginUserid){
                        if(item.result=="agree"){
                            result="对方同意了该请求";
                        }else if(item.result=="refuse"){
                            result="对方拒绝了该请求";
                        }else{
                            result='正在等待对方答复';
                        }
                        if(item.msgtype=="circleInvite"){
                            var cid = item.msgextras.split(":")[0];
                            var cname = item.msgextras.split(":")[1];
                            invitesHTML+='<li><span>'+result+'</span><div>您邀请了 <a href="${pageContext.request.contextPath}/f/profile/'+item.targetid+'">'
                                +item.targetname+'</a> 加入圈子 <a href="${pageContext.request.contextPath}/f/circle/'+cid+'">'+cname+'</a></div><p>验证信息：'+item.msgbody+'</p></li>';
                        }else if(item.msgtype=="circleApply"){
                            var cid = item.msgextras.split(":")[0];
                            var cname = item.msgextras.split(":")[1];
                            invitesHTML+='<li><span>'+result+'</span><div>您申请加入圈子 <a href="${pageContext.request.contextPath}/f/circle/'+cid+'">'
                                +cname+'</a></div><p>验证信息：'+item.msgbody+'</p></li>';
                        }else if(item.msgtype=="friendInvite"){
                            invitesHTML+='<li><span>'+result+'</span><div>您申请添加 <a href="${pageContext.request.contextPath}/f/profile/'+item.targetid+'">'
                                +item.targetname+'</a> 为好友</div><p>验证信息：'+item.msgbody+'</p></li>';
                        }
                    }else{
                        if(item.result=="agree"){
                            result="您已同意了该请求";
                        }else if(item.result=="refuse"){
                            result="您已拒绝了该请求";
                        }else{
                            result='<button class="btn btn-sm btn-success" data-res="'+item.id+':agree">同意</button>' +
                                '<button class="btn btn-sm btn-danger" data-res="'+item.id+':refuse">拒绝</button>';
                        }
                        if(item.msgtype=="circleInvite"){
                            var cid = item.msgextras.split(":")[0];
                            var cname = item.msgextras.split(":")[1];
                            invitesHTML+='<li><span>'+result+'</span><div><a href="${pageContext.request.contextPath}/f/profile/'+item.fromid+'">'
                                +item.fromname+'</a> 邀请您加入圈子 <a href="${pageContext.request.contextPath}/f/circle/'+cid+'">'+cname+'</a></div><p>验证信息：'+item.msgbody+'</p></li>';
                        }else if(item.msgtype=="circleApply"){
                            var cid = item.msgextras.split(":")[0];
                            var cname = item.msgextras.split(":")[1];
                            invitesHTML+='<li><span>'+result+'</span><div><a href="${pageContext.request.contextPath}/f/profile/'+item.fromid+'">'
                                +item.fromname+'</a> 希望加入您的圈子 <a href="${pageContext.request.contextPath}/f/circle/'+cid+'">'+cname+'</a></div><p>验证信息：'+item.msgbody+'</p></li>';
                        }else if(item.msgtype=="friendInvite"){
                            invitesHTML+='<li><span>'+result+'</span><div><a href="${pageContext.request.contextPath}/f/profile/'+item.fromid+'">'
                                +item.fromname+'</a> 希望添加您为好友</div><p>验证信息：'+item.msgbody+'</p></li>';
                        }
                    }
                }
            }
            $("#inviteMsg>ul").html(invitesHTML);
        },"json");
    }
    function getMyAlbums() {
        $.get("${pageContext.request.contextPath}/f/getMyAlbums",function (res) {
            var conhtml ="<h5 style='text-align: center;'>暂无数据</h5>";
            if(res.success&&res.data.length>0){
                conhtml="";
                for(var i=0;i<res.data.length;i++){
                    var item = res.data[i];
                    conhtml+='<div class="col-xs-3"><a href="javascript:;" data-aid='+item.id+' class="album" ><img src="${pageContext.request.contextPath}'+item.albumCover+'" ><div>'+item.albumName+'</div></a></div>';
                }
            }
            $("#albums").html(conhtml);
        },"json");
    }
    function showAlubm(id) {
        $.get("${pageContext.request.contextPath}/f/showAlbum/"+id,function (res) {
            var conhtml ="<div class='col-sm-12 menubar'><a href='javascript:getMyAlbums();'><i class='glyphicon glyphicon-chevron-left'></i> 返回上一级</a>" +
                "<button class='btn btn-success btn-sm pull-right' onclick='uploadPhoto(\""+id+"\")' ><i class='glyphicon glyphicon-cloud-upload'></i> 上传图片</button></div>";
            if(res.success&&res.data.length>0){
                for(var i=0;i<res.data.length;i++){
                    var item = res.data[i];
                    conhtml+='<div class="col-xs-3"><a href="javascript:;" data-aid='+item.id+' class="albumphoto"><img src="${pageContext.request.contextPath}'+item.pathname+'" ></a></div>';
                }
            }
            $("#albums").html(conhtml);
        },"json");
    }
    function uploadPhoto(id) {
        var self = this;
        ($("#tempFileUploadInput").length>0)&&$("#tempFileUploadInput").remove();
        $('body').append('<input type="file" id="tempFileUploadInput" style="display: none;" multiple accept=".jpg,.png,.jpeg,.gif" />');
        $("#tempFileUploadInput").click();
        $("#tempFileUploadInput").change(function () {
            var fData = new FormData();
            var upfiles = $('#tempFileUploadInput')[0].files;
            if(upfiles.length>0){
                for(var i=0;i<upfiles.length;i++){fData.append("file"+i,upfiles[i]);}
                $.ajax({
                    url: "${pageContext.request.contextPath}/f/uploadAlbumphoto/"+id,
                    type: 'POST',
                    data: fData,
                    dataType:"json",
                    contentType: false,
                    processData: false,
                    success: function(data){
                        showAlubm(id);
                    }
                });
            }
        });
    }
    function uploadAlbumCover() {
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
                            $("#coverpath").val(data.data);
                        }else{
                            layer.msg("选择图片时出现了错误，请重新选择");
                        }
                    }
                });
            }
        });
    }
    function uploadFile(upurl,ftype,success) {
        var self = this;
        ($("#tempFileUploadInput").length>0)&&$("#tempFileUploadInput").remove();
        $('body').append('<input type="file" id="tempFileUploadInput" style="display: none;" accept="'+ftype+'">');
        $("#tempFileUploadInput").click();
        $("#tempFileUploadInput").change(function () {
            var fData = new FormData();
            var upfiles = $('#tempFileUploadInput')[0].files;
            if(upfiles.length>0){
                fData.append("photofile",upfiles[0]);
                // for(var i=0;i<upfiles.length;i++){fData.append("file"+i,upfiles[i]);}
                $.ajax({url: upurl, type: 'POST', data: fData, dataType:"json", contentType: false, processData: false,success: success});
            }
        });
    }
    function rightMenuEvent(e,menu) {
        var winWidth = $(document).width();
        var winHeight = $(document).height();
        var posX = e.pageX;
        var posY = e.pageY;
        var menuWidth = menu.width();
        var menuHeight = menu.height();
        var secMargin = 10,posLeft,posTop;
        if(posX + menuWidth + secMargin >= winWidth  && posY + menuHeight + secMargin >= winHeight){
            posLeft = posX - menuWidth - secMargin + "px";
            posTop = posY - menuHeight - secMargin + "px";
        }else if(posX + menuWidth + secMargin >= winWidth){
            posLeft = posX - menuWidth - secMargin + "px";
            posTop = posY + secMargin + "px";
        }else if(posY + menuHeight + secMargin >= winHeight){
            posLeft = posX + secMargin + "px";
            posTop = posY - menuHeight - secMargin + "px";
        }else {
            posLeft = posX + secMargin + "px";
            posTop = posY + secMargin + "px";
        }
        $(".contextmenu").hide();
        menu.css({"left": posLeft, "top": posTop}).show();
        return false;
    }
</script>
</body>
</html>
