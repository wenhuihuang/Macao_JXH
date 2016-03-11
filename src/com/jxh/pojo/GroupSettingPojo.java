package com.jxh.pojo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** GroupSetting

gSID,handler,groupName,target,beginDate,endDate,leader,toll,place,device,configuration,gSNO,note
?,?,?,?,?,?,?,?,?,?,?,?,?

groupSetting.gSID,groupSetting.handler,groupSetting.groupName,groupSetting.target,groupSetting.beginDate,groupSetting.endDate,groupSetting.leader,groupSetting.toll,groupSetting.place,groupSetting.device,groupSetting.configuration,groupSetting.gSNO,groupSetting.note

gSID=?,handler=?,groupName=?,target=?,beginDate=?,endDate=?,leader=?,toll=?,place=?,device=?,configuration=?,gSNO=?,note=?
*/
public class GroupSettingPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String gSID;
	private int handler;
	private String groupName;
	private String target;
	private Date beginDate;
	private Date endDate;
	private String leader;
	private BigDecimal toll;
	private String place;
	private String device;
	private String configuration;
	private String gSNO;
	private String note;

	public GroupSettingPojo(){
		super();
	}
	public GroupSettingPojo(String gSID, int handler, String groupName, String target, Date beginDate, Date endDate, String leader, BigDecimal toll, String place, String device, String configuration, String gSNO, String note ){
		super();
		this.gSID=gSID;
		this.handler=handler;
		this.groupName=groupName;
		this.target=target;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.leader=leader;
		this.toll=toll;
		this.place=place;
		this.device=device;
		this.configuration=configuration;
		this.gSNO=gSNO;
		this.note=note;
	}
	public void setHandler(int handler){
		this.handler=handler;
	}
	public int getHandler(){
		return handler;
	}
	public void setGroupName(String groupName){
		this.groupName=groupName;
	}
	public String getGroupName(){
		return groupName;
	}
	public void setTarget(String target){
		this.target=target;
	}
	public String getTarget(){
		return target;
	}
	public void setBeginDate(Date beginDate){
		this.beginDate=beginDate;
	}
	public Date getBeginDate(){
		return beginDate;
	}
	public void setEndDate(Date endDate){
		this.endDate=endDate;
	}
	public Date getEndDate(){
		return endDate;
	}
	public void setLeader(String leader){
		this.leader=leader;
	}
	public String getLeader(){
		return leader;
	}
	public void setToll(BigDecimal toll){
		this.toll=toll;
	}
	public BigDecimal getToll(){
		return toll;
	}
	public void setPlace(String place){
		this.place=place;
	}
	public String getPlace(){
		return place;
	}
	public void setDevice(String device){
		this.device=device;
	}
	public String getDevice(){
		return device;
	}
	public void setConfiguration(String configuration){
		this.configuration=configuration;
	}
	public String getConfiguration(){
		return configuration;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public String getgSID() {
		return gSID;
	}
	public void setgSID(String gSID) {
		this.gSID = gSID;
	}
	public String getgSNO() {
		return gSNO;
	}
	public void setgSNO(String gSNO) {
		this.gSNO = gSNO;
	}
	@Override
	public String toString(){
		return "GroupSetting [gSID="+gSID+",handler="+handler+",groupName="+groupName+",target="+target+",beginDate="+beginDate+",endDate="+endDate+",leader="+leader+",toll="+toll+",place="+place+",device="+device+",configuration="+configuration+",gSNO="+gSNO+",note="+note+"]";
	}
}

