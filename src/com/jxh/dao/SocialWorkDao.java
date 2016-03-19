package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
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
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<SocialWork> socialWorks = this.findForList(sql, params);
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

	public int updateSocialWork(SocialWork socialWork) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, socialWork);
		return this.update(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("SOCIALWORK", corpId, 20);
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
	
}
