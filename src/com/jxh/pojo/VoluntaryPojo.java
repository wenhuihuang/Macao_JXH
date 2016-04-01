package com.jxh.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.math.*;
import java.text.ParseException;

public class VoluntaryPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String workID;
	private String work;
	private String note;

	private String custID;

	private String actName;
	private String actNO;

	public VoluntaryPojo() {
		super();
	}

	public VoluntaryPojo(String workID, String work, String note, String custID, String actName, String actNO) {
		super();
		this.workID = workID;
		this.work = work;
		this.note = note;
		this.custID = custID;
		this.actName = actName;
		this.actNO = actNO;
	}

	public void setWorkID(String workID) {
		this.workID = workID;
	}

	public String getWorkID() {
		return workID;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getWork() {
		return work;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getActNO() {
		return actNO;
	}

	public void setActNO(String actNO) {
		this.actNO = actNO;
	}

	@Override
	public String toString() {
		return "SocialWork [workID=" + workID + ",work=" + work + ",note=" + note + ",custID=" + custID + ",actName="
				+ actName + ",actNO=" + actNO + "]";
	}

}
