package com.jxh.pojo;

/**
 * QxUserRights entity. @author MyEclipse Persistence Tools
 */

public class QxUserRights implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userRightsId;
	private String userId;
	private String funcId;
	private String fview;
	private String fadd;
	private String fmodify;
	private String fdelete;
	private String fviewPrice;
	private String fprint;
	private String fdesignReport;
	private String fexportData;
	private String fcheck;
	private String funCheck;
	private String fdisuse;
	private String funDisuse;
	private String fexecute;
	private String allCorpRight;

	private String funcType;
	private String funcName;
	
	public String getFuncType() {
		return funcId;
	}

	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}

	public String getFuncName() {
		return funcId;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	// Constructors

	/** default constructor */
	public QxUserRights() {
	}

	/** minimal constructor */
	public QxUserRights(Integer userRightsId, String userId, String funcId) {
		this.userRightsId = userRightsId;
		this.userId = userId;
		this.funcId = funcId;
	}

	/** full constructor */
	public QxUserRights(Integer userRightsId, String userId, String funcId,
			String fview, String fadd, String fmodify, String fdelete,
			String fviewPrice, String fprint, String fdesignReport,
			String fexportData, String fcheck, String funCheck, String fdisuse,
			String funDisuse, String fexecute, String allCorpRight) {
		this.userRightsId = userRightsId;
		this.userId = userId;
		this.funcId = funcId;
		this.fview = fview;
		this.fadd = fadd;
		this.fmodify = fmodify;
		this.fdelete = fdelete;
		this.fviewPrice = fviewPrice;
		this.fprint = fprint;
		this.fdesignReport = fdesignReport;
		this.fexportData = fexportData;
		this.fcheck = fcheck;
		this.funCheck = funCheck;
		this.fdisuse = fdisuse;
		this.funDisuse = funDisuse;
		this.fexecute = fexecute;
		this.allCorpRight = allCorpRight;
	}

	// Property accessors

	public Integer getUserRightsId() {
		return this.userRightsId;
	}

	public void setUserRightsId(Integer userRightsId) {
		this.userRightsId = userRightsId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFuncId() {
		return this.funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getFview() {
		return this.fview;
	}

	public void setFview(String fview) {
		this.fview = fview;
	}

	public String getFadd() {
		return this.fadd;
	}

	public void setFadd(String fadd) {
		this.fadd = fadd;
	}

	public String getFmodify() {
		return this.fmodify;
	}

	public void setFmodify(String fmodify) {
		this.fmodify = fmodify;
	}

	public String getFdelete() {
		return this.fdelete;
	}

	public void setFdelete(String fdelete) {
		this.fdelete = fdelete;
	}

	public String getFviewPrice() {
		return this.fviewPrice;
	}

	public void setFviewPrice(String fviewPrice) {
		this.fviewPrice = fviewPrice;
	}

	public String getFprint() {
		return this.fprint;
	}

	public void setFprint(String fprint) {
		this.fprint = fprint;
	}

	public String getFdesignReport() {
		return this.fdesignReport;
	}

	public void setFdesignReport(String fdesignReport) {
		this.fdesignReport = fdesignReport;
	}

	public String getFexportData() {
		return this.fexportData;
	}

	public void setFexportData(String fexportData) {
		this.fexportData = fexportData;
	}

	public String getFcheck() {
		return this.fcheck;
	}

	public void setFcheck(String fcheck) {
		this.fcheck = fcheck;
	}

	public String getFunCheck() {
		return this.funCheck;
	}

	public void setFunCheck(String funCheck) {
		this.funCheck = funCheck;
	}

	public String getFdisuse() {
		return this.fdisuse;
	}

	public void setFdisuse(String fdisuse) {
		this.fdisuse = fdisuse;
	}

	public String getFunDisuse() {
		return this.funDisuse;
	}

	public void setFunDisuse(String funDisuse) {
		this.funDisuse = funDisuse;
	}

	public String getFexecute() {
		return this.fexecute;
	}

	public void setFexecute(String fexecute) {
		this.fexecute = fexecute;
	}

	public String getAllCorpRight() {
		return this.allCorpRight;
	}

	public void setAllCorpRight(String allCorpRight) {
		this.allCorpRight = allCorpRight;
	}

}