package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.QxUsers;
import com.jxh.vo.ActivityApply;
import com.jxh.vo.SmsSendMaster;

public class SmsSendMasterDao extends DaoImpl<SmsSendMaster>{

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 獲取左邊
	 * @param page
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<SmsSendMaster> getSmsSendMasterByCondition(PageUtils<SmsSendMaster> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<SmsSendMaster> list = this.findForList(sql, params);
		page.setList(list);
		
		return page;
	}
	public SmsSendMaster getSmsMasterId(String Id) throws SQLException {
		String sql = "select * from SmsSendMaster where BillMasterID = ? ";
		return this.findForObject(sql, Id);
	}
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("SMSSENDMASTER", corpId, 20);
	}

	public int insertSmsSendMaster(SmsSendMaster smsSendMaster) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, smsSendMaster);
		return this.update(sql, params);
	}
	
	public int updateSmsSendMaster(SmsSendMaster smsSendMaster) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, smsSendMaster);
		return this.update(sql, params);
	}
}
