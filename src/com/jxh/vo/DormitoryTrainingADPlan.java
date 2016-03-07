package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.math.*;
import java.text.ParseException;


/** DormitoryTrainingADPlan

aPlanID,recordID,beginDate,endDate,handler
?,?,?,?,?

dormitoryTrainingADPlan.aPlanID,dormitoryTrainingADPlan.recordID,dormitoryTrainingADPlan.beginDate,dormitoryTrainingADPlan.endDate,dormitoryTrainingADPlan.handler

aPlanID=?,recordID=?,beginDate=?,endDate=?,handler=?
*/
public class DormitoryTrainingADPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aPlanID;
	private String recordID;
	private Date beginDate;
	private Date endDate;
	private String handler;
	
	private String beginDate_str;
	private String endDate_str;

	public DormitoryTrainingADPlan(){
		super();
	}
	public DormitoryTrainingADPlan(String aPlanID, String recordID, Date beginDate, Date endDate, String handler ,
								String beginDate_str,String endDate_str){
		super();
		this.aPlanID=aPlanID;
		this.recordID=recordID;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.handler=handler;
		this.beginDate_str=beginDate_str;
		this.endDate_str=endDate_str;
	}
	public void setaPlanID(String aPlanID){
		this.aPlanID=aPlanID;
	}
	public String getaPlanID(){
		return aPlanID;
	}
	public void setRecordID(String recordID){
		this.recordID=recordID;
	}
	public String getRecordID(){
		return recordID;
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
	public void setHandler(String handler){
		this.handler=handler;
	}
	public String getHandler(){
		return handler;
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
		return "DormitoryTrainingADPlan [aPlanID="+aPlanID+",recordID="+recordID+",beginDate="+beginDate+",endDate="+endDate+",handler="+handler+
				",beginDate_str="+beginDate_str+",endDate_str="+endDate_str+"]";
	}
}

