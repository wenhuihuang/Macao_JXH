package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.GroupSetting;

public class GroupSettingDao extends DaoImpl<GroupSetting>{

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
	public PageUtils<GroupSetting> getGroupSettingByCondition(PageUtils<GroupSetting> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<GroupSetting> groupSetting = this.findForList(sql, params);
		page.setList(groupSetting);
		
		return page;
	}
	
	
	
	
	public int insertGroupSetting(GroupSetting groupSetting) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, groupSetting);
		return this.update(sql, params);
	}
	
	
	public int updateGroupSetting(GroupSetting groupSetting) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, groupSetting);
		return this.update(sql, params);
	}
	
	
	
	public int deleteGroupSetting(List<GroupSetting> groupSetting) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[groupSetting.size()][1];
		for (int i = 0;i<groupSetting.size();i++) {
			params[i][0] = groupSetting.get(i).getgSID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	
	public int deleteGroupSettingByRecordID(String recordID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, recordID);
	}
	
	public GroupSetting getGroupSettingByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (GroupSetting) this.findForObject(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("GROUPSETTING", corpId, 20);
	}
	
}
