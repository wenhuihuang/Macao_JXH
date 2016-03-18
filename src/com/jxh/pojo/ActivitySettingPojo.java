package com.jxh.pojo;

import java.io.Serializable;
import java.util.Date;
import java.math.*;

public class ActivitySettingPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String actID;
	private String actName;
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
	private Date actBDate;
	private Date actEDate;
	private String address;
	private String principal;
	private String registrant;
	private String actNO;

	private String participationTotal;
	private int applyTotal;

	public ActivitySettingPojo() {
		super();
	}

	public ActivitySettingPojo(String actID, String actName, BigDecimal expense1, BigDecimal expense2,
			BigDecimal expense3, BigDecimal expense4, int time, String way, int onlineCan, int offlineCan,
			int onlineThen, int offlineThen, String integral, int isOnly, Date applyBDate, Date applyEDate,
			Date actBDate, Date actEDate, String address, String principal, String registrant, String actNO,
			String participationTotal, int ApplyTotal) {
		super();
		this.actID = actID;
		this.actName = actName;
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
		this.actBDate = actBDate;
		this.actEDate = actEDate;
		this.address = address;
		this.principal = principal;
		this.registrant = registrant;
		this.actNO = actNO;
		this.participationTotal = participationTotal;
		this.applyTotal = applyTotal;
	}

	public void setActID(String actID) {
		this.actID = actID;
	}

	public String getActID() {
		return actID;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getActName() {
		return actName;
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

	public void setActBDate(Date actBDate) {
		this.actBDate = actBDate;
	}

	public Date getActBDate() {
		return actBDate;
	}

	public void setActEDate(Date actEDate) {
		this.actEDate = actEDate;
	}

	public Date getActEDate() {
		return actEDate;
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

	public void setActNO(String actNO) {
		this.actNO = actNO;
	}

	public String getActNO() {
		return actNO;
	}

	public String getParticipationTotal() {
		return participationTotal;
	}

	public void setParticipationTotal(String participationTotal) {
		this.participationTotal = participationTotal;
	}

	public int getApplyTotal() {
		return this.onlineThen + this.offlineThen;
	}

	public void setApplyTotal(int applyTotal) {
		this.applyTotal = applyTotal;
	}

	@Override
	public String toString() {
		return "ActivitySetting [actID=" + actID + ",actName=" + actName + ",expense1=" + expense1 + ",expense2="
				+ expense2 + ",expense3=" + expense3 + ",expense4=" + expense4 + ",time=" + time + ",way=" + way
				+ ",onlineCan=" + onlineCan + ",offlineCan=" + offlineCan + ",onlineThen=" + onlineThen
				+ ",offlineThen=" + offlineThen + ",integral=" + integral + ",isOnly=" + isOnly + ",applyBDate="
				+ applyBDate + ",applyEDate=" + applyEDate + ",actBDate=" + actBDate + ",actEDate=" + actEDate
				+ ",address=" + address + ",principal=" + principal + ",registrant=" + registrant + ",actNO=" + actNO
				+ ",participationTotal=" + participationTotal + ",applyTotal=" + applyTotal + "]";
	}
}
