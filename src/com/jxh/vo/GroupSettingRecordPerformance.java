package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** GroupSettingRecordPerformance

performanceID,recordID,custID,billDate,actNO,actName,performance,reason,note,time
?,?,?,?,?,?,?,?,?,?

groupSettingRecordPerformance.performanceID,groupSettingRecordPerformance.recordID,groupSettingRecordPerformance.custID,groupSettingRecordPerformance.billDate,groupSettingRecordPerformance.actNO,groupSettingRecordPerformance.actName,groupSettingRecordPerformance.performance,groupSettingRecordPerformance.reason,groupSettingRecordPerformance.note,groupSettingRecordPerformance.time

performanceID=?,recordID=?,custID=?,billDate=?,actNO=?,actName=?,performance=?,reason=?,note=?,time=?
*/
public class GroupSettingRecordPerformance implements Serializable {
	private static final long serialVersionUID = 1L;
	private int performanceID;
	private int recordID;
	private String custID;
	private Date billDate;
	private String actNO;
	private String actName;
	private String performance;
	private String reason;
	private String note;
	private String time;

	public GroupSettingRecordPerformance(){
		super();
	}
	public GroupSettingRecordPerformance(int performanceID, int recordID, String custID, Date billDate, String actNO, String actName, String performance, String reason, String note, String time ){
		super();
		this.performanceID=performanceID;
		this.recordID=recordID;
		this.custID=custID;
		this.billDate=billDate;
		this.actNO=actNO;
		this.actName=actName;
		this.performance=performance;
		this.reason=reason;
		this.note=note;
		this.time=time;
	}
	public void setPerformanceID(int performanceID){
		this.performanceID=performanceID;
	}
	public int getPerformanceID(){
		return performanceID;
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
	public void setBillDate(Date billDate){
		this.billDate=billDate;
	}
	public Date getBillDate(){
		return billDate;
	}
	public void setActNO(String actNO){
		this.actNO=actNO;
	}
	public String getActNO(){
		return actNO;
	}
	public void setActName(String actName){
		this.actName=actName;
	}
	public String getActName(){
		return actName;
	}
	public void setPerformance(String performance){
		this.performance=performance;
	}
	public String getPerformance(){
		return performance;
	}
	public void setReason(String reason){
		this.reason=reason;
	}
	public String getReason(){
		return reason;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public void setTime(String time){
		this.time=time;
	}
	public String getTime(){
		return time;
	}
	@Override
	public String toString(){
		return "GroupSettingRecordPerformance [performanceID="+performanceID+",recordID="+recordID+",custID="+custID+",billDate="+billDate+",actNO="+actNO+",actName="+actName+",performance="+performance+",reason="+reason+",note="+note+",time="+time+"]";
	}
}

