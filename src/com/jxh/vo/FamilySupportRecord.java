package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

/**
 * FamilySupportRecord
 * 
 * recordID,custID,pCustID,acceptDate,note,supportID,parentName,family,sum,amentiaName ?,?,?,?,?,?,?,?,?,?
 * 
 * familySupportRecord.recordID,familySupportRecord.custID,familySupportRecord.
 * pCustID,familySupportRecord.acceptDatefamilySupportRecord.note,
 * familySupportRecord.supportID
 * 
 * recordID=?,custID=?,pCustID=?,acceptDate=?,note=?,supportID=?,parentName=?,
 * family=?,sum=?,amentiaName=?
 */
public class FamilySupportRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private String custID;
	private String pCustID;
	private Date acceptDate;
	private String note;
	private String supportID;
	private String parentName;
	private String family;
	private int sum;
	private String amentiaName;
	
	private String custCode;

	public FamilySupportRecord() {
		super();
	}

	public FamilySupportRecord(int recordID, String custID, String pCustID, Date acceptDate, String note,
			String supportID, String parentName, String family, int sum, String amentiaName,String custCode) {
		super();
		this.recordID = recordID;
		this.custID = custID;
		this.pCustID = pCustID;
		this.acceptDate = acceptDate;
		this.note = note;
		this.supportID = supportID;
		this.parentName = parentName;
		this.family = family;
		this.sum = sum;
		this.amentiaName = amentiaName;
		this.custCode=custCode;
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

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public Date getAcceptDate() {
		return acceptDate;
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
	
	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	@Override
	public String toString() {
		return "FamilySupportRecord [recordID=" + recordID + ",custID=" + custID + ",pCustID=" + pCustID
				+ ",acceptDate=" + acceptDate + ",note=" + note + ",supportID=" + supportID + ",parentName="
				+ parentName + ",family=" + family + ",sum=" + sum + ",amentiaName=" + amentiaName + ",custCode="+custCode+ "]";
	}
}
