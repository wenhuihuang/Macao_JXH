package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.DormitoryTrainingADPlan;

public class DormitoryTrainingADPlanDao extends DaoImpl<DormitoryTrainingADPlan>{

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
	public PageUtils<DormitoryTrainingADPlan> getDormitoryTrainingADPlanByCondition(PageUtils<DormitoryTrainingADPlan> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingADPlan> dormitoryTrainingADPlan = this.findForList(sql, params);
		page.setList(dormitoryTrainingADPlan);
		
		return page;
	}
	
	
	
	
	public int insertDormitoryTrainingADPlan(DormitoryTrainingADPlan dormitoryTrainingADPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, dormitoryTrainingADPlan);
		return this.update(sql, params);
		//return insertBatchByList(sql, dormitoryTrainingADPlan);
	}
	
	
	public int updateDormitoryTrainingADPlan(List<DormitoryTrainingADPlan> dormitoryTrainingADPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, dormitoryTrainingADPlan);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteDormitoryTrainingADPlan(List<DormitoryTrainingADPlan> dormitoryTrainingADPlan) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[dormitoryTrainingADPlan.size()][1];
		for (int i = 0;i<dormitoryTrainingADPlan.size();i++) {
			params[i][0] = dormitoryTrainingADPlan.get(i).getaPlanID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteDormitoryTrainingADPlanByAPlanID(String aPlanID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, aPlanID);
	}
	
	public DormitoryTrainingADPlan getDormitoryTrainingADPlanByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingADPlan) this.findForObject(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("DORMITORYTRAININGADPLAN", corpId, 20);
	}
	
}
