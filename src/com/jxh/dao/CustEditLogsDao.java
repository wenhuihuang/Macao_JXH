package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.BcustEditLogsMasterPojo;

public class CustEditLogsDao extends DaoImpl {

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public PageUtils<BcustEditLogsMasterPojo> getCustEditLogsByCondition(PageUtils<BcustEditLogsMasterPojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = BcustEditLogsMasterPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = "select CustID,CustCode,FullName,Status, convert(varchar(19),billDate,120) BillDate,isRead from bCustEditLogs where 1=1 "+condition+" group by CustID,CustCode,FullName,Status, billDate,isRead ";
		//String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<BcustEditLogsMasterPojo> pojos = this.findForList(sql, params);
		page.setList(pojos);
		
		return page;
	}


}
