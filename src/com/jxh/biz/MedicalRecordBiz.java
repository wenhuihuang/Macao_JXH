package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.MedicalRecordDao;
import com.jxh.dao.MedicalRecordFamilyDao;
import com.jxh.dao.MedicalRecordViewDao;
import com.jxh.utils.Constants;
import com.jxh.vo.BCustomer;
import com.jxh.vo.MedicalRecord;
import com.jxh.vo.MedicalRecordFamily;
import com.jxh.vo.MedicalRecordView;

public class MedicalRecordBiz {
	private MedicalRecordDao  medicalRecordDao = new MedicalRecordDao();
	private MedicalRecordFamilyDao medicalRecordFamilyDao = new MedicalRecordFamilyDao();
	private MedicalRecordViewDao medicalRecordViewDao = new MedicalRecordViewDao();

	public String updateMedicalRecord(MedicalRecord medicalRecord, List<MedicalRecordView> medicalRecordViewAdds,
			 List<MedicalRecordView> medicalRecordViewUpdates, List<MedicalRecordView> medicalRecordViewDeletes,
			List<MedicalRecordFamily> medicalRecordFamilyAdds, List<MedicalRecordFamily> medicalRecordFamilyUpdates,
			List<MedicalRecordFamily> medicalRecordFamilyDeletes) throws Exception {
		int row = medicalRecordDao.updateMedicalRecord(medicalRecord);
		if (row > 0) {
			//
			if(addMedicalRecordView(medicalRecord, medicalRecordViewAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateMedicalRecordView(medicalRecord, medicalRecordViewUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteMedicalRecordView(medicalRecord, medicalRecordViewDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			//
			if (addMedicalRecordFamily(medicalRecord, medicalRecordFamilyAdds) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			if (updateMedicalRecordFamily(medicalRecord, medicalRecordFamilyUpdates) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			if (deleteMedicalRecordFamily(medicalRecord, medicalRecordFamilyDeletes) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
		}
		return "操作成功！";
	}

	private int deleteMedicalRecordView(MedicalRecord medicalRecord, List<MedicalRecordView> medicalRecordViewDeletes) throws IOException, SQLException {
		if (medicalRecordViewDeletes == null || medicalRecordViewDeletes.size() <= 0) {
			return 1;
		}
		return medicalRecordViewDao.deleteMedicalRecordView(medicalRecordViewDeletes);
	
	}

	private int updateMedicalRecordView(MedicalRecord medicalRecord,
			List<MedicalRecordView> medicalRecordViewUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (medicalRecordViewUpdates == null || medicalRecordViewUpdates.size() <= 0) {
			return 1;
		}
		
		for (MedicalRecordView update : medicalRecordViewUpdates) {
			
			update.setRecordID(medicalRecord.getRecordID());
		}
		
		int [] rows =medicalRecordViewDao.updateMedicalRecordViewBatch(medicalRecordViewUpdates);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int deleteMedicalRecordFamily(MedicalRecord medicalRecord,
			List<MedicalRecordFamily> medicalRecordFamilyDeletes) throws IOException, SQLException {
		if (medicalRecordFamilyDeletes == null || medicalRecordFamilyDeletes.size() <= 0) {
			return 1;
		}
		return medicalRecordFamilyDao.deleteMedicalRecordFamilyByFamilyID(medicalRecordFamilyDeletes);
	}

	private int updateMedicalRecordFamily(MedicalRecord medicalRecord,
			List<MedicalRecordFamily> medicalRecordFamilyUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, SQLException, IOException {
		if (medicalRecordFamilyUpdates == null || medicalRecordFamilyUpdates.size() <= 0) {
			return 1;
		}
		
		for (MedicalRecordFamily update : medicalRecordFamilyUpdates) {
			
			update.setRecordID(medicalRecord.getRecordID());
		}
		
		int [] rows =medicalRecordFamilyDao.updateMedicalRecordFamilyBatch(medicalRecordFamilyUpdates);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	public String insertMedicalRecord(MedicalRecord medicalRecord, List<MedicalRecordView> medicalRecordViewAdds,
			List<MedicalRecordFamily> medicalRecordFamilyAdds) throws Exception {
		String recordID = medicalRecordDao.getPrimaryKey(Constants.CORPID);
		medicalRecord.setRecordID(recordID);
		int row = medicalRecordDao.insertMedicalRecord(medicalRecord);
		if (row > 0) {
			//
			if(addMedicalRecordView(medicalRecord, medicalRecordViewAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			//
			if (addMedicalRecordFamily(medicalRecord, medicalRecordFamilyAdds) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
		}
		return "操作成功！";
	}

	private int addMedicalRecordFamily(MedicalRecord medicalRecord, List<MedicalRecordFamily> medicalRecordFamilyAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (medicalRecordFamilyAdds == null || medicalRecordFamilyAdds.size() <= 0) {
			return 1;
		}

		for (MedicalRecordFamily add : medicalRecordFamilyAdds) {
			add.setRecordID(medicalRecord.getRecordID());
		}

		int[] rows = medicalRecordFamilyDao.insertMedicalRecordFamilyBatch(medicalRecordFamilyAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addMedicalRecordView(MedicalRecord medicalRecord, List<MedicalRecordView> medicalRecordViewAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (medicalRecordViewAdds == null || medicalRecordViewAdds.size() <= 0) {
			return 1;
		}

		for (MedicalRecordView add : medicalRecordViewAdds) {
			add.setRecordID(medicalRecord.getRecordID());
		}
		int[] rows = medicalRecordViewDao.insertMedicalRecordViewBatch(medicalRecordViewAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
		/*medicalRecordView.setRecordID(medicalRecord.getRecordID());
		return  medicalRecordViewDao.insertMedicalRecordView(medicalRecordViewAdds);*/
	}
	
	public boolean deleteMedicalRecordByRecordID(String recordID) throws Exception {
		boolean flag=false;
		int row = medicalRecordDao.deleteMedicalRecordByRecordID(recordID);
			if (row > 0) {
				
				if (deleteMedicalRecordFamilyByRecordID(recordID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				
				if (deleteMedicalRecordViewByRecordID(recordID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				
				flag=true;
				
			}
		return flag;
	}

	private int deleteMedicalRecordViewByRecordID(String recordID) throws SQLException, IOException {
		return medicalRecordViewDao.deleteMedicalRecordViewByRecordID(recordID);
	}

	private int deleteMedicalRecordFamilyByRecordID(String recordID) throws SQLException, IOException {
		return medicalRecordFamilyDao.deleteMedicalRecordFamilyByRecordID(recordID);
	}

	
}
