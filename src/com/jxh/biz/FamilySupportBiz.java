package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.FamilySupportApplyDao;
import com.jxh.dao.FamilySupportDao;
import com.jxh.dao.FamilySupportRecordDao;
import com.jxh.pojo.FamilySupportApplyPojo;
import com.jxh.utils.Constants;
import com.jxh.vo.FamilySupport;
import com.jxh.vo.FamilySupportApply;
import com.jxh.vo.FamilySupportRecord;

public class FamilySupportBiz {

	private FamilySupportDao familySupportDao = new FamilySupportDao();
	private FamilySupportRecordDao familySupportRecordDao = new FamilySupportRecordDao();
	private FamilySupportApplyDao familySupportApplyDao = new FamilySupportApplyDao();

	public String updateFamilySupport(FamilySupport familySupport, List<FamilySupportApplyPojo> memberDataAdds,
			List<FamilySupportApplyPojo> memberDataUpdates, List<FamilySupportApplyPojo> memberDataDeletes,
			List<FamilySupportApplyPojo> notMemberDataAdds, List<FamilySupportApplyPojo> notMemberDataUpdates,
			List<FamilySupportApplyPojo> notMemberDataDeletes, List<FamilySupportApplyPojo> volunteerDataAdds,
			List<FamilySupportApplyPojo> volunteerDataUpdates, List<FamilySupportApplyPojo> volunteerDataDeletes,
			List<FamilySupportRecord> familySupportRecordAdds, List<FamilySupportRecord> familySupportRecordUpdates,
			List<FamilySupportRecord> familySupportRecordDeletes) throws Exception {
		int row = familySupportDao.updateFamilySupport(familySupport);
		if (row > 0) {
			//
			if (addFamilySupportApply(familySupport, memberDataAdds) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (updateFamilySupportApply(familySupport, memberDataUpdates) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (deleteFamilySupportApply(familySupport, memberDataDeletes) < 0) {
				throw new Exception("新增個案撮要失败！");
			}
			//
			if (addFamilySupportApply(familySupport, notMemberDataAdds) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (updateFamilySupportApply(familySupport, notMemberDataUpdates) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (deleteFamilySupportApply(familySupport, notMemberDataDeletes) < 0) {
				throw new Exception("新增個案撮要失败！");
			}
			
			//
			if (addFamilySupportApply(familySupport, volunteerDataAdds) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (updateFamilySupportApply(familySupport, volunteerDataUpdates) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (deleteFamilySupportApply(familySupport, volunteerDataDeletes) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			//
			if (addFamilySupportRecord(familySupport, familySupportRecordAdds) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}

			if (updateFamilySupportRecord(familySupport, familySupportRecordUpdates) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			if (deleteFamilySupportRecord(familySupport, familySupportRecordDeletes) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
		}
		return "操作成功！";
	}

	private int deleteFamilySupportRecord(FamilySupport familySupport,
			List<FamilySupportRecord> familySupportRecordDeletes) throws IOException, SQLException {
		if (familySupportRecordDeletes == null || familySupportRecordDeletes.size() <= 0) {
			return 1;
		}
		return familySupportRecordDao.deleteFamilySupportRecord(familySupportRecordDeletes);
	}

	private int updateFamilySupportRecord(FamilySupport familySupport,
			List<FamilySupportRecord> familySupportRecordUpdates) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (familySupportRecordUpdates == null || familySupportRecordUpdates.size() <= 0) {
			return 1;
		}

		for (FamilySupportRecord update : familySupportRecordUpdates) {

			update.setSupportID(familySupport.getSupportID());
		}

		int[] rows = familySupportRecordDao.updateFamilySupportRecordBatch(familySupportRecordUpdates);

		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int deleteFamilySupportApply(FamilySupport familySupport,
			List<FamilySupportApplyPojo> familySupportApplyDeletes) throws IOException, SQLException {
		if (familySupportApplyDeletes == null || familySupportApplyDeletes.size() <= 0) {
			return 1;
		}
		return familySupportApplyDao.deleteFamilySupportApply(familySupportApplyDeletes);
	}

	private int updateFamilySupportApply(FamilySupport familySupport,
			List<FamilySupportApplyPojo> familySupportApplyUpdates) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (familySupportApplyUpdates == null || familySupportApplyUpdates.size() <= 0) {
			return 1;
		}

		for (FamilySupportApplyPojo update : familySupportApplyUpdates) {

			update.setSupportID(familySupport.getSupportID());
		}

		int[] rows = familySupportApplyDao.updateFamilySupportApplyBatch(familySupportApplyUpdates);

		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	public String insertFamilySupport(FamilySupport familySupport, List<FamilySupportApplyPojo> memberDataAdds,
			List<FamilySupportApplyPojo> notMemberDataAdds, List<FamilySupportApplyPojo> volunteerDataAdds,
			List<FamilySupportRecord> familySupportRecordAdds) throws Exception {

		String supportID = familySupportDao.getPrimaryKey(Constants.CORPID);
		familySupport.setSupportID(supportID);
		int row = familySupportDao.insertFamilySupport(familySupport);
		if (row > 0) {
			if (addFamilySupportApply(familySupport, memberDataAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			if (addFamilySupportApply(familySupport, notMemberDataAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			if (addFamilySupportApply(familySupport, volunteerDataAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}

			if (addFamilySupportRecord(familySupport, familySupportRecordAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}

		}
		return "操作成功！";
	}

	private int addFamilySupportRecord(FamilySupport familySupport, List<FamilySupportRecord> familySupportRecordAdds)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
			SQLException, ParseException, IOException {
		if (familySupportRecordAdds == null || familySupportRecordAdds.size() <= 0) {
			return 1;
		}

		for (FamilySupportRecord update : familySupportRecordAdds) {

			update.setSupportID(familySupport.getSupportID());
		}

		int[] rows = familySupportRecordDao.insertFamilySupportRecordBatch(familySupportRecordAdds);

		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int addFamilySupportApply(FamilySupport familySupport, List<FamilySupportApplyPojo> familySupportApplyAdds)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
			SQLException, ParseException, IOException {
		if (familySupportApplyAdds == null || familySupportApplyAdds.size() <= 0) {
			return 1;
		}

		for (FamilySupportApplyPojo update : familySupportApplyAdds) {

			update.setSupportID(familySupport.getSupportID());
		}

		int[] rows = familySupportApplyDao.insertFamilySupportApplyBatch(familySupportApplyAdds);

		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	public boolean deleteFamilySupportBySupportID(String supportID) throws Exception {
		boolean flag = false;
		int row = familySupportDao.deleteFamilySupportBySupportID(supportID);
		if (row > 0) {

			if (deleteFamilySupportRecordBySupportID(supportID) < 0) {
				throw new Exception("個案轉介評估刪除失敗！");
			}

			if (deleteFamilySupportApplyBySupportID(supportID) < 0) {
				throw new Exception("個案轉介評估刪除失敗！");
			}

			flag = true;

		}
		return flag;
	}

	private int deleteFamilySupportApplyBySupportID(String supportID) throws IOException, SQLException {
		return familySupportApplyDao.deleteFamilySupportApplyBySupportID(supportID);
	}

	private int deleteFamilySupportRecordBySupportID(String supportID) throws IOException, SQLException {
		return familySupportRecordDao.deleteFamilySupportRecordBySupportID(supportID);
	}

}
