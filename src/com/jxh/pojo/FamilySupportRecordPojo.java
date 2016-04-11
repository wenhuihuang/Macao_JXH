package com.jxh.pojo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

public class FamilySupportRecordPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private String custID;
	private String pCustID;
	private Date registerDate;
	private String registerTime;
	private int isLate;
	private String note;
	private String supportID;
	private String parentName;
	private String family;
	private int sum;
	private String amentiaName;

	public FamilySupportRecordPojo() {
		super();
	}

	public FamilySupportRecordPojo(int recordID, String custID, String pCustID, Date registerDate, String registerTime,
			int isLate, String note, String supportID, String parentName, String family, int sum, String amentiaName) {
		super();
		this.recordID = recordID;
		this.custID = custID;
		this.pCustID = pCustID;
		this.registerDate = registerDate;
		this.registerTime = registerTime;
		this.isLate = isLate;
		this.note = note;
		this.supportID = supportID;
		this.parentName = parentName;
		this.family = family;
		this.sum = sum;
		this.amentiaName = amentiaName;
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

	public void setPCustID(String pCustID) {
		this.pCustID = pCustID;
	}

	public String getPCustID() {
		return pCustID;
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

	public void setSupportID(String supportID) {
		this.supportID = supportID;
	}

	public String getSupportID() {
		return supportID;
	}

	public String getpCustID() {
		return pCustID;
	}

	public void setpCustID(String pCustID) {
		this.pCustID = pCustID;
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

	@Override
	public String toString() {
		return "FamilySupportRecord [recordID=" + recordID + ",custID=" + custID + ",pCustID=" + pCustID
				+ ",registerDate=" + registerDate + ",registerTime=" + registerTime + ",isLate=" + isLate + ",note="
				+ note + ",supportID=" + supportID + ",parentName=" + parentName + ",family=" + family + ",sum=" + sum
				+ ",amentiaName=" + amentiaName + "]";

	}
}
