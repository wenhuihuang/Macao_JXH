package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.math.*;
import java.text.ParseException;

/**
 * SocialWork
 * 
 * workID,work,workNO,note,custID
 * ?,?,?,?,?
 * 
 * socialWork.workID,socialWork.work,socialWork.workNO,socialWork.note,socialWork.custID
 * 
 * workID=?,work=?,workNO=?,note=?,custID=?
 */
public class SocialWork implements Serializable {
	private static final long serialVersionUID = 1L;
	private String workID;
	private String work;
	private String workNO;
	private String note;

	private String custID;


	public SocialWork() {
		super();
	}

	public SocialWork(String workID, String work,
			String workNO, String note, String custID) {
		super();
		this.workID = workID;
		this.work = work;
		this.workNO = workNO;
		this.note = note;
		this.custID = custID;
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

	public void setWorkNO(String workNO) {
		this.workNO = workNO;
	}

	public String getWorkNO() {
		return workNO;
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


	@Override
	public String toString() {
		return "SocialWork [workID=" + workID + ",work=" + work + ",workNO=" + workNO + ",note=" + note
				+ ",custID=" + custID + "]";
	}

}
