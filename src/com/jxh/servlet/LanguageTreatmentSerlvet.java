package com.jxh.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

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
import com.jxh.dao.TreatmentDao;
import com.jxh.pojo.CustCasePojo;
import com.jxh.pojo.LanguageTreatmentPojo;
import com.jxh.vo.BCustomer;
import com.jxh.vo.Treatment;

/**
 * Servlet implementation class LanguageTreatmentSerlvet
 */
@WebServlet("/LanguageTreatment/*")
public class LanguageTreatmentSerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
	private TreatmentDao treatmentDao = new TreatmentDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LanguageTreatmentSerlvet() {
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
		PageUtils<LanguageTreatmentPojo> page = this.getPage(request);
		treatmentDao.getLanguageTreatmentPojo(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {

			Treatment treatment = new Treatment();

			request.setAttribute("treatment", treatment);
			request.setAttribute(JSPTYPE, ConstantUtils.FORMJSP);

			forwardDispatcher("../jsp/treatment/language_edit.jsp", request, response);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			LanguageTreatmentPojo languageTreatmentPojo = treatmentDao.getTreatmentPojoByCondition(" and Treatment.treatmentID = ? ",
					this.getParameterByName(request, "treatmentID"));
			request.setAttribute("languageTreatmentPojo", languageTreatmentPojo);
			forwardDispatcher("../jsp/custCase/edit.jsp", request, response);

		} catch (IOException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
