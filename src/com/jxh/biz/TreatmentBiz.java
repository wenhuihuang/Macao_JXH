package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fg.utils.ToolsUtils;
import com.jxh.dao.BCustomerSchoolDao;
import com.jxh.dao.GroupDetailDao;
import com.jxh.dao.GroupSettingRecordPerformanceDao;
import com.jxh.dao.GroupTrainingPlanDao;
import com.jxh.dao.GroupTrainingRecordDao;
import com.jxh.dao.TreatmentAssessDao;
import com.jxh.dao.TreatmentDao;
import com.jxh.dao.TreatmentFamilyDao;
import com.jxh.dao.TreatmentHistoryDao;
import com.jxh.dao.TreatmentPlanDao;
import com.jxh.dao.TreatmentRecordDao;
import com.jxh.dao.TreatmentReportDao;
import com.jxh.dao.TreatmentTrainingDao;
import com.jxh.dao.TreatmentTrainingPlanDao;
import com.jxh.dao.TreatmentTrainingWorkDao;
import com.jxh.dao.TreatmentTrainingWorkRecordDao;
import com.jxh.utils.Constants;
import com.jxh.vo.BCustCase;
import com.jxh.vo.BCustCaseRecord;
import com.jxh.vo.BCustomer;
import com.jxh.vo.BCustomerSchool;
import com.jxh.vo.GroupDetail;
import com.jxh.vo.GroupSettingRecordPerformance;
import com.jxh.vo.GroupTrainingPlan;
import com.jxh.vo.GroupTrainingRecord;
import com.jxh.vo.Treatment;
import com.jxh.vo.TreatmentAssess;
import com.jxh.vo.TreatmentFamily;
import com.jxh.vo.TreatmentHistory;
import com.jxh.vo.TreatmentPlan;
import com.jxh.vo.TreatmentRecord;
import com.jxh.vo.TreatmentReport;
import com.jxh.vo.TreatmentTraining;
import com.jxh.vo.TreatmentTrainingPlan;
import com.jxh.vo.TreatmentTrainingWork;
import com.jxh.vo.TreatmentTrainingWorkRecord;

public class TreatmentBiz {
	private TreatmentDao treatmentDao = new TreatmentDao();
	private TreatmentAssessDao treatmentAssessDao = new TreatmentAssessDao();
	private TreatmentPlanDao treatmentPlanDao = new TreatmentPlanDao();
	private TreatmentRecordDao treatmentRecordDao = new TreatmentRecordDao();
	private BCustomerSchoolDao bCustomerSchoolDao = new BCustomerSchoolDao();
	private TreatmentHistoryDao treatmentHistoryDao = new TreatmentHistoryDao();
	private TreatmentReportDao treatmentReportDao = new TreatmentReportDao();
	private TreatmentFamilyDao treatmentFamilyDao = new TreatmentFamilyDao();
	private TreatmentTrainingDao treatmentTrainingDao = new TreatmentTrainingDao();
	private TreatmentTrainingWorkDao treatmentTrainingWorkDao = new TreatmentTrainingWorkDao();
	private GroupDetailDao groupDetailDao = new GroupDetailDao();
	private GroupSettingRecordPerformanceDao groupSettingRecordPerformanceDao = new GroupSettingRecordPerformanceDao();
	private TreatmentTrainingPlanDao treatmentTrainingPlanDao = new TreatmentTrainingPlanDao();
	private TreatmentTrainingWorkRecordDao treatmentTrainingWorkRecordDao = new TreatmentTrainingWorkRecordDao();
	private GroupTrainingPlanDao groupTrainingPlanDao = new GroupTrainingPlanDao();
	private GroupTrainingRecordDao groupTrainingRecordDao = new GroupTrainingRecordDao();

	public String updateTreatment(Treatment treatment,TreatmentAssess treatmentAssess,TreatmentReport treatmentReport,List<TreatmentPlan> treatmentPlanAdds,List<TreatmentPlan> treatmentPlanUpdates,List<TreatmentPlan> treatmentPlanDeletes,List<TreatmentRecord> treatmentRecordAdds,List<TreatmentRecord> treatmentRecordUpdates,List<TreatmentRecord> treatmentRecordDeletes,List<TreatmentHistory> treatmentHistoryAdds,List<TreatmentHistory> treatmentHistoryUpdates,List<TreatmentHistory> treatmentHistoryDeletes, List<BCustomerSchool> bCustomerSchoolAdds, List<BCustomerSchool> bCustomerSchoolUpdates, List<BCustomerSchool> bCustomerSchoolDeletes,List<TreatmentFamily> treatmentFamilyAdds,List<TreatmentFamily> treatmentFamilyUpdates,List<TreatmentFamily> treatmentFamilyDeletes) throws Exception {

		int row = treatmentDao.updateTreatment(treatment);
		if (row > 0) {
			
			if (updateTreatmentAssess(treatment, treatmentAssess) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			//新增個案撮要
			if(addTreatmentPlan(treatment, treatmentPlanAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateTreatmentPlan(treatment, treatmentPlanUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteTreatmentPlan(treatment, treatmentPlanDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentRecord(treatment, treatmentRecordAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateTreatmentRecord(treatment, treatmentRecordUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteTreatmentRecord(treatment, treatmentRecordDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addBCustomerSchool(treatment, bCustomerSchoolAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateBCustomerSchool(treatment, bCustomerSchoolUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteBCustomerSchool(treatment, bCustomerSchoolDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentHistory(treatment, treatmentHistoryAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateTreatmentHistory(treatment, treatmentHistoryUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteTreatmentHistory(treatment, treatmentHistoryDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentFamily(treatment, treatmentFamilyAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateTreatmentFamily(treatment, treatmentFamilyUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteTreatmentFamily(treatment, treatmentFamilyDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			//
			if(updateTreatmentReport(treatment, treatmentReport)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			
		}
		return "操作成功！";
	}

	public boolean deleteTreatmentByTreatmentID(String treatmentID,String custID,String treatmentType) throws Exception {
		boolean flag=false;
		int row = treatmentDao.deleteTreatmentByTreatmentID(treatmentID);
			if (row > 0) {
				
				if (deleteTreatmentAssessByTreatmentID(treatmentID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				
				if (deleteTreatmentHistoryByCustID(custID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				
				if (deleteTreatmentFamilyByTreatmentID(treatmentID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}

				if(deleteBCustomerSchoolByCustID(custID) < 0){
					throw new Exception("結案摘要刪除失敗！");
				}
				
				if("5".equals(treatmentType)){
					
					
					if(deleteGroupTrainingPlanByTreatmentID(treatmentID) < 0){
						throw new Exception("個案撮要記錄刪除失敗！");
					}
					
					if(deleteGroupTrainingRecordByTreatmentID(treatmentID) < 0){
						throw new Exception("個案撮要記錄刪除失敗！");
					}
					
					if(deleteTreatmentTrainingByTreatmentID(treatmentID) < 0){
						throw new Exception("個案撮要記錄刪除失敗！");
					}
					
					
				/*	if(deleteTreatmentTrainingWorkRecordByTreatmentID(treatmentID) < 0){
						throw new Exception("個案撮要記錄刪除失敗！");
					}*/
					
					if(deleteTreatmentTrainingWorkByTreatmentID(treatmentID) < 0){
						throw new Exception("個案撮要記錄刪除失敗！");
					}
					
				}else{
				
					
					if(deleteTreatmentReportByTreatmentID(treatmentID) < 0){
						throw new Exception("個案撮要記錄刪除失敗！");
					}
					
					if(deleteTreatmentPlanByTreatmentID(treatmentID) < 0){
						throw new Exception("结案摘要工作人员处理方式刪除失敗！");
					}
					
					if(deleteTreatmentRecordByTreatmentID(treatmentID) < 0){
						throw new Exception("結案摘要刪除失敗！");
					}
					
				}
				
			
				
				flag=true;
				
			}
		return flag;
	}
	

	private int deleteTreatmentTrainingWorkByTreatmentID(String treatmentID) throws SQLException, IOException {
		treatmentTrainingWorkRecordDao.deleteTreatmentTrainingWorkRecordByTreatmentID(treatmentID);
		return treatmentTrainingWorkDao.deleteTreatmentTrainingWorkByTreatmentID(treatmentID);
	}

	private int deleteTreatmentTrainingByTreatmentID(String treatmentID) throws SQLException, IOException {
		treatmentTrainingPlanDao.deleteTreatmentTrainingPlanByTreatmentID(treatmentID);
		return treatmentTrainingDao.deleteTreatmentTrainingByTreatmentID(treatmentID);
	}

	private int deleteGroupTrainingRecordByTreatmentID(String treatmentID) throws SQLException, IOException {
		return groupTrainingRecordDao.deleteGroupTrainingRecordByTreatmentID(treatmentID);
	}

	private int deleteGroupTrainingPlanByTreatmentID(String treatmentID) throws SQLException, IOException {
		return groupTrainingRecordDao.deleteGroupTrainingRecordByTreatmentID(treatmentID);
	}

	private int deleteTreatmentReportByTreatmentID(String treatmentID) throws SQLException, IOException {
		return treatmentReportDao.deleteTreatmentReportByTreatmentID(treatmentID);
	}

	private int deleteTreatmentPlanByTreatmentID(String treatmentID) throws SQLException, IOException {
		return treatmentPlanDao.deleteTreatmentPlanByTreatmentID(treatmentID);
	}

	private int deleteTreatmentAssessByTreatmentID(String treatmentID) throws SQLException, IOException {
		return treatmentAssessDao.deleteTreatmentAssessByTreatmentID(treatmentID);
	}
	
	private int deleteTreatmentRecordByTreatmentID(String treatmentID) throws SQLException, IOException {
		return treatmentRecordDao.deleteTreatmentRecordByTreatmentID(treatmentID);
	}
	
	private int deleteTreatmentHistoryByCustID(String custID) throws SQLException, IOException {
		return treatmentHistoryDao.deleteTreatmentHistoryByCustID(custID);
	}
	
	private int deleteBCustomerSchoolByCustID(String custID) throws SQLException, IOException {
		return bCustomerSchoolDao.deleteBCustomerSchoolByCustID(custID);
	}
	
	private int deleteTreatmentFamilyByTreatmentID(String treatmentID) throws SQLException, IOException {
		return treatmentFamilyDao.deleteTreatmentFamilyByTreatmentID(treatmentID);
	}


	private int updateTreatmentReport(Treatment treatment, TreatmentReport treatmentReport) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (treatmentReport == null || "".equals(treatmentReport)) {
			return 1;
		}
		return treatmentReportDao.updateTreatmentReport(treatmentReport);
		
	}




	
	
	
	/*
	 * ==================================================================================================================================
	 * ==================================================================================================================================
	 * ==================================================================================================================================
	 * ==================================================================================================================================
	 */
	
	
	private int addTreatmentAssess(Treatment treatment, TreatmentAssess treatmentAssess) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (treatmentAssess == null || "".equals(treatmentAssess)) {
			return 1;
		}
		treatmentAssess.setTreatmentID(treatment.getTreatmentID());

		treatmentAssessDao.insertTreatmentAssess(treatmentAssess);
		return 1;
		
	}





	private int addBCustomerSchool(Treatment treatment, List<BCustomerSchool> bCustomerSchoolAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		// TODO Auto-generated method stub
		if (bCustomerSchoolAdds == null || bCustomerSchoolAdds.size() <= 0) {
			return 1;
		}

		for (BCustomerSchool add : bCustomerSchoolAdds) {
			add.setCustID(treatment.getCustID());
		}

		int[] rows = bCustomerSchoolDao.insertBCustomerSchool(bCustomerSchoolAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}





	private int addTreatmentReport(Treatment treatment, TreatmentReport treatmentReport) throws Exception {
		String treatmentID = treatmentReportDao.getPrimaryKey(Constants.CORPID);
		if (treatmentReport == null || "".equals(treatmentReport)) {
			return 1;
		}

		treatmentReport.setTreatmentID(treatment.getTreatmentID());
		int row = treatmentReportDao.insertTreatmentReport(treatmentReport);
		if(row > 0 ){
			
		}
		return 1;
	}
	
	private int addTreatmentRecord(Treatment treatment, List<TreatmentRecord> treatmentRecordAdds) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException, ParseException {
		// TODO Auto-generated method stub
		if (treatmentRecordAdds == null || treatmentRecordAdds.size() <= 0) {
			return 1;
		}

		for (TreatmentRecord add : treatmentRecordAdds) {
			add.setTreatmentID(treatment.getTreatmentID());
			add.setTreatmentID(treatment.getTreatmentID());
		}
		int[] rows = treatmentRecordDao.insertTreatmentRecord(treatmentRecordAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int updateTreatmentAssess(Treatment treatment, TreatmentAssess treatmentAssess) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, SQLException, IOException {
		if (treatmentAssess == null || "".equals(treatmentAssess)) {
			return 1;
		}
		
		treatmentAssess.setTreatmentID(treatmentAssess.getTreatmentID());
		return treatmentAssessDao.updateTreatmentAssess(treatmentAssess);
		
	}
	
	

	
	private int updateTreatmentRecord(Treatment treatment, List<TreatmentRecord> treatmentRecordUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException, SQLException, ParseException {
		
		if (treatmentRecordUpdates == null || treatmentRecordUpdates.size() <= 0) {
			return 1;
		}
		
		
		int rows =treatmentRecordDao.updateTreatmentRecord(treatmentRecordUpdates);
		
	/*	for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}*/
		return 1;
	}
	

	private int deleteTreatmentRecord(Treatment treatment, List<TreatmentRecord> treatmentRecordDeletes) throws SQLException, IOException {
		
		if (treatmentRecordDeletes == null || treatmentRecordDeletes.size() <= 0) {
			return 1;
		}

		
		int rows = treatmentRecordDao.deleteTreatmentRecord(treatmentRecordDeletes);
	/*	for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}*/
		return 1;
	}
	
	private int addTreatmentPlan(Treatment treatment, List<TreatmentPlan> treatmentPlanAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		// TODO Auto-generated method stub
		if (treatmentPlanAdds == null || treatmentPlanAdds.size() <= 0) {
			return 1;
		}

		for (TreatmentPlan add : treatmentPlanAdds) {
			add.setTreatmentID(treatment.getTreatmentID());
			add.setTreatmentID(treatment.getTreatmentID());
		}

		int[] rows = treatmentPlanDao.insertTreatmentPlan(treatmentPlanAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}
	
	private int addTreatmentHistory(Treatment treatment, List<TreatmentHistory> treatmentHistoryAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		// TODO Auto-generated method stub
		if (treatmentHistoryAdds == null || treatmentHistoryAdds.size() <= 0) {
			return 1;
		}

		for (TreatmentHistory add : treatmentHistoryAdds) {
			add.setCustID(treatment.getCustID());
		}

		int[] rows = treatmentHistoryDao.insertTreatmentHistory(treatmentHistoryAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}
	
	private int addTreatmentFamily(Treatment treatment, List<TreatmentFamily> treatmentFamilyAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		// TODO Auto-generated method stub
		if (treatmentFamilyAdds == null || treatmentFamilyAdds.size() <= 0) {
			return 1;
		}

		for (TreatmentFamily add : treatmentFamilyAdds) {
			add.setTreatmentID(treatment.getTreatmentID());
		}

		int[] rows = treatmentFamilyDao.insertTreatmentFamily(treatmentFamilyAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}
	
	private int updateTreatmentHistory(Treatment treatment, List<TreatmentHistory> treatmentHistoryUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		// TODO Auto-generated method stub
		if (treatmentHistoryUpdates == null || treatmentHistoryUpdates.size() <= 0) {
			return 1;
		}
		return treatmentHistoryDao.updateTreatmentHistory(treatmentHistoryUpdates);
	}
	
	private int updateTreatmentFamily(Treatment treatment, List<TreatmentFamily> treatmentFamilyUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		// TODO Auto-generated method stub
		if (treatmentFamilyUpdates == null || treatmentFamilyUpdates.size() <= 0) {
			return 1;
		}
		return treatmentFamilyDao.updateTreatmentFamily(treatmentFamilyUpdates);
	}
	
	private int updateTreatmentPlan(Treatment treatment, List<TreatmentPlan> treatmentPlanUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		// TODO Auto-generated method stub
		if (treatmentPlanUpdates == null || treatmentPlanUpdates.size() <= 0) {
			return 1;
		}
		return treatmentPlanDao.updateTreatmentPlan(treatmentPlanUpdates);
	}
	
	private int updateBCustomerSchool(Treatment treatment, List<BCustomerSchool> bCustomerSchoolUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		// TODO Auto-generated method stub
		if (bCustomerSchoolUpdates == null || bCustomerSchoolUpdates.size() <= 0) {
			return 1;
		}
		return bCustomerSchoolDao.updateBCustomerSchool(bCustomerSchoolUpdates);
	}
	
	public int deleteBCustomerSchool(Treatment treatment,List<BCustomerSchool> bCustomerSchoolDeletes) throws IOException, SQLException{
		if (bCustomerSchoolDeletes == null || bCustomerSchoolDeletes.size() <= 0) {
			return 1;
		}
		return bCustomerSchoolDao.deleteBCustomerSchool(bCustomerSchoolDeletes);
	}
	
	public int deleteTreatmentPlan(Treatment treatment,List<TreatmentPlan> treatmentPlanDeletes) throws IOException, SQLException{
		if (treatmentPlanDeletes == null || treatmentPlanDeletes.size() <= 0) {
			return 1;
		}
		return treatmentPlanDao.deleteTreatmentPlan(treatmentPlanDeletes);
	}
	
	private int deleteTreatmentHistory(Treatment treatment, List<TreatmentHistory> treatmentHistoryDeletes) throws IOException, SQLException {
		// TODO Auto-generated method stub
		if (treatmentHistoryDeletes == null || treatmentHistoryDeletes.size() <= 0) {
			return 1;
		}
		return treatmentHistoryDao.deleteTreatmentHistory(treatmentHistoryDeletes);
	}
	private int deleteTreatmentFamily(Treatment treatment, List<TreatmentFamily> treatmentFamilyDeletes) throws IOException, SQLException {
		// TODO Auto-generated method stub
		if (treatmentFamilyDeletes == null || treatmentFamilyDeletes.size() <= 0) {
			return 1;
		}
		return treatmentFamilyDao.deleteTreatmentFamily(treatmentFamilyDeletes);
	}

	public String insertTreatment(Treatment treatment, TreatmentAssess treatmentAssess, TreatmentReport treatmentReport,
			List<TreatmentPlan> treatmentPlanAdds, List<TreatmentRecord> treatmentRecordAdds,
			List<TreatmentHistory> treatmentHistoryAdds, List<BCustomerSchool> bCustomerSchoolAdds,List<TreatmentFamily> treatmentFamilyAdds) throws Exception {
		String treatmentID = treatmentDao.getPrimaryKey(Constants.CORPID);
		treatment.setTreatmentID(treatmentID);
		int row = treatmentDao.insertTreatment(treatment);
		if (row > 0) {
			
			//新增個案轉介評估
			if (addTreatmentAssess(treatment, treatmentAssess) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			
			//新增個案撮要
			if(addTreatmentReport(treatment, treatmentReport)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			
			//
			if(addTreatmentPlan(treatment, treatmentPlanAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			//
			if(addTreatmentRecord(treatment, treatmentRecordAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			//
			if(addTreatmentHistory(treatment, treatmentHistoryAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentFamily(treatment, treatmentFamilyAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addBCustomerSchool(treatment, bCustomerSchoolAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			
		}
		return "操作成功！";
	}


	public String updateTreatmentFunction(Treatment treatment, TreatmentAssess treatmentAssess,
			TreatmentReport treatmentReport,
			List<TreatmentHistory> treatmentHistoryAdds, List<TreatmentHistory> treatmentHistoryUpdates,
			List<TreatmentHistory> treatmentHistoryDeletes, List<BCustomerSchool> bCustomerSchoolAdds,
			List<BCustomerSchool> bCustomerSchoolUpdates, List<BCustomerSchool> bCustomerSchoolDeletes,
			List<TreatmentFamily> treatmentFamilyAdds, List<TreatmentFamily> treatmentFamilyUpdates,
			List<TreatmentFamily> treatmentFamilyDeletes, TreatmentTraining treatmentTraining,
			TreatmentTrainingWork treatmentTrainingWork, List<GroupTrainingPlan> groupTrainingPlanAdds,
			List<GroupTrainingPlan> groupTrainingPlanUpdates, List<GroupTrainingPlan> groupTrainingPlanDeletes,
			List<GroupTrainingRecord> groupTrainingRecordAdds,
			List<GroupTrainingRecord> groupTrainingRecordUpdates,
			List<GroupTrainingRecord> groupTrainingRecordDeletes,
			List<TreatmentTrainingPlan> treatmentTrainingPlanAdds,
			List<TreatmentTrainingPlan> treatmentTrainingPlanUpdates,
			List<TreatmentTrainingPlan> treatmentTrainingPlanDeletes,
			List<TreatmentTrainingWorkRecord> treatmentTrainingWorkRecordAdds,
			List<TreatmentTrainingWorkRecord> treatmentTrainingWorkRecordUpdates,
			List<TreatmentTrainingWorkRecord> treatmentTrainingWorkRecordDeletes) throws Exception {
		
		int row = treatmentDao.updateTreatment(treatment);
		if (row > 0) {
			
			if (updateTreatmentAssess(treatment, treatmentAssess) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			
			if(addBCustomerSchool(treatment, bCustomerSchoolAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateBCustomerSchool(treatment, bCustomerSchoolUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteBCustomerSchool(treatment, bCustomerSchoolDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentHistory(treatment, treatmentHistoryAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateTreatmentHistory(treatment, treatmentHistoryUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteTreatmentHistory(treatment, treatmentHistoryDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentFamily(treatment, treatmentFamilyAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateTreatmentFamily(treatment, treatmentFamilyUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteTreatmentFamily(treatment, treatmentFamilyDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateTreatmentTraining(treatment, treatmentTraining)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateTreatmentTrainingWork(treatment, treatmentTrainingWork)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addGroupTrainingPlan(treatment, groupTrainingPlanAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateGroupTrainingPlan(treatment, groupTrainingPlanUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteGroupTrainingPlan(treatment, groupTrainingPlanDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addGroupTrainingRecord(treatment, groupTrainingRecordAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateGroupTrainingRecord(treatment, groupTrainingRecordUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteGroupTrainingRecord(treatment, groupTrainingRecordDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentTrainingPlan(treatmentTraining, treatmentTrainingPlanAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateTreatmentTrainingPlan(treatmentTraining, treatmentTrainingPlanUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteTreatmentTrainingPlan(treatmentTraining, treatmentTrainingPlanDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentTrainingWorkRecord(treatmentTrainingWork, treatmentTrainingWorkRecordAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateTreatmentTrainingWorkRecord(treatmentTrainingWork, treatmentTrainingWorkRecordUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteTreatmentTrainingWorkRecord(treatmentTrainingWork, treatmentTrainingWorkRecordDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(updateTreatmentReport(treatment, treatmentReport)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
		}
		return "操作成功！";
	}

	private int deleteTreatmentTrainingWorkRecord(TreatmentTrainingWork treatmentTrainingWork,
			List<TreatmentTrainingWorkRecord> treatmentTrainingWorkRecordDeletes) throws IOException, SQLException {
		if (treatmentTrainingWorkRecordDeletes == null || treatmentTrainingWorkRecordDeletes.size() <= 0) {
			return 1;
		}
		return treatmentTrainingWorkRecordDao.deleteTreatmentTrainingWorkRecord(treatmentTrainingWorkRecordDeletes);
	}

	private int deleteTreatmentTrainingPlan(TreatmentTraining treatmentTraining,
			List<TreatmentTrainingPlan> treatmentTrainingPlanDeletes) throws IOException, SQLException {
		if (treatmentTrainingPlanDeletes == null || treatmentTrainingPlanDeletes.size() <= 0) {
			return 1;
		}
		return treatmentTrainingPlanDao.deleteTreatmentTrainingPlan(treatmentTrainingPlanDeletes);
	}

	private int updateTreatmentTrainingPlan(TreatmentTraining treatmentTraining,
			List<TreatmentTrainingPlan> treatmentTrainingPlanUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {

		if (treatmentTrainingPlanUpdates == null || treatmentTrainingPlanUpdates.size() <= 0) {
			return 1;
		}
		return treatmentTrainingPlanDao.updateTreatmentTrainingPlan(treatmentTrainingPlanUpdates);
	}

	private int deleteGroupTrainingRecord(Treatment treatment,
			List<GroupTrainingRecord> groupTrainingRecordDeletes) throws IOException, SQLException {
		if (groupTrainingRecordDeletes == null || groupTrainingRecordDeletes.size() <= 0) {
			return 1;
		}
		return groupTrainingRecordDao.deleteGroupTrainingRecord(groupTrainingRecordDeletes);
	}

	private int deleteGroupTrainingPlan(Treatment treatment, List<GroupTrainingPlan> groupTrainingPlanDeletes) throws IOException, SQLException {
		if (groupTrainingPlanDeletes == null || groupTrainingPlanDeletes.size() <= 0) {
			return 1;
		}
		return groupTrainingPlanDao.deleteGroupTrainingPlan(groupTrainingPlanDeletes);
	}

	private int updateTreatmentTrainingWorkRecord(TreatmentTrainingWork treatmentTrainingWork,
			List<TreatmentTrainingWorkRecord> treatmentTrainingWorkRecordUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {

		if (treatmentTrainingWorkRecordUpdates == null || treatmentTrainingWorkRecordUpdates.size() <= 0) {
			return 1;
		}
		for (TreatmentTrainingWorkRecord update : treatmentTrainingWorkRecordUpdates) {
			
			update.setWorkID(treatmentTrainingWork.getWorkID());
		}
		
		int [] rows =treatmentTrainingWorkRecordDao.updateTreatmentTrainingWorkRecordBatch(treatmentTrainingWorkRecordUpdates);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
		
		//return treatmentTrainingWorkRecordDao.updateTreatmentTrainingWorkRecord(treatmentTrainingWorkRecordUpdates);
	}

	private int updateGroupTrainingRecord(Treatment treatment,
			List<GroupTrainingRecord> groupTrainingRecordUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		
		if (groupTrainingRecordUpdates == null || groupTrainingRecordUpdates.size() <= 0) {
			return 1;
		}
		return groupTrainingRecordDao.updateGroupTrainingRecord(groupTrainingRecordUpdates);
	}

	private int updateGroupTrainingPlan(Treatment treatment, List<GroupTrainingPlan> groupTrainingPlanUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		
		if (groupTrainingPlanUpdates == null || groupTrainingPlanUpdates.size() <= 0) {
			return 1;
		}
		return groupTrainingPlanDao.updateGroupTrainingPlan(groupTrainingPlanUpdates);
	}

	private int updateTreatmentTrainingWork(Treatment treatment,
			TreatmentTrainingWork treatmentTrainingWork) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		
		if (treatmentTrainingWork == null || "".equals(treatmentTrainingWork)) {
			return 1;
		}
		
		treatmentTrainingWork.setTreatmentID(treatment.getTreatmentID());
		return treatmentTrainingWorkDao.updateTreatmentTrainingWork(treatmentTrainingWork);
	}

	private int updateTreatmentTraining(Treatment treatment, TreatmentTraining treatmentTraining) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (treatmentTraining == null || "".equals(treatmentTraining)) {
			return 1;
		}
		
		treatmentTraining.setTreatmentID(treatmentTraining.getTreatmentID());
		return treatmentTrainingDao.updateTreatmentTraining(treatmentTraining);
	}

	public String insertTreatmentFunction(Treatment treatment, TreatmentAssess treatmentAssess,
			TreatmentReport treatmentReport,
			List<TreatmentHistory> treatmentHistoryAdds, List<BCustomerSchool> bCustomerSchoolAdds,
			List<TreatmentFamily> treatmentFamilyAdds, TreatmentTraining treatmentTraining,
			TreatmentTrainingWork treatmentTrainingWork, List<GroupTrainingPlan> groupTrainingPlanAdds,
			List<GroupTrainingRecord> groupTrainingRecordAdds,
			List<TreatmentTrainingPlan> treatmentTrainingPlanAdds,
			List<TreatmentTrainingWorkRecord> treatmentTrainingWorkRecordAdds) throws Exception {
		
		String treatmentID = treatmentDao.getPrimaryKey(Constants.CORPID);
		treatment.setTreatmentID(treatmentID);
		int row = treatmentDao.insertTreatment(treatment);
		if (row > 0) {
			if(addTreatmentReport(treatment, treatmentReport)<0){
				throw new Exception("新增個案撮要失败！");
			}
			//新增個案轉介評估
			if (addTreatmentAssess(treatment, treatmentAssess) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			
			//
			if(addTreatmentHistory(treatment, treatmentHistoryAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentFamily(treatment, treatmentFamilyAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addBCustomerSchool(treatment, bCustomerSchoolAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentTraining(treatment, treatmentTraining)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentTrainingWork(treatment, treatmentTrainingWork)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addGroupTrainingPlan(treatment, groupTrainingPlanAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addGroupTrainingRecord(treatment, groupTrainingRecordAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentTrainingPlan(treatmentTraining, treatmentTrainingPlanAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addTreatmentTrainingWorkRecord(treatmentTrainingWork, treatmentTrainingWorkRecordAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
		}
		return "操作成功！";
	}

	private int addTreatmentTrainingWorkRecord(TreatmentTrainingWork treatmentTrainingWork,
			List<TreatmentTrainingWorkRecord> treatmentTrainingWorkRecordAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		
		if (treatmentTrainingWorkRecordAdds == null || treatmentTrainingWorkRecordAdds.size() <= 0) {
			return 1;
		}

		for (TreatmentTrainingWorkRecord add : treatmentTrainingWorkRecordAdds) {
			add.setWorkID(treatmentTrainingWork.getWorkID());
		}

		int[] rows = treatmentTrainingWorkRecordDao.insertTreatmentTrainingWorkRecord(treatmentTrainingWorkRecordAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addTreatmentTrainingPlan(TreatmentTraining treatmentTraining,
			List<TreatmentTrainingPlan> treatmentTrainingPlanAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		
		if (treatmentTrainingPlanAdds == null || treatmentTrainingPlanAdds.size() <= 0) {
			return 1;
		}

		for (TreatmentTrainingPlan add : treatmentTrainingPlanAdds) {
			add.setTrainingID(treatmentTraining.getTrainingID());
		}

		int[] rows = treatmentTrainingPlanDao.insertTreatmentTrainingPlan(treatmentTrainingPlanAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addGroupTrainingRecord(Treatment treatment,
			List<GroupTrainingRecord> groupTrainingRecordAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		
		if (groupTrainingRecordAdds == null || groupTrainingRecordAdds.size() <= 0) {
			return 1;
		}

		for (GroupTrainingRecord add : groupTrainingRecordAdds) {
			add.setTreatmentID(treatment.getTreatmentID());
		}

		int[] rows = groupTrainingRecordDao.insertGroupTrainingRecord(groupTrainingRecordAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addGroupTrainingPlan(Treatment treatment, List<GroupTrainingPlan> groupTrainingPlanAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (groupTrainingPlanAdds == null || groupTrainingPlanAdds.size() <= 0) {
			return 1;
		}

		for (GroupTrainingPlan add : groupTrainingPlanAdds) {
			add.setTreatmentID(treatment.getTreatmentID());
		}

		int[] rows = groupTrainingPlanDao.insertGroupTrainingPlan(groupTrainingPlanAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addTreatmentTrainingWork(Treatment treatment, TreatmentTrainingWork treatmentTrainingWork) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException {
		String workID = treatmentTrainingWorkDao.getPrimaryKey(Constants.CORPID);
		if (treatmentTrainingWork == null || "".equals(treatmentTrainingWork)) {
			return 1;
		}
		treatmentTrainingWork.setWorkID(workID);
		treatmentTrainingWork.setTreatmentID(treatment.getTreatmentID());
		int row = treatmentTrainingWorkDao.insertTreatmentTrainingWork(treatmentTrainingWork);
		if(row > 0 ){
			
		}
		return 1;
	}

	private int addTreatmentTraining(Treatment treatment, TreatmentTraining treatmentTraining) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		String trainingID = treatmentTrainingDao.getPrimaryKey(Constants.CORPID);
		if (treatmentTraining == null || "".equals(treatmentTraining)) {
			return 1;
		}
		treatmentTraining.setTrainingID(trainingID);
		treatmentTraining.setTreatmentID(treatment.getTreatmentID());
		int row = treatmentTrainingDao.insertTreatmentTraining(treatmentTraining);
		if(row > 0 ){
			
		}
		return 1;
	}
}
