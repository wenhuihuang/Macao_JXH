package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.TreatmentTrainingWork;

public class TreatmentTrainingWorkDao extends DaoImpl<TreatmentTrainingWork>{

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
	public PageUtils<TreatmentTrainingWork> getTreatmentTrainingWorkByCondition(PageUtils<TreatmentTrainingWork> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<TreatmentTrainingWork> treatmentTrainingWork = this.findForList(sql, params);
		page.setList(treatmentTrainingWork);
		
		return page;
	}
	
	
	
	
	public int[] insertTreatmentTrainingWork(List<TreatmentTrainingWork> treatmentTrainingWork) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, treatmentTrainingWork);
	}
	
	
	public int updateTreatmentTrainingWork(List<TreatmentTrainingWork> treatmentTrainingWork) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, treatmentTrainingWork);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteTreatmentTrainingWork(List<TreatmentTrainingWork> treatmentTrainingWork) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[treatmentTrainingWork.size()][1];
		for (int i = 0;i<treatmentTrainingWork.size();i++) {
			params[i][0] = treatmentTrainingWork.get(i).getTrainingID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteTreatmentTrainingWorkByTreatmentID(String treatmentID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, treatmentID);
	}
	
	public TreatmentTrainingWork getTreatmentTrainingWorkByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (TreatmentTrainingWork) this.findForObject(sql, params);
	}
	
}
