package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.BCustCaseSummary;

public class BCustCaseSummaryDao extends DaoImpl<BCustCaseSummary> {

	@Override
	protected String getSqlPropertiesPath() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<BCustCaseSummary> getSpecialAllowanceByCondition(PageUtils<BCustCaseSummary> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<BCustCaseSummary> specialAllowances = this.findForList(sql, params);
		page.setList(specialAllowances);
		
		return page;
	}
	
	
	
	/**
	 * 新增結案摘要
	 * @param bCustCaseRecordAdds
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 * @throws IOException
	 * @throws SQLException
	 */
	public int insertBCustCaseSummary(BCustCaseSummary bCustCaseSummary) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, bCustCaseSummary);
		return this.update(sql, params);
	}
	
	/**
	 * 更新結案摘要
	 * @param bCustCaseSummary
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws ParseException
	 * @throws IOException
	 */
	public int updateBCustCaseSummary(BCustCaseSummary bCustCaseSummary) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, bCustCaseSummary);
		return this.update(sql, params);
	}
	
	
	/**
	 * 刪除結案摘要
	 * @param bCustCaseSummary
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public int deleteBCustCaseSummary(List<BCustCaseSummary> bCustCaseSummary) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[bCustCaseSummary.size()][1];
		for (int i = 0;i<bCustCaseSummary.size();i++) {
			params[i][0] = bCustCaseSummary.get(i).getSummaryID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}


	public int deleteBCustCaseSummaryByCaseID(String caseID) throws SQLException {
		String sql = "delete from BCustCaseSummary where caseID = ? ";
		return this.update(sql, caseID);
	}


	public String getPrimaryKey(String corpId) throws SQLException {
		return this.getPrimaryKey("BCUSTOMER", corpId, 20);
	}
}
