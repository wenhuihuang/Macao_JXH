package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.CarAbsentDao;
import com.jxh.dao.CarAbsentDao;
import com.jxh.utils.Constants;
import com.jxh.vo.CarAbsent;

public class CarAbsentBiz {
	private CarAbsentDao carAbsentDao = new CarAbsentDao();

	private int deleteCarAbsent(List<CarAbsent> carAbsentDeletes) throws IOException, SQLException {
		if (carAbsentDeletes == null || carAbsentDeletes.size() <= 0) {
			return 1;
		}
		return carAbsentDao.deleteCarAbsent(carAbsentDeletes);
	}

	private int updateCarAbsent(List<CarAbsent> carAbsentUpdates) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (carAbsentUpdates == null || carAbsentUpdates.size() <= 0) {
			return 1;
		}
		return carAbsentDao.updateCarAbsent(carAbsentUpdates);
	}

	private int addCarAbsent(List<CarAbsent> carAbsentAdds) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (carAbsentAdds == null || carAbsentAdds.size() <= 0) {
			return 1;
		}

		int[] rows = carAbsentDao.insertCarAbsentBatch(carAbsentAdds);

		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	private int deleteCarAbsentByCarID(String carID) throws SQLException, IOException {
		return carAbsentDao.deleteCarAbsentByCarID(carID);
	}

	public String updateCarAbsents(List<CarAbsent> carAbsentAdds, List<CarAbsent> carAbsentUpdates,
			List<CarAbsent> carAbsentDeletes) throws Exception {
			//
			if (addCarAbsent(carAbsentAdds) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (updateCarAbsent(carAbsentUpdates) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			if (deleteCarAbsent(carAbsentDeletes) < 0) {
				throw new Exception("新增個案撮要失败！");
			}

			
		return "操作成功！";
	}

}
