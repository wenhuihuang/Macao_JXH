package com.jxh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fg.daoImpl.DaoImpl;
import com.fg.utils.PageUtils;
import com.fg.utils.ToolsUtils;
import com.jxh.vo.ActivityRecord;
import com.jxh.vo.SpecialAllowance;

public class ActivityRecordDao extends DaoImpl<ActivityRecord>{

	@Override
	protected String getSqlPropertiesPath() {
		return "/sqls/Macao_JXH/activityrecordnew.properties";
	}
	
	/**
	 * 获取所有
	 * @param condition
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public PageUtils<ActivityRecord> getActivityRecordByCondition(PageUtils<ActivityRecord> page, String condition,Object ...params) throws SQLException, IOException{
		String sql = this.getSqlByPropKey("getActivityRecordNewByCondition");
		condition = condition==null?"":condition;
		sql += condition;
		Integer count = this.findElement(getCountSql(sql), params);
		page.setRowCount(count);
		
		
		List<ActivityRecord> ActivityRecords = this.findForList(sql, params);
		page.setList(ActivityRecords);
		
		return page;
	}

}
