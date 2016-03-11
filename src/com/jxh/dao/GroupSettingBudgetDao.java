package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.GroupSettingBudget;

public class GroupSettingBudgetDao extends DaoImpl<GroupSettingBudget>{

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
	public PageUtils<GroupSettingBudget> getGroupSettingBudgetByCondition(PageUtils<GroupSettingBudget> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<GroupSettingBudget> groupSettingBudget = this.findForList(sql, params);
		page.setList(groupSettingBudget);
		
		return page;
	}
	
	
	
	
	public int[] insertGroupSettingBudget(List<GroupSettingBudget> groupSettingBudget) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, groupSettingBudget);
	}
	
	
	public int updateGroupSettingBudget(List<GroupSettingBudget> groupSettingBudget) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, groupSettingBudget);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteGroupSettingBudget(List<GroupSettingBudget> groupSettingBudget) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[groupSettingBudget.size()][1];
		for (int i = 0;i<groupSettingBudget.size();i++) {
			params[i][0] = groupSettingBudget.get(i).getBudgetID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteGroupSettingBudgetByBudgetID(String budgetID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, budgetID);
	}
	
	public GroupSettingBudget getGroupSettingBudgetByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (GroupSettingBudget) this.findForObject(sql, params);
	}
	
}
