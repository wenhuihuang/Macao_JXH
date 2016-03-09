package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.DormitoryTrainingReview;

public class DormitoryTrainingReviewDao extends DaoImpl<DormitoryTrainingReview>{

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
	public PageUtils<DormitoryTrainingReview> getDormitoryTrainingReviewByCondition(PageUtils<DormitoryTrainingReview> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingReview> dormitoryTrainingReview = this.findForList(sql, params);
		page.setList(dormitoryTrainingReview);
		
		return page;
	}
	
	
	
	
	public int insertDormitoryTrainingReview(DormitoryTrainingReview dormitoryTrainingReview) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, dormitoryTrainingReview);
		return this.update(sql, params);
		//return insertBatchByList(sql, dormitoryTrainingADPlan);
	}
	
	
	public int updateDormitoryTrainingReview(DormitoryTrainingReview dormitoryTrainingReview) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		Object[] params = getUpdateParams(sql, dormitoryTrainingReview);
		
		return this.update(sql, params);
	}
	
	
	
/*	public int deleteDormitoryTrainingRecord(List<DormitoryTrainingRecord> dormitoryTrainingRecord) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[dormitoryTrainingRecord.size()][1];
		for (int i = 0;i<dormitoryTrainingRecord.size();i++) {
			params[i][0] = dormitoryTrainingRecord.get(i).getPlanID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}*/
	
	public int deleteDormitoryTrainingReviewByRecordID(String recordID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, recordID);
	}
	
	public DormitoryTrainingReview getDormitoryTrainingReviewByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingReview) this.findForObject(sql, params);
	}
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("DROMITROTYTRAININGREVIEW", corpId, 20);
	}
	
}
