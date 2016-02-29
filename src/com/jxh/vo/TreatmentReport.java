package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;


/** TreatmentReport

reportID,treatmentID,reason,performance,suggest,summary,handler,handleDate,handleSuggest,closeDate,custID
?,?,?,?,?,?,?,?,?,?,?

treatmentReport.reportID,treatmentReport.treatmentID,treatmentReport.reason,treatmentReport.performance,treatmentReport.suggest,treatmentReport.summary,treatmentReport.handler,treatmentReport.handleDate,treatmentReport.handleSuggest,treatmentReport.closeDate,custID

reportID=?,treatmentID=?,reason=?,performance=?,suggest=?,summary=?,handler=?,handleDate=?,handleSuggest=?,closeDate=?,custID=?
*/
public class TreatmentReport implements Serializable {
	private static final long serialVersionUID = 1L;
	private int reportID;
	private String treatmentID;
	private String reason;
	private String performance;
	private String suggest;
	private String summary;
	private String handler;
	private Date handleDate;
	private String handleSuggest;
	private Date closeDate;
	private String custID;

	public TreatmentReport(){
		super();
	}
	public TreatmentReport(int reportID, String treatmentID, String reason, String performance, String suggest, String summary, String handler, Date handleDate, String handleSuggest,Date closeDate,String custID ){
		super();
		this.reportID=reportID;
		this.treatmentID=treatmentID;
		this.reason=reason;
		this.performance=performance;
		this.suggest=suggest;
		this.summary=summary;
		this.handler=handler;
		this.handleDate=handleDate;
		this.handleSuggest=handleSuggest;
		this.closeDate=closeDate;
		this.custID=custID;
	}
	public void setReportID(int reportID){
		this.reportID=reportID;
	}
	public int getReportID(){
		return reportID;
	}
	public void setTreatmentID(String treatmentID){
		this.treatmentID=treatmentID;
	}
	public String getTreatmentID(){
		return treatmentID;
	}
	public void setReason(String reason){
		this.reason=reason;
	}
	public String getReason(){
		return reason;
	}
	public void setPerformance(String performance){
		this.performance=performance;
	}
	public String getPerformance(){
		return performance;
	}
	public void setSuggest(String suggest){
		this.suggest=suggest;
	}
	public String getSuggest(){
		return suggest;
	}
	public void setSummary(String summary){
		this.summary=summary;
	}
	public String getSummary(){
		return summary;
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
	
	
	
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	
	
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	@Override
	public String toString(){
		return "TreatmentReport [reportID="+reportID+",treatmentID="+treatmentID+",reason="+reason+",performance="+performance+",suggest="+suggest+",summary="+summary+",handler="+handler+",handleDate="+handleDate+",handleSuggest="+handleSuggest+",closeDate="+closeDate+",custID="+custID+"]";
	}
}

