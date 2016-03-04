package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** TreatmentRecord

recordID,treatmentID,billDate,time,content,target,note,activity,performance,worker
?,?,?,?,?,?,?,?,?,?

treatmentRecord.recordID,treatmentRecord.treatmentID,treatmentRecord.billDate,treatmentRecord.time,treatmentRecord.content,treatmentRecord.target,treatmentRecord.note,treatmentRecord.activity,treatmentRecord.performance,treatmentRecord.worker

recordID=?,treatmentID=?,billDate=?,time=?,content=?,target=?,note=?,activity=?,performance=?,worker=?
*/
public class TreatmentRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private String treatmentID;
	private Date billDate;
	private String time;
	private String content;
	private String target;
	private String note;
	private String activity;
	private String performance;
	private String worker;

	public TreatmentRecord(){
		super();
	}
	public TreatmentRecord(int recordID, String treatmentID, Date billDate, String time, String content, String target, String note, String activity, String performance,
							String worker){
		super();
		this.recordID=recordID;
		this.treatmentID=treatmentID;
		this.billDate=billDate;
		this.time=time;
		this.content=content;
		this.target=target;
		this.note=note;
		this.activity=activity;
		this.performance=performance;
		this.worker=worker;
	}
	public void setRecordID(int recordID){
		this.recordID=recordID;
	}
	public int getRecordID(){
		return recordID;
	}
	public void setTreatmentID(String treatmentID){
		this.treatmentID=treatmentID;
	}
	public String getTreatmentID(){
		return treatmentID;
	}
	public void setBillDate(Date billDate){
		this.billDate=billDate;
	}
	public Date getBillDate(){
		return billDate;
	}
	public void setTime(String time){
		this.time=time;
	}
	public String getTime(){
		return time;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setTarget(String target){
		this.target=target;
	}
	public String getTarget(){
		return target;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public void setActivity(String activity){
		this.activity=activity;
	}
	public String getActivity(){
		return activity;
	}
	public void setPerformance(String performance){
		this.performance=performance;
	}
	public String getPerformance(){
		return performance;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	@Override
	public String toString(){
		return "TreatmentRecord [recordID="+recordID+",treatmentID="+treatmentID+",billDate="+billDate+",time="+time+",content="+content+",target="+target+",note="+note+",activity="+activity+",performance="+performance+",worker="+worker+"]";
	}
}

