package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.TreatmentRecord;

public class TreatmentRecordDao extends DaoImpl<TreatmentRecord>{

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
	public PageUtils<TreatmentRecord> getTreatmentRecordByCondition(PageUtils<TreatmentRecord> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<TreatmentRecord> treatmentRecord = this.findForList(sql, params);
		page.setList(treatmentRecord);
		
		return page;
	}
	
	
	
	
	public int[] insertTreatmentRecord(List<TreatmentRecord> treatmentRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, treatmentRecord);
	}
	
	
	public int updateTreatmentRecord(List<TreatmentRecord> treatmentRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, treatmentRecord);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteTreatmentRecord(List<TreatmentRecord> treatmentRecord) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[treatmentRecord.size()][1];
		for (int i = 0;i<treatmentRecord.size();i++) {
			params[i][0] = treatmentRecord.get(i).getTreatmentID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
}
