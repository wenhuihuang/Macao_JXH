package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.CSSA;

public class CSSADao extends DaoImpl<CSSA>{

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
	public PageUtils<CSSA> getCSSAByCondition(PageUtils<CSSA> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<CSSA> cssas = this.findForList(sql, params);
		page.setList(cssas);
		
		return page;
	}
	
	
	
	
	/**
	 * 新增CSSA
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
	public int[] insertCSSA(List<CSSA> cssas) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, cssas);
	}
	
	
	/**
	 * 更新CSSA
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
	public int updateCSSA(List<CSSA> cssas) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, cssas);
		
		return getflagByIntArray(rows);
	}
	
	
	
	/**
	 * 删除CSSA
	 * @param cssas
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public int deleteCSSA(List<CSSA> cssas) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[cssas.size()][1];
		for (int i = 0;i<cssas.size();i++) {
			params[i][0] = cssas.get(i).getCSSACustID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
}
