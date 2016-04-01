package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.FamilySupportApplyPojo;
import com.jxh.vo.FamilySupportApply;

public class FamilySupportApplyDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/familysupportapply.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<FamilySupportApply> getFamilySupportApplyByCondition(PageUtils<FamilySupportApply> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = FamilySupportApply.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<FamilySupportApply> familySupportApplys = this.findForList(sql, params);
		page.setList(familySupportApplys);
		
		return page;
	}
	
	public PageUtils<FamilySupportApplyPojo> getFamilySupportApply1ByCondition(PageUtils<FamilySupportApplyPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = FamilySupportApplyPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<FamilySupportApplyPojo> familySupportApplys = this.findForList(sql, params);
		System.out.println("1="+familySupportApplys+"sql="+sql);
		page.setList(familySupportApplys);
		
		return page;
	}
	public PageUtils<FamilySupportApplyPojo> getFamilySupportApply2ByCondition(PageUtils<FamilySupportApplyPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = FamilySupportApplyPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<FamilySupportApplyPojo> familySupportApplys = this.findForList(sql, params);
		System.out.println("2="+familySupportApplys);
		page.setList(familySupportApplys);
		
		return page;
	}
	public PageUtils<FamilySupportApplyPojo> getFamilySupportApply3ByCondition(PageUtils<FamilySupportApplyPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = FamilySupportApplyPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<FamilySupportApplyPojo> familySupportApplys = this.findForList(sql, params);
		System.out.println("3="+familySupportApplys);
		page.setList(familySupportApplys);
		
		return page;
	}
	
	public PageUtils<FamilySupportApplyPojo> getFamilySupportApplyPojoByCondition(PageUtils<FamilySupportApplyPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = FamilySupportApplyPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<FamilySupportApplyPojo> familySupportApplys = this.findForList(sql, params);
		page.setList(familySupportApplys);
		
		return page;
	}
	
	
	
	
	public int deleteFamilySupportApply(List<FamilySupportApply> familySupportApply) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[familySupportApply.size()][1];
		for (int i = 0;i<familySupportApply.size();i++) {
			params[i][0] = familySupportApply.get(i).getApplyID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	
	
	public FamilySupportApply getFamilySupportApplyByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = FamilySupportApply.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		return  (FamilySupportApply) this.findForObject(sql, params);
	}
	
	public int[] insertFamilySupportApplyBatch(List<FamilySupportApply> familySupportApplyAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		String sql = this.getSqlByPropKey("insertFamilySupportApply");
		return insertBatchByList(sql, familySupportApplyAdds);
	}

	public int[] updateFamilySupportApplyBatch(List<FamilySupportApply> familySupportApplyUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		String sql = this.getSqlByPropKey("updateFamilySupportApply");
		return updateBatchByList(sql, familySupportApplyUpdates);
	}

	public int deleteFamilySupportApplyBySupportID(String supportID) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		return this.update(sql, supportID);
	}
	
	
}
