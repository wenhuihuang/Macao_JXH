package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;

public class SpecialAllowance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String specialAllowanceID;
	private String specialAllowanceNO;
	private String specialAllowanceCustID;
	private String userName;
	private Date billDate;
	private String note;
	

	public SpecialAllowance() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public SpecialAllowance(String specialAllowanceID, String specialAllowanceNO, String specialAllowanceCustID,
			String userName, Date billDate, String note) {
		super();
		this.specialAllowanceID = specialAllowanceID;
		this.specialAllowanceNO = specialAllowanceNO;
		this.specialAllowanceCustID = specialAllowanceCustID;
		this.userName = userName;
		this.billDate = billDate;
		this.note = note;
	}


	public String getSpecialAllowanceID() {
		return specialAllowanceID;
	}

	public void setSpecialAllowanceID(String specialAllowanceID) {
		this.specialAllowanceID = specialAllowanceID;
	}

	public String getSpecialAllowanceNO() {
		return specialAllowanceNO;
	}

	public void setSpecialAllowanceNO(String specialAllowanceNO) {
		this.specialAllowanceNO = specialAllowanceNO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
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


	public String getSpecialAllowanceCustID() {
		return specialAllowanceCustID;
	}


	public void setSpecialAllowanceCustID(String specialAllowanceCustID) {
		this.specialAllowanceCustID = specialAllowanceCustID;
	}


	@Override
	public String toString() {
		return "SpecialAllowance [specialAllowanceID=" + specialAllowanceID + ", specialAllowanceNO="
				+ specialAllowanceNO + ", specialAllowanceCustID=" + specialAllowanceCustID + ", userName=" + userName
				+ ", billDate=" + billDate + ", note=" + note + "]";
	}



}
