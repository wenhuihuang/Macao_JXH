package com.jxh.vo;


import java.io.Serializable;

/** DormitoryTrainingRecordDetailBottom

detailID,masterRecordID,year,month,sixteen,seventeen,eighteen,nineteen,twenty,twentyOne,twentyTwo,twentyThree,twentyFour,twentyFive,twentySix,twentySeven,twentyAight,twentyNine,thirty,thirtyOne
?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?

dormitoryTrainingRecordDetailBottom.detailID,dormitoryTrainingRecordDetailBottom.masterRecordID,dormitoryTrainingRecordDetailBottom.year,dormitoryTrainingRecordDetailBottom.month,dormitoryTrainingRecordDetailBottom.sixteen,dormitoryTrainingRecordDetailBottom.seventeen,dormitoryTrainingRecordDetailBottom.eighteen,dormitoryTrainingRecordDetailBottom.nineteen,dormitoryTrainingRecordDetailBottom.twenty,dormitoryTrainingRecordDetailBottom.twentyOne,dormitoryTrainingRecordDetailBottom.twentyTwo,dormitoryTrainingRecordDetailBottom.twentyThree,dormitoryTrainingRecordDetailBottom.twentyFour,dormitoryTrainingRecordDetailBottom.twentyFive,dormitoryTrainingRecordDetailBottom.twentySix,dormitoryTrainingRecordDetailBottom.twentySeven,dormitoryTrainingRecordDetailBottom.twentyAight,dormitoryTrainingRecordDetailBottom.twentyNine,dormitoryTrainingRecordDetailBottom.thirty,dormitoryTrainingRecordDetailBottom.thirtyOne

detailID=?,masterRecordID=?,year=?,month=?,sixteen=?,seventeen=?,eighteen=?,nineteen=?,twenty=?,twentyOne=?,twentyTwo=?,twentyThree=?,twentyFour=?,twentyFive=?,twentySix=?,twentySeven=?,twentyAight=?,twentyNine=?,thirty=?,thirtyOne=?
*/
public class DormitoryTrainingRecordDetailBottom implements Serializable {
	private static final long serialVersionUID = 1L;
	private int detailID;
	private String masterRecordID;
	private String year;
	private String month;
	private String sixteen;
	private String seventeen;
	private String eighteen;
	private String nineteen;
	private String twenty;
	private String twentyOne;
	private String twentyTwo;
	private String twentyThree;
	private String twentyFour;
	private String twentyFive;
	private String twentySix;
	private String twentySeven;
	private String twentyAight;
	private String twentyNine;
	private String thirty;
	private String thirtyOne;

	public DormitoryTrainingRecordDetailBottom(){
		super();
	}
	public DormitoryTrainingRecordDetailBottom(int detailID, String masterRecordID, String year, String month, String sixteen, String seventeen, String eighteen, String nineteen, String twenty, String twentyOne, String twentyTwo, String twentyThree, String twentyFour, String twentyFive, String twentySix, String twentySeven, String twentyAight, String twentyNine, String thirty, String thirtyOne ){
		super();
		this.detailID=detailID;
		this.masterRecordID=masterRecordID;
		this.year=year;
		this.month=month;
		this.sixteen=sixteen;
		this.seventeen=seventeen;
		this.eighteen=eighteen;
		this.nineteen=nineteen;
		this.twenty=twenty;
		this.twentyOne=twentyOne;
		this.twentyTwo=twentyTwo;
		this.twentyThree=twentyThree;
		this.twentyFour=twentyFour;
		this.twentyFive=twentyFive;
		this.twentySix=twentySix;
		this.twentySeven=twentySeven;
		this.twentyAight=twentyAight;
		this.twentyNine=twentyNine;
		this.thirty=thirty;
		this.thirtyOne=thirtyOne;
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
	public void setSixteen(String sixteen){
		this.sixteen=sixteen;
	}
	public String getSixteen(){
		return sixteen;
	}
	public void setSeventeen(String seventeen){
		this.seventeen=seventeen;
	}
	public String getSeventeen(){
		return seventeen;
	}
	public void setEighteen(String eighteen){
		this.eighteen=eighteen;
	}
	public String getEighteen(){
		return eighteen;
	}
	public void setNineteen(String nineteen){
		this.nineteen=nineteen;
	}
	public String getNineteen(){
		return nineteen;
	}
	public void setTwenty(String twenty){
		this.twenty=twenty;
	}
	public String getTwenty(){
		return twenty;
	}
	public void setTwentyOne(String twentyOne){
		this.twentyOne=twentyOne;
	}
	public String getTwentyOne(){
		return twentyOne;
	}
	public void setTwentyTwo(String twentyTwo){
		this.twentyTwo=twentyTwo;
	}
	public String getTwentyTwo(){
		return twentyTwo;
	}
	public void setTwentyThree(String twentyThree){
		this.twentyThree=twentyThree;
	}
	public String getTwentyThree(){
		return twentyThree;
	}
	public void setTwentyFour(String twentyFour){
		this.twentyFour=twentyFour;
	}
	public String getTwentyFour(){
		return twentyFour;
	}
	public void setTwentyFive(String twentyFive){
		this.twentyFive=twentyFive;
	}
	public String getTwentyFive(){
		return twentyFive;
	}
	public void setTwentySix(String twentySix){
		this.twentySix=twentySix;
	}
	public String getTwentySix(){
		return twentySix;
	}
	public void setTwentySeven(String twentySeven){
		this.twentySeven=twentySeven;
	}
	public String getTwentySeven(){
		return twentySeven;
	}
	public void setTwentyAight(String twentyAight){
		this.twentyAight=twentyAight;
	}
	public String getTwentyAight(){
		return twentyAight;
	}
	public void setTwentyNine(String twentyNine){
		this.twentyNine=twentyNine;
	}
	public String getTwentyNine(){
		return twentyNine;
	}
	public void setThirty(String thirty){
		this.thirty=thirty;
	}
	public String getThirty(){
		return thirty;
	}
	public void setThirtyOne(String thirtyOne){
		this.thirtyOne=thirtyOne;
	}
	public String getThirtyOne(){
		return thirtyOne;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingRecordDetailBottom [detailID="+detailID+",masterRecordID="+masterRecordID+",year="+year+",month="+month+",sixteen="+sixteen+",seventeen="+seventeen+",eighteen="+eighteen+",nineteen="+nineteen+",twenty="+twenty+",twentyOne="+twentyOne+",twentyTwo="+twentyTwo+",twentyThree="+twentyThree+",twentyFour="+twentyFour+",twentyFive="+twentyFive+",twentySix="+twentySix+",twentySeven="+twentySeven+",twentyAight="+twentyAight+",twentyNine="+twentyNine+",thirty="+thirty+",thirtyOne="+thirtyOne+"]";
	}
}

