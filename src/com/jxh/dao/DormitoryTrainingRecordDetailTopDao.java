package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.DormitoryTrainingRecordDetailTop;

public class DormitoryTrainingRecordDetailTopDao extends DaoImpl<DormitoryTrainingRecordDetailTop>{

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
	public PageUtils<DormitoryTrainingRecordDetailTop> getDormitoryTrainingRecordDetailTopByCondition(PageUtils<DormitoryTrainingRecordDetailTop> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTop = this.findForList(sql, params);
		page.setList(dormitoryTrainingRecordDetailTop);
		
		return page;
	}
	
	
	
	
	public int[] insertDormitoryTrainingRecordDetailTop(List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTop) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, dormitoryTrainingRecordDetailTop);
	}
	
	
	public int updateDormitoryTrainingRecordDetailTop(List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTop) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, dormitoryTrainingRecordDetailTop);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteDormitoryTrainingRecordDetailTop(List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTop) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[dormitoryTrainingRecordDetailTop.size()][1];
		for (int i = 0;i<dormitoryTrainingRecordDetailTop.size();i++) {
			params[i][0] = dormitoryTrainingRecordDetailTop.get(i).getDetailID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteDormitoryTrainingRecordDetailTopByMasterRecordID(String tRecordID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, tRecordID);
	}
	
	public DormitoryTrainingRecordDetailTop getDormitoryTrainingRecordDetailTopByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingRecordDetailTop) this.findForObject(sql, params);
	}
	
}
