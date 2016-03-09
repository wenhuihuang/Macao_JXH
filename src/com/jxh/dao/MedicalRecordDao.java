package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.MedicalRecordPojo;
import com.jxh.vo.MedicalRecord;

public class MedicalRecordDao extends DaoImpl {
	
	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/medicalrecord.properties";
	}
	
	public PageUtils<MedicalRecordPojo> getMedicalRecordPojo(PageUtils<MedicalRecordPojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = MedicalRecordPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<MedicalRecordPojo> medicalRecordPojos = this.findForList(sql, params);
		page.setList(medicalRecordPojos);
		
		return page;
	}

	public MedicalRecord getMedicalRecordByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = MedicalRecord.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (MedicalRecord) this.findForObject(sql, params);
	}

	public int updateMedicalRecord(MedicalRecord medicalRecord) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		// TODO Auto-generated method stub
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, medicalRecord);
		return this.update(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("MEDICALRECORD", corpId, 20);
	}
	
	public int insertMedicalRecord(MedicalRecord MedicalRecord) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, MedicalRecord);
		return this.update(sql, params);
	}
	
	public int deleteMedicalRecordByRecordID(String recordID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from Treatment where treatmentID = ? ";
		return this.update(sql, recordID);
	}
	
}
