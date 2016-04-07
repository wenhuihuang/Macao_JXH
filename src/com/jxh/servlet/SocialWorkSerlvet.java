package com.jxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fg.ligerui.ConstantUtils;
import com.fg.ligerui.LigerUITools;
import com.fg.servlet.FGServlet;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.biz.SocialWorkBiz;
import com.jxh.dao.CustomerDao;
import com.jxh.dao.SocialWorkDao;
import com.jxh.pojo.SocialWorkPojo;
import com.jxh.utils.Constants;
import com.jxh.vo.BCustomer;
import com.jxh.vo.SocialWork;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/SocialWork/*")
public class SocialWorkSerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
    
	private SocialWorkDao socialWorkDao = new SocialWorkDao();
	private SocialWorkBiz socialWorkBiz = new SocialWorkBiz();
	private CustomerDao customerDao = new CustomerDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialWorkSerlvet() {
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
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		PageUtils<SocialWorkPojo> page = this.getPage(request);
		socialWorkDao.getSocialWorkPojo(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException {
		try {

			SocialWorkPojo socialWorkPojo = new SocialWorkPojo();
			
			
			Timestamp time = Timestamp.valueOf(ToolsUtils.getDateStringByFormat(new Date(), null, null));
			String ts= (time+"").replace("-", "");
			String d = "NEW"+ts.substring(0, 8)+customerDao.getCUSTCODE(Constants.NO);
			socialWorkPojo.setWorkNO(d);
			BCustomer customer = new BCustomer();
			customer.setCustType2("3");
			request.setAttribute("socialWorkPojo", socialWorkPojo);
			request.setAttribute("customer", customer);
			forwardDispatcher("../jsp/manage/socialWork_edit.jsp", request, response);
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			SocialWorkPojo socialWorkPojo = socialWorkDao.getSocialWorkPojoByCondition(" and workID = ? ",
					this.getParameterByName(request, "workID"));
			BCustomer customer = customerDao.getCustomerByCondition(" and custID = ? ",
					this.getParameterByName(request, "custID"));
		
			request.setAttribute("socialWorkPojo", socialWorkPojo);
			request.setAttribute("customer", customer);
			
				forwardDispatcher("../jsp/manage/socialWork_edit.jsp",request,response);
			

		} catch (IOException | SQLException | ServletException e) {
			e.printStackTrace();
		}

	}

	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		SocialWork socialWork = this.getObjectByParameter(request, SocialWork.class);
		BCustomer bCustomer = this.getObjectByParameter(request, BCustomer.class);
		String message = "";
		
			if (socialWork.getWorkID() != null && !"".equals(socialWork.getWorkID())) {
				message = socialWorkBiz.updateSocialWork(socialWork,bCustomer);
			} else {
				message = socialWorkBiz.insertSocialWork(socialWork,bCustomer);
			}
	

		// 设置为表单jsp
		request.setAttribute("msg", message);
		

		if (message.indexOf("成功") > 0) {
			sendRedirect("../jsp/manage/socialWork_list.jsp", response);
			
		} else {
			request.setAttribute("socialWork", socialWork);
			forwardDispatcher("../jsp/manage/socialWork_edit.jsp", request,response);
			
		}

	}
	
	private void deleteSocialWork(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String workID = request.getParameter("workID");
		String custID = request.getParameter("custID");
		if(workID != null && !"".equals(workID)){
			flag = socialWorkBiz.deleteSocialWorkByWorkID(workID,custID);
		}
		response.getWriter().print(flag);
	}

}
