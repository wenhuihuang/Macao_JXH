package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.TreatmentPojo;
import com.jxh.vo.TreatmentTraining;

public class TreatmentTrainingDao extends DaoImpl<TreatmentTraining>{

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
	public PageUtils<TreatmentTraining> getTreatmentTrainingByCondition(PageUtils<TreatmentTraining> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<TreatmentTraining> treatmentTraining = this.findForList(sql, params);
		page.setList(treatmentTraining);
		
		return page;
	}
	
	
	
	
	public int[] insertTreatmentTraining(List<TreatmentTraining> treatmentTraining) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, treatmentTraining);
	}
	
	
	public int updateTreatmentTraining(List<TreatmentTraining> treatmentTraining) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, treatmentTraining);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteTreatmentTraining(List<TreatmentTraining> treatmentTraining) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[treatmentTraining.size()][1];
		for (int i = 0;i<treatmentTraining.size();i++) {
			params[i][0] = treatmentTraining.get(i).getTreatmentID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteTreatmentTrainingByTreatmentID(String treatmentID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, treatmentID);
	}
	
	public TreatmentTraining getTreatmentTrainingByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (TreatmentTraining) this.findForObject(sql, params);
	}
	
}
