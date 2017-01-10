package com.ittx.web.filter;



import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineUserLisener implements HttpSessionListener {
	private static int userCount = 0; // 在线人数

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		userCount++;
		System.out.println("访问 sessionCreated :"+userCount);
		arg0.getSession().getServletContext().setAttribute("userCounts", userCount);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		userCount--;
		System.out.println("退出 sessionDestroyed :"+userCount);
		arg0.getSession().getServletContext().setAttribute("userCount", userCount);
	}


}
