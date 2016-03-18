package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.ActivitySettingDao;
import com.jxh.utils.Constants;
import com.jxh.vo.ActivityApply;
import com.jxh.vo.ActivityRecordNew;
import com.jxh.vo.ActivitySetting;

public class ActivitySettingBiz {

	private ActivitySettingDao activitySettingDao = new ActivitySettingDao();

	public String updateActivitySetting(ActivitySetting activitySetting, List<ActivityApply> activityApplyAdds,
			List<ActivityApply> activityApplyUpdates, List<ActivityApply> activityApplyDeletes,
			List<ActivityRecordNew> activityRecordNewAdds, List<ActivityRecordNew> activityRecordNewUpdates,
			List<ActivityRecordNew> activityRecordNewDeletes) {
		// TODO Auto-generated method stub
		return null;
	}

	public String insertActivitySetting(ActivitySetting activitySetting, List<ActivityApply> activityApplyAdds,
			List<ActivityRecordNew> activityRecordNewAdds) {

		String actID = activitySettingDao.getPrimaryKey(Constants.CORPID);
		activitySetting.setActID(actID);
		int row = activitySettingDao.insertActivitySetting(activitySetting);
		if (row > 0) {
			if (addActivityApply(activitySetting, activityApplyAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}

			if (addActivityRecordNew(activitySetting, activityRecordNewAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}

			if (addDormitoryTrainingRecord(dormitoryRecord, dormitoryTrainingRecord,
					dormitoryTrainingRecordDetailTopAdds, dormitoryTrainingRecordDetailBottomAdds) < 0) {
				throw new Exception("新增家庭成員資料失败！");
			}

			if (addDormitoryTrainingReview(dormitoryRecord, dormitoryTrainingReview, dormitoryTrainingReviewTargetAdds,
					dormitoryTrainingReviewFinanceAdds, dormitoryTrainingReviewSettleAdds,
					dormitoryTrainingReviewDetailAdds) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}

		}
		return "操作成功！";
	}

}
