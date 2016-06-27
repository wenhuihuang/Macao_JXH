package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** bCustomerSchool
	SCHOOLID	INT(10)
	CUSTID	VARCHAR(20)
	SCHOOLNAME	VARCHAR(128)
	STARTDATE	DATETIME(23,3)
	ENDDATE	DATETIME(23,3)
	GRADE	VARCHAR(32)
	SCHOOLNOTE	VARCHAR(128)

schoolID,custID,schoolName,startDate,endDate,grade,schoolNote
?,?,?,?,?,?,?

bCustomerSchool.schoolID,bCustomerSchool.custID,bCustomerSchool.schoolName,bCustomerSchool.startDate,bCustomerSchool.endDate,bCustomerSchool.grade,bCustomerSchool.schoolNote

schoolID=?,custID=?,schoolName=?,startDate=?,endDate=?,grade=?,schoolNote=?
*/
public class BCustomerSchool implements Serializable {
	private static final long serialVersionUID = 1L;
	private int schoolID;
	private String custID;
	private String schoolName;
	private Date startDate;
	private Date endDate;
	private String grade;
	private String schoolNote;

	public BCustomerSchool(){
		super();
	}
	public BCustomerSchool(int schoolID, String custID, String schoolName, Date startDate, Date endDate, String grade, String schoolNote ){
		super();
		this.schoolID=schoolID;
		this.custID=custID;
		this.schoolName=schoolName;
		this.startDate=startDate;
		this.endDate=endDate;
		this.grade=grade;
		this.schoolNote=schoolNote;
	}
	public void setSchoolID(int schoolID){
		this.schoolID=schoolID;
	}
	public int getSchoolID(){
		return schoolID;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setSchoolName(String schoolName){
		this.schoolName=schoolName;
	}
	public String getSchoolName(){
		return schoolName;
	}
	public void setStartDate(Date startDate){
		this.startDate=startDate;
	}
	public Date getStartDate(){
		return startDate;
	}
	public void setEndDate(Date endDate){
		this.endDate=endDate;
	}
	public Date getEndDate(){
		return endDate;
	}
	public void setGrade(String grade){
		this.grade=grade;
	}
	public String getGrade(){
		return grade;
	}
	public void setSchoolNote(String schoolNote){
		this.schoolNote=schoolNote;
	}
	public String getSchoolNote(){
		return schoolNote;
	}
	@Override
	public String toString(){
		return "BCustomerSchool [schoolID="+schoolID+",custID="+custID+",schoolName="+schoolName+",startDate="+startDate+",endDate="+endDate+",grade="+grade+",schoolNote="+schoolNote+"]";
	}
}

