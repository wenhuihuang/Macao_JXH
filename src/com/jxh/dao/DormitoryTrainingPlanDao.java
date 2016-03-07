package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.DormitoryTrainingPlan;

public class DormitoryTrainingPlanDao extends DaoImpl<DormitoryTrainingPlan> {
	
	@Override
	protected String getSqlPropertiesPath() {
		return null;
	}
	
	public PageUtils<DormitoryTrainingPlan> getDormitoryTrainingPlan(PageUtils<DormitoryTrainingPlan> page,String condition,Object...params) throws IOException, SQLException{
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<DormitoryTrainingPlan> dormitoryTrainingPlan = this.findForList(sql, params);
		page.setList(dormitoryTrainingPlan);
		
		return page;
	}

	public DormitoryTrainingPlan getDormitoryTrainingPlanByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = DormitoryTrainingPlan.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingPlan) this.findForObject(sql, params);
	}

	public int updateDormitoryTrainingPlan(DormitoryTrainingPlan dormitoryTrainingPlan) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, dormitoryTrainingPlan);
		return this.update(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("DORMITORYTRAININGPLAN", corpId, 20);
	}
	
	public int insertDormitoryTrainingPlan(DormitoryTrainingPlan dormitoryTrainingPlan) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, dormitoryTrainingPlan);
		return this.update(sql, params);
	}
	
	public int deleteDormitoryTrainingPlanByPlanID(String planID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from Treatment where treatmentID = ? ";
		return this.update(sql, planID);
	}
	
}
