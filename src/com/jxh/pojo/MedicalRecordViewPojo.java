package com.jxh.pojo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;


public class MedicalRecordViewPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int viewID;
	private String recordID;
	private Date billDate;
	private String project;
	private int mentality;
	private int heartLung;
	private int blood;
	private int skin;
	private int nerve;
	private String releaseDate;
	private String handler;

	public MedicalRecordViewPojo(){
		super();
	}
	public MedicalRecordViewPojo(int viewID, String recordID, Date billDate, String project, int mentality, int heartLung, int blood, int skin, int nerve, String releaseDate, String handler ){
		super();
		this.viewID=viewID;
		this.recordID=recordID;
		this.billDate=billDate;
		this.project=project;
		this.mentality=mentality;
		this.heartLung=heartLung;
		this.blood=blood;
		this.skin=skin;
		this.nerve=nerve;
		this.releaseDate=releaseDate;
		this.handler=handler;
	}
	public void setViewID(int viewID){
		this.viewID=viewID;
	}
	public int getViewID(){
		return viewID;
	}
	public void setRecordID(String recordID){
		this.recordID=recordID;
	}
	public String getRecordID(){
		return recordID;
	}
	public void setBillDate(Date billDate){
		this.billDate=billDate;
	}
	public Date getBillDate(){
		return billDate;
	}
	public void setProject(String project){
		this.project=project;
	}
	public String getProject(){
		return project;
	}
	public void setMentality(int mentality){
		this.mentality=mentality;
	}
	public int getMentality(){
		return mentality;
	}
	public void setHeartLung(int heartLung){
		this.heartLung=heartLung;
	}
	public int getHeartLung(){
		return heartLung;
	}
	public void setBlood(int blood){
		this.blood=blood;
	}
	public int getBlood(){
		return blood;
	}
	public void setSkin(int skin){
		this.skin=skin;
	}
	public int getSkin(){
		return skin;
	}
	public void setNerve(int nerve){
		this.nerve=nerve;
	}
	public int getNerve(){
		return nerve;
	}
	public void setReleaseDate(String releaseDate){
		this.releaseDate=releaseDate;
	}
	public String getReleaseDate(){
		return releaseDate;
	}
	public void setHandler(String handler){
		this.handler=handler;
	}
	public String getHandler(){
		return handler;
	}
	@Override
	public String toString(){
		return "MedicalRecordView [viewID="+viewID+",recordID="+recordID+",billDate="+billDate+",project="+project+",mentality="+mentality+",heartLung="+heartLung+",blood="+blood+",skin="+skin+",nerve="+nerve+",releaseDate="+releaseDate+",handler="+handler+"]";
	}
}

