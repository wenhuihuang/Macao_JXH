package com.jxh.pojo;


import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.sql.*;
import java.text.ParseException;
import java.math.*;

public class TreatmentPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String treatmentID;
	private int treatmentType;
	private String custID;
	private String treatmentNO;
	private String worker;
	private Date applyDate;
	private int serviceStatus;
	private String reason;
	private String note;
	private String familySituation;
	private int physicalAssess;
	private int physicalLevel;
	private Date physicalDate;
	private String physicalPlace;
	private String physicalDescribe;
	private String physicalNote;
	private int visionAssess;
	private int visionLevel;
	private Date visionDate;
	private String visionPlace;
	private String visionDescribe;
	private String visionNote;
	private int hearingAssess;
	private int hearingLevel;
	private Date hearingDate;
	private String hearingPlace;
	private String hearingDescribe;
	private String hearingNote;
	private int iQAssess;
	private int iQLevel;
	private Date iQDate;
	private String iQPlace;
	private String iQDescribe;
	private String iQNote;
	private int speechAssess;
	private int speechLevel;
	private Date speechDate;
	private String speechPlace;
	private String speechDescribe;
	private String speechNote;
	private int behaviorAssess;
	private int behaviorLevel;
	private Date behaviorDate;
	private String behaviorPlace;
	private String behaviorDescribe;
	private String behaviorNote;
	private String communication;
	private String communicationNote;
	private String life;
	private String lifeNote;
	private String useResources;
	private String useResourcesNote;
	private String selfGuided;
	private String selfGuidedNote;
	private String functional;
	private String functionalNote;
	private String play;
	private String playNote;
	private String work;
	private String workNote;
	private String cognitive;
	private String cognitiveNote;
	private String lMuscle;
	private String lMuscleNote;
	private String sMuscle;
	private String sMuscleNote;
	private String interpersonal;
	private String interpersonalNote;
	private String selfAbility;
	private String selfAbilityNote;
	private String sensory;
	private String sensoryNote;
	private String health;
	private String healthNote;
	private String disease;
	private String diseaseOther;
	private String allergyFood;
	private String allergyOther;
	private String allergyDrug;
	private int medication;
	private String medicationNote;
	private String history;
	private int sCantonese;
	private int rCantonese;
	private int lCantonese;
	private int wCantonese;
	private int sMandarin;
	private int rMandarin;
	private int lMandarin;
	private int wMandarin;
	private String sRLWOther;
	private String others;
	private String physicalReason;
	private String knowReason;
	private String wish;
	private String otherReason;
	private int socially;
	private String emotional;
	private String inducements;
	private String solve;
	private String attack;
	private String temper;
	private String behavior;
	private String behaviorHandle;
	private String sport;
	private String art;
	private String hobby;
	private String morningLife;
	private String afternoonLife;
	private String nightLife;
	private String lifeEnvironment;
	private String workerNote;
	private String behaviourNote;
	private Date startDate;
	private Date awaitDate;
	private String diseaseHeredity;
	private int communicationLevel;
	private int selfLevel;
	private int lifeLevel;
	private int socialLevel;
	private int recourceLevel;
	private int guideLevel;
	private int safetyLevel;
	private int fnLevel;
	private int playLevel;
	private int workerLevel;
	private String supportPeople;
	private String coldnessPeople;
	private String connivePeople;
	private String neglectPeople;
	private String protectPeople;
	private String severePeople;
	private String treatmentCategory;
	private Date acceptDate;
	
	private String fullName;
	private String isMember;
	
	private String caseWorker;
	private Date receiveDate;
	private int caseStatus;
	
	private Date assessDate;
	
	private Date closeDate;
	
	private String applyDate_str;
	private String physicalDate_str;
	private String visionDate_str;
	private String hearingDate_str;
	private String iQDate_str;
	private String speechDate_str;
	private String behaviorDate_str;
	private String startDate_str;
	private String awaitDate_str;
	private String acceptDate_str;
	
	private String assessDate_str;
	private String closeDate_str;
	
	private String receiveDate_str;

	public TreatmentPojo(){
		super();
	}
	public TreatmentPojo(String treatmentID, int treatmentType, String custID, String treatmentNO, String worker,
								Date applyDate, int serviceStatus, String reason, String note,
								String familySituation, int physicalAssess, int physicalLevel, Date physicalDate, 
								String physicalPlace, String physicalDescribe, String physicalNote, int visionAssess,
								int visionLevel, Date visionDate, String visionPlace, String visionDescribe,
								String visionNote, int hearingAssess, int hearingLevel, Date hearingDate,
								String hearingPlace, String hearingDescribe, String hearingNote, int iQAssess,
								int iQLevel, Date iQDate, String iQPlace, String iQDescribe, String iQNote, 
								int speechAssess, int speechLevel, Date speechDate, String speechPlace, 
								String speechDescribe, String speechNote, int behaviorAssess, int behaviorLevel,
								Date behaviorDate, String behaviorPlace, String behaviorDescribe, String behaviorNote,
								String communication, String communicationNote, String life, String lifeNote, String useResources, 
								String useResourcesNote, String selfGuided, String selfGuidedNote, String functional, 
								String functionalNote, String play, String playNote, String work, String workNote, 
								String cognitive, String cognitiveNote, String lMuscle, String lMuscleNote, String sMuscle, 
								String sMuscleNote, String interpersonal, String interpersonalNote, String selfAbility,
								String selfAbilityNote, String sensory, String sensoryNote, String health, String healthNote,
								String disease, String diseaseOther, String allergyFood, String allergyOther,String allergyDrug, int medication, String medicationNote,
								String history, int sCantonese, int rCantonese, int lCantonese, int wCantonese, int sMandarin, 
								int rMandarin, int lMandarin, int wMandarin, String sRLWOther, String others, String physicalReason,
								String knowReason, String wish, String otherReason, int socially, String emotional, String inducements,
								String solve, String attack, String temper, String behavior, String behaviorHandle, String sport, String art,
								String hobby, String morningLife, String afternoonLife, String nightLife, String lifeEnvironment,
								String workerNote, String behaviourNote,String applyDate_str,String physicalDate_str,
								String visionDate_str,String hearingDate_str, String iQDate_str,String speechDate_str,String behaviorDate_str,
								Date startDate,String startDate_str,Date awaitDate,String awaitDate_str,String fullName, String isMember,Date assessDate,Date closeDate,
								String assessDate_str,String closeDate_str,String caseWorker,int caseStatus,Date receiveDate,String receiveDate_str,
								String diseaseHeredity, int communicationLevel, int selfLevel, int lifeLevel, int socialLevel, int recourceLevel, int guideLevel, int safetyLevel,
								int fnLevel, int playLevel, int workerLevel, String supportPeople, String coldnessPeople, String connivePeople, String neglectPeople, String protectPeople,
								String severePeople,String treatmentCategory,Date acceptDate,String acceptDate_str){
		super();
		this.treatmentID=treatmentID;
		this.treatmentType=treatmentType;
		this.custID=custID;
		this.treatmentNO=treatmentNO;
		this.worker=worker;
		this.applyDate=applyDate;
		this.serviceStatus=serviceStatus;
		this.reason=reason;
		this.note=note;
		this.familySituation=familySituation;
		this.physicalAssess=physicalAssess;
		this.physicalLevel=physicalLevel;
		this.physicalDate=physicalDate;
		this.physicalPlace=physicalPlace;
		this.physicalDescribe=physicalDescribe;
		this.physicalNote=physicalNote;
		this.visionAssess=visionAssess;
		this.visionLevel=visionLevel;
		this.visionDate=visionDate;
		this.visionPlace=visionPlace;
		this.visionDescribe=visionDescribe;
		this.visionNote=visionNote;
		this.hearingAssess=hearingAssess;
		this.hearingLevel=hearingLevel;
		this.hearingDate=hearingDate;
		this.hearingPlace=hearingPlace;
		this.hearingDescribe=hearingDescribe;
		this.hearingNote=hearingNote;
		this.iQAssess=iQAssess;
		this.iQLevel=iQLevel;
		this.iQDate=iQDate;
		this.iQPlace=iQPlace;
		this.iQDescribe=iQDescribe;
		this.iQNote=iQNote;
		this.speechAssess=speechAssess;
		this.speechLevel=speechLevel;
		this.speechDate=speechDate;
		this.speechPlace=speechPlace;
		this.speechDescribe=speechDescribe;
		this.speechNote=speechNote;
		this.behaviorAssess=behaviorAssess;
		this.behaviorLevel=behaviorLevel;
		this.behaviorDate=behaviorDate;
		this.behaviorPlace=behaviorPlace;
		this.behaviorDescribe=behaviorDescribe;
		this.behaviorNote=behaviorNote;
		this.communication=communication;
		this.communicationNote=communicationNote;
		this.life=life;
		this.lifeNote=lifeNote;
		this.useResources=useResources;
		this.useResourcesNote=useResourcesNote;
		this.selfGuided=selfGuided;
		this.selfGuidedNote=selfGuidedNote;
		this.functional=functional;
		this.functionalNote=functionalNote;
		this.play=play;
		this.playNote=playNote;
		this.work=work;
		this.workNote=workNote;
		this.cognitive=cognitive;
		this.cognitiveNote=cognitiveNote;
		this.lMuscle=lMuscle;
		this.lMuscleNote=lMuscleNote;
		this.sMuscle=sMuscle;
		this.sMuscleNote=sMuscleNote;
		this.interpersonal=interpersonal;
		this.interpersonalNote=interpersonalNote;
		this.selfAbility=selfAbility;
		this.selfAbilityNote=selfAbilityNote;
		this.sensory=sensory;
		this.sensoryNote=sensoryNote;
		this.health=health;
		this.healthNote=healthNote;
		this.disease=disease;
		this.diseaseOther=diseaseOther;
		this.allergyFood=allergyFood;
		this.allergyOther=allergyOther;
		this.allergyDrug=allergyDrug;
		this.medication=medication;
		this.medicationNote=medicationNote;
		this.history=history;
		this.sCantonese=sCantonese;
		this.rCantonese=rCantonese;
		this.lCantonese=lCantonese;
		this.wCantonese=wCantonese;
		this.sMandarin=sMandarin;
		this.rMandarin=rMandarin;
		this.lMandarin=lMandarin;
		this.wMandarin=wMandarin;
		this.sRLWOther=sRLWOther;
		this.others=others;
		this.physicalReason=physicalReason;
		this.knowReason=knowReason;
		this.wish=wish;
		this.otherReason=otherReason;
		this.socially=socially;
		this.emotional=emotional;
		this.inducements=inducements;
		this.solve=solve;
		this.attack=attack;
		this.temper=temper;
		this.behavior=behavior;
		this.behaviorHandle=behaviorHandle;
		this.sport=sport;
		this.art=art;
		this.hobby=hobby;
		this.morningLife=morningLife;
		this.afternoonLife=afternoonLife;
		this.nightLife=nightLife;
		this.lifeEnvironment=lifeEnvironment;
		this.workerNote=workerNote;
		this.behaviourNote=behaviourNote;
		this.startDate=startDate;
		this.awaitDate=awaitDate;
		this.diseaseHeredity=diseaseHeredity;
		this.communicationLevel=communicationLevel;
		this.selfLevel=selfLevel;
		this.lifeLevel=lifeLevel;
		this.socialLevel=socialLevel;
		this.recourceLevel=recourceLevel;
		this.guideLevel=guideLevel;
		this.safetyLevel=safetyLevel;
		this.fnLevel=fnLevel;
		this.playLevel=playLevel;
		this.workerLevel=workerLevel;
		this.supportPeople=supportPeople;
		this.coldnessPeople=coldnessPeople;
		this.connivePeople=connivePeople;
		this.neglectPeople=neglectPeople;
		this.protectPeople=protectPeople;
		this.severePeople=severePeople;
		this.treatmentCategory=treatmentCategory;
		this.acceptDate=acceptDate;
		
		this.fullName=fullName;
		this.isMember=isMember;
		
		this.caseWorker=caseWorker;
		this.caseStatus=caseStatus;
		this.receiveDate=receiveDate;
		this.receiveDate_str=receiveDate_str;
		this.acceptDate_str=acceptDate_str;
		
		this.assessDate=assessDate;
		
		this.closeDate=closeDate;
		
		this.applyDate_str=applyDate_str;
		this.physicalDate_str=physicalDate_str;
		this.visionDate_str=visionDate_str;
		this.hearingDate_str=hearingDate_str;
		this.iQDate_str=iQDate_str;
		this.speechDate_str=speechDate_str;
		this.behaviorDate_str=behaviorDate_str;
		this.startDate_str=startDate_str;
		this.awaitDate_str=awaitDate_str;
		this.assessDate_str=assessDate_str;
		this.closeDate_str=closeDate_str;
	}
	public void setTreatmentID(String treatmentID){
		this.treatmentID=treatmentID;
	}
	public String getTreatmentID(){
		return treatmentID;
	}
	public void setTreatmentType(int treatmentType){
		this.treatmentType=treatmentType;
	}
	public int getTreatmentType(){
		return treatmentType;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setTreatmentNO(String treatmentNO){
		this.treatmentNO=treatmentNO;
	}
	public String getTreatmentNO(){
		return treatmentNO;
	}
	public void setWorker(String worker){
		this.worker=worker;
	}
	public String getWorker(){
		return worker;
	}
	public void setApplyDate(Date applyDate){
		this.applyDate=applyDate;
	}
	public Date getApplyDate(){
		return applyDate;
	}
	public void setServiceStatus(int serviceStatus){
		this.serviceStatus=serviceStatus;
	}
	public int getServiceStatus(){
		return serviceStatus;
	}
	public void setReason(String reason){
		this.reason=reason;
	}
	public String getReason(){
		return reason;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public void setFamilySituation(String familySituation){
		this.familySituation=familySituation;
	}
	public String getFamilySituation(){
		return familySituation;
	}
	public void setPhysicalAssess(int physicalAssess){
		this.physicalAssess=physicalAssess;
	}
	public int getPhysicalAssess(){
		return physicalAssess;
	}
	public void setPhysicalLevel(int physicalLevel){
		this.physicalLevel=physicalLevel;
	}
	public int getPhysicalLevel(){
		return physicalLevel;
	}
	public void setPhysicalDate(Date physicalDate){
		this.physicalDate=physicalDate;
	}
	public Date getPhysicalDate(){
		return physicalDate;
	}
	public void setPhysicalPlace(String physicalPlace){
		this.physicalPlace=physicalPlace;
	}
	public String getPhysicalPlace(){
		return physicalPlace;
	}
	public void setPhysicalDescribe(String physicalDescribe){
		this.physicalDescribe=physicalDescribe;
	}
	public String getPhysicalDescribe(){
		return physicalDescribe;
	}
	public void setPhysicalNote(String physicalNote){
		this.physicalNote=physicalNote;
	}
	public String getPhysicalNote(){
		return physicalNote;
	}
	public void setVisionAssess(int visionAssess){
		this.visionAssess=visionAssess;
	}
	public int getVisionAssess(){
		return visionAssess;
	}
	public void setVisionLevel(int visionLevel){
		this.visionLevel=visionLevel;
	}
	public int getVisionLevel(){
		return visionLevel;
	}
	public void setVisionDate(Date visionDate){
		this.visionDate=visionDate;
	}
	public Date getVisionDate(){
		return visionDate;
	}
	public void setVisionPlace(String visionPlace){
		this.visionPlace=visionPlace;
	}
	public String getVisionPlace(){
		return visionPlace;
	}
	public void setVisionDescribe(String visionDescribe){
		this.visionDescribe=visionDescribe;
	}
	public String getVisionDescribe(){
		return visionDescribe;
	}
	public void setVisionNote(String visionNote){
		this.visionNote=visionNote;
	}
	public String getVisionNote(){
		return visionNote;
	}
	public void setHearingAssess(int hearingAssess){
		this.hearingAssess=hearingAssess;
	}
	public int getHearingAssess(){
		return hearingAssess;
	}
	public void setHearingLevel(int hearingLevel){
		this.hearingLevel=hearingLevel;
	}
	public int getHearingLevel(){
		return hearingLevel;
	}
	public void setHearingDate(Date hearingDate){
		this.hearingDate=hearingDate;
	}
	public Date getHearingDate(){
		return hearingDate;
	}
	public void setHearingPlace(String hearingPlace){
		this.hearingPlace=hearingPlace;
	}
	public String getHearingPlace(){
		return hearingPlace;
	}
	public void setHearingDescribe(String hearingDescribe){
		this.hearingDescribe=hearingDescribe;
	}
	public String getHearingDescribe(){
		return hearingDescribe;
	}
	public void setHearingNote(String hearingNote){
		this.hearingNote=hearingNote;
	}
	public String getHearingNote(){
		return hearingNote;
	}
	public int getiQAssess() {
		return iQAssess;
	}
	public void setiQAssess(int iQAssess) {
		this.iQAssess = iQAssess;
	}
	public int getiQLevel() {
		return iQLevel;
	}
	public void setiQLevel(int iQLevel) {
		this.iQLevel = iQLevel;
	}
	public Date getiQDate() {
		return iQDate;
	}
	public void setiQDate(Date iQDate) {
		this.iQDate = iQDate;
	}
	public void setiQPlace(String iQPlace){
		this.iQPlace=iQPlace;
	}
	public String getiQPlace(){
		return iQPlace;
	}
	public void setiQDescribe(String iQDescribe){
		this.iQDescribe=iQDescribe;
	}
	public String getiQDescribe(){
		return iQDescribe;
	}
	public void setiQNote(String iQNote){
		this.iQNote=iQNote;
	}
	public String getiQNote(){
		return iQNote;
	}
	public void setSpeechAssess(int speechAssess){
		this.speechAssess=speechAssess;
	}
	public int getSpeechAssess(){
		return speechAssess;
	}
	public void setSpeechLevel(int speechLevel){
		this.speechLevel=speechLevel;
	}
	public int getSpeechLevel(){
		return speechLevel;
	}
	public void setSpeechDate(Date speechDate){
		this.speechDate=speechDate;
	}
	public Date getSpeechDate(){
		return speechDate;
	}
	public void setSpeechPlace(String speechPlace){
		this.speechPlace=speechPlace;
	}
	public String getSpeechPlace(){
		return speechPlace;
	}
	public void setSpeechDescribe(String speechDescribe){
		this.speechDescribe=speechDescribe;
	}
	public String getSpeechDescribe(){
		return speechDescribe;
	}
	public void setSpeechNote(String speechNote){
		this.speechNote=speechNote;
	}
	public String getSpeechNote(){
		return speechNote;
	}
	public void setBehaviorAssess(int behaviorAssess){
		this.behaviorAssess=behaviorAssess;
	}
	public int getBehaviorAssess(){
		return behaviorAssess;
	}
	public void setBehaviorLevel(int behaviorLevel){
		this.behaviorLevel=behaviorLevel;
	}
	public int getBehaviorLevel(){
		return behaviorLevel;
	}
	public void setBehaviorDate(Date behaviorDate){
		this.behaviorDate=behaviorDate;
	}
	public Date getBehaviorDate(){
		return behaviorDate;
	}
	public void setBehaviorPlace(String behaviorPlace){
		this.behaviorPlace=behaviorPlace;
	}
	public String getBehaviorPlace(){
		return behaviorPlace;
	}
	public void setBehaviorDescribe(String behaviorDescribe){
		this.behaviorDescribe=behaviorDescribe;
	}
	public String getBehaviorDescribe(){
		return behaviorDescribe;
	}
	public void setBehaviorNote(String behaviorNote){
		this.behaviorNote=behaviorNote;
	}
	public String getBehaviorNote(){
		return behaviorNote;
	}
	public void setCommunication(String communication){
		this.communication=communication;
	}
	public String getCommunication(){
		return communication;
	}
	public void setCommunicationNote(String communicationNote){
		this.communicationNote=communicationNote;
	}
	public String getCommunicationNote(){
		return communicationNote;
	}
	public void setLife(String life){
		this.life=life;
	}
	public String getLife(){
		return life;
	}
	public void setLifeNote(String lifeNote){
		this.lifeNote=lifeNote;
	}
	public String getLifeNote(){
		return lifeNote;
	}
	public void setUseResources(String useResources){
		this.useResources=useResources;
	}
	public String getUseResources(){
		return useResources;
	}
	public void setUseResourcesNote(String useResourcesNote){
		this.useResourcesNote=useResourcesNote;
	}
	public String getUseResourcesNote(){
		return useResourcesNote;
	}
	public void setSelfGuided(String selfGuided){
		this.selfGuided=selfGuided;
	}
	public String getSelfGuided(){
		return selfGuided;
	}
	public void setSelfGuidedNote(String selfGuidedNote){
		this.selfGuidedNote=selfGuidedNote;
	}
	public String getSelfGuidedNote(){
		return selfGuidedNote;
	}
	public void setFunctional(String functional){
		this.functional=functional;
	}
	public String getFunctional(){
		return functional;
	}
	public void setFunctionalNote(String functionalNote){
		this.functionalNote=functionalNote;
	}
	public String getFunctionalNote(){
		return functionalNote;
	}
	public void setPlay(String play){
		this.play=play;
	}
	public String getPlay(){
		return play;
	}
	public void setPlayNote(String playNote){
		this.playNote=playNote;
	}
	public String getPlayNote(){
		return playNote;
	}
	public void setWork(String work){
		this.work=work;
	}
	public String getWork(){
		return work;
	}
	public void setWorkNote(String workNote){
		this.workNote=workNote;
	}
	public String getWorkNote(){
		return workNote;
	}
	public void setCognitive(String cognitive){
		this.cognitive=cognitive;
	}
	public String getCognitive(){
		return cognitive;
	}
	public void setCognitiveNote(String cognitiveNote){
		this.cognitiveNote=cognitiveNote;
	}
	public String getCognitiveNote(){
		return cognitiveNote;
	}
	public void setInterpersonal(String interpersonal){
		this.interpersonal=interpersonal;
	}
	public String getInterpersonal(){
		return interpersonal;
	}
	public void setInterpersonalNote(String interpersonalNote){
		this.interpersonalNote=interpersonalNote;
	}
	public String getInterpersonalNote(){
		return interpersonalNote;
	}
	public void setSelfAbility(String selfAbility){
		this.selfAbility=selfAbility;
	}
	public String getSelfAbility(){
		return selfAbility;
	}
	public void setSelfAbilityNote(String selfAbilityNote){
		this.selfAbilityNote=selfAbilityNote;
	}
	public String getSelfAbilityNote(){
		return selfAbilityNote;
	}
	public void setSensory(String sensory){
		this.sensory=sensory;
	}
	public String getSensory(){
		return sensory;
	}
	public void setSensoryNote(String sensoryNote){
		this.sensoryNote=sensoryNote;
	}
	public String getSensoryNote(){
		return sensoryNote;
	}
	public void setHealth(String health){
		this.health=health;
	}
	public String getHealth(){
		return health;
	}
	public void setHealthNote(String healthNote){
		this.healthNote=healthNote;
	}
	public String getHealthNote(){
		return healthNote;
	}
	public void setDisease(String disease){
		this.disease=disease;
	}
	public String getDisease(){
		return disease;
	}
	public void setDiseaseOther(String diseaseOther){
		this.diseaseOther=diseaseOther;
	}
	public String getDiseaseOther(){
		return diseaseOther;
	}
	
	
	public String getDiseaseHeredity() {
		return diseaseHeredity;
	}
	public void setDiseaseHeredity(String diseaseHeredity) {
		this.diseaseHeredity = diseaseHeredity;
	}
	public void setAllergyFood(String allergyFood){
		this.allergyFood=allergyFood;
	}
	public String getAllergyFood(){
		return allergyFood;
	}
	public void setAllergyOther(String allergyOther){
		this.allergyOther=allergyOther;
	}
	public String getAllergyOther(){
		return allergyOther;
	}
	public void setMedication(int medication){
		this.medication=medication;
	}
	public int getMedication(){
		return medication;
	}
	public void setMedicationNote(String medicationNote){
		this.medicationNote=medicationNote;
	}
	public String getMedicationNote(){
		return medicationNote;
	}
	public void setHistory(String history){
		this.history=history;
	}
	public String getHistory(){
		return history;
	}
	public void setOthers(String others){
		this.others=others;
	}
	public String getOthers(){
		return others;
	}
	public void setPhysicalReason(String physicalReason){
		this.physicalReason=physicalReason;
	}
	public String getPhysicalReason(){
		return physicalReason;
	}
	public void setKnowReason(String knowReason){
		this.knowReason=knowReason;
	}
	public String getKnowReason(){
		return knowReason;
	}
	public void setWish(String wish){
		this.wish=wish;
	}
	public String getWish(){
		return wish;
	}
	public void setOtherReason(String otherReason){
		this.otherReason=otherReason;
	}
	public String getOtherReason(){
		return otherReason;
	}
	public void setSocially(int socially){
		this.socially=socially;
	}
	public int getSocially(){
		return socially;
	}
	public void setEmotional(String emotional){
		this.emotional=emotional;
	}
	public String getEmotional(){
		return emotional;
	}
	public void setInducements(String inducements){
		this.inducements=inducements;
	}
	public String getInducements(){
		return inducements;
	}
	public void setSolve(String solve){
		this.solve=solve;
	}
	public String getSolve(){
		return solve;
	}
	public void setAttack(String attack){
		this.attack=attack;
	}
	public String getAttack(){
		return attack;
	}
	public void setTemper(String temper){
		this.temper=temper;
	}
	public String getTemper(){
		return temper;
	}
	public void setBehavior(String behavior){
		this.behavior=behavior;
	}
	public String getBehavior(){
		return behavior;
	}
	public void setBehaviorHandle(String behaviorHandle){
		this.behaviorHandle=behaviorHandle;
	}
	public String getBehaviorHandle(){
		return behaviorHandle;
	}
	public void setSport(String sport){
		this.sport=sport;
	}
	public String getSport(){
		return sport;
	}
	public void setArt(String art){
		this.art=art;
	}
	public String getArt(){
		return art;
	}
	public void setHobby(String hobby){
		this.hobby=hobby;
	}
	public String getHobby(){
		return hobby;
	}
	public void setMorningLife(String morningLife){
		this.morningLife=morningLife;
	}
	public String getMorningLife(){
		return morningLife;
	}
	public void setAfternoonLife(String afternoonLife){
		this.afternoonLife=afternoonLife;
	}
	public String getAfternoonLife(){
		return afternoonLife;
	}
	public void setNightLife(String nightLife){
		this.nightLife=nightLife;
	}
	public String getNightLife(){
		return nightLife;
	}
	public void setLifeEnvironment(String lifeEnvironment){
		this.lifeEnvironment=lifeEnvironment;
	}
	public String getLifeEnvironment(){
		return lifeEnvironment;
	}
	public void setWorkerNote(String workerNote){
		this.workerNote=workerNote;
	}
	public String getWorkerNote(){
		return workerNote;
	}
	public void setBehaviourNote(String behaviourNote){
		this.behaviourNote=behaviourNote;
	}
	public String getBehaviourNote(){
		return behaviourNote;
	}
	
	

	public String getApplyDate_str() {
		try {
			return applyDate == null || "".equals(applyDate) ? ""
					: ToolsUtils.getDateStringByFormat(applyDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setApplyDate_str(String applyDate_str) {
		this.applyDate_str = applyDate_str;
	}
	public String getPhysicalDate_str() {
		try {
			return physicalDate == null || "".equals(physicalDate) ? ""
					: ToolsUtils.getDateStringByFormat(physicalDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setPhysicalDate_str(String physicalDate_str) {
		this.physicalDate_str = physicalDate_str;
	}
	public String getVisionDate_str() {
		try {
			return visionDate == null || "".equals(visionDate) ? ""
					: ToolsUtils.getDateStringByFormat(visionDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setVisionDate_str(String visionDate_str) {
		this.visionDate_str = visionDate_str;
	}
	public String getHearingDate_str() {
		try {
			return hearingDate == null || "".equals(hearingDate) ? ""
					: ToolsUtils.getDateStringByFormat(hearingDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setHearingDate_str(String hearingDate_str) {
		this.hearingDate_str = hearingDate_str;
	}
	public String getiQDate_str() {
		try {
			return iQDate == null || "".equals(iQDate) ? ""
					: ToolsUtils.getDateStringByFormat(iQDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setiQDate_str(String iQDate_str) {
		this.iQDate_str = iQDate_str;
	}
	public String getSpeechDate_str() {
		try {
			return speechDate == null || "".equals(speechDate) ? ""
					: ToolsUtils.getDateStringByFormat(speechDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setSpeechDate_str(String speechDate_str) {
		this.speechDate_str = speechDate_str;
	}
	public String getBehaviorDate_str() {
		try {
			return behaviorDate == null || "".equals(behaviorDate) ? ""
					: ToolsUtils.getDateStringByFormat(behaviorDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setBehaviorDate_str(String behaviorDate_str) {
		this.behaviorDate_str = behaviorDate_str;
	}
	
	
	
	public Date getAwaitDate() {
		return awaitDate;
	}
	public void setAwaitDate(Date awaitDate) {
		this.awaitDate = awaitDate;
	}
	public String getAwaitDate_str() {
		try {
			return awaitDate == null || "".equals(awaitDate) ? ""
					: ToolsUtils.getDateStringByFormat(awaitDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setAwaitDate_str(String awaitDate_str) {
		this.awaitDate_str = awaitDate_str;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getStartDate_str() {
		try {
			return startDate == null || "".equals(startDate) ? ""
					: ToolsUtils.getDateStringByFormat(startDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setStartDate_str(String startDate_str) {
		this.startDate_str = startDate_str;
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
	
	
	
	public String getlMuscle() {
		return lMuscle;
	}
	public void setlMuscle(String lMuscle) {
		this.lMuscle = lMuscle;
	}
	public String getlMuscleNote() {
		return lMuscleNote;
	}
	public void setlMuscleNote(String lMuscleNote) {
		this.lMuscleNote = lMuscleNote;
	}
	public String getsMuscle() {
		return sMuscle;
	}
	public void setsMuscle(String sMuscle) {
		this.sMuscle = sMuscle;
	}
	public String getsMuscleNote() {
		return sMuscleNote;
	}
	public void setsMuscleNote(String sMuscleNote) {
		this.sMuscleNote = sMuscleNote;
	}
	public int getsCantonese() {
		return sCantonese;
	}
	public void setsCantonese(int sCantonese) {
		this.sCantonese = sCantonese;
	}
	public int getrCantonese() {
		return rCantonese;
	}
	public void setrCantonese(int rCantonese) {
		this.rCantonese = rCantonese;
	}
	public int getlCantonese() {
		return lCantonese;
	}
	public void setlCantonese(int lCantonese) {
		this.lCantonese = lCantonese;
	}
	public int getwCantonese() {
		return wCantonese;
	}
	public void setwCantonese(int wCantonese) {
		this.wCantonese = wCantonese;
	}
	public int getsMandarin() {
		return sMandarin;
	}
	public void setsMandarin(int sMandarin) {
		this.sMandarin = sMandarin;
	}
	public int getrMandarin() {
		return rMandarin;
	}
	public void setrMandarin(int rMandarin) {
		this.rMandarin = rMandarin;
	}
	public int getlMandarin() {
		return lMandarin;
	}
	public void setlMandarin(int lMandarin) {
		this.lMandarin = lMandarin;
	}
	public int getwMandarin() {
		return wMandarin;
	}
	public void setwMandarin(int wMandarin) {
		this.wMandarin = wMandarin;
	}
	public String getsRLWOther() {
		return sRLWOther;
	}
	public void setsRLWOther(String sRLWOther) {
		this.sRLWOther = sRLWOther;
	}
	
	
	
	public Date getAssessDate() {
		return assessDate;
	}
	public void setAssessDate(Date assessDate) {
		this.assessDate = assessDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
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
	public String getCloseDate_str() {
		try {
			return closeDate == null || "".equals(closeDate) ? ""
					: ToolsUtils.getDateStringByFormat(closeDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setCloseDate_str(String closeDate_str) {
		this.closeDate_str = closeDate_str;
	}
	
	
	
	public String getCaseWorker() {
		return caseWorker;
	}
	public void setCaseWorker(String caseWorker) {
		this.caseWorker = caseWorker;
	}
	public Date getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	public int getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(int caseStatus) {
		this.caseStatus = caseStatus;
	}
	public String getReceiveDate_str() {
		try {
			return receiveDate == null || "".equals(receiveDate) ? ""
					: ToolsUtils.getDateStringByFormat(receiveDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setReceiveDate_str(String receiveDate_str) {
		this.receiveDate_str = receiveDate_str;
	}
	
	
	
	public String getAllergyDrug() {
		return allergyDrug;
	}
	public void setAllergyDrug(String allergyDrug) {
		this.allergyDrug = allergyDrug;
	}
	public void setCommunicationLevel(int communicationLevel){
		this.communicationLevel=communicationLevel;
	}
	public int getCommunicationLevel(){
		return communicationLevel;
	}
	public void setSelfLevel(int selfLevel){
		this.selfLevel=selfLevel;
	}
	public int getSelfLevel(){
		return selfLevel;
	}
	public void setLifeLevel(int lifeLevel){
		this.lifeLevel=lifeLevel;
	}
	public int getLifeLevel(){
		return lifeLevel;
	}
	public void setSocialLevel(int socialLevel){
		this.socialLevel=socialLevel;
	}
	public int getSocialLevel(){
		return socialLevel;
	}
	public void setRecourceLevel(int recourceLevel){
		this.recourceLevel=recourceLevel;
	}
	public int getRecourceLevel(){
		return recourceLevel;
	}
	public void setGuideLevel(int guideLevel){
		this.guideLevel=guideLevel;
	}
	public int getGuideLevel(){
		return guideLevel;
	}
	public void setSafetyLevel(int safetyLevel){
		this.safetyLevel=safetyLevel;
	}
	public int getSafetyLevel(){
		return safetyLevel;
	}
	public void setFnLevel(int fnLevel){
		this.fnLevel=fnLevel;
	}
	public int getFnLevel(){
		return fnLevel;
	}
	public void setPlayLevel(int playLevel){
		this.playLevel=playLevel;
	}
	public int getPlayLevel(){
		return playLevel;
	}
	public void setWorkerLevel(int workerLevel){
		this.workerLevel=workerLevel;
	}
	public int getWorkerLevel(){
		return workerLevel;
	}
	
	
	
	public String getSupportPeople() {
		return supportPeople;
	}
	public void setSupportPeople(String supportPeople) {
		this.supportPeople = supportPeople;
	}
	public String getColdnessPeople() {
		return coldnessPeople;
	}
	public void setColdnessPeople(String coldnessPeople) {
		this.coldnessPeople = coldnessPeople;
	}
	public String getConnivePeople() {
		return connivePeople;
	}
	public void setConnivePeople(String connivePeople) {
		this.connivePeople = connivePeople;
	}
	public String getNeglectPeople() {
		return neglectPeople;
	}
	public void setNeglectPeople(String neglectPeople) {
		this.neglectPeople = neglectPeople;
	}
	public String getProtectPeople() {
		return protectPeople;
	}
	public void setProtectPeople(String protectPeople) {
		this.protectPeople = protectPeople;
	}
	public String getSeverePeople() {
		return severePeople;
	}
	public void setSeverePeople(String severePeople) {
		this.severePeople = severePeople;
	}
	
	
	
	public String getTreatmentCategory() {
		return treatmentCategory;
	}
	public void setTreatmentCategory(String treatmentCategory) {
		this.treatmentCategory = treatmentCategory;
	}
	public Date getAcceptDate() {
		return acceptDate;
	}
	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}
	public String getAcceptDate_str() {
		try {
			return acceptDate == null || "".equals(acceptDate) ? ""
					: ToolsUtils.getDateStringByFormat(acceptDate, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setAcceptDate_str(String acceptDate_str) {
		this.acceptDate_str = acceptDate_str;
	}
	@Override
	public String toString(){
		return "Treatment [treatmentID="+treatmentID+",treatmentType="+treatmentType+",custID="+custID+
				",treatmentNO="+treatmentNO+",worker="+worker+",applyDate="+applyDate+
				",serviceStatus="+serviceStatus+",reason="+reason+
				",note="+note+",familySituation="+familySituation+",physicalAssess="+physicalAssess+
				",physicalLevel="+physicalLevel+",physicalDate="+physicalDate+
				",physicalPlace="+physicalPlace+",physicalDescribe="+physicalDescribe+
				",physicalNote="+physicalNote+",visionAssess="+visionAssess+",visionLevel="+visionLevel+
				",visionDate="+visionDate+",visionPlace="+visionPlace+",visionDescribe="+visionDescribe+
				",visionNote="+visionNote+",hearingAssess="+hearingAssess+",hearingLevel="+hearingLevel+
				",hearingDate="+hearingDate+",hearingPlace="+hearingPlace+",hearingDescribe="+hearingDescribe+
				",hearingNote="+hearingNote+",iQAssess="+iQAssess+",iQLevel="+iQLevel+",iQDate="+iQDate+
				",iQPlace="+iQPlace+",iQDescribe="+iQDescribe+",iQNote="+iQNote+",speechAssess="+speechAssess+
				",speechLevel="+speechLevel+",speechDate="+speechDate+",speechPlace="+speechPlace+
				",speechDescribe="+speechDescribe+",speechNote="+speechNote+",behaviorAssess="+behaviorAssess+
				",behaviorLevel="+behaviorLevel+",behaviorDate="+behaviorDate+",behaviorPlace="+behaviorPlace+
				",behaviorDescribe="+behaviorDescribe+",behaviorNote="+behaviorNote+",communication="+communication+
				",communicationNote="+communicationNote+",life="+life+",lifeNote="+lifeNote+",useResources="+useResources+
				",useResourcesNote="+useResourcesNote+",selfGuided="+selfGuided+",selfGuidedNote="+selfGuidedNote+
				",functional="+functional+",functionalNote="+functionalNote+",play="+play+",playNote="+playNote+
				",work="+work+",workNote="+workNote+",cognitive="+cognitive+",cognitiveNote="+cognitiveNote+
				",lMuscle="+lMuscle+",lMuscleNote="+lMuscleNote+",sMuscle="+sMuscle+",sMuscleNote="+sMuscleNote+
				",interpersonal="+interpersonal+",interpersonalNote="+interpersonalNote+",selfAbility="+selfAbility+
				",selfAbilityNote="+selfAbilityNote+",sensory="+sensory+",sensoryNote="+sensoryNote+",health="+health+
				",healthNote="+healthNote+",disease="+disease+",diseaseOther="+diseaseOther+",allergyFood="+allergyFood+
				",allergyOther="+allergyOther+",allergyDrug="+allergyDrug+",medication="+medication+",medicationNote="+medicationNote+
				",history="+history+",sCantonese="+sCantonese+",rCantonese="+rCantonese+",lCantonese="+lCantonese+
				",wCantonese="+wCantonese+",sMandarin="+sMandarin+",rMandarin="+rMandarin+",lMandarin="+lMandarin+
				",wMandarin="+wMandarin+",sRLWOther="+sRLWOther+",others="+others+",physicalReason="+physicalReason+
				",knowReason="+knowReason+",wish="+wish+",otherReason="+otherReason+",socially="+socially+
				",emotional="+emotional+",inducements="+inducements+",solve="+solve+",attack="+attack+",temper="+temper+
				",behavior="+behavior+",behaviorHandle="+behaviorHandle+",sport="+sport+",art="+art+",hobby="+hobby+
				",morningLife="+morningLife+",afternoonLife="+afternoonLife+",nightLife="+nightLife+
				",lifeEnvironment="+lifeEnvironment+",workerNote="+workerNote+",behaviourNote="+behaviourNote+
				",applyDate_str="+applyDate_str+",physicalDate_str="+physicalDate_str+
				",visionDate_str="+visionDate_str+",hearingDate_str="+hearingDate_str+",iQDate_str="+iQDate_str+",speechDate_str="+speechDate_str+
				",behaviorDate_str="+behaviorDate_str+",startDate="+startDate+",startDate_str"+startDate_str+
				",awaitDate="+awaitDate+",awaitDate_str="+awaitDate_str+",fullName="+fullName+",isMember="+isMember+
				",assessDate="+assessDate+",closeDate="+closeDate+",assessDate_str="+assessDate_str+",closeDate_str="+closeDate_str+
				",caseWorker="+caseWorker+",caseStatus="+caseStatus+",receiveDate="+receiveDate+",receiveDate_str="+receiveDate_str+
				",diseaseHeredity="+diseaseHeredity+",communicationLevel="+communicationLevel+",selfLevel="+selfLevel+",lifeLevel="+lifeLevel+
				",socialLevel="+socialLevel+",recourceLevel="+recourceLevel+",guideLevel="+guideLevel+",safetyLevel="+safetyLevel+",fnLevel="+fnLevel+",playLevel="+playLevel+
				",workerLevel="+workerLevel+",supportPeople="+supportPeople+",coldnessPeople="+coldnessPeople+",connivePeople="+connivePeople+",neglectPeople="+neglectPeople+
				",protectPeople="+protectPeople+",severePeople="+severePeople+",treatmentCategory="+treatmentCategory+
				",acceptDate="+acceptDate+",acceptDate_str="+acceptDate_str+"]";
	}
}
