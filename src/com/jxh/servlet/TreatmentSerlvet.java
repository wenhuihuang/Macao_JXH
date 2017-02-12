package com.jxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
import com.jxh.biz.TreatmentBiz;
import com.jxh.dao.BCustomerSchoolDao;
import com.jxh.dao.CustCaseDao;
import com.jxh.dao.CustomerDao;
import com.jxh.dao.GroupDetailDao;
import com.jxh.dao.GroupSettingRecordPerformanceDao;
import com.jxh.dao.GroupTrainingPlanDao;
import com.jxh.dao.GroupTrainingRecordDao;
import com.jxh.dao.TreatmentAssessDao;
import com.jxh.dao.TreatmentDao;
import com.jxh.dao.TreatmentFamilyDao;
import com.jxh.dao.TreatmentHistoryDao;
import com.jxh.dao.TreatmentPlanDao;
import com.jxh.dao.TreatmentRecordDao;
import com.jxh.dao.TreatmentReportDao;
import com.jxh.dao.TreatmentTrainingDao;
import com.jxh.dao.TreatmentTrainingPlanDao;
import com.jxh.dao.TreatmentTrainingWorkDao;
import com.jxh.dao.TreatmentTrainingWorkRecordDao;
import com.jxh.pojo.CustCasePojo;
import com.jxh.pojo.Customer;
import com.jxh.pojo.TreatmentPojo;
import com.jxh.pojo.TreatmentAssessPojo;
import com.jxh.pojo.TreatmentReportPojo;
import com.jxh.utils.Constants;
import com.jxh.vo.BCustCase;
import com.jxh.vo.BCustomer;
import com.jxh.vo.BCustomerSchool;
import com.jxh.vo.CSSA;
import com.jxh.vo.GroupDetail;
import com.jxh.vo.GroupSetting;
import com.jxh.vo.GroupSettingRecordPerformance;
import com.jxh.vo.GroupTrainingPlan;
import com.jxh.vo.GroupTrainingRecord;
import com.jxh.vo.Retarded;
import com.jxh.vo.SpecialAllowance;
import com.jxh.vo.Treatment;
import com.jxh.vo.TreatmentAssess;
import com.jxh.vo.TreatmentFamily;
import com.jxh.vo.TreatmentHistory;
import com.jxh.vo.TreatmentPlan;
import com.jxh.vo.TreatmentRecord;
import com.jxh.vo.TreatmentReport;
import com.jxh.vo.TreatmentTraining;
import com.jxh.vo.TreatmentTrainingPlan;
import com.jxh.vo.TreatmentTrainingWork;
import com.jxh.vo.TreatmentTrainingWorkRecord;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/Treatment/*")
public class TreatmentSerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
	private TreatmentDao treatmentDao = new TreatmentDao();
	private BCustomerSchoolDao bCustomerSchoolDao = new BCustomerSchoolDao();
	private TreatmentHistoryDao treatmentHistoryDao = new TreatmentHistoryDao();
	private TreatmentPlanDao treatmentPlanDao = new TreatmentPlanDao();
	private TreatmentRecordDao treatmentRecordDao = new TreatmentRecordDao();
	private TreatmentFamilyDao treatmentFamilyDao = new TreatmentFamilyDao();
	private TreatmentAssessDao treatmentAssessDao = new TreatmentAssessDao();
	private TreatmentReportDao treatmentReportDao = new TreatmentReportDao();
	private CustomerDao customerDao = new CustomerDao();
	private CustCaseDao custCaseDao = new CustCaseDao();
	private TreatmentBiz treatmentBiz = new TreatmentBiz();
	private TreatmentTrainingDao treatmentTrainingDao = new TreatmentTrainingDao();
	private TreatmentTrainingWorkDao treatmentTrainingWorkDao = new TreatmentTrainingWorkDao();
	private GroupDetailDao groupDetailDao = new GroupDetailDao();
	private GroupSettingRecordPerformanceDao groupSettingRecordPerformanceDao = new GroupSettingRecordPerformanceDao();
	private TreatmentTrainingPlanDao treatmentTrainingPlanDao = new TreatmentTrainingPlanDao();
	private TreatmentTrainingWorkRecordDao  treatmentTrainingWorkRecordDao = new TreatmentTrainingWorkRecordDao();
    private GroupTrainingPlanDao groupTrainingPlanDao = new GroupTrainingPlanDao();
    private GroupTrainingRecordDao groupTrainingRecordDao = new GroupTrainingRecordDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TreatmentSerlvet() {
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
		PageUtils<TreatmentPojo> page = this.getPage(request);
		String treatmentType = request.getParameter("treatmentType");
		if("5".equals(treatmentType)){
			treatmentDao.getTreatmentFnPojo(page," and treatmentType="+treatmentType);
		}else{
			treatmentDao.getTreatmentPojo(page," and treatmentType="+treatmentType);	
		}
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException {
		String treatmentType = request.getParameter("treatmentType");
		try {

			TreatmentPojo treatmentPojo = new TreatmentPojo();

			Timestamp time = Timestamp.valueOf(ToolsUtils.getDateStringByFormat(new Date(), null, null));
			String ts= (time+"").replace("-", "");
			String NO = ts.substring(0, 8)+treatmentDao.getTreatmentNO(Constants.NO);
			
			//request.setAttribute(JSPTYPE, ConstantUtils.FORMJSP);
			if("1".equals(treatmentType)){
				treatmentPojo.setTreatmentNO("L"+NO);
				request.setAttribute("treatmentPojo", treatmentPojo);
				forwardDispatcher("../jsp/treatment/language_edit.jsp", request, response);
			}else if("2".equals(treatmentType)){
				treatmentPojo.setTreatmentNO("J"+NO);
				request.setAttribute("treatmentPojo", treatmentPojo);
				forwardDispatcher("../jsp/treatment/job_edit.jsp", request, response);
			}else if("3".equals(treatmentType)){
				treatmentPojo.setTreatmentNO("P"+NO);
				request.setAttribute("treatmentPojo", treatmentPojo);
				forwardDispatcher("../jsp/treatment/physics_edit.jsp", request, response);
			}else if("4".equals(treatmentType)){
				treatmentPojo.setTreatmentNO("S"+NO);
				request.setAttribute("treatmentPojo", treatmentPojo);
				forwardDispatcher("../jsp/treatment/special_edit.jsp", request, response);
			}else if("5".equals(treatmentType)){
				treatmentPojo.setTreatmentNO("F"+NO);
				request.setAttribute("treatmentPojo", treatmentPojo);
				forwardDispatcher("../jsp/treatment/function_edit.jsp", request, response);
			}else if("6".equals(treatmentType)){
				treatmentPojo.setTreatmentNO("C"+NO);
				request.setAttribute("treatmentPojo", treatmentPojo);
				forwardDispatcher("../jsp/treatment/collocation_edit.jsp", request, response);
			}
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		String treatmentType=request.getParameter("treatmentType");
		try {
			BCustomer customer = customerDao.getCustomerByCondition(" and custID = ? ",
					this.getParameterByName(request, "custID"));
			TreatmentPojo treatmentPojo = treatmentDao.getTreatmentPojoByCondition(" and treatmentID = ? ",
					this.getParameterByName(request, "treatmentID"));
			TreatmentAssessPojo treatmentAssessPojo = treatmentAssessDao.getTreatmentAssessPojoByCondition(" and treatmentID = ? ",
					this.getParameterByName(request, "treatmentID"));
			TreatmentReportPojo treatmentReportPojo = treatmentReportDao.getTreatmentReportPojoByCondition(" and treatmentID = ? ",
					this.getParameterByName(request,"treatmentID"));
		
			request.setAttribute("customer", customer);
			request.setAttribute("treatmentPojo", treatmentPojo);
			request.setAttribute("treatmentAssessPojo", treatmentAssessPojo);
			request.setAttribute("treatmentReportPojo", treatmentReportPojo);
			
			if("1".equals(treatmentType)){
				forwardDispatcher("../jsp/treatment/language_edit.jsp", request, response);
			}else if("2".equals(treatmentType)){
				forwardDispatcher("../jsp/treatment/job_edit.jsp", request, response);
			}else if("3".equals(treatmentType)){
				forwardDispatcher("../jsp/treatment/physics_edit.jsp",request,response);
			}else if("4".equals(treatmentType)){
				forwardDispatcher("../jsp/treatment/special_edit.jsp",request,response);
			}else if("5".equals(treatmentType)){
				CustCasePojo custCasePojo = custCaseDao.getCustCasePojoByCustId(" and custID = ? ",
						this.getParameterByName(request, "custID"));
				TreatmentTraining treatmentTraining = treatmentTrainingDao.getTreatmentTrainingByCondition(" and treatmentID = ? ",
						this.getParameterByName(request,"treatmentID"));
				TreatmentTrainingWork treatmentTrainingWork = treatmentTrainingWorkDao.getTreatmentTrainingWorkByCondition(" and treatmentID = ?  ",
						this.getParameterByName(request,"treatmentID"));
				
				request.setAttribute("custCasePojo",custCasePojo);
				request.setAttribute("treatmentTraining", treatmentTraining);
				request.setAttribute("treatmentTrainingWork", treatmentTrainingWork);
				forwardDispatcher("../jsp/treatment/function_edit.jsp",request,response);
			}else if("6".equals(treatmentType)){
				forwardDispatcher("../jsp/treatment/collocation_edit.jsp",request,response);
			}
			

		} catch (IOException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getBCustomerSchool(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String custId = this.getParameterByName(request, "custID");
		PageUtils<BCustomerSchool> page = this.getPage(request);
		String condition = " and custID = ? ";
		bCustomerSchoolDao.getBCustomerSchoolByCondition(page, condition, custId);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getTreatmentHistory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String custId = this.getParameterByName(request, "custID");
		PageUtils<TreatmentHistory> page = this.getPage(request);
		String condition = " and custID = ? ";
		treatmentHistoryDao.getTreatmentHistoryByCondition(page, condition, custId);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getTreatmentPlan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String treatmentID = this.getParameterByName(request, "treatmentID");
		PageUtils<TreatmentPlan> page = this.getPage(request);
		String condition = " and treatmentID = ? ";
		treatmentPlanDao.getTreatmentPlanByCondition(page, condition, treatmentID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getTreatmentRecord(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String treatmentID = this.getParameterByName(request, "treatmentID");
		PageUtils<TreatmentRecord> page = this.getPage(request);
		String condition = " and treatmentID = ? ";
		treatmentRecordDao.getTreatmentRecordByCondition(page, condition, treatmentID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getTreatmentFamily(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String treatmentID = this.getParameterByName(request, "treatmentID");
		PageUtils<TreatmentFamily> page = this.getPage(request);
		String condition = " and treatmentID = ? ";
		treatmentFamilyDao.getTreatmentFamilyByCondition(page, condition, treatmentID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getGroupTrainingPlan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String treatmentID = this.getParameterByName(request, "treatmentID");
		PageUtils<GroupTrainingPlan> page = this.getPage(request);
		String condition = " and treatmentID = ? ";
		groupTrainingPlanDao.getGroupTrainingPlanByCondition(page, condition, treatmentID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getTreatmentFlowPlan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String custID = this.getParameterByName(request, "trainingID");
		PageUtils<TreatmentTrainingPlan> page = this.getPage(request);
		String condition = " and trainingID = ? ";
		treatmentTrainingPlanDao.getTreatmentTrainingPlanByCondition(page, condition, custID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getGroupTrainingRecord(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String treatmentID = this.getParameterByName(request, "treatmentID");
		PageUtils<GroupTrainingRecord> page = this.getPage(request);
		String condition = " and treatmentID = ? ";
		groupTrainingRecordDao.getGroupTrainingRecordByCondition(page, condition, treatmentID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getTreatmentManifestation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String custID = this.getParameterByName(request, "workID");
		PageUtils<TreatmentTrainingWorkRecord> page = this.getPage(request);
		String condition = " and workID = ? ";
		treatmentTrainingWorkRecordDao.getTreatmentTrainingWorkRecordByCondition(page, condition, custID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String treatmentType = request.getParameter("treatmentType");
		
		List<TreatmentPlan> treatmentPlanAdds = getGridListByParamerName(TreatmentPlan.class, request, "treatmentPlanAdds");
		List<TreatmentPlan> treatmentPlanUpdates = getGridListByParamerName(TreatmentPlan.class, request, "treatmentPlanUpdates");
		List<TreatmentPlan> treatmentPlanDeletes = getGridListByParamerName(TreatmentPlan.class, request, "treatmentPlanDeletes");
		
		
		List<TreatmentRecord>  treatmentRecordAdds = getGridListByParamerName(TreatmentRecord.class, request, "treatmentRecordAdds");
		List<TreatmentRecord>  treatmentRecordUpdates = getGridListByParamerName(TreatmentRecord.class, request, "treatmentRecordUpdates");
		List<TreatmentRecord>  treatmentRecordDeletes = getGridListByParamerName(TreatmentRecord.class, request, "treatmentRecordDeletes");
		
		
		List<TreatmentHistory>  treatmentHistoryAdds = getGridListByParamerName(TreatmentHistory.class, request, "treatmentHistoryAdds");
		List<TreatmentHistory>  treatmentHistoryUpdates = getGridListByParamerName(TreatmentHistory.class, request, "treatmentHistoryUpdates");
		List<TreatmentHistory>  treatmentHistoryDeletes = getGridListByParamerName(TreatmentHistory.class, request, "treatmentHistoryDeletes");
		
		List<TreatmentFamily>  treatmentFamilyAdds = getGridListByParamerName(TreatmentFamily.class, request, "treatmentFamilyAdds");
		List<TreatmentFamily>  treatmentFamilyUpdates = getGridListByParamerName(TreatmentFamily.class, request, "treatmentFamilyUpdates");
		List<TreatmentFamily>  treatmentFamilyDeletes = getGridListByParamerName(TreatmentFamily.class, request, "treatmentFamilyDeletes");
		
		List<BCustomerSchool>  bCustomerSchoolAdds = getGridListByParamerName(BCustomerSchool.class, request, "bCustomerSchoolAdds");
		List<BCustomerSchool>  bCustomerSchoolUpdates = getGridListByParamerName(BCustomerSchool.class, request, "bCustomerSchoolUpdates");
		List<BCustomerSchool>  bCustomerSchoolDeletes = getGridListByParamerName(BCustomerSchool.class, request, "bCustomerSchoolDeletes");
		
		

		Treatment treatment = this.getObjectByParameter(request, Treatment.class);
		TreatmentAssess treatmentAssess = this.getObjectByParameter(request, TreatmentAssess.class);
		TreatmentReport treatmentReport = this.getObjectByParameter(request, TreatmentReport.class);
		
		String message = "";
		
		if("5".equals(treatmentType)){
			TreatmentTraining treatmentTraining = this.getObjectByParameter(request, TreatmentTraining.class);
			TreatmentTrainingWork treatmentTrainingWork = this.getObjectByParameter(request, TreatmentTrainingWork.class);
			List<GroupTrainingPlan>  groupTrainingPlanAdds = getGridListByParamerName(GroupTrainingPlan.class, request, "groupTrainingPlanAdds");
			List<GroupTrainingPlan>  groupTrainingPlanUpdates = getGridListByParamerName(GroupTrainingPlan.class, request, "groupTrainingPlanUpdates");
			List<GroupTrainingPlan>  groupTrainingPlanDeletes = getGridListByParamerName(GroupTrainingPlan.class, request, "groupTrainingPlanDeletes");
			
			List<GroupTrainingRecord>  groupTrainingRecordAdds = getGridListByParamerName(GroupTrainingRecord.class, request, "groupTrainingRecordAdds");
			List<GroupTrainingRecord>  groupTrainingRecordUpdates = getGridListByParamerName(GroupTrainingRecord.class, request, "groupTrainingRecordUpdates");
			List<GroupTrainingRecord>  groupTrainingRecordDeletes = getGridListByParamerName(GroupTrainingRecord.class, request, "groupTrainingRecordDeletes");
			
			List<TreatmentTrainingPlan>  treatmentTrainingPlanAdds = getGridListByParamerName(TreatmentTrainingPlan.class, request, "treatmentTrainingPlanAdds");
			List<TreatmentTrainingPlan>  treatmentTrainingPlanUpdates = getGridListByParamerName(TreatmentTrainingPlan.class, request, "treatmentTrainingPlanUpdates");
			List<TreatmentTrainingPlan>  treatmentTrainingPlanDeletes = getGridListByParamerName(TreatmentTrainingPlan.class, request, "treatmentTrainingPlanDeletes");
			
			List<TreatmentTrainingWorkRecord>  treatmentTrainingWorkRecordAdds = getGridListByParamerName(TreatmentTrainingWorkRecord.class, request, "treatmentTrainingWorkRecordAdds");
			List<TreatmentTrainingWorkRecord>  treatmentTrainingWorkRecordUpdates = getGridListByParamerName(TreatmentTrainingWorkRecord.class, request, "treatmentTrainingWorkRecordUpdates");
			List<TreatmentTrainingWorkRecord>  treatmentTrainingWorkRecordDeletes = getGridListByParamerName(TreatmentTrainingWorkRecord.class, request, "treatmentTrainingWorkRecordDeletes");
			if(treatment.getTreatmentID() != null && !"".equals(treatment.getTreatmentID())){
				message = treatmentBiz.updateTreatmentFunction(treatment, treatmentAssess,treatmentReport,treatmentHistoryAdds,treatmentHistoryUpdates,treatmentHistoryDeletes,bCustomerSchoolAdds,bCustomerSchoolUpdates,bCustomerSchoolDeletes,treatmentFamilyAdds,treatmentFamilyUpdates,treatmentFamilyDeletes,treatmentTraining,treatmentTrainingWork,groupTrainingPlanAdds,groupTrainingPlanUpdates,groupTrainingPlanDeletes,groupTrainingRecordAdds,groupTrainingRecordUpdates,groupTrainingRecordDeletes,treatmentTrainingPlanAdds,treatmentTrainingPlanUpdates,treatmentTrainingPlanDeletes,treatmentTrainingWorkRecordAdds,treatmentTrainingWorkRecordUpdates,treatmentTrainingWorkRecordDeletes);
			}else{
				message = treatmentBiz.insertTreatmentFunction(treatment, treatmentAssess,treatmentReport,treatmentHistoryAdds,bCustomerSchoolAdds,treatmentFamilyAdds,treatmentTraining,treatmentTrainingWork,groupTrainingPlanAdds,groupTrainingRecordAdds,treatmentTrainingPlanAdds,treatmentTrainingWorkRecordAdds);
			}
		}
		
		if(!"5".equals(treatmentType)){
			if (treatment.getTreatmentID() != null && !"".equals(treatment.getTreatmentID())) {
				message = treatmentBiz.updateTreatment(treatment, treatmentAssess,treatmentReport,treatmentPlanAdds,treatmentPlanUpdates,treatmentPlanDeletes,treatmentRecordAdds,treatmentRecordUpdates,treatmentRecordDeletes,treatmentHistoryAdds,treatmentHistoryUpdates,treatmentHistoryDeletes,bCustomerSchoolAdds,bCustomerSchoolUpdates,bCustomerSchoolDeletes,treatmentFamilyAdds,treatmentFamilyUpdates,treatmentFamilyDeletes);
			} else {
				message = treatmentBiz.insertTreatment(treatment, treatmentAssess,treatmentReport,treatmentPlanAdds,treatmentRecordAdds,treatmentHistoryAdds,bCustomerSchoolAdds,treatmentFamilyAdds);
			}
		}
	

		// 设置为表单jsp
		request.setAttribute(JSPTYPE, ConstantUtils.FORMJSP);
		request.setAttribute("msg", message);
		

		if (message.indexOf("成功") > 0) {
			if("1".equals(treatmentType)){
				sendRedirect("../jsp/treatment/language_list.jsp", response);
			}else if("2".equals(treatmentType)){
				sendRedirect("../jsp/treatment/job_list.jsp", response);
			}else if("3".equals(treatmentType)){
				sendRedirect("../jsp/treatment/physics_list.jsp", response);
			}else if("4".equals(treatmentType)){
				sendRedirect("../jsp/treatment/special_list.jsp", response);
			}else if("5".equals(treatmentType)){
				sendRedirect("../jsp/treatment/function_list.jsp", response);
			}else if("6".equals(treatmentType)){
				sendRedirect("../jsp/treatment/collocation_list.jsp", response);
			}
			
		} else {
			request.setAttribute("treatment", treatment);
			if("1".equals(treatmentType)){
				forwardDispatcher("../jsp/treatment/language_edit.jsp", request, response);
			}else if("2".equals(treatmentType)){
				forwardDispatcher("../jsp/treatment/job_edit.jsp", request, response);
			}else if("3".equals(treatmentType)){
				forwardDispatcher("../jsp/treatment/physics_edit.jsp", request, response);
			}else if("4".equals(treatmentType)){
				forwardDispatcher("../jsp/treatment/special_edit.jsp", request,response);
			}else if("5".equals(treatmentType)){
				forwardDispatcher("../jsp/treatment/function_edit.jsp",request, response);
			}else if("6".equals(treatmentType)){
				forwardDispatcher("../jsp/treatment/collocation_edit.jsp", request,response);
			}
			
		}

	}
	
	private void deleteTreatment(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String treatmentID = request.getParameter("treatmentID");
		String custID = request.getParameter("custID");
		String treatmentType = request.getParameter("treatmentType");
		if(treatmentID != null && !"".equals(treatmentID) && custID != null && !"".equals(custID)){
			flag = treatmentBiz.deleteTreatmentByTreatmentID(treatmentID,custID,treatmentType);
		}
		response.getWriter().print(flag);
	}

}
