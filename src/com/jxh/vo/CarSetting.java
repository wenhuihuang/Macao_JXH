package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.sql.*;
import java.text.ParseException;
import java.math.*;

/**
 * CarSetting
 * 
 * carID,carNO,carNumber,worker,assistant,beginDate,endDate,site,note ?,?,?,?,?,?,?,?,?
 * 
 * carSetting.carID,carSetting.carNO,carSetting.carNumber,carSetting.worker,
 * carSetting.assistant,carSetting.beginDate,carSetting.endDate,carSetting.site,carSetting.note
 * 
 * carID=?,carNO=?,carNumber=?,worker=?,assistant=?,beginDate=?,endDate=?,site=?,note=?
 */
public class CarSetting implements Serializable {
	private static final long serialVersionUID = 1L;
	private String carID;
	private String carNO;
	private String carNumber;
	private String worker;
	private String assistant;
	private Date beginDate;
	private Date endDate;
	private String site;
	private String note;

	private String beginDate_str;
	private String endDate_str;

	public CarSetting() {
		super();
	}

	public CarSetting(String carID, String carNO, String carNumber, String worker, String assistant, Date beginDate,
			Date endDate, String site, String beginDate_str,String endDate_str,String note) {
		super();
		this.carID = carID;
		this.carNO = carNO;
		this.carNumber = carNumber;
		this.worker = worker;
		this.assistant = assistant;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.site = site;
		this.beginDate_str=beginDate_str;
		this.endDate_str=endDate_str;
		this.note=note;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarNO(String carNO) {
		this.carNO = carNO;
	}

	public String getCarNO() {
		return carNO;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

	public String getWorker() {
		return worker;
	}

	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}

	public String getAssistant() {
		return assistant;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getSite() {
		return site;
	}

	public String getBeginDate_str() {
		try {
			return beginDate == null || "".equals(beginDate) ? ""
					: ToolsUtils.getDateStringByFormat(beginDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setBeginDate_str(String beginDate_str) {
		this.beginDate_str = beginDate_str;
	}

	public String getEndDate_str() {
		try {
			return endDate == null || "".equals(endDate) ? ""
					: ToolsUtils.getDateStringByFormat(endDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setEndDate_str(String endDate_str) {
		this.endDate_str = endDate_str;
	}

	@Override
	public String toString() {
		return "CarSetting [carID=" + carID + ",carNO=" + carNO + ",carNumber=" + carNumber + ",worker=" + worker
				+ ",assistant=" + assistant + ",beginDate=" + beginDate + ",endDate=" + endDate + ",site=" + site + 
				",beginDate_str="+beginDate_str+",endDate_str="+endDate_str+",note="+note+"]";
	}
}
