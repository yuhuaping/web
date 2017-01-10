<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>添加学生</title>
	</head>
	<style>
		.x{
			position:fixed;
			background-color:pink;
			width:350px;
			top:20%;
			left:40%;
			margin:0 auto;
			padding-top:20px;
			padding-left:20px;
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
			padding-left:20%;
		}
	</style>

	<body>
		<div class="x">
			<h3>添加学生</h3>
			<form name="form1" action="./addstudent" method="post" enctype="multipart/form-data" >
				<span style="color:white">头像 :</span>
				<input type="file" id="myfile" name="header_img"/>
				<br>
				学&nbsp;号<input type="text" name="userNumber" />
				<br/>
				姓&nbsp;名<input type="text" name="userName" />
				<br/>
				年&nbsp;龄<input type="text" name="userAge" />
				<br/>
				性&nbsp;别<input type="text" name="userSex" />
				<br/>
				<div class="b">
					<input type="submit" value="添加" />
				</div>
				<span id="msg"></span>
			</form>
		</div>
	</body>
</html>




















