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
import com.jxh.biz.GroupSettingBiz;
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
import com.jxh.pojo.GroupSettingPojo;
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
	private GroupSettingBiz groupSettingBiz = new GroupSettingBiz();
	private GroupSettingBudgetDao groupSettingBudgetDao = new GroupSettingBudgetDao();
	private GroupSettingPlanDao groupSettingPlanDao = new GroupSettingPlanDao();
	
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
		PageUtils<GroupSettingPojo> page = this.getPage(request);
		groupSettingDao.getGroupSettingPojo(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {

			GroupSetting groupSetting = new GroupSetting();

			request.setAttribute("groupSetting", groupSetting);
			forwardDispatcher("../jsp/manage/groupSetting_edit.jsp", request, response);
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			GroupSetting groupSetting = groupSettingDao.getGroupSettingByCondition(" and gSID = ? ",
					this.getParameterByName(request, "gSID"));
			request.setAttribute("groupSetting", groupSetting);
			
			forwardDispatcher("../jsp/manage/groupSetting_edit.jsp",request,response);
			

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
		

		GroupSetting groupSetting = this.getObjectByParameter(request, GroupSetting.class);
		
		String message = "";
		System.out.println("groupSettingPlanAdds="+groupSettingPlanAdds);
			if(groupSetting.getgSID() != null && !"".equals(groupSetting.getgSID())){
				message = groupSettingBiz.updateGroupSetting(groupSetting,groupSettingBudgetAdds,groupSettingBudgetUpdates,groupSettingBudgetDeletes,groupSettingPlanAdds,groupSettingPlanUpdates,groupSettingPlanDeletes);
			}else{
				message = groupSettingBiz.insertGroupSetting(groupSetting,groupSettingBudgetAdds,groupSettingPlanAdds);
			}
		
	

		// 设置为表单jsp
		request.setAttribute("msg", message);
		
		
		if (message.indexOf("成功") > 0) {
			sendRedirect("../jsp/manage/groupSetting_list.jsp", response);
		} else {
			request.setAttribute("groupSetting", groupSetting);
				forwardDispatcher("../jsp/manage/groupSetting_edit.jsp", request,response);
			
		}

	}
	
	private void deleteGroupSetting(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String gSID = request.getParameter("gSID");
		if(gSID != null && !"".equals(gSID)){
			flag = groupSettingBiz.deleteGroupSettingByGSID(gSID);
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
	
	private void getGroupSettingByGSID(HttpServletRequest request, HttpServletResponse response){
		String gSID = request.getParameter("gSID");
		try {
			//PageUtils<Customer> page = getPage(request);
			String condition = " and gSID ='"+gSID+"'";
			GroupSetting groupSetting = groupSettingDao.getGroupSettingByCondition(condition);
			 PrintWriter out = response.getWriter();  
		     out.write(JSONArray.fromObject(groupSetting).toString());  
			//LigerUITools.writeGridJson(page, response);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
