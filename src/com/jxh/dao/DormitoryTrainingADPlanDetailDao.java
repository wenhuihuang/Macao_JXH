package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.DormitoryTrainingADPlanDetail;

public class DormitoryTrainingADPlanDetailDao extends DaoImpl<DormitoryTrainingADPlanDetail>{

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
	public PageUtils<DormitoryTrainingADPlanDetail> getDormitoryTrainingADPlanDetailByCondition(PageUtils<DormitoryTrainingADPlanDetail> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetail = this.findForList(sql, params);
		page.setList(dormitoryTrainingADPlanDetail);
		
		return page;
	}
	
	
	
	
	public int[] insertDormitoryTrainingADPlanDetail(List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetail) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, dormitoryTrainingADPlanDetail);
	}
	
	
	public int updateDormitoryTrainingADPlanDetail(List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetail) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, dormitoryTrainingADPlanDetail);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteDormitoryTrainingADPlanDetail(List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetail) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[dormitoryTrainingADPlanDetail.size()][1];
		for (int i = 0;i<dormitoryTrainingADPlanDetail.size();i++) {
			params[i][0] = dormitoryTrainingADPlanDetail.get(i).getPlanID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteDormitoryTrainingADPlanDetailByAPlanID(String aPlanID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, aPlanID);
	}
	
	public DormitoryTrainingADPlanDetail getDormitoryTrainingADPlanDetailByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingADPlanDetail) this.findForObject(sql, params);
	}
	
}
