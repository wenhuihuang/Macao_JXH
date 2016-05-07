package com.jxh.pojo;

import java.sql.Timestamp;

/**
 * BcustEditLogs entity. @author MyEclipse Persistence Tools
 */

public class BcustEditLogsMasterPojo implements java.io.Serializable {

	// Fields

	private String custId;
	private String status;
	private String billDate;
	private String isRead;
	private String custCode;
	private String fullName;
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
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
	public BcustEditLogsMasterPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BcustEditLogsMasterPojo(String custId, String status, String billDate,
			String isRead, String custCode, String fullName) {
		super();
		this.custId = custId;
		this.status = status;
		this.billDate = billDate;
		this.isRead = isRead;
		this.custCode = custCode;
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "BcustEditLogsMasterVO [custId=" + custId + ", status=" + status
				+ ", billDate=" + billDate + ", isRead=" + isRead
				+ ", custCode=" + custCode + ", fullName=" + fullName + "]";
	}
	
	
	

	
}