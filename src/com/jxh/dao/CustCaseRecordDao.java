package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.BCustCaseRecordPojo;

public class CustCaseRecordDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return "/sqls/Macao_JXH/bcustcaserecord.properties";
	}
	
	/**
	 * 
	 * @param page
	 * @param condition
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public PageUtils<BCustCaseRecordPojo> getBCustCaseRecordList(PageUtils<BCustCaseRecordPojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = BCustCaseRecordPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		List<BCustCaseRecordPojo> pojos = this.findForList(sql, params);
		page.setList(pojos);
		
		return page;
	}
	
	public BCustCaseRecordPojo getBCustCaseRecordPojoByCondition(String condition,Object...params) throws IOException, SQLException{
		clazz = BCustCaseRecordPojo.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		return (BCustCaseRecordPojo) this.findForObject(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("BCUSTOMER", corpId, 20);
	}
	
	
}
