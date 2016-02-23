package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.BCustomerSchool;
import com.jxh.vo.CSSA;

public class BCustomerSchoolDao extends DaoImpl<BCustomerSchool>{

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
	public PageUtils<BCustomerSchool> getBCustomerSchoolByCondition(PageUtils<BCustomerSchool> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<BCustomerSchool> bCustomerSchool = this.findForList(sql, params);
		page.setList(bCustomerSchool);
		
		return page;
	}
	
	
	
	
	public int[] insertBCustomerSchool(List<BCustomerSchool> bCustomerSchool) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, bCustomerSchool);
	}
	
	
	public int updateBCustomerSchool(List<BCustomerSchool> bCustomerSchool) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, bCustomerSchool);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteBCustomerSchool(List<BCustomerSchool> bCustomerSchool) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[bCustomerSchool.size()][1];
		for (int i = 0;i<bCustomerSchool.size();i++) {
			params[i][0] = bCustomerSchool.get(i).getCustID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
}
