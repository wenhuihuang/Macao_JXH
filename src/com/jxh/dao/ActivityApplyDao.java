package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.ActivityApplyPojo;
import com.jxh.vo.ActivityApply;
import com.jxh.vo.ActivityRecordNew;

public class ActivityApplyDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/activityapply.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<ActivityApply> getActivityApplyByCondition(PageUtils<ActivityApply> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = ActivityApply.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<ActivityApply> activityApplys = this.findForList(sql, params);
		page.setList(activityApplys);
		
		return page;
	}
	
	public PageUtils<ActivityApplyPojo> getActivityApply1ByCondition(PageUtils<ActivityApplyPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = ActivityApplyPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<ActivityApplyPojo> activityApplys = this.findForList(sql, params);
		page.setList(activityApplys);
		
		return page;
	}
	public PageUtils<ActivityApplyPojo> getActivityApply2ByCondition(PageUtils<ActivityApplyPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = ActivityApplyPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<ActivityApplyPojo> activityApplys = this.findForList(sql, params);
		page.setList(activityApplys);
		
		return page;
	}
	public PageUtils<ActivityApplyPojo> getActivityApply3ByCondition(PageUtils<ActivityApplyPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = ActivityApplyPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		System.out.println(sql);
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<ActivityApplyPojo> activityApplys = this.findForList(sql, params);
		System.out.println(activityApplys);
		page.setList(activityApplys);
		
		return page;
	}
	
	
	public int insertActivityApply(ActivityApply activityApply) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, activityApply);
		return this.update(sql, params);
	}
	
	
	public int updateActivityApply(ActivityApply activityApply) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, activityApply);
		return this.update(sql, params);
	}
	
	
	
	public int deleteActivityApply(List<ActivityApply> activityApply) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[activityApply.size()][1];
		for (int i = 0;i<activityApply.size();i++) {
			params[i][0] = activityApply.get(i).getApplyID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	
	public int deleteActivityApplyByApplyID(String applyID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, applyID);
	}
	
	public ActivityApply getActivityApplyByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = ActivityApply.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		return  (ActivityApply) this.findForObject(sql, params);
	}
	
	public int[] insertActivityApplyBatch(List<ActivityApply> activityApplyAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		String sql = this.getSqlByPropKey("insertActivityApply");
		return insertBatchByList(sql, activityApplyAdds);
	}

	public int[] updateActivityApplyBatch(List<ActivityApply> activityApplyUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		String sql = this.getSqlByPropKey("updateActivityApply");
		return updateBatchByList(sql, activityApplyUpdates);
	}

	public int deleteActivityApplyByActID(String actID) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return this.update(sql, actID);
	}
	
	
}
