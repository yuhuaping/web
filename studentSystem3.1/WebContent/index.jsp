<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>后台管理中心</title>
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<script  src="js/jquery.js"></script>
  </head>
  
  <body>
			<body style="background-color: #f2f9fd;">
		<div class="header bg-main">
			<div class="logo margin-big-left fadein-top">
				<h1>
					<img src="images/y.jpg" class="radius-circle rotate-hover"
						height="50" alt="" />
					后台管理中心
				</h1>
			</div>
			<div class="head-l">
				<a class="button button-little bg-blue" href="login.jsp"><span
					class="icon-power-off"></span> 退出登录</a>
				<span>在线人数：<span style=color:yellow;size:+2em><%=application.getAttribute("userCounts") %></span></span>
			</div>
		</div>
		<div class="leftnav">
			<div class="leftnav-title">
				<strong><span class="icon-list"></span>菜单列表</strong>
			</div>
			<h2>
				<span class="icon-user"></span>基本操作
			</h2>
			<ul style="display: block">
				<li>
					<a href="info.jsp" target="right"><span
						class="icon-caret-right"></span>操作员管理</a>
				</li>
				<li>
					<a href="info.jsp" target="right"><span
						class="icon-caret-right"></span>修改密码</a>
				</li>

			</ul>
			<h2>
				<span class="icon-pencil-square-o"></span>学生管理
			</h2>
			<ul>
				<li>
					<a href="./showStudent.jsp" target="right"><span
						class="icon-caret-right"></span>学生列表</a>
				</li>
				<li>
					<a href="./addStudent.jsp" target="right"><span
						class="icon-caret-right"></span>添加学生</a>
				</li>
				<li>
					<a href="./selectStudent.jsp" target="right"><span
						class="icon-caret-right"></span>查找学生</a>
				</li>
			</ul>


		</div>
		<script type="text/javascript">
	$(function() {
		$(".leftnav h2").click(function() {
			$(this).next().slideToggle(200);
			$(this).toggleClass("on");
		})
		$(".leftnav ul li a").click(function() {
			$("#a_leader_txt").text($(this).text());
			$(".leftnav ul li a").removeClass("on");
			$(this).addClass("on");
		})
	});
</script>
		<ul class="bread">
			<li>
				<a href="info.jsp" target="right" class="icon-home"> 首页</a>
			</li>
			<li>
				<a href="##" id="a_leader_txt">网站信息</a>
			</li>
		</ul>
		<div class="admin">
			<iframe scrolling="auto" rameborder="0" src="info.jsp" name="right"
				width="100%" height="100%"></iframe>
		</div>

	</body>
  </body>
</html>
