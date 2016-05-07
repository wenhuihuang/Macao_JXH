package com.jxh.servlet;

import java.io.IOException;
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
import com.jxh.biz.WelcomeBiz;
import com.jxh.dao.BCustBelongOrgPayLogDao;
import com.jxh.dao.CustEditLogsDao;
import com.jxh.dao.CustomerDao;
import com.jxh.pojo.BcustBelongOrgPayPojo;
import com.jxh.pojo.BcustEditLogsMasterPojo;
import com.jxh.pojo.Customer;
import com.jxh.pojo.DormitoryTrainingReviewTargetPojo;
import com.jxh.vo.BCustomer;

/**
 * Servlet implementation class User
 */
@WebServlet("/Welcome/*")
public class WelcomeServlet extends FGServlet {
	private static final long serialVersionUID = 1L;
    
	private WelcomeBiz welcomeBiz = new WelcomeBiz();
	private CustEditLogsDao custEditLogsDao = new CustEditLogsDao();
	private BCustBelongOrgPayLogDao bCustBelongOrgPayLogDao = new BCustBelongOrgPayLogDao();
	private CustomerDao customerDao = new CustomerDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
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

	/**
	 * 資料更新提醒
	 * @param request
	 * @param response
	 * @return
	 */
	private String loadChangeCusts(HttpServletRequest request, HttpServletResponse response){
		try {
			
			
			String condition = request.getParameter("condition");
			
			String resultCondition = "";
			if(condition!=null&&!"".equals(condition)){
				resultCondition = " and (CustCode like '%"+condition+"%' or FullName like '%"+condition+"%')";
			}
			PageUtils<BcustEditLogsMasterPojo> page = this.getPage(request);
			//String condition = " and reviewID = ? ";
			custEditLogsDao.getCustEditLogsByCondition(page, condition);
			
			LigerUITools.writeGridJson(page, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 繳費通知
	 * @param request
	 * @param response
	 * @return
	 */
	private String loadPayCusts(HttpServletRequest request, HttpServletResponse response){
		
		try {
			String condition = request.getParameter("condition");
			
			String resultCondition = "";
			if(condition!=null&&!"".equals(condition)){
				resultCondition = " and (CustCode like '%"+condition+"%' or FullName like '%"+condition+"%')";
			}
			PageUtils<BcustBelongOrgPayPojo> page = this.getPage(request);
			bCustBelongOrgPayLogDao.getCustBelongOrgPayLogDaoByCondition(page, resultCondition);
			
			LigerUITools.writeGridJson(page, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 未來7天生日的會員
	 * @return
	 */
	private String loadbirthdayCust(HttpServletRequest request, HttpServletResponse response){
		
		try {
			String condition = request.getParameter("condition");
			
			String resultCondition = "";
			if(condition!=null&&!"".equals(condition)){
				resultCondition = " and (CustCode like '%"+condition+"%' or FullName like '%"+condition+"%')";
			}
			PageUtils<BCustomer> page = this.getPage(request);
			customerDao.getBirthDayCusts(page, resultCondition);
			
			LigerUITools.writeGridJson(page, response);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 年齡超過60歲的會員
	 * @param request
	 * @param response
	 * @return
	 */
	private String loadOldAageCusts(HttpServletRequest request, HttpServletResponse response){
		try {
			PageUtils<BCustomer> page = this.getPage(request);
			customerDao.getOldAgeCusts(page, null);
			
			LigerUITools.writeGridJson(page, response);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
	}
	
	/**
	 * 證照期限
	 * @param request
	 * @param response
	 * @return
	 */
	private String loadCertificates(HttpServletRequest request, HttpServletResponse response){
		try {
			PageUtils<BCustomer> page = this.getPage(request);
			customerDao.getCertificates(page, null);
			
			LigerUITools.writeGridJson(page, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
