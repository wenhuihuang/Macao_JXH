package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.TreatmentFamily;

public class TreatmentFamilyDao extends DaoImpl<TreatmentFamily>{

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
	public PageUtils<TreatmentFamily> getTreatmentFamilyByCondition(PageUtils<TreatmentFamily> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<TreatmentFamily> treatmentFamily = this.findForList(sql, params);
		page.setList(treatmentFamily);
		
		return page;
	}
	
	
	
	
	public int[] insertTreatmentFamily(List<TreatmentFamily> treatmentFamily) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, treatmentFamily);
	}
	
	
	public int updateTreatmentFamily(List<TreatmentFamily> treatmentFamily) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, treatmentFamily);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteTreatmentFamily(List<TreatmentFamily> treatmentFamily) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[treatmentFamily.size()][1];
		for (int i = 0;i<treatmentFamily.size();i++) {
			params[i][0] = treatmentFamily.get(i).getTreatmentID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
}
