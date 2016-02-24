package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.Treatment;
import com.jxh.vo.TreatmentAssess;

public class TreatmentAssessDao extends DaoImpl {
	
	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/treatmentassess.properties";
	}
	
	public int insertTreatmentAssess(TreatmentAssess treatmentAssess ) throws SQLException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getInsertParams(sql, treatmentAssess);
		return this.update(sql, params);
	}
	
	public int updateTreatmentAssess(TreatmentAssess treatmentAssess) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException{
		String sql = this.getSqlByPropKey(ToolsUtils.getCurrentMethodName());
		Object[] params = getUpdateParams(sql, treatmentAssess);
		
		return this.update(sql, params);
	}

	public int deleteTreatmentAssessByTreatmentID(String treatmentID) throws SQLException{
		String sql = "delete from Treatment where treatmentID = ? ";
		return this.update(sql, treatmentID);
	}
	
}
