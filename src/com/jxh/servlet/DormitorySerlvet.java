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
import com.jxh.biz.DormitoryRecordBiz;
import com.jxh.dao.CustomerDao;
import com.jxh.dao.DormitoryRecordDao;
import com.jxh.dao.DormitoryTrainingADPlanDao;
import com.jxh.dao.DormitoryTrainingADPlanDetailDao;
import com.jxh.dao.DormitoryTrainingPlanDao;
import com.jxh.dao.DormitoryTrainingRecordDao;
import com.jxh.dao.DormitoryTrainingRecordDetailBottomDao;
import com.jxh.dao.DormitoryTrainingRecordDetailTopDao;
import com.jxh.dao.DormitoryTrainingReviewDao;
import com.jxh.dao.DormitoryTrainingReviewDetailDao;
import com.jxh.dao.DormitoryTrainingReviewFinanceDao;
import com.jxh.dao.DormitoryTrainingReviewSettleDao;
import com.jxh.dao.DormitoryTrainingReviewTargetDao;
import com.jxh.pojo.DormitoryRecordPojo;
import com.jxh.pojo.DormitoryTrainingReviewDetailPojo;
import com.jxh.pojo.DormitoryTrainingReviewTargetPojo;
import com.jxh.vo.BCustomer;
import com.jxh.vo.DormitoryRecord;
import com.jxh.vo.DormitoryTrainingADPlan;
import com.jxh.vo.DormitoryTrainingADPlanDetail;
import com.jxh.vo.DormitoryTrainingPlan;
import com.jxh.vo.DormitoryTrainingRecord;
import com.jxh.vo.DormitoryTrainingRecordDetailBottom;
import com.jxh.vo.DormitoryTrainingRecordDetailTop;
import com.jxh.vo.DormitoryTrainingReview;
import com.jxh.vo.DormitoryTrainingReviewDetail;
import com.jxh.vo.DormitoryTrainingReviewFinance;
import com.jxh.vo.DormitoryTrainingReviewSettle;
import com.jxh.vo.DormitoryTrainingReviewTarget;
import com.jxh.vo.TreatmentPlan;
import com.jxh.vo.TreatmentTrainingWorkRecord;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/Dormitory/*")
public class DormitorySerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
    private DormitoryRecordDao dormitoryRecordDao = new DormitoryRecordDao();
    private CustomerDao customerDao = new CustomerDao();
    private DormitoryRecordBiz dormitoryRecordBiz = new DormitoryRecordBiz();
    private DormitoryTrainingADPlanDetailDao dormitoryTrainingADPlanDetailDao = new DormitoryTrainingADPlanDetailDao();
    private DormitoryTrainingPlanDao dormitoryTrainingPlanDao = new DormitoryTrainingPlanDao();
    private DormitoryTrainingADPlanDao dormitoryTrainingADPlanDao = new DormitoryTrainingADPlanDao();
    private DormitoryTrainingRecordDao dormitoryTrainingRecordDao = new DormitoryTrainingRecordDao();
    private DormitoryTrainingReviewDao dormitoryTrainingReviewDao = new DormitoryTrainingReviewDao();
    private DormitoryTrainingReviewTargetDao dormitoryTrainingReviewTargetDao = new DormitoryTrainingReviewTargetDao();
    private DormitoryTrainingReviewFinanceDao dormitoryTrainingReviewFinanceDao = new DormitoryTrainingReviewFinanceDao();
    private DormitoryTrainingReviewDetailDao dormitoryTrainingReviewDetailDao = new DormitoryTrainingReviewDetailDao();
    private DormitoryTrainingReviewSettleDao dormitoryTrainingReviewSettleDao = new DormitoryTrainingReviewSettleDao();
    private DormitoryTrainingRecordDetailTopDao dormitoryTrainingRecordDetailTopDao = new DormitoryTrainingRecordDetailTopDao();
    private DormitoryTrainingRecordDetailBottomDao dormitoryTrainingRecordDetailBottomDao = new DormitoryTrainingRecordDetailBottomDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DormitorySerlvet() {
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
		PageUtils<DormitoryRecordPojo> page = this.getPage(request);
		dormitoryRecordDao.getDormitoryRecordPojo(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {

			DormitoryRecord dormitoryRecord = new DormitoryRecord();

			request.setAttribute("dormitoryRecord", dormitoryRecord);
			forwardDispatcher("../jsp/manage/dormitory_edit.jsp", request, response);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			DormitoryRecord dormitoryRecord = dormitoryRecordDao.getDormitoryRecordByCondition(" and recordID = ? ",
					this.getParameterByName(request, "recordID"));
			request.setAttribute("dormitoryRecord", dormitoryRecord);
			
			BCustomer customer = customerDao.getCustomerByCondition(" and custID = ? ",
					this.getParameterByName(request, "custID"));
			request.setAttribute("customer", customer);
			
			DormitoryTrainingPlan dormitoryTrainingPlan = dormitoryTrainingPlanDao.getDormitoryTrainingPlanByCondition(" and recordID = ? ",
					this.getParameterByName(request, "recordID"));
			request.setAttribute("dormitoryTrainingPlan", dormitoryTrainingPlan);
			
			DormitoryTrainingADPlan dormitoryTrainingADPlan = dormitoryTrainingADPlanDao.getDormitoryTrainingADPlanByCondition(" and recordID = ? ",
					this.getParameterByName(request, "recordID"));
			request.setAttribute("dormitoryTrainingADPlan", dormitoryTrainingADPlan);
			
			DormitoryTrainingRecord dormitoryTrainingRecord = dormitoryTrainingRecordDao.getDormitoryTrainingRecordByCondition(" and recordID = ? ",
					this.getParameterByName(request, "recordID"));
			request.setAttribute("dormitoryTrainingRecord", dormitoryTrainingRecord);
			
			DormitoryTrainingReview dormitoryTrainingReview = dormitoryTrainingReviewDao.getDormitoryTrainingReviewByCondition(" and recordID = ? ",
					this.getParameterByName(request, "recordID"));
			request.setAttribute("dormitoryTrainingReview", dormitoryTrainingReview);
			
			forwardDispatcher("../jsp/manage/dormitory_edit.jsp",request,response);

		} catch (IOException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<DormitoryTrainingADPlanDetail>  dormitoryTrainingADPlanDetailAdds = getGridListByParamerName(DormitoryTrainingADPlanDetail.class, request, "dormitoryTrainingADPlanDetailAdds");
		List<DormitoryTrainingADPlanDetail>  dormitoryTrainingADPlanDetailUpdates = getGridListByParamerName(DormitoryTrainingADPlanDetail.class, request, "dormitoryTrainingADPlanDetailUpdates");
		List<DormitoryTrainingADPlanDetail>  dormitoryTrainingADPlanDetailDeletes = getGridListByParamerName(DormitoryTrainingADPlanDetail.class, request, "dormitoryTrainingADPlanDetailDeletes");
		
		List<DormitoryTrainingRecordDetailTop>  dormitoryTrainingRecordDetailTopAdds = getGridListByParamerName(DormitoryTrainingRecordDetailTop.class, request, "dormitoryTrainingRecordDetailTopAdds");
		List<DormitoryTrainingRecordDetailTop>  dormitoryTrainingRecordDetailTopUpdates = getGridListByParamerName(DormitoryTrainingRecordDetailTop.class, request, "dormitoryTrainingRecordDetailTopUpdates");
		List<DormitoryTrainingRecordDetailTop>  dormitoryTrainingRecordDetailTopDeletes = getGridListByParamerName(DormitoryTrainingRecordDetailTop.class, request, "dormitoryTrainingRecordDetailTopDeletes");

		List<DormitoryTrainingRecordDetailBottom>  dormitoryTrainingRecordDetailBottomAdds = getGridListByParamerName(DormitoryTrainingRecordDetailBottom.class, request, "dormitoryTrainingRecordDetailBottomAdds");
		List<DormitoryTrainingRecordDetailBottom>  dormitoryTrainingRecordDetailBottomUpdates = getGridListByParamerName(DormitoryTrainingRecordDetailBottom.class, request, "dormitoryTrainingRecordDetailBottomUpdates");
		List<DormitoryTrainingRecordDetailBottom>  dormitoryTrainingRecordDetailBottomDeletes = getGridListByParamerName(DormitoryTrainingRecordDetailBottom.class, request, "dormitoryTrainingRecordDetailBottomDeletes");
		
		List<DormitoryTrainingReviewDetail>  dormitoryTrainingReviewDetailAdds = getGridListByParamerName(DormitoryTrainingReviewDetail.class, request, "dormitoryTrainingReviewDetailAdds");
		List<DormitoryTrainingReviewDetail>  dormitoryTrainingReviewDetailUpdates = getGridListByParamerName(DormitoryTrainingReviewDetail.class, request, "dormitoryTrainingReviewDetailUpdates");
		List<DormitoryTrainingReviewDetail>  dormitoryTrainingReviewDetailDeletes = getGridListByParamerName(DormitoryTrainingReviewDetail.class, request, "dormitoryTrainingReviewDetailDeletes");
		
		List<DormitoryTrainingReviewTarget>  dormitoryTrainingReviewTargetAdds = getGridListByParamerName(DormitoryTrainingReviewTarget.class, request, "dormitoryTrainingReviewTargetAdds");
		List<DormitoryTrainingReviewTarget>  dormitoryTrainingReviewTargetUpdates = getGridListByParamerName(DormitoryTrainingReviewTarget.class, request, "dormitoryTrainingReviewTargetUpdates");
		List<DormitoryTrainingReviewTarget>  dormitoryTrainingReviewTargetDeletes = getGridListByParamerName(DormitoryTrainingReviewTarget.class, request, "dormitoryTrainingReviewTargetDeletes");
		
		List<DormitoryTrainingReviewFinance>  dormitoryTrainingReviewFinanceAdds = getGridListByParamerName(DormitoryTrainingReviewFinance.class, request, "dormitoryTrainingReviewFinanceAdds");
		List<DormitoryTrainingReviewFinance>  dormitoryTrainingReviewFinanceUpdates = getGridListByParamerName(DormitoryTrainingReviewFinance.class, request, "dormitoryTrainingReviewFinanceUpdates");
		List<DormitoryTrainingReviewFinance>  dormitoryTrainingReviewFinanceDeletes = getGridListByParamerName(DormitoryTrainingReviewFinance.class, request, "dormitoryTrainingReviewFinanceDeletes");
		
		List<DormitoryTrainingReviewSettle>  dormitoryTrainingReviewSettleAdds = getGridListByParamerName(DormitoryTrainingReviewSettle.class, request, "dormitoryTrainingReviewSettleAdds");
		List<DormitoryTrainingReviewSettle>  dormitoryTrainingReviewSettleUpdates = getGridListByParamerName(DormitoryTrainingReviewSettle.class, request, "dormitoryTrainingReviewSettleUpdates");
		List<DormitoryTrainingReviewSettle>  dormitoryTrainingReviewSettleDeletes = getGridListByParamerName(DormitoryTrainingReviewSettle.class, request, "dormitoryTrainingReviewSettleDeletes");
		
		
		//院舍記錄
		DormitoryRecord dormitoryRecord = this.getObjectByParameter(request, DormitoryRecord.class);
		//個別訓練策劃
		DormitoryTrainingPlan dormitoryTrainingPlan = this.getObjectByParameter(request, DormitoryTrainingPlan.class);
		//個別住客整日訓練流程
		DormitoryTrainingADPlan dormitoryTrainingADPlan = this.getObjectByParameter(request, DormitoryTrainingADPlan.class);
		//個別訓練記錄
		DormitoryTrainingRecord dormitoryTrainingRecord = this.getObjectByParameter(request, DormitoryTrainingRecord.class);
		//小組話個別訓練策劃及檢討
		DormitoryTrainingReview dormitoryTrainingReview = this.getObjectByParameter(request, DormitoryTrainingReview.class);
		

		String message = "";
		if (dormitoryRecord.getRecordID() != null && !"".equals(dormitoryRecord.getRecordID())) {
			message = dormitoryRecordBiz.updateDormitoryRecord(dormitoryRecord,dormitoryTrainingPlan,dormitoryTrainingADPlan,dormitoryTrainingRecord,dormitoryTrainingReview,dormitoryTrainingADPlanDetailAdds,dormitoryTrainingADPlanDetailUpdates,dormitoryTrainingADPlanDetailDeletes,dormitoryTrainingRecordDetailTopAdds,dormitoryTrainingRecordDetailTopUpdates,dormitoryTrainingRecordDetailTopDeletes,dormitoryTrainingRecordDetailBottomAdds,dormitoryTrainingRecordDetailBottomUpdates,dormitoryTrainingRecordDetailBottomDeletes,dormitoryTrainingReviewTargetAdds,dormitoryTrainingReviewTargetUpdates,dormitoryTrainingReviewTargetDeletes,dormitoryTrainingReviewFinanceAdds,dormitoryTrainingReviewFinanceUpdates,dormitoryTrainingReviewFinanceDeletes,dormitoryTrainingReviewSettleAdds,dormitoryTrainingReviewSettleUpdates,dormitoryTrainingReviewSettleDeletes,dormitoryTrainingReviewDetailAdds,dormitoryTrainingReviewDetailUpdates,dormitoryTrainingReviewDetailDeletes);
		} else {
			message = dormitoryRecordBiz.insertDormitoryRecord(dormitoryRecord,dormitoryTrainingPlan,dormitoryTrainingADPlan,dormitoryTrainingRecord,dormitoryTrainingReview,dormitoryTrainingADPlanDetailAdds,dormitoryTrainingRecordDetailTopAdds,dormitoryTrainingRecordDetailBottomAdds,dormitoryTrainingReviewTargetAdds,dormitoryTrainingReviewFinanceAdds,dormitoryTrainingReviewSettleAdds,dormitoryTrainingReviewDetailAdds);
		}

		// 设置为表单jsp
		request.setAttribute(JSPTYPE, ConstantUtils.FORMJSP);
		request.setAttribute("msg", message);

		if (message.indexOf("成功") > 0) {
			sendRedirect("../jsp/manage/dormitory_list.jsp", response);
		} else {
			request.setAttribute("dormitoryRecord", dormitoryRecord);
			forwardDispatcher("../jsp/manage/dormitory_edit.jsp", request, response);
		}

	}
	public void  getDormitoryTrainingADPlanDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String aPlanID = this.getParameterByName(request, "aPlanID");
		PageUtils<DormitoryTrainingADPlanDetail> page = this.getPage(request);
		String condition = " and planMasterID = ? ";
		dormitoryTrainingADPlanDetailDao.getDormitoryTrainingADPlanDetailByCondition(page, condition, aPlanID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void deleteDormitoryRecord(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String recordID = request.getParameter("recordID");
		String aPlanID = request.getParameter("aPlanID");
		String tRecordID = request.getParameter("tRecordID");
		String reviewID = request.getParameter("reviewID");
		if(recordID != null && !"".equals(recordID)){
			flag = dormitoryRecordBiz.deleteDormitoryRecordByRecordID(recordID,aPlanID,tRecordID,reviewID);
		}
		response.getWriter().print(flag);
	}
	
	private void getDormitoryTrainingReviewTarget(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String reviewID = this.getParameterByName(request, "reviewID");
		PageUtils<DormitoryTrainingReviewTargetPojo> page = this.getPage(request);
		String condition = " and reviewID = ? ";
		dormitoryTrainingReviewTargetDao.getDormitoryTrainingReviewTargetPojoByCondition(page, condition, reviewID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getDormitoryTrainingReviewFinance(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String reviewID = this.getParameterByName(request, "reviewID");
		PageUtils<DormitoryTrainingReviewFinance> page = this.getPage(request);
		String condition = " and reviewID = ? ";
		dormitoryTrainingReviewFinanceDao.getDormitoryTrainingReviewFinanceByCondition(page, condition, reviewID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getDormitoryTrainingReviewDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String reviewID = this.getParameterByName(request, "reviewID");
		PageUtils<DormitoryTrainingReviewDetailPojo> page = this.getPage(request);
		String condition = " and reviewID = ? ";
		dormitoryTrainingReviewDetailDao.getDormitoryTrainingReviewDetailPojoByCondition(page, condition, reviewID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getDormitoryTrainingReviewSettle(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String reviewID = this.getParameterByName(request, "reviewID");
		PageUtils<DormitoryTrainingReviewSettle> page = this.getPage(request);
		String condition = " and reviewID = ? ";
		dormitoryTrainingReviewSettleDao.getDormitoryTrainingReviewSettleByCondition(page, condition, reviewID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getDormitoryTrainingRecordDetailTop(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String reviewID = this.getParameterByName(request, "masterRecordID");
		PageUtils<DormitoryTrainingRecordDetailTop> page = this.getPage(request);
		String condition = " and masterRecordID = ? ";
		dormitoryTrainingRecordDetailTopDao.getDormitoryTrainingRecordDetailTopByCondition(page, condition, reviewID);
		
		LigerUITools.writeGridJson(page, response);
	}
	private void getDormitoryTrainingRecordDetailBottom(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String reviewID = this.getParameterByName(request, "masterRecordID");
		PageUtils<DormitoryTrainingRecordDetailBottom> page = this.getPage(request);
		String condition = " and masterRecordID = ? ";
		dormitoryTrainingRecordDetailBottomDao.getDormitoryTrainingRecordDetailBottomByCondition(page, condition, reviewID);
		
		LigerUITools.writeGridJson(page, response);
	}
	

}
