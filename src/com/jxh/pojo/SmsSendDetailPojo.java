package com.jxh.pojo;

public class SmsSendDetailPojo {
	private String custID;
	private String custCode;
	private String fullName;
	private String mobileTelNO;
	public SmsSendDetailPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SmsSendDetailPojo(String custID, String custCode, String fullName,
			String mobileTelNo) {
		super();
		this.custID = custID;
		this.custCode = custCode;
		this.fullName = fullName;
		this.mobileTelNO = mobileTelNO;
	}
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobileTelNO() {
		return mobileTelNO;
	}
	public void setMobileTelNO(String mobileTelNO) {
		this.mobileTelNO = mobileTelNO;
	}
	@Override
	public String toString() {
		return "SmsSendDetailVO [custID=" + custID + ", custCode=" + custCode
				+ ", fullName=" + fullName + ", mobileTelNO=" + mobileTelNO
				+ "]";
	}
	
}
