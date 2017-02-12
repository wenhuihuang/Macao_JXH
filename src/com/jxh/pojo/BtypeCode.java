package com.jxh.pojo;

/**
 * BtypeCode entity. @author MyEclipse Persistence Tools
 */

public class BtypeCode implements java.io.Serializable {

	// Fields

	private String typeCode;
	private String typeName;
	private Integer levels;
	private String typeParentCode;
	private String typeBase;
	private String type2;
	private String updateTime;
	private String typeNameEng;
	private String cookType;
	private Double cost;
	private Integer cycle;

	
	private String id;
	private String pid;
	private String text;
	public String getId() {
		return typeCode;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return typeParentCode;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getText() {
		return typeName;
	}
	public void setText(String text) {
		this.text = text;
	}
	// Constructors

	/** default constructor */
	public BtypeCode() {
	}

	/** minimal constructor */
	public BtypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/** full constructor */
	public BtypeCode(String typeCode, String typeName, Integer levels,
			String typeParentCode, String typeBase, String type2,
			String updateTime, String typeNameEng, String cookType,
			Double cost, Integer cycle) {
		this.typeCode = typeCode;
		this.typeName = typeName;
		this.levels = levels;
		this.typeParentCode = typeParentCode;
		this.typeBase = typeBase;
		this.type2 = type2;
		this.updateTime = updateTime;
		this.typeNameEng = typeNameEng;
		this.cookType = cookType;
		this.cost = cost;
		this.cycle = cycle;
	}

	// Property accessors

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getLevels() {
		return this.levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	public String getTypeParentCode() {
		return this.typeParentCode;
	}

	public void setTypeParentCode(String typeParentCode) {
		this.typeParentCode = typeParentCode;
	}

	public String getTypeBase() {
		return this.typeBase;
	}

	public void setTypeBase(String typeBase) {
		this.typeBase = typeBase;
	}

	public String getType2() {
		return this.type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getTypeNameEng() {
		return this.typeNameEng;
	}

	public void setTypeNameEng(String typeNameEng) {
		this.typeNameEng = typeNameEng;
	}

	public String getCookType() {
		return this.cookType;
	}

	public void setCookType(String cookType) {
		this.cookType = cookType;
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
	@Override
	public String toString() {
		return "BtypeCode [typeCode=" + typeCode + ", typeName=" + typeName
				+ ", levels=" + levels + ", typeParentCode=" + typeParentCode
				+ ", typeBase=" + typeBase + ", type2=" + type2
				+ ", updateTime=" + updateTime + ", typeNameEng=" + typeNameEng
				+ ", cookType=" + cookType + ", cost=" + cost + ", cycle="
				+ cycle + ", id=" + id + ", pid=" + pid + ", text=" + text
				+ "]";
	}
	
	

}