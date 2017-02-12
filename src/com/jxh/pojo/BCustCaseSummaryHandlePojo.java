package com.jxh.pojo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;


public class BCustCaseSummaryHandlePojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String handleID;
	private String summaryID;
	private int times;
	private Date disposeDate;
	private String disposeDate_str;
	private String form;
	private String note;
	private String worker;
	private String caseID;

	public BCustCaseSummaryHandlePojo(){
		super();
	}
	public BCustCaseSummaryHandlePojo(String handleID, String summaryID, int times, Date disposeDate, String disposeDate_str, String form, String note, String worker, String caseID ){
		super();
		this.handleID=handleID;
		this.summaryID=summaryID;
		this.times=times;
		this.disposeDate=disposeDate;
		this.disposeDate_str = disposeDate_str;
		this.form=form;
		this.note=note;
		this.worker=worker;
		this.caseID=caseID;
	}
	public void setHandleID(String handleID){
		this.handleID=handleID;
	}
	public String getHandleID(){
		return handleID;
	}
	public void setSummaryID(String summaryID){
		this.summaryID=summaryID;
	}
	public String getSummaryID(){
		return summaryID;
	}
	public void setTimes(int times){
		this.times=times;
	}
	public int getTimes(){
		return times;
	}
	public void setDisposeDate(Date disposeDate){
		this.disposeDate=disposeDate;
	}
	public Date getDisposeDate(){
		return disposeDate;
	}
	public void setForm(String form){
		this.form=form;
	}
	public String getForm(){
		return form;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public void setWorker(String worker){
		this.worker=worker;
	}
	public String getWorker(){
		return worker;
	}
	
	
	public String getDisposeDate_str() {
		return disposeDate_str;
	}
	public void setDisposeDate_str(String disposeDate_str) {
		this.disposeDate_str = disposeDate_str;
	}
	
	
	
	public String getCaseID() {
		return caseID;
	}
	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}
	@Override
	public String toString(){
		return "BCustCaseSummaryHandle [handleID="+handleID+",summaryID="+summaryID+",times="+times+",disposeDate="+disposeDate+",disposeDate_str=" + disposeDate_str + ",form="+form+",note="+note+",worker="+worker+ ",caseID="+caseID+"]";
	}
}
