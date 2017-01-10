<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ittx.web.db.StudentDB"%>
<%@ page import="com.ittx.web.db.bean.Student"%>
<% 
	String number=request.getParameter("num");
	Student student=StudentDB.getInstance().findStudentByNumber(Integer.parseInt(number));
%>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改界面</title>
	</head>
	<style>
		.a{
			position:fixed;
			background-color:pink;
			width:250px;
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
		<div class="a">
			<h3>修改学生操作</h3>
			<form name="form1" action="<%=request.getContextPath() %>/updatestudent" method="post" enctype="multipart/form-data">
	      
				<input id="number" type="hidden" name="userNumber" value="<%=student.getNumber()%>"/>
				<br/>
				姓&nbsp;名<input id="name" type="text" name="userName" value="<%=student.getName() %>"/>
				<br/>
				年&nbsp;龄<input id="age" type="text" name="userAge" value="<%=student.getAge() %>" />
				<br/>
				性&nbsp;别<input id="sex" type="text" name="userSex" value="<%=student.isSex()==true?"男":"女"%>"/>
			<img src="<%=student.getHeader()%>" width="60px" height="60px"/> 
			<input type="file" id="myfile" name="header_img"/>
				<br/>
				<div class="b">
					<input type="submit" value="确定" />
				</div>
				<span id="msg"></span>
			</form>
		</div>
	</body>
</html>




















