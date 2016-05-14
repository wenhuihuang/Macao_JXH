package com.jxh.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fg.ligerui.LigerUITools;
import com.fg.servlet.FGServlet;
import com.fg.utils.MD5S;
import com.fg.utils.PageUtils;
import com.jxh.dao.BtypeCodeDao;
import com.jxh.dao.UserDao;
import com.jxh.dao.UserRightDao;
import com.jxh.pojo.ActivityRecordNewPojo;
import com.jxh.pojo.BtypeCode;
import com.jxh.pojo.QxUserRights;
import com.jxh.pojo.QxUsers;
import com.jxh.vo.BCustCase;
import com.jxh.vo.BCustomer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * Servlet implementation class User
 */
@WebServlet("/User/*")
public class UserServlet extends FGServlet {
	private static final long serialVersionUID = 1L;
    
	private UserDao userDao = new UserDao();
	private UserRightDao userRightDao = new UserRightDao();
	private BtypeCodeDao btypeCodeDao = new BtypeCodeDao();
	
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
	
	/**
	 * 獲取用戶權限左邊
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws SQLException
	 */
	private void loadMastersFromDB(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		
		PageUtils<QxUsers> page = this.getPage(request);
		//String condition = "";
		userDao.getAllUsers(page, null);
		LigerUITools.writeGridJson(page, response);
	}
	
	/**
	 * 獲取用戶右邊
	 * @return
	 * @throws SQLException 
	 * @throws IOException 
	 */
	private void loadDetailsFromDB(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		
		String userId = request.getParameter("currentMasterid");
		PageUtils<QxUserRights> page = this.getPage(request);
		userRightDao.getAllUserRightsByUserId(page,null,userId);
		LigerUITools.writeGridJson(page, response);
	}
	
	/**
	 * 增加用戶
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws SQLException 
	 */
	private void showSingle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		PageUtils<BtypeCode> page = this.getPage(request);
		 btypeCodeDao.getAllTypeCodeByTypeBase(page,null,"91");
		 String typeCodes = LigerUITools.getGridJson(page);
		request.setAttribute("typeCodes",typeCodes);

		forwardDispatcher("../jsp/customer/Users_ShowSingle.jsp", request, response);
	}
	
	/*
	 * 查看操作員屬性
	 */
	private void loadMasterFromDB(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		QxUsers user = new QxUsers();
		String editPrimaryKey = request.getParameter("editPrimaryKey");
			if(editPrimaryKey==null||"".equals(editPrimaryKey)){
				
				user.setUserId(editPrimaryKey);
				user.setCorpId("0001");
			}else{
				user = userDao.getUserById(editPrimaryKey);
			}
		
		String rs = JSONObject.fromObject(user).toString();
		response.getWriter().print(rs);
	}
	
	/**
	 * 檢查userCode
	 * @param request
	 * @param response
	 */
	private void checkUserCode(HttpServletRequest request, HttpServletResponse response){
		boolean flag = false;
		try {
			String userCode = request.getParameter("userCode");
			if(userDao.checkUserIsExistByCode(userCode)>0){
				flag=false;
			}else{
				flag=true;
			}
			response.getWriter().print(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 保存操作員
	 * @return
	 * @throws ParseException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IOException 
	 * @throws SQLException 
	 */
	private void saveUser(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, ParseException, IOException, SQLException{
		boolean flag = false;
		QxUsers qxUsers = this.getObjectByParameter(request, QxUsers.class);
		/*			String orgPassword = request.getParameter("orgPassword");
		if(!orgPassword.equals(user.getPassword())){
			
			user.setPassword(MD5S.getMD5Result(user.getPassword()));
			
		}*/
		QxUsers tmpUser = userDao.getUserById(qxUsers.getUserId());
		if(tmpUser!=null){
			if(userDao.updateQxUsers(qxUsers) > 0){
				flag = true;
			}
		}else{
			if(userDao.insertQxUsers(qxUsers) > 0){
				flag = true;
			}
		}
		response.getWriter().print(flag);
	}
	
	/**
	 * 刪除用戶
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public void deleteMasterRowByfrmMDIChild_DB(HttpServletRequest request, HttpServletResponse response) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException, SQLException, ParseException {
		boolean flag=false;
		String userId = request.getParameter("userId");
		if(userDao.deleteByID(userId) > 0){
			flag = true;
		}
		response.getWriter().print(flag);
	}
	
	/**
	 * 保存右邊
	 * @return
	 * @throws IOException 
	 */
	public void saveUserRights(HttpServletRequest request, HttpServletResponse response) throws IOException{
		boolean flag = false;
		try {
			
			
			String updatedRows =  request.getParameter("updatedRows");
			System.out.println("updatedRows="+updatedRows);
			List<QxUserRights> rights =null;
			if (updatedRows != null &&!"null".equals(updatedRows) && !"[]".equals(updatedRows)&& !"undefined".equals(updatedRows)){
				JSONArray addArray = JSONArray.fromObject(updatedRows);
				rights = JSONArray.toList(addArray, new QxUserRights(),new JsonConfig());
				
			}
			
			System.out.println(rights);
			int[] rows = userRightDao.updateQxUserRightsBatch(rights);
			for( int row : rows){
				if(row > 0){
					flag = true;
				}
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().print(flag);
	}
	
}
