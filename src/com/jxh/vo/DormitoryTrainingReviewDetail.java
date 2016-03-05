package com.jxh.vo;


import java.io.Serializable;

/** DormitoryTrainingReviewDetail

detailID,reviewID,custID,schedule,performance,note
?,?,?,?,?,?

dormitoryTrainingReviewDetail.detailID,dormitoryTrainingReviewDetail.reviewID,dormitoryTrainingReviewDetail.custID,dormitoryTrainingReviewDetail.schedule,dormitoryTrainingReviewDetail.performance,dormitoryTrainingReviewDetail.note

detailID=?,reviewID=?,custID=?,schedule=?,performance=?,note=?
*/
public class DormitoryTrainingReviewDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private int detailID;
	private int reviewID;
	private String custID;
	private String schedule;
	private String performance;
	private String note;

	public DormitoryTrainingReviewDetail(){
		super();
	}
	public DormitoryTrainingReviewDetail(int detailID, int reviewID, String custID, String schedule, String performance, String note ){
		super();
		this.detailID=detailID;
		this.reviewID=reviewID;
		this.custID=custID;
		this.schedule=schedule;
		this.performance=performance;
		this.note=note;
	}
	public void setDetailID(int detailID){
		this.detailID=detailID;
	}
	public int getDetailID(){
		return detailID;
	}
	public void setReviewID(int reviewID){
		this.reviewID=reviewID;
	}
	public int getReviewID(){
		return reviewID;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setSchedule(String schedule){
		this.schedule=schedule;
	}
	public String getSchedule(){
		return schedule;
	}
	public void setPerformance(String performance){
		this.performance=performance;
	}
	public String getPerformance(){
		return performance;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingReviewDetail [detailID="+detailID+",reviewID="+reviewID+",custID="+custID+",schedule="+schedule+",performance="+performance+",note="+note+"]";
	}
}

