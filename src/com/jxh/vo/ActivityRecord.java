package com.jxh.vo;

import java.io.Serializable;

public class ActivityRecord implements Serializable {

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

	public ActivityRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActivityRecord(String recordId, String actId, int recordType, int isLate, String duty, String note) {
		super();
		this.recordId = recordId;
		this.actId = actId;
		this.recordType = recordType;
		this.isLate = isLate;
		this.duty = duty;
		this.note = note;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ActivityRecord [recordId=" + recordId + ", actId=" + actId + ", recordType=" + recordType + ", isLate="
				+ isLate + ", duty=" + duty + ", note=" + note + "]";
	}
	
}
