package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.DormitoryTrainingReviewSettle;

public class DormitoryTrainingReviewSettleDao extends DaoImpl<DormitoryTrainingReviewSettle>{

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
	public PageUtils<DormitoryTrainingReviewSettle> getDormitoryTrainingReviewSettleByCondition(PageUtils<DormitoryTrainingReviewSettle> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettle = this.findForList(sql, params);
		page.setList(dormitoryTrainingReviewSettle);
		
		return page;
	}
	
	
	
	
	public int[] insertDormitoryTrainingReviewSettle(List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, dormitoryTrainingReviewSettle);
	}
	
	
	public int updateDormitoryTrainingReviewSettle(List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, dormitoryTrainingReviewSettle);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteDormitoryTrainingReviewSettle(List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettle) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[dormitoryTrainingReviewSettle.size()][1];
		for (int i = 0;i<dormitoryTrainingReviewSettle.size();i++) {
			params[i][0] = dormitoryTrainingReviewSettle.get(i).getReviewID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteDormitoryTrainingReviewSettleByReviewID(String reviewID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, reviewID);
	}
	
	public DormitoryTrainingReviewSettle getDormitoryTrainingReviewSettleByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingReviewSettle) this.findForObject(sql, params);
	}
	
}
