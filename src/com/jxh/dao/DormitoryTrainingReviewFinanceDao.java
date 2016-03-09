package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.DormitoryTrainingReviewFinance;

public class DormitoryTrainingReviewFinanceDao extends DaoImpl<DormitoryTrainingReviewFinance>{

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
	public PageUtils<DormitoryTrainingReviewFinance> getDormitoryTrainingReviewFinanceByCondition(PageUtils<DormitoryTrainingReviewFinance> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinance = this.findForList(sql, params);
		page.setList(dormitoryTrainingReviewFinance);
		
		return page;
	}
	
	
	
	
	public int[] insertDormitoryTrainingReviewFinance(List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinance) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, dormitoryTrainingReviewFinance);
	}
	
	
	public int updateDormitoryTrainingReviewFinance(List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinance) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, dormitoryTrainingReviewFinance);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteDormitoryTrainingReviewFinance(List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinance) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[dormitoryTrainingReviewFinance.size()][1];
		for (int i = 0;i<dormitoryTrainingReviewFinance.size();i++) {
			params[i][0] = dormitoryTrainingReviewFinance.get(i).getReviewID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteDormitoryTrainingReviewFinanceByReviewID(String reviewID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, reviewID);
	}
	
	public DormitoryTrainingReviewFinance getDormitoryTrainingReviewFinanceByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingReviewFinance) this.findForObject(sql, params);
	}
	
}
