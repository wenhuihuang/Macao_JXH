package com.jxh.pojo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

public class ActivityApplyPojo implements Serializable {
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
	private String actID;
	private String amentiaName;
	private String parentsName;

	private String fullName;

	private String workName;
	private int sex;
	private String workID;
	private String work;
	private String phone;
	private String workNO;
	
	private String custType;
	private String custCode;
	private String custNO;
	private String custNewNO;
	private int age;

	public ActivityApplyPojo() {
		super();
	}

	public ActivityApplyPojo(String applyID, int type, Date registerDate, String custID, String pCustID,
			BigDecimal parentsExpense, BigDecimal amentiaExpense, String family, BigDecimal fExpense, int fNumber,
			String note, String actID, String amentiaName, String parentsName, String workName, int sex, String workID,
			String work, String phone, String workNO, String custNO, String custNewNO, int age, String fullName,String custType,String custCode) {
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
		this.actID = actID;
		this.amentiaName = amentiaName;
		this.parentsName = parentsName;
		this.workName = workName;
		this.sex = sex;
		this.workID = workID;
		this.work = work;
		this.phone = phone;
		this.workNO = workNO;
		this.custNO = custNO;
		this.custNewNO = custNewNO;
		this.age = age;
		this.fullName = fullName;
		this.custType=custType;
		this.custCode=custCode;
	}

	public String getAmentiaName() {
		return amentiaName;
	}

	public void setAmentiaName(String amentiaName) {
		this.amentiaName = amentiaName;
	}

	public String getParentsName() {
		return parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public void setApplyID(String applyID) {
		this.applyID = applyID;
	}

	public String getApplyID() {
		return applyID;
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

	public BigDecimal getFExpense() {
		return fExpense;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
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

	public String getActID() {
		return actID;
	}

	public void setActID(String actID) {
		this.actID = actID;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getWorkID() {
		return workID;
	}

	public void setWorkID(String workID) {
		this.workID = workID;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWorkNO() {
		return workNO;
	}

	public void setWorkNO(String workNO) {
		this.workNO = workNO;
	}

	public String getCustNO() {
		if("0".equals(custType)){
			custNO = "";
		}else{
			custNO = custCode;
		}
		return custNO;
	}

	public void setCustNO(String custNO) {
		if("1".equals(custType) || "2".equals(custType)){
			this.custNO = custCode;
		}
		this.custNO = custNO;
	}

	public String getCustNewNO() {
		if("1".equals(custType) || "2".equals(custType)){
			custNewNO = "";
		}else{
			custNewNO = custCode;
		}
		return custNewNO;
	}

	public void setCustNewNO(String custNewNO) {
		if("0".equals(custType)){
			this.custCode=custNewNO;
		}
		this.custNewNO = custNewNO;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	@Override
	public String toString() {
		return "ActivityApply [applyID=" + applyID + ",type=" + type + ",registerDate=" + registerDate + ",custID="
				+ custID + ",pCustID=" + pCustID + ",parentsExpense=" + parentsExpense + ",amentiaExpense="
				+ amentiaExpense + ",family=" + family + ",fExpense=" + fExpense + ",fNumber=" + fNumber + ",note="
				+ note + ",actID=" + actID + ",amentiaName=" + amentiaName + ",parentsName=" + parentsName
				+ ",workName=" + workName + ",sex=" + sex + ",workID=" + workID + ",work=" + work + ",phone=" + phone
				+ ",workNO=" + workNO + ",custNO=" + custNO + ",custNewNO=" + custNewNO + ",age=" + age + ",fullName="
				+ fullName + ",custType="+custType+",custCode="+custCode+"]";
	}

}
