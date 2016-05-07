package com.jxh.pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import com.fg.utils.ToolsUtils;

public class CustCasePojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String caseID;
	private String caseNO;
	private String custID;
	private String fullName;
	private String isMember;
	private String custType;
	private Date receiveDate;
	private Date closeDate;
	private int caseStatus;
	private String caseWorker;
	private String closeWorker;
	private String note;
	private int caseSource;
	private String sex;
	private Date birthday_Chn;
	private String cardNO;// 身份證
	private String goldCard;// 金卡
	private String mobileTelNO;// 聯繫電話
	private String father;
	private String mother;
	private String linkAdr;// 居住地
	private int isMarry;
	private String edulevel;// 教育程度
	private String economics;
	private String caseProblem;
	private String caseRequest;
	private String caseAction;
	private int initAssess;
	private int suggest;
	private String handler;
	private String form;
	private String place;
	private String family;
	private String otherMan;
	private int times;
	private String recordAdmin;
	private String title;
	private String content;
	private String analysis;
	private String ways;
	private Date handleDate;
	private String handleSuggest;
	private int handleWay;
	private String disposeWorker;
	private String summaryID;
	private String summaryDetail;
	private String summaryNeed;
	private String assessWorker;
	private String background;
	private String problem;
	private String objective;
	private String describe;
	private Date talksDate;
	private String talksTime;
	private Date assessDate;
	private Date disposeDate;
	private String caseSourceDetail;
	private Date problemDate;
	private String problemAdmin;
	private Date requestDate;
	private String requestAdmin;
	private Date actionDate;
	private String actionAdmin;
	private String initAssessDetail;
	private String manager;
	private Date manageDate;
	private String manageSuggest;
	private String handleWayDetail;
	private String closePeople;

	//
	private String receiveDate_str;
	private String closeDate_str;
	private String birthday_ChnStr;
	private String handleDate_str;
	private String talksDate_str;
	private String assessDate_str;
	private String disposeDate_str;
	private String problemDate_str;
	private String requestDate_str;
	private String actionDate_str;
	private String manageDate_str;

	public CustCasePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustCasePojo(String caseID, String caseNO, String fullName, String isMember, Date receiveDate,
			Date closeDate, int caseStatus, String caseWorker, String closeWorker, String note, int caseSource,
			String receiveDate_str, String closeDate_str, String sex, Date birthday_Chn, String birthday_ChnStr,
			String cardNO, String goldCard, String mobileTelNO, String father, String mother, String linkAdr,
			int isMarry, String edulevel, String economics, String caseProblem, String caseRequest, String caseAction,
			int initAssess, int suggest, String handler, String form, String place, String family, String otherMan,
			int times, String recordAdmin, String title, String content, String analysis, String ways, Date handleDate,
			String handleSuggest, String handleDate_str, int handleWay, String disposeWorker, String custID,
			String summaryID, String summaryDetail, String summaryNeed, String assessWorker, String background,
			String problem, String objective, String describe, Date talksDate, String talksDate_str, String talksTime,
			Date assessDate, String assessDate_str, Date disposeDate, String disposeDate_str, String caseSourceDetail,
			Date problemDate, String problemDate_str, String problemAdmin, Date requestDate, String requestDate_str,
			String requestAdmin, Date actionDate, String actionDate_str, String actionAdmin, String initAssessDetail,
			String manager, Date manageDate, String manageDate_str, String manageSuggest, String handleWayDetail,
			String closePeople, String custType) {
		super();
		this.caseID = caseID;
		this.caseNO = caseNO;
		this.fullName = fullName;
		this.isMember = isMember;
		this.receiveDate = receiveDate;
		this.closeDate = closeDate;
		this.caseStatus = caseStatus;
		this.caseWorker = caseWorker;
		this.closeWorker = closeWorker;
		this.note = note;
		this.caseSource = caseSource;
		this.custID = custID;
		this.receiveDate_str = receiveDate_str;
		this.closeDate_str = closeDate_str;
		this.sex = sex;
		this.birthday_Chn = birthday_Chn;
		this.birthday_ChnStr = birthday_ChnStr;
		this.cardNO = cardNO;
		this.goldCard = goldCard;
		this.economics = economics;
		this.caseProblem = caseProblem;
		this.caseRequest = caseRequest;
		this.caseAction = caseAction;
		this.initAssess = initAssess;
		this.suggest = suggest;
		this.handler = handler;
		this.form = form;
		this.place = place;
		this.family = family;
		this.otherMan = otherMan;
		this.times = times;
		this.recordAdmin = recordAdmin;
		this.title = title;
		this.content = content;
		this.analysis = analysis;
		this.ways = ways;
		this.handleDate = handleDate;
		this.handleSuggest = handleSuggest;
		this.handleDate_str = handleDate_str;
		this.handleWay = handleWay;
		this.disposeWorker = disposeWorker;
		this.summaryID = summaryID;
		this.summaryDetail = summaryDetail;
		this.summaryNeed = summaryNeed;
		this.assessWorker = assessWorker;
		this.background = background;
		this.problem = problem;
		this.objective = objective;
		this.describe = describe;
		this.talksDate = talksDate;
		this.talksDate_str = talksDate_str;
		this.talksTime = talksTime;
		this.assessDate = assessDate;
		this.assessDate_str = assessDate_str;
		this.disposeDate = disposeDate;
		this.disposeDate_str = disposeDate_str;
		this.caseSourceDetail = caseSourceDetail;
		this.problemDate = problemDate;
		this.problemDate_str = problemDate_str;
		this.problemAdmin = problemAdmin;
		this.requestDate = requestDate;
		this.requestDate_str = requestDate_str;
		this.requestAdmin = requestAdmin;
		this.actionDate = actionDate;
		this.actionDate_str = actionDate_str;
		this.actionAdmin = actionAdmin;
		this.initAssessDetail = initAssessDetail;
		this.manager = manager;
		this.manageDate = manageDate;
		this.manageDate_str = manageDate_str;
		this.manageSuggest = manageSuggest;
		this.handleWayDetail = handleWayDetail;
		this.closePeople = closePeople;
		this.custType = custType;
	}

	public String getCaseNO() {
		return caseNO;
	}

	public void setCaseNO(String caseNO) {
		this.caseNO = caseNO;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIsMember() {
		return isMember;
	}

	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getCaseID() {
		return caseID;
	}

	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public int getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(int caseStatus) {
		this.caseStatus = caseStatus;
	}

	public String getCaseWorker() {
		return caseWorker;
	}

	public void setCaseWorker(String caseWorker) {
		this.caseWorker = caseWorker;
	}

	public String getCloseWorker() {
		return closeWorker;
	}

	public void setCloseWorker(String closeWorker) {
		this.closeWorker = closeWorker;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getReceiveDate_str() {
		try {
			return receiveDate == null || "".equals(receiveDate) ? ""
					: ToolsUtils.getDateStringByFormat(receiveDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setReceiveDate_str(String receiveDate_str) {
		this.receiveDate_str = receiveDate_str;
	}

	public String getCloseDate_str() {
		try {
			return closeDate == null || "".equals(closeDate) ? ""
					: ToolsUtils.getDateStringByFormat(closeDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setCloseDate_str(String closeDate_str) {
		this.closeDate_str = closeDate_str;
	}

	public int getCaseSource() {
		return caseSource;
	}

	public void setCaseSource(int caseSource) {
		this.caseSource = caseSource;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday_Chn() {
		return birthday_Chn;
	}

	public void setBirthday_Chn(Date birthday_Chn) {
		this.birthday_Chn = birthday_Chn;
	}

	public String getCardNO() {
		return cardNO;
	}

	public void setCardNO(String cardNO) {
		this.cardNO = cardNO;
	}

	public String getGoldCard() {
		return goldCard;
	}

	public void setGoldCard(String goldCard) {
		this.goldCard = goldCard;
	}

	public String getMobileTelNO() {
		return mobileTelNO;
	}

	public void setMobileTelNO(String mobileTelNO) {
		this.mobileTelNO = mobileTelNO;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getLinkAdr() {
		return linkAdr;
	}

	public void setLinkAdr(String linkAdr) {
		this.linkAdr = linkAdr;
	}

	public int getIsMarry() {
		return isMarry;
	}

	public void setIsMarry(int isMarry) {
		this.isMarry = isMarry;
	}

	public String getEdulevel() {
		return edulevel;
	}

	public void setEdulevel(String edulevel) {
		this.edulevel = edulevel;
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

	public String getCaseRequest() {
		return caseRequest;
	}

	public void setCaseRequest(String caseRequest) {
		this.caseRequest = caseRequest;
	}

	public String getCaseAction() {
		return caseAction;
	}

	public void setCaseAction(String caseAction) {
		this.caseAction = caseAction;
	}

	public int getInitAssess() {
		return initAssess;
	}

	public void setInitAssess(int initAssess) {
		this.initAssess = initAssess;
	}

	public int getSuggest() {
		return suggest;
	}

	public void setSuggest(int suggest) {
		this.suggest = suggest;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getOtherMan() {
		return otherMan;
	}

	public void setOtherMan(String otherMan) {
		this.otherMan = otherMan;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public String getRecordAdmin() {
		return recordAdmin;
	}

	public void setRecordAdmin(String recordAdmin) {
		this.recordAdmin = recordAdmin;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getWays() {
		return ways;
	}

	public void setWays(String ways) {
		this.ways = ways;
	}

	public Date getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}

	public String getHandleSuggest() {
		return handleSuggest;
	}

	public void setHandleSuggest(String handleSuggest) {
		this.handleSuggest = handleSuggest;
	}

	public String getBirthday_ChnStr() {
		try {
			return birthday_Chn == null || "".equals(birthday_Chn) ? ""
					: ToolsUtils.getDateStringByFormat(birthday_Chn, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setBirthday_ChnStr(String birthday_ChnStr) {
		this.birthday_ChnStr = birthday_ChnStr;
	}

	public String getHandleDate_str() {
		try {
			return handleDate == null || "".equals(handleDate) ? ""
					: ToolsUtils.getDateStringByFormat(handleDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setHandleDate_str(String handleDate_str) {
		this.handleDate_str = handleDate_str;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public int getHandleWay() {
		return handleWay;
	}

	public void setHandleWay(int handleWay) {
		this.handleWay = handleWay;
	}

	public String getDisposeWorker() {
		return disposeWorker;
	}

	public void setDisposeWorker(String disposeWorker) {
		this.disposeWorker = disposeWorker;
	}

	public String getSummaryDetail() {
		return summaryDetail;
	}

	public void setSummaryDetail(String summaryDetail) {
		this.summaryDetail = summaryDetail;
	}

	public String getSummaryNeed() {
		return summaryNeed;
	}

	public void setSummaryNeed(String summaryNeed) {
		this.summaryNeed = summaryNeed;
	}

	public String getAssessWorker() {
		return assessWorker;
	}

	public void setAssessWorker(String assessWorker) {
		this.assessWorker = assessWorker;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getSummaryID() {
		return summaryID;
	}

	public void setSummaryID(String summaryID) {
		this.summaryID = summaryID;
	}

	public Date getTalksDate() {
		return talksDate;
	}

	public void setTalksDate(Date talksDate) {
		this.talksDate = talksDate;
	}

	public String getTalksTime() {
		return talksTime;
	}

	public void setTalksTime(String talksTime) {
		this.talksTime = talksTime;
	}

	public String getTalksDate_str() {
		try {
			return talksDate == null || "".equals(talksDate) ? ""
					: ToolsUtils.getDateStringByFormat(talksDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setTalksDate_str(String talksDate_str) {
		this.talksDate_str = talksDate_str;
	}

	public Date getAssessDate() {
		return assessDate;
	}

	public void setAssessDate(Date assessDate) {
		this.assessDate = assessDate;
	}

	public String getAssessDate_str() {
		try {
			return assessDate == null || "".equals(assessDate) ? ""
					: ToolsUtils.getDateStringByFormat(assessDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setAssessDate_str(String assessDate_str) {
		this.assessDate_str = assessDate_str;
	}

	public Date getDisposeDate() {
		return disposeDate;
	}

	public void setDisposeDate(Date disposeDate) {
		this.disposeDate = disposeDate;
	}

	public String getDisposeDate_str() {
		try {
			return disposeDate == null || "".equals(disposeDate) ? ""
					: ToolsUtils.getDateStringByFormat(disposeDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setDisposeDate_str(String disposeDate_str) {
		this.disposeDate_str = disposeDate_str;
	}

	public String getCaseSourceDetail() {
		return caseSourceDetail;
	}

	public void setCaseSourceDetail(String caseSourceDetail) {
		this.caseSourceDetail = caseSourceDetail;
	}

	public Date getProblemDate() {
		return problemDate;
	}

	public void setProblemDate(Date problemDate) {
		this.problemDate = problemDate;
	}

	public String getProblemDate_str() {
		try {
			return problemDate == null || "".equals(problemDate) ? ""
					: ToolsUtils.getDateStringByFormat(problemDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setProblemDate_str(String problemDate_str) {
		this.problemDate_str = problemDate_str;
	}

	public String getProblemAdmin() {
		return problemAdmin;
	}

	public void setProblemAdmin(String problemAdmin) {
		this.problemAdmin = problemAdmin;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestDate_str() {
		try {
			return requestDate == null || "".equals(requestDate) ? ""
					: ToolsUtils.getDateStringByFormat(requestDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setRequestDate_str(String requestDate_str) {
		this.requestDate_str = requestDate_str;
	}

	public String getRequestAdmin() {
		return requestAdmin;
	}

	public void setRequestAdmin(String requestAdmin) {
		this.requestAdmin = requestAdmin;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public String getActionDate_str() {
		try {
			return actionDate == null || "".equals(actionDate) ? ""
					: ToolsUtils.getDateStringByFormat(actionDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setActionDate_str(String actionDate_str) {
		this.actionDate_str = actionDate_str;
	}

	public String getActionAdmin() {
		return actionAdmin;
	}

	public void setActionAdmin(String actionAdmin) {
		this.actionAdmin = actionAdmin;
	}

	public String getInitAssessDetail() {
		return initAssessDetail;
	}

	public void setInitAssessDetail(String initAssessDetail) {
		this.initAssessDetail = initAssessDetail;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Date getManageDate() {
		return manageDate;
	}

	public void setManageDate(Date manageDate) {
		this.manageDate = manageDate;
	}

	public String getManageDate_str() {
		try {
			return manageDate == null || "".equals(manageDate) ? ""
					: ToolsUtils.getDateStringByFormat(manageDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setManageDate_str(String manageDate_str) {
		this.manageDate_str = manageDate_str;
	}

	public String getManageSuggest() {
		return manageSuggest;
	}

	public void setManageSuggest(String manageSuggest) {
		this.manageSuggest = manageSuggest;
	}

	public String getHandleWayDetail() {
		return handleWayDetail;
	}

	public void setHandleWayDetail(String handleWayDetail) {
		this.handleWayDetail = handleWayDetail;
	}

	public String getClosePeople() {
		return closePeople;
	}

	public void setClosePeople(String closePeople) {
		this.closePeople = closePeople;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	@Override
	public String toString() {
		return "CustCasePojo [caseID=" + caseID + ",caseNO=" + caseNO + ", fullName=" + fullName + ", receiveDate="
				+ receiveDate + ", isMember=" + isMember + ",receiveDate_str=" + receiveDate_str + ",closeDate="
				+ closeDate + ",closeDate_str=" + closeDate_str + ",caseStatus=" + caseStatus + ",caseWorker="
				+ caseWorker + ",closeWorker=" + closeWorker + ",note=" + note + ",caseSource=" + caseSource
				+ ",custID=" + custID + ",sex=" + sex + ",birthday_Chn=" + birthday_Chn + ",birthday_ChnStr="
				+ birthday_ChnStr + ",cardNO=" + cardNO + ",goldCard=" + goldCard + ",mobileTelNO=" + mobileTelNO
				+ ",father=" + father + ",mother=" + mother + ",linkAdr=" + linkAdr + ",isMarry=" + isMarry
				+ ",edulevel=" + edulevel + ",economics=" + economics + ",caseProblem=" + caseProblem + ",caseRequest="
				+ caseRequest + ",caseAction=" + caseAction + ",initAssess=" + initAssess + ",suggest=" + suggest
				+ ",handler=" + handler + ",form=" + form + ",place=" + place + ",family=" + family + ",otherMan="
				+ otherMan + ",times=" + times + ",recordAdmin=" + recordAdmin + ",title=" + title + ",content="
				+ content + ",analysis=" + analysis + ",ways=" + ways + ",handleDate=" + handleDate + ",handleSuggest="
				+ handleSuggest + ",handleDate_str=" + handleDate_str + ",handleWay=" + handleWay + ",disposeWorker="
				+ disposeWorker + ",summaryID=" + summaryID + ",summaryDetail=" + summaryDetail + ",summaryNeed="
				+ summaryNeed + ",assessWorker=" + assessWorker + ",background=" + background + ",problem=" + problem
				+ ",objective=" + objective + ",describe=" + describe + ",talksDate=" + talksDate + ",talksDate_str="
				+ talksDate_str + ",talksTime=" + talksTime + ",assessDate=" + assessDate + ",assessDate_str="
				+ assessDate_str + ",disposeDate=" + disposeDate + ",disposeDate_str=" + disposeDate_str
				+ ",caseSourceDetail=" + caseSourceDetail + ",problemDate=" + problemDate + ",problemDate_str="
				+ problemDate_str + ",problemAdmin=" + problemAdmin + ",requestDate=" + requestDate
				+ ",requestDate_str=" + requestDate_str + ",requestAdmin=" + requestAdmin + ",actionDate=" + actionDate
				+ ",actionDate_str=" + actionDate_str + ",actionAdmin=" + actionAdmin + ",initAssessDetail="
				+ initAssessDetail + ",manager=" + manager + ",manageDate=" + manageDate + ",manageDate_str="
				+ manageDate_str + ",manageSuggest=" + manageSuggest + ",handleWayDetail=" + handleWayDetail
				+ ",closePeople=" + closePeople + ",custType=" + custType + "]";
	}

}
