package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.CSSA;
import com.jxh.vo.SpecialAllowance;

public class SpecialAllowanceDao extends DaoImpl<SpecialAllowance> {

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
	public PageUtils<SpecialAllowance> getSpecialAllowanceByCondition(PageUtils<SpecialAllowance> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<SpecialAllowance> specialAllowances = this.findForList(sql, params);
		page.setList(specialAllowances);
		
		return page;
	}
	
	
	
	
	/**
	 * 新增特别津贴
	 * @param cssas
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 * @throws IOException
	 * @throws SQLException
	 */
	public int insertSpecialAllowance(List<SpecialAllowance> specialAllowances) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		int[] rows = insertBatchByList(sql, specialAllowances);
		return getflagByIntArray(rows);
	}
	
	
	/**
	 * 更新特别津贴
	 * @param cssas
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws ParseException
	 * @throws IOException
	 */
	public int updateSpecialAllowance(List<SpecialAllowance> specialAllowances) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, specialAllowances);
		
		return getflagByIntArray(rows);
	}
	
	
	
	/**
	 * 删除特别津贴
	 * @param cssas
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public int deleteSpecialAllowance(List<SpecialAllowance> specialAllowances) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[specialAllowances.size()][1];
		for (int i = 0;i<specialAllowances.size();i++) {
			params[i][0] = specialAllowances.get(i).getSpecialAllowanceID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	public int deleteSpecialAllowanceByCustID(String custID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return this.update(sql, custID);
	}
}
