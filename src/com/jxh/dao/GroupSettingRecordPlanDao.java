package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.GroupSettingRecordPlan;

public class GroupSettingRecordPlanDao extends DaoImpl<GroupSettingRecordPlan>{

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
	public PageUtils<GroupSettingRecordPlan> getGroupSettingRecordPlanByCondition(PageUtils<GroupSettingRecordPlan> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<GroupSettingRecordPlan> groupSettingRecordPlan = this.findForList(sql, params);
		page.setList(groupSettingRecordPlan);
		
		return page;
	}
	
	
	
	
	public int[] insertGroupSettingRecordPlan(List<GroupSettingRecordPlan> groupSettingRecordPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, groupSettingRecordPlan);
	}
	
	
	public int updateGroupSettingRecordPlan(List<GroupSettingRecordPlan> groupSettingRecordPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, groupSettingRecordPlan);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteGroupSettingRecordPlan(List<GroupSettingRecordPlan> groupSettingRecordPlan) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[groupSettingRecordPlan.size()][1];
		for (int i = 0;i<groupSettingRecordPlan.size();i++) {
			params[i][0] = groupSettingRecordPlan.get(i).getPlanID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteGroupSettingRecordPlanByPlanID(String planID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, planID);
	}
	
	public int deleteGroupSettingRecordPlanByRecordID(String recordID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, recordID);
	}
	
	public GroupSettingRecordPlan getGroupSettingRecordPlanByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (GroupSettingRecordPlan) this.findForObject(sql, params);
	}
	
	public int[] insertGroupSettingRecordPlanBatch(List<GroupSettingRecordPlan> groupSettingRecordPlan) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey("insertGroupSettingRecordPlan");
		Object[][] params = new Object[groupSettingRecordPlan.size()][];
		for(int i = 0;i<groupSettingRecordPlan.size();i++){
			params[i] = getInsertParams(sql, groupSettingRecordPlan.get(i));
		}
		return this.updateBatch(sql, params);
	}
	
}
