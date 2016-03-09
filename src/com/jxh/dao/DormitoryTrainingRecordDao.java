package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.DormitoryTrainingRecord;

public class DormitoryTrainingRecordDao extends DaoImpl<DormitoryTrainingRecord>{

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<DormitoryTrainingRecord> getDormitoryTrainingRecordByCondition(PageUtils<DormitoryTrainingRecord> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingRecord> dormitoryTrainingRecord = this.findForList(sql, params);
		page.setList(dormitoryTrainingRecord);
		
		return page;
	}
	
	
	
	
	public int insertDormitoryTrainingRecord(DormitoryTrainingRecord dormitoryTrainingRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, dormitoryTrainingRecord);
		return this.update(sql, params);
		//return insertBatchByList(sql, dormitoryTrainingADPlan);
	}
	
	
	public int updateDormitoryTrainingRecord(DormitoryTrainingRecord dormitoryTrainingRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		Object[] params = getUpdateParams(sql, dormitoryTrainingRecord);
		
		return this.update(sql, params);
	}
	
	
	
/*	public int deleteDormitoryTrainingRecord(List<DormitoryTrainingRecord> dormitoryTrainingRecord) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[dormitoryTrainingRecord.size()][1];
		for (int i = 0;i<dormitoryTrainingRecord.size();i++) {
			params[i][0] = dormitoryTrainingRecord.get(i).getPlanID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}*/
	
	public int deleteDormitoryTrainingRecordByTRecordID(String tRecordID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, tRecordID);
	}
	
	public DormitoryTrainingRecord getDormitoryTrainingRecordByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingRecord) this.findForObject(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("DROMITROTYTRAININGRECORD", corpId, 20);
	}
	
}
