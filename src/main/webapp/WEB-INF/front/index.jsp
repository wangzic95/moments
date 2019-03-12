<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>网上朋友圈</title>
  <%@include file="link.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<div class="box-body">
  <div class="container" >
    <div class="row clearfix" style="padding-top: 15px;">
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
          <div class="tab-content" >
            <div class="tab-pane active" id="tab_createtime" >
              <ul class="announces"></ul>
              <div id="pages1" class="pages_box"></div>
            </div>
            <div class="tab-pane" id="tab_com_total">
              <ul class="announces"></ul>
              <div id="pages2" class="pages_box"></div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-3 column">

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
        <a href="${pageContext.request.contextPath}/f/topublish" class="btn btn-block btn-primary" style="padding:9px 12px;margin-bottom: 15px;">发表帖子</a>
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title"><i class="glyphicon glyphicon-bullhorn"></i> 网站公告</h3>
          </div>
          <div class="panel-body" style="height: 300px;overflow: auto;">
            <ul class="noticeul"></ul>
          </div>
        </div>
        <%--<div class="panel panel-default">--%>
        <%--<div class="panel-heading"><h3 class="panel-title"><i class="glyphicon glyphicon-link"></i> 友情链接</h3></div>--%>
        <%--<div class="panel-body">--%>
        <%--<ul class="friendLink">--%>
        <%--<li><a href="http://stackoverflow.com/" target="_blank">Stackoverflow</a></li>--%>
        <%--<li><a href="http://www.dzone.com/" target="_blank">DZone</a></li>--%>
        <%--<li><a href="http://leetcode.com/" target="_blank">LeetCode</a></li>--%>
        <%--<li><a href="http://docs.oracle.com/javase/" target="_blank">Java SE技术文档</a></li>--%>
        <%--<li><a href="https://github.com/" target="_blank">Github</a></li>--%>
        <%--<li><a href="https://www.coursera.org" target="_blank">Coursera</a></li>--%>
        <%--<li><a href="http://www.javaworld.com/" target="_blank">Java World</a></li>--%>
        <%--<li><a href="http://www.ibm.com/developerworks/java/" target="_blank">IBM developerWorks</a></li>--%>
        <%--<li><a href="http://en.wikipedia.org/wiki/" target="_blank">Wikipedia 维基百科</a></li>--%>
        <%--<li><a href="https://blog.csdn.net/" target="_blank">CSDN博客</a></li>--%>
        <%--</ul>--%>
        <%--</div>--%>
        <%--</div>--%>
      </div>
    </div>
    <%@include file="footer.jsp" %>
  </div>
</div>
<script type="text/javascript">
  $(function () {
      pageData1();
      pageData2();
      $("#searchBtn").click(function () {
          var href = $("#sorttab>li.active>a").attr("href");
          if(href=="#tab_createtime"){
              pageData1();
          }else{
              pageData2();
          }
      });
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
  });
function pageData1(pn) {
    var ps = 10;
    $.ajax({
        url:"${pageContext.request.contextPath}/pageTopics",
        type:"post",
        data:{page:pn||1,limit:ps,orderBy:"createtime",keyword:$("#keyword").val()},
        dataType:"json",
        success:function (data) {
            var conhtml ="<li><h3 style='text-align: center;'>暂无数据</h3></li>";
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
          url:"${pageContext.request.contextPath}/pageTopics",
          type:"post",
          data:{page:pn||1,limit:ps,orderBy:"com_total",keyword:$("#keyword").val()},
          dataType:"json",
          success:function (data) {
              var conhtml ="<li><h3 style='text-align: center;'>暂无数据</h3></li>";
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
</script>
</body>
</html>
