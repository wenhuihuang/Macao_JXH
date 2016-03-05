package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** DormitoryTrainingADPlanDetail

planID,planMasterID,billDate,living,item,type,content,time,note
?,?,?,?,?,?,?,?,?

dormitoryTrainingADPlanDetail.planID,dormitoryTrainingADPlanDetail.planMasterID,dormitoryTrainingADPlanDetail.billDate,dormitoryTrainingADPlanDetail.living,dormitoryTrainingADPlanDetail.item,dormitoryTrainingADPlanDetail.type,dormitoryTrainingADPlanDetail.content,dormitoryTrainingADPlanDetail.time,dormitoryTrainingADPlanDetail.note

planID=?,planMasterID=?,billDate=?,living=?,item=?,type=?,content=?,time=?,note=?
*/
public class DormitoryTrainingADPlanDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private int planID;
	private int planMasterID;
	private Date billDate;
	private String living;
	private String item;
	private String type;
	private String content;
	private int time;
	private String note;

	public DormitoryTrainingADPlanDetail(){
		super();
	}
	public DormitoryTrainingADPlanDetail(int planID, int planMasterID, Date billDate, String living, String item, String type, String content, int time, String note ){
		super();
		this.planID=planID;
		this.planMasterID=planMasterID;
		this.billDate=billDate;
		this.living=living;
		this.item=item;
		this.type=type;
		this.content=content;
		this.time=time;
		this.note=note;
	}
	public void setPlanID(int planID){
		this.planID=planID;
	}
	public int getPlanID(){
		return planID;
	}
	public void setPlanMasterID(int planMasterID){
		this.planMasterID=planMasterID;
	}
	public int getPlanMasterID(){
		return planMasterID;
	}
	public void setBillDate(Date billDate){
		this.billDate=billDate;
	}
	public Date getBillDate(){
		return billDate;
	}
	public void setLiving(String living){
		this.living=living;
	}
	public String getLiving(){
		return living;
	}
	public void setItem(String item){
		this.item=item;
	}
	public String getItem(){
		return item;
	}
	public void setType(String type){
		this.type=type;
	}
	public String getType(){
		return type;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setTime(int time){
		this.time=time;
	}
	public int getTime(){
		return time;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingADPlanDetail [planID="+planID+",planMasterID="+planMasterID+",billDate="+billDate+",living="+living+",item="+item+",type="+type+",content="+content+",time="+time+",note="+note+"]";
	}
}

