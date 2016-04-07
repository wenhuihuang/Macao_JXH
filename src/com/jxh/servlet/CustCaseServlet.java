package com.jxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fg.ligerui.ConstantUtils;
import com.fg.ligerui.LigerUITools;
import com.fg.servlet.FGServlet;
import com.fg.utils.JSONResultUtils;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.BCustCaseRecordPojo;
import com.jxh.pojo.BCustCaseSummaryHandlePojo;
import com.jxh.pojo.CustCasePojo;
import com.jxh.pojo.Customer;
import com.jxh.utils.Constants;
import com.jxh.vo.BCustomer;
import com.jxh.vo.CSSA;
import com.jxh.vo.BCustCase;
import com.jxh.vo.BCustCaseAssess;
import com.jxh.vo.BCustCaseRecord;
import com.jxh.vo.BCustCaseSummary;
import com.jxh.vo.BCustCaseSummaryHandle;
import com.jxh.vo.Retarded;
import com.jxh.vo.SpecialAllowance;

import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;

import com.jxh.biz.CustCaseBiz;
import com.jxh.dao.BCustCaseSummaryHandleDao;
import com.jxh.dao.CustCaseDao;
import com.jxh.dao.CustCaseRecordDao;
import com.jxh.dao.CustomerDao;

/**
 * Servlet implementation class CustCaseServlet
 */
@WebServlet("/CustCase/*")
public class CustCaseServlet extends FGServlet {
	private static final long serialVersionUID = 1L;
	private CustCaseDao custCaseDao = new CustCaseDao();
	private CustCaseBiz custCaseBiz = new CustCaseBiz();
	private CustCaseRecordDao custCaseRecordDao = new CustCaseRecordDao();
	private BCustCaseSummaryHandleDao bCustCaseSummaryHandleDao = new BCustCaseSummaryHandleDao();
	private CustomerDao customerDao = new CustomerDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustCaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	 * 獲取所有個案
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws SQLException
	 */
	private void listPojos(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		String custType = request.getParameter("custType");
		System.out.println(custType);
		String condition=null;
		if("0".equals(custType) ){
			condition = " and bCustomer.custType =  '0' ";
		}else if("1".equals(custType) || "2".equals(custType)){
			condition = " and bCustomer.custType != '0' ";
		}
		PageUtils<CustCasePojo> page = this.getPage(request);
		custCaseDao.getCustCasePojoList(page,condition);
		LigerUITools.writeGridJson(page, response);
	}
	
	
	/**
	 * 獲取個案撮要記錄
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws SQLException
	 */
	private void bCustCaseRecordList(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		String caseID = request.getParameter("caseID");
		String sqlStr = " and caseID='"+caseID+"'";
		PageUtils<BCustCaseRecordPojo> page = this.getPage(request);
		custCaseRecordDao.getBCustCaseRecordList(page,sqlStr);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void bCustCaseSummaryHandlePojoList(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		String caseID = request.getParameter("caseID");
		System.out.print(caseID+"=cc");
		String sqlStr = " and caseID='"+caseID+"'";
		PageUtils<BCustCaseSummaryHandlePojo> page = this.getPage(request);
		bCustCaseSummaryHandleDao.getBCustSummaryHandlePojoByCondition(page,sqlStr);
		LigerUITools.writeGridJson(page, response);
	}
	
	/**
	 * 進入修改個案撮要記錄
	 * @param request
	 * @param response
	 */
	private void editBCustCaseRecord(HttpServletRequest request,HttpServletResponse response){
		//String caseID = request.getParameter("caseID");
		try {
			BCustCaseRecordPojo record = custCaseRecordDao.getBCustCaseRecordPojoByCondition(" and caseID = ?",
					this.getParameterByName(request, "caseID"));
			request.setAttribute("bCustCaseRecordPojo", record);
				forwardDispatcher("../jsp/custCase/bCustCaseRecord_detail.jsp", request, response);
		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private void addBCustCaseRecord(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		BCustCaseRecord bCustCaseRecord = new BCustCaseRecord();
		String fullName = request.getParameter("fullName");
		bCustCaseRecord.setFullName(fullName);
		//request.setAttribute("bCustCaseRecord", bCustCaseRecord);

		forwardDispatcher("../jsp/custCase/bCustCaseRecord_detail.jsp?fullName="+fullName, request, response);
	
	}
	
	/**
	 * 进入修改页面
	 * 
	 * @param request
	 * @param response
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			CustCasePojo custCasePojo = custCaseDao.getCustCasePojoByCondition(" and bCustCase.caseID = ? ",
					this.getParameterByName(request, "caseID"));
			BCustomer customer = customerDao.getCustomerByCondition(" and custID = ? ",
					this.getParameterByName(request, "custID"));
			request.setAttribute("custCasePojo", custCasePojo);
			request.setAttribute("customer", customer);
			
			
			forwardDispatcher("../jsp/custCase/edit.jsp", request, response);

		} catch (IOException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 进入新增页面
	 * 
	 * @param request
	 * @param response
	 * @throws ParseException 
	 * @throws SQLException 
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException {
			try {

				CustCasePojo custCase = new CustCasePojo();
				String d = ToolsUtils.getDateStringByFormat(new Date(), null, "yyyyMMdd");
				String caseNO = "C" +d+ custCaseDao.getCaseNO(Constants.NO);
				custCase.setCaseNO(caseNO);
				request.setAttribute("custCasePojo", custCase);
				request.setAttribute(JSPTYPE, ConstantUtils.FORMJSP);
				forwardDispatcher("../jsp/custCase/edit.jsp", request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	private void deleteCustCase(HttpServletRequest request, HttpServletResponse response) throws IOException{
		boolean flag=false;
		String caseID = request.getParameter("caseID");
		if (caseID != null && !"".equals(caseID)) {
			try {
				flag = custCaseBiz.deleteCustCaseByCaseID(caseID);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		response.getWriter().print(flag);
	}
	
	/**
	 * 新增提交個案资料信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		List<BCustCaseRecord>  bCustCaseRecordAdds = getGridListByParamerName(BCustCaseRecord.class, request, "bCustCaseRecordAdds");
		List<BCustCaseRecord>  bCustCaseRecordUpdates = getGridListByParamerName(BCustCaseRecord.class, request, "bCustCaseRecordUpdates");
		List<BCustCaseRecord>  bCustCaseRecordDeletes = getGridListByParamerName(BCustCaseRecord.class, request, "bCustCaseRecordDeletes");
		
		
		
		List<BCustCaseSummaryHandle>  bCustCaseSummaryHandleAdds = getGridListByParamerName(BCustCaseSummaryHandle.class, request, "bCustCaseSummaryHandleAdds");
		List<BCustCaseSummaryHandle>  bCustCaseSummaryHandleUpdates = getGridListByParamerName(BCustCaseSummaryHandle.class, request, "bCustCaseSummaryHandleUpdates");
		List<BCustCaseSummaryHandle>  bCustCaseSummaryHandleDeletes = getGridListByParamerName(BCustCaseSummaryHandle.class, request, "bCustCaseSummaryHandleDeletes");

		System.out.println("bCustCaseSummaryHandle="+bCustCaseSummaryHandleAdds);
		String caseNO = request.getParameter("caseNO");
		System.out.println(caseNO+"caseNO");
		
		//接案登記
		BCustCase bCustCase = this.getObjectByParameter(request, BCustCase.class);
		System.out.println("bCustCase__"+bCustCase);
		//個案轉介評估
		BCustCaseAssess bCustCaseAssess = this.getObjectByParameter(request, BCustCaseAssess.class);
		//結案摘要
		BCustCaseSummary bCustCaseSummary = this.getObjectByParameter(request, BCustCaseSummary.class);
		//個案撮要記錄
		//BCustCaseRecord bCustCaseRecord = this.getObjectByParameter(request, BCustCaseRecord.class);
		
		System.out.println("bCustCaseRecordUpdates=="+bCustCaseRecordUpdates);

		String message = "";
		if (bCustCase.getCaseID() != null && !"".equals(bCustCase.getCaseID())) {
			message = custCaseBiz.updateCustCase(bCustCase,bCustCaseAssess,bCustCaseSummary,bCustCaseRecordAdds,bCustCaseRecordUpdates,bCustCaseRecordDeletes,bCustCaseSummaryHandleAdds,bCustCaseSummaryHandleUpdates,bCustCaseSummaryHandleDeletes);
		} else {
			message = custCaseBiz.insertCustCase(bCustCase,bCustCaseAssess,bCustCaseSummary,bCustCaseRecordAdds,bCustCaseSummaryHandleAdds);
		}

		// 设置为表单jsp
		request.setAttribute(JSPTYPE, ConstantUtils.FORMJSP);
		request.setAttribute("msg", message);

		if (message.indexOf("成功") > 0) {
			sendRedirect("../jsp/custCase/list.jsp", response);
		} else {
			request.setAttribute("bCustCase", bCustCase);
			forwardDispatcher("../jsp/custCase/edit.jsp", request, response);
		}

	}
	
}
