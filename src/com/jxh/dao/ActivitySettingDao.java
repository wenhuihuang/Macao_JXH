package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.ActivitySettingPojo;
import com.jxh.vo.ActivitySetting;

public class ActivitySettingDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/activitysetting.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<ActivitySettingPojo> getActivitySettingPojo(PageUtils<ActivitySettingPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = ActivitySettingPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<ActivitySettingPojo> activitySettingPojos = this.findForList(sql, params);
		page.setList(activitySettingPojos);
		
		return page;
	}
	
	
	
	
	public int insertActivitySetting(ActivitySetting activitySetting) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, activitySetting);
		return this.update(sql, params);
	}
	
	
	public int updateActivitySetting(ActivitySetting activitySetting) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		clazz = ActivitySetting.class;
		String sql = this.getSqlByPropKey("updateActivitySetting");
		Object[] params = getUpdateParams(sql, activitySetting);
		System.out.println(activitySetting);
		return this.update(sql, params);
	}
	
	
	
	public int deleteActivitySetting(List<ActivitySetting> activitySetting) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[activitySetting.size()][1];
		for (int i = 0;i<activitySetting.size();i++) {
			params[i][0] = activitySetting.get(i).getActID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	
	public int deleteActivitySettingByActID(String actID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, actID);
	}
	
	public ActivitySetting getActivitySettingByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = ActivitySetting.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		return  (ActivitySetting) this.findForObject(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("ACTIVITYSETTING", corpId, 20);
	}
	
	public String getActNO(String corpId) throws SQLException{
		return this.getPrimaryKey("ACTNO", corpId, 4);
	}
	
}
