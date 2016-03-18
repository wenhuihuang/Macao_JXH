package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** ActivityRecordNew
	RECORDID	INT(10)
	CUSTID	VARCHAR(20)
	PCUSTID	VARCHAR(20)
	REGISTERDATE	DATETIME(23,3)
	REGISTERTIME	VARCHAR(32)
	ISLATE	INT(10)
	NOTE	VARCHAR(128)

recordID,custID,pCustID,registerDate,registerTime,isLate,note
?,?,?,?,?,?,?

activityRecordNew.recordID,activityRecordNew.custID,activityRecordNew.pCustID,activityRecordNew.registerDate,activityRecordNew.registerTime,activityRecordNew.isLate,activityRecordNew.note

recordID=?,custID=?,pCustID=?,registerDate=?,registerTime=?,isLate=?,note=?
*/
public class ActivityRecordNew implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private String custID;
	private String pCustID;
	private Date registerDate;
	private String registerTime;
	private int isLate;
	private String note;

	public ActivityRecordNew(){
		super();
	}
	public ActivityRecordNew(int recordID, String custID, String pCustID, Date registerDate, String registerTime, int isLate, String note ){
		super();
		this.recordID=recordID;
		this.custID=custID;
		this.pCustID=pCustID;
		this.registerDate=registerDate;
		this.registerTime=registerTime;
		this.isLate=isLate;
		this.note=note;
	}
	public void setRecordID(int recordID){
		this.recordID=recordID;
	}
	public int getRecordID(){
		return recordID;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setPCustID(String pCustID){
		this.pCustID=pCustID;
	}
	public String getPCustID(){
		return pCustID;
	}
	public void setRegisterDate(Date registerDate){
		this.registerDate=registerDate;
	}
	public Date getRegisterDate(){
		return registerDate;
	}
	public void setRegisterTime(String registerTime){
		this.registerTime=registerTime;
	}
	public String getRegisterTime(){
		return registerTime;
	}
	public void setIsLate(int isLate){
		this.isLate=isLate;
	}
	public int getIsLate(){
		return isLate;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "ActivityRecordNew [recordID="+recordID+",custID="+custID+",pCustID="+pCustID+",registerDate="+registerDate+",registerTime="+registerTime+",isLate="+isLate+",note="+note+"]";
	}
}

