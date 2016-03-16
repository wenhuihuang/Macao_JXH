package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.CourseSettingPojo;
import com.jxh.vo.CourseSetting;

public class CourseSettingDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/coursesetting.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<CourseSettingPojo> getCourseSettingPojo(PageUtils<CourseSettingPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = CourseSettingPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		System.out.println("sql+=="+sql);
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<CourseSettingPojo> courseSettingPojos = this.findForList(sql, params);
		page.setList(courseSettingPojos);
		
		return page;
	}
	
	
	
	
	public int insertCourseSetting(CourseSetting courseSetting) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, courseSetting);
		return this.update(sql, params);
	}
	
	
	public int updateCourseSetting(CourseSetting courseSetting) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, courseSetting);
		return this.update(sql, params);
	}
	
	
	
	public int deleteCourseSetting(List<CourseSetting> courseSetting) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[courseSetting.size()][1];
		for (int i = 0;i<courseSetting.size();i++) {
			params[i][0] = courseSetting.get(i).getCourseID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	
	public int deleteCourseSettingByCourseID(String courseID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, courseID);
	}
	
	public CourseSetting getCourseSettingByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = CourseSetting.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (CourseSetting) this.findForObject(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("COURSESETTING", corpId, 20);
	}
	
}
