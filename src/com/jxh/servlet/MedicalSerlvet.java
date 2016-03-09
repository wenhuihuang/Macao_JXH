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
import com.jxh.biz.MedicalRecordBiz;
import com.jxh.dao.CustomerDao;
import com.jxh.dao.MedicalRecordDao;
import com.jxh.pojo.Customer;
import com.jxh.pojo.MedicalRecordPojo;
import com.jxh.vo.BCustomer;
import com.jxh.vo.MedicalRecord;
import com.jxh.vo.MedicalRecordFamily;
import com.jxh.vo.MedicalRecordView;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/Medical/*")
public class MedicalSerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
    private MedicalRecordDao medicalRecordDao = new MedicalRecordDao();
    private CustomerDao customerDao = new CustomerDao();
    private MedicalRecordBiz medicalRecordBiz = new MedicalRecordBiz();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicalSerlvet() {
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
		PageUtils<MedicalRecordPojo> page = this.getPage(request);
		medicalRecordDao.getMedicalRecordPojo(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {

			MedicalRecord medicalRecord = new MedicalRecord();

			request.setAttribute("medicalRecord", medicalRecord);
			forwardDispatcher("../jsp/manage/medical_edit.jsp", request, response);
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			BCustomer customer = customerDao.getCustomerByCondition(" and custId = ? ",
					this.getParameterByName(request, "custID"));
			MedicalRecord medicalRecord = medicalRecordDao.getMedicalRecordByCondition(" and recordID = ? ",
					this.getParameterByName(request, "recordID"));
		
			request.setAttribute("customer", customer);
			request.setAttribute("medicalRecord", medicalRecord);
			
			forwardDispatcher("../jsp/manage/medical_edit.jsp",request,response);
			

		} catch (IOException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<MedicalRecordFamily> medicalRecordFamilyAdds = getGridListByParamerName(MedicalRecordFamily.class, request, "medicalRecordFamilyAdds");
		List<MedicalRecordFamily> medicalRecordFamilyUpdates = getGridListByParamerName(MedicalRecordFamily.class, request, "medicalRecordFamilyUpdates");
		List<MedicalRecordFamily> medicalRecordFamilyDeletes = getGridListByParamerName(MedicalRecordFamily.class, request, "medicalRecordFamilyDeletes");
		
		List<MedicalRecordView> medicalRecordViewAdds = getGridListByParamerName(MedicalRecordView.class, request, "medicalRecordViewAdds");
		List<MedicalRecordView> medicalRecordViewUpdates = getGridListByParamerName(MedicalRecordView.class, request, "medicalRecordViewUpdates");
		List<MedicalRecordView> medicalRecordViewDeletes = getGridListByParamerName(MedicalRecordView.class, request, "medicalRecordViewDeletes");
		
		

		MedicalRecord medicalRecord = this.getObjectByParameter(request, MedicalRecord.class);
		//MedicalRecordView medicalRecordView = this.getObjectByParameter(request, MedicalRecordView.class);
		
		String message = "";
		
			if(medicalRecord.getRecordID() != null && !"".equals(medicalRecord.getRecordID())){
				message = medicalRecordBiz.updateMedicalRecord(medicalRecord, medicalRecordViewAdds,medicalRecordViewUpdates,medicalRecordViewDeletes,medicalRecordFamilyAdds,medicalRecordFamilyUpdates,medicalRecordFamilyDeletes);
			}else{
				message = medicalRecordBiz.insertMedicalRecord(medicalRecord, medicalRecordViewAdds,medicalRecordFamilyAdds);
			}
		
	

		// 设置为表单jsp
		request.setAttribute("msg", message);
		
		
		if (message.indexOf("成功") > 0) {
			sendRedirect("../jsp/manage/medical_list.jsp", response);
		} else {
			request.setAttribute("medicalRecord", medicalRecord);
				forwardDispatcher("../jsp/manage/medical_edit.jsp", request,response);
			
		}

	}
	
	private void deleteMedicalRecord(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String recordID = request.getParameter("recordID");
		if(recordID != null && !"".equals(recordID)){
			flag = medicalRecordBiz.deleteMedicalRecordByRecordID(recordID);
		}
		response.getWriter().print(flag);
	}

}
