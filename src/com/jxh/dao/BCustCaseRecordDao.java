package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.BCustCaseRecord;

public class BCustCaseRecordDao extends DaoImpl<BCustCaseRecord> {

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
	public PageUtils<BCustCaseRecord> getSpecialAllowanceByCondition(PageUtils<BCustCaseRecord> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<BCustCaseRecord> specialAllowances = this.findForList(sql, params);
		page.setList(specialAllowances);
		
		return page;
	}
	
	
	
	
	/**
	 * 新增特别津贴
	 * @param cssas
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 * @throws IOException
	 * @throws SQLException
	 */
	public int[] insertBCustCaseRecord(List<BCustCaseRecord> bCustCaseRecordAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[bCustCaseRecordAdds.size()][];
		for(int i = 0;i<bCustCaseRecordAdds.size();i++){
			params[i] = getInsertParams(sql, bCustCaseRecordAdds.get(i));
		}
		return this.updateBatch(sql, params);
	}
	
	/**
	 * 更新個案撮要記錄
	 * @param bCustCaseRecord
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws ParseException
	 * @throws IOException
	 */
	public int updateBCustCaseRecord(List<BCustCaseRecord> bCustCaseRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, bCustCaseRecord);
		
		return getflagByIntArray(rows);
	}
	
	
	/**
	 * 刪除個案撮要記錄
	 * @param bCustCaseRecord
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public int deleteBCustCaseReord(List<BCustCaseRecord> bCustCaseRecord) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[bCustCaseRecord.size()][1];
		for (int i = 0;i<bCustCaseRecord.size();i++) {
			params[i][0] = bCustCaseRecord.get(i).getRecordID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}


	public int BCustCaseRecordByCaseID(String caseID) throws SQLException {
		String sql = "delete from BCustCaseRecord where caseID = ? ";
		return this.update(sql, caseID);
	}
}
