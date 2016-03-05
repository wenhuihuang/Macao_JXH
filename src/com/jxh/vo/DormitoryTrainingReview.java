package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;


/** DormitoryTrainingReview

reviewID,recordID,workder,beginDate,endDate,beginWeek,beginNoon,endWeek,endNoon,task,interactive,activity,tTools,tReward,tAttention,tWorker,tWorkDate,tSuggest,tHandler,tHandleDate,tHandleSuggest,trainingNote,rTools,wholeReview,suggest,rWorker,rWorkDate,rSuggest,rHandler,rHandleDate,rHandleSuggest,groupNO
?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?

dormitoryTrainingReview.reviewID,dormitoryTrainingReview.recordID,dormitoryTrainingReview.workder,dormitoryTrainingReview.beginDate,dormitoryTrainingReview.endDate,dormitoryTrainingReview.beginWeek,dormitoryTrainingReview.beginNoon,dormitoryTrainingReview.endWeek,dormitoryTrainingReview.endNoon,dormitoryTrainingReview.task,dormitoryTrainingReview.interactive,dormitoryTrainingReview.activity,dormitoryTrainingReview.tTools,dormitoryTrainingReview.tReward,dormitoryTrainingReview.tAttention,dormitoryTrainingReview.tWorker,dormitoryTrainingReview.tWorkDate,dormitoryTrainingReview.tSuggest,dormitoryTrainingReview.tHandler,dormitoryTrainingReview.tHandleDate,dormitoryTrainingReview.tHandleSuggest,dormitoryTrainingReview.trainingNote,dormitoryTrainingReview.rTools,dormitoryTrainingReview.wholeReview,dormitoryTrainingReview.suggest,dormitoryTrainingReview.rWorker,dormitoryTrainingReview.rWorkDate,dormitoryTrainingReview.rSuggest,dormitoryTrainingReview.rHandler,dormitoryTrainingReview.rHandleDate,dormitoryTrainingReview.rHandleSuggest,dormitoryTrainingReview.groupNO

reviewID=?,recordID=?,workder=?,beginDate=?,endDate=?,beginWeek=?,beginNoon=?,endWeek=?,endNoon=?,task=?,interactive=?,activity=?,tTools=?,tReward=?,tAttention=?,tWorker=?,tWorkDate=?,tSuggest=?,tHandler=?,tHandleDate=?,tHandleSuggest=?,trainingNote=?,rTools=?,wholeReview=?,suggest=?,rWorker=?,rWorkDate=?,rSuggest=?,rHandler=?,rHandleDate=?,rHandleSuggest=?,groupNO=?
*/
public class DormitoryTrainingReview implements Serializable {
	private static final long serialVersionUID = 1L;
	private int reviewID;
	private String recordID;
	private String workder;
	private Date beginDate;
	private Date endDate;
	private int beginWeek;
	private int beginNoon;
	private int endWeek;
	private int endNoon;
	private String task;
	private String interactive;
	private String activity;
	private String tTools;
	private String tReward;
	private String tAttention;
	private String tWorker;
	private Date tWorkDate;
	private String tSuggest;
	private String tHandler;
	private Date tHandleDate;
	private String tHandleSuggest;
	private String trainingNote;
	private String rTools;
	private String wholeReview;
	private String suggest;
	private String rWorker;
	private Date rWorkDate;
	private String rSuggest;
	private String rHandler;
	private Date rHandleDate;
	private String rHandleSuggest;
	private String groupNO;

	public DormitoryTrainingReview(){
		super();
	}
	public DormitoryTrainingReview(int reviewID, String recordID, String workder, Date beginDate, Date endDate, int beginWeek, int beginNoon, int endWeek, int endNoon, String task, String interactive, String activity, String tTools, String tReward, String tAttention, String tWorker, Date tWorkDate, String tSuggest, String tHandler, Date tHandleDate, String tHandleSuggest, String trainingNote, String rTools, String wholeReview, String suggest, String rWorker, Date rWorkDate, String rSuggest, String rHandler, Date rHandleDate, String rHandleSuggest, String groupNO ){
		super();
		this.reviewID=reviewID;
		this.recordID=recordID;
		this.workder=workder;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.beginWeek=beginWeek;
		this.beginNoon=beginNoon;
		this.endWeek=endWeek;
		this.endNoon=endNoon;
		this.task=task;
		this.interactive=interactive;
		this.activity=activity;
		this.tTools=tTools;
		this.tReward=tReward;
		this.tAttention=tAttention;
		this.tWorker=tWorker;
		this.tWorkDate=tWorkDate;
		this.tSuggest=tSuggest;
		this.tHandler=tHandler;
		this.tHandleDate=tHandleDate;
		this.tHandleSuggest=tHandleSuggest;
		this.trainingNote=trainingNote;
		this.rTools=rTools;
		this.wholeReview=wholeReview;
		this.suggest=suggest;
		this.rWorker=rWorker;
		this.rWorkDate=rWorkDate;
		this.rSuggest=rSuggest;
		this.rHandler=rHandler;
		this.rHandleDate=rHandleDate;
		this.rHandleSuggest=rHandleSuggest;
		this.groupNO=groupNO;
	}
	public void setReviewID(int reviewID){
		this.reviewID=reviewID;
	}
	public int getReviewID(){
		return reviewID;
	}
	public void setRecordID(String recordID){
		this.recordID=recordID;
	}
	public String getRecordID(){
		return recordID;
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
	public void setBeginWeek(int beginWeek){
		this.beginWeek=beginWeek;
	}
	public int getBeginWeek(){
		return beginWeek;
	}
	public void setBeginNoon(int beginNoon){
		this.beginNoon=beginNoon;
	}
	public int getBeginNoon(){
		return beginNoon;
	}
	public void setEndWeek(int endWeek){
		this.endWeek=endWeek;
	}
	public int getEndWeek(){
		return endWeek;
	}
	public void setEndNoon(int endNoon){
		this.endNoon=endNoon;
	}
	public int getEndNoon(){
		return endNoon;
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
	public void setActivity(String activity){
		this.activity=activity;
	}
	public String getActivity(){
		return activity;
	}
	public void setTTools(String tTools){
		this.tTools=tTools;
	}
	public String getTTools(){
		return tTools;
	}
	public void setTReward(String tReward){
		this.tReward=tReward;
	}
	public String getTReward(){
		return tReward;
	}
	public void setTAttention(String tAttention){
		this.tAttention=tAttention;
	}
	public String getTAttention(){
		return tAttention;
	}
	public void setTWorker(String tWorker){
		this.tWorker=tWorker;
	}
	public String getTWorker(){
		return tWorker;
	}
	public void setTWorkDate(Date tWorkDate){
		this.tWorkDate=tWorkDate;
	}
	public Date getTWorkDate(){
		return tWorkDate;
	}
	public void setTSuggest(String tSuggest){
		this.tSuggest=tSuggest;
	}
	public String getTSuggest(){
		return tSuggest;
	}
	public void setTHandler(String tHandler){
		this.tHandler=tHandler;
	}
	public String getTHandler(){
		return tHandler;
	}
	public void setTHandleDate(Date tHandleDate){
		this.tHandleDate=tHandleDate;
	}
	public Date getTHandleDate(){
		return tHandleDate;
	}
	public void setTHandleSuggest(String tHandleSuggest){
		this.tHandleSuggest=tHandleSuggest;
	}
	public String getTHandleSuggest(){
		return tHandleSuggest;
	}
	public void setTrainingNote(String trainingNote){
		this.trainingNote=trainingNote;
	}
	public String getTrainingNote(){
		return trainingNote;
	}
	public void setRTools(String rTools){
		this.rTools=rTools;
	}
	public String getRTools(){
		return rTools;
	}
	public void setWholeReview(String wholeReview){
		this.wholeReview=wholeReview;
	}
	public String getWholeReview(){
		return wholeReview;
	}
	public void setSuggest(String suggest){
		this.suggest=suggest;
	}
	public String getSuggest(){
		return suggest;
	}
	public void setRWorker(String rWorker){
		this.rWorker=rWorker;
	}
	public String getRWorker(){
		return rWorker;
	}
	public void setRWorkDate(Date rWorkDate){
		this.rWorkDate=rWorkDate;
	}
	public Date getRWorkDate(){
		return rWorkDate;
	}
	public void setRSuggest(String rSuggest){
		this.rSuggest=rSuggest;
	}
	public String getRSuggest(){
		return rSuggest;
	}
	public void setRHandler(String rHandler){
		this.rHandler=rHandler;
	}
	public String getRHandler(){
		return rHandler;
	}
	public void setRHandleDate(Date rHandleDate){
		this.rHandleDate=rHandleDate;
	}
	public Date getRHandleDate(){
		return rHandleDate;
	}
	public void setRHandleSuggest(String rHandleSuggest){
		this.rHandleSuggest=rHandleSuggest;
	}
	public String getRHandleSuggest(){
		return rHandleSuggest;
	}
	public void setGroupNO(String groupNO){
		this.groupNO=groupNO;
	}
	public String getGroupNO(){
		return groupNO;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingReview [reviewID="+reviewID+",recordID="+recordID+",workder="+workder+",beginDate="+beginDate+",endDate="+endDate+",beginWeek="+beginWeek+",beginNoon="+beginNoon+",endWeek="+endWeek+",endNoon="+endNoon+",task="+task+",interactive="+interactive+",activity="+activity+",tTools="+tTools+",tReward="+tReward+",tAttention="+tAttention+",tWorker="+tWorker+",tWorkDate="+tWorkDate+",tSuggest="+tSuggest+",tHandler="+tHandler+",tHandleDate="+tHandleDate+",tHandleSuggest="+tHandleSuggest+",trainingNote="+trainingNote+",rTools="+rTools+",wholeReview="+wholeReview+",suggest="+suggest+",rWorker="+rWorker+",rWorkDate="+rWorkDate+",rSuggest="+rSuggest+",rHandler="+rHandler+",rHandleDate="+rHandleDate+",rHandleSuggest="+rHandleSuggest+",groupNO="+groupNO+"]";
	}
}

