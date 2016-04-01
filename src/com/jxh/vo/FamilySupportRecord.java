package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** FamilySupportRecord

recordID,custID,pCustID,acceptDate,note,supportID
?,?,?,?,?,?

familySupportRecord.recordID,familySupportRecord.custID,familySupportRecord.pCustID,familySupportRecord.acceptDatefamilySupportRecord.note,familySupportRecord.supportID

recordID=?,custID=?,pCustID=?,acceptDate=?,note=?,supportID=?
*/
public class FamilySupportRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private String custID;
	private String pCustID;
	private Date acceptDate;
	private String note;
	private String supportID;

	public FamilySupportRecord(){
		super();
	}
	public FamilySupportRecord(int recordID, String custID, String pCustID, Date acceptDate, String note, String supportID ){
		super();
		this.recordID=recordID;
		this.custID=custID;
		this.pCustID=pCustID;
		this.acceptDate=acceptDate;
		this.note=note;
		this.supportID=supportID;
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
	public void setAcceptDate(Date acceptDate){
		this.acceptDate=acceptDate;
	}
	public Date getAcceptDate(){
		return acceptDate;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public void setSupportID(String supportID){
		this.supportID=supportID;
	}
	public String getSupportID(){
		return supportID;
	}
	@Override
	public String toString(){
		return "FamilySupportRecord [recordID="+recordID+",custID="+custID+",pCustID="+pCustID+",acceptDate="+acceptDate+",note="+note+",supportID="+supportID+"]";
	}
}

