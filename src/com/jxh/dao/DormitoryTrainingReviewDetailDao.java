package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.DormitoryTrainingReviewDetail;

public class DormitoryTrainingReviewDetailDao extends DaoImpl<DormitoryTrainingReviewDetail>{

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
	public PageUtils<DormitoryTrainingReviewDetail> getDormitoryTrainingReviewDetailByCondition(PageUtils<DormitoryTrainingReviewDetail> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetail = this.findForList(sql, params);
		page.setList(dormitoryTrainingReviewDetail);
		
		return page;
	}
	
	
	
	
	public int[] insertDormitoryTrainingReviewDetail(List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetail) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, dormitoryTrainingReviewDetail);
	}
	
	
	public int updateDormitoryTrainingReviewDetail(List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetail) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, dormitoryTrainingReviewDetail);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteDormitoryTrainingReviewDetail(List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetail) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[dormitoryTrainingReviewDetail.size()][1];
		for (int i = 0;i<dormitoryTrainingReviewDetail.size();i++) {
			params[i][0] = dormitoryTrainingReviewDetail.get(i).getReviewID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteDormitoryTrainingReviewDetailByReviewID(String reviewID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, reviewID);
	}
	
	public DormitoryTrainingReviewDetail getDormitoryTrainingReviewDetailByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingReviewDetail) this.findForObject(sql, params);
	}
	
}
