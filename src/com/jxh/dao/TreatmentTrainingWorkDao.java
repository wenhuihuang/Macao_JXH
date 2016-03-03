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
		return "/sqls/Macao_JXH/treatmenttrainingwork.properties";
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
	
	
	
	
	public int insertTreatmentTrainingWork(TreatmentTrainingWork treatmentTrainingWork) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, treatmentTrainingWork);
		return this.update(sql, params);
	}
	
	
	public int updateTreatmentTrainingWork(TreatmentTrainingWork treatmentTrainingWork) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql ="update TreatmentTrainingWork set treatmentID=?,beginDate=?,endDate=?,duty=?,corp=?,place=?,workTime=?,content=?,workDetail=?,envioment=?,handler=?,handleDate=?,handleSuggest=? where treatmentID = ? ";
		Object[] params = getUpdateParams(sql, treatmentTrainingWork);
		return this.update(sql, params);
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

	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("TREATMENTTRAININGWORK", corpId, 20);
	}
	
}
