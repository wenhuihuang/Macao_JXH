package com.jxh.vo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** MedicalRecordView

viewID,recordID,billDate,project,releaseDate,handler,mentalitySober,mentalityLethargy,mentalityUneasy,heartLungBreathe,heartLungAnhelation,bloodWarmth,bloodRuddy,bloodFrozen,bloodPallor,bloodBruise,bloodDe,skinFull,skinDamaged,nerveDiscomfort,nerveParalysis
?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?

medicalRecordView.viewID,medicalRecordView.recordID,medicalRecordView.billDate,medicalRecordView.project,medicalRecordView.releaseDate,medicalRecordView.handler,medicalRecordView.mentalitySober,medicalRecordView.mentalityLethargy,medicalRecordView.mentalityUneasy,medicalRecordView.heartLungBreathe,medicalRecordView.heartLungAnhelation,medicalRecordView.bloodWarmth,medicalRecordView.bloodRuddy,medicalRecordView.bloodFrozen,medicalRecordView.bloodPallor,medicalRecordView.bloodBruise,medicalRecordView.bloodDe,medicalRecordView.skinFull,medicalRecordView.skinDamaged,medicalRecordView.nerveDiscomfort,medicalRecordView.nerveParalysis

viewID=?,recordID=?,billDate=?,project=?,releaseDate=?,handler=?,mentalitySober=?,mentalityLethargy=?,mentalityUneasy=?,heartLungBreathe=?,heartLungAnhelation=?,bloodWarmth=?,bloodRuddy=?,bloodFrozen=?,bloodPallor=?,bloodBruise=?,bloodDe=?,skinFull=?,skinDamaged=?,nerveDiscomfort=?,nerveParalysis=?
*/
public class MedicalRecordView implements Serializable {
	private static final long serialVersionUID = 1L;
	private int viewID;
	private String recordID;
	private Date billDate;
	private String project;
	private String releaseDate;
	private String handler;
	private int mentalitySober;
	private int mentalityLethargy;
	private int mentalityUneasy;
	private int heartLungBreathe;
	private int heartLungAnhelation;
	private int bloodWarmth;
	private int bloodRuddy;
	private int bloodFrozen;
	private int bloodPallor;
	private int bloodBruise;
	private int bloodDe;
	private int skinFull;
	private int skinDamaged;
	private int nerveDiscomfort;
	private int nerveParalysis;

	public MedicalRecordView(){
		super();
	}
	public MedicalRecordView(int viewID, String recordID, Date billDate, String project, String releaseDate, String handler, int mentalitySober, int mentalityLethargy, int mentalityUneasy, int heartLungBreathe, int heartLungAnhelation, int bloodWarmth, int bloodRuddy, int bloodFrozen, int bloodPallor, int bloodBruise, int bloodDe, int skinFull, int skinDamaged, int nerveDiscomfort, int nerveParalysis ){
		super();
		this.viewID=viewID;
		this.recordID=recordID;
		this.billDate=billDate;
		this.project=project;
		this.releaseDate=releaseDate;
		this.handler=handler;
		this.mentalitySober=mentalitySober;
		this.mentalityLethargy=mentalityLethargy;
		this.mentalityUneasy=mentalityUneasy;
		this.heartLungBreathe=heartLungBreathe;
		this.heartLungAnhelation=heartLungAnhelation;
		this.bloodWarmth=bloodWarmth;
		this.bloodRuddy=bloodRuddy;
		this.bloodFrozen=bloodFrozen;
		this.bloodPallor=bloodPallor;
		this.bloodBruise=bloodBruise;
		this.bloodDe=bloodDe;
		this.skinFull=skinFull;
		this.skinDamaged=skinDamaged;
		this.nerveDiscomfort=nerveDiscomfort;
		this.nerveParalysis=nerveParalysis;
	}
	public void setViewID(int viewID){
		this.viewID=viewID;
	}
	public int getViewID(){
		return viewID;
	}
	public void setRecordID(String recordID){
		this.recordID=recordID;
	}
	public String getRecordID(){
		return recordID;
	}
	public void setBillDate(Date billDate){
		this.billDate=billDate;
	}
	public Date getBillDate(){
		return billDate;
	}
	public void setProject(String project){
		this.project=project;
	}
	public String getProject(){
		return project;
	}
	public void setReleaseDate(String releaseDate){
		this.releaseDate=releaseDate;
	}
	public String getReleaseDate(){
		return releaseDate;
	}
	public void setHandler(String handler){
		this.handler=handler;
	}
	public String getHandler(){
		return handler;
	}
	public void setMentalitySober(int mentalitySober){
		this.mentalitySober=mentalitySober;
	}
	public int getMentalitySober(){
		return mentalitySober;
	}
	public void setMentalityLethargy(int mentalityLethargy){
		this.mentalityLethargy=mentalityLethargy;
	}
	public int getMentalityLethargy(){
		return mentalityLethargy;
	}
	public void setMentalityUneasy(int mentalityUneasy){
		this.mentalityUneasy=mentalityUneasy;
	}
	public int getMentalityUneasy(){
		return mentalityUneasy;
	}
	public void setHeartLungBreathe(int heartLungBreathe){
		this.heartLungBreathe=heartLungBreathe;
	}
	public int getHeartLungBreathe(){
		return heartLungBreathe;
	}
	public void setHeartLungAnhelation(int heartLungAnhelation){
		this.heartLungAnhelation=heartLungAnhelation;
	}
	public int getHeartLungAnhelation(){
		return heartLungAnhelation;
	}
	public void setBloodWarmth(int bloodWarmth){
		this.bloodWarmth=bloodWarmth;
	}
	public int getBloodWarmth(){
		return bloodWarmth;
	}
	public void setBloodRuddy(int bloodRuddy){
		this.bloodRuddy=bloodRuddy;
	}
	public int getBloodRuddy(){
		return bloodRuddy;
	}
	public void setBloodFrozen(int bloodFrozen){
		this.bloodFrozen=bloodFrozen;
	}
	public int getBloodFrozen(){
		return bloodFrozen;
	}
	public void setBloodPallor(int bloodPallor){
		this.bloodPallor=bloodPallor;
	}
	public int getBloodPallor(){
		return bloodPallor;
	}
	public void setBloodBruise(int bloodBruise){
		this.bloodBruise=bloodBruise;
	}
	public int getBloodBruise(){
		return bloodBruise;
	}
	public void setBloodDe(int bloodDe){
		this.bloodDe=bloodDe;
	}
	public int getBloodDe(){
		return bloodDe;
	}
	public void setSkinFull(int skinFull){
		this.skinFull=skinFull;
	}
	public int getSkinFull(){
		return skinFull;
	}
	public void setSkinDamaged(int skinDamaged){
		this.skinDamaged=skinDamaged;
	}
	public int getSkinDamaged(){
		return skinDamaged;
	}
	public void setNerveDiscomfort(int nerveDiscomfort){
		this.nerveDiscomfort=nerveDiscomfort;
	}
	public int getNerveDiscomfort(){
		return nerveDiscomfort;
	}
	public void setNerveParalysis(int nerveParalysis){
		this.nerveParalysis=nerveParalysis;
	}
	public int getNerveParalysis(){
		return nerveParalysis;
	}
	@Override
	public String toString(){
		return "MedicalRecordView [viewID="+viewID+",recordID="+recordID+",billDate="+billDate+",project="+project+",releaseDate="+releaseDate+",handler="+handler+",mentalitySober="+mentalitySober+",mentalityLethargy="+mentalityLethargy+",mentalityUneasy="+mentalityUneasy+",heartLungBreathe="+heartLungBreathe+",heartLungAnhelation="+heartLungAnhelation+",bloodWarmth="+bloodWarmth+",bloodRuddy="+bloodRuddy+",bloodFrozen="+bloodFrozen+",bloodPallor="+bloodPallor+",bloodBruise="+bloodBruise+",bloodDe="+bloodDe+",skinFull="+skinFull+",skinDamaged="+skinDamaged+",nerveDiscomfort="+nerveDiscomfort+",nerveParalysis="+nerveParalysis+"]";
	}
}

