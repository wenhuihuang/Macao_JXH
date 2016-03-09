package com.jxh.vo;


import java.io.Serializable;

/** MedicalRecordFamily
	FAMILYID	INT(10)
	RECORDID	VARCHAR(20)
	RELATIONSHIP	VARCHAR(32)
	HISTORYNOTE	VARCHAR(128)
	NOTE	VARCHAR(128)

familyID,recordID,relationShip,historyNote,note
?,?,?,?,?

medicalRecordFamily.familyID,medicalRecordFamily.recordID,medicalRecordFamily.relationShip,medicalRecordFamily.historyNote,medicalRecordFamily.note

familyID=?,recordID=?,relationShip=?,historyNote=?,note=?
*/
public class MedicalRecordFamily implements Serializable {
	private static final long serialVersionUID = 1L;
	private int familyID;
	private String recordID;
	private String relationShip;
	private String historyNote;
	private String note;

	public MedicalRecordFamily(){
		super();
	}
	public MedicalRecordFamily(int familyID, String recordID, String relationShip, String historyNote, String note ){
		super();
		this.familyID=familyID;
		this.recordID=recordID;
		this.relationShip=relationShip;
		this.historyNote=historyNote;
		this.note=note;
	}
	public void setFamilyID(int familyID){
		this.familyID=familyID;
	}
	public int getFamilyID(){
		return familyID;
	}
	public void setRecordID(String recordID){
		this.recordID=recordID;
	}
	public String getRecordID(){
		return recordID;
	}
	public void setRelationShip(String relationShip){
		this.relationShip=relationShip;
	}
	public String getRelationShip(){
		return relationShip;
	}
	public void setHistoryNote(String historyNote){
		this.historyNote=historyNote;
	}
	public String getHistoryNote(){
		return historyNote;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "MedicalRecordFamily [familyID="+familyID+",recordID="+recordID+",relationShip="+relationShip+",historyNote="+historyNote+",note="+note+"]";
	}
}

