package com.jxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fg.ligerui.ConstantUtils;
import com.fg.ligerui.LigerUITools;
import com.fg.servlet.FGServlet;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.biz.CourseSettingBiz;
import com.jxh.dao.CourseSettingDao;
import com.jxh.dao.CourseSettingDetailDao;
import com.jxh.pojo.CourseSettingPojo;
import com.jxh.vo.CourseSetting;
import com.jxh.vo.CourseSettingDetail;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/CourseSetting/*")
public class CourseSettingSerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
	
	private CourseSettingDao courseSettingDao = new CourseSettingDao();
	private CourseSettingBiz courseSettingBiz = new CourseSettingBiz();
	private CourseSettingDetailDao courseSettingDetailDao = new CourseSettingDetailDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseSettingSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		PageUtils<CourseSettingPojo> page = this.getPage(request);
		courseSettingDao.getCourseSettingPojo(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {

			CourseSetting courseSetting = new CourseSetting();

			request.setAttribute("courseSetting", courseSetting);
			forwardDispatcher("../jsp/manage/courseSetting_edit.jsp", request, response);
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			CourseSetting courseSetting = courseSettingDao.getCourseSettingByCondition(" and courseID = ? ",
					this.getParameterByName(request, "courseID"));
			request.setAttribute("courseSetting", courseSetting);
			
			forwardDispatcher("../jsp/manage/courseSetting_edit.jsp",request,response);
			

		} catch (IOException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		List<CourseSettingDetail> courseSettingDetailAdds = getGridListByParamerName(CourseSettingDetail.class, request, "courseSettingDetailAdds");
		List<CourseSettingDetail> courseSettingDetailUpdates = getGridListByParamerName(CourseSettingDetail.class, request, "courseSettingDetailUpdates");
		List<CourseSettingDetail> courseSettingDetailDeletes = getGridListByParamerName(CourseSettingDetail.class, request, "courseSettingDetailDeletes");
		

		CourseSetting courseSetting = this.getObjectByParameter(request, CourseSetting.class);
		
		String message = "";
			if(courseSetting.getCourseID() != null && !"".equals(courseSetting.getCourseID())){
				message = courseSettingBiz.updateCourseSetting(courseSetting,courseSettingDetailAdds,courseSettingDetailUpdates,courseSettingDetailDeletes);
			}else{
				message = courseSettingBiz.insertCourseSetting(courseSetting,courseSettingDetailAdds);
			}
		
	

		// 设置为表单jsp
		request.setAttribute("msg", message);
		
		
		if (message.indexOf("成功") > 0) {
			sendRedirect("../jsp/manage/courseSetting_list.jsp", response);
		} else {
			request.setAttribute("courseSetting", courseSetting);
				forwardDispatcher("../jsp/manage/courseSetting_edit.jsp", request,response);
			
		}

	}
	
	private void deleteCourseSetting(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String courseID = request.getParameter("courseID");
		if(courseID != null && !"".equals(courseID)){
			flag = courseSettingBiz.deleteCourseSettingByCourseID(courseID);
		}
		response.getWriter().print(flag);
	}

	private void getCourseSettingDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String courseID = this.getParameterByName(request, "courseID");
		PageUtils<CourseSettingDetail> page = this.getPage(request);
		String condition = " and courseID = ? ";
		courseSettingDetailDao.getCourseSettingDetailByCondition(page, condition, courseID);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	
}
