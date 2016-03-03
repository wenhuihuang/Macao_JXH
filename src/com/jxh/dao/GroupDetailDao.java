package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.GroupDetail;
import com.jxh.vo.GroupSetting;

public class GroupDetailDao extends DaoImpl<GroupDetail>{

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
	public PageUtils<GroupDetail> getGroupDetailByCondition(PageUtils<GroupDetail> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<GroupDetail> groupDetail = this.findForList(sql, params);
		page.setList(groupDetail);
		
		return page;
	}
	
	
	
	
	public int[] insertGroupDetail(List<GroupDetail> groupDetail) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return insertBatchByList(sql, groupDetail);
	}
	
	
	public int updateGroupDetail(List<GroupDetail> groupDetail) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, groupDetail);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteGroupDetail(List<GroupDetail> groupDetail) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[groupDetail.size()][1];
		for (int i = 0;i<groupDetail.size();i++) {
			params[i][0] = groupDetail.get(i).getgSID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteGroupDetailByCustID(String custID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, custID);
	}
	
	public GroupDetail getGroupDetailByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (GroupDetail) this.findForObject(sql, params);
	}
	
}
