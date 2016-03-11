package com.jxh.vo;


import java.io.Serializable;
import java.math.*;


/** GroupSettingRecordBudget

budgetID,recordID,actNO,actName,pay,qty,expenditure
?,?,?,?,?,?,?

groupSettingRecordBudget.budgetID,groupSettingRecordBudget.recordID,groupSettingRecordBudget.actNO,groupSettingRecordBudget.actName,groupSettingRecordBudget.pay,groupSettingRecordBudget.qty,groupSettingRecordBudget.expenditure

budgetID=?,recordID=?,actNO=?,actName=?,pay=?,qty=?,expenditure=?
*/
public class GroupSettingRecordBudget implements Serializable {
	private static final long serialVersionUID = 1L;
	private int budgetID;
	private String recordID;
	private int actNO;
	private String actName;
	private BigDecimal pay;
	private BigDecimal qty;
	private BigDecimal expenditure;

	public GroupSettingRecordBudget(){
		super();
	}
	public GroupSettingRecordBudget(int budgetID, String recordID, int actNO, String actName, BigDecimal pay, BigDecimal qty, BigDecimal expenditure ){
		super();
		this.budgetID=budgetID;
		this.recordID=recordID;
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
	public void setRecordID(String recordID){
		this.recordID=recordID;
	}
	public String getRecordID(){
		return recordID;
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
		return "GroupSettingRecordBudget [budgetID="+budgetID+",recordID="+recordID+",actNO="+actNO+",actName="+actName+",pay="+pay+",qty="+qty+",expenditure="+expenditure+"]";
	}
}

