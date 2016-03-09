package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.DormitoryTrainingRecordDetail;

public class DormitoryTrainingRecordDetailDao extends DaoImpl<DormitoryTrainingRecordDetail>{

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
	public PageUtils<DormitoryTrainingRecordDetail> getDormitoryTrainingRecordDetailByCondition(PageUtils<DormitoryTrainingRecordDetail> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingRecordDetail> dormitoryTrainingRecordDetail = this.findForList(sql, params);
		page.setList(dormitoryTrainingRecordDetail);
		
		return page;
	}
	
	
	
	
	public int[] insertDormitoryTrainingRecordDetail(List<DormitoryTrainingRecordDetail> dormitoryTrainingRecordDetail) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, dormitoryTrainingRecordDetail);
	}
	
	
	public int updateDormitoryTrainingRecordDetail(List<DormitoryTrainingRecordDetail> dormitoryTrainingRecordDetail) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, dormitoryTrainingRecordDetail);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteDormitoryTrainingRecordDetail(List<DormitoryTrainingRecordDetail> dormitoryTrainingRecordDetail) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[dormitoryTrainingRecordDetail.size()][1];
		for (int i = 0;i<dormitoryTrainingRecordDetail.size();i++) {
			params[i][0] = dormitoryTrainingRecordDetail.get(i).getDetailID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteDormitoryTrainingRecordDetailByMasterRecordID(String tRecordID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, tRecordID);
	}
	
	public DormitoryTrainingRecordDetail getDormitoryTrainingRecordDetailByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingRecordDetail) this.findForObject(sql, params);
	}
	
}
