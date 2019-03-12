<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>圈子管理</title>
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
            <label class="layui-form-label">圈子名称</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="find_title" >
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">创建人：</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="find_username" >
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">圈子状态：</label>
            <div class="layui-input-inline">
                <select id="find_state">
                    <option value="" >请选择</option>
                    <option value="0">待审核</option>
                    <option value="1" >已审核</option>
                    <option value="2" >不通过</option>
                    <%--<option value="-1" >已禁用</option>--%>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <div class="layui-input-inline">
                <button class="layui-btn" id="findBtn">查询</button>
            </div>
        </div>
    </div>
    <table id="demo" lay-filter="test"></table>
</div>
<div id="circleDetail" style="display: none;padding: 30px;">
    <form class="layui-form layui-form-pane" >
        <input type="hidden" name="id"  value="0">
        <div class="layui-form-item">
            <label class="layui-form-label">圈子头像</label>
            <div class="layui-input-block">
                <img src="" style="height: 60px;width: 60px;margin-left: 20px;border-radius: 3px;" id="circlePhoto">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">圈子名称</label>
            <div class="layui-input-block">
                <input type="text" id="circleName"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">圈主</label>
            <div class="layui-input-inline">
                <input type="text" id="creater"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">圈子介绍</label>
            <div class="layui-input-block">
                <textarea  id="description" class="layui-textarea" style="height: 180px;"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">创建时间</label>
            <div class="layui-input-inline">
                <input type="text" id="createtime"  class="layui-input">
            </div>
        </div>
    </form>
</div>
<script type="text/html" id="barDemo">
    {{#  if(!d.circleState|| d.circleState=='0'){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
    {{#  }else{ }}
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="detail">查看</a>
    {{#  } }}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="photoTpl">
    <img src="${pageContext.request.contextPath}{{d.circlePhoto}}" style="height: 70px;width: 70px;border-radius: 5px;" >
</script>
<script type="text/javascript">
    layui.use(['jquery','element', 'table','form','layer'], function(){
        var $ = layui.$,element = layui.element,table= layui.table,form = layui.form;
        table.render({
            elem: '#demo',id:"circleList",height: 'full-115',cellMinWidth: 80 ,page: {groups: 10}
            ,url: '${pageContext.request.contextPath}/a/pageCircles'
            ,cols: [[ //标题栏
                {field: 'id', title: 'ID', sort: true,width:80}
                ,{field: 'circleName', title: '圈子名称', sort: true,width:200}
                ,{field: 'circleUsername', title: '圈主' }
                ,{field: 'circleDescription', title: '圈子描述',width:350 }
                ,{field: 'createtime', title: '创建时间', sort: true}
                ,{field: 'circleState', title: '圈子状态', sort: true,align:"center",templet: function(d){
                        if(!d.circleState||d.circleState==="0"){
                            return "<span class=\"layui-badge\">待审核</span>";
                        }else if(d.circleState==="1"){
                            return "<span class=\"layui-badge layui-bg-green\">已审核</span>";
                        }else if(d.circleState==="2"){
                            return "<span class=\"layui-badge layui-bg-cyan\">不通过</span>";
                        }
                        //else if(d.state==="-1"){
                        //     return "<span class=\"layui-badge layui-bg-gray\">禁用</span>";
                        // }
                    }
                }
                ,{fixed: 'right',title: '操作', align:'center', toolbar: '#barDemo'}
            ]]
        });
        table.on('tool(test)', function(obj){
            var data = obj.data;
            var layEvent = obj.event;
            var tr = obj.tr;
            if(layEvent === 'del'){
                layer.confirm('确定要删除吗？', function(index){
                    $.get("${pageContext.request.contextPath}/a/delCircle/"+data.id,function (res) {
                        res.success&&table.reload("circleList",{});
                        layer.msg(res.message);
                    },"json");
                });
            }
            else if(layEvent==="check"){
                setForm(data);
                layer.open({type: 1,area: "1000px",content: $("#circleDetail"),btn: ['通过','不通过']
                    ,yes: function(){
                        $.post("${pageContext.request.contextPath}/a/checkCircle",{id:data.id,circleState:"1"},function (res) {
                            res.success&&table.reload("circleList",{});
                            layer.closeAll();
                            layer.msg(res.message);
                        },"json")
                    }
                    ,btn2: function(index, layero){
                        $.post("${pageContext.request.contextPath}/a/checkCircle",{id:data.id,circleState:"2"},function (res) {
                            res.success&&table.reload("circleList",{});
                            layer.msg(res.message);
                        },"json")
                    }
                });
            }
            else if(layEvent==="detail"){
                setForm(data);
                layer.open({type: 1,area: "1000px",content: $("#circleDetail")});
            }
        });
        $("#findBtn").click(function () {
            table.reload('circleList', {
                method:"post",
                where: {
                    circleUsername: $("#find_username").val(),
                    circleName: $("#find_title").val(),
                    circleState: $("#find_state").val()
                }
            });
        });
        function setForm(data) {
            $("#circlePhoto").attr("src","${pageContext.request.contextPath}"+data.circlePhoto);
            $("#circleName").val(data.circleName);
            $("#creater").val(data.circleUsername);
            $("#createtime").val(data.createtime);
            $("#description").val(data.circleDescription);
        }
    });
</script>
</body>
</html>
