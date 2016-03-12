package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.CourseSettingDao;
import com.jxh.dao.CourseSettingDetailDao;
import com.jxh.utils.Constants;
import com.jxh.vo.CourseSetting;
import com.jxh.vo.CourseSettingDetail;

public class CourseSettingBiz {
	private CourseSettingDao courseSettingDao = new CourseSettingDao();
	private CourseSettingDetailDao courseSettingDetailDao = new CourseSettingDetailDao();

	public String updateCourseSetting(CourseSetting courseSetting,
			List<CourseSettingDetail> courseSettingDetailAdds, List<CourseSettingDetail> courseSettingDetailUpdates,
			List<CourseSettingDetail> courseSettingDetailDeletes
			) throws Exception {
		int row = courseSettingDao.updateCourseSetting(courseSetting);
		if (row > 0) {

			
			if(addCourseSettingDetail(courseSetting, courseSettingDetailAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(updateCourseSettingDetail(courseSetting,courseSettingDetailUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(delteCourseSettingDetail(courseSetting, courseSettingDetailDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
		
		}
		return "操作成功！";
	}




	private int delteCourseSettingDetail(CourseSetting courseSetting,
			List<CourseSettingDetail> courseSettingDetailDeletes) throws IOException, SQLException {
		if (courseSettingDetailDeletes == null || courseSettingDetailDeletes.size() <= 0) {
			return 1;
		}
		return courseSettingDetailDao.deleteCourseSettingDetail(courseSettingDetailDeletes);
	}




	private int updateCourseSettingDetail(CourseSetting courseSetting,
			List<CourseSettingDetail> courseSettingDetailUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (courseSettingDetailUpdates == null || courseSettingDetailUpdates.size() <= 0) {
			return 1;
		}
		return courseSettingDetailDao.updateCourseSettingDetail(courseSettingDetailUpdates);
	}




	public String insertCourseSetting(CourseSetting courseSetting,
			List<CourseSettingDetail> courseSettingDetailAdds
			) throws Exception {

		String courseID = courseSettingDao.getPrimaryKey(Constants.CORPID);
		courseSetting.setCourseID(courseID);
		int row = courseSettingDao.insertCourseSetting(courseSetting);
		if (row > 0) {
			
			if(addCourseSettingDetail(courseSetting, courseSettingDetailAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			
		}
		return "操作成功！";
	
	}




	private int addCourseSettingDetail(CourseSetting courseSetting,
			List<CourseSettingDetail> courseSettingDetailAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (courseSettingDetailAdds == null || courseSettingDetailAdds.size() <= 0) {
			return 1;
		}
		
		for (CourseSettingDetail update : courseSettingDetailAdds) {
			
			update.setCourseID(courseSetting.getCourseID());
		}
		
		int [] rows =courseSettingDetailDao.insertCourseSettingDetailBatch(courseSettingDetailAdds);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}



	public boolean deleteCourseSettingByCourseID(String courseID) throws Exception {
		boolean flag=false;
		int row = courseSettingDao.deleteCourseSettingByCourseID(courseID);
			if (row > 0) {
				if (deleteCourseSettingDetailByCourseID(courseID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				flag=true;
				
			}
		return flag;
	}


	private int deleteCourseSettingDetailByCourseID(String courseID) throws SQLException, IOException {
		return courseSettingDetailDao.deleteCourseSettingDetailByCourseID(courseID);
	}



}
