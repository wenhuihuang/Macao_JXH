package com.jxh.vo;


import java.io.Serializable;
import java.math.*;


/** DormitoryTrainingReviewSettle

settleID,reviewID,inItem,inMoney,outItem,outMoney,note
?,?,?,?,?,?,?

dormitoryTrainingReviewSettle.settleID,dormitoryTrainingReviewSettle.reviewID,dormitoryTrainingReviewSettle.inItem,dormitoryTrainingReviewSettle.inMoney,dormitoryTrainingReviewSettle.outItem,dormitoryTrainingReviewSettle.outMoney,dormitoryTrainingReviewSettle.note

settleID=?,reviewID=?,inItem=?,inMoney=?,outItem=?,outMoney=?,note=?
*/
public class DormitoryTrainingReviewSettle implements Serializable {
	private static final long serialVersionUID = 1L;
	private int settleID;
	private String reviewID;
	private String inItem;
	private BigDecimal inMoney;
	private String outItem;
	private BigDecimal outMoney;
	private String note;

	public DormitoryTrainingReviewSettle(){
		super();
	}
	public DormitoryTrainingReviewSettle(int settleID, String reviewID, String inItem, BigDecimal inMoney, String outItem, BigDecimal outMoney, String note ){
		super();
		this.settleID=settleID;
		this.reviewID=reviewID;
		this.inItem=inItem;
		this.inMoney=inMoney;
		this.outItem=outItem;
		this.outMoney=outMoney;
		this.note=note;
	}
	public void setSettleID(int settleID){
		this.settleID=settleID;
	}
	public int getSettleID(){
		return settleID;
	}
	public void setReviewID(String reviewID){
		this.reviewID=reviewID;
	}
	public String getReviewID(){
		return reviewID;
	}
	public void setInItem(String inItem){
		this.inItem=inItem;
	}
	public String getInItem(){
		return inItem;
	}
	public void setInMoney(BigDecimal inMoney){
		this.inMoney=inMoney;
	}
	public BigDecimal getInMoney(){
		return inMoney;
	}
	public void setOutItem(String outItem){
		this.outItem=outItem;
	}
	public String getOutItem(){
		return outItem;
	}
	public void setOutMoney(BigDecimal outMoney){
		this.outMoney=outMoney;
	}
	public BigDecimal getOutMoney(){
		return outMoney;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingReviewSettle [settleID="+settleID+",reviewID="+reviewID+",inItem="+inItem+",inMoney="+inMoney+",outItem="+outItem+",outMoney="+outMoney+",note="+note+"]";
	}
}

