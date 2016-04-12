package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.CustCasePojo;
import com.jxh.pojo.TreatmentPojo;
import com.jxh.vo.BCustCase;
import com.jxh.vo.Treatment;

public class TreatmentDao extends DaoImpl {
	
	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/treatment.properties";
	}
	
	public PageUtils<TreatmentPojo> getTreatmentPojo(PageUtils<TreatmentPojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = TreatmentPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<TreatmentPojo> languageTreatmentPojos = this.findForList(sql, params);
		page.setList(languageTreatmentPojos);
		
		return page;
	}
	
	public PageUtils<TreatmentPojo> getTreatmentFnPojo(PageUtils<TreatmentPojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = TreatmentPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<TreatmentPojo> languageTreatmentPojos = this.findForList(sql, params);
		page.setList(languageTreatmentPojos);
		
		return page;
	}

	public TreatmentPojo getTreatmentPojoByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = TreatmentPojo.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (TreatmentPojo) this.findForObject(sql, params);
	}

	public int updateTreatment(Treatment treatment) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		// TODO Auto-generated method stub
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, treatment);
		return this.update(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("TREATMENT", corpId, 20);
	}
	
	public String getTreatmentNO(String corpId) throws SQLException{
		return this.getPrimaryKey("TREATMENTNO", corpId, 4);
	}
	
	public int insertTreatment(Treatment treatment) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, treatment);
		return this.update(sql, params);
	}
	
	public int deleteTreatmentByTreatmentID(String treatmentID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from Treatment where treatmentID = ? ";
		return this.update(sql, treatmentID);
	}
	
}
