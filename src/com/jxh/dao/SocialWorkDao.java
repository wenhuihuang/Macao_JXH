package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.SocialWorkPojo;
import com.jxh.pojo.VoluntaryPojo;
import com.jxh.vo.SocialWork;

public class SocialWorkDao extends DaoImpl {
	
	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/socialwork.properties";
	}
	
	public PageUtils<SocialWork> getSocialWork(PageUtils<SocialWork> page,String condition,Object...params) throws IOException, SQLException{
		clazz = SocialWork.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		System.out.println(sql);
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<SocialWork> socialWorks = this.findForList(sql, params);
		page.setList(socialWorks);
		
		return page;
	}
	public PageUtils<SocialWorkPojo> getSocialWorkPojo(PageUtils<SocialWorkPojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = SocialWorkPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<SocialWorkPojo> socialWorks = this.findForList(sql, params);
		page.setList(socialWorks);
		
		return page;
	}

	public SocialWork getSocialWorkByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = SocialWork.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		return  (SocialWork) this.findForObject(sql, params);
	}

	public SocialWorkPojo getSocialWorkPojoByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = SocialWorkPojo.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		return  (SocialWorkPojo) this.findForObject(sql, params);
	}
	
	public int updateSocialWork(SocialWork socialWork) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, socialWork);
		return this.update(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("SOCIALWORK", corpId, 20);
	}
	
	public int[] insertSocialWork(List<SocialWork> socialWorkAdds) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return this.insertBatchByList(sql, socialWorkAdds);
	}
	public int insertSocialWork(SocialWork socialWork) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, socialWork);
		return this.update(sql, params);
	}
	
	public int deleteSocialWorkByWorkID(String workID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from SocialWork where SocialWorkID = ? ";
		return this.update(sql, workID);
	}

	public int updateSocialWork(List<SocialWork> socialWorkUpdates) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, socialWorkUpdates);
		
		return getflagByIntArray(rows);
	}

	public int deleteSocialWork(List<SocialWork> socialWorkDeletes) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[socialWorkDeletes.size()][1];
		for (int i = 0;i<socialWorkDeletes.size();i++) {
			params[i][0] = socialWorkDeletes.get(i).getWorkID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public PageUtils<VoluntaryPojo> getVoluntaryPojo(PageUtils<VoluntaryPojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = VoluntaryPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<VoluntaryPojo> voluntaryPojos = this.findForList(sql, params);
		page.setList(voluntaryPojos);
		
		return page;
	}
	
}
