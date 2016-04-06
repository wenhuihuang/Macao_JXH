package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.Retarded;

public class RetardedDao extends DaoImpl<Retarded>{

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 获取智障登记资料
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<Retarded> getRetardedByCondition(PageUtils<Retarded> page,String condition ,Object...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		sql += condition==null||"".equals(condition)?"":condition;
		
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<Retarded> retardeds = this.findForList(sql, params);
		page.setList(retardeds);
		
		return page;
	}
	
	
	/**
	 * 增加
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws ParseException 
	 */
	public int[] insertRetarded(List<Retarded> retardeds) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException{
		
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, getInsertParams(sql, retarded));
		Object[][] params = new Object[retardeds.size()][];
		
		for(int i = 0;i<retardeds.size();i++){
			params[i] =getInsertParams(sql, retardeds.get(i));
		}
		
		
		return this.updateBatch(sql, params);
	}

	
	
	/**
	 * 修改
	 * @param retardedUpdates
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException 
	 */
	public int[] updateRetarded(List<Retarded> retardedUpdates) throws IOException, SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException {
		// TODO Auto-generated method stub
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		Object[][] params = new Object[retardedUpdates.size()][];
		
		for(int i = 0;i<retardedUpdates.size();i++){
			params[i] =getUpdateParams(sql, retardedUpdates.get(i));
		}
		
		return this.updateBatch(sql, params);
		
		
	}


	
	/**
	 * 删除
	 * @param retardedDeletes
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public int[] deleteRetardedById(List<Retarded> retardedDeletes) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		Object[][] params = new Object[retardedDeletes.size()][1];
		
		for(int i = 0;i<retardedDeletes.size();i++){
			params[i][0] = retardedDeletes.get(i).getRetardedID();
		}
		
		return this.updateBatch(sql, params);
	}
	
	
	public int deleteRetardedByCustID(String custID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return this.update(sql, custID);
	}
	
	
	
	
}
