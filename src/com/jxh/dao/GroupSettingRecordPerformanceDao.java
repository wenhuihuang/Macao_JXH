package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.GroupSettingRecordPerformance;

public class GroupSettingRecordPerformanceDao extends DaoImpl<GroupSettingRecordPerformance>{

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
	public PageUtils<GroupSettingRecordPerformance> getGroupSettingRecordPerformanceByCondition(PageUtils<GroupSettingRecordPerformance> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<GroupSettingRecordPerformance> groupSettingRecordPerformance = this.findForList(sql, params);
		page.setList(groupSettingRecordPerformance);
		
		return page;
	}
	
	
	
	
	public int[] insertGroupSettingRecordPerformance(List<GroupSettingRecordPerformance> groupSettingRecordPerformance) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, groupSettingRecordPerformance);
	}
	
	
	public int updateGroupSettingRecordPerformance(List<GroupSettingRecordPerformance> groupSettingRecordPerformance) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, groupSettingRecordPerformance);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteGroupSettingRecordPerformance(List<GroupSettingRecordPerformance> groupSettingRecordPerformance) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[groupSettingRecordPerformance.size()][1];
		for (int i = 0;i<groupSettingRecordPerformance.size();i++) {
			params[i][0] = groupSettingRecordPerformance.get(i).getPerformanceID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteGroupSettingRecordPerformanceByCustID(String custID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, custID);
	}
	
	public GroupSettingRecordPerformance getGroupSettingRecordPerformanceByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (GroupSettingRecordPerformance) this.findForObject(sql, params);
	}
	
}
