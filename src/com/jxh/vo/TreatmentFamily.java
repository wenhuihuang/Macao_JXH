package com.jxh.vo;


import java.io.Serializable;

/** TreatmentFamily
	FAMILYID	INT(10)
	TREATMENTID	INT(10)
	USERNAME	VARCHAR(32)
	RELATIONSHIP	VARCHAR(32)
	AGE	INT(10)
	EDULEVEL	INT(10)
	WORK	VARCHAR(20)
	NOTE	VARCHAR(128)

familyID,treatmentID,userName,relationShip,age,eduLevel,work,note
?,?,?,?,?,?,?,?

treatmentFamily.familyID,treatmentFamily.treatmentID,treatmentFamily.userName,treatmentFamily.relationShip,treatmentFamily.age,treatmentFamily.eduLevel,treatmentFamily.work,treatmentFamily.note

familyID=?,treatmentID=?,userName=?,relationShip=?,age=?,eduLevel=?,work=?,note=?
*/
public class TreatmentFamily implements Serializable {
	private static final long serialVersionUID = 1L;
	private int familyID;
	private int treatmentID;
	private String userName;
	private String relationShip;
	private int age;
	private int eduLevel;
	private String work;
	private String note;

	public TreatmentFamily(){
		super();
	}
	public TreatmentFamily(int familyID, int treatmentID, String userName, String relationShip, int age, int eduLevel, String work, String note ){
		super();
		this.familyID=familyID;
		this.treatmentID=treatmentID;
		this.userName=userName;
		this.relationShip=relationShip;
		this.age=age;
		this.eduLevel=eduLevel;
		this.work=work;
		this.note=note;
	}
	public void setFamilyID(int familyID){
		this.familyID=familyID;
	}
	public int getFamilyID(){
		return familyID;
	}
	public void setTreatmentID(int treatmentID){
		this.treatmentID=treatmentID;
	}
	public int getTreatmentID(){
		return treatmentID;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return userName;
	}
	public void setRelationShip(String relationShip){
		this.relationShip=relationShip;
	}
	public String getRelationShip(){
		return relationShip;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	public void setEduLevel(int eduLevel){
		this.eduLevel=eduLevel;
	}
	public int getEduLevel(){
		return eduLevel;
	}
	public void setWork(String work){
		this.work=work;
	}
	public String getWork(){
		return work;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "TreatmentFamily [familyID="+familyID+",treatmentID="+treatmentID+",userName="+userName+",relationShip="+relationShip+",age="+age+",eduLevel="+eduLevel+",work="+work+",note="+note+"]";
	}
}

