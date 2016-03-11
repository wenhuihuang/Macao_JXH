package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** GroupSettingPlan

planID,gSID,actNO,actName,billDate,process,note,time
?,?,?,?,?,?,?,?

groupSettingPlan.planID,groupSettingPlan.gSID,groupSettingPlan.actNO,groupSettingPlan.actName,groupSettingPlan.billDate,groupSettingPlan.process,groupSettingPlan.note,groupSettingPlan.time

planID=?,gSID=?,actNO=?,actName=?,billDate=?,process=?,note=?,time=?
*/
public class GroupSettingPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int planID;
	private String gSID;
	private String actNO;
	private String actName;
	private Date billDate;
	private String process;
	private String note;
	private String time;

	public GroupSettingPlan(){
		super();
	}
	public GroupSettingPlan(int planID, String gSID, String actNO, String actName, Date billDate, String process, String note,String time ){
		super();
		this.planID=planID;
		this.gSID=gSID;
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
	public void setgSID(String gSID){
		this.gSID=gSID;
	}
	public String getgSID(){
		return gSID;
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
		return "GroupSettingPlan [planID="+planID+",gSID="+gSID+",actNO="+actNO+",actName="+actName+",billDate="+billDate+",process="+process+",note="+note+",time="+time+"]";
	}
}

