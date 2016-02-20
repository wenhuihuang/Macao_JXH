package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;


public class CSSA implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CSSAID;
	private String CSSANO;
	private String CSSACustID;
	private String userName;
	private Date billDate;
	private String note;

	public CSSA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CSSA(String cSSAID, String cSSANO, String cSSACustID, String userName, Date billDate, String note) {
		super();
		CSSAID = cSSAID;
		CSSANO = cSSANO;
		CSSACustID = cSSACustID;
		this.userName = userName;
		this.billDate = billDate;
		this.note = note;
	}

	public String getCSSAID() {
		return CSSAID;
	}

	public void setCSSAID(String cSSAID) {
		CSSAID = cSSAID;
	}

	public String getCSSANO() {
		return CSSANO;
	}

	public void setCSSANO(String cSSANO) {
		CSSANO = cSSANO;
	}

	public String getCSSACustID() {
		return CSSACustID;
	}

	public void setCSSACustID(String cSSACustID) {
		CSSACustID = cSSACustID;
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

	@Override
	public String toString() {
		return "CSSA [CSSAID=" + CSSAID + ", CSSANO=" + CSSANO + ", CSSACustID=" + CSSACustID + ", userName=" + userName
				+ ", billDate=" + billDate + ", note=" + note + "]";
	}

}
