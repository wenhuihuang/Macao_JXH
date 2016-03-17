package com.jxh.vo;


import java.io.Serializable;

/** DormitoryTrainingRecordDetailTop

detailID,masterRecordID,year,month,one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen,fifteen
?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?

dormitoryTrainingRecordDetailTop.detailID,dormitoryTrainingRecordDetailTop.masterRecordID,dormitoryTrainingRecordDetailTop.year,dormitoryTrainingRecordDetailTop.month,dormitoryTrainingRecordDetailTop.one,dormitoryTrainingRecordDetailTop.two,dormitoryTrainingRecordDetailTop.three,dormitoryTrainingRecordDetailTop.four,dormitoryTrainingRecordDetailTop.five,dormitoryTrainingRecordDetailTop.six,dormitoryTrainingRecordDetailTop.seven,dormitoryTrainingRecordDetailTop.eight,dormitoryTrainingRecordDetailTop.nine,dormitoryTrainingRecordDetailTop.ten,dormitoryTrainingRecordDetailTop.eleven,dormitoryTrainingRecordDetailTop.twelve,dormitoryTrainingRecordDetailTop.thirteen,dormitoryTrainingRecordDetailTop.fourteen,dormitoryTrainingRecordDetailTop.fifteen

detailID=?,masterRecordID=?,year=?,month=?,one=?,two=?,three=?,four=?,five=?,six=?,seven=?,eight=?,nine=?,ten=?,eleven=?,twelve=?,thirteen=?,fourteen=?,fifteen=?
*/
public class DormitoryTrainingRecordDetailTop implements Serializable {
	private static final long serialVersionUID = 1L;
	private int detailID;
	private String masterRecordID;
	private String year;
	private String month;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private String six;
	private String seven;
	private String eight;
	private String nine;
	private String ten;
	private String eleven;
	private String twelve;
	private String thirteen;
	private String fourteen;
	private String fifteen;

	public DormitoryTrainingRecordDetailTop(){
		super();
	}
	public DormitoryTrainingRecordDetailTop(int detailID, String masterRecordID, String year, String month, String one, String two, String three, String four, String five, String six, String seven, String eight, String nine, String ten, String eleven, String twelve, String thirteen, String fourteen, String fifteen ){
		super();
		this.detailID=detailID;
		this.masterRecordID=masterRecordID;
		this.year=year;
		this.month=month;
		this.one=one;
		this.two=two;
		this.three=three;
		this.four=four;
		this.five=five;
		this.six=six;
		this.seven=seven;
		this.eight=eight;
		this.nine=nine;
		this.ten=ten;
		this.eleven=eleven;
		this.twelve=twelve;
		this.thirteen=thirteen;
		this.fourteen=fourteen;
		this.fifteen=fifteen;
	}
	public void setDetailID(int detailID){
		this.detailID=detailID;
	}
	public int getDetailID(){
		return detailID;
	}
	public void setMasterRecordID(String masterRecordID){
		this.masterRecordID=masterRecordID;
	}
	public String getMasterRecordID(){
		return masterRecordID;
	}
	public void setYear(String year){
		this.year=year;
	}
	public String getYear(){
		return year;
	}
	public void setMonth(String month){
		this.month=month;
	}
	public String getMonth(){
		return month;
	}
	public void setOne(String one){
		this.one=one;
	}
	public String getOne(){
		return one;
	}
	public void setTwo(String two){
		this.two=two;
	}
	public String getTwo(){
		return two;
	}
	public void setThree(String three){
		this.three=three;
	}
	public String getThree(){
		return three;
	}
	public void setFour(String four){
		this.four=four;
	}
	public String getFour(){
		return four;
	}
	public void setFive(String five){
		this.five=five;
	}
	public String getFive(){
		return five;
	}
	public void setSix(String six){
		this.six=six;
	}
	public String getSix(){
		return six;
	}
	public void setSeven(String seven){
		this.seven=seven;
	}
	public String getSeven(){
		return seven;
	}
	public void setEight(String eight){
		this.eight=eight;
	}
	public String getEight(){
		return eight;
	}
	public void setNine(String nine){
		this.nine=nine;
	}
	public String getNine(){
		return nine;
	}
	public void setTen(String ten){
		this.ten=ten;
	}
	public String getTen(){
		return ten;
	}
	public void setEleven(String eleven){
		this.eleven=eleven;
	}
	public String getEleven(){
		return eleven;
	}
	public void setTwelve(String twelve){
		this.twelve=twelve;
	}
	public String getTwelve(){
		return twelve;
	}
	public void setThirteen(String thirteen){
		this.thirteen=thirteen;
	}
	public String getThirteen(){
		return thirteen;
	}
	public void setFourteen(String fourteen){
		this.fourteen=fourteen;
	}
	public String getFourteen(){
		return fourteen;
	}
	public void setFifteen(String fifteen){
		this.fifteen=fifteen;
	}
	public String getFifteen(){
		return fifteen;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingRecordDetailTop [detailID="+detailID+",masterRecordID="+masterRecordID+",year="+year+",month="+month+",one="+one+",two="+two+",three="+three+",four="+four+",five="+five+",six="+six+",seven="+seven+",eight="+eight+",nine="+nine+",ten="+ten+",eleven="+eleven+",twelve="+twelve+",thirteen="+thirteen+",fourteen="+fourteen+",fifteen="+fifteen+"]";
	}
}

