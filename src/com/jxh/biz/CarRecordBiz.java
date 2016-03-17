package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.CarRecordDao;
import com.jxh.utils.Constants;
import com.jxh.vo.CarAbsent;
import com.jxh.vo.CarRecord;
import com.jxh.vo.CarSetting;

public class CarRecordBiz {
	private CarRecordDao carRecordDao = new CarRecordDao();

	private int deleteCarRecord(List<CarRecord> carRecordDeletes) throws IOException, SQLException {
		if (carRecordDeletes == null || carRecordDeletes.size() <= 0) {
			return 1;
		}
		return carRecordDao.deleteCarRecord(carRecordDeletes);
	}

	private int updateCarRecord(List<CarRecord> carRecordUpdates) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (carRecordUpdates == null || carRecordUpdates.size() <= 0) {
			return 1;
		}
		return carRecordDao.updateCarRecord(carRecordUpdates);
	}

	private int addCarRecord(List<CarRecord> carRecordAdds) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (carRecordAdds == null || carRecordAdds.size() <= 0) {
			return 1;
		}

		int[] rows = carRecordDao.insertCarRecordBatch(carRecordAdds);

		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int deleteCarRecordByCarID(String carID) throws SQLException, IOException {
		return carRecordDao.deleteCarRecordByCarID(carID);
	}

	public String updateCarRecords(List<CarRecord> carRecordAdds, List<CarRecord> carRecordUpdates,
			List<CarRecord> carRecordDeletes) throws Exception {
			//
			if (addCarRecord(carRecordAdds) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (updateCarRecord(carRecordUpdates) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (deleteCarRecord(carRecordDeletes) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			
		return "操作成功！";
	}

}
