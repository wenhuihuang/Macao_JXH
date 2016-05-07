package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** bCustEditLogs
	LOGID	VARCHAR(20)
	CUSTID	VARCHAR(20)
	STATUS	CHAR(1)
	BILLDATE	DATETIME(23,3)
	ISREAD	CHAR(1)
	CUSTCODE	VARCHAR(32)
	FULLNAME	VARCHAR(64)
	UPDATEFIELD	VARCHAR(100)
	BEFOREFIELD	VARCHAR(500)
	AFTERFIELD	VARCHAR(500)
	UPDATEFIELDCHS	VARCHAR(100)

logID,custID,status,billDate,isRead,custCode,fullName,updateField,beforeField,afterField,updateFieldCHS
?,?,?,?,?,?,?,?,?,?,?

bCustEditLogs.logID,bCustEditLogs.custID,bCustEditLogs.status,bCustEditLogs.billDate,bCustEditLogs.isRead,bCustEditLogs.custCode,bCustEditLogs.fullName,bCustEditLogs.updateField,bCustEditLogs.beforeField,bCustEditLogs.afterField,bCustEditLogs.updateFieldCHS

logID=?,custID=?,status=?,billDate=?,isRead=?,custCode=?,fullName=?,updateField=?,beforeField=?,afterField=?,updateFieldCHS=?
*/
public class BCustEditLogs implements Serializable {
	private static final long serialVersionUID = 1L;
	private String logID;
	private String custID;
	private String status;
	private Date billDate;
	private String isRead;
	private String custCode;
	private String fullName;
	private String updateField;
	private String beforeField;
	private String afterField;
	private String updateFieldCHS;

	public BCustEditLogs(){
		super();
	}
	public BCustEditLogs(String logID, String custID, String status, Date billDate, String isRead, String custCode, String fullName, String updateField, String beforeField, String afterField, String updateFieldCHS ){
		super();
		this.logID=logID;
		this.custID=custID;
		this.status=status;
		this.billDate=billDate;
		this.isRead=isRead;
		this.custCode=custCode;
		this.fullName=fullName;
		this.updateField=updateField;
		this.beforeField=beforeField;
		this.afterField=afterField;
		this.updateFieldCHS=updateFieldCHS;
	}
	public void setLogID(String logID){
		this.logID=logID;
	}
	public String getLogID(){
		return logID;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public void setBillDate(Date billDate){
		this.billDate=billDate;
	}
	public Date getBillDate(){
		return billDate;
	}
	public void setIsRead(String isRead){
		this.isRead=isRead;
	}
	public String getIsRead(){
		return isRead;
	}
	public void setCustCode(String custCode){
		this.custCode=custCode;
	}
	public String getCustCode(){
		return custCode;
	}
	public void setFullName(String fullName){
		this.fullName=fullName;
	}
	public String getFullName(){
		return fullName;
	}
	public void setUpdateField(String updateField){
		this.updateField=updateField;
	}
	public String getUpdateField(){
		return updateField;
	}
	public void setBeforeField(String beforeField){
		this.beforeField=beforeField;
	}
	public String getBeforeField(){
		return beforeField;
	}
	public void setAfterField(String afterField){
		this.afterField=afterField;
	}
	public String getAfterField(){
		return afterField;
	}
	public void setUpdateFieldCHS(String updateFieldCHS){
		this.updateFieldCHS=updateFieldCHS;
	}
	public String getUpdateFieldCHS(){
		return updateFieldCHS;
	}
	@Override
	public String toString(){
		return "BCustEditLogs [logID="+logID+",custID="+custID+",status="+status+",billDate="+billDate+",isRead="+isRead+",custCode="+custCode+",fullName="+fullName+",updateField="+updateField+",beforeField="+beforeField+",afterField="+afterField+",updateFieldCHS="+updateFieldCHS+"]";
	}
}

