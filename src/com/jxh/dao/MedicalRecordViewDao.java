package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.MedicalRecordView;

public class MedicalRecordViewDao extends DaoImpl<MedicalRecordView> {

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/medicalrecordview.properties";
	}

	
	public int[] insertMedicalRecordViewBatch(List<MedicalRecordView> medicalRecordView) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey("insertMedicalRecordView");
		System.out.println("sql=="+sql);
		Object[][] params = new Object[medicalRecordView.size()][];
		for(int i = 0;i<medicalRecordView.size();i++){
			params[i] = getInsertParams(sql, medicalRecordView.get(i));
		}
		return this.updateBatch(sql, params);
	}
	
	public int[] updateMedicalRecordViewBatch(List<MedicalRecordView> medicalRecordViews) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, SQLException, IOException{
		String sql = this.getSqlByPropKey("updateMedicalRecordView");
		Object[][] params = new Object[medicalRecordViews.size()][];
		for (int i = 0; i < medicalRecordViews.size(); i++) {
			params[i] = getUpdateParams(sql, medicalRecordViews.get(i));
		}
		return this.updateBatch(sql, params);
	}
	
	public int deleteMedicalRecordView(List<MedicalRecordView> medicalRecordView) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[medicalRecordView.size()][1];
		for (int i = 0;i<medicalRecordView.size();i++) {
			params[i][0] = medicalRecordView.get(i).getRecordID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	public int deleteMedicalRecordViewByRecordID(String recordID) throws SQLException, IOException {
		//String sql = "delete from BCustCaseSummary where caseID = ? ";
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return this.update(sql, recordID);
	}
}
