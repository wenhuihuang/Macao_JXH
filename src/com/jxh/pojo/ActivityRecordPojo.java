package com.jxh.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class ActivityRecordPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String actId;
	private int recordType;
	private int isLate;
	private String duty;
	private String note;
	private String actCode;
	private String actName;
	private Timestamp actBeginDate;
	private int SignInQty;
	public ActivityRecordPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActivityRecordPojo(String recordId, String actId, int recordType, int isLate, String duty, String note,
			String actCode, String actName, Timestamp actBeginDate, int signInQty) {
		super();
		this.recordId = recordId;
		this.actId = actId;
		this.recordType = recordType;
		this.isLate = isLate;
		this.duty = duty;
		this.note = note;
		this.actCode = actCode;
		this.actName = actName;
		this.actBeginDate = actBeginDate;
		SignInQty = signInQty;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public int getRecordType() {
		return recordType;
	}
	public void setRecordType(int recordType) {
		this.recordType = recordType;
	}
	public int getIsLate() {
		return isLate;
	}
	public void setIsLate(int isLate) {
		this.isLate = isLate;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getActCode() {
		return actCode;
	}
	public void setActCode(String actCode) {
		this.actCode = actCode;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public Timestamp getActBeginDate() {
		return actBeginDate;
	}
	public void setActBeginDate(Timestamp actBeginDate) {
		this.actBeginDate = actBeginDate;
	}
	public int getSignInQty() {
		return SignInQty;
	}
	public void setSignInQty(int signInQty) {
		SignInQty = signInQty;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ActivityRecordPojo [recordId=" + recordId + ", actId=" + actId + ", recordType=" + recordType
				+ ", isLate=" + isLate + ", duty=" + duty + ", note=" + note + ", actCode=" + actCode + ", actName="
				+ actName + ", actBeginDate=" + actBeginDate + ", SignInQty=" + SignInQty + "]";
	}
	
	

}
