package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;


/** TreatmentTrainingWork

workID,trainingID,beginDate,endDate,duty,corp,place,workTime,content,workDetail,envioment,handler,handleDate,handleSuggest
?,?,?,?,?,?,?,?,?,?,?,?,?,?

treatmentTrainingWork.workID,treatmentTrainingWork.trainingID,treatmentTrainingWork.beginDate,treatmentTrainingWork.endDate,treatmentTrainingWork.duty,treatmentTrainingWork.corp,treatmentTrainingWork.place,treatmentTrainingWork.workTime,treatmentTrainingWork.content,treatmentTrainingWork.workDetail,treatmentTrainingWork.envioment,treatmentTrainingWork.handler,treatmentTrainingWork.handleDate,treatmentTrainingWork.handleSuggest

workID=?,trainingID=?,beginDate=?,endDate=?,duty=?,corp=?,place=?,workTime=?,content=?,workDetail=?,envioment=?,handler=?,handleDate=?,handleSuggest=?
*/
public class TreatmentTrainingWork implements Serializable {
	private static final long serialVersionUID = 1L;
	private String workID;
	private String trainingID;
	private Date beginDate;
	private Date endDate;
	private String duty;
	private String corp;
	private String place;
	private int workTime;
	private String content;
	private String workDetail;
	private String envioment;
	private String handler;
	private Date handleDate;
	private String handleSuggest;

	public TreatmentTrainingWork(){
		super();
	}
	public TreatmentTrainingWork(String workID, String trainingID, Date beginDate, Date endDate, String duty, String corp, String place, int workTime, String content, String workDetail, String envioment, String handler, Date handleDate, String handleSuggest ){
		super();
		this.workID=workID;
		this.trainingID=trainingID;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.duty=duty;
		this.corp=corp;
		this.place=place;
		this.workTime=workTime;
		this.content=content;
		this.workDetail=workDetail;
		this.envioment=envioment;
		this.handler=handler;
		this.handleDate=handleDate;
		this.handleSuggest=handleSuggest;
	}
	public void setWorkID(String workID){
		this.workID=workID;
	}
	public String getWorkID(){
		return workID;
	}
	public void setTrainingID(String trainingID){
		this.trainingID=trainingID;
	}
	public String getTrainingID(){
		return trainingID;
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
	public void setDuty(String duty){
		this.duty=duty;
	}
	public String getDuty(){
		return duty;
	}
	public void setCorp(String corp){
		this.corp=corp;
	}
	public String getCorp(){
		return corp;
	}
	public void setPlace(String place){
		this.place=place;
	}
	public String getPlace(){
		return place;
	}
	public void setWorkTime(int workTime){
		this.workTime=workTime;
	}
	public int getWorkTime(){
		return workTime;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setWorkDetail(String workDetail){
		this.workDetail=workDetail;
	}
	public String getWorkDetail(){
		return workDetail;
	}
	public void setEnvioment(String envioment){
		this.envioment=envioment;
	}
	public String getEnvioment(){
		return envioment;
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
		return "TreatmentTrainingWork [workID="+workID+",trainingID="+trainingID+",beginDate="+beginDate+",endDate="+endDate+",duty="+duty+",corp="+corp+",place="+place+",workTime="+workTime+",content="+content+",workDetail="+workDetail+",envioment="+envioment+",handler="+handler+",handleDate="+handleDate+",handleSuggest="+handleSuggest+"]";
	}
}

