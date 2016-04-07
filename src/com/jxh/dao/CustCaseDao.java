package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.BCustCaseRecordPojo;
import com.jxh.pojo.CustCasePojo;
import com.jxh.vo.BCustCase;
import com.jxh.vo.BCustCaseRecord;

public class CustCaseDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return "/sqls/Macao_JXH/custcase.properties";
	}
	
	/**
	 * 獲取所有個案
	 * @param page
	 * @param condition
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public PageUtils<CustCasePojo> getCustCasePojoList(PageUtils<CustCasePojo> page,String condition,Object...params) throws IOException, SQLException{
		clazz = CustCasePojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<CustCasePojo> pojos = this.findForList(sql, params);
		page.setList(pojos);
		
		return page;
	}
	
	public CustCasePojo getCustCasePojoByCondition(String condition,Object...params) throws IOException, SQLException{
		clazz = CustCasePojo.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		System.out.println(sql);
		return (CustCasePojo) this.findForObject(sql, params);
	}
	
	public CustCasePojo getCustCasePojoByCustId(String condition,Object...params) throws IOException, SQLException{
		clazz = CustCasePojo.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		//System.out.println("sql++"+condition);
		return (CustCasePojo) this.findForObject(sql, params);
	}
	
	/**
	 * 获取所有個案
	 * @param page
	 * @param condition
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public PageUtils<BCustCase> getCustCaseList(PageUtils page,String condition,Object...params) throws IOException, SQLException{
		
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<BCustCase> custCases = this.findForList(sql, params);
		
/*		//其它可以跳过
		List<CustCasePojo> custs = new ArrayList<Customer>();
		if(bcusts!=null){
			for (CustCase cust : bcusts) {
				Date regDate = cust.getRegDate();
				
				Date validDate = cust.getValidDate();
				
				custs.add(new Customer(cust.getCustId(), cust.getCustCode(), cust.getFullName(),
						cust.getFullNameEng(), cust.getSex(), cust.getCustType(), cust.getCardStatus(), 
						regDate, validDate, cust.getCardType(), cust.getCardNo(),cust.getTelNo()
						,cust.getMobileTelNo(),cust.getRelationship()));
			}
		}*/
		
		/*Iterator it = custCases.iterator();
		while(it.hasNext()){
			CustCase c = (CustCase)it.next();
			//System.out.println(c.getCustId());
		}
		*/
		page.setList(custCases);
		
		return page;
		
	}
	
	
	/**
	 * 新增
	 * @param custCase
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws ParseException 
	 */
	public int insertCustCase(BCustCase custCase) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, custCase);
		return this.update(sql, params);
	}
	
	/**
	 * 批量增加
	 * @param custCases
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 */
	public int[] insertCustCaseBatch(List<BCustCase> custCases) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey("insertCustomer");
		Object[][] params = new Object[custCases.size()][];
		for(int i = 0;i<custCases.size();i++){
			params[i] = getInsertParams(sql, custCases.get(i));
		}
		return this.updateBatch(sql, params);
	}
	


	/**
	 * 更新
	 * @param custCase
	 * @return
	 * @throws IOException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws ParseException 
	 */
	public int updateCustCase(BCustCase custCase) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException {
		// TODO Auto-generated method stub
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, custCase);
		return this.update(sql, params);
	}
	
	
	public int deleteCustCaseByCaseID(String caseID) throws SQLException{
		String sql = "delete from BCustCase where CaseID = ? ";
		return this.update(sql, caseID);
	}
	
	
	/**
	 * 批量更新 ，家庭成员
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
	public int[] updateCustCaseBatch(List<BCustCase> custCases) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, SQLException, IOException{
		String sql = this.getSqlByPropKey("updateCustomer");
		Object[][] params = new Object[custCases.size()][];
		for (int i = 0; i < custCases.size(); i++) {
			params[i] = getUpdateParams(sql, custCases.get(i));
		}
		return this.updateBatch(sql, params);
	}


	
	
	/**
	 * 批量删除Customer
	 * @param custs
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public int[] deleteCustCaseBatch(List<BCustCase> custCases) throws IOException, SQLException{
		String sql = this.getSqlByPropKey("deleteCustCaseById");
		Object[][] params = new Object[custCases.size()][1];
		for (int i = 0; i < custCases.size(); i++) {
			params[i][0] = custCases.get(i).getCaseID();
		}
		System.out.println("deletesql=="+params);
		return this.updateBatch(sql, params);
	}
	
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("BCUSTOMER", corpId, 20);
	}

	public String getCaseNO(String corpId) throws SQLException{
		return this.getPrimaryKey("CASENO", corpId, 4);
	}
	
}
