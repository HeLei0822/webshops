<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}" scope="application"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="../static/css/styles.css" />
<script src="../static/js/jquery.js"></script>
<script src="../static/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>
	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
</script>
</head>
<body>
<!--header-->
<header>
 <h1><img src="../static/images/admin_logo.png"/></h1>
 <ul class="rt_nav">
  <li><a href="http://www.aspku.com/" target="_blank" class="website_icon">站点首页</a></li>
  <li><a href="#" class="admin_icon">DeathGhost</a></li>
  <li><a href="#" class="set_icon">账号设置</a></li>
  <li><a href="login.php" class="quit_icon">退出登录</a></li>
 </ul>
</header>

<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="${ctx}/backstage/adminWatchs.jsp">起始页</a></h2>
 <ul>
  <li>
   <dl>
    <dt>商品信息</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="#" class="active">商品列表</a></dd>
    <dd><a href="BookType.jsp">商品分类</a></dd>
    <dd><a href="#">商品属性</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>订单信息</dt>
    <dd><a href="${ctx}/adminorderlist">订单列表</a></dd>
    <dd><a href="#">添加订单</a></dd>
    <dd><a href="#">缺货登记</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>会员管理</dt>
    <dd><a href="#">会员列表</a></dd>
    <dd><a href="#">添加会员</a></dd>
    <dd><a href="#">会员等级</a></dd>
    <dd><a href="#">资金管理</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>基础设置</dt>
    <dd><a href="#">站点基础设置</a></dd>
    <dd><a href="#">SEO设置</a></dd>
    <dd><a href="#">SQL语句查询</a></dd>
    <dd><a href="#">模板管理</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>配送与支付设置</dt>
    <dd><a href="#">配送方式</a></dd>
    <dd><a href="#">支付方式</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>在线统计</dt>
    <dd><a href="#">流量统计</a></dd>
    <dd><a href="#">销售额统计</a></dd>
   </dl>
  </li>
  <li>
   <p class="btm_infor">© 望唐集团 版权所有</p>
  </li>
 </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
    
      <!-- <h2><strong style="color:grey;">页面标题及表格/分页（根据具体情况列入重点，切勿放置可扩展内容不定的数据）</strong></h2> -->
      <div class="page_title">
       <h2 class="fl">产品详情</h2>
      <!--   <a class="fr top_rt_btn">右侧按钮</a>-->
      </div>
      <table class="table">
       <tr>
        <th>标号</th>
        <th>商品</th>
        <th>类型</th>
        <th>图片</th>
        <th>价格</th>
        <th>描述</th>
        <th colspan="3">操作</th>
       </tr>
       <c:forEach items="${adminWatch}" var="watch">
       <tr>
        
            	<td>${watch.id}</td>
                <td>${watch.name}</td>
				<td>${watch.watchId.watchName}</td>          
				<td><img href="${watch.listimg}" width="75" height="100">${watch.listimg}</td>        
				<td>${watch.unitPrice}</td>       
				<td>${watch.introduce}</td>    
				
				<td><a href="${ctx}/adminWatchDelete?id=${watch.id}">删除</a></td>
				<td><a href="${ctx}/adminFindById?id=${watch.id}">修改</a></td>
        </tr>
        </c:forEach>
        <tr><td colsan="5"><a href="${ctx}/admin/addWatchs.jsp">增加</a></td></tr>
        <tr><td colspan="7">
			<a href="${ctx}/page/showAll.do?pageNo=${page.topPageNo}">首页</a>&nbsp;&nbsp;&nbsp;
	        <c:if test="${page.pageNo != 1}">
			<a href="${ctx}/page/showAll.do?pageNo=${page.previousPageNo}">上一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
		    <c:if test="${page.pageNo != pagetotalPages}">
			<a href="${ctx}/page/showAll.do?pageNo=${page.nextPageNo}">下一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<a href="${ctx}/page/showAll.do?pageNo=${page.bottomPageNo}">尾页</a>
		</td>
		</tr>
     <script>
     $(document).ready(function(){
		 //tab
		 $(".admin_tab li a").click(function(){
		  var liindex = $(".admin_tab li a").index(this);
		  $(this).addClass("active").parent().siblings().find("a").removeClass("active");
		  $(".admin_tab_cont").eq(liindex).fadeIn(150).siblings(".admin_tab_cont").hide();
		 });
		 });
 </div>
</section>

</body>
</html>