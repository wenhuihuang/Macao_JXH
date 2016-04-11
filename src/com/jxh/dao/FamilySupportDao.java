package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.FamilySupportPojo;
import com.jxh.vo.FamilySupport;

public class FamilySupportDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/familysupport.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<FamilySupportPojo> getFamilySupportPojo(PageUtils<FamilySupportPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = FamilySupportPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<FamilySupportPojo> familySupportPojos = this.findForList(sql, params);
		page.setList(familySupportPojos);
		
		return page;
	}
	
	
	
	
	public int insertFamilySupport(FamilySupport familySupport) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, familySupport);
		return this.update(sql, params);
	}
	
	
	public int updateFamilySupport(FamilySupport familySupport) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		clazz = FamilySupport.class;
		String sql = this.getSqlByPropKey("updateFamilySupport");
		Object[] params = getUpdateParams(sql, familySupport);
		System.out.println(familySupport);
		return this.update(sql, params);
	}
	
	
	
	public int deleteFamilySupport(List<FamilySupport> familySupport) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[familySupport.size()][1];
		for (int i = 0;i<familySupport.size();i++) {
			params[i][0] = familySupport.get(i).getSupportID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	
	public int deleteFamilySupportBySupportID(String supportID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, supportID);
	}
	
	public FamilySupport getFamilySupportByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = FamilySupport.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		return  (FamilySupport) this.findForObject(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("FAMILYSUPPORT", corpId, 20);
	}
	public String getSupportNO(String corpId) throws SQLException{
		return this.getPrimaryKey("SUPPORTNO", corpId, 4);
	}
	
}
