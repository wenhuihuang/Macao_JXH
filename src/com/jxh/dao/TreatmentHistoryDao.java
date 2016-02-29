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
import com.jxh.vo.TreatmentHistory;

public class TreatmentHistoryDao extends DaoImpl<TreatmentHistory>{

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
	public PageUtils<TreatmentHistory> getTreatmentHistoryByCondition(PageUtils<TreatmentHistory> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<TreatmentHistory> treatmentHistory = this.findForList(sql, params);
		page.setList(treatmentHistory);
		
		return page;
	}
	
	
	public int[] insertTreatmentHistory(List<TreatmentHistory> treatmentHistory) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, treatmentHistory);
	}
	
	
	public int updateTreatmentHistory(List<TreatmentHistory> treatmentHistory) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, treatmentHistory);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteTreatmentHistory(List<TreatmentHistory> treatmentHistory) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[treatmentHistory.size()][1];
		for (int i = 0;i<treatmentHistory.size();i++) {
			params[i][0] = treatmentHistory.get(i).getCustID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteTreatmentHistoryByCustID(String custID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from treatmentHistory where custID = ? ";
		return this.update(sql, custID);
	}
	
}
