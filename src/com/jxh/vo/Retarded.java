package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;



public class Retarded implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String retardedID;
	private int retardedType ;
	private  int retardedDegree;
	private int hasRetardedReport;
	private int retardedReportSource;
	private Date assessDate;
	private String  note;
	private String custId;
	
	
	public Retarded() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Retarded(String retardedID, int retardedType, int retardedDegree, int hasRetardedReport,
			int retardedReportSource, Date assessDate, String note, String custId) {
		super();
		this.retardedID = retardedID;
		this.retardedType = retardedType;
		this.retardedDegree = retardedDegree;
		this.hasRetardedReport = hasRetardedReport;
		this.retardedReportSource = retardedReportSource;
		this.assessDate = assessDate;
		this.note = note;
		this.custId = custId;
	
	}

	public String getRetardedID() {
		return retardedID;
	}
	public void setRetardedID(String retardedID) {
		this.retardedID = retardedID;
	}
	public int getRetardedType() {
		return retardedType;
	}
	public void setRetardedType(int retardedType) {
		this.retardedType = retardedType;
	}
	public int getRetardedDegree() {
		return retardedDegree;
	}
	public void setRetardedDegree(int retardedDegree) {
		this.retardedDegree = retardedDegree;
	}
	public int getHasRetardedReport() {
		return hasRetardedReport;
	}
	public void setHasRetardedReport(int hasRetardedReport) {
		this.hasRetardedReport = hasRetardedReport;
	}
	public int getRetardedReportSource() {
		return retardedReportSource;
	}
	public void setRetardedReportSource(int retardedReportSource) {
		this.retardedReportSource = retardedReportSource;
	}
	public Date getAssessDate() {
		return assessDate;
	}
	public void setAssessDate(Date assessDate) {
		this.assessDate = assessDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Retarded [retardedID=" + retardedID + ", retardedType=" + retardedType + ", retardedDegree="
				+ retardedDegree + ", hasRetardedReport=" + hasRetardedReport + ", retardedReportSource="
				+ retardedReportSource + ", assessDate=" + assessDate + ", note=" + note + ", custId=" + custId + "]";
	}

	
	
}
