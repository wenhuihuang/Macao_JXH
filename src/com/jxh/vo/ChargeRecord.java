package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** ChargeRecord

chargeID,projectNO,projectName,chargeBDate,chargeEDate,money,payDate,payMoney,note
?,?,?,?,?,?,?,?,?

chargeRecord.chargeID,chargeRecord.projectNO,chargeRecord.projectName,chargeRecord.chargeBDate,chargeRecord.chargeEDate,chargeRecord.money,chargeRecord.payDate,chargeRecord.payMoney,chargeRecord.note

chargeID=?,projectNO=?,projectName=?,chargeBDate=?,chargeEDate=?,money=?,payDate=?,payMoney=?,note=?
*/
public class ChargeRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private String chargeID;
	private String projectNO;
	private String projectName;
	private Date chargeBDate;
	private Date chargeEDate;
	private BigDecimal money;
	private Date payDate;
	private BigDecimal payMoney;
	private String note;

	public ChargeRecord(){
		super();
	}
	public ChargeRecord(String chargeID, String projectNO, String projectName, Date chargeBDate, Date chargeEDate, BigDecimal money, Date payDate, BigDecimal payMoney, String note ){
		super();
		this.chargeID=chargeID;
		this.projectNO=projectNO;
		this.projectName=projectName;
		this.chargeBDate=chargeBDate;
		this.chargeEDate=chargeEDate;
		this.money=money;
		this.payDate=payDate;
		this.payMoney=payMoney;
		this.note=note;
	}
	public void setChargeID(String chargeID){
		this.chargeID=chargeID;
	}
	public String getChargeID(){
		return chargeID;
	}
	public void setProjectNO(String projectNO){
		this.projectNO=projectNO;
	}
	public String getProjectNO(){
		return projectNO;
	}
	public void setProjectName(String projectName){
		this.projectName=projectName;
	}
	public String getProjectName(){
		return projectName;
	}
	public void setChargeBDate(Date chargeBDate){
		this.chargeBDate=chargeBDate;
	}
	public Date getChargeBDate(){
		return chargeBDate;
	}
	public void setChargeEDate(Date chargeEDate){
		this.chargeEDate=chargeEDate;
	}
	public Date getChargeEDate(){
		return chargeEDate;
	}
	public void setMoney(BigDecimal money){
		this.money=money;
	}
	public BigDecimal getMoney(){
		return money;
	}
	public void setPayDate(Date payDate){
		this.payDate=payDate;
	}
	public Date getPayDate(){
		return payDate;
	}
	public void setPayMoney(BigDecimal payMoney){
		this.payMoney=payMoney;
	}
	public BigDecimal getPayMoney(){
		return payMoney;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "ChargeRecord [chargeID="+chargeID+",projectNO="+projectNO+",projectName="+projectName+",chargeBDate="+chargeBDate+",chargeEDate="+chargeEDate+",money="+money+",payDate="+payDate+",payMoney="+payMoney+",note="+note+"]";
	}
}

