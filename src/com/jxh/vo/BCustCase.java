package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;


/** bCustCase

caseID,caseNO,ReceiveDate,caseWorker,caseStatus,caseSource,caseSourceDetail,custID,custNO,custNewNO,economics,caseProblem,problemDate,problemAdmin,caseRequest,requestDate,requestAdmin,caseAction,actionDate,actionAdmin,initAssess,initAssessDetail,suggest,handler,handleDate,handleWay,handleWayDetail,handleSuggest,note,disposeWorker
?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?
*/
public class BCustCase implements Serializable {
	private static final long serialVersionUID = 1L;
	private String caseID;
	private String caseNO;
	private Date receiveDate;
	private String caseWorker;
	private int caseStatus;
	private int caseSource;
	private String caseSourceDetail;
	private String custID;
	private String custNO;
	private String custNewNO;
	private String economics;
	private String caseProblem;
	private Date problemDate;
	private String problemAdmin;
	private String caseRequest;
	private Date requestDate;
	private String requestAdmin;
	private String caseAction;
	private Date actionDate;
	private String actionAdmin;
	private int initAssess;
	private String initAssessDetail;
	private int suggest;
	private String handler;
	private Date handleDate;
	private int handleWay;
	private String handleWayDetail;
	private String handleSuggest;
	private String note;
	private String disposeWorker;

	public BCustCase(){
		super();
	}
	public BCustCase(String caseID, String caseNO, Date receiveDate, String caseWorker, int caseStatus, int caseSource, String caseSourceDetail, String custID, String custNO, String custNewNO, String economics, String caseProblem, Date problemDate, String problemAdmin, String caseRequest, Date requestDate, String requestAdmin, String caseAction, Date actionDate, String actionAdmin, int initAssess, String initAssessDetail, int suggest, String handler, Date handleDate, int handleWay, String handleWayDetail, String handleSuggest, String note, String disposeWorker ){
		super();
		this.caseID=caseID;
		this.caseNO=caseNO;
		this.receiveDate=receiveDate;
		this.caseWorker=caseWorker;
		this.caseStatus=caseStatus;
		this.caseSource=caseSource;
		this.caseSourceDetail=caseSourceDetail;
		this.custID=custID;
		this.custNO=custNO;
		this.custNewNO=custNewNO;
		this.economics=economics;
		this.caseProblem=caseProblem;
		this.problemDate=problemDate;
		this.problemAdmin=problemAdmin;
		this.caseRequest=caseRequest;
		this.requestDate=requestDate;
		this.requestAdmin=requestAdmin;
		this.caseAction=caseAction;
		this.actionDate=actionDate;
		this.actionAdmin=actionAdmin;
		this.initAssess=initAssess;
		this.initAssessDetail=initAssessDetail;
		this.suggest=suggest;
		this.handler=handler;
		this.handleDate=handleDate;
		this.handleWay=handleWay;
		this.handleWayDetail=handleWayDetail;
		this.handleSuggest=handleSuggest;
		this.note=note;
		this.disposeWorker=disposeWorker;
	}
	public void setCaseID(String caseID){
		this.caseID=caseID;
	}
	public String getCaseID(){
		return caseID;
	}
	public void setCaseNO(String caseNO){
		this.caseNO=caseNO;
	}
	public String getCaseNO(){
		return caseNO;
	}
	public void setReceiveDate(Date receiveDate){
		this.receiveDate=receiveDate;
	}
	public Date getReceiveDate(){
		return receiveDate;
	}
	public void setCaseWorker(String caseWorker){
		this.caseWorker=caseWorker;
	}
	public String getCaseWorker(){
		return caseWorker;
	}
	public void setCaseStatus(int caseStatus){
		this.caseStatus=caseStatus;
	}
	public int getCaseStatus(){
		return caseStatus;
	}
	public void setCaseSource(int caseSource){
		this.caseSource=caseSource;
	}
	public int getCaseSource(){
		return caseSource;
	}
	public void setCaseSourceDetail(String caseSourceDetail){
		this.caseSourceDetail=caseSourceDetail;
	}
	public String getCaseSourceDetail(){
		return caseSourceDetail;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setCustNO(String custNO){
		this.custNO=custNO;
	}
	public String getCustNO(){
		return custNO;
	}
	public void setCustNewNO(String custNewNO){
		this.custNewNO=custNewNO;
	}
	public String getCustNewNO(){
		return custNewNO;
	}
	public void setEconomics(String economics){
		this.economics=economics;
	}
	public String getEconomics(){
		return economics;
	}
	public void setCaseProblem(String caseProblem){
		this.caseProblem=caseProblem;
	}
	public String getCaseProblem(){
		return caseProblem;
	}
	public void setProblemDate(Date problemDate){
		this.problemDate=problemDate;
	}
	public Date getProblemDate(){
		return problemDate;
	}
	public void setProblemAdmin(String problemAdmin){
		this.problemAdmin=problemAdmin;
	}
	public String getProblemAdmin(){
		return problemAdmin;
	}
	public void setCaseRequest(String caseRequest){
		this.caseRequest=caseRequest;
	}
	public String getCaseRequest(){
		return caseRequest;
	}
	public void setRequestDate(Date requestDate){
		this.requestDate=requestDate;
	}
	public Date getRequestDate(){
		return requestDate;
	}
	public void setRequestAdmin(String requestAdmin){
		this.requestAdmin=requestAdmin;
	}
	public String getRequestAdmin(){
		return requestAdmin;
	}
	public void setCaseAction(String caseAction){
		this.caseAction=caseAction;
	}
	public String getCaseAction(){
		return caseAction;
	}
	public void setActionDate(Date actionDate){
		this.actionDate=actionDate;
	}
	public Date getActionDate(){
		return actionDate;
	}
	public void setActionAdmin(String actionAdmin){
		this.actionAdmin=actionAdmin;
	}
	public String getActionAdmin(){
		return actionAdmin;
	}
	public void setInitAssess(int initAssess){
		this.initAssess=initAssess;
	}
	public int getInitAssess(){
		return initAssess;
	}
	public void setInitAssessDetail(String initAssessDetail){
		this.initAssessDetail=initAssessDetail;
	}
	public String getInitAssessDetail(){
		return initAssessDetail;
	}
	public void setSuggest(int suggest){
		this.suggest=suggest;
	}
	public int getSuggest(){
		return suggest;
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
	public void setHandleWay(int handleWay){
		this.handleWay=handleWay;
	}
	public int getHandleWay(){
		return handleWay;
	}
	public void setHandleWayDetail(String handleWayDetail){
		this.handleWayDetail=handleWayDetail;
	}
	public String getHandleWayDetail(){
		return handleWayDetail;
	}
	public void setHandleSuggest(String handleSuggest){
		this.handleSuggest=handleSuggest;
	}
	public String getHandleSuggest(){
		return handleSuggest;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public void setDisposeWorker(String disposeWorker){
		this.disposeWorker=disposeWorker;
	}
	public String getDisposeWorker(){
		return disposeWorker;
	}
	@Override
	public String toString(){
		return "BCustCase [caseID="+caseID+",caseNO="+caseNO+",receiveDate="+receiveDate+",caseWorker="+caseWorker+",caseStatus="+caseStatus+",caseSource="+caseSource+",caseSourceDetail="+caseSourceDetail+",custID="+custID+",custNO="+custNO+",custNewNO="+custNewNO+",economics="+economics+",caseProblem="+caseProblem+",problemDate="+problemDate+",problemAdmin="+problemAdmin+",caseRequest="+caseRequest+",requestDate="+requestDate+",requestAdmin="+requestAdmin+",caseAction="+caseAction+",actionDate="+actionDate+",actionAdmin="+actionAdmin+",initAssess="+initAssess+",initAssessDetail="+initAssessDetail+",suggest="+suggest+",handler="+handler+",handleDate="+handleDate+",handleWay="+handleWay+",handleWayDetail="+handleWayDetail+",handleSuggest="+handleSuggest+",note="+note+",disposeWorker="+disposeWorker+"]";
	}
}