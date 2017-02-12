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
import com.jxh.biz.CarRecordBiz;
import com.jxh.biz.CarSettingBiz;
import com.jxh.dao.CarAbsentDao;
import com.jxh.dao.CarRecordDao;
import com.jxh.dao.CarSettingDao;
import com.jxh.pojo.CarAbsentPojo;
import com.jxh.pojo.CarRecordPojo;
import com.jxh.pojo.CarSettingPojo;
import com.jxh.vo.CarAbsent;
import com.jxh.vo.CarRecord;
import com.jxh.vo.CarSetting;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/CarRecord/*")
public class CarRecordSerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
	
	private CarSettingDao carSettingDao = new CarSettingDao();
	private CarSettingBiz carSettingBiz = new CarSettingBiz();
	private CarRecordDao carRecordDao = new CarRecordDao();
	private CarAbsentDao carAbsentDao = new CarAbsentDao();
	private CarRecordBiz carRecordBiz = new CarRecordBiz();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarRecordSerlvet() {
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
		PageUtils<CarSettingPojo> page = this.getPage(request);
		carSettingDao.getCarSettingPojo(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void addCarRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean flag = false;
		List<CarRecord> carRecordAdds = getGridListByParamerName(CarRecord.class, request, "carRecordAdds");
		List<CarRecord> carRecordUpdates = getGridListByParamerName(CarRecord.class, request, "carRecordUpdates");
		List<CarRecord> carRecordDeletes = getGridListByParamerName(CarRecord.class, request, "carRecordDeletes");
		

	
		String message = "";
				message = carRecordBiz.updateCarRecords(carRecordAdds,carRecordUpdates,carRecordDeletes);
		
	

		// 设置为表单jsp
		request.setAttribute("msg", message);
		
		
		if (message.indexOf("成功") > 0) {
			flag = true;
			response.getWriter().print(flag);
			//sendRedirect("../jsp/manage/carSetting_list.jsp", response);
		} else {
			response.getWriter().print(flag);
			//request.setAttribute("carSetting", carSetting);
				//forwardDispatcher("../jsp/manage/carSetting_edit.jsp", request,response);
			
		}

	}
	private void deleteCarRecord(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String recordID = request.getParameter("recordID");
		if(recordID != null && !"".equals(recordID)){
			int row = carRecordDao.deleteCarRecordByRecordID(recordID);
			if(row > 0){
				flag=true;
			}
		}
		response.getWriter().print(flag);
	}
	
	private void deleteCarSetting(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String carID = request.getParameter("carID");
		if(carID != null && !"".equals(carID)){
			flag = carSettingBiz.deleteCarSettingByCarID(carID);
		}
		response.getWriter().print(flag);
	}

	private void getCarRecord(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String carID = this.getParameterByName(request, "carID");
		System.out.println("carID="+carID);
		PageUtils<CarRecordPojo> page = this.getPage(request);
		if(carID != null && !"".equals(carID)){
			String condition = " and carID = ? ";
			carRecordDao.getCarRecordPojoByCondition(page, condition, carID);
		}else{
			carRecordDao.getCarRecordPojoByCondition(page, null);
		}
		
		LigerUITools.writeGridJson(page, response);
		
	}
	
	
}
