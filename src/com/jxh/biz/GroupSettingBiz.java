package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.GroupSettingBudgetDao;
import com.jxh.dao.GroupSettingDao;
import com.jxh.dao.GroupSettingPlanDao;
import com.jxh.dao.GroupSettingRecordBudgetDao;
import com.jxh.dao.GroupSettingRecordDao;
import com.jxh.dao.GroupSettingRecordPerformanceDao;
import com.jxh.dao.GroupSettingRecordPlanDao;
import com.jxh.utils.Constants;
import com.jxh.vo.GroupSetting;
import com.jxh.vo.GroupSettingBudget;
import com.jxh.vo.GroupSettingPlan;

public class GroupSettingBiz {
	private GroupSettingDao groupSettingDao = new GroupSettingDao();
	private GroupSettingBudgetDao groupSettingBudgetDao = new GroupSettingBudgetDao();
	private GroupSettingPlanDao groupSettingPlanDao = new GroupSettingPlanDao();

	public String updateGroupSetting(GroupSetting groupSetting,
			List<GroupSettingBudget> groupSettingBudgetAdds, List<GroupSettingBudget> groupSettingBudgetUpdates,
			List<GroupSettingBudget> groupSettingBudgetDeletes, List<GroupSettingPlan> groupSettingPlanAdds,
			List<GroupSettingPlan> groupSettingPlanUpdates, List<GroupSettingPlan> groupSettingPlanDeletes
			) throws Exception {
		int row = groupSettingDao.updateGroupSetting(groupSetting);
		if (row > 0) {

			
			if(addGroupSettingBudget(groupSetting, groupSettingBudgetAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(updateGroupSettingBudget(groupSetting, groupSettingBudgetUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(deleteGroupSettingBudget(groupSetting, groupSettingBudgetDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addGroupSettingPlan(groupSetting, groupSettingPlanAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(updateGroupSettingPlan(groupSetting, groupSettingPlanUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(deleteGroupSettingPlan(groupSetting, groupSettingPlanDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			
		
		}
		return "操作成功！";
	}




	private int deleteGroupSettingPlan(GroupSetting groupSetting,
			List<GroupSettingPlan> groupSettingPlanDeletes) throws IOException, SQLException {
		if (groupSettingPlanDeletes == null || groupSettingPlanDeletes.size() <= 0) {
			return 1;
		}
		return groupSettingPlanDao.deleteGroupSettingPlan(groupSettingPlanDeletes);
	}

	private int updateGroupSettingPlan(GroupSetting groupSetting,
			List<GroupSettingPlan> groupSettingPlanUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (groupSettingPlanUpdates == null || groupSettingPlanUpdates.size() <= 0) {
			return 1;
		}
		return groupSettingPlanDao.updateGroupSettingPlan(groupSettingPlanUpdates);
	}

	private int deleteGroupSettingBudget(GroupSetting groupSetting,
			List<GroupSettingBudget> groupSettingBudgetDeletes) throws IOException, SQLException {
		if (groupSettingBudgetDeletes == null || groupSettingBudgetDeletes.size() <= 0) {
			return 1;
		}
		return groupSettingBudgetDao.deleteGroupSettingBudget(groupSettingBudgetDeletes);
	}

	private int updateGroupSettingBudget(GroupSetting groupSetting,
			List<GroupSettingBudget> groupSettingBudgetUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (groupSettingBudgetUpdates == null || groupSettingBudgetUpdates.size() <= 0) {
			return 1;
		}
		return groupSettingBudgetDao.updateGroupSettingBudget(groupSettingBudgetUpdates);
	}

	public String insertGroupSetting(GroupSetting groupSetting,
			List<GroupSettingBudget> groupSettingBudgetAdds, List<GroupSettingPlan> groupSettingPlanAdds
			) throws Exception {

		String gSID = groupSettingDao.getPrimaryKey(Constants.CORPID);
		groupSetting.setgSID(gSID);
		int row = groupSettingDao.insertGroupSetting(groupSetting);
		if (row > 0) {
			
			if(addGroupSettingBudget(groupSetting, groupSettingBudgetAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addGroupSettingPlan(groupSetting, groupSettingPlanAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			
		}
		return "操作成功！";
	
	}




	private int addGroupSettingPlan(GroupSetting groupSetting,
			List<GroupSettingPlan> groupSettingPlanAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (groupSettingPlanAdds == null || groupSettingPlanAdds.size() <= 0) {
			return 1;
		}
		
		for (GroupSettingPlan update : groupSettingPlanAdds) {
			
			update.setgSID(groupSetting.getgSID());
		}
		
		int [] rows =groupSettingPlanDao.insertGroupSettingPlanBatch(groupSettingPlanAdds);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int addGroupSettingBudget(GroupSetting groupSetting,
			List<GroupSettingBudget> groupSettingBudgetAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (groupSettingBudgetAdds == null || groupSettingBudgetAdds.size() <= 0) {
			return 1;
		}
		
		for (GroupSettingBudget update : groupSettingBudgetAdds) {
			
			update.setgSID(groupSetting.getgSID());
		}
		
		int [] rows =groupSettingBudgetDao.insertGroupSettingBudgetBatch(groupSettingBudgetAdds);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}


	public boolean deleteGroupSettingByGSID(String gSID) throws Exception {
		boolean flag=false;
		int row = groupSettingDao.deleteGroupSettingByGSID(gSID);
			if (row > 0) {
				if (deleteGroupSettingPlanByGSID(gSID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				if (deleteGroupSettingBudgetByGSID(gSID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				
				flag=true;
				
			}
		return flag;
	}


	private int deleteGroupSettingPlanByGSID(String gSID) throws SQLException, IOException {
		return groupSettingPlanDao.deleteGroupSettingPlanByGSID(gSID);
	}

	private int deleteGroupSettingBudgetByGSID(String gSID) throws SQLException, IOException {
		return groupSettingBudgetDao.deleteGroupSettingBudgetByGSID(gSID);
	}


}
