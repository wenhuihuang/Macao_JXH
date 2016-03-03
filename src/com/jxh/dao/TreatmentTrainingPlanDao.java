package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.TreatmentTrainingPlan;

public class TreatmentTrainingPlanDao extends DaoImpl<TreatmentTrainingPlan>{

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
	public PageUtils<TreatmentTrainingPlan> getTreatmentTrainingPlanByCondition(PageUtils<TreatmentTrainingPlan> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<TreatmentTrainingPlan> treatmentTrainingPlan = this.findForList(sql, params);
		page.setList(treatmentTrainingPlan);
		
		return page;
	}
	
	
	
	
	public int[] insertTreatmentTrainingPlan(List<TreatmentTrainingPlan> treatmentTrainingPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, treatmentTrainingPlan);
	}
	
	
	public int updateTreatmentTrainingPlan(List<TreatmentTrainingPlan> treatmentTrainingPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, treatmentTrainingPlan);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteTreatmentTrainingPlan(List<TreatmentTrainingPlan> treatmentTrainingPlan) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[treatmentTrainingPlan.size()][1];
		for (int i = 0;i<treatmentTrainingPlan.size();i++) {
			params[i][0] = treatmentTrainingPlan.get(i).getTrainingID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteTreatmentTrainingPlanByTreatmentID(String treatmentID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, treatmentID);
	}
	
	public TreatmentTrainingPlan getTreatmentTrainingPlanByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (TreatmentTrainingPlan) this.findForObject(sql, params);
	}
	
}
