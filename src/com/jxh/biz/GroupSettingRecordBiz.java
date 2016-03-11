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
import com.jxh.vo.GroupSettingRecord;
import com.jxh.vo.GroupSettingRecordBudget;
import com.jxh.vo.GroupSettingRecordPerformance;
import com.jxh.vo.GroupSettingRecordPlan;
import com.jxh.vo.MedicalRecordView;

public class GroupSettingRecordBiz {
	private GroupSettingRecordDao groupSettingRecordDao = new GroupSettingRecordDao();
	private GroupSettingBudgetDao groupSettingBudgetDao = new GroupSettingBudgetDao();
	private GroupSettingPlanDao groupSettingPlanDao = new GroupSettingPlanDao();
	private GroupSettingRecordBudgetDao groupSettingRecordBudgetDao = new GroupSettingRecordBudgetDao();
	private GroupSettingRecordPlanDao groupSettingRecordPlanDao = new GroupSettingRecordPlanDao();
	private GroupSettingRecordPerformanceDao groupSettingRecordPerformanceDao = new GroupSettingRecordPerformanceDao();
	private GroupSettingDao groupSettingDao = new GroupSettingDao();

	public String updateGroupSettingRecord(GroupSettingRecord groupSettingRecord, GroupSetting groupSetting,
			List<GroupSettingBudget> groupSettingBudgetAdds, List<GroupSettingBudget> groupSettingBudgetUpdates,
			List<GroupSettingBudget> groupSettingBudgetDeletes, List<GroupSettingPlan> groupSettingPlanAdds,
			List<GroupSettingPlan> groupSettingPlanUpdates, List<GroupSettingPlan> groupSettingPlanDeletes,
			List<GroupSettingRecordBudget> groupSettingRecordBudgetAdds,
			List<GroupSettingRecordBudget> groupSettingRecordBudgetUpdates,
			List<GroupSettingRecordBudget> groupSettingRecordBudgetDeletes,
			List<GroupSettingRecordPlan> groupSettingRecordPlanAdds,
			List<GroupSettingRecordPlan> groupSettingRecordPlanUpdates,
			List<GroupSettingRecordPlan> groupSettingRecordPlanDeletes,
			List<GroupSettingRecordPerformance> groupSettingRecordPerformanceAdds,
			List<GroupSettingRecordPerformance> groupSettingRecordPerformanceUpdates,
			List<GroupSettingRecordPerformance> groupSettingRecordPerformanceDeletes) throws Exception {
		int row = groupSettingRecordDao.updateGroupSettingRecord(groupSettingRecord);
		if (row > 0) {

			//
			if(updateGroupSetting(groupSettingRecord, groupSetting)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addGroupSettingBudget(groupSettingRecord, groupSettingBudgetAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(updateGroupSettingBudget(groupSettingRecord, groupSettingBudgetUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(deleteGroupSettingBudget(groupSettingRecord, groupSettingBudgetDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addGroupSettingPlan(groupSettingRecord, groupSettingPlanAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(updateGroupSettingPlan(groupSettingRecord, groupSettingPlanUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(deleteGroupSettingPlan(groupSettingRecord, groupSettingPlanDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			//
			if (addGroupSettingRecordBudget(groupSettingRecord, groupSettingRecordBudgetAdds) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			if (updateGroupSettingRecordBudget(groupSettingRecord, groupSettingRecordBudgetUpdates) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			if (deleteGroupSettingRecordBudget(groupSettingRecord, groupSettingRecordBudgetDeletes) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			if (addGroupSettingRecordPlan(groupSettingRecord, groupSettingRecordPlanAdds) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			if (updateGroupSettingRecordPlan(groupSettingRecord, groupSettingRecordPlanUpdates) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			if (deleteGroupSettingRecordPlan(groupSettingRecord, groupSettingRecordPlanDeletes) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			if (addGroupSettingRecordPerformance(groupSettingRecord, groupSettingRecordPerformanceAdds) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			if (updateGroupSettingRecordPerformance(groupSettingRecord, groupSettingRecordPerformanceUpdates) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			if (deleteGroupSettingRecordPerformance(groupSettingRecord, groupSettingRecordPerformanceDeletes) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
		
		}
		return "操作成功！";
	}

	private int deleteGroupSettingRecordPerformance(GroupSettingRecord groupSettingRecord,
			List<GroupSettingRecordPerformance> groupSettingRecordPerformanceDeletes) throws IOException, SQLException {
		if (groupSettingRecordPerformanceDeletes == null || groupSettingRecordPerformanceDeletes.size() <= 0) {
			return 1;
		}
		return groupSettingRecordPerformanceDao.deleteGroupSettingRecordPerformance(groupSettingRecordPerformanceDeletes);
	}

	private int updateGroupSettingRecordPerformance(GroupSettingRecord groupSettingRecord,
			List<GroupSettingRecordPerformance> groupSettingRecordPerformanceUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (groupSettingRecordPerformanceUpdates == null || groupSettingRecordPerformanceUpdates.size() <= 0) {
			return 1;
		}
		return groupSettingRecordPerformanceDao.updateGroupSettingRecordPerformance(groupSettingRecordPerformanceUpdates);
	}

	private int deleteGroupSettingRecordPlan(GroupSettingRecord groupSettingRecord,
			List<GroupSettingRecordPlan> groupSettingRecordPlanDeletes) throws IOException, SQLException {
		if (groupSettingRecordPlanDeletes == null || groupSettingRecordPlanDeletes.size() <= 0) {
			return 1;
		}
		return groupSettingRecordPlanDao.deleteGroupSettingRecordPlan(groupSettingRecordPlanDeletes);
	}

	private int updateGroupSettingRecordPlan(GroupSettingRecord groupSettingRecord,
			List<GroupSettingRecordPlan> groupSettingRecordPlanUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (groupSettingRecordPlanUpdates == null || groupSettingRecordPlanUpdates.size() <= 0) {
			return 1;
		}
		return groupSettingRecordPlanDao.updateGroupSettingRecordPlan(groupSettingRecordPlanUpdates);
	}

	private int deleteGroupSettingRecordBudget(GroupSettingRecord groupSettingRecord,
			List<GroupSettingRecordBudget> groupSettingRecordBudgetDeletes) throws IOException, SQLException {
		if (groupSettingRecordBudgetDeletes == null || groupSettingRecordBudgetDeletes.size() <= 0) {
			return 1;
		}
		return groupSettingRecordBudgetDao.deleteGroupSettingRecordBudget(groupSettingRecordBudgetDeletes);
	}

	private int updateGroupSettingRecordBudget(GroupSettingRecord groupSettingRecord,
			List<GroupSettingRecordBudget> groupSettingRecordBudgetUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (groupSettingRecordBudgetUpdates == null || groupSettingRecordBudgetUpdates.size() <= 0) {
			return 1;
		}
		return groupSettingRecordBudgetDao.updateGroupSettingRecordBudget(groupSettingRecordBudgetUpdates);
	}

	private int deleteGroupSettingPlan(GroupSettingRecord groupSettingRecord,
			List<GroupSettingPlan> groupSettingPlanDeletes) throws IOException, SQLException {
		if (groupSettingPlanDeletes == null || groupSettingPlanDeletes.size() <= 0) {
			return 1;
		}
		return groupSettingPlanDao.deleteGroupSettingPlan(groupSettingPlanDeletes);
	}

	private int updateGroupSettingPlan(GroupSettingRecord groupSettingRecord,
			List<GroupSettingPlan> groupSettingPlanUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (groupSettingPlanUpdates == null || groupSettingPlanUpdates.size() <= 0) {
			return 1;
		}
		return groupSettingPlanDao.updateGroupSettingPlan(groupSettingPlanUpdates);
	}

	private int deleteGroupSettingBudget(GroupSettingRecord groupSettingRecord,
			List<GroupSettingBudget> groupSettingBudgetDeletes) throws IOException, SQLException {
		if (groupSettingBudgetDeletes == null || groupSettingBudgetDeletes.size() <= 0) {
			return 1;
		}
		return groupSettingBudgetDao.deleteGroupSettingBudget(groupSettingBudgetDeletes);
	}

	private int updateGroupSettingBudget(GroupSettingRecord groupSettingRecord,
			List<GroupSettingBudget> groupSettingBudgetUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (groupSettingBudgetUpdates == null || groupSettingBudgetUpdates.size() <= 0) {
			return 1;
		}
		return groupSettingBudgetDao.updateGroupSettingBudget(groupSettingBudgetUpdates);
	}

	private int updateGroupSetting(GroupSettingRecord groupSettingRecord, GroupSetting groupSetting) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		return groupSettingDao.updateGroupSetting(groupSetting);
	}

	public String insertGroupSettingRecord(GroupSettingRecord groupSettingRecord, GroupSetting groupSetting,
			List<GroupSettingBudget> groupSettingBudgetAdds, List<GroupSettingPlan> groupSettingPlanAdds,
			List<GroupSettingRecordBudget> groupSettingRecordBudgetAdds,
			List<GroupSettingRecordPlan> groupSettingRecordPlanAdds,
			List<GroupSettingRecordPerformance> groupSettingRecordPerformanceAdds) throws Exception {

		String recordID = groupSettingRecordDao.getPrimaryKey(Constants.CORPID);
		groupSettingRecord.setRecordID(recordID);
		int row = groupSettingRecordDao.insertGroupSettingRecord(groupSettingRecord);
		if (row > 0) {
			//
			if(addGroupSetting(groupSettingRecord, groupSetting)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addGroupSettingBudget(groupSettingRecord, groupSettingBudgetAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addGroupSettingPlan(groupSettingRecord, groupSettingPlanAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			//
			if (addGroupSettingRecordBudget(groupSettingRecord, groupSettingRecordBudgetAdds) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			if (addGroupSettingRecordPlan(groupSettingRecord, groupSettingRecordPlanAdds) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			if (addGroupSettingRecordPerformance(groupSettingRecord, groupSettingRecordPerformanceAdds) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
		}
		return "操作成功！";
	
	}

	private int addGroupSettingRecordPerformance(GroupSettingRecord groupSettingRecord,
			List<GroupSettingRecordPerformance> groupSettingRecordPerformanceAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (groupSettingRecordPerformanceAdds == null || groupSettingRecordPerformanceAdds.size() <= 0) {
			return 1;
		}
		
		for (GroupSettingRecordPerformance update : groupSettingRecordPerformanceAdds) {
			
			update.setRecordID(groupSettingRecord.getRecordID());
		}
		
		int [] rows = groupSettingRecordPerformanceDao.insertGroupSettingRecordPerformanceBatch(groupSettingRecordPerformanceAdds);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int addGroupSettingRecordPlan(GroupSettingRecord groupSettingRecord,
			List<GroupSettingRecordPlan> groupSettingRecordPlanAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (groupSettingRecordPlanAdds == null || groupSettingRecordPlanAdds.size() <= 0) {
			return 1;
		}
		
		for (GroupSettingRecordPlan update : groupSettingRecordPlanAdds) {
			
			update.setRecordID(groupSettingRecord.getRecordID());
		}
		
		int [] rows =groupSettingRecordPlanDao.insertGroupSettingRecordPlanBatch(groupSettingRecordPlanAdds);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int addGroupSettingRecordBudget(GroupSettingRecord groupSettingRecord,
			List<GroupSettingRecordBudget> groupSettingRecordBudgetAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (groupSettingRecordBudgetAdds == null || groupSettingRecordBudgetAdds.size() <= 0) {
			return 1;
		}
		
		for (GroupSettingRecordBudget update : groupSettingRecordBudgetAdds) {
			
			update.setRecordID(groupSettingRecord.getRecordID());
		}
		
		int [] rows =groupSettingRecordBudgetDao.insertGroupSettingRecordBudgetBatch(groupSettingRecordBudgetAdds);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int addGroupSettingPlan(GroupSettingRecord groupSettingRecord,
			List<GroupSettingPlan> groupSettingPlanAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (groupSettingPlanAdds == null || groupSettingPlanAdds.size() <= 0) {
			return 1;
		}
		
		for (GroupSettingPlan update : groupSettingPlanAdds) {
			
			update.setgSID(groupSettingRecord.getgSID());
		}
		
		int [] rows =groupSettingPlanDao.insertGroupSettingPlanBatch(groupSettingPlanAdds);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int addGroupSettingBudget(GroupSettingRecord groupSettingRecord,
			List<GroupSettingBudget> groupSettingBudgetAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (groupSettingBudgetAdds == null || groupSettingBudgetAdds.size() <= 0) {
			return 1;
		}
		
		for (GroupSettingBudget update : groupSettingBudgetAdds) {
			
			update.setgSID(groupSettingRecord.getgSID());
		}
		
		int [] rows =groupSettingBudgetDao.insertGroupSettingBudgetBatch(groupSettingBudgetAdds);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int addGroupSetting(GroupSettingRecord groupSettingRecord, GroupSetting groupSetting) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException {
		String gSID = groupSettingDao.getPrimaryKey(Constants.CORPID);
		if (groupSetting == null || "".equals(groupSetting)) {
			return 1;
		}

		groupSetting.setgSID(gSID);
		int row = groupSettingDao.insertGroupSetting(groupSetting);
		if(row > 0 ){
			
		}
		return 1;
	}

	public boolean deleteGroupSettingRecordByRecordID(String recordID) throws Exception {
		boolean flag=false;
		int row = groupSettingRecordDao.deleteGroupSettingRecordByRecordID(recordID);
			if (row > 0) {
				if (deleteGroupSettingByRecordID(recordID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				if (deleteGroupSettingPlanByRecordID(recordID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				if (deleteGroupSettingBudgetByRecordID(recordID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				if (deleteGroupSettingRecordPlanByRecordID(recordID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				if (deleteGroupSettingRecordBudgetByRecordID(recordID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				if (deleteGroupSettingRecordPerformanceByRecordID(recordID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				
				
				
				
				
				flag=true;
				
			}
		return flag;
	}

	private int deleteGroupSettingByRecordID(String recordID) throws SQLException, IOException {
		return groupSettingDao.deleteGroupSettingByRecordID(recordID);
	}

	private int deleteGroupSettingPlanByRecordID(String recordID) throws SQLException, IOException {
		return groupSettingPlanDao.deleteGroupSettingPlanByRecordID(recordID);
	}

	private int deleteGroupSettingBudgetByRecordID(String recordID) throws SQLException, IOException {
		return groupSettingBudgetDao.deleteGroupSettingBudgetByRecordID(recordID);
	}

	private int deleteGroupSettingRecordPlanByRecordID(String recordID) throws SQLException, IOException {
		return groupSettingRecordPlanDao.deleteGroupSettingRecordPlanByRecordID(recordID);
	}

	private int deleteGroupSettingRecordBudgetByRecordID(String recordID) throws SQLException, IOException {
		return groupSettingRecordBudgetDao.deleteGroupSettingRecordBudgetByRecordID(recordID);
	}

	private int deleteGroupSettingRecordPerformanceByRecordID(String recordID) throws SQLException, IOException {
		return groupSettingRecordPerformanceDao.deleteGroupSettingRecordPerformanceByRecordID(recordID);
	}
	
}
