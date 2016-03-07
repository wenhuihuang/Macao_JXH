package com.jxh.vo;


import java.io.Serializable;

/** DormitoryTrainingRecord

tRecordID,recordID,handler,workder,standard,groupGrade
?,?,?,?,?,?

dormitoryTrainingRecord.tRecordID,dormitoryTrainingRecord.recordID,dormitoryTrainingRecord.handler,dormitoryTrainingRecord.workder,dormitoryTrainingRecord.standard,dormitoryTrainingRecord.groupGrade

tRecordID=?,recordID=?,handler=?,workder=?,standard=?
*/
public class DormitoryTrainingRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tRecordID;
	private String recordID;
	private String handler;
	private String workder;
	private int standard;
	private String groupGrade;

	public DormitoryTrainingRecord(){
		super();
	}
	public DormitoryTrainingRecord(String tRecordID, String recordID, String handler, String workder, int standard ,
								String groupGrade){
		super();
		this.tRecordID=tRecordID;
		this.recordID=recordID;
		this.handler=handler;
		this.workder=workder;
		this.standard=standard;
		this.groupGrade=groupGrade;
	}
	public void settRecordID(String tRecordID){
		this.tRecordID=tRecordID;
	}
	public String gettRecordID(){
		return tRecordID;
	}
	public void setRecordID(String recordID){
		this.recordID=recordID;
	}
	public String getRecordID(){
		return recordID;
	}
	public void setHandler(String handler){
		this.handler=handler;
	}
	public String getHandler(){
		return handler;
	}
	public void setWorkder(String workder){
		this.workder=workder;
	}
	public String getWorkder(){
		return workder;
	}
	public void setStandard(int standard){
		this.standard=standard;
	}
	public int getStandard(){
		return standard;
	}
	public String getGroupGrade() {
		return groupGrade;
	}
	public void setGroupGrade(String groupGrade) {
		this.groupGrade = groupGrade;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingRecord [tRecordID="+tRecordID+",recordID="+recordID+",handler="+handler+",workder="+workder+",standard="+standard+
				",groupGrade="+groupGrade+"]";
	}
}

