package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** TreatmentPlan
	RECORDID	INT(10)
	TREATMENTID	INT(10)
	BILLDATE	DATETIME(23,3)
	TIME	VARCHAR(20)
	CONTENT	VARCHAR(128)
	TARGET	VARCHAR(128)
	CHARGE	DECIMAL(18,2)
	PAYMENT	DECIMAL(18,2)
	NOTE	VARCHAR(128)
	ACTIVITY	VARCHAR(128)
	PERFORMANCE	VARCHAR(128)

recordID,treatmentID,billDate,time,content,target,charge,payment,note,activity,performance
?,?,?,?,?,?,?,?,?,?,?

treatmentPlan.recordID,treatmentPlan.treatmentID,treatmentPlan.billDate,treatmentPlan.time,treatmentPlan.content,treatmentPlan.target,treatmentPlan.charge,treatmentPlan.payment,treatmentPlan.note,treatmentPlan.activity,treatmentPlan.performance

recordID=?,treatmentID=?,billDate=?,time=?,content=?,target=?,charge=?,payment=?,note=?,activity=?,performance=?
*/
public class TreatmentPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private int treatmentID;
	private Date billDate;
	private String time;
	private String content;
	private String target;
	private BigDecimal charge;
	private BigDecimal payment;
	private String note;
	private String activity;
	private String performance;

	public TreatmentPlan(){
		super();
	}
	public TreatmentPlan(int recordID, int treatmentID, Date billDate, String time, String content, String target, BigDecimal charge, BigDecimal payment, String note, String activity, String performance ){
		super();
		this.recordID=recordID;
		this.treatmentID=treatmentID;
		this.billDate=billDate;
		this.time=time;
		this.content=content;
		this.target=target;
		this.charge=charge;
		this.payment=payment;
		this.note=note;
		this.activity=activity;
		this.performance=performance;
	}
	public void setRecordID(int recordID){
		this.recordID=recordID;
	}
	public int getRecordID(){
		return recordID;
	}
	public void setTreatmentID(int treatmentID){
		this.treatmentID=treatmentID;
	}
	public int getTreatmentID(){
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
	public void setCharge(BigDecimal charge){
		this.charge=charge;
	}
	public BigDecimal getCharge(){
		return charge;
	}
	public void setPayment(BigDecimal payment){
		this.payment=payment;
	}
	public BigDecimal getPayment(){
		return payment;
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
	@Override
	public String toString(){
		return "TreatmentPlan [recordID="+recordID+",treatmentID="+treatmentID+",billDate="+billDate+",time="+time+",content="+content+",target="+target+",charge="+charge+",payment="+payment+",note="+note+",activity="+activity+",performance="+performance+"]";
	}
}

