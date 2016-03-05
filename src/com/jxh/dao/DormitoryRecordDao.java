package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.DormitoryRecordPojo;
import com.jxh.vo.DormitoryRecord;

public class DormitoryRecordDao extends DaoImpl {
	
	@Override
	protected String getSqlPropertiesPath() {
		return null;
	}
	
	public PageUtils<DormitoryRecordPojo> getDormitoryRecordPojo(PageUtils<DormitoryRecordPojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = DormitoryRecordPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<DormitoryRecordPojo> dormitoryRecordPojos = this.findForList(sql, params);
		page.setList(dormitoryRecordPojos);
		
		return page;
	}

	public DormitoryRecordPojo getDormitoryRecordPojoByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = DormitoryRecordPojo.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return  (DormitoryRecordPojo) this.findForObject(sql, params);
	}

	public int updateDormitoryRecord(DormitoryRecord dormitoryRecord) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, dormitoryRecord);
		return this.update(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("DORMITORYERCORD", corpId, 20);
	}
	
	public int insertDormitoryRecord(DormitoryRecord dormitoryRecord) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, dormitoryRecord);
		return this.update(sql, params);
	}
	
	public int deleteDormitoryRecordByRecordID(String recordID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from Treatment where treatmentID = ? ";
		return this.update(sql, recordID);
	}
	
}
