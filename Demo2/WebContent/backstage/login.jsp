<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <c:set var="ctx" value="${pageContext.request.contextPath}" scope="application"/>
    <!DOCTYPE html>
<html>
<head>
<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<meta charset="utf-8"/>
<title>后台登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="../static/css/styles.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="../static/js/jquery.js"></script>
<script src="../static/js/verificationNumbers.js"></script>
<script src="../static/js/Particleground.js"></script>
</head>
<body>
<dl class="admin_login">
 <dt>
  <strong>手表商城后台管理系统</strong>
  <em>Management System</em>
 </dt>
 <form action="${ctx}/adminlogin.do" method="post">
 <dd class="user_icon">
  <input type="text" class="login_txtbx" name="username"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password"  class="login_txtbx" name="password"/>
 </dd>
 <dd>
  <input type="submit" value="立即登陆" class="submit_btn"/>
 </dd>
 </form>
 <dd>
  <p>© 2015-2016 DeathGhost 版权所有</p>
  <p>陕B2-20080224-1</p>
 </dd>
</dl>
</body>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
   lineColor: '#5cbdaa'
  });
</script>
</html>
 