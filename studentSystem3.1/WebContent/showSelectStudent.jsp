<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.ittx.web.db.StudentDB"%>
<%@ page import="com.ittx.web.db.bean.Student"%>
<%
	String number = request.getParameter("userNumber");

	Student student = StudentDB.getInstance().findStudentByNumber(Integer.parseInt(number));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>学生列表</title>
<style>
table {
	width: 500px;
	height: 50px;
	border-collapse: collapse; /*设置表格的边框折叠成一个单一的边框*/
	margin: 0 auto; /*设置表格居中*/
	background-color: white;
}

table,tr,td,th {
	border: 1px solid black; /*边框：大小 实线 颜色*/
	text-align: center; /*表格内容居中*/
	padding: 10px; /*内边距*/
}

th {
	background-color: green;
	color: white;
}

tr:hover {
	background-color: #b0c4de;
	color: white;
}

a {
	text-decoration: none; /*移除鼠标下划线*/
	background-color: #008000;
	padding: 7px;
}

a:link,a:visited {
	display: block; /*行元素->块元素*/
	color: white; /* 未访问链接*/
}

a:hover,a:active { /* 鼠标移动到链接上 */
	color: #FF00FF;
	background-color: #7A991A;
}
</style>
</head>
<body>
	<table>
				<caption><h2>学生信息表</h2></caption>
				<tr>
					<th>学生学号</th>
					<th>学生姓名</th>
					<th>学生年龄</th>
					<th>学生性别</th>
					<th colspan="2">操作</th>
				</tr>
				<tr>
					<td><%=student.getNumber()%></td>
					<td><%=student.getName()%></td>
					<td><%=student.getAge()%></td>
					<td><%=student.isSex()==true?"男":"女"%></td>
				
					<td><a href="<%=request.getContextPath()%>/deleteservlet?num=<%=student.getNumber()%>">删除</a></td>
					  <td><a href="<%=request.getContextPath()%>/updateStudent.jsp?num=<%=student.getNumber()%>">修改</a></td>
				</tr>
	</table>
</body>
</html>




















































