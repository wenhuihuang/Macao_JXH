package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.CourseSettingDetail;
import com.jxh.vo.GroupSettingRecordPlan;

public class CourseSettingDetailDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/coursesettingdetail.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<CourseSettingDetail> getCourseSettingDetailByCondition(PageUtils<CourseSettingDetail> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = CourseSettingDetail.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		System.out.println("sql+=="+sql);
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<CourseSettingDetail> courseSettingDetail = this.findForList(sql, params);
		page.setList(courseSettingDetail);
		
		return page;
	}
	
	
	
	
	public int insertCourseSettingDetail(CourseSettingDetail courseSettingDetail) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, courseSettingDetail);
		return this.update(sql, params);
	}
	
	public int[] insertCourseSettingDetailBatch(List<CourseSettingDetail> courseSettingDetail) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey("insertCourseSettingDetail");
		//return this.update(sql, params);
		return insertBatchByList(sql, courseSettingDetail);
	}
	
	
	public int updateCourseSettingDetail(List<CourseSettingDetail> courseSettingDetail) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, courseSettingDetail);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteCourseSettingDetail(List<CourseSettingDetail> courseSettingDetail) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[courseSettingDetail.size()][1];
		for (int i = 0;i<courseSettingDetail.size();i++) {
			params[i][0] = courseSettingDetail.get(i).getCourseID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	
	public int deleteCourseSettingDetailByCourseID(String courseID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, courseID);
	}
/*	
	public CourseSettingDetail getCourseSettingDetailByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = CourseSettingDetail.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		System.out.println(sql);
		return  (CourseSettingDetail) this.findForObject(sql, params);
	}
	*/
	
}
