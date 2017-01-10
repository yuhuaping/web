package com.ittx.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.dbcp.pool.impl.GenericKeyedObjectPool.Config;


public class LongFilter implements Filter {

    
	private String noUri;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req =(HttpServletRequest) request;
			HttpServletResponse resp =(HttpServletResponse) response;
			System.out.println("req.getRequestURI():"+req.getRequestURI());
			
//			String requestUri = req.getRequestURI();//获取当前uil的地址
//			String [] urls = noUri.split(";");
//			if (urls != null && urls.length > 0) {
//				for (String url : urls) {
//					if (requestUri.indexOf(url) == -1) {
//						continue;
//					} else {
//						chain.doFilter(request, response);
//						return;
//					}
//				}
//			}
			String url = req.getRequestURI();
			if(url.indexOf("login.jsp") !=-1 || url.indexOf("loginservlet") !=-1) {
				chain.doFilter(request, response); 
                     return;				
			}
			HttpSession session =req.getSession();
			String user = (String) session.getAttribute("username");
			System.out.println(user);
			   if(user ==null){
				   resp.sendRedirect(req.getContextPath()+"/login.jsp");
			   }else{
				   chain.doFilter(request, response);
				   
			   }
		
	}

	/*
	 * 初始化
	 * 
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		noUri = fConfig.getInitParameter("noFilterUri");
		System.out.println("noUri>>>:" + noUri);
	}

}
