package com.jxh.pojo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** FamilySupportRecord
	RECORDID	INT(10)
	CUSTID	VARCHAR(20)
	PCUSTID	VARCHAR(20)
	REGISTERDATE	DATETIME(23,3)
	REGISTERTIME	VARCHAR(32)
	ISLATE	INT(10)
	NOTE	VARCHAR(128)
	ACTID	VARCHAR(20)

recordID,custID,pCustID,registerDate,registerTime,isLate,note,actID
?,?,?,?,?,?,?,?

familySupportRecord.recordID,familySupportRecord.custID,familySupportRecord.pCustID,familySupportRecord.registerDate,familySupportRecord.registerTime,familySupportRecord.isLate,familySupportRecord.note,familySupportRecord.actID

recordID=?,custID=?,pCustID=?,registerDate=?,registerTime=?,isLate=?,note=?,actID=?
*/
public class FamilySupportRecordPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private String custID;
	private String pCustID;
	private Date registerDate;
	private String registerTime;
	private int isLate;
	private String note;
	private String actID;

	public FamilySupportRecordPojo(){
		super();
	}
	public FamilySupportRecordPojo(int recordID, String custID, String pCustID, Date registerDate, String registerTime, int isLate, String note, String actID ){
		super();
		this.recordID=recordID;
		this.custID=custID;
		this.pCustID=pCustID;
		this.registerDate=registerDate;
		this.registerTime=registerTime;
		this.isLate=isLate;
		this.note=note;
		this.actID=actID;
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
	public void setActID(String actID){
		this.actID=actID;
	}
	public String getActID(){
		return actID;
	}
	@Override
	public String toString(){
		return "FamilySupportRecord [recordID="+recordID+",custID="+custID+",pCustID="+pCustID+",registerDate="+registerDate+",registerTime="+registerTime+",isLate="+isLate+",note="+note+",actID="+actID+"]";
	}
}

