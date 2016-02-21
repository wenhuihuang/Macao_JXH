package com.jxh.pojo;


import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;

public class LanguageTreatmentPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String treatmentID;
	private int treatmentType;
	private String caseNO;
	private String treatmentNO;
	private String worker;
	private Date applyDate;
	private Date assessDate;
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
	private int disease;
	private String diseaseNote;
	private int allergy;
	private String allergyNote;
	private int medication;
	private String medicationNote;
	private String history;
	private int sCantonese;
	private int rCantonese;
	private int lCantonese;
	private int wCantonese;
	private int sMandarin;
	private int rSMandarin;
	private int lSMandarin;
	private int wSMandarin;
	private String sRLWOther;
	private String others;
	private String physicalReason;
	private String knowReason;
	private String wish;
	private String otherReason;
	private int socially;
	private int emotional;
	private String inducements;
	private String solve;
	private int attack;
	private int temper;
	private int behavior;
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

	public LanguageTreatmentPojo(){
		super();
	}
	public LanguageTreatmentPojo(String treatmentID, int treatmentType, String caseNO, String treatmentNO, String worker, Date applyDate, Date assessDate, int serviceStatus, String reason, String note, String familySituation, int physicalAssess, int physicalLevel, Date physicalDate, String physicalPlace, String physicalDescribe, String physicalNote, int visionAssess, int visionLevel, Date visionDate, String visionPlace, String visionDescribe, String visionNote, int hearingAssess, int hearingLevel, Date hearingDate, String hearingPlace, String hearingDescribe, String hearingNote, int iQAssess, int iQLevel, Date iQDate, String iQPlace, String iQDescribe, String iQNote, int speechAssess, int speechLevel, Date speechDate, String speechPlace, String speechDescribe, String speechNote, int behaviorAssess, int behaviorLevel, Date behaviorDate, String behaviorPlace, String behaviorDescribe, String behaviorNote, String communication, String communicationNote, String life, String lifeNote, String useResources, String useResourcesNote, String selfGuided, String selfGuidedNote, String functional, String functionalNote, String play, String playNote, String work, String workNote, String cognitive, String cognitiveNote, String lMuscle, String lMuscleNote, String sMuscle, String sMuscleNote, String interpersonal, String interpersonalNote, String selfAbility, String selfAbilityNote, String sensory, String sensoryNote, String health, String healthNote, int disease, String diseaseNote, int allergy, String allergyNote, int medication, String medicationNote, String history, int sCantonese, int rCantonese, int lCantonese, int wCantonese, int sMandarin, int rSMandarin, int lSMandarin, int wSMandarin, String sRLWOther, String others, String physicalReason, String knowReason, String wish, String otherReason, int socially, int emotional, String inducements, String solve, int attack, int temper, int behavior, String behaviorHandle, String sport, String art, String hobby, String morningLife, String afternoonLife, String nightLife, String lifeEnvironment, String workerNote, String behaviourNote ){
		super();
		this.treatmentID=treatmentID;
		this.treatmentType=treatmentType;
		this.caseNO=caseNO;
		this.treatmentNO=treatmentNO;
		this.worker=worker;
		this.applyDate=applyDate;
		this.assessDate=assessDate;
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
		this.diseaseNote=diseaseNote;
		this.allergy=allergy;
		this.allergyNote=allergyNote;
		this.medication=medication;
		this.medicationNote=medicationNote;
		this.history=history;
		this.sCantonese=sCantonese;
		this.rCantonese=rCantonese;
		this.lCantonese=lCantonese;
		this.wCantonese=wCantonese;
		this.sMandarin=sMandarin;
		this.rSMandarin=rSMandarin;
		this.lSMandarin=lSMandarin;
		this.wSMandarin=wSMandarin;
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
	public void setCaseNO(String caseNO){
		this.caseNO=caseNO;
	}
	public String getCaseNO(){
		return caseNO;
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
	public void setAssessDate(Date assessDate){
		this.assessDate=assessDate;
	}
	public Date getAssessDate(){
		return assessDate;
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
	public void setIQAssess(int iQAssess){
		this.iQAssess=iQAssess;
	}
	public int getIQAssess(){
		return iQAssess;
	}
	public void setIQLevel(int iQLevel){
		this.iQLevel=iQLevel;
	}
	public int getIQLevel(){
		return iQLevel;
	}
	public void setIQDate(Date iQDate){
		this.iQDate=iQDate;
	}
	public Date getIQDate(){
		return iQDate;
	}
	public void setIQPlace(String iQPlace){
		this.iQPlace=iQPlace;
	}
	public String getIQPlace(){
		return iQPlace;
	}
	public void setIQDescribe(String iQDescribe){
		this.iQDescribe=iQDescribe;
	}
	public String getIQDescribe(){
		return iQDescribe;
	}
	public void setIQNote(String iQNote){
		this.iQNote=iQNote;
	}
	public String getIQNote(){
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
	public void setLMuscle(String lMuscle){
		this.lMuscle=lMuscle;
	}
	public String getLMuscle(){
		return lMuscle;
	}
	public void setLMuscleNote(String lMuscleNote){
		this.lMuscleNote=lMuscleNote;
	}
	public String getLMuscleNote(){
		return lMuscleNote;
	}
	public void setSMuscle(String sMuscle){
		this.sMuscle=sMuscle;
	}
	public String getSMuscle(){
		return sMuscle;
	}
	public void setSMuscleNote(String sMuscleNote){
		this.sMuscleNote=sMuscleNote;
	}
	public String getSMuscleNote(){
		return sMuscleNote;
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
	public void setDisease(int disease){
		this.disease=disease;
	}
	public int getDisease(){
		return disease;
	}
	public void setDiseaseNote(String diseaseNote){
		this.diseaseNote=diseaseNote;
	}
	public String getDiseaseNote(){
		return diseaseNote;
	}
	public void setAllergy(int allergy){
		this.allergy=allergy;
	}
	public int getAllergy(){
		return allergy;
	}
	public void setAllergyNote(String allergyNote){
		this.allergyNote=allergyNote;
	}
	public String getAllergyNote(){
		return allergyNote;
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
	public void setSCantonese(int sCantonese){
		this.sCantonese=sCantonese;
	}
	public int getSCantonese(){
		return sCantonese;
	}
	public void setRCantonese(int rCantonese){
		this.rCantonese=rCantonese;
	}
	public int getRCantonese(){
		return rCantonese;
	}
	public void setLCantonese(int lCantonese){
		this.lCantonese=lCantonese;
	}
	public int getLCantonese(){
		return lCantonese;
	}
	public void setWCantonese(int wCantonese){
		this.wCantonese=wCantonese;
	}
	public int getWCantonese(){
		return wCantonese;
	}
	public void setSMandarin(int sMandarin){
		this.sMandarin=sMandarin;
	}
	public int getSMandarin(){
		return sMandarin;
	}
	public void setRSMandarin(int rSMandarin){
		this.rSMandarin=rSMandarin;
	}
	public int getRSMandarin(){
		return rSMandarin;
	}
	public void setLSMandarin(int lSMandarin){
		this.lSMandarin=lSMandarin;
	}
	public int getLSMandarin(){
		return lSMandarin;
	}
	public void setWSMandarin(int wSMandarin){
		this.wSMandarin=wSMandarin;
	}
	public int getWSMandarin(){
		return wSMandarin;
	}
	public void setSRLWOther(String sRLWOther){
		this.sRLWOther=sRLWOther;
	}
	public String getSRLWOther(){
		return sRLWOther;
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
	public void setEmotional(int emotional){
		this.emotional=emotional;
	}
	public int getEmotional(){
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
	public void setAttack(int attack){
		this.attack=attack;
	}
	public int getAttack(){
		return attack;
	}
	public void setTemper(int temper){
		this.temper=temper;
	}
	public int getTemper(){
		return temper;
	}
	public void setBehavior(int behavior){
		this.behavior=behavior;
	}
	public int getBehavior(){
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
	@Override
	public String toString(){
		return "Treatment [treatmentID="+treatmentID+",treatmentType="+treatmentType+",caseNO="+caseNO+",treatmentNO="+treatmentNO+",worker="+worker+",applyDate="+applyDate+",assessDate="+assessDate+",serviceStatus="+serviceStatus+",reason="+reason+",note="+note+",familySituation="+familySituation+",physicalAssess="+physicalAssess+",physicalLevel="+physicalLevel+",physicalDate="+physicalDate+",physicalPlace="+physicalPlace+",physicalDescribe="+physicalDescribe+",physicalNote="+physicalNote+",visionAssess="+visionAssess+",visionLevel="+visionLevel+",visionDate="+visionDate+",visionPlace="+visionPlace+",visionDescribe="+visionDescribe+",visionNote="+visionNote+",hearingAssess="+hearingAssess+",hearingLevel="+hearingLevel+",hearingDate="+hearingDate+",hearingPlace="+hearingPlace+",hearingDescribe="+hearingDescribe+",hearingNote="+hearingNote+",iQAssess="+iQAssess+",iQLevel="+iQLevel+",iQDate="+iQDate+",iQPlace="+iQPlace+",iQDescribe="+iQDescribe+",iQNote="+iQNote+",speechAssess="+speechAssess+",speechLevel="+speechLevel+",speechDate="+speechDate+",speechPlace="+speechPlace+",speechDescribe="+speechDescribe+",speechNote="+speechNote+",behaviorAssess="+behaviorAssess+",behaviorLevel="+behaviorLevel+",behaviorDate="+behaviorDate+",behaviorPlace="+behaviorPlace+",behaviorDescribe="+behaviorDescribe+",behaviorNote="+behaviorNote+",communication="+communication+",communicationNote="+communicationNote+",life="+life+",lifeNote="+lifeNote+",useResources="+useResources+",useResourcesNote="+useResourcesNote+",selfGuided="+selfGuided+",selfGuidedNote="+selfGuidedNote+",functional="+functional+",functionalNote="+functionalNote+",play="+play+",playNote="+playNote+",work="+work+",workNote="+workNote+",cognitive="+cognitive+",cognitiveNote="+cognitiveNote+",lMuscle="+lMuscle+",lMuscleNote="+lMuscleNote+",sMuscle="+sMuscle+",sMuscleNote="+sMuscleNote+",interpersonal="+interpersonal+",interpersonalNote="+interpersonalNote+",selfAbility="+selfAbility+",selfAbilityNote="+selfAbilityNote+",sensory="+sensory+",sensoryNote="+sensoryNote+",health="+health+",healthNote="+healthNote+",disease="+disease+",diseaseNote="+diseaseNote+",allergy="+allergy+",allergyNote="+allergyNote+",medication="+medication+",medicationNote="+medicationNote+",history="+history+",sCantonese="+sCantonese+",rCantonese="+rCantonese+",lCantonese="+lCantonese+",wCantonese="+wCantonese+",sMandarin="+sMandarin+",rSMandarin="+rSMandarin+",lSMandarin="+lSMandarin+",wSMandarin="+wSMandarin+",sRLWOther="+sRLWOther+",others="+others+",physicalReason="+physicalReason+",knowReason="+knowReason+",wish="+wish+",otherReason="+otherReason+",socially="+socially+",emotional="+emotional+",inducements="+inducements+",solve="+solve+",attack="+attack+",temper="+temper+",behavior="+behavior+",behaviorHandle="+behaviorHandle+",sport="+sport+",art="+art+",hobby="+hobby+",morningLife="+morningLife+",afternoonLife="+afternoonLife+",nightLife="+nightLife+",lifeEnvironment="+lifeEnvironment+",workerNote="+workerNote+",behaviourNote="+behaviourNote+"]";
	}
}

