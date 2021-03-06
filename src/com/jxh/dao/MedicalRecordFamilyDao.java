package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.BCustomer;
import com.jxh.vo.BCustomerSchool;
import com.jxh.vo.CSSA;
import com.jxh.vo.MedicalRecordFamily;

public class MedicalRecordFamilyDao extends DaoImpl<MedicalRecordFamily> {
	
	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/medicalrecordfamily.properties";
	}
	
	public PageUtils<MedicalRecordFamily> getMedicalRecordFamilyByCondition(PageUtils<MedicalRecordFamily> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<MedicalRecordFamily> medicalRecordFamily = this.findForList(sql, params);
		page.setList(medicalRecordFamily);
		
		return page;
	}
	
	public int[] insertMedicalRecordFamilyBatch(List<MedicalRecordFamily> medicalRecordFamily) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey("insertMedicalRecordFamily");
		Object[][] params = new Object[medicalRecordFamily.size()][];
		for(int i = 0;i<medicalRecordFamily.size();i++){
			params[i] = getInsertParams(sql, medicalRecordFamily.get(i));
		}
		return this.updateBatch(sql, params);
	}
	
	public int[] updateMedicalRecordFamilyBatch(List<MedicalRecordFamily> medicalRecordFamilys) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, SQLException, IOException{
		String sql = this.getSqlByPropKey("updateMedicalRecordFamily");
		Object[][] params = new Object[medicalRecordFamilys.size()][];
		for (int i = 0; i < medicalRecordFamilys.size(); i++) {
			params[i] = getUpdateParams(sql, medicalRecordFamilys.get(i));
		}
		return this.updateBatch(sql, params);
	}
	
	public int deleteMedicalRecordFamilyByFamilyID(List<MedicalRecordFamily> medicalRecordFamily) throws IOException, SQLException{
		String sql = this.getSqlByPropKey("deleteMedicalRecordFamilyByFamilyID");
		Object[][] params = new Object[medicalRecordFamily.size()][1];
		for (int i = 0;i<medicalRecordFamily.size();i++) {
			params[i][0] = medicalRecordFamily.get(i).getFamilyID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	public int deleteMedicalRecordFamilyByRecordID(String recordID) throws SQLException, IOException {
		//String sql = "delete from BCustCaseSummary where caseID = ? ";
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return this.update(sql, recordID);
	}
}
