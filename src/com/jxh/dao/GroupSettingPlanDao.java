package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.GroupSettingPlan;

public class GroupSettingPlanDao extends DaoImpl<GroupSettingPlan>{

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
	public PageUtils<GroupSettingPlan> getGroupSettingPlanByCondition(PageUtils<GroupSettingPlan> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<GroupSettingPlan> groupSettingPlan = this.findForList(sql, params);
		page.setList(groupSettingPlan);
		
		return page;
	}
	
	
	
	
	public int[] insertGroupSettingPlan(List<GroupSettingPlan> groupSettingPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, groupSettingPlan);
	}
	
	
	public int updateGroupSettingPlan(List<GroupSettingPlan> groupSettingPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, groupSettingPlan);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteGroupSettingPlan(List<GroupSettingPlan> groupSettingPlan) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[groupSettingPlan.size()][1];
		for (int i = 0;i<groupSettingPlan.size();i++) {
			params[i][0] = groupSettingPlan.get(i).getPlanID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteGroupSettingPlanByPlanID(String planID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, planID);
	}
	
	public int deleteGroupSettingPlanByRecordID(String recordID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, recordID);
	}
	
	public GroupSettingPlan getGroupSettingPlanByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (GroupSettingPlan) this.findForObject(sql, params);
	}
	
	public int[] insertGroupSettingPlanBatch(List<GroupSettingPlan> groupSettingPlan) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey("insertGroupSettingPlan");
		Object[][] params = new Object[groupSettingPlan.size()][];
		for(int i = 0;i<groupSettingPlan.size();i++){
			params[i] = getInsertParams(sql, groupSettingPlan.get(i));
		}
		return this.updateBatch(sql, params);
	}
	
}
