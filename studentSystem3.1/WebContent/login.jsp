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
		<title>登录</title>
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<script src="js/jquery.js"></script>
		<script src="js/pintuer.js"></script>
  </head>
  
  <body>
		<div class="bg"></div>
		<div class="container">
			<div class="line bouncein">
				<div class="xs6 xm4 xs3-move xm4-move">
					<div style="height: 150px;"></div>
					<div class="media media-y margin-big-bottom">
					</div>
					<form action="./loginservlet" method="post">
						<div class="panel loginbox">
							<div class="text-center margin-big padding-big-top">
								<h1>
									后台管理中心
								</h1>
							</div>
							
		<%
			String userName="";
			String passWord="";
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (Cookie c : cookies) {
					if(c.getName().equals("name")){
						userName = c.getValue();
					}else if(c.getName().equals("psw")){
						passWord = c.getValue();
					}
	
				}
			}
		%>
							<div class="panel-body"
								style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
								<div class="form-group">
									<div class="field field-icon-right">
										<input action="" type="text" class="input input-big" name="userName"
											placeholder="登录账号" data-validate="required:请填写账号" value="<%=userName %>"/>
										<span class="icon icon-user margin-small"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="field field-icon-right">
										<input type="password" class="input input-big" name="passWord"
											placeholder="登录密码" data-validate="required:请填写密码" value="<%=passWord %>"/>
										<span class="icon icon-key margin-small"></span>
									</div>
								</div>
							<input type="checkbox" name="autoLogin" value="true" checked="checked"><span style="color:gray">保存登录信息</span><br/>
							</div>
							<div style="padding: 30px;">
								<input type="submit"
									class="button button-block bg-main text-big input-big"
									value="登录">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		
  </body>
</html>
