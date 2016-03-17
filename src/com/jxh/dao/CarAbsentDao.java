package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.CarAbsentPojo;
import com.jxh.vo.CarAbsent;

public class CarAbsentDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/carabsent.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<CarAbsent> getCarAbsentByCondition(PageUtils<CarAbsent> page, String condition,Object ...params) throws SQLException, IOException{
		clazz=CarAbsent.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<CarAbsent> carAbsents = this.findForList(sql, params);
		page.setList(carAbsents);
		
		return page;
	}
	
	
	
	
	public int[] insertCarAbsentBatch(List<CarAbsent> carAbsents) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey("insertCarAbsent");
		//return this.update(sql, params);
		return insertBatchByList(sql, carAbsents);
	}
	
	
	public int updateCarAbsent(List<CarAbsent> carAbsents) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, carAbsents);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteCarAbsent(List<CarAbsent> carAbsents) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[carAbsents.size()][1];
		for (int i = 0;i<carAbsents.size();i++) {
			params[i][0] = carAbsents.get(i).getAbsentID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteCarAbsentByCarID(String carID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, carID);
	}
	
	public CarAbsent getCarAbsentByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = CarAbsent.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		return  (CarAbsent) this.findForObject(sql, params);
	}

	public PageUtils<CarAbsentPojo> getCarAbsentPojoByCondition(PageUtils<CarAbsentPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz=CarAbsentPojo.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<CarAbsentPojo> carAbsents = this.findForList(sql, params);
		page.setList(carAbsents);
		
		return page;
	}
	
	
}
