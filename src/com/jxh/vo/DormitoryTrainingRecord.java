package com.jxh.vo;


import java.io.Serializable;

/** DormitoryTrainingRecord

tRecordID,recordID,handler,tutor,standardInt,groupGrade
?,?,?,?,?,?

dormitoryTrainingRecord.tRecordID,dormitoryTrainingRecord.recordID,dormitoryTrainingRecord.tutor,dormitoryTrainingRecord.workder,dormitoryTrainingRecord.standardInt,dormitoryTrainingRecord.groupGrade

tRecordID=?,recordID=?,tutor=?,workder=?,standardInt=?
*/
public class DormitoryTrainingRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tRecordID;
	private String recordID;
	private String tutor;
	private String workder;
	private int standardInt;
	private String groupGrade;

	public DormitoryTrainingRecord(){
		super();
	}
	public DormitoryTrainingRecord(String tRecordID, String recordID, String tutor, String workder, int standardInt ,
								String groupGrade){
		super();
		this.tRecordID=tRecordID;
		this.recordID=recordID;
		this.tutor=tutor;
		this.workder=workder;
		this.standardInt=standardInt;
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
	public void setTutor(String tutor){
		this.tutor=tutor;
	}
	public String getTutor(){
		return tutor;
	}
	public void setWorkder(String workder){
		this.workder=workder;
	}
	public String getWorkder(){
		return workder;
	}
	public void setStandardInt(int standardInt){
		this.standardInt=standardInt;
	}
	public int getStandardInt(){
		return standardInt;
	}
	public String getGroupGrade() {
		return groupGrade;
	}
	public void setGroupGrade(String groupGrade) {
		this.groupGrade = groupGrade;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingRecord [tRecordID="+tRecordID+",recordID="+recordID+",tutor="+tutor+",workder="+workder+",standardInt="+standardInt+
				",groupGrade="+groupGrade+"]";
	}
}

