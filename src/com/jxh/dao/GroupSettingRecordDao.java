package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.GroupSettingRecordPojo;
import com.jxh.vo.GroupSettingRecord;

public class GroupSettingRecordDao extends DaoImpl {
	
	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/groupsettingrecord.properties";
	}
	
	public PageUtils<GroupSettingRecordPojo> getGroupSettingRecordPojo(PageUtils<GroupSettingRecordPojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = GroupSettingRecordPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		System.out.println("sql+=="+sql);
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<GroupSettingRecordPojo> groupSettingRecordPojos = this.findForList(sql, params);
		page.setList(groupSettingRecordPojos);
		
		return page;
	}

	public GroupSettingRecord getGroupSettingRecordByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = GroupSettingRecord.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (GroupSettingRecord) this.findForObject(sql, params);
	}

	public int updateGroupSettingRecord(GroupSettingRecord groupSettingRecord) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, groupSettingRecord);
		return this.update(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("GROUPSETTINGRECORD", corpId, 20);
	}
	
	public int insertGroupSettingRecord(GroupSettingRecord groupSettingRecord) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, groupSettingRecord);
		return this.update(sql, params);
	}
	
	public int deleteGroupSettingRecordByRecordID(String recordID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from Treatment where treatmentID = ? ";
		return this.update(sql, recordID);
	}
	
}
