package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.ChargeRecordDao;
import com.jxh.utils.Constants;
import com.jxh.vo.ChargeRecord;

public class ChargeRecordBiz {

	private ChargeRecordDao chargeRecordDao = new ChargeRecordDao();

	public String updateChargeRecord(List<ChargeRecord> chargeRecordAdds,List<ChargeRecord> chargeRecordUpdates,List<ChargeRecord> chargeRecordDeletes) throws Exception {
		if(chargeRecordAdds != null && chargeRecordAdds.size() >0){
			chargeRecordDao.insertChargeRecordBatch(chargeRecordAdds);
		}
		if(chargeRecordUpdates != null && chargeRecordUpdates.size() >0){
			chargeRecordDao.updateChargeRecordBatch(chargeRecordUpdates);
		}
		if(chargeRecordDeletes != null && chargeRecordDeletes.size() >0){
			chargeRecordDao.deleteChargeRecordBatch(chargeRecordDeletes);
		}
		
		return "操作成功！";
	}


	public boolean deleteChargeRecordByChargeID(String chargeID) throws Exception {
		boolean flag=false;
		int row = chargeRecordDao.deleteChargeRecordByChargeID(chargeID);
		if(row > 0){
			flag=true;
		}
		return flag;
	}

}
