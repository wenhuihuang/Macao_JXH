package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** ActivityApply
	APPLYID	VARCHAR(20)
	TYPE	INT(10)
	REGISTERDATE	DATETIME(23,3)
	CUSTID	VARCHAR(20)
	PCUSTID	VARCHAR(20)
	PARENTSEXPENSE	NUMERIC(18,2)
	AMENTIAEXPENSE	NUMERIC(18,2)
	FAMILY	VARCHAR(32)
	FEXPENSE	NUMERIC(18,2)
	FNUMBER	INT(10)
	NOTE	VARCHAR(128)

applyID,type,registerDate,custID,pCustID,parentsExpense,amentiaExpense,family,fExpense,fNumber,note
?,?,?,?,?,?,?,?,?,?,?

activityApply.applyID,activityApply.type,activityApply.registerDate,activityApply.custID,activityApply.pCustID,activityApply.parentsExpense,activityApply.amentiaExpense,activityApply.family,activityApply.fExpense,activityApply.fNumber,activityApply.note

applyID=?,type=?,registerDate=?,custID=?,pCustID=?,parentsExpense=?,amentiaExpense=?,family=?,fExpense=?,fNumber=?,note=?
*/
public class ActivityApply implements Serializable {
	private static final long serialVersionUID = 1L;
	private String applyID;
	private int type;
	private Date registerDate;
	private String custID;
	private String pCustID;
	private BigDecimal parentsExpense;
	private BigDecimal amentiaExpense;
	private String family;
	private BigDecimal fExpense;
	private int fNumber;
	private String note;

	public ActivityApply(){
		super();
	}
	public ActivityApply(String applyID, int type, Date registerDate, String custID, String pCustID, BigDecimal parentsExpense, BigDecimal amentiaExpense, String family, BigDecimal fExpense, int fNumber, String note ){
		super();
		this.applyID=applyID;
		this.type=type;
		this.registerDate=registerDate;
		this.custID=custID;
		this.pCustID=pCustID;
		this.parentsExpense=parentsExpense;
		this.amentiaExpense=amentiaExpense;
		this.family=family;
		this.fExpense=fExpense;
		this.fNumber=fNumber;
		this.note=note;
	}
	public void setApplyID(String applyID){
		this.applyID=applyID;
	}
	public String getApplyID(){
		return applyID;
	}
	public void setType(int type){
		this.type=type;
	}
	public int getType(){
		return type;
	}
	public void setRegisterDate(Date registerDate){
		this.registerDate=registerDate;
	}
	public Date getRegisterDate(){
		return registerDate;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setPCustID(String pCustID){
		this.pCustID=pCustID;
	}
	public String getPCustID(){
		return pCustID;
	}
	public void setParentsExpense(BigDecimal parentsExpense){
		this.parentsExpense=parentsExpense;
	}
	public BigDecimal getParentsExpense(){
		return parentsExpense;
	}
	public void setAmentiaExpense(BigDecimal amentiaExpense){
		this.amentiaExpense=amentiaExpense;
	}
	public BigDecimal getAmentiaExpense(){
		return amentiaExpense;
	}
	public void setFamily(String family){
		this.family=family;
	}
	public String getFamily(){
		return family;
	}
	public void setFExpense(BigDecimal fExpense){
		this.fExpense=fExpense;
	}
	public BigDecimal getFExpense(){
		return fExpense;
	}
	public void setFNumber(int fNumber){
		this.fNumber=fNumber;
	}
	public int getFNumber(){
		return fNumber;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "ActivityApply [applyID="+applyID+",type="+type+",registerDate="+registerDate+",custID="+custID+",pCustID="+pCustID+",parentsExpense="+parentsExpense+",amentiaExpense="+amentiaExpense+",family="+family+",fExpense="+fExpense+",fNumber="+fNumber+",note="+note+"]";
	}
}

