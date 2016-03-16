package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

/**
 * CarAbsent
 * 
 * absentID,carID,custID,billDate,upSite,dowSite,reason,note,time
 * ?,?,?,?,?,?,?,?,?
 * 
 * carAbsent.absentID,carAbsent.carID,carAbsent.custID,carAbsent.billDate,carAbsent.upSite,carAbsent.dowSite,carAbsent.reason,carAbsent.note,carAbsent.time
 * 
 * absentID=?,carID=?,custID=?,billDate=?,upSite=?,dowSite=?,reason=?,note=?,
 * time=?
 */
public class CarAbsent implements Serializable {
	private static final long serialVersionUID = 1L;
	private int absentID;
	private String carID;
	private String custID;
	private Date billDate;
	private String upSite;
	private String dowSite;
	private String reason;
	private String note;
	private String time;

	public CarAbsent() {
		super();
	}

	public CarAbsent(int absentID, String carID, String custID, Date billDate, String upSite, String dowSite,
			String reason, String note, String time) {
		super();
		this.absentID = absentID;
		this.carID = carID;
		this.custID = custID;
		this.billDate = billDate;
		this.upSite = upSite;
		this.dowSite = dowSite;
		this.reason = reason;
		this.note = note;
		this.time=time;
	}

	public void setAbsentID(int absentID) {
		this.absentID = absentID;
	}

	public int getAbsentID() {
		return absentID;
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

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setUpSite(String upSite) {
		this.upSite = upSite;
	}

	public String getUpSite() {
		return upSite;
	}

	public void setDowSite(String dowSite) {
		this.dowSite = dowSite;
	}

	public String getDowSite() {
		return dowSite;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "CarAbsent [absentID=" + absentID + ",carID=" + carID + ",custID=" + custID + ",billDate=" + billDate
				+ ",upSite=" + upSite + ",dowSite=" + dowSite + ",reason=" + reason + ",note=" + note + 
				",time="+time+"]";
	}

}
