package com.jxh.pojo;


import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;

public class GroupSettingRecordPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordID;
	private String gSID;
	private Date beginDate;
	private Date endDate;
	private String leader;
	private int qty;
	private String place;
	private String device;
	private String custs;
	private String configuration;
	private String summary;
	
	private String gSNO;
	private String groupName;
	private String target;

	public GroupSettingRecordPojo(){
		super();
	}
	public GroupSettingRecordPojo(String recordID, String gSID, Date beginDate, Date endDate, String leader, int qty, String place, String device, String custs, String configuration, String summary,
								String gSNO,String groupName,String target){
		super();
		this.recordID=recordID;
		this.gSID=gSID;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.leader=leader;
		this.qty=qty;
		this.place=place;
		this.device=device;
		this.custs=custs;
		this.configuration=configuration;
		this.summary=summary;
		this.groupName=groupName;
		this.target=target;
		this.gSNO=gSNO;
	}
	public void setRecordID(String recordID){
		this.recordID=recordID;
	}
	public String getRecordID(){
		return recordID;
	}
	public void setgSID(String gSID){
		this.gSID=gSID;
	}
	public String getgSID(){
		return gSID;
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
	public void setQty(int qty){
		this.qty=qty;
	}
	public int getQty(){
		return qty;
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
	public void setCusts(String custs){
		this.custs=custs;
	}
	public String getCusts(){
		return custs;
	}
	public void setConfiguration(String configuration){
		this.configuration=configuration;
	}
	public String getConfiguration(){
		return configuration;
	}
	public void setSummary(String summary){
		this.summary=summary;
	}
	public String getSummary(){
		return summary;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getgSNO() {
		return gSNO;
	}
	public void setgSNO(String gSNO) {
		this.gSNO = gSNO;
	}
	@Override
	public String toString(){
		return "GroupSettingRecord [recordID="+recordID+",gSID="+gSID+",beginDate="+beginDate+",endDate="+endDate+",leader="+leader+",qty="+qty+",place="+place+",device="+device+",custs="+custs+",configuration="+configuration+",summary="+summary+
				",groupName="+groupName+",target="+target+",gSNO="+gSNO+"]";
	}
}

