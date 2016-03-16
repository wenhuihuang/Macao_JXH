package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.CarRecord;

public class CarRecordDao extends DaoImpl<CarRecord>{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/carrecord.properties";
	}

	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<CarRecord> getCarRecordByCondition(PageUtils<CarRecord> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<CarRecord> carRecords = this.findForList(sql, params);
		page.setList(carRecords);
		
		return page;
	}
	
	
	
	
	public int[] insertCarRecordBatch(List<CarRecord> carRecords) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException{
		String sql = this.getSqlByPropKey("insertCarRecord");
		//return this.update(sql, params);
		return insertBatchByList(sql, carRecords);
	}
	
	
	public int updateCarRecord(List<CarRecord> carRecords) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		int[] rows = updateBatchByList(sql, carRecords);
		
		return getflagByIntArray(rows);
	}
	
	
	
	public int deleteCarRecord(List<CarRecord> carRecords) throws IOException, SQLException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[][] params = new Object[carRecords.size()][1];
		for (int i = 0;i<carRecords.size();i++) {
			params[i][0] = carRecords.get(i).getRecordID();
		}
		int[] rows = this.updateBatch(sql, params);
		return getflagByIntArray(rows);
	}
	
	public int deleteCarRecordByCarID(String carID) throws SQLException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		//String sql = "delete from TreatmentPlan where treatmentID = ? ";
		return this.update(sql, carID);
	}
	
	public CarRecord getCarRecordByCondition(String condition, Object...params) throws IOException, SQLException {
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		
		sql += condition==null||"".equals(condition)?"":condition;
		return  (CarRecord) this.findForObject(sql, params);
	}
	
	
}
