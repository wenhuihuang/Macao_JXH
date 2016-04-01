package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.GroupSettingPojo;
import com.jxh.pojo.GroupSettingRecordPojo;
import com.jxh.vo.GroupSetting;

public class GroupSettingDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/groupsetting.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<GroupSettingPojo> getGroupSettingPojo(PageUtils<GroupSettingPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = GroupSettingPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		System.out.println("sql+=="+sql);
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<GroupSettingPojo> groupSettingPojos = this.findForList(sql, params);
		page.setList(groupSettingPojos);
		
		return page;
	}
	
	
	
	
	public int insertGroupSetting(GroupSetting groupSetting) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, groupSetting);
		return this.update(sql, params);
	}
	
	
	public int updateGroupSetting(GroupSetting groupSetting) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, groupSetting);
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
	
	
	public int deleteGroupSettingByGSID(String gSID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, gSID);
	}
	
	public GroupSetting getGroupSettingByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = GroupSetting.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (GroupSetting) this.findForObject(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("GROUPSETTING", corpId, 20);
	}
	
}
