package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;


/** DormitoryTrainingPlan

planID,recordID,actProtocol,billDate,suggest,target,place,tools,reward,standard,attention,handler,handleDate,handleSuggest
?,?,?,?,?,?,?,?,?,?,?,?,?,?

dormitoryTrainingPlan.planID,dormitoryTrainingPlan.recordID,dormitoryTrainingPlan.actProtocol,dormitoryTrainingPlan.billDate,dormitoryTrainingPlan.suggest,dormitoryTrainingPlan.target,dormitoryTrainingPlan.place,dormitoryTrainingPlan.tools,dormitoryTrainingPlan.reward,dormitoryTrainingPlan.standard,dormitoryTrainingPlan.attention,dormitoryTrainingPlan.handler,dormitoryTrainingPlan.handleDate,dormitoryTrainingPlan.handleSuggest

planID=?,recordID=?,actProtocol=?,billDate=?,suggest=?,target=?,place=?,tools=?,reward=?,standard=?,attention=?,handler=?,handleDate=?,handleSuggest=?
*/
public class DormitoryTrainingPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int planID;
	private String recordID;
	private String actProtocol;
	private Date billDate;
	private String suggest;
	private String target;
	private String place;
	private String tools;
	private String reward;
	private String standard;
	private String attention;
	private String handler;
	private Date handleDate;
	private String handleSuggest;

	public DormitoryTrainingPlan(){
		super();
	}
	public DormitoryTrainingPlan(int planID, String recordID, String actProtocol, Date billDate, String suggest, String target, String place, String tools, String reward, String standard, String attention, String handler, Date handleDate, String handleSuggest ){
		super();
		this.planID=planID;
		this.recordID=recordID;
		this.actProtocol=actProtocol;
		this.billDate=billDate;
		this.suggest=suggest;
		this.target=target;
		this.place=place;
		this.tools=tools;
		this.reward=reward;
		this.standard=standard;
		this.attention=attention;
		this.handler=handler;
		this.handleDate=handleDate;
		this.handleSuggest=handleSuggest;
	}
	public void setPlanID(int planID){
		this.planID=planID;
	}
	public int getPlanID(){
		return planID;
	}
	public void setRecordID(String recordID){
		this.recordID=recordID;
	}
	public String getRecordID(){
		return recordID;
	}
	public void setActProtocol(String actProtocol){
		this.actProtocol=actProtocol;
	}
	public String getActProtocol(){
		return actProtocol;
	}
	public void setBillDate(Date billDate){
		this.billDate=billDate;
	}
	public Date getBillDate(){
		return billDate;
	}
	public void setSuggest(String suggest){
		this.suggest=suggest;
	}
	public String getSuggest(){
		return suggest;
	}
	public void setTarget(String target){
		this.target=target;
	}
	public String getTarget(){
		return target;
	}
	public void setPlace(String place){
		this.place=place;
	}
	public String getPlace(){
		return place;
	}
	public void setTools(String tools){
		this.tools=tools;
	}
	public String getTools(){
		return tools;
	}
	public void setReward(String reward){
		this.reward=reward;
	}
	public String getReward(){
		return reward;
	}
	public void setStandard(String standard){
		this.standard=standard;
	}
	public String getStandard(){
		return standard;
	}
	public void setAttention(String attention){
		this.attention=attention;
	}
	public String getAttention(){
		return attention;
	}
	public void setHandler(String handler){
		this.handler=handler;
	}
	public String getHandler(){
		return handler;
	}
	public void setHandleDate(Date handleDate){
		this.handleDate=handleDate;
	}
	public Date getHandleDate(){
		return handleDate;
	}
	public void setHandleSuggest(String handleSuggest){
		this.handleSuggest=handleSuggest;
	}
	public String getHandleSuggest(){
		return handleSuggest;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingPlan [planID="+planID+",recordID="+recordID+",actProtocol="+actProtocol+",billDate="+billDate+",suggest="+suggest+",target="+target+",place="+place+",tools="+tools+",reward="+reward+",standard="+standard+",attention="+attention+",handler="+handler+",handleDate="+handleDate+",handleSuggest="+handleSuggest+"]";
	}
}

