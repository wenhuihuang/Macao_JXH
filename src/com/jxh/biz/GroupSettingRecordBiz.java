package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.utils.Constants;
import com.jxh.vo.GroupSetting;
import com.jxh.vo.GroupSettingBudget;
import com.jxh.vo.GroupSettingPlan;
import com.jxh.vo.GroupSettingRecord;
import com.jxh.vo.GroupSettingRecordBudget;
import com.jxh.vo.GroupSettingRecordPerformance;
import com.jxh.vo.GroupSettingRecordPlan;

public class GroupSettingRecordBiz {

	public String updateMedicalRecord(GroupSettingRecord groupSettingRecord, GroupSetting groupSetting,
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
			List<GroupSettingRecordPerformance> groupSettingRecordPerformanceDeletes) {
		// TODO Auto-generated method stub
		return null;
	}

	public String insertMedicalRecord(GroupSettingRecord groupSettingRecord, GroupSetting groupSetting,
			List<GroupSettingBudget> groupSettingBudgetAdds, List<GroupSettingPlan> groupSettingPlanAdds,
			List<GroupSettingRecordBudget> groupSettingRecordBudgetAdds,
			List<GroupSettingRecordPlan> groupSettingRecordPlanAdds,
			List<GroupSettingRecordPerformance> groupSettingRecordPerformanceAdds) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteGroupSettingRecordByRecordID(String recordID) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
