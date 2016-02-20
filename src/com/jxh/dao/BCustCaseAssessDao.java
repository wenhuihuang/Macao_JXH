package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.BCustCaseAssess;

public class BCustCaseAssessDao extends DaoImpl<BCustCaseAssess> {

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
	public PageUtils<BCustCaseAssess> getSpecialAllowanceByCondition(PageUtils<BCustCaseAssess> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<BCustCaseAssess> specialAllowances = this.findForList(sql, params);
		page.setList(specialAllowances);
		
		return page;
	}
	
	
	
	/**
	 * 新增個案轉介評估
	 * @param bCustCaseAssessAdds
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 * @throws IOException
	 * @throws SQLException
	 */
	public int insertBCustCaseAssess(BCustCaseAssess bCustCaseAssess) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, bCustCaseAssess);
		return this.update(sql, params);
	}
	
	/**
	 * 更新個案轉介評估
	 * @param bCustCaseAssess
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws ParseException
	 * @throws IOException
	 */
	public int updateBCustCaseAssess(BCustCaseAssess bCustCaseAssess) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, bCustCaseAssess);
		
		return this.update(sql, params);
	}
	
	
	/**
	 * 刪除個案轉介評估
	 * @param bCustCaseAssess
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public int deleteBCustCaseAssess(List<BCustCaseAssess> bCustCaseAssess) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[bCustCaseAssess.size()][1];
		for (int i = 0;i<bCustCaseAssess.size();i++) {
			params[i][0] = bCustCaseAssess.get(i).getAssessID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}


	public int deleteBCustCaseAssessByCaseID(String caseID) throws SQLException {
		String sql ="delete from BCustCaseAssess where caseID = ? ";
		return this.update(sql, caseID);
	}
}
