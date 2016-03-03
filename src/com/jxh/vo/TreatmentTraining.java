package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;


/** TreatmentTraining

trainingID,treatmentID,program,target,workder,beginDate,endDate,place,attention,emotional,attitude,instruction,endurance,skill,other,targetAssess,trainingNO
?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?

treatmentTraining.trainingID,treatmentTraining.treatmentID,treatmentTraining.program,treatmentTraining.target,treatmentTraining.workder,treatmentTraining.beginDate,treatmentTraining.endDate,treatmentTraining.place,treatmentTraining.attention,treatmentTraining.emotional,treatmentTraining.attitude,treatmentTraining.instruction,treatmentTraining.endurance,treatmentTraining.skill,treatmentTraining.other,treatmentTraining.targetAssess,treatmentTraining.trainingNO

trainingID=?,treatmentID=?,program=?,target=?,workder=?,beginDate=?,endDate=?,place=?,attention=?,emotional=?,attitude=?,instruction=?,endurance=?,skill=?,other=?,targetAssess=?,trainingNO=?
*/
public class TreatmentTraining implements Serializable {
	private static final long serialVersionUID = 1L;
	private String trainingID;
	private String treatmentID;
	private String program;
	private String target;
	private String workder;
	private Date beginDate;
	private Date endDate;
	private String place;
	private String attention;
	private String emotional;
	private String attitude;
	private String instruction;
	private String endurance;
	private String skill;
	private String other;
	private String targetAssess;
	private String trainingNO;

	public TreatmentTraining(){
		super();
	}
	public TreatmentTraining(String trainingID, String treatmentID, String program, String target, String workder, Date beginDate, Date endDate, String place, String attention, String emotional, String attitude, String instruction, String endurance, String skill, String other, String targetAssess, String trainingNO ){
		super();
		this.trainingID=trainingID;
		this.treatmentID=treatmentID;
		this.program=program;
		this.target=target;
		this.workder=workder;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.place=place;
		this.attention=attention;
		this.emotional=emotional;
		this.attitude=attitude;
		this.instruction=instruction;
		this.endurance=endurance;
		this.skill=skill;
		this.other=other;
		this.targetAssess=targetAssess;
		this.trainingNO=trainingNO;
	}
	public void setTrainingID(String trainingID){
		this.trainingID=trainingID;
	}
	public String getTrainingID(){
		return trainingID;
	}
	public void setTreatmentID(String treatmentID){
		this.treatmentID=treatmentID;
	}
	public String getTreatmentID(){
		return treatmentID;
	}
	public void setProgram(String program){
		this.program=program;
	}
	public String getProgram(){
		return program;
	}
	public void setTarget(String target){
		this.target=target;
	}
	public String getTarget(){
		return target;
	}
	public void setWorkder(String workder){
		this.workder=workder;
	}
	public String getWorkder(){
		return workder;
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
	public void setPlace(String place){
		this.place=place;
	}
	public String getPlace(){
		return place;
	}
	public void setAttention(String attention){
		this.attention=attention;
	}
	public String getAttention(){
		return attention;
	}
	public void setEmotional(String emotional){
		this.emotional=emotional;
	}
	public String getEmotional(){
		return emotional;
	}
	public void setAttitude(String attitude){
		this.attitude=attitude;
	}
	public String getAttitude(){
		return attitude;
	}
	public void setInstruction(String instruction){
		this.instruction=instruction;
	}
	public String getInstruction(){
		return instruction;
	}
	public void setEndurance(String endurance){
		this.endurance=endurance;
	}
	public String getEndurance(){
		return endurance;
	}
	public void setSkill(String skill){
		this.skill=skill;
	}
	public String getSkill(){
		return skill;
	}
	public void setOther(String other){
		this.other=other;
	}
	public String getOther(){
		return other;
	}
	public void setTargetAssess(String targetAssess){
		this.targetAssess=targetAssess;
	}
	public String getTargetAssess(){
		return targetAssess;
	}
	public void setTrainingNO(String trainingNO){
		this.trainingNO=trainingNO;
	}
	public String getTrainingNO(){
		return trainingNO;
	}
	@Override
	public String toString(){
		return "TreatmentTraining [trainingID="+trainingID+",treatmentID="+treatmentID+",program="+program+",target="+target+",workder="+workder+",beginDate="+beginDate+",endDate="+endDate+",place="+place+",attention="+attention+",emotional="+emotional+",attitude="+attitude+",instruction="+instruction+",endurance="+endurance+",skill="+skill+",other="+other+",targetAssess="+targetAssess+",trainingNO="+trainingNO+"]";
	}
}

