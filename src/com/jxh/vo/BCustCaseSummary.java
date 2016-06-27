package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;


/** BCustCaseSummary
	SUMMARYID	INT(10)
	CASENO	VARCHAR(32)
	CASEID	VARCHAR(20)
	CLOSEWORKER	VARCHAR(20)
	CUSTID	VARCHAR(20)
	SUMMARYDETAIL	TEXT(2147483647)
	SUMMARYNEED	TEXT(2147483647)
	MANAGER	VARCHAR(32)
	MANAGEDATE	DATETIME(23,3)
	MANAGESUGGEST	TEXT(2147483647)
	CLOSEDATE	DATETIME(23,3)
*/
public class BCustCaseSummary implements Serializable {
	private static final long serialVersionUID = 1L;
	private String summaryID;
	private String caseNO;
	private String caseID;
	private String closeWorker;
	private String custID;
	private String summaryDetail;
	private String summaryNeed;
	private String manager;
	private Date manageDate;
	private String manageSuggest;
	private Date closeDate;
	private String closePeople;

	public BCustCaseSummary(){
		super();
	}
	public BCustCaseSummary(String summaryID, String caseNO, String caseID, String closeWorker, String custID, String summaryDetail, String summaryNeed, String manager, Date manageDate, String manageSuggest, Date closeDate, String closePeople ){
		super();
		this.summaryID=summaryID;
		this.caseNO=caseNO;
		this.caseID = caseID;
		this.closeWorker=closeWorker;
		this.custID=custID;
		this.summaryDetail=summaryDetail;
		this.summaryNeed=summaryNeed;
		this.manager=manager;
		this.manageDate=manageDate;
		this.manageSuggest=manageSuggest;
		this.closeDate=closeDate;
		this.closePeople=closePeople;
	}
	public void setSummaryID(String summaryID){
		this.summaryID=summaryID;
	}
	public String getSummaryID(){
		return summaryID;
	}
	public void setCaseNO(String caseNO){
		this.caseNO=caseNO;
	}
	public String getCaseNO(){
		return caseNO;
	}
	public void setCloseWorker(String closeWorker){
		this.closeWorker=closeWorker;
	}
	public String getCloseWorker(){
		return closeWorker;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setSummaryDetail(String summaryDetail){
		this.summaryDetail=summaryDetail;
	}
	public String getSummaryDetail(){
		return summaryDetail;
	}
	public void setSummaryNeed(String summaryNeed){
		this.summaryNeed=summaryNeed;
	}
	public String getSummaryNeed(){
		return summaryNeed;
	}
	public void setManager(String manager){
		this.manager=manager;
	}
	public String getManager(){
		return manager;
	}
	public void setManageDate(Date manageDate){
		this.manageDate=manageDate;
	}
	public Date getManageDate(){
		return manageDate;
	}
	public void setManageSuggest(String manageSuggest){
		this.manageSuggest=manageSuggest;
	}
	public String getManageSuggest(){
		return manageSuggest;
	}
	public void setCloseDate(Date closeDate){
		this.closeDate=closeDate;
	}
	public Date getCloseDate(){
		return closeDate;
	}
	
	
	
	public String getCaseID() {
		return caseID;
	}
	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}
	
	
	
	public String getClosePeople() {
		return closePeople;
	}
	public void setClosePeople(String closePeople) {
		this.closePeople = closePeople;
	}
	@Override
	public String toString(){
		return "BCustCaseSummary [summaryID="+summaryID+",caseNO="+caseNO+",caseID=" + caseID + ",closeWorker="+closeWorker+",custID="+custID+",summaryDetail="+summaryDetail+",summaryNeed="+summaryNeed+",manager="+manager+",manageDate="+manageDate+",manageSuggest="+manageSuggest+",closeDate="+closeDate+",closePeople="+closePeople+"]";
	}
}
