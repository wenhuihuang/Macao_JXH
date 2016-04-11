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
import com.jxh.dao.ActivityRecordNewDao;
import com.jxh.dao.ActivitySettingDao;
import com.jxh.pojo.ActivityApplyPojo;
import com.jxh.pojo.ActivityRecordNewPojo;
import com.jxh.pojo.ActivitySettingPojo;
import com.jxh.utils.Constants;
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
	private ActivityRecordNewDao activityRecordNewDao = new ActivityRecordNewDao();
       
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
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException {
		// TODO Auto-generated method stub
		try {

			ActivitySetting activitySetting = new ActivitySetting();
			Date now = new Date();
			Timestamp time = Timestamp.valueOf(ToolsUtils.getDateStringByFormat(now, null, null));
			String ts= (time+"").replace("-", "");
			String actNO = "A"+ts.substring(0,8)+activitySettingDao.getActNO(Constants.NO);
			activitySetting.setActNO(actNO);
			
			request.setAttribute("activitySetting", activitySetting);
			forwardDispatcher("../jsp/manage/activity_edit.jsp", request, response);
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			ActivitySetting activitySetting = activitySettingDao.getActivitySettingByCondition(" and actID = ? ",
					this.getParameterByName(request, "actID"));
		
			request.setAttribute("activitySetting", activitySetting);
			
				forwardDispatcher("../jsp/manage/activity_edit.jsp",request,response);
			

		} catch (IOException | SQLException | ServletException e) {
			e.printStackTrace();
		}

	}

	private void getActivityApply(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String actId = this.getParameterByName(request, "actID");
		String type = this.getParameterByName(request, "type");
		PageUtils<ActivityApplyPojo> page = this.getPage(request);
		String condition = " and actID = ? and type = ? ";
			
		if("1".equals(type)){//會員
			activityApplyDao.getActivityApply1ByCondition(page, condition, actId,type);
		}else if("2".equals(type)){//非會員
			activityApplyDao.getActivityApply2ByCondition(page, condition, actId,type);
		}else if("3".equals(type)){//社工
			activityApplyDao.getActivityApply3ByCondition(page, condition, actId,type);
		}else{
			activityApplyDao.getActivityApplyByCondition(page, null);
		}
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getActivityRecordNew(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String actId = this.getParameterByName(request, "actID");
		PageUtils<ActivityRecordNew> page = this.getPage(request);
		String condition = " and actID = ? ";
		activityRecordNewDao.getActivityRecordNewByCondition(page, condition, actId);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<ActivityApplyPojo> memberDataAdds = getGridListByParamerName(ActivityApplyPojo.class, request, "memberDataAdds");
		List<ActivityApplyPojo> memberDataUpdates = getGridListByParamerName(ActivityApplyPojo.class, request, "memberDataUpdates");
		List<ActivityApplyPojo> memberDataDeletes = getGridListByParamerName(ActivityApplyPojo.class, request, "memberDataDeletes");
		System.out.println("memberDataAdds=="+memberDataAdds);
		if( !"".equals(memberDataAdds) && memberDataAdds != null){
			for(int i = 0;i<memberDataAdds.size();i++){
				 memberDataAdds.get(i).setType(1);
			 }
		}
	
		List<ActivityApplyPojo> notMemberDataAdds = getGridListByParamerName(ActivityApplyPojo.class, request, "notMemberDataAdds");
		List<ActivityApplyPojo> notMemberDataUpdates = getGridListByParamerName(ActivityApplyPojo.class, request, "notMemberDataUpdates");
		List<ActivityApplyPojo> notMemberDataDeletes = getGridListByParamerName(ActivityApplyPojo.class, request, "notMemberDataDeletes");
		if( !"".equals(notMemberDataAdds) && notMemberDataAdds != null ){
			for(int i = 0;i<notMemberDataAdds.size();i++){
				 notMemberDataAdds.get(i).setType(2);
			 }
		}
	
		List<ActivityApplyPojo> volunteerDataAdds = getGridListByParamerName(ActivityApplyPojo.class, request, "volunteerDataAdds");
		List<ActivityApplyPojo> volunteerDataUpdates = getGridListByParamerName(ActivityApplyPojo.class, request, "volunteerDataUpdates");
		List<ActivityApplyPojo> volunteerDataDeletes = getGridListByParamerName(ActivityApplyPojo.class, request, "volunteerDataDeletes");
		if( !"".equals(volunteerDataAdds) && volunteerDataAdds != null){
			for(int i = 0;i<volunteerDataAdds.size();i++){
				 volunteerDataAdds.get(i).setType(3);
			 }
		}
	
		
		List<ActivityRecordNew>  activityRecordNewAdds = getGridListByParamerName(ActivityRecordNew.class, request, "activityRecordNewAdds");
		List<ActivityRecordNew>  activityRecordNewUpdates = getGridListByParamerName(ActivityRecordNew.class, request, "activityRecordNewUpdates");
		List<ActivityRecordNew>  activityRecordNewDeletes = getGridListByParamerName(ActivityRecordNew.class, request, "activityRecordNewDeletes");
		ActivitySetting activitySetting = this.getObjectByParameter(request, ActivitySetting.class);
		String message = "";
		System.out.println(activityRecordNewUpdates);
			if (activitySetting.getActID() != null && !"".equals(activitySetting.getActID())) {
				message = activitySettingBiz.updateActivitySetting(activitySetting, memberDataAdds,memberDataUpdates,memberDataDeletes,notMemberDataAdds,notMemberDataUpdates,notMemberDataDeletes,volunteerDataAdds,volunteerDataUpdates,volunteerDataDeletes,activityRecordNewAdds,activityRecordNewUpdates,activityRecordNewDeletes);
			} else {
				message = activitySettingBiz.insertActivitySetting(activitySetting,memberDataAdds,notMemberDataAdds,volunteerDataAdds,activityRecordNewAdds);
			}
	

		// 设置为表单jsp
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
