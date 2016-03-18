package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

/**
 * ActivityRecordNew
 * 
 * recordID,custID,pCustID,registerDate,registerTime,isLate,note,actID
 * ?,?,?,?,?,?,?,?
 * 
 * activityRecordNew.recordID,activityRecordNew.custID,activityRecordNew.pCustID
 * ,activityRecordNew.registerDate,activityRecordNew.registerTime,
 * activityRecordNew.isLate,activityRecordNew.note,activityRecordNew.actID
 * 
 * recordID=?,custID=?,pCustID=?,registerDate=?,registerTime=?,isLate=?,note=?,
 * actID=?
 */
public class ActivityRecordNew implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private String custID;
	private String pCustID;
	private Date registerDate;
	private String registerTime;
	private int isLate;
	private String note;
	private String actID;

	public ActivityRecordNew() {
		super();
	}

	public ActivityRecordNew(int recordID, String custID, String pCustID, Date registerDate, String registerTime,
			int isLate, String note, String actID) {
		super();
		this.recordID = recordID;
		this.custID = custID;
		this.pCustID = pCustID;
		this.registerDate = registerDate;
		this.registerTime = registerTime;
		this.isLate = isLate;
		this.note = note;
		this.actID = actID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public int getRecordID() {
		return recordID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getCustID() {
		return custID;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setIsLate(int isLate) {
		this.isLate = isLate;
	}

	public int getIsLate() {
		return isLate;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public String getpCustID() {
		return pCustID;
	}

	public void setpCustID(String pCustID) {
		this.pCustID = pCustID;
	}

	public String getActID() {
		return actID;
	}

	public void setActID(String actID) {
		this.actID = actID;
	}

	@Override
	public String toString() {
		return "ActivityRecordNew [recordID=" + recordID + ",custID=" + custID + ",pCustID=" + pCustID
				+ ",registerDate=" + registerDate + ",registerTime=" + registerTime + ",isLate=" + isLate + ",note="
				+ note + ",actID=" + actID + "]";
	}
}
