package com.fg.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.fg.factory.ConnectionContext;
import com.fg.factory.ConnectionFactory;

/**
 * Servlet Filter implementation class ConnectionFilter
 */
public class ConnectionFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ConnectionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		Connection conn = null;

		try {
			//获取链接，事务处理
			conn = ConnectionFactory.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			
			//将Connection加入到ThreadLocal中
			ConnectionContext.getInstance().addConnection(conn);
			
			//转给Servlet做处理
			chain.doFilter(request, response);

			//提交事务
			conn.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} finally {
			//移除ThreadLocal中的链接
			ConnectionContext.getInstance().removeConnection();
			//关闭连接
			ConnectionFactory.closeConnection(conn);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
