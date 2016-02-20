package com.jxh.pojo;

/**
 * QxFunctList entity. @author MyEclipse Persistence Tools
 */

public class QxFunctList implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String funcId;
	private String funcType;
	private String funcName;
	private Integer forder;
	private String funcBit;
	private String funcBelong;
	private Integer isHide;

	// Constructors

	/** default constructor */
	public QxFunctList() {
	}

	/** minimal constructor */
	public QxFunctList(String funcId) {
		this.funcId = funcId;
	}

	/** full constructor */
	public QxFunctList(String funcId, String funcType, String funcName,
			Integer forder, String funcBit, String funcBelong, Integer isHide) {
		this.funcId = funcId;
		this.funcType = funcType;
		this.funcName = funcName;
		this.forder = forder;
		this.funcBit = funcBit;
		this.funcBelong = funcBelong;
		this.isHide = isHide;
	}

	// Property accessors

	public String getFuncId() {
		return this.funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getFuncType() {
		return this.funcType;
	}

	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}

	public String getFuncName() {
		return this.funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public Integer getForder() {
		return this.forder;
	}

	public void setForder(Integer forder) {
		this.forder = forder;
	}

	public String getFuncBit() {
		return this.funcBit;
	}

	public void setFuncBit(String funcBit) {
		this.funcBit = funcBit;
	}

	public String getFuncBelong() {
		return this.funcBelong;
	}

	public void setFuncBelong(String funcBelong) {
		this.funcBelong = funcBelong;
	}

	public Integer getIsHide() {
		return this.isHide;
	}

	public void setIsHide(Integer isHide) {
		this.isHide = isHide;
	}

}