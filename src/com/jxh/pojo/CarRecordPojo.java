package com.jxh.pojo;

import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;

public class CarRecordPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private String carID;
	private String custID;
	private Date beginDate;
	private Date endDate;
	private Date takeDate;
	private BigDecimal toll;
	private BigDecimal actToll;
	private String note;

	private String carNumber;
	private String carNO;
	
	private String fullName;

	public CarRecordPojo() {
		super();
	}

	public CarRecordPojo(int recordID, String carID, String custID, Date beginDate, Date endDate, Date takeDate,
			BigDecimal toll, BigDecimal actToll, String note,String carNumber,String carNO,String fullName) {
		super();
		this.recordID = recordID;
		this.carID = carID;
		this.custID = custID;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.takeDate = takeDate;
		this.toll = toll;
		this.actToll = actToll;
		this.note = note;
		this.carNO=carNO;
		this.carNumber=carNumber;
		this.fullName=fullName;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public int getRecordID() {
		return recordID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getCarID() {
		return carID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getCustID() {
		return custID;
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

	public void setTakeDate(Date takeDate) {
		this.takeDate = takeDate;
	}

	public Date getTakeDate() {
		return takeDate;
	}

	public void setToll(BigDecimal toll) {
		this.toll = toll;
	}

	public BigDecimal getToll() {
		return toll;
	}

	public void setActToll(BigDecimal actToll) {
		this.actToll = actToll;
	}

	public BigDecimal getActToll() {
		return actToll;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarNO() {
		return carNO;
	}

	public void setCarNO(String carNO) {
		this.carNO = carNO;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "CarRecord [recordID=" + recordID + ",carID=" + carID + ",custID=" + custID + ",beginDate=" + beginDate
				+ ",endDate=" + endDate + ",takeDate=" + takeDate + ",toll=" + toll + ",actToll=" + actToll + ",note="
				+ note + ",carNO="+carNO+",carNumber="+carNumber+ ",fullName="+fullName+"]";
	}
}
