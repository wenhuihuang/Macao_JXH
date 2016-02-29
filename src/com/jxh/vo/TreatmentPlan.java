package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** TreatmentPlan
	PLANID	INT(10)
	TREATMENTID	INT(10)
	BILLDATE	DATETIME(23,3)
	TIME	VARCHAR(20)
	CONTENT	VARCHAR(128)
	TARGET	VARCHAR(128)
	CHARGE	DECIMAL(18,2)
	PAYMENT	DECIMAL(18,2)
	NOTE	VARCHAR(128)

planID,treatmentID,billDate,time,content,target,charge,payment,note
?,?,?,?,?,?,?,?,?

treatmentPlan.planID,treatmentPlan.treatmentID,treatmentPlan.billDate,treatmentPlan.time,treatmentPlan.content,treatmentPlan.target,treatmentPlan.charge,treatmentPlan.payment,treatmentPlan.note

planID=?,treatmentID=?,billDate=?,time=?,content=?,target=?,charge=?,payment=?,note=?
*/
public class TreatmentPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int planID;
	private String treatmentID;
	private Date billDate;
	private String time;
	private String content;
	private String target;
	private BigDecimal charge;
	private BigDecimal payment;
	private String note;

	public TreatmentPlan(){
		super();
	}
	public TreatmentPlan(int planID, String treatmentID, Date billDate, String time, String content, String target, BigDecimal charge, BigDecimal payment, String note ){
		super();
		this.planID=planID;
		this.treatmentID=treatmentID;
		this.billDate=billDate;
		this.time=time;
		this.content=content;
		this.target=target;
		this.charge=charge;
		this.payment=payment;
		this.note=note;
	}
	public void setPlanID(int planID){
		this.planID=planID;
	}
	public int getPlanID(){
		return planID;
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
	@Override
	public String toString(){
		return "TreatmentPlan [planID="+planID+",treatmentID="+treatmentID+",billDate="+billDate+",time="+time+",content="+content+",target="+target+",charge="+charge+",payment="+payment+",note="+note+"]";
	}
}

