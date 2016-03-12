package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.math.*;
import java.text.ParseException;


/** GroupSetting

gSID,handler,groupName,target,beginDate,endDate,leader,toll,place,device,configuration,gSNO,note,qty,custs
?,?,?,?,?,?,?,?,?,?,?,?,?,?,?

groupSetting.gSID,groupSetting.handler,groupSetting.groupName,groupSetting.target,groupSetting.beginDate,groupSetting.endDate,groupSetting.leader,groupSetting.toll,groupSetting.place,groupSetting.device,groupSetting.configuration,groupSetting.gSNO,groupSetting.note,groupSetting.qty,groupSetting.custs

gSID=?,handler=?,groupName=?,target=?,beginDate=?,endDate=?,leader=?,toll=?,place=?,device=?,configuration=?,gSNO=?,note=?,qty=?,custs=?
*/
public class GroupSetting implements Serializable {
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
	
	private String beginDate_str;
	private String endDate_str;

	public GroupSetting(){
		super();
	}
	public GroupSetting(String gSID, String handler, String groupName, String target, Date beginDate, Date endDate, String leader, BigDecimal toll, String place, String device, String configuration, String gSNO, String note, int qty, String custs ,
						String beginDate_str,String endDate_str){
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
		this.beginDate_str=beginDate_str;
		this.endDate_str=endDate_str;
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
	public String getBeginDate_str() {
		try {
			return beginDate == null || "".equals(beginDate) ? ""
					: ToolsUtils.getDateStringByFormat(beginDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setBeginDate_str(String beginDate_str) {
		this.beginDate_str = beginDate_str;
	}
	public String getEndDate_str() {
		try {
			return endDate == null || "".equals(endDate) ? ""
					: ToolsUtils.getDateStringByFormat(endDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setEndDate_str(String endDate_str) {
		this.endDate_str = endDate_str;
	}
	@Override
	public String toString(){
		return "GroupSetting [gSID="+gSID+",handler="+handler+",groupName="+groupName+",target="+target+",beginDate="+beginDate+",endDate="+endDate+",leader="+leader+",toll="+toll+",place="+place+",device="+device+",configuration="+configuration+",gSNO="+gSNO+",note="+note+",qty="+qty+",custs="+custs+
							",beginDate_str="+beginDate_str+",endDate_str="+endDate_str+"]";
	}
}

