package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.QxUsers;

public class UserDao extends DaoImpl<QxUsers>{

	public QxUsers login(String userCode,String password) throws SQLException, IOException{
		return this.findForObject(this.getSqlByPropKey(ToolsUtils.getCurrentMethodName()), userCode,password);
	}
	
	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
