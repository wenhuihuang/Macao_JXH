package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.GroupTrainingRecord;
import com.jxh.vo.TreatmentPlan;

public class GroupTrainingRecordDao extends DaoImpl<GroupTrainingRecord>{

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
	public PageUtils<GroupTrainingRecord> getGroupTrainingRecordByCondition(PageUtils<GroupTrainingRecord> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<GroupTrainingRecord> groupTrainingRecord = this.findForList(sql, params);
		page.setList(groupTrainingRecord);
		
		return page;
	}
	
	
	
	
	public int[] insertGroupTrainingRecord(List<GroupTrainingRecord> groupTrainingRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, groupTrainingRecord);
	}
	
	
	public int updateGroupTrainingRecord(List<GroupTrainingRecord> groupTrainingRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, groupTrainingRecord);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteGroupTrainingRecord(List<GroupTrainingRecord> groupTrainingRecord) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[groupTrainingRecord.size()][1];
		for (int i = 0;i<groupTrainingRecord.size();i++) {
			params[i][0] = groupTrainingRecord.get(i).getRecordID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteGroupTrainingRecordByTreatmentID(String treatmentID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, treatmentID);
	}
	
}
