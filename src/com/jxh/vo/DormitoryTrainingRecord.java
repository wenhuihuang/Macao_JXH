package com.jxh.vo;


import java.io.Serializable;

/** DormitoryTrainingRecord

recordID,masterRecordID,handler,workder,standard
?,?,?,?,?

dormitoryTrainingRecord.recordID,dormitoryTrainingRecord.masterRecordID,dormitoryTrainingRecord.handler,dormitoryTrainingRecord.workder,dormitoryTrainingRecord.standard

recordID=?,masterRecordID=?,handler=?,workder=?,standard=?
*/
public class DormitoryTrainingRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private int masterRecordID;
	private String handler;
	private String workder;
	private int standard;

	public DormitoryTrainingRecord(){
		super();
	}
	public DormitoryTrainingRecord(int recordID, int masterRecordID, String handler, String workder, int standard ){
		super();
		this.recordID=recordID;
		this.masterRecordID=masterRecordID;
		this.handler=handler;
		this.workder=workder;
		this.standard=standard;
	}
	public void setRecordID(int recordID){
		this.recordID=recordID;
	}
	public int getRecordID(){
		return recordID;
	}
	public void setMasterRecordID(int masterRecordID){
		this.masterRecordID=masterRecordID;
	}
	public int getMasterRecordID(){
		return masterRecordID;
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
	@Override
	public String toString(){
		return "DormitoryTrainingRecord [recordID="+recordID+",masterRecordID="+masterRecordID+",handler="+handler+",workder="+workder+",standard="+standard+"]";
	}
}

