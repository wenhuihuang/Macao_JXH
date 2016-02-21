package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.CustCasePojo;
import com.jxh.pojo.LanguageTreatmentPojo;

public class TreatmentDao extends DaoImpl {
	
	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/treatment.properties";
	}
	
	public PageUtils<LanguageTreatmentPojo> getLanguageTreatmentPojo(PageUtils<LanguageTreatmentPojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = LanguageTreatmentPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<LanguageTreatmentPojo> languageTreatmentPojos = this.findForList(sql, params);
		page.setList(languageTreatmentPojos);
		
		return page;
	}

	public LanguageTreatmentPojo getTreatmentPojoByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = LanguageTreatmentPojo.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (LanguageTreatmentPojo) this.findForObject(sql, params);
	}

	
}
