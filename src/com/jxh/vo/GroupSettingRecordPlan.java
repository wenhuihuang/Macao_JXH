package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** GroupSettingRecordPlan

planID,recordID,actNO,actName,billDate,process,note,time
?,?,?,?,?,?,?,?

groupSettingRecordPlan.planID,groupSettingRecordPlan.recordID,groupSettingRecordPlan.actNO,groupSettingRecordPlan.actName,groupSettingRecordPlan.billDate,groupSettingRecordPlan.process,groupSettingRecordPlan.note,groupSettingRecordPlan.time

planID=?,recordID=?,actNO=?,actName=?,billDate=?,process=?,note=?,time=?
*/
public class GroupSettingRecordPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int planID;
	private String recordID;
	private String actNO;
	private String actName;
	private Date billDate;
	private String process;
	private String note;
	private String time;

	public GroupSettingRecordPlan(){
		super();
	}
	public GroupSettingRecordPlan(int planID, String recordID, String actNO, String actName, Date billDate, String process, String note,String time ){
		super();
		this.planID=planID;
		this.recordID=recordID;
		this.actNO=actNO;
		this.actName=actName;
		this.billDate=billDate;
		this.process=process;
		this.note=note;
		this.time=time;
	}
	public void setPlanID(int planID){
		this.planID=planID;
	}
	public int getPlanID(){
		return planID;
	}
	public void setRecordID(String recordID){
		this.recordID=recordID;
	}
	public String getRecordID(){
		return recordID;
	}
	public void setActNO(String actNO){
		this.actNO=actNO;
	}
	public String getActNO(){
		return actNO;
	}
	public void setActName(String actName){
		this.actName=actName;
	}
	public String getActName(){
		return actName;
	}
	public void setBillDate(Date billDate){
		this.billDate=billDate;
	}
	public Date getBillDate(){
		return billDate;
	}
	public void setProcess(String process){
		this.process=process;
	}
	public String getProcess(){
		return process;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString(){
		return "GroupSettingRecordPlan [planID="+planID+",recordID="+recordID+",actNO="+actNO+",actName="+actName+",billDate="+billDate+",process="+process+",note="+note+",time="+time+"]";
	}
}

