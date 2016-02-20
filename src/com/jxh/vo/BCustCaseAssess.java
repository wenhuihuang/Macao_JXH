package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;


/** BCustCaseAssess
	ASSESSID	INT(10)
	CASENO	VARCHAR(32)
	CASEID	VARCHAR(20)
	CUSTID	VARCHAR(20)
	FATHER	VARCHAR(32)
	MOTHER	VARCHAR(32)
	ASSESSWORKER	VARCHAR(32)
	ASSESSDATE	DATETIME(23,3)
	BACKGROUND	TEXT(2147483647)
	PROBLEM	TEXT(2147483647)
	OBJECTIVE	TEXT(2147483647)
	DESCRIBE	TEXT(2147483647)

assessID,caseNO,caseID,custID,father,mother,assessWorker,assessDate,background,problem,objective,describe
?,?,?,?,?,?,?,?,?,?,?,?
*/
public class BCustCaseAssess implements Serializable {
	private static final long serialVersionUID = 1L;
	private int assessID;
	private String caseNO;
	private String caseID;
	private String custID;
	private String father;
	private String mother;
	private String assessWorker;
	private Date assessDate;
	private String background;
	private String problem;
	private String objective;
	private String describe;

	public BCustCaseAssess(){
		super();
	}
	public BCustCaseAssess(int assessID, String caseNO, String caseID, String custID, String father, String mother, String assessWorker, Date assessDate, String background, String problem, String objective, String describe ){
		super();
		this.assessID=assessID;
		this.caseNO=caseNO;
		this.caseID=caseID;
		this.custID=custID;
		this.father=father;
		this.mother=mother;
		this.assessWorker=assessWorker;
		this.assessDate=assessDate;
		this.background=background;
		this.problem=problem;
		this.objective=objective;
		this.describe=describe;
	}
	public void setAssessID(int assessID){
		this.assessID=assessID;
	}
	public int getAssessID(){
		return assessID;
	}
	public void setCaseNO(String caseNO){
		this.caseNO=caseNO;
	}
	public String getCaseNO(){
		return caseNO;
	}
	public void setCaseID(String caseID){
		this.caseID=caseID;
	}
	public String getCaseID(){
		return caseID;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setFather(String father){
		this.father=father;
	}
	public String getFather(){
		return father;
	}
	public void setMother(String mother){
		this.mother=mother;
	}
	public String getMother(){
		return mother;
	}
	public void setAssessWorker(String assessWorker){
		this.assessWorker=assessWorker;
	}
	public String getAssessWorker(){
		return assessWorker;
	}
	public void setAssessDate(Date assessDate){
		this.assessDate=assessDate;
	}
	public Date getAssessDate(){
		return assessDate;
	}
	public void setBackground(String background){
		this.background=background;
	}
	public String getBackground(){
		return background;
	}
	public void setProblem(String problem){
		this.problem=problem;
	}
	public String getProblem(){
		return problem;
	}
	public void setObjective(String objective){
		this.objective=objective;
	}
	public String getObjective(){
		return objective;
	}
	public void setDescribe(String describe){
		this.describe=describe;
	}
	public String getDescribe(){
		return describe;
	}
	@Override
	public String toString(){
		return "BCustCaseAssess [assessID="+assessID+",caseNO="+caseNO+",caseID="+caseID+",custID="+custID+",father="+father+",mother="+mother+",assessWorker="+assessWorker+",assessDate="+assessDate+",background="+background+",problem="+problem+",objective="+objective+",describe="+describe+"]";
	}
}
