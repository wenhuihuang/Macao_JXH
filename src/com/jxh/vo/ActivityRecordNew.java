package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

/**
 * ActivityRecordNew
 * 
 * recordID,custID,pCustID,registerDate,registerTime,isLate,note,actID,
 * parentName,family,sum,amentiaName ?,?,?,?,?,?,?,?,?,?,?,?
 * 
 * 
 * recordID=?,custID=?,pCustID=?,registerDate=?,registerTime=?,isLate=?,note=?,
 * actID=?,parentName=?,family=?,sum=?,amentiaName=?
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
	private String parentName;
	private String family;
	private int sum;
	private String amentiaName;

	private String custCode;

	public ActivityRecordNew() {
		super();
	}

	public ActivityRecordNew(int recordID, String custID, String pCustID, Date registerDate, String registerTime,
			int isLate, String note, String actID, String parentName, String family, int sum, String amentiaName,
			String custCode) {
		super();
		this.recordID = recordID;
		this.custID = custID;
		this.pCustID = pCustID;
		this.registerDate = registerDate;
		this.registerTime = registerTime;
		this.isLate = isLate;
		this.note = note;
		this.actID = actID;
		this.parentName = parentName;
		this.family = family;
		this.sum = sum;
		this.amentiaName = amentiaName;
		this.custCode = custCode;
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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getAmentiaName() {
		return amentiaName;
	}

	public void setAmentiaName(String amentiaName) {
		this.amentiaName = amentiaName;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	@Override
	public String toString() {
		return "ActivityRecordNew [recordID=" + recordID + ",custID=" + custID + ",pCustID=" + pCustID
				+ ",registerDate=" + registerDate + ",registerTime=" + registerTime + ",isLate=" + isLate + ",note="
				+ note + ",actID=" + actID + ",parentName=" + parentName + ",family=" + family + ",sum=" + sum
				+ ",amentiaName=" + amentiaName + ",custCode=" + custCode + "]";
	}
}
