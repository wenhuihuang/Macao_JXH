package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.ActivityApplyDao;
import com.jxh.dao.ActivityRecordNewDao;
import com.jxh.dao.ActivitySettingDao;
import com.jxh.pojo.ActivityApplyPojo;
import com.jxh.utils.Constants;
import com.jxh.vo.ActivityApply;
import com.jxh.vo.ActivityRecordNew;
import com.jxh.vo.ActivitySetting;
import com.jxh.vo.CarRecord;
import com.jxh.vo.MedicalRecordView;

public class ActivitySettingBiz {

	private ActivitySettingDao activitySettingDao = new ActivitySettingDao();
	private ActivityRecordNewDao activityRecordNewDao = new ActivityRecordNewDao();
	private ActivityApplyDao activityApplyDao = new ActivityApplyDao();

	public String updateActivitySetting(ActivitySetting activitySetting, List<ActivityApplyPojo> activityApplyAdds,
			List<ActivityApplyPojo> activityApplyUpdates, List<ActivityApplyPojo> activityApplyDeletes,
			List<ActivityApplyPojo> notMemberDataAdds, List<ActivityApplyPojo> notMemberDataUpdates,
			List<ActivityApplyPojo> notMemberDataDeletes, List<ActivityApplyPojo> volunteerDataAdds,
			List<ActivityApplyPojo> volunteerDataUpdates, List<ActivityApplyPojo> volunteerDataDeletes,
			List<ActivityRecordNew> activityRecordNewAdds, List<ActivityRecordNew> activityRecordNewUpdates,
			List<ActivityRecordNew> activityRecordNewDeletes) throws Exception {
		int row = activitySettingDao.updateActivitySetting(activitySetting);
		if (row > 0) {
			//
			if (addActivityApply(activitySetting, activityApplyAdds) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (updateActivityApply(activitySetting, activityApplyUpdates) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (deleteActivityApply(activitySetting, activityApplyDeletes) < 0) {
				throw new Exception("新增個案撮要失败！");
			}
			
			if (addActivityApply(activitySetting, notMemberDataAdds) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (updateActivityApply(activitySetting, notMemberDataUpdates) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (deleteActivityApply(activitySetting, notMemberDataDeletes) < 0) {
				throw new Exception("新增個案撮要失败！");
			}
			
			if (addActivityApply(activitySetting, volunteerDataAdds) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (updateActivityApply(activitySetting, volunteerDataUpdates) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (deleteActivityApply(activitySetting, volunteerDataDeletes) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			//
			if (addActivityRecordNew(activitySetting, activityRecordNewAdds) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}

			if (updateActivityRecordNew(activitySetting, activityRecordNewUpdates) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			if (deleteActivityRecordNew(activitySetting, activityRecordNewDeletes) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
		}
		return "操作成功！";
	}

	private int deleteActivityRecordNew(ActivitySetting activitySetting,
			List<ActivityRecordNew> activityRecordNewDeletes) throws IOException, SQLException {
		if (activityRecordNewDeletes == null || activityRecordNewDeletes.size() <= 0) {
			return 1;
		}
		return activityRecordNewDao.deleteActivityRecordNew(activityRecordNewDeletes);
	}

	private int updateActivityRecordNew(ActivitySetting activitySetting,
			List<ActivityRecordNew> activityRecordNewUpdates) throws NoSuchFieldException, SecurityException,
					IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (activityRecordNewUpdates == null || activityRecordNewUpdates.size() <= 0) {
			return 1;
		}

		for (ActivityRecordNew update : activityRecordNewUpdates) {

			update.setActID(activitySetting.getActID());
		}

		return activityRecordNewDao.updateActivityRecordNewBatch(activityRecordNewUpdates);

	}

	private int deleteActivityApply(ActivitySetting activitySetting, List<ActivityApplyPojo> activityApplyDeletes)
			throws IOException, SQLException {
		if (activityApplyDeletes == null || activityApplyDeletes.size() <= 0) {
			return 1;
		}
		return activityApplyDao.deleteActivityApply(activityApplyDeletes);
	}

	private int updateActivityApply(ActivitySetting activitySetting, List<ActivityApplyPojo> activityApplyUpdates)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
			SQLException, ParseException, IOException {
		if (activityApplyUpdates == null || activityApplyUpdates.size() <= 0) {
			return 1;
		}

		for (ActivityApplyPojo update : activityApplyUpdates) {

			update.setActID(activitySetting.getActID());
		}

		int[] rows = activityApplyDao.updateActivityApplyBatch(activityApplyUpdates);

		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	public String insertActivitySetting(ActivitySetting activitySetting, List<ActivityApplyPojo> activityApplyAdds,
			List<ActivityApplyPojo> notMemberDataAdds, List<ActivityApplyPojo> volunteerDataAdds,
			List<ActivityRecordNew> activityRecordNewAdds) throws Exception {

		String actID = activitySettingDao.getPrimaryKey(Constants.CORPID);
		activitySetting.setActID(actID);
		int row = activitySettingDao.insertActivitySetting(activitySetting);
		if (row > 0) {
			if (addActivityApply(activitySetting, activityApplyAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			if (addActivityApply(activitySetting, notMemberDataAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			if (addActivityApply(activitySetting, volunteerDataAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}

			if (addActivityRecordNew(activitySetting, activityRecordNewAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}

		}
		return "操作成功！";
	}

	private int addActivityRecordNew(ActivitySetting activitySetting, List<ActivityRecordNew> activityRecordNewAdds)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
			SQLException, ParseException, IOException {
		if (activityRecordNewAdds == null || activityRecordNewAdds.size() <= 0) {
			return 1;
		}

		for (ActivityRecordNew update : activityRecordNewAdds) {

			update.setActID(activitySetting.getActID());
		}

		int[] rows = activityRecordNewDao.insertActivityRecordNewBatch(activityRecordNewAdds);

		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int addActivityApply(ActivitySetting activitySetting, List<ActivityApplyPojo> activityApplyAdds)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
			SQLException, ParseException, IOException {
		if (activityApplyAdds == null || activityApplyAdds.size() <= 0) {
			return 1;
		}

		for (ActivityApplyPojo update : activityApplyAdds) {

			update.setActID(activitySetting.getActID());
		}

		int[] rows = activityApplyDao.insertActivityApplyBatch(activityApplyAdds);

		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	public boolean deleteActivityByActID(String actID) throws Exception {
		boolean flag = false;
		int row = activitySettingDao.deleteActivitySettingByActID(actID);
		if (row > 0) {

			if (deleteActivityRecordNewByActID(actID) < 0) {
				throw new Exception("個案轉介評估刪除失敗！");
			}

			if (deleteActivityApplyByActID(actID) < 0) {
				throw new Exception("個案轉介評估刪除失敗！");
			}

			flag = true;

		}
		return flag;
	}

	private int deleteActivityApplyByActID(String actID) throws IOException, SQLException {
		return activityApplyDao.deleteActivityApplyByActID(actID);
	}

	private int deleteActivityRecordNewByActID(String actID) throws IOException, SQLException {
		return activityRecordNewDao.deleteActivityRecordNewByActID(actID);
	}

}
