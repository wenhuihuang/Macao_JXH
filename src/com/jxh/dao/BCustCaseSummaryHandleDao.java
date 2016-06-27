package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.BCustCaseSummaryHandlePojo;
import com.jxh.vo.BCustCaseSummaryHandle;

public class BCustCaseSummaryHandleDao extends DaoImpl {

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
	public PageUtils<BCustCaseSummaryHandlePojo> getBCustSummaryHandlePojoByCondition(PageUtils<BCustCaseSummaryHandlePojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = BCustCaseSummaryHandle.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		System.out.println("-------"+sql);
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<BCustCaseSummaryHandlePojo> bCustCaseSummaryHandlePojo = this.findForList(sql, params);
		page.setList(bCustCaseSummaryHandlePojo);
		return page;
	}
	
	
	public int[] insertBCustCaseSummaryHandle(List<BCustCaseSummaryHandle> bCustCaseSummaryHandleAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		clazz = BCustCaseSummaryHandle.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[bCustCaseSummaryHandleAdds.size()][];
		for(int i = 0;i<bCustCaseSummaryHandleAdds.size();i++){
			params[i] = getInsertParams(sql, bCustCaseSummaryHandleAdds.get(i));
		}
		return this.updateBatch(sql, params);
	}
	
	/**
	 * 更新結案人員處理方式
	 * @param bCustCaseSummaryHandle
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws ParseException
	 * @throws IOException
	 */
	public int[] updateBCustCaseSummaryHandle(List<BCustCaseSummaryHandle> bCustCaseSummaryHandle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[bCustCaseSummaryHandle.size()][];
		for (int i = 0; i < bCustCaseSummaryHandle.size(); i++) {
			params[i] = getUpdateParams(sql, bCustCaseSummaryHandle.get(i));
		}
		return this.updateBatch(sql, params);
		//int[] rows = updateBatchByList(sql, bCustCaseSummaryHandle);
		
		//return getflagByIntArray(rows);
	}
	
	
	/**
	 * 刪除結案人員處理方式
	 * @param bCustCaseSummaryHandle
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public int[] deleteBCustCaseSummaryHandle(List<BCustCaseSummaryHandle> bCustCaseSummaryHandle) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
	/*	Object[][] params = new Object[bCustCaseSummaryHandle.size()][1];
		for (int i = 0;i<bCustCaseSummaryHandle.size();i++) {
			params[i][0] = bCustCaseSummaryHandle.get(i).getHandleID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);*/
		
		Object[][] params = new Object[bCustCaseSummaryHandle.size()][1];
		for (int i = 0; i < bCustCaseSummaryHandle.size(); i++) {
			params[i][0] = bCustCaseSummaryHandle.get(i).getHandleID();
		}
		return this.updateBatch(sql, params);
	}


	public int deleteBCustCaseSummaryHandleByCaseID(String caseID) throws SQLException {
		String sql = "delete from BCustCaseSummaryHandle where caseID = ? ";
		return this.update(sql, caseID);
	}
}
