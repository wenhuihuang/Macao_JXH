package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.ActivityRecordNewPojo;
import com.jxh.vo.ActivityRecordNew;
import com.jxh.vo.CSSA;

public class ActivityRecordNewDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/activityrecordnew.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<ActivityRecordNew> getActivityRecordNewByCondition(PageUtils<ActivityRecordNew> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = ActivityRecordNew.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<ActivityRecordNew> activityRecordNews = this.findForList(sql, params);
		page.setList(activityRecordNews);
		
		return page;
	}
	
	public PageUtils<ActivityRecordNewPojo> getActivityRecordNewPojoByCondition(PageUtils<ActivityRecordNewPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = ActivityRecordNewPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<ActivityRecordNewPojo> activityRecordNews = this.findForList(sql, params);
		page.setList(activityRecordNews);
		
		return page;
	}
	
	
	
	
	public int insertActivityRecordNew(ActivityRecordNew activityRecordNew) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, activityRecordNew);
		return this.update(sql, params);
	}
	
	public int updateActivityRecordNew(ActivityRecordNew activityRecordNew) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, activityRecordNew);
		return this.update(sql, params);
	}
	
	
	
	public int deleteActivityRecordNew(List<ActivityRecordNew> activityRecordNew) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[activityRecordNew.size()][1];
		for (int i = 0;i<activityRecordNew.size();i++) {
			params[i][0] = activityRecordNew.get(i).getRecordID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	
	public int deleteActivityRecordNewByApplyID(String applyID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, applyID);
	}
	
	public ActivityRecordNew getActivityRecordNewByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = ActivityRecordNew.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		return  (ActivityRecordNew) this.findForObject(sql, params);
	}

	public int[] insertActivityRecordNewBatch(List<ActivityRecordNew> activityRecordNewAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		String sql = this.getSqlByPropKey("insertActivityRecordNew");
		return insertBatchByList(sql, activityRecordNewAdds);
	}

	public int updateActivityRecordNewBatch(List<ActivityRecordNew> activityRecordNewUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		String sql = this.getSqlByPropKey("updateActivityRecordNew");
		 int[] rows = updateBatchByList(sql, activityRecordNewUpdates);
		return getflagByIntArray(rows);
	}

	public int deleteActivityRecordNewByActID(String actID) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return this.update(sql, actID);
	}
	
	
}
