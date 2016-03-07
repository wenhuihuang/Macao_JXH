package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.sql.*;
import java.text.ParseException;
import java.math.*;


/** DormitoryTrainingReview

reviewID,recordID,workder,beginDate,endDate,beginWeek,beginNoon,endWeek,endNoon,task,interactive,activity,tTools,tReward,tAttention,tWorker,tWorkDate,tSuggest,tHandler,tHandleDate,tHandleSuggest,trainingNote,rTools,wholeReview,suggest,rWorker,rWorkDate,rSuggest,rHandler,rHandleDate,rHandleSuggest,groupNO
?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?

dormitoryTrainingReview.reviewID,dormitoryTrainingReview.recordID,dormitoryTrainingReview.workder,dormitoryTrainingReview.beginDate,dormitoryTrainingReview.endDate,dormitoryTrainingReview.beginWeek,dormitoryTrainingReview.beginNoon,dormitoryTrainingReview.endWeek,dormitoryTrainingReview.endNoon,dormitoryTrainingReview.task,dormitoryTrainingReview.interactive,dormitoryTrainingReview.activity,dormitoryTrainingReview.tTools,dormitoryTrainingReview.tReward,dormitoryTrainingReview.tAttention,dormitoryTrainingReview.tWorker,dormitoryTrainingReview.tWorkDate,dormitoryTrainingReview.tSuggest,dormitoryTrainingReview.tHandler,dormitoryTrainingReview.tHandleDate,dormitoryTrainingReview.tHandleSuggest,dormitoryTrainingReview.trainingNote,dormitoryTrainingReview.rTools,dormitoryTrainingReview.wholeReview,dormitoryTrainingReview.suggest,dormitoryTrainingReview.rWorker,dormitoryTrainingReview.rWorkDate,dormitoryTrainingReview.rSuggest,dormitoryTrainingReview.rHandler,dormitoryTrainingReview.rHandleDate,dormitoryTrainingReview.rHandleSuggest,dormitoryTrainingReview.groupNO

reviewID=?,recordID=?,workder=?,beginDate=?,endDate=?,beginWeek=?,beginNoon=?,endWeek=?,endNoon=?,task=?,interactive=?,activity=?,tTools=?,tReward=?,tAttention=?,tWorker=?,tWorkDate=?,tSuggest=?,tHandler=?,tHandleDate=?,tHandleSuggest=?,trainingNote=?,rTools=?,wholeReview=?,suggest=?,rWorker=?,rWorkDate=?,rSuggest=?,rHandler=?,rHandleDate=?,rHandleSuggest=?,groupNO=?
*/
public class DormitoryTrainingReview implements Serializable {
	private static final long serialVersionUID = 1L;
	private String reviewID;
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
	
	private String beginDate_str;
	private String endDate_str;
	private String tWorkDate_str;
	private String tHandleDate_str;
	private String rWorkDate_str;
	private String rHandleDate_str;

	public DormitoryTrainingReview(){
		super();
	}
	public DormitoryTrainingReview(String reviewID, String recordID, String workder, Date beginDate, Date endDate, int beginWeek, int beginNoon, int endWeek, int endNoon, String task, String interactive, String activity, String tTools, String tReward, String tAttention, String tWorker, Date tWorkDate, String tSuggest, String tHandler, Date tHandleDate, String tHandleSuggest, String trainingNote, String rTools, String wholeReview, String suggest, String rWorker, Date rWorkDate, String rSuggest, String rHandler, Date rHandleDate, String rHandleSuggest, String groupNO,
								String beginDate_str,String endDate_str,String tWorkDate_str,String tHandleDate_str,
								String rWorkDate_str,String rHandleDate_str){
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
		this.beginDate_str=beginDate_str;
		this.endDate_str=endDate_str;
		this.tWorkDate_str=tWorkDate_str;
		this.tHandleDate_str=tHandleDate_str;
		this.rWorkDate_str=rWorkDate_str;
		this.rHandleDate_str=rHandleDate_str;
		
	}
	public void setReviewID(String reviewID){
		this.reviewID=reviewID;
	}
	public String getReviewID(){
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
	public void setTrainingNote(String trainingNote){
		this.trainingNote=trainingNote;
	}
	public String getTrainingNote(){
		return trainingNote;
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
	public void setGroupNO(String groupNO){
		this.groupNO=groupNO;
	}
	public String getGroupNO(){
		return groupNO;
	}
	
	
	public String gettTools() {
		return tTools;
	}
	public void settTools(String tTools) {
		this.tTools = tTools;
	}
	public String gettReward() {
		return tReward;
	}
	public void settReward(String tReward) {
		this.tReward = tReward;
	}
	public String gettAttention() {
		return tAttention;
	}
	public void settAttention(String tAttention) {
		this.tAttention = tAttention;
	}
	public String gettWorker() {
		return tWorker;
	}
	public void settWorker(String tWorker) {
		this.tWorker = tWorker;
	}
	public Date gettWorkDate() {
		return tWorkDate;
	}
	public void settWorkDate(Date tWorkDate) {
		this.tWorkDate = tWorkDate;
	}
	public String gettSuggest() {
		return tSuggest;
	}
	public void settSuggest(String tSuggest) {
		this.tSuggest = tSuggest;
	}
	public String gettHandler() {
		return tHandler;
	}
	public void settHandler(String tHandler) {
		this.tHandler = tHandler;
	}
	public Date gettHandleDate() {
		return tHandleDate;
	}
	public void settHandleDate(Date tHandleDate) {
		this.tHandleDate = tHandleDate;
	}
	public String gettHandleSuggest() {
		return tHandleSuggest;
	}
	public void settHandleSuggest(String tHandleSuggest) {
		this.tHandleSuggest = tHandleSuggest;
	}
	public String getrTools() {
		return rTools;
	}
	public void setrTools(String rTools) {
		this.rTools = rTools;
	}
	public String getrWorker() {
		return rWorker;
	}
	public void setrWorker(String rWorker) {
		this.rWorker = rWorker;
	}
	public Date getrWorkDate() {
		return rWorkDate;
	}
	public void setrWorkDate(Date rWorkDate) {
		this.rWorkDate = rWorkDate;
	}
	public String getrSuggest() {
		return rSuggest;
	}
	public void setrSuggest(String rSuggest) {
		this.rSuggest = rSuggest;
	}
	public String getrHandler() {
		return rHandler;
	}
	public void setrHandler(String rHandler) {
		this.rHandler = rHandler;
	}
	public Date getrHandleDate() {
		return rHandleDate;
	}
	public void setrHandleDate(Date rHandleDate) {
		this.rHandleDate = rHandleDate;
	}
	public String getrHandleSuggest() {
		return rHandleSuggest;
	}
	public void setrHandleSuggest(String rHandleSuggest) {
		this.rHandleSuggest = rHandleSuggest;
	}
	public String getBeginDate_str() {
		try {
			return beginDate == null || "".equals(beginDate) ? ""
					: ToolsUtils.getDateStringByFormat(beginDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
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
			e.printStackTrace();
			return null;
		}
	}
	public void setEndDate_str(String endDate_str) {
		this.endDate_str = endDate_str;
	}
	public String gettWorkDate_str() {
		try {
			return tWorkDate == null || "".equals(tWorkDate) ? ""
					: ToolsUtils.getDateStringByFormat(tWorkDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void settWorkDate_str(String tWorkDate_str) {
		this.tWorkDate_str = tWorkDate_str;
	}
	public String gettHandleDate_str() {
		try {
			return tHandleDate == null || "".equals(tHandleDate) ? ""
					: ToolsUtils.getDateStringByFormat(tHandleDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void settHandleDate_str(String tHandleDate_str) {
		this.tHandleDate_str = tHandleDate_str;
	}
	public String getrWorkDate_str() {
		try {
			return rWorkDate == null || "".equals(rWorkDate) ? ""
					: ToolsUtils.getDateStringByFormat(rWorkDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setrWorkDate_str(String rWorkDate_str) {
		this.rWorkDate_str = rWorkDate_str;
	}
	public String getrHandleDate_str() {
		try {
			return rHandleDate == null || "".equals(rHandleDate) ? ""
					: ToolsUtils.getDateStringByFormat(rHandleDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setrHandleDate_str(String rHandleDate_str) {
		this.rHandleDate_str = rHandleDate_str;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingReview [reviewID="+reviewID+",recordID="+recordID+",workder="+workder+",beginDate="+beginDate+",endDate="+endDate+",beginWeek="+beginWeek+",beginNoon="+beginNoon+",endWeek="+endWeek+",endNoon="+endNoon+",task="+task+",interactive="+interactive+",activity="+activity+",tTools="+tTools+",tReward="+tReward+",tAttention="+tAttention+",tWorker="+tWorker+",tWorkDate="+tWorkDate+",tSuggest="+tSuggest+",tHandler="+tHandler+",tHandleDate="+tHandleDate+",tHandleSuggest="+tHandleSuggest+",trainingNote="+trainingNote+",rTools="+rTools+",wholeReview="+wholeReview+",suggest="+suggest+",rWorker="+rWorker+",rWorkDate="+rWorkDate+",rSuggest="+rSuggest+",rHandler="+rHandler+",rHandleDate="+rHandleDate+",rHandleSuggest="+rHandleSuggest+",groupNO="+groupNO+
									",beginDate_str="+beginDate_str+",endDate_str="+endDate_str+",tWorkDate_str="+tWorkDate_str+
									",tHandleDate_str="+tHandleDate_str+",rWorkDate_str="+rWorkDate_str+",rHandleDate_str="+rHandleDate_str+"]";
	}
	
}

