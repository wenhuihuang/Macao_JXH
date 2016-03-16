package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.pojo.CarSettingPojo;
import com.jxh.vo.CarSetting;

public class CarSettingDao extends DaoImpl{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/carsetting.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<CarSettingPojo> getCarSettingPojo(PageUtils<CarSettingPojo> page, String condition,Object ...params) throws SQLException, IOException{
		clazz = CarSettingPojo.class;
		//获取SQL
		condition = condition ==null?"":condition;
		String sql = getSqlByPropKey(ToolsUtils.getCurrentMethodName())+condition;
		//获取总页数
		Integer count = (Integer) this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		List<CarSettingPojo> carSettingPojos = this.findForList(sql, params);
		page.setList(carSettingPojos);
		
		return page;
	}
	
	
	
	
	public int insertCarSetting(CarSetting carSetting) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, carSetting);
		return this.update(sql, params);
	}
	
	
	public int updateCarSetting(CarSetting carSetting) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, carSetting);
		return this.update(sql, params);
	}
	
	
	
	public int deleteCarSetting(List<CarSetting> carSetting) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[carSetting.size()][1];
		for (int i = 0;i<carSetting.size();i++) {
			params[i][0] = carSetting.get(i).getCarID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	
	public int deleteCarSettingByCarID(String carID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, carID);
	}
	
	public CarSetting getCarSettingByCondition(String condition, Object...params) throws IOException, SQLException {
		clazz = CarSetting.class;
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		return  (CarSetting) this.findForObject(sql, params);
	}
	
	public String getPrimaryKey(String corpId) throws SQLException{
		return this.getPrimaryKey("CARSETTING", corpId, 20);
	}
	
}
