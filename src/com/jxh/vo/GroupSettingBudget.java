package com.jxh.vo;


import java.io.Serializable;
import java.math.*;


/** GroupSettingBudget

budgetID,gSID,actNO,actName,pay,qty,expenditure
?,?,?,?,?,?,?

groupSettingBudget.budgetID,groupSettingBudget.gSID,groupSettingBudget.actNO,groupSettingBudget.actName,groupSettingBudget.pay,groupSettingBudget.qty,groupSettingBudget.expenditure

budgetID=?,gSID=?,actNO=?,actName=?,pay=?,qty=?,expenditure=?
*/
public class GroupSettingBudget implements Serializable {
	private static final long serialVersionUID = 1L;
	private int budgetID;
	private String gSID;
	private int actNO;
	private String actName;
	private BigDecimal pay;
	private BigDecimal qty;
	private BigDecimal expenditure;

	public GroupSettingBudget(){
		super();
	}
	public GroupSettingBudget(int budgetID, String gSID, int actNO, String actName, BigDecimal pay, BigDecimal qty, BigDecimal expenditure ){
		super();
		this.budgetID=budgetID;
		this.gSID=gSID;
		this.actNO=actNO;
		this.actName=actName;
		this.pay=pay;
		this.qty=qty;
		this.expenditure=expenditure;
	}
	public void setBudgetID(int budgetID){
		this.budgetID=budgetID;
	}
	public int getBudgetID(){
		return budgetID;
	}
	public void setgSID(String gSID){
		this.gSID=gSID;
	}
	public String getgSID(){
		return gSID;
	}
	public void setActNO(int actNO){
		this.actNO=actNO;
	}
	public int getActNO(){
		return actNO;
	}
	public void setActName(String actName){
		this.actName=actName;
	}
	public String getActName(){
		return actName;
	}
	public void setPay(BigDecimal pay){
		this.pay=pay;
	}
	public BigDecimal getPay(){
		return pay;
	}
	public void setQty(BigDecimal qty){
		this.qty=qty;
	}
	public BigDecimal getQty(){
		return qty;
	}
	public void setExpenditure(BigDecimal expenditure){
		this.expenditure=expenditure;
	}
	public BigDecimal getExpenditure(){
		return expenditure;
	}
	@Override
	public String toString(){
		return "GroupSettingBudget [budgetID="+budgetID+",gSID="+gSID+",actNO="+actNO+",actName="+actName+",pay="+pay+",qty="+qty+",expenditure="+expenditure+"]";
	}
}

