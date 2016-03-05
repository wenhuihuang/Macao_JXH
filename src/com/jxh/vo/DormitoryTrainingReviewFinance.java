package com.jxh.vo;


import java.io.Serializable;
import java.math.*;


/** DormitoryTrainingReviewFinance

financeID,reviewID,inItem,inMoney,outItem,outMoney,note
?,?,?,?,?,?,?

dormitoryTrainingReviewFinance.financeID,dormitoryTrainingReviewFinance.reviewID,dormitoryTrainingReviewFinance.inItem,dormitoryTrainingReviewFinance.inMoney,dormitoryTrainingReviewFinance.outItem,dormitoryTrainingReviewFinance.outMoney,dormitoryTrainingReviewFinance.note

financeID=?,reviewID=?,inItem=?,inMoney=?,outItem=?,outMoney=?,note=?
*/
public class DormitoryTrainingReviewFinance implements Serializable {
	private static final long serialVersionUID = 1L;
	private int financeID;
	private int reviewID;
	private String inItem;
	private BigDecimal inMoney;
	private String outItem;
	private BigDecimal outMoney;
	private String note;

	public DormitoryTrainingReviewFinance(){
		super();
	}
	public DormitoryTrainingReviewFinance(int financeID, int reviewID, String inItem, BigDecimal inMoney, String outItem, BigDecimal outMoney, String note ){
		super();
		this.financeID=financeID;
		this.reviewID=reviewID;
		this.inItem=inItem;
		this.inMoney=inMoney;
		this.outItem=outItem;
		this.outMoney=outMoney;
		this.note=note;
	}
	public void setFinanceID(int financeID){
		this.financeID=financeID;
	}
	public int getFinanceID(){
		return financeID;
	}
	public void setReviewID(int reviewID){
		this.reviewID=reviewID;
	}
	public int getReviewID(){
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
		return "DormitoryTrainingReviewFinance [financeID="+financeID+",reviewID="+reviewID+",inItem="+inItem+",inMoney="+inMoney+",outItem="+outItem+",outMoney="+outMoney+",note="+note+"]";
	}
}

