package com.jxh.pojo;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String custId;
	private String custCode;
	private String fullName;
	private String fullNameEng;
	private String sex;
	private String custType;
	private int cardStatus;
	private Date regDate;
	private Date validDate;
	private String cardType;
	private String cardNo;
	private String telNo;
	private String mobileTelNo;
	private String relationship;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String custId, String custCode, String fullName, String fullNameEng, String sex, String custType,
			int cardStatus, Date regDate, Date validDate, String cardType, String cardNo, String telNo,
			String mobileTelNo, String relationship) {
		super();
		this.custId = custId;
		this.custCode = custCode;
		this.fullName = fullName;
		this.fullNameEng = fullNameEng;
		this.sex = sex;
		this.custType = custType;
		this.cardStatus = cardStatus;
		this.regDate = regDate;
		this.validDate = validDate;
		this.cardType = cardType;
		this.cardNo = cardNo;
		this.telNo = telNo;
		this.mobileTelNo = mobileTelNo;
		this.relationship = relationship;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
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

	public String getFullNameEng() {
		return fullNameEng;
	}

	public void setFullNameEng(String fullNameEng) {
		this.fullNameEng = fullNameEng;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public int getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(int cardStatus) {
		this.cardStatus = cardStatus;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getMobileTelNo() {
		return mobileTelNo;
	}

	public void setMobileTelNo(String mobileTelNo) {
		this.mobileTelNo = mobileTelNo;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custCode=" + custCode + ", fullName=" + fullName + ", fullNameEng="
				+ fullNameEng + ", sex=" + sex + ", custType=" + custType + ", cardStatus=" + cardStatus + ", regDate="
				+ regDate + ", validDate=" + validDate + ", cardType=" + cardType + ", cardNo=" + cardNo + ", telNo="
				+ telNo + ", mobileTelNo=" + mobileTelNo + ", relationship=" + relationship + "]";
	}

}
