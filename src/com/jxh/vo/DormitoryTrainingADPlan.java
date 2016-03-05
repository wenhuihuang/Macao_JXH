package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** DormitoryTrainingADPlan

planID,recordID,billDate,endDate,handler
?,?,?,?,?

dormitoryTrainingADPlan.planID,dormitoryTrainingADPlan.recordID,dormitoryTrainingADPlan.billDate,dormitoryTrainingADPlan.endDate,dormitoryTrainingADPlan.handler

planID=?,recordID=?,billDate=?,endDate=?,handler=?
*/
public class DormitoryTrainingADPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int planID;
	private int recordID;
	private Date billDate;
	private Date endDate;
	private String handler;

	public DormitoryTrainingADPlan(){
		super();
	}
	public DormitoryTrainingADPlan(int planID, int recordID, Date billDate, Date endDate, String handler ){
		super();
		this.planID=planID;
		this.recordID=recordID;
		this.billDate=billDate;
		this.endDate=endDate;
		this.handler=handler;
	}
	public void setPlanID(int planID){
		this.planID=planID;
	}
	public int getPlanID(){
		return planID;
	}
	public void setRecordID(int recordID){
		this.recordID=recordID;
	}
	public int getRecordID(){
		return recordID;
	}
	public void setBillDate(Date billDate){
		this.billDate=billDate;
	}
	public Date getBillDate(){
		return billDate;
	}
	public void setEndDate(Date endDate){
		this.endDate=endDate;
	}
	public Date getEndDate(){
		return endDate;
	}
	public void setHandler(String handler){
		this.handler=handler;
	}
	public String getHandler(){
		return handler;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingADPlan [planID="+planID+",recordID="+recordID+",billDate="+billDate+",endDate="+endDate+",handler="+handler+"]";
	}
}

