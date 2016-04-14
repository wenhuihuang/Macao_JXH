package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** GroupTrainingPlan
	PLANID	INT(10)
	TreatmentID	VARCHAR(20)
	GROUPNO	VARCHAR(32)
	GROUPNAME	VARCHAR(32)
	GOAL	VARCHAR(32)
	PRINCIPAL	VARCHAR(32)
	BEGINDATE	DATETIME(23,3)
	ENDDATE	DATETIME(23,3)
	NOTE	VARCHAR(128)

planID,treatmentID,groupNO,groupName,goal,principal,beginDate,endDate,note
?,?,?,?,?,?,?,?,?

groupTrainingPlan.planID,groupTrainingPlan.treatmentID,groupTrainingPlan.groupNO,groupTrainingPlan.groupName,groupTrainingPlan.goal,groupTrainingPlan.principal,groupTrainingPlan.beginDate,groupTrainingPlan.endDate,groupTrainingPlan.note

planID=?,treatmentID=?,groupNO=?,groupName=?,goal=?,principal=?,beginDate=?,endDate=?,note=?
*/
public class GroupTrainingPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int planID;
	private String treatmentID;
	private String groupNO;
	private String groupName;
	private String goal;
	private String principal;
	private Date beginDate;
	private Date endDate;
	private String note;

	public GroupTrainingPlan(){
		super();
	}
	public GroupTrainingPlan(int planID, String treatmentID, String groupNO, String groupName, String goal, String principal, Date beginDate, Date endDate, String note ){
		super();
		this.planID=planID;
		this.treatmentID=treatmentID;
		this.groupNO=groupNO;
		this.groupName=groupName;
		this.goal=goal;
		this.principal=principal;
		this.beginDate=beginDate;
		this.endDate=endDate;
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
	public void setGroupNO(String groupNO){
		this.groupNO=groupNO;
	}
	public String getGroupNO(){
		return groupNO;
	}
	public void setGroupName(String groupName){
		this.groupName=groupName;
	}
	public String getGroupName(){
		return groupName;
	}
	public void setGoal(String goal){
		this.goal=goal;
	}
	public String getGoal(){
		return goal;
	}
	public void setPrincipal(String principal){
		this.principal=principal;
	}
	public String getPrincipal(){
		return principal;
	}
	public void setBeginDate(Date beginDate){
		this.beginDate=beginDate;
	}
	public Date getBeginDate(){
		return beginDate;
	}
	public void setEndDate(Date endDate){
		this.endDate=endDate;
	}
	public Date getEndDate(){
		return endDate;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "GroupTrainingPlan [planID="+planID+",treatmentID="+treatmentID+",groupNO="+groupNO+",groupName="+groupName+",goal="+goal+",principal="+principal+",beginDate="+beginDate+",endDate="+endDate+",note="+note+"]";
	}
}

