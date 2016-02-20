package com.jxh.pojo;

/**
 * QxUsers entity. @author MyEclipse Persistence Tools
 */

public class QxUsers implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userCode;
	private String userName;
	private String corpId;
	private String password;
	private String disChangePwd;
	private String nextMustChangePwd;
	private String note;
	private String isStop;
	private String fetionNo;
	private String fetionPwd;
	private String loginIp;
	private String cardNo;
	private String belongOrg;

	// Constructors

	/** default constructor */
	public QxUsers() {
	}

	/** minimal constructor */
	public QxUsers(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public QxUsers(String userId, String userCode, String userName,
			String corpId, String password, String disChangePwd,
			String nextMustChangePwd, String note, String isStop,
			String fetionNo, String fetionPwd, String loginIp, String cardNo,
			String belongOrg) {
		this.userId = userId;
		this.userCode = userCode;
		this.userName = userName;
		this.corpId = corpId;
		this.password = password;
		this.disChangePwd = disChangePwd;
		this.nextMustChangePwd = nextMustChangePwd;
		this.note = note;
		this.isStop = isStop;
		this.fetionNo = fetionNo;
		this.fetionPwd = fetionPwd;
		this.loginIp = loginIp;
		this.cardNo = cardNo;
		this.belongOrg = belongOrg;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCorpId() {
		return this.corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisChangePwd() {
		return this.disChangePwd;
	}

	public void setDisChangePwd(String disChangePwd) {
		this.disChangePwd = disChangePwd;
	}

	public String getNextMustChangePwd() {
		return this.nextMustChangePwd;
	}

	public void setNextMustChangePwd(String nextMustChangePwd) {
		this.nextMustChangePwd = nextMustChangePwd;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIsStop() {
		return this.isStop;
	}

	public void setIsStop(String isStop) {
		this.isStop = isStop;
	}

	public String getFetionNo() {
		return this.fetionNo;
	}

	public void setFetionNo(String fetionNo) {
		this.fetionNo = fetionNo;
	}

	public String getFetionPwd() {
		return this.fetionPwd;
	}

	public void setFetionPwd(String fetionPwd) {
		this.fetionPwd = fetionPwd;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getBelongOrg() {
		return this.belongOrg;
	}

	public void setBelongOrg(String belongOrg) {
		this.belongOrg = belongOrg;
	}

	@Override
	public String toString() {
		return "QxUsers [userId=" + userId + ", userCode=" + userCode
				+ ", userName=" + userName + ", corpId=" + corpId
				+ ", password=" + password + ", disChangePwd=" + disChangePwd
				+ ", nextMustChangePwd=" + nextMustChangePwd + ", note=" + note
				+ ", isStop=" + isStop + ", fetionNo=" + fetionNo
				+ ", fetionPwd=" + fetionPwd + ", loginIp=" + loginIp
				+ ", cardNo=" + cardNo + ", belongOrg=" + belongOrg + "]";
	}

	
	
}