package com.jxh.pojo;


import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;


public class CarSettingPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String carID;
	private String carNO;
	private String carNumber;
	private String worker;
	private String assistant;
	private Date beginDate;
	private Date endDate;
	private String site;

	public CarSettingPojo(){
		super();
	}
	public CarSettingPojo(String carID, String carNO, String carNumber, String worker, String assistant, Date beginDate, Date endDate, String site ){
		super();
		this.carID=carID;
		this.carNO=carNO;
		this.carNumber=carNumber;
		this.worker=worker;
		this.assistant=assistant;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.site=site;
	}
	public void setCarID(String carID){
		this.carID=carID;
	}
	public String getCarID(){
		return carID;
	}
	public void setCarNO(String carNO){
		this.carNO=carNO;
	}
	public String getCarNO(){
		return carNO;
	}
	public void setCarNumber(String carNumber){
		this.carNumber=carNumber;
	}
	public String getCarNumber(){
		return carNumber;
	}
	public void setWorker(String worker){
		this.worker=worker;
	}
	public String getWorker(){
		return worker;
	}
	public void setAssistant(String assistant){
		this.assistant=assistant;
	}
	public String getAssistant(){
		return assistant;
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
	public void setSite(String site){
		this.site=site;
	}
	public String getSite(){
		return site;
	}
	@Override
	public String toString(){
		return "CarSetting [carID="+carID+",carNO="+carNO+",carNumber="+carNumber+",worker="+worker+",assistant="+assistant+",beginDate="+beginDate+",endDate="+endDate+",site="+site+"]";
	}
}

