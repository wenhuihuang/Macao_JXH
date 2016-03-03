package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.TreatmentTrainingWorkRecord;

public class TreatmentTrainingWorkRecordDao extends DaoImpl<TreatmentTrainingWorkRecord>{

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
	public PageUtils<TreatmentTrainingWorkRecord> getTreatmentTrainingWorkRecordByCondition(PageUtils<TreatmentTrainingWorkRecord> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<TreatmentTrainingWorkRecord> treatmentTrainingWorkRecord = this.findForList(sql, params);
		page.setList(treatmentTrainingWorkRecord);
		
		return page;
	}
	
	
	
	
	public int[] insertTreatmentTrainingWorkRecord(List<TreatmentTrainingWorkRecord> treatmentTrainingWorkRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, treatmentTrainingWorkRecord);
	}
	
	
	public int[] updateTreatmentTrainingWorkRecordBatch(List<TreatmentTrainingWorkRecord> treatmentTrainingWorkRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey("updateTreatmentTrainingWorkRecord");
		
		Object[][] params = new Object[treatmentTrainingWorkRecord.size()][];
		for (int i = 0; i < treatmentTrainingWorkRecord.size(); i++) {
			params[i] = getUpdateParams(sql, treatmentTrainingWorkRecord.get(i));
		}
		return this.updateBatch(sql, params);
		
	}
	
	
	
	public int deleteTreatmentTrainingWorkRecord(List<TreatmentTrainingWorkRecord> treatmentTrainingWorkRecord) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[treatmentTrainingWorkRecord.size()][1];
		for (int i = 0;i<treatmentTrainingWorkRecord.size();i++) {
			params[i][0] = treatmentTrainingWorkRecord.get(i).getWorkID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteTreatmentTrainingWorkRecordByTreatmentID(String treatmentID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, treatmentID);
	}
	
	public TreatmentTrainingWorkRecord getTreatmentTrainingWorkRecordByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (TreatmentTrainingWorkRecord) this.findForObject(sql, params);
	}
	
}
