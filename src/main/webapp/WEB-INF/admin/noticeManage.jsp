<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告管理</title>
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
    <div class="layui-elem-quote " style="margin-top: 15px;">
        <button class="layui-btn layui-btn-normal" id="addNoticeBtn">发布公告</button>
    </div>
    <table id="demo" lay-filter="test"></table>
</div>
<div id="noticedetail" style="display: none;padding: 50px;">
    <form class="layui-form layui-form-pane" >
        <input type="hidden" name="id"  value="0">
        <div class="layui-form-item">
            <label class="layui-form-label">公告标题</label>
            <div class="layui-input-block">
                <input type="text" name="noticeTitle"  lay-verify="required"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">公告内容</label>
            <div class="layui-input-block">
                <textarea  name="noticeBody" lay-verify="required" placeholder="请输入内容" class="layui-textarea" style="height: 180px;"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <button class="layui-btn" id="saveBtn" lay-submit lay-filter="noticeForm">立即发布</button>
        </div>
    </form>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs " lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger " lay-event="del">删除</a>
</script>
<script type="text/javascript">
    layui.use(['jquery','element', 'table','form','layer'], function(){
        var $ = layui.$,element = layui.element,table= layui.table,form = layui.form;
        table.render({
            elem: '#demo'
            ,id:"noticeList"
            ,height: 'full-115'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,url: '${pageContext.request.contextPath}/a/pageNotices' //数据接口
            ,page: {groups: 10} //是否显示分页
            ,cols: [[ //标题栏
                {field: 'id', title: 'ID', sort: true,width:80}
                ,{field: 'noticeTitle', title: '标题', sort: true,width:400}
                ,{field: 'noticeUsername', title: '发布人' }
                ,{field: 'createtime', title: '发布时间', sort: true}
                ,{fixed: 'right',title: '操作', align:'center', toolbar: '#barDemo'}
            ]]
        });
        table.on('tool(test)', function(obj){
            var trdata = obj.data; //获得当前行数据
            if( obj.event === 'del'){ //删除
                layer.confirm('确定要删除吗？', function(index){
                    $.get("${pageContext.request.contextPath}/a/delNotice/"+trdata.id,function (res) {
                        res.success&&table.reload("noticeList",{});
                        layer.msg(res.message);
                    },"json");
                });
            }
            else if( obj.event==="detail"){
                $("input[name='id']").val(trdata.id);
                $("input[name='noticeTitle']").val(trdata.noticeTitle);
                $("#saveBtn").html("保存更改");
                $.get("${pageContext.request.contextPath}/a/getNotice/"+trdata.id,function (res) {
                    $("textarea[name='noticeBody']").val(res.data.noticeBody);
                },"json");
                layer.open({type: 1,area: "800px",content: $("#noticedetail")});
            }
        });
        $("#addNoticeBtn").click(function () {
            $("input[name='id']").val(0);
            $("#saveBtn").html("立即发布");
            layer.open({type: 1,area: "800px",content: $("#noticedetail")});
        });
        form.on('submit(noticeForm)', function(data){
            $.post('${pageContext.request.contextPath}/a/saveNotice',data.field,function(data){
                if(data.success){
                    layer.close(layer.closeAll());
                    table.reload('noticeList', {});
                }
                layer.msg(data.message);
            },"json");
            return false;
        });
    });
</script>
</body>
</html>
