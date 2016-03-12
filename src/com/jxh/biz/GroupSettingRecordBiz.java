package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.GroupSettingRecordBudgetDao;
import com.jxh.dao.GroupSettingRecordDao;
import com.jxh.dao.GroupSettingRecordPerformanceDao;
import com.jxh.dao.GroupSettingRecordPlanDao;
import com.jxh.utils.Constants;
import com.jxh.vo.GroupSettingRecord;
import com.jxh.vo.GroupSettingRecordBudget;
import com.jxh.vo.GroupSettingRecordPerformance;
import com.jxh.vo.GroupSettingRecordPlan;

public class GroupSettingRecordBiz {
	private GroupSettingRecordDao groupSettingRecordDao = new GroupSettingRecordDao();
	private GroupSettingRecordBudgetDao groupSettingRecordBudgetDao = new GroupSettingRecordBudgetDao();
	private GroupSettingRecordPlanDao groupSettingRecordPlanDao = new GroupSettingRecordPlanDao();
	private GroupSettingRecordPerformanceDao groupSettingRecordPerformanceDao = new GroupSettingRecordPerformanceDao();

	public String updateGroupSettingRecord(GroupSettingRecord groupSettingRecord,
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



	public String insertGroupSettingRecord(GroupSettingRecord groupSettingRecord,
			List<GroupSettingRecordBudget> groupSettingRecordBudgetAdds,
			List<GroupSettingRecordPlan> groupSettingRecordPlanAdds,
			List<GroupSettingRecordPerformance> groupSettingRecordPerformanceAdds) throws Exception {

		String recordID = groupSettingRecordDao.getPrimaryKey(Constants.CORPID);
		groupSettingRecord.setRecordID(recordID);
		int row = groupSettingRecordDao.insertGroupSettingRecord(groupSettingRecord);
		if (row > 0) {
			
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


	public boolean deleteGroupSettingRecordByRecordID(String recordID) throws Exception {
		boolean flag=false;
		int row = groupSettingRecordDao.deleteGroupSettingRecordByRecordID(recordID);
			if (row > 0) {
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
