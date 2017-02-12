package com.jxh.pojo;

import java.sql.Timestamp;

/**
 * BcustBelongOrg entity. @author MyEclipse Persistence Tools
 */

public class BcustBelongOrgPayPojo implements java.io.Serializable {

	// Fields

	private String custBelongOrgId;
	private String custId;
	private String typeCode;
	private Double cost;
	private Integer cycle;
	private Timestamp validay;
	private String typeName;
	private String custCode;
	private String fullName;
	
	private String validayStr;
	
	
	// Constructors

	public String getValidayStr() {
		return validayStr;
	}

	public void setValidayStr(String validayStr) {
		this.validayStr = validayStr;
	}

	/** default constructor */
	public BcustBelongOrgPayPojo() {
	}

	/** minimal constructor */
	public BcustBelongOrgPayPojo(String custBelongOrgId) {
		this.custBelongOrgId = custBelongOrgId;
	}

	/** full constructor */
	public BcustBelongOrgPayPojo(String custBelongOrgId, String custId,
			String typeCode, Double cost, Integer cycle, Timestamp validay) {
		this.custBelongOrgId = custBelongOrgId;
		this.custId = custId;
		this.typeCode = typeCode;
		this.cost = cost;
		this.cycle = cycle;
		this.validay = validay;
	}

	// Property accessors

	public String getCustBelongOrgId() {
		return this.custBelongOrgId;
	}

	public void setCustBelongOrgId(String custBelongOrgId) {
		this.custBelongOrgId = custBelongOrgId;
	}

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getCycle() {
		return this.cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	public Timestamp getValiday() {
		return this.validay;
	}

	public void setValiday(Timestamp validay) {
		this.validay = validay;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	

}