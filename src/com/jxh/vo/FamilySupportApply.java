package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

/**
 * FamilySupportApply
 * 
 * applyID,type,registerDate,custID,pCustID,parentsExpense,amentiaExpense,family
 * ,fExpense,fNumber,note,supportID,amentiaName,parentsName,actWork,tel
 * ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?
 * 
 * familySupportApply.applyID,familySupportApply.type,familySupportApply.
 * registerDate,familySupportApply.custID,familySupportApply.pCustID,
 * familySupportApply.parentsExpense,familySupportApply.amentiaExpense,
 * familySupportApply.family,familySupportApply.fExpense,familySupportApply.
 * fNumber,familySupportApply.note,familySupportApply.supportID,
 * familySupportApply.amentiaName,familySupportApply.parentsName,
 * familySupportApply.actWork,familySupportApply.tel
 * 
 * applyID=?,type=?,registerDate=?,custID=?,pCustID=?,parentsExpense=?,
 * amentiaExpense=?,family=?,fExpense=?,fNumber=?,note=?,supportID=?,amentiaName
 * =?,parentsName=?,actWork=?,tel=?
 */
public class FamilySupportApply implements Serializable {
	private static final long serialVersionUID = 1L;
	private int applyID;
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
	private String supportID;
	private String amentiaName;
	private String parentsName;
	private String actWork;
	private String tel;

	public FamilySupportApply() {
		super();
	}

	public FamilySupportApply(int applyID, int type, Date registerDate, String custID, String pCustID,
			BigDecimal parentsExpense, BigDecimal amentiaExpense, String family, BigDecimal fExpense, int fNumber,
			String note, String supportID, String amentiaName, String parentsName, String actWork, String tel) {
		super();
		this.applyID = applyID;
		this.type = type;
		this.registerDate = registerDate;
		this.custID = custID;
		this.pCustID = pCustID;
		this.parentsExpense = parentsExpense;
		this.amentiaExpense = amentiaExpense;
		this.family = family;
		this.fExpense = fExpense;
		this.fNumber = fNumber;
		this.note = note;
		this.supportID = supportID;
		this.amentiaName = amentiaName;
		this.parentsName = parentsName;
		this.actWork = actWork;
		this.tel = tel;
	}

	public void setApplyID(int applyID) {
		this.applyID = applyID;
	}

	public int getApplyID() {
		return applyID;
	}

	public String getpCustID() {
		return pCustID;
	}

	public void setpCustID(String pCustID) {
		this.pCustID = pCustID;
	}

	public BigDecimal getfExpense() {
		return fExpense;
	}

	public void setfExpense(BigDecimal fExpense) {
		this.fExpense = fExpense;
	}

	public int getfNumber() {
		return fNumber;
	}

	public void setfNumber(int fNumber) {
		this.fNumber = fNumber;
	}

	public String getActWork() {
		return actWork;
	}

	public void setActWork(String actWork) {
		this.actWork = actWork;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getCustID() {
		return custID;
	}

	public void setParentsExpense(BigDecimal parentsExpense) {
		this.parentsExpense = parentsExpense;
	}

	public BigDecimal getParentsExpense() {
		return parentsExpense;
	}

	public void setAmentiaExpense(BigDecimal amentiaExpense) {
		this.amentiaExpense = amentiaExpense;
	}

	public BigDecimal getAmentiaExpense() {
		return amentiaExpense;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getFamily() {
		return family;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public void setSupportID(String supportID) {
		this.supportID = supportID;
	}

	public String getSupportID() {
		return supportID;
	}

	public void setAmentiaName(String amentiaName) {
		this.amentiaName = amentiaName;
	}

	public String getAmentiaName() {
		return amentiaName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public String getParentsName() {
		return parentsName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "FamilySupportApply [applyID=" + applyID + ",type=" + type + ",registerDate=" + registerDate + ",custID="
				+ custID + ",pCustID=" + pCustID + ",parentsExpense=" + parentsExpense + ",amentiaExpense="
				+ amentiaExpense + ",family=" + family + ",fExpense=" + fExpense + ",fNumber=" + fNumber + ",note="
				+ note + ",supportID=" + supportID + ",amentiaName=" + amentiaName + ",parentsName=" + parentsName
				+ ",actWork=" + actWork + ",tel=" + tel + "]";
	}
}
