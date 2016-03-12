package com.jxh.pojo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


public class GroupSettingPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String gSID;
	private String handler;
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
	private int qty;
	private String custs;

	public GroupSettingPojo(){
		super();
	}
	public GroupSettingPojo(String gSID, String handler, String groupName, String target, Date beginDate, Date endDate, String leader, BigDecimal toll, String place, String device, String configuration, String gSNO, String note, int qty, String custs ){
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
		this.qty=qty;
		this.custs=custs;
	}
	public void setgSID(String gSID){
		this.gSID=gSID;
	}
	public String getgSID(){
		return gSID;
	}
	public void setHandler(String handler){
		this.handler=handler;
	}
	public String getHandler(){
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
	public void setgSNO(String gSNO){
		this.gSNO=gSNO;
	}
	public String getgSNO(){
		return gSNO;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public void setQty(int qty){
		this.qty=qty;
	}
	public int getQty(){
		return qty;
	}
	public void setCusts(String custs){
		this.custs=custs;
	}
	public String getCusts(){
		return custs;
	}
	@Override
	public String toString(){
		return "GroupSetting [gSID="+gSID+",handler="+handler+",groupName="+groupName+",target="+target+",beginDate="+beginDate+",endDate="+endDate+",leader="+leader+",toll="+toll+",place="+place+",device="+device+",configuration="+configuration+",gSNO="+gSNO+",note="+note+",qty="+qty+",custs="+custs+"]";
	}
}

