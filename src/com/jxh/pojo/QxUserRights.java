package com.jxh.pojo;

import java.io.Serializable;

/** qx_UserRights
	USERRIGHTSID	INT(10)
	USERID	VARCHAR(16)
	FUNCID	VARCHAR(32)
	FVIEW	CHAR(1)
	FADD	CHAR(1)
	FMODIFY	CHAR(1)
	FDELETE	CHAR(1)
	FVIEWPRICE	CHAR(1)
	FPRINT	CHAR(1)
	FDESIGNREPORT	CHAR(1)
	FEXPORTDATA	CHAR(1)
	FCHECK	CHAR(1)
	FUNCHECK	CHAR(1)
	FDISUSE	CHAR(1)
	FUNDISUSE	CHAR(1)
	FEXECUTE	CHAR(1)
	ALLCORPRIGHT	CHAR(1)

userRightsID,userID,funcID,fView,fAdd,fModify,fDelete,fViewPrice,fPrint,fDesignReport,fExportData,fCheck,fUnCheck,fDisuse,fUnDisuse,fExecute,allCorpRight
?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?

qx_UserRights.userRightsID,qx_UserRights.userID,qx_UserRights.funcID,qx_UserRights.fView,qx_UserRights.fAdd,qx_UserRights.fModify,qx_UserRights.fDelete,qx_UserRights.fViewPrice,qx_UserRights.fPrint,qx_UserRights.fDesignReport,qx_UserRights.fExportData,qx_UserRights.fCheck,qx_UserRights.fUnCheck,qx_UserRights.fDisuse,qx_UserRights.fUnDisuse,qx_UserRights.fExecute,qx_UserRights.allCorpRight

userRightsID=?,userID=?,funcID=?,fView=?,fAdd=?,fModify=?,fDelete=?,fViewPrice=?,fPrint=?,fDesignReport=?,fExportData=?,fCheck=?,fUnCheck=?,fDisuse=?,fUnDisuse=?,fExecute=?,allCorpRight=?
*/
public class QxUserRights implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer userRightsID;
	private String userID;
	private String funcID;
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

	
	public String getFuncType() {
		return funcID;
	}

	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}

	public String getFuncName() {
		return funcID;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	private String funcType;
	private String funcName;
	// Constructors

	/** default constructor */
	public QxUserRights() {
	}

	/** minimal constructor */
	public QxUserRights(Integer userRightsID, String userID, String funcID) {
		this.userRightsID = userRightsID;
		this.userID = userID;
		this.funcID = funcID;
	}

	/** full constructor */
	public QxUserRights(Integer userRightsID, String userID, String funcID,
			String fview, String fadd, String fmodify, String fdelete,
			String fviewPrice, String fprint, String fdesignReport,
			String fexportData, String fcheck, String funCheck, String fdisuse,
			String funDisuse, String fexecute, String allCorpRight) {
		this.userRightsID = userRightsID;
		this.userID = userID;
		this.funcID = funcID;
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

	public Integer getUserRightsID() {
		return this.userRightsID;
	}

	public void setUserRightsID(Integer userRightsID) {
		this.userRightsID = userRightsID;
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFuncID() {
		return this.funcID;
	}

	public void setFuncID(String funcID) {
		this.funcID = funcID;
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
	@Override
	public String toString(){
		return "Qx_UserRights [userRightsID="+userRightsID+",userID="+userID+",funcID="+funcID+",fview="+fview+",fadd="+fadd+",fmodify="+fmodify+",fdelete="+fdelete+",fviewPrice="+fviewPrice+",fprint="+fprint+",fdesignReport="+fdesignReport+",fexportData="+fexportData+",fcheck="+fcheck+",funCheck="+funCheck+",fdisuse="+fdisuse+",funDisuse="+funDisuse+",fexecute="+fexecute+",allCorpRight="+allCorpRight+"]";
	}
}