<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="application"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8"/>
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />

<link rel="stylesheet" type="text/css" href="../static/css/styles.css" />
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
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
  <li><a href="${ctx}/backstage/login.jsp" class="quit_icon">安全退出</a></li>
 </ul>
</header>

<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="${ctx}/backstage/adminWatch.jsp">起始页</a></h2>
 <ul>
  <li>
   <dl>
    <dt>商品信息</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="${ctx}/backstage/adminWatch.jsp">商品列表</a></dd>
    <dd><a href="#"  class="active">商品分类</a></dd>
    <dd><a href="#">商品属性</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>订单信息</dt>
    <dd><a href="${ctx}/AdminOrderServlet">订单列表</a></dd>
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
     <!--开始：以下内容则可删除，仅为素材引用参考
     <h1 style="color:red;font-size:20px;font-weight:bold;text-align:center;">Example/Explanation</h1>
     <p style="color:red;font-size:16px;font-weight:bold;text-align:center;">这里是相关常用性样式预设，具体根据内容版块调整，列表添加字段注意考虑笔记本屏幕显示；<br/>此页面仅为样式参考，程序对接可移除，具体布局根据项目内容而定<br/>注意保留rt_content.parent</p>
     -->
     <!--点击加载
     <script>
     $(document).ready(function(){
		$("#loading").click(function(){
			$(".loading_area").fadeIn();
             $(".loading_area").fadeOut(1500);
			});
		 });
     </script>
     <section class="loading_area">
      <div class="loading_cont">
       <div class="loading_icon"><i></i><i></i><i></i><i></i><i></i></div>
       <div class="loading_txt"><mark>数据正在加载，请稍后！</mark></div>
      </div>
     </section>
     	结束加载-->
     <!--弹出框效果-->
     <!--  <script>
     $(document).ready(function(){
		 //弹出文本性提示框
		 $("#showPopTxt").click(function(){
			 $(".pop_bg").fadeIn();
			 });
		 //弹出：确认按钮
		 $(".trueBtn").click(function(){
			 alert("你点击了确认！");//测试
			 $(".pop_bg").fadeOut();
			 });
		 //弹出：取消或关闭按钮
		 $(".falseBtn").click(function(){
			 alert("你点击了取消/关闭！");//测试
			 $(".pop_bg").fadeOut();
			 });
		 });
     </script>
     <section class="pop_bg">
      <div class="pop_cont">-->
       <!--title-->
       <!-- <h3>弹出提示标题</h3> -->
       <!--content-->
      <!--  <div class="pop_cont_input">
        <ul>
         <li>
          <span>标题</span>
          <input type="text" placeholder="定义提示语..." class="textbox"/>
         </li>
         <li>
          <span class="ttl">城市</span>
          <select class="select">
           <option>选择省份</option>
          </select>
          <select class="select">
           <option>选择城市</option>
          </select>
          <select class="select">
           <option>选择区/县</option>
          </select>
         </li>
         <li>
          <span class="ttl">地址</span>
          <input type="text" placeholder="定义提示语..." class="textbox"/>
         </li>
         <li>
          <span class="ttl">地址</span>
          <textarea class="textarea" style="height:50px;width:80%;"></textarea>
         </li>
        </ul>
       </div>--> 
       <!--以pop_cont_text分界-->
       <!--  <div class="pop_cont_text">
        这里是文字性提示信息！
       </div>
       <!--bottom:operate->button-->
       <!--<div class="btm_btn">
        <input type="button" value="确认" class="input_btn trueBtn"/>
        <input type="button" value="关闭" class="input_btn falseBtn"/>
       </div>
      </div>
     </section>-->
     <!--结束：弹出框效果-->
	<!-- 
     <section>
      <h2><strong style="color:grey;">常用按钮（水平块元素，无区域限制）</strong></h2>
      <a class="link_btn" id="loading">点击加载</a>
      <button class="link_btn" id="showPopTxt">测试弹出框</button>
      <input type="button" value="按钮input" class="link_btn"/>
     </section>
      <section>
      <h2><strong style="color:grey;">表单样式（组合）</strong></h2>
      <input type="text" class="textbox" placeholder="默认宽度..."/>
      <input type="text" class="textbox textbox_295" placeholder="class=295px..."/>
      <input type="text" class="textbox textbox_225" placeholder="class=225px..."/>
      <select class="select">
       <option>下拉菜单</option>
       <option>菜单1</option>
      </select>
      <input type="button" value="组合按钮" class="group_btn"/>
     </section>
     <section> -->
      <!-- <h2><strong style="color:grey;">页面标题及表格/分页（根据具体情况列入重点，切勿放置可扩展内容不定的数据）</strong></h2> -->
      <div class="page_title">
       <h2 class="fl">分类</h2>
      <!--   <a class="fr top_rt_btn">右侧按钮</a>-->
      </div>
     <!--tabStyle-->
     <script>
     $(document).ready(function(){
		 //tab
		 $(".admin_tab li a").click(function(){
		  var liindex = $(".admin_tab li a").index(this);
		  $(this).addClass("active").parent().siblings().find("a").removeClass("active");
		  $(".admin_tab_cont").eq(liindex).fadeIn(150).siblings(".admin_tab_cont").hide();
		 });
		 });
     </script>
     <section>
      <form action="" method="post">
      <table >
      <ul class="admin_tab">
       <li><a class="active">Watch</a></li>
       <li><a>Count</a></li>
       <li><a>State</a></li>
       <li><a>Price</a></li>
       <li><a>Delete</a></li>
      </ul>
      <c:forEach items="${map}" var="map">
		<tr>
		
			<td>《${map.key}》</td>
			<td>${map.value.count}</td>
			<td>${map.value.state}</td>
			<c:set var="pc" value="${map.value.count*map.value.unitPrice}"/>
		    <td><c:out value="$ ${pc}"></c:out></td>
		    <td><a href="${ctx}/admin/adminDeleteOrder?id=${map.value.id}">Delete</a></td>
<%-- 			<td><a href="${ctx}/watch/orderDetail?id=${map.value.id}">查看订单详情</a></td> --%>
		</tr> 
		</c:forEach>
     


		
	
		
	</table>
	
	</form>
      <!--tabCont-->
      <div class="admin_tab_cont" style="display:block;">
      <ul>
        	<c:forEach items="${adminWatch}" var="watch">
            	<li>
                	<dl>
                	<c:if test="${watch.watchId==1}">
                    	<a href="#"><img src="${watch.listimg}" alt="book" height="140" width="110"/></a>
                        <dt>
                        	${watch.name}
                            ${watch.unitPrice}
                            <br/>
 
                        </dt>
                    </c:if>
                    </dl>
                </li>
            	</c:forEach>
            </ul>
      </div>
      <div class="admin_tab_cont">
      <ul>
        	<c:forEach items="${adminWatch}" var="watch">
            	<li>
                	<dl>
                	<c:if test="${watch.watchId==2}">
                    	<a href="#"><img src="${watch.listimg}" alt="book" height="140" width="110"/></a>
                        <dt>
                             ${watch.name}
                             ${watch.unitPrice}
                            <br/>
 
                        </dt>
                    </c:if>
                    </dl>
                </li>
            	</c:forEach>
            </ul></div>
    
     </section>
          
    <!--结束：以下内容则可删除，仅为素材引用参考-->
 </div>
</section>
</body>
</html>
