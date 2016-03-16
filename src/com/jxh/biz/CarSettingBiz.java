package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.CarAbsentDao;
import com.jxh.dao.CarRecordDao;
import com.jxh.dao.CarSettingDao;
import com.jxh.utils.Constants;
import com.jxh.vo.CarAbsent;
import com.jxh.vo.CarRecord;
import com.jxh.vo.CarSetting;

public class CarSettingBiz {
	private CarSettingDao carSettingDao = new CarSettingDao();
	private CarRecordDao carRecordDao = new CarRecordDao();
	private CarAbsentDao carAbsentDao = new CarAbsentDao();
	

	private int deleteCarAbsent(CarSetting carSetting,
			List<CarAbsent> carAbsentDeletes) throws IOException, SQLException {
		if (carAbsentDeletes == null || carAbsentDeletes.size() <= 0) {
			return 1;
		}
		return carAbsentDao.deleteCarAbsent(carAbsentDeletes);
	}




	private int updateCarAbsent(CarSetting carSetting,
			List<CarAbsent> carAbsentUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (carAbsentUpdates == null || carAbsentUpdates.size() <= 0) {
			return 1;
		}
		return carAbsentDao.updateCarAbsent(carAbsentUpdates);
	}








	private int addCarAbsent(CarSetting carSetting,
			List<CarAbsent> carAbsentAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (carAbsentAdds == null || carAbsentAdds.size() <= 0) {
			return 1;
		}
		
		for (CarAbsent update : carAbsentAdds) {
			
			update.setCarID(carSetting.getCarID());
		}
		
		int [] rows = carAbsentDao.insertCarAbsentBatch(carAbsentAdds);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}
	
	private int deleteCarRecord(CarSetting carSetting,
			List<CarRecord> carRecordDeletes) throws IOException, SQLException {
		if (carRecordDeletes == null || carRecordDeletes.size() <= 0) {
			return 1;
		}
		return carRecordDao.deleteCarRecord(carRecordDeletes);
	}




	private int updateCarRecord(CarSetting carSetting,
			List<CarRecord> carRecordUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if (carRecordUpdates == null || carRecordUpdates.size() <= 0) {
			return 1;
		}
		return carRecordDao.updateCarRecord(carRecordUpdates);
	}








	private int addCarRecord(CarSetting carSetting,
			List<CarRecord> carRecordAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (carRecordAdds == null || carRecordAdds.size() <= 0) {
			return 1;
		}
		
		for (CarRecord update : carRecordAdds) {
			
			update.setCarID(carSetting.getCarID());
		}
		
		int [] rows = carRecordDao.insertCarRecordBatch(carRecordAdds);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}



	public boolean deleteCarSettingByCarID(String carID) throws Exception {
		boolean flag=false;
		int row = carSettingDao.deleteCarSettingByCarID(carID);
			if (row > 0) {
				if (deleteCarRecordByCarID(carID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				
				if (deleteCarAbsentByCarID(carID) < 0) {
					throw new Exception("個案轉介評估刪除失敗！");
				}
				
				flag=true;
				
			}
		return flag;
	}


	private int deleteCarRecordByCarID(String carID) throws SQLException, IOException {
		return carRecordDao.deleteCarRecordByCarID(carID);
	}
	private int deleteCarAbsentByCarID(String carID) throws SQLException, IOException {
		return carAbsentDao.deleteCarAbsentByCarID(carID);
	}




	public String updateCarSetting(CarSetting carSetting, List<CarRecord> carRecordAdds,
			List<CarRecord> carRecordUpdates, List<CarRecord> carRecordDeletes, List<CarAbsent> carAbsentAdds,
			List<CarAbsent> carAbsentUpdates, List<CarAbsent> carAbsentDeletes) throws Exception {
		int row = carSettingDao.updateCarSetting(carSetting);
		if (row > 0) {
			//
			if(addCarRecord(carSetting, carRecordAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(updateCarRecord(carSetting, carRecordUpdates)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			if(deleteCarRecord(carSetting, carRecordDeletes)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			//
			if (addCarAbsent(carSetting, carAbsentAdds) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			
			if (updateCarAbsent(carSetting, carAbsentUpdates) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
			if (deleteCarAbsent(carSetting, carAbsentDeletes) < 0) {
				throw new Exception("個案轉介評估保存失敗！");
			}
		}
		return "操作成功！";
	}




	public String insertCarSetting(CarSetting carSetting, List<CarRecord> carRecordAdds,
			List<CarAbsent> carAbsentAdds) throws Exception {
		String carID = carSettingDao.getPrimaryKey(Constants.CORPID);
		carSetting.setCarID(carID);
		int row = carSettingDao.insertCarSetting(carSetting);
		if (row > 0) {
			
			if(addCarRecord(carSetting, carRecordAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			if(addCarAbsent(carSetting, carAbsentAdds)<0){
				throw new Exception("新增個案撮要失败！");
			}
			
			
		}
		return "操作成功！";

	}



}
