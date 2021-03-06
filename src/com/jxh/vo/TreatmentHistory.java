package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** TreatmentHistory
	HISTORYID	INT(10)
	CUSTID	VARCHAR(20)
	TREATMENTITEM	VARCHAR(32)
	TSTARTDATE	DATETIME(23,3)
	TENDDATE	DATETIME(23,3)
	CONTENT	VARCHAR(128)
	TNOTE	VARCHAR(128)
	ORG VARCHAR(32)

historyID,custID,treatmentItem,tStartDate,tEndDate,content,tNote,org
?,?,?,?,?,?,?,?



historyID=?,custID=?,treatmentItem=?,tStartDate=?,tEndDate=?,content=?,tNote=?,org=?
*/
public class TreatmentHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	private int historyID;
	private String custID;
	private String treatmentItem;
	private Date tStartDate;
	private Date tEndDate;
	private String content;
	private String tNote;
	private String org;

	public TreatmentHistory(){
		super();
	}
	public TreatmentHistory(int historyID, String custID, String treatmentItem, Date tStartDate, Date tEndDate, String content, String tNote, String org ){
		super();
		this.historyID=historyID;
		this.custID=custID;
		this.treatmentItem=treatmentItem;
		this.tStartDate=tStartDate;
		this.tEndDate=tEndDate;
		this.content=content;
		this.tNote=tNote;
		this.org=org;
	}
	public void setHistoryID(int historyID){
		this.historyID=historyID;
	}
	public int getHistoryID(){
		return historyID;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setTreatmentItem(String treatmentItem){
		this.treatmentItem=treatmentItem;
	}
	public String getTreatmentItem(){
		return treatmentItem;
	}
	public void settStartDate(Date tStartDate){
		this.tStartDate=tStartDate;
	}
	public Date gettStartDate(){
		return tStartDate;
	}
	public void settEndDate(Date tEndDate){
		this.tEndDate=tEndDate;
	}
	public Date gettEndDate(){
		return tEndDate;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void settNote(String tNote){
		this.tNote=tNote;
	}
	public String gettNote(){
		return tNote;
	}
	
	
	
	
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	@Override
	public String toString(){
		return "TreatmentHistory [historyID="+historyID+",custID="+custID+",treatmentItem="+treatmentItem+",tStartDate="+tStartDate+",tEndDate="+tEndDate+",content="+content+",tNote="+tNote+",org="+org+"]";
	}
}

