<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>发表帖子 - 网上朋友圈</title>
    <%@include file="link.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/summernote/summernote.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/summernote/summernote.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/summernote/lang/summernote-zh-CN.min.js" charset="UTF-8"></script>
</head>
<body>
<%@include file="header.jsp" %>
<div class="box-body">
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h3>发表帖子</h3>
                </div>
                <form class="form-horizontal" role="form" id="topicForm" action="${pageContext.request.contextPath}/f/addTopic">
                    <div class="form-group">
                        <label for="topictitle" class="col-sm-2 control-label">帖子标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="topictitle" name="title" style="height: 40px;" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="topicContent"  class="col-sm-2 control-label">帖子内容</label>
                        <div class="col-sm-10">
                            <div class="summernote" id="topicContent"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="topicClassid" class="col-sm-2 control-label">展示设置</label>
                        <div class="col-sm-3">
                            <select class="form-control" id="topicClassid" name="circleid" style="height: 40px;" >
                                <option value="0">公开</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-2">
                            <button type="submit" class="btn btn-primary btn-lg btn-block">发表</button>
                        </div>
                        <div class="col-sm-offset-1 col-sm-4" id="reslutInfo"></div>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        getMyCircles();
        $('.summernote').summernote({height: 300,lang: 'zh-CN',placeholder:'请输入帖子内容...',
            callbacks:{
                onImageUpload: function(files, editor, $editable) {
                    var formData = new FormData();
                    for(f in files){formData.append("file", files[f]);}
                    $.ajax({
                        data: formData,
                        type: "POST",
                        url: "${pageContext.request.contextPath}/f/uploadTopicphoto",
                        cache: false,
                        contentType: false,
                        processData: false,
                        dataType:"json",
                        success: function(data) {
                            var imageUrl =data.data;
                            console.info(imageUrl);
                            for(i in imageUrl){
                                $('.summernote').summernote('insertImage',imageUrl[i]);
                            }
                        },error: function() { console.log("uploadError");}
                    })
                }
            }
        });
        $('#topicForm').bootstrapValidator({
            fields: {
                title: {validators: {notEmpty: {},stringLength: {min: 3,max: 100}}},
                content:{validators: {notEmpty: {},stringLength: {min: 3,max: 4000}}}
            }
        }).on('success.form.bv', function(e) {
            e.preventDefault();
            var $form = $(e.target);
            var bv = $form.data('bootstrapValidator');
            $.post($form.attr('action'),
                {
                    title:$("#topictitle").val(),
                    content:$('.summernote').summernote('code'),
                    circleid:$("#topicClassid").val()
                }, function(result) {
                if(result.success){
                    layer.msg(result.message);
                    $('#topicForm').resetForm();
                    $('.summernote').summernote('code',"");
                }
            }, 'json');
        });
    });
    function getMyCircles() {
        $.post("${pageContext.request.contextPath}/f/getMyCircles",function (data) {
            if(data.data.length>0){
                var conhtml="";
                for(var i=0;i<data.data.length;i++){
                    var item = data.data[i];
                    conhtml+='<option value="'+item.id+'">'+item.circleName+'</option>';
                }
                $("#topicClassid").append(conhtml);
            }
        },"json");
    }
</script>
</body>
</html>
