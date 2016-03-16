package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;


/** CarRecord

recordID,carID,custID,beginDate,endDate,takeDate,toll,actToll,note
?,?,?,?,?,?,?,?,?

carRecord.recordID,carRecord.carID,carRecord.custID,carRecord.beginDate,carRecord.endDate,carRecord.takeDate,carRecord.toll,carRecord.actToll,carRecord.note

recordID=?,carID=?,custID=?,beginDate=?,endDate=?,takeDate=?,toll=?,actToll=?,note=?
*/
public class CarRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordID;
	private String carID;
	private String custID;
	private Date beginDate;
	private Date endDate;
	private Date takeDate;
	private BigDecimal toll;
	private BigDecimal actToll;
	private String note;

	public CarRecord(){
		super();
	}
	public CarRecord(int recordID, String carID, String custID, Date beginDate, Date endDate, Date takeDate, BigDecimal toll, BigDecimal actToll, String note ){
		super();
		this.recordID=recordID;
		this.carID=carID;
		this.custID=custID;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.takeDate=takeDate;
		this.toll=toll;
		this.actToll=actToll;
		this.note=note;
	}
	public void setRecordID(int recordID){
		this.recordID=recordID;
	}
	public int getRecordID(){
		return recordID;
	}
	public void setCarID(String carID){
		this.carID=carID;
	}
	public String getCarID(){
		return carID;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
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
	public void setTakeDate(Date takeDate){
		this.takeDate=takeDate;
	}
	public Date getTakeDate(){
		return takeDate;
	}
	public void setToll(BigDecimal toll){
		this.toll=toll;
	}
	public BigDecimal getToll(){
		return toll;
	}
	public void setActToll(BigDecimal actToll){
		this.actToll=actToll;
	}
	public BigDecimal getActToll(){
		return actToll;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "CarRecord [recordID="+recordID+",carID="+carID+",custID="+custID+",beginDate="+beginDate+",endDate="+endDate+",takeDate="+takeDate+",toll="+toll+",actToll="+actToll+",note="+note+"]";
	}
}

