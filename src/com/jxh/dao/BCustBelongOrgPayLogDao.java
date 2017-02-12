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
import com.jxh.pojo.BcustBelongOrgPayPojo;

public class BCustBelongOrgPayLogDao extends DaoImpl {

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public PageUtils<BcustBelongOrgPayPojo> getCustBelongOrgPayLogDaoByCondition(PageUtils<BcustBelongOrgPayPojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = BcustBelongOrgPayPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = "select bCustBelongOrg.*,bTypeCode.TypeName,bTypeCode.Cost,bTypeCode.Cycle,bCustomer.CustCode,bCustomer.FullName from bCustBelongOrg left outer join bTypeCode on bCustBelongOrg.TypeCode = bTypeCode.TypeCode  left outer join bCustomer on bCustBelongOrg.CustID = bCustomer.CustID where (Validay is null or   DATEDIFF(MONTH,  GetDate(),Validay ) <2) "+condition;
		//String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<BcustBelongOrgPayPojo> pojos = this.findForList(sql, params);
		page.setList(pojos);
		
		return page;
	}


}
