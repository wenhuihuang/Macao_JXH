package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.sql.*;
import java.text.ParseException;
import java.math.*;


/** TreatmentTrainingWork

workID,treatmentID,beginDate,endDate,duty,corp,placeT,workTime,content,workDetail,envioment,handler,handleDate,handleSuggest
?,?,?,?,?,?,?,?,?,?,?,?,?,?

treatmentTrainingWork.workID,treatmentTrainingWork.treatmentID,treatmentTrainingWork.beginDate,treatmentTrainingWork.endDate,treatmentTrainingWork.duty,treatmentTrainingWork.corp,treatmentTrainingWork.placeT,treatmentTrainingWork.workTime,treatmentTrainingWork.content,treatmentTrainingWork.workDetail,treatmentTrainingWork.envioment,treatmentTrainingWork.handler,treatmentTrainingWork.handleDate,treatmentTrainingWork.handleSuggest

workID=?,treatmentID=?,beginDate=?,endDate=?,duty=?,corp=?,placeT=?,workTime=?,content=?,workDetail=?,envioment=?,handler=?,handleDate=?,handleSuggest=?
*/
public class TreatmentTrainingWork implements Serializable {
	private static final long serialVersionUID = 1L;
	private String workID;
	private String treatmentID;
	private Date beginDate;
	private Date endDate;
	private String duty;
	private String corp;
	private String placeT;
	private String workTime;
	private String content;
	private String workDetail;
	private String envioment;
	private String handler;
	private Date handleDate;
	private String handleSuggest;
	
	private String beginDate_str;
	private String endDate_str;
	private String handleDate_str;

	public TreatmentTrainingWork(){
		super();
	}
	public TreatmentTrainingWork(String workID, String treatmentID, Date beginDate, Date endDate, String duty, String corp, String placeT, String workTime, String content, String workDetail, String envioment, String handler, Date handleDate, String handleSuggest,String handleDate_str ,
								String endDate_str, String beginDate_str){
		super();
		this.workID=workID;
		this.treatmentID=treatmentID;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.duty=duty;
		this.corp=corp;
		this.placeT=placeT;
		this.workTime=workTime;
		this.content=content;
		this.workDetail=workDetail;
		this.envioment=envioment;
		this.handler=handler;
		this.handleDate=handleDate;
		this.handleSuggest=handleSuggest;
		this.handleDate_str=handleDate_str;
		this.beginDate_str=beginDate_str;
		this.endDate_str=endDate_str;
	}
	public void setWorkID(String workID){
		this.workID=workID;
	}
	public String getWorkID(){
		return workID;
	}
	public void setTreatmentID(String treatmentID){
		this.treatmentID=treatmentID;
	}
	public String getTreatmentID(){
		return treatmentID;
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
	public void setPlaceT(String placeT){
		this.placeT=placeT;
	}
	public String getPlaceT(){
		return placeT;
	}
	public void setWorkTime(String workTime){
		this.workTime=workTime;
	}
	public String getWorkTime(){
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
	
	
	
	public String getHandleDate_str() {
		try {
			return handleDate == null || "".equals(handleDate) ? ""
					: ToolsUtils.getDateStringByFormat(handleDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void setHandleDate_str(String handleDate_str) {
		this.handleDate_str = handleDate_str;
	}
	
	
	
	public String getBeginDate_str() {
		try {
			return beginDate == null || "".equals(beginDate) ? ""
					: ToolsUtils.getDateStringByFormat(beginDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void setBeginDate_str(String beginDate_str) {
		this.beginDate_str = beginDate_str;
	}
	public String getEndDate_str() {
		try {
			return endDate == null || "".equals(endDate) ? ""
					: ToolsUtils.getDateStringByFormat(endDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void setEndDate_str(String endDate_str) {
		this.endDate_str = endDate_str;
	}
	@Override
	public String toString(){
		return "TreatmentTrainingWork [workID="+workID+",treatmentID="+treatmentID+",beginDate="+beginDate+",endDate="+endDate+",duty="+duty+",corp="+corp+",placeT="+placeT+",workTime="+workTime+",content="+content+",workDetail="+workDetail+",envioment="+envioment+",handler="+handler+",handleDate="+handleDate+",handleSuggest="+handleSuggest+",handleDate_str="+handleDate_str+
				",beginDate_str="+beginDate_str+",endDate_str="+endDate_str+"]";
	}
}

