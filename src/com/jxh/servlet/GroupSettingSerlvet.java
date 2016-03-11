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
import com.jxh.biz.GroupSettingRecordBiz;
import com.jxh.dao.CustomerDao;
import com.jxh.dao.GroupSettingBudgetDao;
import com.jxh.dao.GroupSettingDao;
import com.jxh.dao.GroupSettingPlanDao;
import com.jxh.dao.GroupSettingRecordBudgetDao;
import com.jxh.dao.GroupSettingRecordDao;
import com.jxh.dao.GroupSettingRecordPerformanceDao;
import com.jxh.dao.GroupSettingRecordPlanDao;
import com.jxh.pojo.Customer;
import com.jxh.pojo.GroupSettingRecordPojo;
import com.jxh.vo.BCustomer;
import com.jxh.vo.GroupSetting;
import com.jxh.vo.GroupSettingBudget;
import com.jxh.vo.GroupSettingPlan;
import com.jxh.vo.GroupSettingRecord;
import com.jxh.vo.GroupSettingRecordBudget;
import com.jxh.vo.GroupSettingRecordPerformance;
import com.jxh.vo.GroupSettingRecordPlan;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/GroupSetting/*")
public class GroupSettingSerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao = new CustomerDao();
	private GroupSettingRecordDao groupSettingRecordDao = new GroupSettingRecordDao();
	private GroupSettingRecordBiz groupSettingRecordBiz = new GroupSettingRecordBiz();
	private GroupSettingBudgetDao groupSettingBudgetDao = new GroupSettingBudgetDao();
	private GroupSettingPlanDao groupSettingPlanDao = new GroupSettingPlanDao();
	private GroupSettingRecordBudgetDao groupSettingRecordBudgetDao = new GroupSettingRecordBudgetDao();
	private GroupSettingRecordPlanDao groupSettingRecordPlanDao = new GroupSettingRecordPlanDao();
	private GroupSettingRecordPerformanceDao groupSettingRecordPerformanceDao = new GroupSettingRecordPerformanceDao();
	
	private GroupSettingDao groupSettingDao = new GroupSettingDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupSettingSerlvet() {
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
		PageUtils<GroupSettingRecordPojo> page = this.getPage(request);
		groupSettingDao.getGroupSettingPojo(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {

			GroupSettingRecord groupSettingRecord = new GroupSettingRecord();

			request.setAttribute("groupSettingRecord", groupSettingRecord);
			forwardDispatcher("../jsp/manage/groupRecord_edit.jsp", request, response);
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			BCustomer customer = customerDao.getCustomerByCondition(" and custId = ? ",
					this.getParameterByName(request, "custID"));
			GroupSettingRecord groupSettingRecord = groupSettingRecordDao.getGroupSettingRecordByCondition(" and recordID = ? ",
					this.getParameterByName(request, "recordID"));
		
			request.setAttribute("customer", customer);
			request.setAttribute("groupSettingRecord", groupSettingRecord);
			
			forwardDispatcher("../jsp/manage/groupRecord_edit.jsp",request,response);
			

		} catch (IOException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<GroupSettingBudget> groupSettingBudgetAdds = getGridListByParamerName(GroupSettingBudget.class, request, "groupSettingBudgetAdds");
		List<GroupSettingBudget> groupSettingBudgetUpdates = getGridListByParamerName(GroupSettingBudget.class, request, "groupSettingBudgetUpdates");
		List<GroupSettingBudget> groupSettingBudgetDeletes = getGridListByParamerName(GroupSettingBudget.class, request, "groupSettingBudgetDeletes");
		
		List<GroupSettingPlan> groupSettingPlanAdds = getGridListByParamerName(GroupSettingPlan.class, request, "groupSettingPlanAdds");
		List<GroupSettingPlan> groupSettingPlanUpdates = getGridListByParamerName(GroupSettingPlan.class, request, "groupSettingPlanUpdates");
		List<GroupSettingPlan> groupSettingPlanDeletes = getGridListByParamerName(GroupSettingPlan.class, request, "groupSettingPlanDeletes");
		
		List<GroupSettingRecordBudget> groupSettingRecordBudgetAdds = getGridListByParamerName(GroupSettingRecordBudget.class, request, "groupSettingRecordBudgetAdds");
		List<GroupSettingRecordBudget> groupSettingRecordBudgetUpdates = getGridListByParamerName(GroupSettingRecordBudget.class, request, "groupSettingRecordBudgetUpdates");
		List<GroupSettingRecordBudget> groupSettingRecordBudgetDeletes = getGridListByParamerName(GroupSettingRecordBudget.class, request, "groupSettingRecordBudgetDeletes");
		
		List<GroupSettingRecordPlan> groupSettingRecordPlanAdds = getGridListByParamerName(GroupSettingRecordPlan.class, request, "groupSettingRecordPlanAdds");
		List<GroupSettingRecordPlan> groupSettingRecordPlanUpdates = getGridListByParamerName(GroupSettingRecordPlan.class, request, "groupSettingRecordPlanUpdates");
		List<GroupSettingRecordPlan> groupSettingRecordPlanDeletes = getGridListByParamerName(GroupSettingRecordPlan.class, request, "groupSettingRecordPlanDeletes");
		
		List<GroupSettingRecordPerformance> groupSettingRecordPerformanceAdds = getGridListByParamerName(GroupSettingRecordPerformance.class, request, "groupSettingRecordPerformanceAdds");
		List<GroupSettingRecordPerformance> groupSettingRecordPerformanceUpdates = getGridListByParamerName(GroupSettingRecordPerformance.class, request, "groupSettingRecordPerformanceUpdates");
		List<GroupSettingRecordPerformance> groupSettingRecordPerformanceDeletes = getGridListByParamerName(GroupSettingRecordPerformance.class, request, "groupSettingRecordPerformanceDeletes");
		

		GroupSettingRecord groupSettingRecord = this.getObjectByParameter(request, GroupSettingRecord.class);
		GroupSetting groupSetting = this.getObjectByParameter(request, GroupSetting.class);
		
		String message = "";
		
			if(groupSettingRecord.getRecordID() != null && !"".equals(groupSettingRecord.getRecordID())){
				message = groupSettingRecordBiz.updateGroupSettingRecord(groupSettingRecord, groupSetting,groupSettingBudgetAdds,groupSettingBudgetUpdates,groupSettingBudgetDeletes,groupSettingPlanAdds,groupSettingPlanUpdates,groupSettingPlanDeletes,groupSettingRecordBudgetAdds,groupSettingRecordBudgetUpdates,groupSettingRecordBudgetDeletes,groupSettingRecordPlanAdds,groupSettingRecordPlanUpdates,groupSettingRecordPlanDeletes,groupSettingRecordPerformanceAdds,groupSettingRecordPerformanceUpdates,groupSettingRecordPerformanceDeletes);
			}else{
				message = groupSettingRecordBiz.insertGroupSettingRecord(groupSettingRecord, groupSetting,groupSettingBudgetAdds,groupSettingPlanAdds,groupSettingRecordBudgetAdds,groupSettingRecordPlanAdds,groupSettingRecordPerformanceAdds);
			}
		
	

		// 设置为表单jsp
		request.setAttribute("msg", message);
		
		
		if (message.indexOf("成功") > 0) {
			sendRedirect("../jsp/manage/groupRecord_list.jsp", response);
		} else {
			request.setAttribute("groupSettingRecord", groupSettingRecord);
				forwardDispatcher("../jsp/manage/groupRecord_edit.jsp", request,response);
			
		}

	}
	
	private void deleteGroupSettingRecord(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String recordID = request.getParameter("recordID");
		if(recordID != null && !"".equals(recordID)){
			flag = groupSettingRecordBiz.deleteGroupSettingRecordByRecordID(recordID);
		}
		response.getWriter().print(flag);
	}

	private void getGroupSettingBudget(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String recordID = this.getParameterByName(request, "gSID");
		PageUtils<GroupSettingBudget> page = this.getPage(request);
		String condition = " and gSID = ? ";
		groupSettingBudgetDao.getGroupSettingBudgetByCondition(page, condition, recordID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getGroupSettingPlan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String recordID = this.getParameterByName(request, "gSID");
		PageUtils<GroupSettingPlan> page = this.getPage(request);
		String condition = " and gSID = ? ";
		groupSettingPlanDao.getGroupSettingPlanByCondition(page, condition, recordID);
		
		LigerUITools.writeGridJson(page, response);
	}
	private void getGroupSettingRecordBudget(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String recordID = this.getParameterByName(request, "recordID");
		PageUtils<GroupSettingRecordBudget> page = this.getPage(request);
		String condition = " and recordID = ? ";
		groupSettingRecordBudgetDao.getGroupSettingRecordBudgetByCondition(page, condition, recordID);
		
		LigerUITools.writeGridJson(page, response);
	}
	private void getGroupSettingRecordPlan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String recordID = this.getParameterByName(request, "recordID");
		PageUtils<GroupSettingRecordPlan> page = this.getPage(request);
		String condition = " and recordID = ? ";
		groupSettingRecordPlanDao.getGroupSettingRecordPlanByCondition(page, condition, recordID);
		
		LigerUITools.writeGridJson(page, response);
	}
	private void getGroupSettingRecordPerformance(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String recordID = this.getParameterByName(request, "recordID");
		PageUtils<GroupSettingRecordPerformance> page = this.getPage(request);
		String condition = " and recordID = ? ";
		groupSettingRecordPerformanceDao.getGroupSettingRecordPerformanceByCondition(page, condition, recordID);
		
		LigerUITools.writeGridJson(page, response);
	}
}
