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
import com.jxh.biz.FamilySupportBiz;
import com.jxh.dao.FamilySupportApplyDao;
import com.jxh.dao.FamilySupportDao;
import com.jxh.dao.FamilySupportRecordDao;
import com.jxh.pojo.ActivityApplyPojo;
import com.jxh.pojo.FamilySupportApplyPojo;
import com.jxh.pojo.FamilySupportPojo;
import com.jxh.vo.FamilySupport;
import com.jxh.vo.FamilySupportApply;
import com.jxh.vo.FamilySupportRecord;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/FamilySupport/*")
public class FamilySupportSerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
	private FamilySupportDao familySupportDao = new FamilySupportDao();
	private FamilySupportApplyDao familySupportApplyDao = new FamilySupportApplyDao();
	private FamilySupportRecordDao familySupportRecordDao = new FamilySupportRecordDao();
	private FamilySupportBiz familySupportBiz = new FamilySupportBiz();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FamilySupportSerlvet() {
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
		PageUtils<FamilySupportPojo> page = this.getPage(request);
		familySupportDao.getFamilySupportPojo(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {

			FamilySupport familySupport = new FamilySupport();

			request.setAttribute("familySupport", familySupport);
			forwardDispatcher("../jsp/manage/familySupport_edit.jsp", request, response);
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			FamilySupport familySupport = familySupportDao.getFamilySupportByCondition(" and supportID = ? ",
					this.getParameterByName(request, "supportID"));
			System.out.println(familySupport);
			request.setAttribute("familySupport", familySupport);
			
				forwardDispatcher("../jsp/manage/familySupport_edit.jsp",request,response);
			

		} catch (IOException | SQLException | ServletException e) {
			e.printStackTrace();
		}

	}

	private void getFamilySupportApply(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String supportID = this.getParameterByName(request, "supportID");
		String type = this.getParameterByName(request, "type");
		PageUtils<FamilySupportApplyPojo> page = this.getPage(request);
		String condition = " and supportID = ? and type = ? ";
		if("1".equals(type)){//會員
			familySupportApplyDao.getFamilySupportApply1ByCondition(page, condition, supportID,type);
		}else if("2".equals(type)){//非會員
			familySupportApplyDao.getFamilySupportApply2ByCondition(page, condition, supportID,type);
		}else if("3".equals(type)){//社工
			familySupportApplyDao.getFamilySupportApply3ByCondition(page, condition, supportID,type);
		}
		
		LigerUITools.writeGridJson(page, response);
	}
	
	private void getFamilySupportRecord(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String actId = this.getParameterByName(request, "supportID");
		PageUtils<FamilySupportRecord> page = this.getPage(request);
		String condition = " and supportID = ? ";
		familySupportRecordDao.getFamilySupportRecordByCondition(page, condition, actId);
		
		LigerUITools.writeGridJson(page, response);
	}
	
	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<FamilySupportApply> familySupportApplyAdds = getGridListByParamerName(FamilySupportApply.class, request, "familySupportApplyAdds");
		List<FamilySupportApply> familySupportApplyUpdates = getGridListByParamerName(FamilySupportApply.class, request, "familySupportApplyUpdates");
		List<FamilySupportApply> familySupportApplyDeletes = getGridListByParamerName(FamilySupportApply.class, request, "familySupportApplyDeletes");
		
		
		List<FamilySupportRecord>  familySupportRecordAdds = getGridListByParamerName(FamilySupportRecord.class, request, "familySupportRecordAdds");
		List<FamilySupportRecord>  familySupportRecordUpdates = getGridListByParamerName(FamilySupportRecord.class, request, "familySupportRecordUpdates");
		List<FamilySupportRecord>  familySupportRecordDeletes = getGridListByParamerName(FamilySupportRecord.class, request, "familySupportRecordDeletes");

		FamilySupport familySupport = this.getObjectByParameter(request, FamilySupport.class);
		String message = "";
			if (familySupport.getSupportID() != null && !"".equals(familySupport.getSupportID())) {
				message = familySupportBiz.updateFamilySupport(familySupport, familySupportApplyAdds,familySupportApplyUpdates,familySupportApplyDeletes,familySupportRecordAdds,familySupportRecordUpdates,familySupportRecordDeletes);
			} else {
				message = familySupportBiz.insertFamilySupport(familySupport,familySupportApplyAdds,familySupportRecordAdds);
			}
	

		// 设置为表单jsp
		request.setAttribute("msg", message);
		

		if (message.indexOf("成功") > 0) {
			sendRedirect("../jsp/manage/familySupport_list.jsp", response);
			
		} else {
			request.setAttribute("familySupport", familySupport);
			forwardDispatcher("../jsp/manage/familySupport_edit.jsp", request,response);
			
		}

	}
	
	private void deleteFamilySupport(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String supportID = request.getParameter("supportID");
		if(supportID != null && !"".equals(supportID)){
			flag = familySupportBiz.deleteFamilySupportBySupportID(supportID);
		}
		response.getWriter().print(flag);
	}

}
