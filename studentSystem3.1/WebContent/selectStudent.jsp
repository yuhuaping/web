<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>查找页面</title>
	</head>
	<style>
		.a{
			position:fixed;
			background-color:pink;
			width:400px;
			top:20%;
			left:40%;
			margin:0 auto;
			padding-top:20px;
			padding-left:50px;
			color:blue;
		}
		form input{
			margin-left:10px;
		}
		#msg{
			color:red;
			font-size:16px;
		}
		span{
			color:red;
			font-size:13px;
		}
		body{
			width:100%;
			padding-left:42%;
			padding-top:5%;
		}
		b.{
			width:100%;
			padding-top:7%;
			padding-left:42%;
		}
		
		h3{
			width: 100%;
			padding-left:30%;
		}
	</style>

	<body>
		<div class="a">
			<h3>查找学生</h3>
			<form name="form1" action="./showSelectStudent.jsp" method="get"">
				请输入要查找的学生：<input number="user" type="text" name="userNumber" />
				<br/>
				<br/>
				<div class="b">
					<input type="submit" value="查找" />
				</div>
				<span id="msg"></span>
			</form>
		</div>
	</body>
</html>




















