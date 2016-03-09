package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.BCustCaseAssessDao;
import com.jxh.dao.BCustCaseRecordDao;
import com.jxh.dao.BCustCaseSummaryDao;
import com.jxh.dao.BCustCaseSummaryHandleDao;
import com.jxh.dao.CustCaseDao;
import com.jxh.utils.Constants;
import com.jxh.vo.BCustCase;
import com.jxh.vo.BCustCaseAssess;
import com.jxh.vo.BCustCaseRecord;
import com.jxh.vo.BCustCaseSummary;
import com.jxh.vo.BCustCaseSummaryHandle;

public class CustCaseBiz {
	private CustCaseDao custCaseDao = new CustCaseDao();
	private BCustCaseAssessDao bCustCaseAssessDao = new BCustCaseAssessDao();
	private BCustCaseRecordDao bCustCaseRecordDao = new BCustCaseRecordDao();
	private BCustCaseSummaryDao bCustCaseSummaryDao = new BCustCaseSummaryDao();
	private BCustCaseSummaryHandleDao bCustCaseSummaryHandleDao = new BCustCaseSummaryHandleDao();

	public String updateCustCase(BCustCase custCase, BCustCaseAssess bCustCaseAssess, BCustCaseSummary bCustCaseSummary, List<BCustCaseRecord> bCustCaseRecordAdds, List<BCustCaseRecord> bCustCaseRecordUpdates, List<BCustCaseRecord> bCustCaseRecordDeletes, List<BCustCaseSummaryHandle> bCustCaseSummaryHandleAdds, List<BCustCaseSummaryHandle> bCustCaseSummaryHandleUpdates, List<BCustCaseSummaryHandle> bCustCaseSummaryHandleDeletes) throws Exception {

		int row = custCaseDao.updateCustCase(custCase);
		if (row > 0) {
			
			if (updateBCustCaseAssess(custCase, bCustCaseAssess) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			//新增個案撮要
			if(addBCustCaseRecord(custCase, bCustCaseRecordAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateBCustCaseRecord(custCase, bCustCaseRecordUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteBCustCaseRecord(custCase, bCustCaseRecordDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			//
			
			if(updateBCustCaseSummary(custCase, bCustCaseSummary)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(addBCustCaseSummaryHandle(bCustCaseSummary, bCustCaseSummaryHandleAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateBCustCaseSummaryHandle(bCustCaseSummary, bCustCaseSummaryHandleUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteBCustCaseSummaryHandle(bCustCaseSummary, bCustCaseSummaryHandleDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
		}
		return "操作成功！";
	}

	public boolean deleteCustCaseByCaseID(String caseID) throws Exception {
		boolean flag=false;
		int row = custCaseDao.deleteCustCaseByCaseID(caseID);
			if (row > 0) {
				
				if (deleteBCustCaseAssessByCaseID(caseID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				
				if(deleteBCustCaseRecordByCaseID(caseID) < 0){
					throw new Exception("個案撮要記錄刪除失敗！");
				}
				
				if(deleteBCustCaseSummaryHandleByCaseID(caseID) < 0){
					throw new Exception("结案摘要工作人员处理方式刪除失敗！");
				}
				
				if(deleteBCustCaseSummaryByCaseID(caseID) < 0){
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

	private int deleteBCustCaseRecordByCaseID(String caseID) throws SQLException {
		return bCustCaseRecordDao.BCustCaseRecordByCaseID(caseID);
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






	private int updateBCustCaseSummary(BCustCase custCase, BCustCaseSummary bCustCaseSummary) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (bCustCaseSummary == null || "".equals(bCustCaseSummary)) {
			return 1;
		}
		return bCustCaseSummaryDao.updateBCustCaseSummary(bCustCaseSummary);
		
	}






	/**
	 * 新增会员信息
	 * @param cust
	 * @param retardedAdds
	 * @param familyAdds
	 * @param cSSAAdds 
	 * @param specialAllowanceAdds 
	 * @return
	 * @throws Exception
	 */
	public String insertCustCase(BCustCase custCase, BCustCaseAssess bCustCaseAssess, BCustCaseSummary bCustCaseSummary, List<BCustCaseRecord> bCustCaseRecordAdds, List<BCustCaseSummaryHandle> bCustCaseSummaryHandleAdds) throws Exception {
		String caseId = custCaseDao.getPrimaryKey(Constants.CORPID);
		custCase.setCaseID(caseId);
		int row = custCaseDao.insertCustCase(custCase);
		if (row > 0) {
			//
			if(addBCustCaseSummary(custCase, bCustCaseSummary,bCustCaseSummaryHandleAdds)<0){
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
	
	public String insertBCustCaseAssess(BCustCase custCase, BCustCaseAssess bCustCaseAssess) throws Exception {
		String caseId = custCaseDao.getPrimaryKey(Constants.CORPID);
		custCase.setCaseID(caseId);
		int row = custCaseDao.insertCustCase(custCase);
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





	/**
	 * 新增個案撮要記錄
	 * @param custCase
	 * @param bCustCaseRecordAdds
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 * @throws IOException
	 * @throws SQLException
	 */
	private int addBCustCaseRecord(BCustCase custCase, List<BCustCaseRecord> bCustCaseRecordAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		// TODO Auto-generated method stub
		if (bCustCaseRecordAdds == null || bCustCaseRecordAdds.size() <= 0) {
			return 1;
		}

		for (BCustCaseRecord add : bCustCaseRecordAdds) {
			add.setCustID(custCase.getCustID());
			add.setCaseID(custCase.getCaseID());
		}

		int[] rows = bCustCaseRecordDao.insertBCustCaseRecord(bCustCaseRecordAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}





	/**
	 * 新增結案摘要
	 * @param custCase
	 * @param bCustCaseSummaryAdds
	 * @return
	 * @throws Exception 
	 */
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
	
	/**
	 * 新增結案摘要工作人員處理方式
	 * @param bCustCaseSummary
	 * @param bCustCaseSummaryHandleAdds
	 * @return
	 * @throws SQLException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws ParseException
	 */
	private int addBCustCaseSummaryHandle(BCustCaseSummary bCustCaseSummary, List<BCustCaseSummaryHandle> bCustCaseSummaryHandleAdds) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException, ParseException {
		// TODO Auto-generated method stub
		if (bCustCaseSummaryHandleAdds == null || bCustCaseSummaryHandleAdds.size() <= 0) {
			return 1;
		}

		for (BCustCaseSummaryHandle add : bCustCaseSummaryHandleAdds) {
			add.setCaseID(bCustCaseSummary.getCaseID());
			add.setSummaryID(bCustCaseSummary.getSummaryID());
		}
		System.out.println("进入handle");
		System.out.println(bCustCaseSummary.getCaseID()+"=="+bCustCaseSummary.getSummaryID());
		int[] rows = bCustCaseSummaryHandleDao.insertBCustCaseSummaryHandle(bCustCaseSummaryHandleAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	/**
	 * 更新個案轉介評估
	 * @param custCase
	 * @param bCustCaseAssessUpdates
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 * @throws SQLException
	 * @throws IOException
	 */
	private int updateBCustCaseAssess(BCustCase custCase, BCustCaseAssess bCustCaseAssess) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, SQLException, IOException {
		if (bCustCaseAssess == null || "".equals(bCustCaseAssess)) {
			return 1;
		}
		
		bCustCaseAssess.setCaseID(custCase.getCaseID());
		return bCustCaseAssessDao.updateBCustCaseAssess(bCustCaseAssess);
		
	}
	
	
	
	private int deleteBCustCaseAssessByCaseID(String caseID) throws SQLException{
		return bCustCaseAssessDao.deleteBCustCaseAssessByCaseID(caseID);
	}

	
	private int updateBCustCaseSummaryHandle(BCustCaseSummary bCustCaseSummary, List<BCustCaseSummaryHandle> bCustCaseSummaryHandleUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException, SQLException, ParseException {
		
		if (bCustCaseSummaryHandleUpdates == null || bCustCaseSummaryHandleUpdates.size() <= 0) {
			return 1;
		}
		
		
		int [] rows =bCustCaseSummaryHandleDao.updateBCustCaseSummaryHandle(bCustCaseSummaryHandleUpdates);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}
	

	private int deleteBCustCaseSummaryHandle(BCustCaseSummary bCustCaseSummary, List<BCustCaseSummaryHandle> bCustCaseSummaryHandle) throws SQLException, IOException {
		
		if (bCustCaseSummaryHandle == null || bCustCaseSummaryHandle.size() <= 0) {
			return 1;
		}

		
		int[] rows = bCustCaseSummaryHandleDao.deleteBCustCaseSummaryHandle(bCustCaseSummaryHandle);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}
}
