package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fg.utils.ToolsUtils;
import com.jxh.dao.BCustomerSchoolDao;
import com.jxh.dao.TreatmentAssessDao;
import com.jxh.dao.TreatmentDao;
import com.jxh.dao.TreatmentHistoryDao;
import com.jxh.dao.TreatmentPlanDao;
import com.jxh.dao.TreatmentRecordDao;
import com.jxh.dao.TreatmentReportDao;
import com.jxh.utils.Constants;
import com.jxh.vo.BCustCase;
import com.jxh.vo.BCustCaseRecord;
import com.jxh.vo.BCustomerSchool;
import com.jxh.vo.Treatment;
import com.jxh.vo.TreatmentAssess;
import com.jxh.vo.TreatmentHistory;
import com.jxh.vo.TreatmentPlan;
import com.jxh.vo.TreatmentRecord;
import com.jxh.vo.TreatmentReport;

public class TreatmentBiz {
	private TreatmentDao treatmentDao = new TreatmentDao();
	private TreatmentAssessDao treatmentAssessDao = new TreatmentAssessDao();
	private TreatmentPlanDao treatmentPlanDao = new TreatmentPlanDao();
	private TreatmentRecordDao treatmentRecordDao = new TreatmentRecordDao();
	private BCustomerSchoolDao bCustomerSchoolDao = new BCustomerSchoolDao();
	private TreatmentHistoryDao treatmentHistoryDao = new TreatmentHistoryDao();
	private TreatmentReportDao treatmentReportDao = new TreatmentReportDao();
	

	public String updateTreatment(Treatment treatment, TreatmentAssess treatmentAssess, List<TreatmentPlan> treatmentPlanAdds, List<TreatmentPlan> treatmentPlanDeletes,List<TreatmentPlan> treatmentPlanUpdates, List<TreatmentRecord> treatmentRecordAdds, List<TreatmentRecord> treatmentRecordUpdates, List<TreatmentRecord> treatmentRecordDeletes, List<BCustomerSchool> bCustomerSchoolAdds, List<BCustomerSchool> bCustomerSchoolUpdates, List<BCustomerSchool> bCustomerSchoolDeletes
			,List<TreatmentHistory> treatmentHistoryAdds,List<TreatmentHistory> treatmentHistoryUpdates,List<TreatmentHistory> treatmentHistoryDeletes,TreatmentReport treatmentReport) throws Exception {

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
			
			//
			if(updateTreatmentReport(treatment, treatmentReport)<0){
				throw new Exception("新增個案撮要失败！");
			}
		}
		return "操作成功！";
	}

	public boolean deleteTreatmentByCaseID(String treatmentID) throws Exception {
		boolean flag=false;
		int row = treatmentDao.deleteTreatmentByTreatmentID(treatmentID);
			if (row > 0) {
				
				if (deleteTreatmentAssessByCaseID(treatmentID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				
				if(deleteBCustCaseRecordByCaseID(treatmentID) < 0){
					throw new Exception("個案撮要記錄刪除失敗！");
				}
				
				if(deleteBCustCaseSummaryHandleByCaseID(treatmentID) < 0){
					throw new Exception("结案摘要工作人员处理方式刪除失敗！");
				}
				
				if(deleteBCustCaseSummaryByCaseID(treatmentID) < 0){
					throw new Exception("結案摘要刪除失敗！");
				}
				
				flag=true;
				
			}
		return flag;
	}
	

	private int deleteBCustCaseSummaryHandleByCaseID(String caseID) throws SQLException {
		return bCustCaseSummaryHandleDao.deleteBCustCaseSummaryHandleByCaseID(caseID);
	}

	private int deleteBCustCaseSummaryByCaseID(String caseID) throws SQLException {
		return bCustCaseSummaryDao.deleteBCustCaseSummaryByCaseID(caseID);
	}

	private int deleteTreatmentAssessByTreatmentID(String treatmentID) throws SQLException {
		return treatmentAssessDao.deleteTreatmentAssessByTreatmentID(treatmentID);
	}

	/**
	 * 刪除個案撮要記錄
	 * @param custCase
	 * @param bCustCaseRecordDeletes
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	private int deleteBCustCaseRecord(BCustCase custCase, List<BCustCaseRecord> bCustCaseRecordDeletes) throws IOException, SQLException {
		// TODO Auto-generated method stub
		if (bCustCaseRecordDeletes == null || bCustCaseRecordDeletes.size() <= 0) {
			return 1;
		}
		return bCustCaseRecordDao.deleteBCustCaseReord(bCustCaseRecordDeletes);
	}



	/**
	 * 更新個案撮要記錄
	 * @param cust
	 * @param bCustCaseRecordUpdates
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws ParseException
	 * @throws IOException
	 */
	private int updateBCustCaseRecord(BCustCase custCase, List<BCustCaseRecord> bCustCaseRecordUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		// TODO Auto-generated method stub
		if (bCustCaseRecordUpdates == null || bCustCaseRecordUpdates.size() <= 0) {
			return 1;
		}
		return bCustCaseRecordDao.updateBCustCaseRecord(bCustCaseRecordUpdates);
	}






	private int deleteBCustCaseSummary(BCustCase custCase, List<BCustCaseSummary> bCustCaseSummaryDeletes) throws IOException, SQLException {
		// TODO Auto-generated method stub
		if (bCustCaseSummaryDeletes == null || bCustCaseSummaryDeletes.size() <= 0) {
			return 1;
		}
		return bCustCaseSummaryDao.deleteBCustCaseSummary(bCustCaseSummaryDeletes);
	}






	private int updateTreatmentReport(Treatment treatment, TreatmentReport treatmentReport) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (treatmentReport == null || "".equals(treatmentReport)) {
			return 1;
		}
		return treatmentReportDao.updateTreatmentReport(treatmentReport);
		
	}






	public String insertTreatment(Treatment treatment, TreatmentAssess treatmentAssess, TreatmentReport treatmentReport, List<BCustCaseRecord> bCustCaseRecordAdds, List<TreatmentPlan> treatmentPlanAdds,List<TreatmentRecord> treatmentRecordAdds,List<BCustomerSchool> BCustomerSchoolAdds,List<TreatmentHistory> treatmentHistoryAdds) throws Exception {
		String treatmentID = treatmentDao.getPrimaryKey(Constants.CORPID);
		treatment.setTreatmentID(treatmentID);
		int row = treatmentDao.insertTreatment(treatment);
		if (row > 0) {
			//新增個案撮要
			if(addTreatmentAssess(treatment, treatmentAssess)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			//
			if(addBCustCa(treatment, bCustCaseSummary,bCustCaseSummaryHandleAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			//新增個案轉介評估
			if (addBCustCaseAssess(custCase, bCustCaseAssess) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			
			
			//新增個案撮要
			if(addBCustCaseRecord(custCase, bCustCaseRecordAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			
			
			
		}
		return "操作成功！";
	}
	
	public String insertTreatmentAssess(Treatment treatment, TreatmentAssess treatmentAssess) throws Exception {
		String treatmentID = treatmentDao.getPrimaryKey(Constants.CORPID);
		treatment.setTreatmentID(treatmentID);
		int row = treatmentAssessDao.insertTreatmentAssess(treatmentAssess);
		if (row > 0) {
			
		}
		return "操作成功！";
	}

	
	
	
	/*
	 * ==================================================================================================================================
	 * ==================================================================================================================================
	 * ==================================================================================================================================
	 * ==================================================================================================================================
	 */
	
	
	/**
	 * 新增個案轉介評估
	 * @param custCase
	 * @param bCustCaseAssessAdds
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 * @throws IOException
	 * @throws SQLException
	 */
	private int addBCustCaseAssess(BCustCase custCase, BCustCaseAssess bCustCaseAssess) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (bCustCaseAssess == null || "".equals(bCustCaseAssess)) {
			return 1;
		}
		bCustCaseAssess.setCaseID(custCase.getCaseID());

		bCustCaseAssessDao.insertBCustCaseAssess(bCustCaseAssess);
		return 1;
		
	}





	private int addBCustomerSchool(Treatment treatment, List<BCustomerSchool> bCustomerSchoolAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		// TODO Auto-generated method stub
		if (bCustomerSchoolAdds == null || bCustomerSchoolAdds.size() <= 0) {
			return 1;
		}

		for (BCustomerSchool add : bCustomerSchoolAdds) {
			add.setCustID(treatment.getCustID());
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





	private int addBCustCaseSummary(BCustCase custCase, BCustCaseSummary bCustCaseSummary, List<BCustCaseSummaryHandle> bCustCaseSummaryHandleAdds) throws Exception {
		String summaryID = bCustCaseSummaryDao.getPrimaryKey(Constants.CORPID);
		if (bCustCaseSummary == null || "".equals(bCustCaseSummary)) {
			return 1;
		}

		bCustCaseSummary.setCaseID(custCase.getCaseID());
		bCustCaseSummary.setSummaryID(summaryID);
		int row = bCustCaseSummaryDao.insertBCustCaseSummary(bCustCaseSummary);
		if(row > 0 ){
			if(addBCustCaseSummaryHandle(bCustCaseSummary, bCustCaseSummaryHandleAdds)<0){
				throw new Exception("新增結案記錄失败！");
			}
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
		
		
		int [] rows =treatmentRecordDao.updateTreatmentRecord(treatmentRecordUpdates);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}
	

	private int deleteTreatmentRecord(Treatment treatment, List<TreatmentRecord> treatmentRecordDeletes) throws SQLException, IOException {
		
		if (treatmentRecordDeletes == null || treatmentRecordDeletes.size() <= 0) {
			return 1;
		}

		
		int[] rows = treatmentRecordDao.deleteTreatmentRecord(treatmentRecordDeletes);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
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
			add.setCustID(treatment.getCustID());
		}

		int[] rows = treatmentPlanDao.insertTreatmentPlan(treatmentHistoryAdds);
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
}
