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
import com.jxh.biz.ChargeRecordBiz;
import com.jxh.dao.ChargeRecordDao;
import com.jxh.vo.ChargeRecord;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/ChargeRecord/*")
public class ChargeRecordSerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
    private ChargeRecordDao chargeRecordDao = new ChargeRecordDao();
    private ChargeRecordBiz chargeRecordBiz = new ChargeRecordBiz();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChargeRecordSerlvet() {
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
		PageUtils<ChargeRecord> page = this.getPage(request);
		chargeRecordDao.getChargeRecord(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {

			ChargeRecord chargeRecord = new ChargeRecord();

			request.setAttribute("chargeRecord", chargeRecord);
			forwardDispatcher("../jsp/manage/chargeRecord_edit.jsp", request, response);
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			ChargeRecord chargeRecord = chargeRecordDao.getChargeRecordByCondition(" and chargeID = ? ",
					this.getParameterByName(request, "chargeID"));
		
			request.setAttribute("chargeRecord", chargeRecord);
			
			forwardDispatcher("../jsp/manage/chargeRecord_edit.jsp",request,response);
			

		} catch (IOException | SQLException | ServletException e) {
			e.printStackTrace();
		}

	}
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean flag = false;
		List<ChargeRecord> chargeRecordAdds = getGridListByParamerName(ChargeRecord.class, request, "chargeRecordAdds");
		List<ChargeRecord> chargeRecordUpdates = getGridListByParamerName(ChargeRecord.class, request, "chargeRecordUpdates");
		List<ChargeRecord> chargeRecordDeletes = getGridListByParamerName(ChargeRecord.class, request, "chargeRecordDeletes");
		
		String message = "";
		
		message = chargeRecordBiz.updateChargeRecord(chargeRecordAdds,chargeRecordUpdates,chargeRecordDeletes);
		
	

		// 设置为表单jsp
		request.setAttribute("msg", message);
		
		
		if (message.indexOf("成功") > 0) {
			flag = true ;
		} else {
			flag = false;
		}
		response.getWriter().print(flag);
	}
	
	private void deleteChargeRecord(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String chargeID = request.getParameter("chargeID");
		if(chargeID != null && !"".equals(chargeID)){
			flag = chargeRecordBiz.deleteChargeRecordByChargeID(chargeID);
		}
		response.getWriter().print(flag);
	}

	
}
