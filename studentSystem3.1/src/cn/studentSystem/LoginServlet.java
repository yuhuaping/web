package cn.studentSystem;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.tools.ForwardingFileObject;

public class LoginServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//解决post请求乱码
		response.setContentType("text/html;charset=utf-8");//设置响应编码
		System.out.println("LoginServlet 请求成功！");
		
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		String auto=request.getParameter("autoLogin");
		
		if(userName.endsWith("yhp") && passWord.equals("123")){
			if("true".equals(auto)){
				savCookie(response,userName,passWord,60*60*10);
			}else{
				savCookie(response,userName,passWord,0);
			}
		HttpSession session=request.getSession();
		session.setAttribute("username",userName);
		session.setMaxInactiveInterval(30*60);
		
			response.sendRedirect("./index.jsp");
	}else{
			request.getRequestDispatcher("login.jsp?isSucuess=false").forward(request, response);
		}
	}

	public void savCookie(HttpServletResponse response,String userName,String passWord,int maxAGE){
		Cookie cookie_use=new Cookie("name",userName);
		Cookie cookie_psw=new Cookie("psw",passWord);
		cookie_use.setMaxAge(maxAGE);
		cookie_psw.setMaxAge(maxAGE);
		response.addCookie(cookie_use);
		response.addCookie(cookie_psw);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}



































