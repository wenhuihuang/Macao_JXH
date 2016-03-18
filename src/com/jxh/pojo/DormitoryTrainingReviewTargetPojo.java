package com.jxh.pojo;

import java.io.Serializable;

public class DormitoryTrainingReviewTargetPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int targetID;
	private String reviewID;
	private String custID;
	private String target;
	private String assess;
	private String note;

	private String fullName;

	public DormitoryTrainingReviewTargetPojo() {
		super();
	}

	public DormitoryTrainingReviewTargetPojo(int targetID, String reviewID, String custID, String target, String assess,
			String note, String fullName) {
		super();
		this.targetID = targetID;
		this.reviewID = reviewID;
		this.custID = custID;
		this.target = target;
		this.assess = assess;
		this.note = note;
		this.fullName = fullName;
	}

	public void setTargetID(int targetID) {
		this.targetID = targetID;
	}

	public int getTargetID() {
		return targetID;
	}

	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}

	public String getReviewID() {
		return reviewID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getCustID() {
		return custID;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTarget() {
		return target;
	}

	public void setAssess(String assess) {
		this.assess = assess;
	}

	public String getAssess() {
		return assess;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "DormitoryTrainingReviewTarget [targetID=" + targetID + ",reviewID=" + reviewID + ",custID=" + custID
				+ ",target=" + target + ",assess=" + assess + ",note=" + note + ",fullName=" + fullName + "]";
	}
}
