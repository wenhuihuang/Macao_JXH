package com.jxh.vo;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import com.fg.utils.ToolsUtils;

public class CustCase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String caseId;
	private String cssaNo;
	private Date billDate;
	private String caseWorder;
	private int caseStatus;
	private int caseSource;
	private String caseSourceDetail; 
	private String custId;
	private String custNo;
	private String custNewNo;
	private String economics;
	private String caseProblem;
	private Date problemDate;
	private String problemAdmin;
	private String caseRequest;
	private Date requestDate;
	private String requestAdmin;
	private String caseAction;
	private Date actionDate;
	private String actionAdmin;
	private int initAssess;
	private String initAssessDetail;
	private int suggert;
	private String handler;
	private Date handleDate;
	private int handleWay;
	private String handleWayDetail;
	private String handleSuggest;

	public CustCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustCase(String caseId, String cssaNo,Date billDate,String caseWorder,int caseStatus,int caseSource,
			String caseSourceDetail,String custId,String custNo,String custNewNo,String economics,String caseProblem,
			Date problemDate,String problemAdmin,String caseRequest,Date requestDate,String requestAdmin,String caseAction,
			Date actionDate,String actionAdmin,int initAssess,String initAssessDetail,int suggert,String handler,Date handleDate,
			int handleWay,String handleWayDetail,String handleSuggest) {
		super();
		this.caseId = caseId;
		this.cssaNo = cssaNo;
		this.billDate = billDate;
		this.caseWorder = caseWorder;
		this.caseStatus = caseStatus;
		this.caseSource = caseSource;
		this.caseSourceDetail = caseSourceDetail;
		this.custId = custId;
		this.custNo = custNo;
		this.custNewNo = custNewNo;
		this.economics = economics;
		this.caseProblem = caseProblem;
		this.problemDate = problemDate;
		this.problemAdmin = problemAdmin;
		this.caseRequest = caseRequest;
		this.requestDate = requestDate;
		this.requestAdmin = requestAdmin;
		this.caseAction = caseAction;
		this.handleWay = handleWay;
		this.handleWayDetail = handleWayDetail;
		this.handleSuggest = handleSuggest;
	}

	

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCssaNo() {
		return cssaNo;
	}

	public void setCssaNo(String cssaNo) {
		this.cssaNo = cssaNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getCaseWorder() {
		return caseWorder;
	}

	public void setCaseWorder(String caseWorder) {
		this.caseWorder = caseWorder;
	}

	public int getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(int caseStatus) {
		this.caseStatus = caseStatus;
	}

	public int getCaseSource() {
		return caseSource;
	}

	public void setCaseSource(int caseSource) {
		this.caseSource = caseSource;
	}

	public String getCaseSourceDetail() {
		return caseSourceDetail;
	}

	public void setCaseSourceDetail(String caseSourceDetail) {
		this.caseSourceDetail = caseSourceDetail;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getCustNewNo() {
		return custNewNo;
	}

	public void setCustNewNo(String custNewNo) {
		this.custNewNo = custNewNo;
	}

	public String getEconomics() {
		return economics;
	}

	public void setEconomics(String economics) {
		this.economics = economics;
	}

	public String getCaseProblem() {
		return caseProblem;
	}

	public void setCaseProblem(String caseProblem) {
		this.caseProblem = caseProblem;
	}

	public Date getProblemDate() {
		return problemDate;
	}

	public void setProblemDate(Date problemDate) {
		this.problemDate = problemDate;
	}

	public String getProblemAdmin() {
		return problemAdmin;
	}

	public void setProblemAdmin(String problemAdmin) {
		this.problemAdmin = problemAdmin;
	}

	public String getCaseRequest() {
		return caseRequest;
	}

	public void setCaseRequest(String caseRequest) {
		this.caseRequest = caseRequest;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestAdmin() {
		return requestAdmin;
	}

	public void setRequestAdmin(String requestAdmin) {
		this.requestAdmin = requestAdmin;
	}

	public String getCaseAction() {
		return caseAction;
	}

	public void setCaseAction(String caseAction) {
		this.caseAction = caseAction;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public String getActionAdmin() {
		return actionAdmin;
	}

	public void setActionAdmin(String actionAdmin) {
		this.actionAdmin = actionAdmin;
	}

	public int getInitAssess() {
		return initAssess;
	}

	public void setInitAssess(int initAssess) {
		this.initAssess = initAssess;
	}

	public String getInitAssessDetail() {
		return initAssessDetail;
	}

	public void setInitAssessDetail(String initAssessDetail) {
		this.initAssessDetail = initAssessDetail;
	}

	public int getSuggert() {
		return suggert;
	}

	public void setSuggert(int suggert) {
		this.suggert = suggert;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public Date getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}

	public int getHandleWay() {
		return handleWay;
	}

	public void setHandleWay(int handleWay) {
		this.handleWay = handleWay;
	}

	public String getHandleWayDetail() {
		return handleWayDetail;
	}

	public void setHandleWayDetail(String handleWayDetail) {
		this.handleWayDetail = handleWayDetail;
	}

	public String getHandleSuggest() {
		return handleSuggest;
	}

	public void setHandleSuggest(String handleSuggest) {
		this.handleSuggest = handleSuggest;
	}

	@Override
	public String toString() {
		return "BCustomer [caseId=" + caseId + ", cssaNo=" + cssaNo + ", billDate=" + billDate + ", caseWorder="
				+ caseWorder + ", caseStatus=" + caseStatus + ", caseSource=" + caseSource + ", caseSourceDetail=" + caseSourceDetail
				+ ", custId=" + custId + ", custNo=" + custNo + ", custNewNo=" + custNewNo
				+ ", economics=" + economics + ", caseProblem=" + caseProblem + ", problemDate=" + problemDate
				+ ", problemAdmin=" + problemAdmin + ", caseRequest=" + caseRequest + ", requestDate=" + requestDate + ", requestAdmin="
				+ requestAdmin + ", caseAction=" + caseAction + ", handleWay=" + handleWay + ", handleWayDetail=" + handleWayDetail
				+ ", handleSuggest=" + handleSuggest +"]";
	}

}
