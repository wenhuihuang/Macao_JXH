package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.DormitoryTrainingRecordDetailBottom;

public class DormitoryTrainingRecordDetailBottomDao extends DaoImpl<DormitoryTrainingRecordDetailBottom>{

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
	public PageUtils<DormitoryTrainingRecordDetailBottom> getDormitoryTrainingRecordDetailBottomByCondition(PageUtils<DormitoryTrainingRecordDetailBottom> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottom = this.findForList(sql, params);
		page.setList(dormitoryTrainingRecordDetailBottom);
		
		return page;
	}
	
	
	
	
	public int[] insertDormitoryTrainingRecordDetailBottom(List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottom) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//return this.update(sql, params);
		return insertBatchByList(sql, dormitoryTrainingRecordDetailBottom);
	}
	
	
	public int updateDormitoryTrainingRecordDetailBottom(List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottom) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, dormitoryTrainingRecordDetailBottom);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteDormitoryTrainingRecordDetailBottom(List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottom) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[dormitoryTrainingRecordDetailBottom.size()][1];
		for (int i = 0;i<dormitoryTrainingRecordDetailBottom.size();i++) {
			params[i][0] = dormitoryTrainingRecordDetailBottom.get(i).getDetailID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteDormitoryTrainingRecordDetailBottomByMasterRecordID(String tRecordID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, tRecordID);
	}
	
	public DormitoryTrainingRecordDetailBottom getDormitoryTrainingRecordDetailBottomByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (DormitoryTrainingRecordDetailBottom) this.findForObject(sql, params);
	}
	
}
