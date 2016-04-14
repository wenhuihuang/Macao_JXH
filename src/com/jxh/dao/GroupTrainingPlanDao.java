package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.GroupTrainingPlan;
import com.jxh.vo.TreatmentPlan;

public class GroupTrainingPlanDao extends DaoImpl<GroupTrainingPlan>{

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
	public PageUtils<GroupTrainingPlan> getGroupTrainingPlanByCondition(PageUtils<GroupTrainingPlan> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<GroupTrainingPlan> groupTrainingPlan = this.findForList(sql, params);
		page.setList(groupTrainingPlan);
		
		return page;
	}
	
	
	
	
	public int[] insertGroupTrainingPlan(List<GroupTrainingPlan> groupTrainingPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, groupTrainingPlan);
	}
	
	
	public int updateGroupTrainingPlan(List<GroupTrainingPlan> groupTrainingPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, groupTrainingPlan);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteGroupTrainingPlan(List<GroupTrainingPlan> groupTrainingPlan) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[groupTrainingPlan.size()][1];
		for (int i = 0;i<groupTrainingPlan.size();i++) {
			params[i][0] = groupTrainingPlan.get(i).getPlanID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteGroupTrainingPlanByTreatmentID(String treatmentID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, treatmentID);
	}
	
}
