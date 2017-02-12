package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** GroupTrainingRecord
	RECORDID	INT(10)
	TreatmentID	VARCHAR(20)
	TRAININGDATE	DATETIME(23,3)
	EXPRESSION	VARCHAR(128)
	NOTE	VARCHAR(128)

recordID,treatmentID,trainingDate,expression,note,groupNO
?,?,?,?,?,?

groupTrainingRecord.recordID,groupTrainingRecord.treatmentID,groupTrainingRecord.trainingDate,groupTrainingRecord.expression,groupTrainingRecord.note,groupTrainingRecord.groupNO

recordID=?,treatmentID=?,trainingDate=?,expression=?,note=?,groupNO=?
*/
public class GroupTrainingRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private String treatmentID;
	private Date trainingDate;
	private String expression;
	private String note;
	private String groupNO;

	public GroupTrainingRecord(){
		super();
	}
	public GroupTrainingRecord(int recordID, String treatmentID, Date trainingDate, String expression, String note,String groupNO ){
		super();
		this.recordID=recordID;
		this.treatmentID=treatmentID;
		this.trainingDate=trainingDate;
		this.expression=expression;
		this.note=note;
		this.groupNO=groupNO;
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
	public void setTrainingDate(Date trainingDate){
		this.trainingDate=trainingDate;
	}
	public Date getTrainingDate(){
		return trainingDate;
	}
	public void setExpression(String expression){
		this.expression=expression;
	}
	public String getExpression(){
		return expression;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public String getGroupNO() {
		return groupNO;
	}
	public void setGroupNO(String groupNO) {
		this.groupNO = groupNO;
	}
	@Override
	public String toString(){
		return "GroupTrainingRecord [recordID="+recordID+",treatmentID="+treatmentID+",trainingDate="+trainingDate+",expression="+expression+",note="+note+",groupNO="+groupNO+"]";
	}
}

