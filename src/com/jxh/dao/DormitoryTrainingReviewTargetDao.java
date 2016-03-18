package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.DormitoryTrainingReviewTargetPojo;
import com.jxh.vo.DormitoryTrainingReviewTarget;

public class DormitoryTrainingReviewTargetDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return "/sqls/Macao_JXH/dormitorytrainingreviewtarget.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<DormitoryTrainingReviewTarget> getDormitoryTrainingReviewTargetByCondition(PageUtils<DormitoryTrainingReviewTarget> page, String condition,Object ...params) throws SQLException, IOException{
		clazz=DormitoryTrainingReviewTarget.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTarget = this.findForList(sql, params);
		page.setList(dormitoryTrainingReviewTarget);
		
		return page;
	}
	
	public PageUtils<DormitoryTrainingReviewTargetPojo> getDormitoryTrainingReviewTargetPojoByCondition(PageUtils<DormitoryTrainingReviewTargetPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz=DormitoryTrainingReviewTargetPojo.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingReviewTargetPojo> dormitoryTrainingReviewTargetPojo = this.findForList(sql, params);
		page.setList(dormitoryTrainingReviewTargetPojo);
		
		return page;
	}
	
	
	
	
	public int[] insertDormitoryTrainingReviewTarget(List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTarget) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, dormitoryTrainingReviewTarget);
	}
	
	
	public int updateDormitoryTrainingReviewTarget(List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTarget) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, dormitoryTrainingReviewTarget);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteDormitoryTrainingReviewTarget(List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTarget) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[dormitoryTrainingReviewTarget.size()][1];
		for (int i = 0;i<dormitoryTrainingReviewTarget.size();i++) {
			params[i][0] = dormitoryTrainingReviewTarget.get(i).getReviewID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteDormitoryTrainingReviewTargetByReviewID(String reviewID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, reviewID);
	}
	
	public DormitoryTrainingReviewTarget getDormitoryTrainingReviewTargetByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz=DormitoryTrainingReviewTarget.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingReviewTarget) this.findForObject(sql, params);
	}
	
}
