package com.jxh.pojo;

import java.io.Serializable;

public class DormitoryTrainingReviewDetailPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int detailID;
	private String reviewID;
	private String custID;
	private String schedule;
	private String performance;
	private String note;

	private String fullName;

	public DormitoryTrainingReviewDetailPojo() {
		super();
	}

	public DormitoryTrainingReviewDetailPojo(int detailID, String reviewID, String custID, String schedule,
			String performance, String note, String fullName) {
		super();
		this.detailID = detailID;
		this.reviewID = reviewID;
		this.custID = custID;
		this.schedule = schedule;
		this.performance = performance;
		this.note = note;
		this.fullName = fullName;
	}

	public void setDetailID(int detailID) {
		this.detailID = detailID;
	}

	public int getDetailID() {
		return detailID;
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

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getPerformance() {
		return performance;
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
		return "DormitoryTrainingReviewDetail [detailID=" + detailID + ",reviewID=" + reviewID + ",custID=" + custID
				+ ",schedule=" + schedule + ",performance=" + performance + ",note=" + note + ",fullName=" + fullName
				+ "]";
	}

}
