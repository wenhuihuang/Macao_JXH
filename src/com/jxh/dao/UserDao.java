package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.QxUsers;
import com.jxh.utils.Constants;
import com.jxh.vo.BCustCase;
import com.jxh.vo.BCustomer;

public class UserDao extends DaoImpl<QxUsers> {

	public QxUsers login(String userCode, String password) throws SQLException, IOException {
		return this.findForObject(this.getSqlByPropKey(ToolsUtils.getCurrentMethodName()), userCode, password);
	}

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public PageUtils<QxUsers> getAllUsers(PageUtils<QxUsers> page, String condition, Object... params)
			throws IOException, SQLException {
		// 获取SQL
		condition = condition == null ? "" : condition;
		String sql = "select * from qx_Users where userCode <> 'sa' ";
		// 获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<QxUsers> pojos = this.findForList(sql, params);
		page.setList(pojos);

		return page;
	}

	public QxUsers getUserById(String userId) throws SQLException {
		String sql = "select * from qx_Users where userId = ? ";
		return this.findForObject(sql, userId);
	}

	public int checkUserIsExistByCode(Object... params) throws SQLException {
		String sql = "select count(1) from qx_users where userCode = ? ";
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		// Object obj = bd.findBySql("select count(1) from qx_users where
		// userCode = '"+userCode+"' ");
		return count;
	}

	public int insertQxUsers(QxUsers qxUsers) throws SQLException, IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, ParseException {
		String userId = this.getPrimaryKey(Constants.CORPID);
		qxUsers.setUserId(userId);
		String sql = "insert into qx_Users(userId,userCode,userName,corpId,password,disChangePwd,nextMustChangePwd,note,isStop,fetionNo,fetionPwd,loginIp,cardNo,belongOrg) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = getInsertParams(sql, qxUsers);
		return this.update(sql, params);
	}

	public int updateQxUsers(QxUsers qxUsers) throws IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		// String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		String sql = "update qx_Users set userCode=?,userName=?,corpId=?,password=?,disChangePwd=?,nextMustChangePwd=?,note=?,isStop=?,fetionNo=?,fetionPwd=?,loginIP=?,cardNo=?,belongOrg=? where userId = ?";
		Object[] params = getUpdateParams(sql, qxUsers);
		return this.update(sql, params);
	}

	public String getPrimaryKey(String corpId) throws SQLException {
		return this.getPrimaryKey("QXUSERS", corpId, 12);
	}

	public int deleteByID(String userId) throws IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		// String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		String sql = "delete from qx_Users where userID = ?";
		return this.update(sql, userId);
	}


}
