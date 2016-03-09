package com.jxh.vo;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import com.fg.utils.ToolsUtils;

public class BCustomer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String custID;
	private String custCode;
	private String fullName;
	private String fullNameEng;
	private String sex;
	private Date birthday_Chn;
	private String custType; // 會員類別
	private int cardStatus;
	private Date regDate;
	private Date validDate;
	private String initiationSource;
	private String cardType;
	private String cardNo;
	private String nativePlace;
	private int isMarry;
	private String edulevel;
	private String linkAdr;
	private String isSendLetter;
	private String mobileTelNO;
	private String telNo;
	private String email;
	private String isJob;
	private String jobPlace;
	private String custType2;// 1、智障人士、2 监护人
	private String isNormalToForever;
	private Date changeDate;
	private Date makeCardDate;
	private Date reciveCardDate;
	private String disabilityCardNo;
	private Date disabilityEndDate;
	private String selfCareAbility;
	private Double totalPoint;
	private Double totalIncome;
	private String backgroundInfo;
	private String governmentalHelp;
	private String governmentalHelpInfo;
	private String imgUrl;
	private String houseSitution;
	private int isCSSA;
	private int specialAllowance;

	private String relationship;
	private int isGuardian;
	private int isLiveTogether;
	private String guardianCustID;
	private String isMember;
	private String telNO_Work;
	private String jobSitution;
	private String jobType;
	private String custNO;
	private String custNewNO;

	private String birthday_ChnStr;
	private String validDateStr;
	private String regDateStr;
	private String changeDateStr;
	private String makeCardDateStr;
	private String reciveCardDateStr;
	private String disabilityEndDateStr;

	public BCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BCustomer(String custID, String custCode, String fullName, String fullNameEng, String sex, Date birthday_Chn,
			String custType, int cardStatus, Date regDate, Date validDate, String initiationSource, String cardType,
			String cardNo, String nativePlace, int isMarry, String edulevel, String linkAdr, String isSendLetter,
			String mobileTelNO, String telNo, String email, String isJob, String jobPlace, String custType2,
			String isNormalToForever, Date changeDate, Date makeCardDate, Date reciveCardDate, String disabilityCardNo,
			Date disabilityEndDate, String selfCareAbility, Double totalPoint, Double totalIncome,
			String backgroundInfo, String governmentalHelp, String governmentalHelpInfo, String imgUrl,
			String houseSitution, int isCSSA, int specialAllowance, String relationship, int isGuardian,
			int isLiveTogether, String guardianCustID, String isMember, String telNO_Work, String jobSitution,
			String jobType, String birthday_ChnStr, String validDateStr, String regDateStr, String changeDateStr,
			String makeCardDateStr, String reciveCardDateStr, String disabilityEndDateStr,String custNO,String custNewNO) {
		super();
		this.custID = custID;
		this.custCode = custCode;
		this.fullName = fullName;
		this.fullNameEng = fullNameEng;
		this.sex = sex;
		this.birthday_Chn = birthday_Chn;
		this.custType = custType;
		this.cardStatus = cardStatus;
		this.regDate = regDate;
		this.validDate = validDate;
		this.initiationSource = initiationSource;
		this.cardType = cardType;
		this.cardNo = cardNo;
		this.nativePlace = nativePlace;
		this.isMarry = isMarry;
		this.edulevel = edulevel;
		this.linkAdr = linkAdr;
		this.isSendLetter = isSendLetter;
		this.mobileTelNO = mobileTelNO;
		this.telNo = telNo;
		this.email = email;
		this.isJob = isJob;
		this.jobPlace = jobPlace;
		this.custType2 = custType2;
		this.isNormalToForever = isNormalToForever;
		this.changeDate = changeDate;
		this.makeCardDate = makeCardDate;
		this.reciveCardDate = reciveCardDate;
		this.disabilityCardNo = disabilityCardNo;
		this.disabilityEndDate = disabilityEndDate;
		this.selfCareAbility = selfCareAbility;
		this.totalPoint = totalPoint;
		this.totalIncome = totalIncome;
		this.backgroundInfo = backgroundInfo;
		this.governmentalHelp = governmentalHelp;
		this.governmentalHelpInfo = governmentalHelpInfo;
		this.imgUrl = imgUrl;
		this.houseSitution = houseSitution;
		this.isCSSA = isCSSA;
		this.specialAllowance = specialAllowance;
		this.relationship = relationship;
		this.isGuardian = isGuardian;
		this.isLiveTogether = isLiveTogether;
		this.guardianCustID = guardianCustID;
		this.isMember = isMember;
		this.telNO_Work = telNO_Work;
		this.jobSitution = jobSitution;
		this.jobType = jobType;
		this.birthday_ChnStr = birthday_ChnStr;
		this.validDateStr = validDateStr;
		this.regDateStr = regDateStr;
		this.changeDateStr = changeDateStr;
		this.makeCardDateStr = makeCardDateStr;
		this.reciveCardDateStr = reciveCardDateStr;
		this.disabilityEndDateStr = disabilityEndDateStr;
		this.custNO=custNO;
		this.custNewNO=custNewNO;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
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

	public String getFullNameEng() {
		return fullNameEng;
	}

	public void setFullNameEng(String fullNameEng) {
		this.fullNameEng = fullNameEng;
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

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public int getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(int cardStatus) {
		this.cardStatus = cardStatus;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public String getInitiationSource() {
		return initiationSource;
	}

	public void setInitiationSource(String initiationSource) {
		this.initiationSource = initiationSource;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
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

	public String getLinkAdr() {
		return linkAdr;
	}

	public void setLinkAdr(String linkAdr) {
		this.linkAdr = linkAdr;
	}

	public String getIsSendLetter() {
		return isSendLetter;
	}

	public void setIsSendLetter(String isSendLetter) {
		this.isSendLetter = isSendLetter;
	}

	public String getMobileTelNO() {
		return mobileTelNO;
	}

	public void setMobileTelNO(String mobileTelNO) {
		this.mobileTelNO = mobileTelNO;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsJob() {
		return isJob;
	}

	public void setIsJob(String isJob) {
		this.isJob = isJob;
	}

	public String getJobPlace() {
		return jobPlace;
	}

	public void setJobPlace(String jobPlace) {
		this.jobPlace = jobPlace;
	}

	public String getCustType2() {
		return custType2;
	}

	public void setCustType2(String custType2) {
		this.custType2 = custType2;
	}

	public String getIsNormalToForever() {
		return isNormalToForever;
	}

	public void setIsNormalToForever(String isNormalToForever) {
		this.isNormalToForever = isNormalToForever;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public Date getMakeCardDate() {
		return makeCardDate;
	}

	public void setMakeCardDate(Date makeCardDate) {
		this.makeCardDate = makeCardDate;
	}

	public Date getReciveCardDate() {
		return reciveCardDate;
	}

	public void setReciveCardDate(Date reciveCardDate) {
		this.reciveCardDate = reciveCardDate;
	}

	public String getDisabilityCardNo() {
		return disabilityCardNo;
	}

	public void setDisabilityCardNo(String disabilityCardNo) {
		this.disabilityCardNo = disabilityCardNo;
	}

	public Date getDisabilityEndDate() {
		return disabilityEndDate;
	}

	public void setDisabilityEndDate(Date disabilityEndDate) {
		this.disabilityEndDate = disabilityEndDate;
	}

	public String getSelfCareAbility() {
		return selfCareAbility;
	}

	public void setSelfCareAbility(String selfCareAbility) {
		this.selfCareAbility = selfCareAbility;
	}

	public Double getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Double totalPoint) {
		this.totalPoint = totalPoint;
	}

	public Double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(Double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public String getBackgroundInfo() {
		return backgroundInfo;
	}

	public void setBackgroundInfo(String backgroundInfo) {
		this.backgroundInfo = backgroundInfo;
	}

	public String getGovernmentalHelp() {
		return governmentalHelp;
	}

	public void setGovernmentalHelp(String governmentalHelp) {
		this.governmentalHelp = governmentalHelp;
	}

	public String getGovernmentalHelpInfo() {
		return governmentalHelpInfo;
	}

	public void setGovernmentalHelpInfo(String governmentalHelpInfo) {
		this.governmentalHelpInfo = governmentalHelpInfo;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getHouseSitution() {
		return houseSitution;
	}

	public void setHouseSitution(String houseSitution) {
		this.houseSitution = houseSitution;
	}

	public int getIsCSSA() {
		return isCSSA;
	}

	public void setIsCSSA(int isCSSA) {
		this.isCSSA = isCSSA;
	}

	public int getSpecialAllowance() {
		return specialAllowance;
	}

	public void setSpecialAllowance(int specialAllowance) {
		this.specialAllowance = specialAllowance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getValidDateStr() {
		try {
			return validDate == null || "".equals(validDate) ? ""
					: ToolsUtils.getDateStringByFormat(validDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getRegDateStr() {

		try {
			return regDate == null || "".equals(regDate) ? ""
					: ToolsUtils.getDateStringByFormat(regDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getChangeDateStr() {
		try {
			return changeDate == null || "".equals(changeDate) ? ""
					: ToolsUtils.getDateStringByFormat(changeDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getMakeCardDateStr() {
		try {
			return makeCardDate == null || "".equals(makeCardDate) ? ""
					: ToolsUtils.getDateStringByFormat(makeCardDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getReciveCardDateStr() {
		try {
			return reciveCardDate == null || "".equals(reciveCardDate) ? ""
					: ToolsUtils.getDateStringByFormat(reciveCardDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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

	public String getDisabilityEndDateStr() {
		try {
			return disabilityEndDate == null || "".equals(disabilityEndDate) ? ""
					: ToolsUtils.getDateStringByFormat(disabilityEndDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public int getIsGuardian() {
		return isGuardian;
	}

	public void setIsGuardian(int isGuardian) {
		this.isGuardian = isGuardian;
	}

	public int getIsLiveTogether() {
		return isLiveTogether;
	}

	public void setIsLiveTogether(int isLiveTogether) {
		this.isLiveTogether = isLiveTogether;
	}

	public String getGuardianCustID() {
		return guardianCustID;
	}

	public void setGuardianCustID(String guardianCustID) {
		this.guardianCustID = guardianCustID;
	}

	public void setBirthday_ChnStr(String birthday_ChnStr) {
		this.birthday_ChnStr = birthday_ChnStr;
	}

	public void setValidDateStr(String validDateStr) {
		this.validDateStr = validDateStr;
	}

	public void setRegDateStr(String regDateStr) {
		this.regDateStr = regDateStr;
	}

	public void setChangeDateStr(String changeDateStr) {
		this.changeDateStr = changeDateStr;
	}

	public void setMakeCardDateStr(String makeCardDateStr) {
		this.makeCardDateStr = makeCardDateStr;
	}

	public void setReciveCardDateStr(String reciveCardDateStr) {
		this.reciveCardDateStr = reciveCardDateStr;
	}

	public void setDisabilityEndDateStr(String disabilityEndDateStr) {
		this.disabilityEndDateStr = disabilityEndDateStr;
	}

	public String getIsMember() {
		return isMember;
	}

	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}

	public String getTelNO_Work() {
		return telNO_Work;
	}

	public void setTelNO_Work(String telNO_Work) {
		this.telNO_Work = telNO_Work;
	}

	public String getJobSitution() {
		return jobSitution;
	}

	public void setJobSitution(String jobSitution) {
		this.jobSitution = jobSitution;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	
	
	public String getCustNO() {
		return custNO;
	}

	public void setCustNO(String custNO) {
		this.custNO = custNO;
	}

	public String getCustNewNO() {
		return custNewNO;
	}

	public void setCustNewNO(String custNewNO) {
		this.custNewNO = custNewNO;
	}

	@Override
	public String toString() {
		return "BCustomer [custID=" + custID + ", custCode=" + custCode + ", fullName=" + fullName + ", fullNameEng="
				+ fullNameEng + ", sex=" + sex + ", birthday_Chn=" + birthday_Chn + ", custType=" + custType
				+ ", cardStatus=" + cardStatus + ", regDate=" + regDate + ", validDate=" + validDate
				+ ", initiationSource=" + initiationSource + ", cardType=" + cardType + ", cardNo=" + cardNo
				+ ", nativePlace=" + nativePlace + ", isMarry=" + isMarry + ", edulevel=" + edulevel + ", linkAdr="
				+ linkAdr + ", isSendLetter=" + isSendLetter + ", mobileTelNO=" + mobileTelNO + ", telNo=" + telNo
				+ ", email=" + email + ", isJob=" + isJob + ", jobPlace=" + jobPlace + ", custType2=" + custType2
				+ ", isNormalToForever=" + isNormalToForever + ", changeDate=" + changeDate + ", makeCardDate="
				+ makeCardDate + ", reciveCardDate=" + reciveCardDate + ", disabilityCardNo=" + disabilityCardNo
				+ ", disabilityEndDate=" + disabilityEndDate + ", selfCareAbility=" + selfCareAbility + ", totalPoint="
				+ totalPoint + ", totalIncome=" + totalIncome + ", backgroundInfo=" + backgroundInfo
				+ ", governmentalHelp=" + governmentalHelp + ", governmentalHelpInfo=" + governmentalHelpInfo
				+ ", imgUrl=" + imgUrl + ", houseSitution=" + houseSitution + ", isCSSA=" + isCSSA
				+ ", specialAllowance=" + specialAllowance + ", relationship=" + relationship + ", isGuardian="
				+ isGuardian + ", isLiveTogether=" + isLiveTogether + ", guardianCustID=" + guardianCustID
				+ ", isMember=" + isMember + ", telNO_Work=" + telNO_Work + ", jobSitution=" + jobSitution
				+ ", jobType=" + jobType + ", birthday_ChnStr=" + birthday_ChnStr + ", validDateStr=" + validDateStr
				+ ", regDateStr=" + regDateStr + ", changeDateStr=" + changeDateStr + ", makeCardDateStr="
				+ makeCardDateStr + ", reciveCardDateStr=" + reciveCardDateStr + ", disabilityEndDateStr="
				+ disabilityEndDateStr + ",custNO="+custNO+",custNewNO="+custNewNO+"]";
	}

}
