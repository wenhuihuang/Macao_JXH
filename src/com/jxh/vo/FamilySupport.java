package com.jxh.vo;

import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.math.*;
import java.text.ParseException;

/**
 * FamilySupport
 * 
 * supportID,supportName,expense1,expense2,expense3,expense4,time,way,onlineCan,
 * offlineCan,onlineThen,offlineThen,integral,isOnly,applyBDate,applyEDate,
 * supportBDate,supportEDate,address,principal,registrant,supportNO
 * ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?
 * 
 * familySupport.supportID,familySupport.supportName,familySupport.expense1,
 * familySupport.expense2,familySupport.expense3,familySupport.expense4,
 * familySupport.time,familySupport.way,familySupport.onlineCan,familySupport.
 * offlineCan,familySupport.onlineThen,familySupport.offlineThen,familySupport.
 * integral,familySupport.isOnly,familySupport.applyBDate,familySupport.
 * applyEDate,familySupport.supportBDate,familySupport.supportEDate,
 * familySupport.address,familySupport.principal,familySupport.registrant,
 * familySupport.supportNO
 * 
 * supportID=?,supportName=?,expense1=?,expense2=?,expense3=?,expense4=?,time=?,
 * way=?,onlineCan=?,offlineCan=?,onlineThen=?,offlineThen=?,integral=?,isOnly=?
 * ,applyBDate=?,applyEDate=?,supportBDate=?,supportEDate=?,address=?,principal=
 * ?,registrant=?,supportNO=?
 */
public class FamilySupport implements Serializable {
	private static final long serialVersionUID = 1L;
	private String supportID;
	private String supportName;
	private BigDecimal expense1;
	private BigDecimal expense2;
	private BigDecimal expense3;
	private BigDecimal expense4;
	private int time;
	private String way;
	private int onlineCan;
	private int offlineCan;
	private int onlineThen;
	private int offlineThen;
	private String integral;
	private int isOnly;
	private Date applyBDate;
	private Date applyEDate;
	private Date supportBDate;
	private Date supportEDate;
	private String address;
	private String principal;
	private String registrant;
	private String supportNO;

	private String applyBDate_str;
	private String applyEDate_str;
	private String supportBDate_str;
	private String supportEDate_str;

	public FamilySupport() {
		super();
	}

	public FamilySupport(String supportID, String supportName, BigDecimal expense1, BigDecimal expense2,
			BigDecimal expense3, BigDecimal expense4, int time, String way, int onlineCan, int offlineCan,
			int onlineThen, int offlineThen, String integral, int isOnly, Date applyBDate, Date applyEDate,
			Date supportBDate, Date supportEDate, String address, String principal, String registrant, String supportNO,
			String applyBDate_str, String applyEDate_str, String supportBDate_str, String supportEDate_str) {
		super();
		this.supportID = supportID;
		this.supportName = supportName;
		this.expense1 = expense1;
		this.expense2 = expense2;
		this.expense3 = expense3;
		this.expense4 = expense4;
		this.time = time;
		this.way = way;
		this.onlineCan = onlineCan;
		this.offlineCan = offlineCan;
		this.onlineThen = onlineThen;
		this.offlineThen = offlineThen;
		this.integral = integral;
		this.isOnly = isOnly;
		this.applyBDate = applyBDate;
		this.applyEDate = applyEDate;
		this.supportBDate = supportBDate;
		this.supportEDate = supportEDate;
		this.address = address;
		this.principal = principal;
		this.registrant = registrant;
		this.supportNO = supportNO;
		this.applyBDate_str = applyBDate_str;
		this.applyEDate_str = applyEDate_str;
		this.supportBDate_str = supportBDate_str;
		this.supportEDate_str = supportEDate_str;
	}

	public void setSupportID(String supportID) {
		this.supportID = supportID;
	}

	public String getSupportID() {
		return supportID;
	}

	public void setSupportName(String supportName) {
		this.supportName = supportName;
	}

	public String getSupportName() {
		return supportName;
	}

	public void setExpense1(BigDecimal expense1) {
		this.expense1 = expense1;
	}

	public BigDecimal getExpense1() {
		return expense1;
	}

	public void setExpense2(BigDecimal expense2) {
		this.expense2 = expense2;
	}

	public BigDecimal getExpense2() {
		return expense2;
	}

	public void setExpense3(BigDecimal expense3) {
		this.expense3 = expense3;
	}

	public BigDecimal getExpense3() {
		return expense3;
	}

	public void setExpense4(BigDecimal expense4) {
		this.expense4 = expense4;
	}

	public BigDecimal getExpense4() {
		return expense4;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getWay() {
		return way;
	}

	public void setOnlineCan(int onlineCan) {
		this.onlineCan = onlineCan;
	}

	public int getOnlineCan() {
		return onlineCan;
	}

	public void setOfflineCan(int offlineCan) {
		this.offlineCan = offlineCan;
	}

	public int getOfflineCan() {
		return offlineCan;
	}

	public void setOnlineThen(int onlineThen) {
		this.onlineThen = onlineThen;
	}

	public int getOnlineThen() {
		return onlineThen;
	}

	public void setOfflineThen(int offlineThen) {
		this.offlineThen = offlineThen;
	}

	public int getOfflineThen() {
		return offlineThen;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIsOnly(int isOnly) {
		this.isOnly = isOnly;
	}

	public int getIsOnly() {
		return isOnly;
	}

	public void setApplyBDate(Date applyBDate) {
		this.applyBDate = applyBDate;
	}

	public Date getApplyBDate() {
		return applyBDate;
	}

	public void setApplyEDate(Date applyEDate) {
		this.applyEDate = applyEDate;
	}

	public Date getApplyEDate() {
		return applyEDate;
	}

	public void setSupportBDate(Date supportBDate) {
		this.supportBDate = supportBDate;
	}

	public Date getSupportBDate() {
		return supportBDate;
	}

	public void setSupportEDate(Date supportEDate) {
		this.supportEDate = supportEDate;
	}

	public Date getSupportEDate() {
		return supportEDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setRegistrant(String registrant) {
		this.registrant = registrant;
	}

	public String getRegistrant() {
		return registrant;
	}

	public void setSupportNO(String supportNO) {
		this.supportNO = supportNO;
	}

	public String getSupportNO() {
		return supportNO;
	}

	public String getApplyBDate_str() {
		try {
			return applyBDate == null || "".equals(applyBDate) ? ""
					: ToolsUtils.getDateStringByFormat(applyBDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setApplyBDate_str(String applyBDate_str) {
		this.applyBDate_str = applyBDate_str;
	}

	public String getApplyEDate_str() {
		try {
			return applyEDate == null || "".equals(applyEDate) ? ""
					: ToolsUtils.getDateStringByFormat(applyEDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setApplyEDate_str(String applyEDate_str) {
		this.applyEDate_str = applyEDate_str;
	}

	public String getSupportBDate_str() {
		try {
			return supportBDate == null || "".equals(supportBDate) ? ""
					: ToolsUtils.getDateStringByFormat(supportBDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setSupportBDate_str(String supportBDate_str) {
		this.supportBDate_str = supportBDate_str;
	}

	public String getSupportEDate_str() {
		try {
			return supportEDate == null || "".equals(supportEDate) ? ""
					: ToolsUtils.getDateStringByFormat(supportEDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setSupportEDate_str(String supportEDate_str) {
		this.supportEDate_str = supportEDate_str;
	}

	@Override
	public String toString() {
		return "FamilySupport [supportID=" + supportID + ",supportName=" + supportName + ",expense1=" + expense1
				+ ",expense2=" + expense2 + ",expense3=" + expense3 + ",expense4=" + expense4 + ",time=" + time
				+ ",way=" + way + ",onlineCan=" + onlineCan + ",offlineCan=" + offlineCan + ",onlineThen=" + onlineThen
				+ ",offlineThen=" + offlineThen + ",integral=" + integral + ",isOnly=" + isOnly + ",applyBDate="
				+ applyBDate + ",applyEDate=" + applyEDate + ",supportBDate=" + supportBDate + ",supportEDate="
				+ supportEDate + ",address=" + address + ",principal=" + principal + ",registrant=" + registrant
				+ ",supportNO=" + supportNO + ",applyBDate_str=" + applyBDate_str + ",applyEDate_str" + applyEDate_str
				+ ",supportBDate_str=" + supportBDate_str + ",supportEDate_str=" + supportEDate_str + "]";
	}

}
