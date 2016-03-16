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
import com.jxh.biz.CarSettingBiz;
import com.jxh.dao.CarAbsentDao;
import com.jxh.dao.CarRecordDao;
import com.jxh.dao.CarSettingDao;
import com.jxh.pojo.CarAbsentPojo;
import com.jxh.pojo.CarSettingPojo;
import com.jxh.vo.CarAbsent;
import com.jxh.vo.CarRecord;
import com.jxh.vo.CarSetting;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/CarSetting/*")
public class CarSettingSerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
	
	private CarSettingDao carSettingDao = new CarSettingDao();
	private CarSettingBiz carSettingBiz = new CarSettingBiz();
	private CarRecordDao carRecordDao = new CarRecordDao();
	private CarAbsentDao carAbsentDao = new CarAbsentDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarSettingSerlvet() {
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
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {

			CarSetting carSetting = new CarSetting();

			request.setAttribute("carSetting", carSetting);
			forwardDispatcher("../jsp/manage/carSetting_edit.jsp", request, response);
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			CarSetting carSetting = carSettingDao.getCarSettingByCondition(" and carID = ? ",
					this.getParameterByName(request, "carID"));
			request.setAttribute("carSetting", carSetting);
			
			forwardDispatcher("../jsp/manage/carSetting_edit.jsp",request,response);
			

		} catch (IOException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		List<CarRecord> carRecordAdds = getGridListByParamerName(CarRecord.class, request, "carRecordAdds");
		List<CarRecord> carRecordUpdates = getGridListByParamerName(CarRecord.class, request, "carRecordUpdates");
		List<CarRecord> carRecordDeletes = getGridListByParamerName(CarRecord.class, request, "carRecordDeletes");
		
		List<CarAbsent> carAbsentAdds = getGridListByParamerName(CarAbsent.class, request, "carAbsentAdds");
		List<CarAbsent> carAbsentUpdates = getGridListByParamerName(CarAbsent.class, request, "carAbsentUpdates");
		List<CarAbsent> carAbsentDeletes = getGridListByParamerName(CarAbsent.class, request, "carAbsentDeletes");
		

		CarSetting carSetting = this.getObjectByParameter(request, CarSetting.class);
		
		String message = "";
			if(carSetting.getCarID() != null && !"".equals(carSetting.getCarID())){
				message = carSettingBiz.updateCarSetting(carSetting,carRecordAdds,carRecordUpdates,carRecordDeletes,carAbsentAdds,carAbsentUpdates,carAbsentDeletes);
			}else{
				message = carSettingBiz.insertCarSetting(carSetting,carRecordAdds,carAbsentAdds);
			}
		
	

		// 设置为表单jsp
		request.setAttribute("msg", message);
		
		
		if (message.indexOf("成功") > 0) {
			sendRedirect("../jsp/manage/carSetting_list.jsp", response);
		} else {
			request.setAttribute("carSetting", carSetting);
				forwardDispatcher("../jsp/manage/carSetting_edit.jsp", request,response);
			
		}

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
		PageUtils<CarRecord> page = this.getPage(request);
		if(carID != null && !"".equals(carID)){
			String condition = " and carID = ? ";
			carRecordDao.getCarRecordByCondition(page, condition, carID);
		}else{
			carRecordDao.getCarRecordByCondition(page, null);
		}
		
		LigerUITools.writeGridJson(page, response);
		
	}
	
	private void getCarAbsentPojo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String carID = this.getParameterByName(request, "carID");
		PageUtils<CarAbsentPojo> page = this.getPage(request);
		if(carID != null && !"".equals(carID)){
			String condition = " and carAbsent.carID = ? ";
			carAbsentDao.getCarAbsentPojoByCondition(page, condition, carID);
		}else{
			carAbsentDao.getCarAbsentPojoByCondition(page, null);
		}
		
		
		LigerUITools.writeGridJson(page, response);
	}
	
}
