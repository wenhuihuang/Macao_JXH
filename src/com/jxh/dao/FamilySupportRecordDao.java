package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.FamilySupportRecord;

public class FamilySupportRecordDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/familysupportrecord.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<FamilySupportRecord> getFamilySupportRecordByCondition(PageUtils<FamilySupportRecord> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = FamilySupportRecord.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<FamilySupportRecord> familySupportRecord = this.findForList(sql, params);
		page.setList(familySupportRecord);
		
		return page;
	}
	
	
	
	
	public int insertFamilySupportRecord(FamilySupportRecord familySupportRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, familySupportRecord);
		return this.update(sql, params);
	}
	
	public int updateFamilySupportRecord(FamilySupportRecord familySupportRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, familySupportRecord);
		return this.update(sql, params);
	}
	
	
	
	public int deleteFamilySupportRecord(List<FamilySupportRecord> familySupportRecord) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[familySupportRecord.size()][1];
		for (int i = 0;i<familySupportRecord.size();i++) {
			params[i][0] = familySupportRecord.get(i).getRecordID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	
	public int deleteFamilySupportRecordByApplyID(String applyID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, applyID);
	}
	
	public FamilySupportRecord getFamilySupportRecordByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = FamilySupportRecord.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		return  (FamilySupportRecord) this.findForObject(sql, params);
	}

	public int[] insertFamilySupportRecordBatch(List<FamilySupportRecord> familySupportRecords) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		String sql = this.getSqlByPropKey("insertFamilySupportRecord");
		return insertBatchByList(sql, familySupportRecords);
	}

	public int[] updateFamilySupportRecordBatch(List<FamilySupportRecord> familySupportRecords) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		String sql = this.getSqlByPropKey("updateFamilySupportRecord");
		return updateBatchByList(sql, familySupportRecords);
	}

	public int deleteFamilySupportRecordBySupportID(String supportID) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return this.update(sql, supportID);
	}
	
	
}
