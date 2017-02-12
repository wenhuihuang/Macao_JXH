package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** BCustCaseSummaryHandle
	HANDLEID	INT(10)
	SUMMARYID	INT(10)
	TIMES	INT(10)
	DISPOSEDATE	DATETIME(23,3)
	FORM	VARCHAR(50)
	NOTE	VARCHAR(128)
	WORKER	VARCHAR(32)
	CASEID	VARCHAR(20)

handleID,summaryID,times,disposeDate,form,note,worker,caseID
?,?,?,?,?,?,?,?
*/
public class BCustCaseSummaryHandle implements Serializable {
	private static final long serialVersionUID = 1L;
	private String handleID;
	private String summaryID;
	private int times;
	private Date disposeDate;
	private String form;
	private String note;
	private String worker;
	private String caseID;

	public BCustCaseSummaryHandle(){
		super();
	}
	public BCustCaseSummaryHandle(String handleID, String summaryID, int times, Date disposeDate, String form, String note, String worker, String caseID ){
		super();
		this.handleID=handleID;
		this.summaryID=summaryID;
		this.times=times;
		this.disposeDate=disposeDate;
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
	public void setCaseID(String caseID){
		this.caseID=caseID;
	}
	public String getCaseID(){
		return caseID;
	}
	@Override
	public String toString(){
		return "BCustCaseSummaryHandle [handleID="+handleID+",summaryID="+summaryID+",times="+times+",disposeDate="+disposeDate+",form="+form+",note="+note+",worker="+worker+",caseID="+caseID+"]";
	}
}
