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
import com.jxh.biz.ActivitySettingBiz;
import com.jxh.dao.ActivityApplyDao;
import com.jxh.dao.ActivitySettingDao;
import com.jxh.pojo.ActivitySettingPojo;
import com.jxh.vo.ActivityApply;
import com.jxh.vo.ActivityRecordNew;
import com.jxh.vo.ActivitySetting;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/Activity/*")
public class ActivitySerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
	private ActivitySettingDao activitySettingDao = new ActivitySettingDao();
	private ActivityApplyDao activityApplyDao = new ActivityApplyDao();
	private ActivitySettingBiz activitySettingBiz = new ActivitySettingBiz();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivitySerlvet() {
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
		PageUtils<ActivitySettingPojo> page = this.getPage(request);
		activitySettingDao.getActivitySettingPojo(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {

			ActivitySetting activitySetting = new ActivitySetting();

			request.setAttribute("activitySetting", activitySetting);
			forwardDispatcher("../jsp/manage/activity_edit.jsp", request, response);
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			ActivitySetting activitySetting = activitySettingDao.getActivitySettingByCondition(" and custID = ? ",
					this.getParameterByName(request, "actID"));
		
			request.setAttribute("activitySetting", activitySetting);
			
				forwardDispatcher("../jsp/manage/activity_edit.jsp",request,response);
			

		} catch (IOException | SQLException | ServletException e) {
			e.printStackTrace();
		}

	}

	private void getActivityApply(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String actId = this.getParameterByName(request, "actID");
		PageUtils<ActivityApply> page = this.getPage(request);
		String condition = " and actID = ? ";
		activityApplyDao.getActivityApplyByCondition(page, condition, actId);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		List<ActivityApply> activityApplyAdds = getGridListByParamerName(ActivityApply.class, request, "activityApplyAdds");
		List<ActivityApply> activityApplyUpdates = getGridListByParamerName(ActivityApply.class, request, "activityApplyUpdates");
		List<ActivityApply> activityApplyDeletes = getGridListByParamerName(ActivityApply.class, request, "activityApplyDeletes");
		
		
		List<ActivityRecordNew>  activityRecordNewAdds = getGridListByParamerName(ActivityRecordNew.class, request, "activityRecordNewAdds");
		List<ActivityRecordNew>  activityRecordNewUpdates = getGridListByParamerName(ActivityRecordNew.class, request, "activityRecordNewUpdates");
		List<ActivityRecordNew>  activityRecordNewDeletes = getGridListByParamerName(ActivityRecordNew.class, request, "activityRecordNewDeletes");

		ActivitySetting activitySetting = this.getObjectByParameter(request, ActivitySetting.class);
		String message = "";
		
			if (activitySetting.getActID() != null && !"".equals(activitySetting.getActID())) {
				message = activitySettingBiz.updateActivitySetting(activitySetting, activityApplyAdds,activityApplyUpdates,activityApplyDeletes,activityRecordNewAdds,activityRecordNewUpdates,activityRecordNewDeletes);
			} else {
				message = activitySettingBiz.insertActivitySetting(activitySetting,activityApplyAdds,activityRecordNewAdds);
			}
	

		// 设置为表单jsp
		request.setAttribute(JSPTYPE, ConstantUtils.FORMJSP);
		request.setAttribute("msg", message);
		

		if (message.indexOf("成功") > 0) {
			sendRedirect("../jsp/manage/activity_list.jsp", response);
			
		} else {
			request.setAttribute("activitySetting", activitySetting);
			forwardDispatcher("../jsp/manage/activity_edit.jsp", request,response);
			
		}

	}
	
	private void deleteActivity(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String actID = request.getParameter("actID");
		if(actID != null && !"".equals(actID)){
			flag = activitySettingBiz.deleteActivityByActID(actID);
		}
		response.getWriter().print(flag);
	}

}
