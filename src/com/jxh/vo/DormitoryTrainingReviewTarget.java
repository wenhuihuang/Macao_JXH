package com.jxh.vo;


import java.io.Serializable;

/** DormitoryTrainingReviewTarget

targetID,reviewID,custID,target,assess,note
?,?,?,?,?,?

dormitoryTrainingReviewTarget.targetID,dormitoryTrainingReviewTarget.reviewID,dormitoryTrainingReviewTarget.custID,dormitoryTrainingReviewTarget.target,dormitoryTrainingReviewTarget.assess,dormitoryTrainingReviewTarget.note

targetID=?,reviewID=?,custID=?,target=?,assess=?,note=?
*/
public class DormitoryTrainingReviewTarget implements Serializable {
	private static final long serialVersionUID = 1L;
	private int targetID;
	private String reviewID;
	private String custID;
	private String target;
	private String assess;
	private String note;

	public DormitoryTrainingReviewTarget(){
		super();
	}
	public DormitoryTrainingReviewTarget(int targetID, String reviewID, String custID, String target, String assess, String note ){
		super();
		this.targetID=targetID;
		this.reviewID=reviewID;
		this.custID=custID;
		this.target=target;
		this.assess=assess;
		this.note=note;
	}
	public void setTargetID(int targetID){
		this.targetID=targetID;
	}
	public int getTargetID(){
		return targetID;
	}
	public void setReviewID(String reviewID){
		this.reviewID=reviewID;
	}
	public String getReviewID(){
		return reviewID;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setTarget(String target){
		this.target=target;
	}
	public String getTarget(){
		return target;
	}
	public void setAssess(String assess){
		this.assess=assess;
	}
	public String getAssess(){
		return assess;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingReviewTarget [targetID="+targetID+",reviewID="+reviewID+",custID="+custID+",target="+target+",assess="+assess+",note="+note+"]";
	}
}

