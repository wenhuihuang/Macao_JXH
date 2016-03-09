package com.jxh.pojo;


import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.sql.*;
import java.text.ParseException;
import java.math.*;


public class DormitoryRecordPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordID;
	private String custID;
	private String recordNO;
	private Date applyDate;
	private Date planDate;
	private int recordType;
	private String roomNO;
	private String groupType;
	private Date inDate;
	private String actProtocol;
	private String worker;
	private Date trainingBDate;
	private Date trainingEDate;
	private Date outDate;
	private String task;
	private String interactive;
	private String ativity;
	private String trainingBTime;
	private String trainingETime;
	private String trainingType;
	private String fullName;
	private String isMember;
	
	private String aPlanID;
	private String tRecordID;
	private String reviewID;
	
	private String applyDate_str;
	private String planDate_str;
	private String inDate_str;
	private String trainingBDate_str;
	private String trainingEDate_str;
	private String outDate_str;

	public DormitoryRecordPojo(){
		super();
	}
	public DormitoryRecordPojo(String recordID, String custID, String recordNO, Date applyDate, Date planDate, int recordType, String roomNO, String groupType, Date inDate, String actProtocol, String worker, Date trainingBDate, Date trainingEDate, Date outDate, String task, String interactive, String ativity,
								String applyDate_str,String planDate_str,String inDate_str,String trainingBDate_str,
								String trainingEDate_str,String outDate_str,String trainingBTime,String trainingETime,String trainingType,
								String fullName,String isMember,String aPlanID,String tRecordID,String reviewID){
		super();
		this.recordID=recordID;
		this.custID=custID;
		this.recordNO=recordNO;
		this.applyDate=applyDate;
		this.planDate=planDate;
		this.recordType=recordType;
		this.roomNO=roomNO;
		this.groupType=groupType;
		this.inDate=inDate;
		this.actProtocol=actProtocol;
		this.worker=worker;
		this.trainingBDate=trainingBDate;
		this.trainingEDate=trainingEDate;
		this.outDate=outDate;
		this.task=task;
		this.interactive=interactive;
		this.ativity=ativity;
		this.trainingBTime=trainingBTime;
		this.trainingETime=trainingETime;
		this.trainingType=trainingType;
		this.fullName=fullName;
		this.isMember=isMember;
		
		this.aPlanID=aPlanID;
		this.tRecordID=tRecordID;
		this.reviewID=reviewID;
		
		
		this.applyDate_str=applyDate_str;
		this.planDate_str=planDate_str;
		this.inDate_str=inDate_str;
		this.trainingBDate_str=trainingBDate_str;
		this.trainingEDate_str=trainingEDate_str;
		this.outDate_str=outDate_str;
	}
	public void setRecordID(String recordID){
		this.recordID=recordID;
	}
	public String getRecordID(){
		return recordID;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setRecordNO(String recordNO){
		this.recordNO=recordNO;
	}
	public String getRecordNO(){
		return recordNO;
	}
	public void setApplyDate(Date applyDate){
		this.applyDate=applyDate;
	}
	public Date getApplyDate(){
		return applyDate;
	}
	public void setPlanDate(Date planDate){
		this.planDate=planDate;
	}
	public Date getPlanDate(){
		return planDate;
	}
	public void setRecordType(int recordType){
		this.recordType=recordType;
	}
	public int getRecordType(){
		return recordType;
	}
	public void setRoomNO(String roomNO){
		this.roomNO=roomNO;
	}
	public String getRoomNO(){
		return roomNO;
	}
	public void setGroupType(String groupType){
		this.groupType=groupType;
	}
	public String getGroupType(){
		return groupType;
	}
	public void setInDate(Date inDate){
		this.inDate=inDate;
	}
	public Date getInDate(){
		return inDate;
	}
	public void setActProtocol(String actProtocol){
		this.actProtocol=actProtocol;
	}
	public String getActProtocol(){
		return actProtocol;
	}
	public void setWorker(String worker){
		this.worker=worker;
	}
	public String getWorker(){
		return worker;
	}
	public void setTrainingBDate(Date trainingBDate){
		this.trainingBDate=trainingBDate;
	}
	public Date getTrainingBDate(){
		return trainingBDate;
	}
	public void setTrainingEDate(Date trainingEDate){
		this.trainingEDate=trainingEDate;
	}
	public Date getTrainingEDate(){
		return trainingEDate;
	}
	public void setOutDate(Date outDate){
		this.outDate=outDate;
	}
	public Date getOutDate(){
		return outDate;
	}
	public void setTask(String task){
		this.task=task;
	}
	public String getTask(){
		return task;
	}
	public void setInteractive(String interactive){
		this.interactive=interactive;
	}
	public String getInteractive(){
		return interactive;
	}
	public void setAtivity(String ativity){
		this.ativity=ativity;
	}
	public String getAtivity(){
		return ativity;
	}
	
	
	public String getApplyDate_str() {
		try {
			return applyDate == null || "".equals(applyDate) ? ""
					: ToolsUtils.getDateStringByFormat(applyDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setApplyDate_str(String applyDate_str) {
		this.applyDate_str = applyDate_str;
	}
	public String getPlanDate_str() {
		try {
			return planDate == null || "".equals(planDate) ? ""
					: ToolsUtils.getDateStringByFormat(planDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setPlanDate_str(String planDate_str) {
		this.planDate_str = planDate_str;
	}
	public String getInDate_str() {
		try {
			return inDate == null || "".equals(inDate) ? ""
					: ToolsUtils.getDateStringByFormat(inDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setInDate_str(String inDate_str) {
		this.inDate_str = inDate_str;
	}
	public String getTrainingBDate_str() {
		try {
			return trainingBDate == null || "".equals(trainingBDate) ? ""
					: ToolsUtils.getDateStringByFormat(trainingBDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setTrainingBDate_str(String trainingBDate_str) {
		this.trainingBDate_str = trainingBDate_str;
	}
	public String getTrainingEDate_str() {
		try {
			return trainingEDate == null || "".equals(trainingEDate) ? ""
					: ToolsUtils.getDateStringByFormat(trainingEDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setTrainingEDate_str(String trainingEDate_str) {
		this.trainingEDate_str = trainingEDate_str;
	}
	public String getOutDate_str() {
		try {
			return outDate == null || "".equals(outDate) ? ""
					: ToolsUtils.getDateStringByFormat(outDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setOutDate_str(String outDate_str) {
		this.outDate_str = outDate_str;
	}
	
	
	
	public String getTrainingBTime() {
		return trainingBTime;
	}
	public void setTrainingBTime(String trainingBTime) {
		this.trainingBTime = trainingBTime;
	}
	public String getTrainingETime() {
		return trainingETime;
	}
	public void setTrainingETime(String trainingETime) {
		this.trainingETime = trainingETime;
	}
	public String getTrainingType() {
		return trainingType;
	}
	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIsMember() {
		return isMember;
	}
	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}
	public String getaPlanID() {
		return aPlanID;
	}
	public void setaPlanID(String aPlanID) {
		this.aPlanID = aPlanID;
	}
	public String gettRecordID() {
		return tRecordID;
	}
	public void settRecordID(String tRecordID) {
		this.tRecordID = tRecordID;
	}
	public String getReviewID() {
		return reviewID;
	}
	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}
	@Override
	public String toString(){
		return "DormitoryRecord [recordID="+recordID+",custID="+custID+",recordNO="+recordNO+",applyDate="+applyDate+",planDate="+planDate+",recordType="+recordType+",roomNO="+roomNO+",groupType="+groupType+",inDate="+inDate+",actProtocol="+actProtocol+",worker="+worker+",trainingBDate="+trainingBDate+",trainingEDate="+trainingEDate+",outDate="+outDate+",task="+task+
				",interactive="+interactive+",ativity="+ativity+",applyDate_str="+applyDate_str+",planDate_str="+planDate_str+",inDate_str="+inDate_str+",trainingBDate_str="+trainingBDate_str+",trainingEDate_str="+trainingEDate_str+",outDate_str="+outDate_str+
				",trainingBTime="+trainingBTime+",trainingETime="+trainingETime+",trainingType="+trainingType+
				",fullName="+fullName+",isMember="+isMember+",aPlanID="+aPlanID+",tRecordID="+tRecordID+",reviewID="+reviewID+"]";
	}
}

