package com.jxh.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fg.ligerui.LigerUITools;
import com.fg.servlet.FGServlet;
import com.fg.utils.MD5S;
import com.fg.utils.PageUtils;
import com.fg.utils.SendPostMessage;
import com.jxh.dao.ActivityApplyDao;
import com.jxh.dao.ActivitySettingDao;
import com.jxh.dao.BtypeCodeDao;
import com.jxh.dao.CustomerDao;
import com.jxh.dao.SmsSendDetailDao;
import com.jxh.dao.SmsSendMasterDao;
import com.jxh.dao.UserDao;
import com.jxh.pojo.ActivityApplyPojo;
import com.jxh.pojo.ActivitySettingPojo;
import com.jxh.pojo.BtypeCode;
import com.jxh.pojo.Customer;
import com.jxh.pojo.QxUserRights;
import com.jxh.pojo.QxUsers;
import com.jxh.pojo.SmsSendDetailPojo;
import com.jxh.vo.ActivityRecordNew;
import com.jxh.vo.ActivitySetting;
import com.jxh.vo.SmsSendDetail;
import com.jxh.vo.SmsSendMaster;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * Servlet implementation class User
 */
@WebServlet("/SmsSendServlet/*")
public class SmsSendServlet extends FGServlet {
	private static final long serialVersionUID = 1L;
    private SmsSendMasterDao smsSendMasterDao = new SmsSendMasterDao();
    private SmsSendDetailDao smsSendDetailDao = new SmsSendDetailDao();
    private UserDao userDao = new UserDao();
    private BtypeCodeDao btypeCodeDao = new BtypeCodeDao();
    private CustomerDao customerDao = new CustomerDao();
    private ActivitySettingDao activitySettingDao = new ActivitySettingDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmsSendServlet() {
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
	/**
	 * 獵取左邊主表
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void getGridMastersFromUrl(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		PageUtils<SmsSendMaster> page = this.getPage(request);
		smsSendMasterDao.getSmsSendMasterByCondition(page,null);
		System.out.println(smsSendMasterDao.getSmsSendMasterByCondition(page,null));
		LigerUITools.writeGridJson(page, response);
	}
	
	/**
	 * 獵取右邊
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void getGridDetailsFromUrl(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String currentMasterid = request.getParameter("currentMasterid");
		String condition = " and BillMasterID = '"+currentMasterid+"'";
		PageUtils<SmsSendDetail> page = this.getPage(request);
		smsSendDetailDao.getSmsSendDetailByCondition(page,condition,null);
		LigerUITools.writeGridJson(page, response);
	}
	
	/**
	 * 获取所有用户并跳转
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws SQLException
	 * @throws ServletException
	 */
	private void showSingle(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException{
		PageUtils<QxUsers> page = this.getPage(request);
		String condition = " and actID = ? ";
		userDao.getAllUsers(page, condition, null);
		
		 String masterUserIds = LigerUITools.getGridJson(page);
		request.setAttribute("masterUserIds", masterUserIds);
		forwardDispatcher("../jsp/manage/SmsSend_ShowSingle.jsp", request, response);
	}
	
	private void getSingleMasterById(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		String editPrimaryKey = request.getParameter("editPrimaryKey");
		SmsSendMaster obj = new SmsSendMaster();
		if(editPrimaryKey==null||"".equals(editPrimaryKey)){
			
			obj.setBillMasterID(smsSendMasterDao.getPrimaryKey("0001"));
			obj.setState(0);
			obj.setCorpID("0001");
			
			QxUsers tmpUsers = (QxUsers) request.getSession().getAttribute("user");
			if(tmpUsers!=null){
				
				obj.setMakeUserID(tmpUsers.getUserId());	
			}
			obj.setBillDate(new Date());
			
			
			String rs = JSONObject.fromObject(obj).toString();
			System.out.println("1"+rs);
			response.getWriter().print(rs);
		}else{
			obj = smsSendMasterDao.getSmsMasterId(editPrimaryKey);
			String rs = JSONObject.fromObject(obj).toString();
			response.getWriter().print(rs);
		}
		
		
	
	}
	
	/**
	 * 获取树形
	 * @return
	 */
	private void getCustTypeCodesTree(HttpServletRequest request, HttpServletResponse response){
		try {

			List<BtypeCode> masterDataList = btypeCodeDao.getAllTypeCodeByTypeBase("01"); 
			String results = "";
			if (masterDataList != null) {

				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < masterDataList.size(); i++) {
					sb.append("{");
					String resultId = masterDataList.get(i).getTypeCode();
					// 如果没有pid 默认设置为0
					String resultPid = masterDataList.get(i).getPid();
					resultPid = resultPid == null ? "0" : resultPid;

					String resultText = masterDataList.get(i).getText();

					sb.append("\"id\":\"" + resultId + "\",\"pid\":\""
							+ resultPid + "\",\"text\":\"" + resultText + "\"");
					sb.append("},");
				}

				results = "[" + sb.substring(0, sb.length() - 1) + "]";
			}
			
			response.getWriter().print(results);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 保存短信人员
	 * @return
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IOException 
	 */
	private void addCustomerToSMS(HttpServletRequest request, HttpServletResponse response) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String editPrimaryKey = request.getParameter("editPrimaryKey");
		String custArrays = request.getParameter("custArrays");
		boolean flag = false;
		try {
			if(custArrays!=null&&!"".equals(custArrays)){
				
				List<SmsSendDetailPojo> pojos = JSONArray.toList(JSONArray.fromObject(custArrays),new SmsSendDetailPojo(),new JsonConfig());
				List<SmsSendDetail> details = new ArrayList<SmsSendDetail>();
				for (SmsSendDetailPojo smsSendDetailPojo : pojos) {
					if(smsSendDetailDao.findSmsUserIsExistInMaster(editPrimaryKey, smsSendDetailPojo.getMobileTelNO())<=0){
						SmsSendDetail detail = new SmsSendDetail();
						detail.setBillDetailID(smsSendDetailDao.getPrimaryKey("0001"));
						detail.setBillMasterID(editPrimaryKey);
						detail.setTelNO(smsSendDetailPojo.getMobileTelNO());
						detail.setTelName(smsSendDetailPojo.getFullName());
						detail.setState(0);
						details.add(detail);
					}
				}
				
				
				
				
				if(smsSendDetailDao.addCustomerToSMS(details)){
					flag = true;
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		response.getWriter().print(flag);
		
	}
	
	/**
	 * 獵取人員
	 * @return
	 * @throws SQLException 
	 */
	private void getCustomers(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		
		try {
			
			String result = "";
			String custActID =  request.getParameter("custActID");
			String custTypeCode = request.getParameter("custTypeCode");
			String custCondition =  request.getParameter("custCondition");
			System.out.println("1"+custActID);
			System.out.println("2"+custTypeCode);
			
		if(custCondition==null||"".equals(custCondition)){
				
				String condition = "";
				if(custTypeCode!=null&&!"".equals(custTypeCode)){
					condition += " and TypeCode like '"+custTypeCode+"%'";
				}
				
				if(custActID!=null&&!"".equals(custActID)){
					condition += " and ActID = '"+custActID+"' ";
				}
				PageUtils<Customer> page = this.getPage(request);
				customerDao.getCustomerList(page,condition,null);
				LigerUITools.writeGridJson(page, response);
				
				
			}else{
				
				
				
				custCondition = new String(custCondition.getBytes("ISO-8859-1"),"UTF-8");
				String condition = " and (CustCode like '%"+custCondition+"%' or FullName like '%"+custCondition+"%') ";
				if(custActID!=null&&!"".equals(custActID)){
					condition += " and ActID = '"+custActID+"' ";
				}
				
				PageUtils<Customer> page = this.getPage(request);
				customerDao.getCustomerList(page,condition,null);
				LigerUITools.writeGridJson(page, response);
				
			}
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 獵取所有用戶
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws SQLException
	 * @throws ServletException
	 */
	private void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException{
		PageUtils<QxUsers> page = this.getPage(request);
		String condition = " and actID = ? ";
		userDao.getAllUsers(page, condition, null);
		
		 String masterUserIds = LigerUITools.getGridJson(page);
		/*request.setAttribute("masterUserIds", masterUserIds);*/
		response.getWriter().print(masterUserIds);
	}
	/**
	 * 读取活动
	 * @return
	 */
	private void loadActivitys(HttpServletRequest request, HttpServletResponse response){

			try {
				String condition = request.getParameter("condition");
				System.out.println("con="+condition);
				
				String conditionResult = "";
				
				
				if(condition!=null&&!"".equals(condition)&&!"[]".equals(condition)){
					
					condition = condition.substring(2,condition.length()-2);
					String[] conditions = condition.split(",");
					
					
					
					String fieldName = "";
					String fieldValue = "";
					for (String con : conditions) {
						
						if(con.indexOf("field")>-1){
							fieldName = con.split(":")[1].replace("\"", "");
						}
						if(con.indexOf("value")>-1){
							fieldValue = con.split(":")[1].replace("\"", "");
						}
					}
					
					if(fieldName!=null&&!"".equals(fieldName)){
						conditionResult = " and ( ActName like '%"+fieldValue+"%' OR ActNO like '%"+fieldValue+"%')"; 
					}
					
				}
				PageUtils<ActivitySettingPojo> page = this.getPage(request);
				activitySettingDao.getActivitySettingPojo(page,conditionResult);
				LigerUITools.writeGridJson(page, response);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * 选择发送信息
	 * @return
	 */
	private void sendSelectedMessages(HttpServletRequest request, HttpServletResponse response){
		String editPrimaryKey = request.getParameter("editPrimaryKey");
		
		try {
			
			
			//權限
		/*	String NOPERMISSION = (String) request.getAttribute("NOPERMISSION");
			if(NOPERMISSION!=null&&!"".equals(NOPERMISSION)){
				writeToHtml("{\"title\":\""+NOPERMISSION+"\"}");
			}*/
			
			
			List<SmsSendDetail> details = smsSendDetailDao.getAllSmsDetail(editPrimaryKey, true);
			
			SmsSendMaster smsMaster = smsSendMasterDao.getSmsMasterId(editPrimaryKey);
			
			
			
			
			SendPostMessage send = new SendPostMessage();
			String urlAddr = "http://202.75.248.226/HttpSend/HttpSendAction";
			Map<String,String> map = new HashMap<String,String>();
			map.put("copid", "20987");
			Calendar nowDate = Calendar.getInstance();
			String year = nowDate.get(Calendar.YEAR)+"";
			String month = nowDate.get(Calendar.MONTH)<10?"0"+nowDate.get(Calendar.MONTH):nowDate.get(Calendar.MONTH)+"";
			String day = nowDate.get(Calendar.DATE)<10?"0"+nowDate.get(Calendar.DATE):nowDate.get(Calendar.DATE)+"";
			String hour = nowDate.get(Calendar.HOUR)<10?"0"+nowDate.get(Calendar.HOUR):nowDate.get(Calendar.HOUR)+"";
			String minute = nowDate.get(Calendar.MINUTE)<10?"0"+nowDate.get(Calendar.MINUTE):nowDate.get(Calendar.MINUTE)+"";
			String second = nowDate.get(Calendar.SECOND)<10?"0"+nowDate.get(Calendar.SECOND):nowDate.get(Calendar.SECOND)+"";
			map.put("time", "1308191750");
			map.put("username", "jzxj");
			map.put("password", "jzxj@853");
			map.put("from", "65604247");
			
			map.put("text", smsMaster.getSms());
			
			StringBuffer result = new StringBuffer();
			
			List<SmsSendDetail> newDetails = new ArrayList<SmsSendDetail>();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String nowDAY = sdf.format(new Date());
			for (SmsSendDetail smsSendDetail : details) {
				map.put("to", smsSendDetail.getTelNO());
				
				if(send.send(urlAddr, map)==false){
					result.append(smsSendDetail.getTelName()+",");
					smsSendDetail.setState(9);
					
				}else{
					Integer tryTime = smsSendDetail.getTryTimes()==null?0:smsSendDetail.getTryTimes();
					smsSendDetail.setTryTimes(tryTime+1);
					smsSendDetail.setState(3);
				}
				smsSendDetail.setSendDateTime(Timestamp.valueOf(nowDAY));
				newDetails.add(smsSendDetail);
			}
			
			
			smsSendDetailDao.updateCustomerToSMS(newDetails);
			
			
			if(result.length()>0){
				result.append("發送短信失敗！");
			}else{
				smsMaster.setState(2);
				smsSendMasterDao.updateSmsSendMaster(smsMaster);
				result.append("發送短信成功！");
			}
			
			response.getWriter().println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void addOrEditMasterRow(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, ParseException, IllegalArgumentException, IOException, SQLException{
		String _status= request.getParameter("_status");
		SmsSendMaster smsSendMaster = this.getObjectByParameter(request, SmsSendMaster.class);
		if( "add".equals(_status)){
			if(smsSendMasterDao.insertSmsSendMaster(smsSendMaster) > 0)
			{
				response.getWriter().print(smsSendMaster.getBillMasterID()+"新增成功");
			}else{
				response.getWriter().print("新增失敗！");
			}
		}else{
			if(smsSendMasterDao.updateSmsSendMaster(smsSendMaster) > 0){
				response.getWriter().print("修改成功！");
			}else{
				response.getWriter().print("修改失敗！");
			}
		}
		
	}
	
	private void deleteMasterRowById(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, ParseException, SQLException{
		boolean flag = false;
		SmsSendMaster smsSendMaster = this.getObjectByParameter(request, SmsSendMaster.class);
		if(!"".equals(smsSendMaster) && smsSendMaster != null){
			String billMasterID = smsSendMaster.getBillMasterID();
			smsSendDetailDao.deleteSmsSendDetailByBillMasterID(billMasterID);
			if(smsSendMasterDao.deleteSmsSendMaster(smsSendMaster) > 0){
				flag=true;
			}
			
		}
		response.getWriter().print(flag);
	}
	
	private void deleteDetailById(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, ParseException, IOException, SQLException{
		//SmsSendDetail smsSendDetail = this.getObjectByParameter(request, SmsSendDetail.class);
		boolean flag = false;
		String billDetailID = request.getParameter("billDetailID");
		System.out.println("billDetailID="+billDetailID);
		if(!"".equals(billDetailID) && billDetailID != null){
			if(smsSendDetailDao.deleteSmsSendDetail(billDetailID) > 0){
				flag = true;
			}
		}
		response.getWriter().print(flag);
	}
	
}
