package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.GroupSettingRecordBudget;

public class GroupSettingRecordBudgetDao extends DaoImpl<GroupSettingRecordBudget>{

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
	public PageUtils<GroupSettingRecordBudget> getGroupSettingRecordBudgetByCondition(PageUtils<GroupSettingRecordBudget> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<GroupSettingRecordBudget> groupSettingRecordBudget = this.findForList(sql, params);
		page.setList(groupSettingRecordBudget);
		
		return page;
	}
	
	
	
	
	public int[] insertGroupSettingRecordBudget(List<GroupSettingRecordBudget> groupSettingRecordBudget) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, groupSettingRecordBudget);
	}
	
	
	public int updateGroupSettingRecordBudget(List<GroupSettingRecordBudget> groupSettingRecordBudget) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, groupSettingRecordBudget);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteGroupSettingRecordBudget(List<GroupSettingRecordBudget> groupSettingRecordBudget) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[groupSettingRecordBudget.size()][1];
		for (int i = 0;i<groupSettingRecordBudget.size();i++) {
			params[i][0] = groupSettingRecordBudget.get(i).getBudgetID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteGroupSettingRecordBudgetByBudgetID(String budgetID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, budgetID);
	}
	
	public GroupSettingRecordBudget getGroupSettingRecordBudgetByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (GroupSettingRecordBudget) this.findForObject(sql, params);
	}
	
}
