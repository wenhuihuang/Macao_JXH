package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.BtypeCode;

public class BtypeCodeDao extends DaoImpl {

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public PageUtils<BtypeCode> getAllTypeCodeByTypeBase(PageUtils<BtypeCode> page,String condition,Object...params) throws IOException, SQLException{
		clazz = BtypeCode.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = "SELECT * FROM bTypeCode where TypeBase = ? ";
		//String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<BtypeCode> pojos = this.findForList(sql, params);
		page.setList(pojos);
		
		return page;
	}
	/**
	 * 根据TypeBase获取TypeCode
	 * @param typeBase
	 * @return
	 * @throws SQLException 
	 */
	public List<BtypeCode> getAllTypeCodeByTypeBase(String typeBase) throws SQLException{
		clazz = BtypeCode.class;
		String sql ="SELECT * FROM bTypeCode where TypeBase = ? ";
		List<BtypeCode> list = this.findForList(sql, typeBase);
		return list;
	}
}
