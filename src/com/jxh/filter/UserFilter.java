package com.jxh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user")==null){
			
			String url = request.getRequestURI();
			System.out.println("url == "+url);
			if(url.indexOf("login")<0){
				System.out.println("跳出");
				request.getRequestDispatcher("../jsp/login.jsp").forward(req, res);
				return;
			}
			
		}
		System.out.println("执行filter");
		chain.doFilter(req, res);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
