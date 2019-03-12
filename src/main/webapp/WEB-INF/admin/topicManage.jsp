<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子管理</title>
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
            <label class="layui-form-label">帖子主题</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="find_title" >
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">发帖人：</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="find_username" >
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">审核状态：</label>
            <div class="layui-input-inline">
                <select id="find_state">
                    <option value="" >请选择</option>
                    <option value="0">待审核</option>
                    <option value="1" >审核通过</option>
                    <option value="2" >审核不通过</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <div class="layui-input-inline">
                <button class="layui-btn" id="findBtn">查询帖子</button>
            </div>
        </div>
    </div>
    <table id="demo" lay-filter="test"></table>
</div>
<div class="layui-card" id="topicdetail" style="display: none;">
    <div class="layui-card-header" style="height: auto;"></div>
    <div class="layui-card-body"></div>
</div>
<script type="text/html" id="barDemo">
    {{#  if(d.state ==0){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
    {{#  }else{ }}
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="detail">查看</a>
    {{#  } }}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
    layui.use(['jquery','element', 'table','form','layer'], function(){
        var $ = layui.$,element = layui.element,table= layui.table,form = layui.form;
        table.render({
            elem: '#demo'
            ,id:"topicList"
            ,height: 'full-115'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,url: '${pageContext.request.contextPath}/a/pageTopics' //数据接口
            ,page: {groups: 10} //是否显示分页
            ,cols: [[ //标题栏
                {field: 'tid', title: 'ID', sort: true,width:80}
                ,{field: 'title', title: '帖子主题', sort: true,width:400}
                ,{field: 'username', title: '发贴人' }
                ,{field: 'circleid', title: '展示设置' ,templet: function(d){
                        if(d.circleid===0){
                            return "公开";
                        }else{
                            return "圈内可看";
                        }
                    }}
                ,{field: 'createtime', title: '发帖时间', sort: true}
                ,{field: 'state', title: '帖子状态', sort: true,align:"center",templet: function(d){
                        if(d.state==="1"){
                            return "<span class=\"layui-badge layui-bg-green\">通过</span>";
                        }else if(d.state==="2"){
                            return "<span class=\"layui-badge layui-bg-cyan\">不通过</span>";
                        }else{
                            return "<span class=\"layui-badge\">待审核</span>";
                        }

                    }
                }
                ,{fixed: 'right',title: '操作', align:'center', toolbar: '#barDemo'}
            ]]
            ,done: function(res, curr, count){
                // console.log(res);
            }
        });
        table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if(layEvent === 'del'){ //删除
                layer.confirm('确定要删除吗？', function(index){
                    $.get("${pageContext.request.contextPath}/a/deltopic/"+data.tid,function (res) {
                        res.success&&table.reload("topicList",{});
                        layer.msg(res.message);
                    },"json");
                });
            }
            else if(layEvent==="check"){
                $.get("${pageContext.request.contextPath}/a/getTopic/"+data.tid,function (res) {
                    $("#topicdetail>.layui-card-header").html('<h1 style="padding: 20px;">'+data.title+'</h1>');
                    $("#topicdetail>.layui-card-body").html(res.data.content);
                    layer.open({
                        type: 1
                        ,area: "1000px"
                        ,content: $("#topicdetail")
                        ,btn: ['通过','不通过']
                        ,yes: function(){
                            $.post("${pageContext.request.contextPath}/a/checkTopic",{tid:data.tid,state:"1"},function (res) {
                                res.success&&table.reload("topicList",{});
                                layer.closeAll();
                                layer.msg(res.message);
                            },"json")
                        }
                        ,btn2: function(index, layero){
                            $.post("${pageContext.request.contextPath}/a/checkTopic",{tid:data.tid,state:"2"},function (res) {
                                res.success&&table.reload("topicList",{});
                                layer.msg(res.message);
                            },"json")
                        }
                       });
                },"json");
            }
            else if(layEvent==="detail"){
                $.get("${pageContext.request.contextPath}/a/getTopic/"+data.tid,function (res) {
                    $("#topicdetail>.layui-card-header").html('<h1 style="padding: 20px;">'+data.title+'</h1>');
                    $("#topicdetail>.layui-card-body").html(res.data.content);
                    layer.open({
                        type: 1
                        ,area: "1000px"
                        ,content: $("#topicdetail")
                    });
                },"json");
            }
        });
        $("#findBtn").click(function () {
            table.reload('topicList', {
                method:"post",
                where: {
                    username: $("#find_username").val(),
                    title: $("#find_title").val(),
                    state: $("#find_state").val()
                }
            });
        });
    });
</script>
</body>
</html>
