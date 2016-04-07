package com.jxh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fg.servlet.FGServlet;
import com.fg.utils.MD5S;
import com.jxh.dao.UserDao;
import com.jxh.pojo.QxUsers;

/**
 * Servlet implementation class User
 */
@WebServlet("/User/*")
public class UserServlet extends FGServlet {
	private static final long serialVersionUID = 1L;
    
	private UserDao userDao = new UserDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String userCode = this.getParameterByName(request, "userCode");
			String password = this.getParameterByName(request, "password");
			password = password==null||"".equals(password)?null:MD5S.getMD5Result(password);
			QxUsers user = userDao.login(userCode, password);
			
			if(user==null){
				request.setAttribute("error", "用户名不存在或密码错误，登录失败！");
				
				forwardDispatcher("../jsp/login.jsp", request, response);
			}else{
				HttpSession session = getSession(request);
				session.setAttribute("user", user);
				
				//forwardDispatcher("../jsp/index.jsp", request, response);
				sendRedirect("../jsp/index.jsp", response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				request.setAttribute("error", "登录失败，错误提示:\n"+e.getMessage());
				forwardDispatcher("../jsp/login.jsp", request, response);
			} catch (ServletException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}

}
