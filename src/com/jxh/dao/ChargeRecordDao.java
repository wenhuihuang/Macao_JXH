package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.ChargeRecord;

public class ChargeRecordDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/chargerecord.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<ChargeRecord> getChargeRecord(PageUtils<ChargeRecord> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = ChargeRecord.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<ChargeRecord> chargeRecord = this.findForList(sql, params);
		page.setList(chargeRecord);
		
		return page;
	}
	
	
	
	
	public int[] insertChargeRecordBatch(List<ChargeRecord> chargeRecords) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey("insertChargeRecord");
		Object[] params = getInsertParams(sql, chargeRecords);
		return insertBatchByList(sql, chargeRecords);
	}
	
	
	public int updateChargeRecordBatch(List<ChargeRecord> chargeRecords) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey("updateChargeRecord");
		int[] rows = updateBatchByList(sql, chargeRecords);
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteChargeRecord(List<ChargeRecord> chargeRecord) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[chargeRecord.size()][1];
		for (int i = 0;i<chargeRecord.size();i++) {
			params[i][0] = chargeRecord.get(i).getChargeID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	
	public int deleteChargeRecordByChargeID(String chargeID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, chargeID);
	}
	
	public ChargeRecord getChargeRecordByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = ChargeRecord.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		return  (ChargeRecord) this.findForObject(sql, params);
	}
	
	public int deleteChargeRecordBatch(List<ChargeRecord> chargeRecord) throws IOException, SQLException{
		String sql = this.getSqlByPropKey("deleteChargeRecord");
		Object[][] params = new Object[chargeRecord.size()][1];
		for (int i = 0;i<chargeRecord.size();i++) {
			params[i][0] = chargeRecord.get(i).getChargeID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("CHARGERECORD", corpId, 20);
	}
	
}
