package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.QxUserRights;
import com.jxh.vo.BCustomer;

public class UserRightDao extends DaoImpl<QxUserRights> {

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public PageUtils<QxUserRights> getAllUserRightsByUserId(PageUtils<QxUserRights> page, String condition,
			Object... params) throws IOException, SQLException {
		// 获取SQL
		condition = condition == null ? "" : condition;
		String sql = "select qx_UserRights.* from qx_UserRights left outer join qx_FunctList on qx_UserRights.FuncID = qx_FunctList.FuncID where isHide = 0 and userId <> 'sa' and qx_UserRights.userId = ? ";
		// 获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<QxUserRights> pojos = this.findForList(sql + " ORDER BY qx_FunctList.funcType ", params);
		page.setList(pojos);

		return page;
	}

	public int[] updateQxUserRightsBatch(List<QxUserRights> qxUserRights) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, ParseException, SQLException, IOException {
		String sql = "update qx_UserRights set userID=?,funcID=?,fView=?,fAdd=?,fModify=?,fDelete=?,fViewPrice=?,fPrint=?,fDesignReport=?,fExportData=?,fCheck=?,fUnCheck=?,fDisuse=?,fUnDisuse=?,fExecute=?,allCorpRight=? where userRightsID = ? ";
		return  updateBatchByList(sql, qxUserRights);
		
	}

}
