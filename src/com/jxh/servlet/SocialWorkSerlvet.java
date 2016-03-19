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
import com.jxh.biz.SocialWorkBiz;
import com.jxh.dao.SocialWorkDao;
import com.jxh.vo.SocialWork;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TreatmentSerlvet
 */
@WebServlet("/SocialWork/*")
public class SocialWorkSerlvet extends FGServlet {
	private static final long serialVersionUID = 1L;
    
	private SocialWorkDao socialWorkDao = new SocialWorkDao();
	private SocialWorkBiz socialWorkBiz = new SocialWorkBiz();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialWorkSerlvet() {
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
		PageUtils<SocialWork> page = this.getPage(request);
		socialWorkDao.getSocialWork(page,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {

			SocialWork socialWork = new SocialWork();

			request.setAttribute("socialWork", socialWork);
			forwardDispatcher("../jsp/manage/socialWork_edit.jsp", request, response);
			

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			SocialWork socialWork = socialWorkDao.getSocialWorkByCondition(" and workID = ? ",
					this.getParameterByName(request, "workID"));
		
			request.setAttribute("socialWork", socialWork);
			
				forwardDispatcher("../jsp/manage/socialWork_edit.jsp",request,response);
			

		} catch (IOException | SQLException | ServletException e) {
			e.printStackTrace();
		}

	}

	
	private void submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		SocialWork socialWork = this.getObjectByParameter(request, SocialWork.class);
		String message = "";
		
			if (socialWork.getWorkID() != null && !"".equals(socialWork.getWorkID())) {
				message = socialWorkBiz.updateSocialWork(socialWork);
			} else {
				message = socialWorkBiz.insertSocialWork(socialWork);
			}
	

		// 设置为表单jsp
		request.setAttribute("msg", message);
		

		if (message.indexOf("成功") > 0) {
			sendRedirect("../jsp/manage/socialWork_list.jsp", response);
			
		} else {
			request.setAttribute("socialWork", socialWork);
			forwardDispatcher("../jsp/manage/socialWork_edit.jsp", request,response);
			
		}

	}
	
	private void deleteSocialWork(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean flag = false;
		String workID = request.getParameter("workID");
		if(workID != null && !"".equals(workID)){
			flag = socialWorkBiz.deleteSocialWorkByWorkID(workID);
		}
		response.getWriter().print(flag);
	}

}
