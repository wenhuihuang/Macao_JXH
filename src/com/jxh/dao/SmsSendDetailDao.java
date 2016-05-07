package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.SmsSendDetail;

public class SmsSendDetailDao extends DaoImpl<SmsSendDetail> {

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 獵取右邊
	 * @param page
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<SmsSendDetail> getSmsSendDetailByCondition(PageUtils<SmsSendDetail> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<SmsSendDetail> list = this.findForList(sql, params);
		page.setList(list);
		
		return page;
	}
	
	public  List<SmsSendDetail> getAllSmsDetail(String billMasterId,boolean isSend) throws SQLException{
		String condition = "";
		if(isSend){
			condition = " and State <> 3 ";
		}
		String sql = "select * from SmsSendDetail where BillMasterID = '"+billMasterId+"' "+condition;
		
		//List<SmsSendDetail> details = (List<SmsSendDetail>) bd.findAllBySQL(SmsSendDetail.class, "select * from SmsSendDetail where BillMasterID = '"+billMasterId+"' "+condition, "BillDetailID desc", page);
		List<SmsSendDetail> details = this.findForList(sql);
		return details;
	}
	public boolean addCustomerToSMS(List<SmsSendDetail> details) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException{
		boolean flag = false;
		String sql = this.getSqlByPropKey("updateSmsSendDetail");
		int[] rows = updateBatchByList(sql, details);
		for(int row : rows){
			if(row>0){
				flag = true;
			}
		}
		return flag;
	}
}
