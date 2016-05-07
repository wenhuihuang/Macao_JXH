package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** bCustBelongOrgPayLog
	LOGID	VARCHAR(20)
	TYPECODE	VARCHAR(32)
	CUSTID	VARCHAR(20)
	PAYDATE	DATETIME(23,3)
	COST	DECIMAL(18,2)

logId,typeCode,custID,payDate,cost
?,?,?,?,?

bCustBelongOrgPayLog.logId,bCustBelongOrgPayLog.typeCode,bCustBelongOrgPayLog.custID,bCustBelongOrgPayLog.payDate,bCustBelongOrgPayLog.cost

logId=?,typeCode=?,custID=?,payDate=?,cost=?
*/
public class BCustBelongOrgPayLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private String logId;
	private String typeCode;
	private String custID;
	private Date payDate;
	private BigDecimal cost;

	public BCustBelongOrgPayLog(){
		super();
	}
	public BCustBelongOrgPayLog(String logId, String typeCode, String custID, Date payDate, BigDecimal cost ){
		super();
		this.logId=logId;
		this.typeCode=typeCode;
		this.custID=custID;
		this.payDate=payDate;
		this.cost=cost;
	}
	public void setLogId(String logId){
		this.logId=logId;
	}
	public String getLogId(){
		return logId;
	}
	public void setTypeCode(String typeCode){
		this.typeCode=typeCode;
	}
	public String getTypeCode(){
		return typeCode;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setPayDate(Date payDate){
		this.payDate=payDate;
	}
	public Date getPayDate(){
		return payDate;
	}
	public void setCost(BigDecimal cost){
		this.cost=cost;
	}
	public BigDecimal getCost(){
		return cost;
	}
	@Override
	public String toString(){
		return "BCustBelongOrgPayLog [logId="+logId+",typeCode="+typeCode+",custID="+custID+",payDate="+payDate+",cost="+cost+"]";
	}
}

