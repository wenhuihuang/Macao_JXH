package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.TreatmentPojo;
import com.jxh.pojo.TreatmentReportPojo;
import com.jxh.vo.Treatment;
import com.jxh.vo.TreatmentReport;

public class TreatmentReportDao extends DaoImpl {
	
	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/treatmentreport.properties";
	}
	
	public PageUtils<TreatmentReport> getTreatmentReport(PageUtils<TreatmentReport> page,String condition,Object...params) throws IOException, SQLException{
		clazz = TreatmentReport.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<TreatmentReport> treatmentReport = this.findForList(sql, params);
		page.setList(treatmentReport);
		
		return page;
	}

	public TreatmentReport getTreatmentReportByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = TreatmentReport.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (TreatmentReport) this.findForObject(sql, params);
	}
	
	public int updateTreatmentReport(TreatmentReport treatment) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		// TODO Auto-generated method stub
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, treatment);
		return this.update(sql, params);
	}
	
	
	public int deleteTreatmentReportByTreatmentID(String treatmentID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentReport where treatmentID = ? ";
		return this.update(sql, treatmentID);
	}
	
	public int insertTreatmentReport(TreatmentReport treatmentReport) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, treatmentReport);
		return this.update(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("BCUSTOMER", corpId, 20);
	}

	public TreatmentReportPojo getTreatmentReportPojoByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = TreatmentReportPojo.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (TreatmentReportPojo) this.findForObject(sql, params);
	}
}
