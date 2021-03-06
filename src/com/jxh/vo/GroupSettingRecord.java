package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.sql.*;
import java.text.ParseException;
import java.math.*;


/** GroupSettingRecord

recordID,gSID,beginDate,endDate,leader,qty,place,device,custs,configuration,summary,note
?,?,?,?,?,?,?,?,?,?,?,?

groupSettingRecord.recordID,groupSettingRecord.gSID,groupSettingRecord.beginDate,groupSettingRecord.endDate,groupSettingRecord.leader,groupSettingRecord.qty,groupSettingRecord.place,groupSettingRecord.device,groupSettingRecord.custs,groupSettingRecord.configuration,groupSettingRecord.summary,groupSettingRecord.note

recordID=?,gSID=?,beginDate=?,endDate=?,leader=?,qty=?,place=?,device=?,custs=?,configuration=?,summary=?,note=?
*/
public class GroupSettingRecord implements Serializable {
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
	private String note;
	
	private String beginDate_str;
	private String endDate_str;

	public GroupSettingRecord(){
		super();
	}
	public GroupSettingRecord(String recordID, String gSID, Date beginDate, Date endDate, String leader, int qty, String place, String device, String custs, String configuration, String summary,
							String beginDate_str,String endDate_str,String note){
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
		this.beginDate_str=beginDate_str;
		this.endDate_str=endDate_str;
		this.note=note;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString(){
		return "GroupSettingRecord [recordID="+recordID+",gSID="+gSID+",beginDate="+beginDate+",endDate="+endDate+",leader="+leader+",qty="+qty+",place="+place+",device="+device+",custs="+custs+",configuration="+configuration+",summary="+summary+
								",beginDate_str="+beginDate_str+",endDate_str="+endDate_str+",note="+note+"]";
	}
}

