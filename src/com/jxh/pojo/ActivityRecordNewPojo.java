package com.jxh.pojo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

public class ActivityRecordNewPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private String custID;
	private String pCustID;
	private Date registerDate;
	private String registerTime;
	private int isLate;
	private String note;
	private String actID;

	private String actNO;
	private String actName;
	private Date actBDate;
	private Date actEDate;
	private String actBDate_str;
	private String actEDate_str;

	public ActivityRecordNewPojo() {
		super();
	}

	public ActivityRecordNewPojo(int recordID, String custID, String pCustID, Date registerDate, String registerTime,
			int isLate, String note, String actID, String actNO, String actName, Date actBDate, Date actEDate,
			String actBDate_str, String actEDate_str) {
		super();
		this.recordID = recordID;
		this.custID = custID;
		this.pCustID = pCustID;
		this.registerDate = registerDate;
		this.registerTime = registerTime;
		this.isLate = isLate;
		this.note = note;
		this.actID = actID;

		this.actNO = actNO;
		this.actBDate = actBDate;
		this.actEDate = actEDate;
		this.actBDate_str = actBDate_str;
		this.actEDate_str = actEDate_str;

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
	
	public String getActNO() {
		return actNO;
	}

	public void setActNO(String actNO) {
		this.actNO = actNO;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public Date getActBDate() {
		return actBDate;
	}

	public void setActBDate(Date actBDate) {
		this.actBDate = actBDate;
	}

	public Date getActEDate() {
		return actEDate;
	}

	public void setActEDate(Date actEDate) {
		this.actEDate = actEDate;
	}

	public String getActBDate_str() {
		return actBDate_str;
	}

	public void setActBDate_str(String actBDate_str) {
		this.actBDate_str = actBDate_str;
	}

	public String getActEDate_str() {
		return actEDate_str;
	}

	public void setActEDate_str(String actEDate_str) {
		this.actEDate_str = actEDate_str;
	}

	@Override
	public String toString() {
		return "ActivityRecordNew [recordID=" + recordID + ",custID=" + custID + ",pCustID=" + pCustID
				+ ",registerDate=" + registerDate + ",registerTime=" + registerTime + ",isLate=" + isLate + ",note="
				+ note + ",actID=" + actID + ",actNO=" + actNO + ",actName=" + actName + ",actBDate=" + actBDate
				+ ",actEDate=" + actEDate + ",actBDate_str" + actBDate_str + ",actEDate_str=" + actEDate_str + "]";
	}
}
