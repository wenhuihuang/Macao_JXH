package com.jxh.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.sql.*;
import java.text.ParseException;
import java.math.*;


/** BCustCaseRecord
	RECORDID	INT(10)
	CUSTID	VARCHAR(20)
	FULLNAME	VARCHAR(32)
	BILLDATE	DATETIME(23,3)
	BILLTIME	VARCHAR(20)
	FORM	VARCHAR(20)
	PLACE	VARCHAR(128)
	FAMILY	VARCHAR(100)
	OTHERMAN	VARCHAR(100)
	TIMES	INT(10)
	RECORDADMIN	VARCHAR(20)
	TITLE	TEXT(2147483647)
	CONTENT	TEXT(2147483647)
	ANALYSIS	TEXT(2147483647)
	WAYS	TEXT(2147483647)
	HANDLER	VARCHAR(32)
	HANDLDATE	DATETIME(23,3)
	HANDLSUGGEST	TEXT(2147483647)
*/
public class BCustCaseRecordPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordID;
	private String custID;
	private String fullName;
	private Date talksDate;
	private String talksDate_str;
	private String talksTime;
	private String form;
	private String place;
	private String family;
	private String otherMan;
	private int times;
	private String recordAdmin;
	private String title;
	private String content;
	private String analysis;
	private String ways;
	private String handler;
	private Date handlDate;
	private String handlDate_str;
	private String handlSuggest;
	private String caseID;

	public BCustCaseRecordPojo(){
		super();
	}
	public BCustCaseRecordPojo(String recordID, String custID, String fullName, Date talksDate, String talksDate_str, String talksTime, String form, String place, String family, String otherMan, int times, String recordAdmin, String title, String content, String analysis, String ways, String handler, Date handlDate, String handlDate_str, String handlSuggest,String caseID ){
		super();
		this.recordID=recordID;
		this.custID=custID;
		this.fullName=fullName;
		this.talksDate=talksDate;
		this.talksDate_str = talksDate_str;
		this.talksTime=talksTime;
		this.form=form;
		this.place=place;
		this.family=family;
		this.otherMan=otherMan;
		this.times=times;
		this.recordAdmin=recordAdmin;
		this.title=title;
		this.content=content;
		this.analysis=analysis;
		this.ways=ways;
		this.handler=handler;
		this.handlDate=handlDate;
		this.handlDate_str = handlDate_str;
		this.handlSuggest=handlSuggest;
		this.caseID=caseID;
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
	public void setFullName(String fullName){
		this.fullName=fullName;
	}
	public String getFullName(){
		return fullName;
	}
	public void setTalksDate(Date talksDate){
		this.talksDate=talksDate;
	}
	public Date getTalksDate(){
		return talksDate;
	}
	public void setTalksTime(String talksTime){
		this.talksTime=talksTime;
	}
	public String getTalksTime(){
		return talksTime;
	}
	public void setForm(String form){
		this.form=form;
	}
	public String getForm(){
		return form;
	}
	public void setPlace(String place){
		this.place=place;
	}
	public String getPlace(){
		return place;
	}
	public void setFamily(String family){
		this.family=family;
	}
	public String getFamily(){
		return family;
	}
	public void setOtherMan(String otherMan){
		this.otherMan=otherMan;
	}
	public String getOtherMan(){
		return otherMan;
	}
	public void setTimes(int times){
		this.times=times;
	}
	public int getTimes(){
		return times;
	}
	public void setRecordAdmin(String recordAdmin){
		this.recordAdmin=recordAdmin;
	}
	public String getRecordAdmin(){
		return recordAdmin;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setAnalysis(String analysis){
		this.analysis=analysis;
	}
	public String getAnalysis(){
		return analysis;
	}
	public void setWays(String ways){
		this.ways=ways;
	}
	public String getWays(){
		return ways;
	}
	public void setHandler(String handler){
		this.handler=handler;
	}
	public String getHandler(){
		return handler;
	}
	public void setHandlDate(Date handlDate){
		this.handlDate=handlDate;
	}
	public Date getHandlDate(){
		return handlDate;
	}
	public void setHandlSuggest(String handlSuggest){
		this.handlSuggest=handlSuggest;
	}
	public String getHandlSuggest(){
		return handlSuggest;
	}
	
	
	
	public String getTalksDate_str() {
		try {
			return talksDate == null || "".equals(talksDate) ? ""
					: ToolsUtils.getDateStringByFormat(talksDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setTalksDate_str(String talksDate_str) {
		this.talksDate_str = talksDate_str;
	}
	
	
	
	public String getHandlDate_str() {
		try {
			return handlDate == null || "".equals(handlDate) ? ""
					: ToolsUtils.getDateStringByFormat(handlDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setHandlDate_str(String handlDate_str) {
		this.handlDate_str = handlDate_str;
	}
	
	
	
	public String getCaseID() {
		return caseID;
	}
	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}
	@Override
	public String toString(){
		return "BCustCaseRecord [recordID="+recordID+",custID="+custID+",fullName="+fullName+",talksDate="+talksDate+",talksDate_str=" + talksDate_str+",talksTime="+talksTime+",form="+form+",place="+place+",family="+family+",otherMan="+otherMan+",times="+times+",recordAdmin="+recordAdmin+",title="+title+",content="+content+",analysis="+analysis+",ways="+ways+",handler="+handler+",handlDate="+handlDate+ ",handlDate_str="+ handlDate_str +",handlSuggest="+handlSuggest+",caseID="+caseID+"]";
	}
}