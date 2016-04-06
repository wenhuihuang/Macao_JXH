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
import com.jxh.pojo.Customer;
import com.jxh.vo.BCustomer;

public class CustomerDao extends DaoImpl<BCustomer> {

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public BCustomer getCustomerByCondition(String condition, Object... params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());

		sql += condition == null || "".equals(condition) ? "" : condition;
		return this.findForObject(sql, params);
	}

	/**
	 * 获取所有会员
	 * 
	 * @param page
	 * @param condition
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public PageUtils<Customer> getCustomerList(PageUtils page, String condition, Object... params)
			throws IOException, SQLException {

		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition == null ? "" : condition;
		sql += condition;
		System.out.println(sql);
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);

		List<BCustomer> bcusts = this.findForList(sql, params);

		// 其它可以跳过
		List<Customer> custs = new ArrayList<Customer>();
		if (bcusts != null) {
			for (BCustomer cust : bcusts) {
				Date regDate = cust.getRegDate();

				Date validDate = cust.getValidDate();

				custs.add(new Customer(cust.getCustID(), cust.getCustCode(), cust.getFullName(), cust.getFullNameEng(),
						cust.getSex(), cust.getCustType(), cust.getCardStatus(), regDate, validDate, cust.getCardType(),
						cust.getCardNo(), cust.getTelNo(), cust.getMobileTelNO(), cust.getRelationship(),
						cust.getCustNO(), cust.getCustNewNO(), cust.getJob(), cust.getIsSociaWork()));
			}
		}

		page.setList(custs);

		return page;

	}

	/**
	 * 新增
	 * 
	 * @param cust
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws ParseException
	 */
	public int insertCustomer(BCustomer cust) throws SQLException, IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, ParseException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, cust);
		return this.update(sql, params);
	}

	/**
	 * 批量增加，家庭成员
	 * 
	 * @param custs
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 */
	public int[] insertCustomerBatch(List<BCustomer> custs) throws SQLException, IOException, NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException, ParseException {
		String sql = this.getSqlByPropKey("insertCustomer");
		Object[][] params = new Object[custs.size()][];
		for (int i = 0; i < custs.size(); i++) {
			params[i] = getInsertParams(sql, custs.get(i));
		}
		return this.updateBatch(sql, params);
	}

	/**
	 * 更新
	 * 
	 * @param cust
	 * @return
	 * @throws IOException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public int updateCustomer(BCustomer cust) throws IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		String sql = this.getSqlByPropKey("updateCustomer");
		Object[] params = getUpdateParams(sql, cust);
		return this.update(sql, params);
	}

	/**
	 * 批量更新 ，家庭成员
	 * 
	 * @param custs
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 * @throws SQLException
	 * @throws IOException
	 */
	public int[] updateCustomerBatch(List<BCustomer> custs) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, ParseException, SQLException, IOException {
		String sql = this.getSqlByPropKey("updateCustomer");
		Object[][] params = new Object[custs.size()][];
		for (int i = 0; i < custs.size(); i++) {
			params[i] = getUpdateParams(sql, custs.get(i));
		}
		return this.updateBatch(sql, params);
	}

	/**
	 * 批量删除Customer
	 * 
	 * @param custs
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public int[] deleteCustomerBatch(List<BCustomer> custs) throws IOException, SQLException {
		String sql = this.getSqlByPropKey("deleteCustomerById");
		Object[][] params = new Object[custs.size()][1];
		for (int i = 0; i < custs.size(); i++) {
			params[i][0] = custs.get(i).getCustID();
		}
		return this.updateBatch(sql, params);
	}

	public String getPrimaryKey(String corpId) throws SQLException {
		return this.getPrimaryKey("BCUSTOMER", corpId, 20);
	}
	public int deleteCustomer(String custID) throws IOException, SQLException {
		String sql = this.getSqlByPropKey("deleteCustomerById");
		return this.update(sql, custID);
	}
	public int deleteFamilyByGuardianCustID(String custID) throws IOException, SQLException {
		String sql = this.getSqlByPropKey("deleteFamilyByGuardianCustID");
		return this.update(sql, custID);
	}

}
