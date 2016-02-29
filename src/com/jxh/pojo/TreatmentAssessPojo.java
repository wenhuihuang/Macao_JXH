package com.jxh.pojo;


import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.sql.*;
import java.text.ParseException;
import java.math.*;


public class TreatmentAssessPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int assessID;
	private String treatmentID;
	private String custID;
	private int assessType;
	private String assessCategory;
	private Date assessDate;
	private String place;
	private String worker;
	private String otherWorkers;
	private String otherFamily;
	private String focus;
	private String eyeContact;
	private String soundsReply;
	private String toySkill;
	private String imitation;
	private String communicate;
	private String conceptual;
	private String ability;
	private String vocabulary;
	private String sentenceLen;
	private String sentenceOrg;
	private String question;
	private String narrative;
	private String storyTell;
	private String interview;
	private String expressionOther;
	private String words;
	private String oralOrder;
	private String questions;
	private String story;
	private String logical;
	private String underStandConceptual;
	private String underStandOther;
	private int vowel;
	private String vowelNote;
	private int beforeConsonant;
	private String beforeConsonantNote;
	private int afterConsonant;
	private String afterConsonantNote;
	private int tone;
	private String toneNote;
	private String pronunciationOther;
	private String other;
	private int acceptService;
	private String servicePoint;
	private String sites;
	private String suggestOther;
	private String communication;
	private String communicationNote;
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
	private String interest;
	private String hope;
	private String totalSuggest;
	
	private String assessDate_str;

	public TreatmentAssessPojo(){
		super();
	}
	public TreatmentAssessPojo(int assessID, String treatmentID, String custID, int assessType, String assessCategory, Date assessDate, String place, String worker, String otherWorkers, String otherFamily, String focus, String eyeContact, String soundsReply, String toySkill, String imitation, String communicate, String conceptual, String ability, String vocabulary, String sentenceLen, String sentenceOrg, String question, String narrative, String storyTell, String interview, String expressionOther, String words, String oralOrder, String questions, String story, String logical, String underStandConceptual, String underStandOther, int vowel, String vowelNote, int beforeConsonant, String beforeConsonantNote, int afterConsonant, String afterConsonantNote, int tone, String toneNote, String pronunciationOther, String other, int acceptService, String servicePoint, String sites, String suggestOther, String communication, String communicationNote, String cognitive, String cognitiveNote, String lMuscle, String lMuscleNote, String sMuscle, String sMuscleNote, String interpersonal, String interpersonalNote, String selfAbility, String selfAbilityNote, String sensory, String sensoryNote, String health, String healthNote, String interest, String hope, String totalSuggest ,String assessDate_str){
		super();
		this.assessID=assessID;
		this.treatmentID=treatmentID;
		this.custID=custID;
		this.assessType=assessType;
		this.assessCategory=assessCategory;
		this.assessDate=assessDate;
		this.place=place;
		this.worker=worker;
		this.otherWorkers=otherWorkers;
		this.otherFamily=otherFamily;
		this.focus=focus;
		this.eyeContact=eyeContact;
		this.soundsReply=soundsReply;
		this.toySkill=toySkill;
		this.imitation=imitation;
		this.communicate=communicate;
		this.conceptual=conceptual;
		this.ability=ability;
		this.vocabulary=vocabulary;
		this.sentenceLen=sentenceLen;
		this.sentenceOrg=sentenceOrg;
		this.question=question;
		this.narrative=narrative;
		this.storyTell=storyTell;
		this.interview=interview;
		this.expressionOther=expressionOther;
		this.words=words;
		this.oralOrder=oralOrder;
		this.questions=questions;
		this.story=story;
		this.logical=logical;
		this.underStandConceptual=underStandConceptual;
		this.underStandOther=underStandOther;
		this.vowel=vowel;
		this.vowelNote=vowelNote;
		this.beforeConsonant=beforeConsonant;
		this.beforeConsonantNote=beforeConsonantNote;
		this.afterConsonant=afterConsonant;
		this.afterConsonantNote=afterConsonantNote;
		this.tone=tone;
		this.toneNote=toneNote;
		this.pronunciationOther=pronunciationOther;
		this.other=other;
		this.acceptService=acceptService;
		this.servicePoint=servicePoint;
		this.sites=sites;
		this.suggestOther=suggestOther;
		this.communication=communication;
		this.communicationNote=communicationNote;
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
		this.interest=interest;
		this.hope=hope;
		this.totalSuggest=totalSuggest;
		this.assessDate_str=assessDate_str;
	}
	public void setAssessID(int assessID){
		this.assessID=assessID;
	}
	public int getAssessID(){
		return assessID;
	}
	public void setTreatmentID(String treatmentID){
		this.treatmentID=treatmentID;
	}
	public String getTreatmentID(){
		return treatmentID;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setAssessType(int assessType){
		this.assessType=assessType;
	}
	public int getAssessType(){
		return assessType;
	}
	public void setAssessCategory(String assessCategory){
		this.assessCategory=assessCategory;
	}
	public String getAssessCategory(){
		return assessCategory;
	}
	public void setAssessDate(Date assessDate){
		this.assessDate=assessDate;
	}
	public Date getAssessDate(){
		return assessDate;
	}
	public void setPlace(String place){
		this.place=place;
	}
	public String getPlace(){
		return place;
	}
	public void setWorker(String worker){
		this.worker=worker;
	}
	public String getWorker(){
		return worker;
	}
	public void setOtherWorkers(String otherWorkers){
		this.otherWorkers=otherWorkers;
	}
	public String getOtherWorkers(){
		return otherWorkers;
	}
	public void setOtherFamily(String otherFamily){
		this.otherFamily=otherFamily;
	}
	public String getOtherFamily(){
		return otherFamily;
	}
	public void setFocus(String focus){
		this.focus=focus;
	}
	public String getFocus(){
		return focus;
	}
	public void setEyeContact(String eyeContact){
		this.eyeContact=eyeContact;
	}
	public String getEyeContact(){
		return eyeContact;
	}
	public void setSoundsReply(String soundsReply){
		this.soundsReply=soundsReply;
	}
	public String getSoundsReply(){
		return soundsReply;
	}
	public void setToySkill(String toySkill){
		this.toySkill=toySkill;
	}
	public String getToySkill(){
		return toySkill;
	}
	public void setImitation(String imitation){
		this.imitation=imitation;
	}
	public String getImitation(){
		return imitation;
	}
	public void setCommunicate(String communicate){
		this.communicate=communicate;
	}
	public String getCommunicate(){
		return communicate;
	}
	public void setConceptual(String conceptual){
		this.conceptual=conceptual;
	}
	public String getConceptual(){
		return conceptual;
	}
	public void setAbility(String ability){
		this.ability=ability;
	}
	public String getAbility(){
		return ability;
	}
	public void setVocabulary(String vocabulary){
		this.vocabulary=vocabulary;
	}
	public String getVocabulary(){
		return vocabulary;
	}
	public void setSentenceLen(String sentenceLen){
		this.sentenceLen=sentenceLen;
	}
	public String getSentenceLen(){
		return sentenceLen;
	}
	public void setSentenceOrg(String sentenceOrg){
		this.sentenceOrg=sentenceOrg;
	}
	public String getSentenceOrg(){
		return sentenceOrg;
	}
	public void setQuestion(String question){
		this.question=question;
	}
	public String getQuestion(){
		return question;
	}
	public void setNarrative(String narrative){
		this.narrative=narrative;
	}
	public String getNarrative(){
		return narrative;
	}
	public void setStoryTell(String storyTell){
		this.storyTell=storyTell;
	}
	public String getStoryTell(){
		return storyTell;
	}
	public void setInterview(String interview){
		this.interview=interview;
	}
	public String getInterview(){
		return interview;
	}
	public void setExpressionOther(String expressionOther){
		this.expressionOther=expressionOther;
	}
	public String getExpressionOther(){
		return expressionOther;
	}
	public void setWords(String words){
		this.words=words;
	}
	public String getWords(){
		return words;
	}
	public void setOralOrder(String oralOrder){
		this.oralOrder=oralOrder;
	}
	public String getOralOrder(){
		return oralOrder;
	}
	public void setQuestions(String questions){
		this.questions=questions;
	}
	public String getQuestions(){
		return questions;
	}
	public void setStory(String story){
		this.story=story;
	}
	public String getStory(){
		return story;
	}
	public void setLogical(String logical){
		this.logical=logical;
	}
	public String getLogical(){
		return logical;
	}
	public void setUnderStandConceptual(String underStandConceptual){
		this.underStandConceptual=underStandConceptual;
	}
	public String getUnderStandConceptual(){
		return underStandConceptual;
	}
	public void setUnderStandOther(String underStandOther){
		this.underStandOther=underStandOther;
	}
	public String getUnderStandOther(){
		return underStandOther;
	}
	public void setVowel(int vowel){
		this.vowel=vowel;
	}
	public int getVowel(){
		return vowel;
	}
	public void setVowelNote(String vowelNote){
		this.vowelNote=vowelNote;
	}
	public String getVowelNote(){
		return vowelNote;
	}
	public void setBeforeConsonant(int beforeConsonant){
		this.beforeConsonant=beforeConsonant;
	}
	public int getBeforeConsonant(){
		return beforeConsonant;
	}
	public void setBeforeConsonantNote(String beforeConsonantNote){
		this.beforeConsonantNote=beforeConsonantNote;
	}
	public String getBeforeConsonantNote(){
		return beforeConsonantNote;
	}
	public void setAfterConsonant(int afterConsonant){
		this.afterConsonant=afterConsonant;
	}
	public int getAfterConsonant(){
		return afterConsonant;
	}
	public void setAfterConsonantNote(String afterConsonantNote){
		this.afterConsonantNote=afterConsonantNote;
	}
	public String getAfterConsonantNote(){
		return afterConsonantNote;
	}
	public void setTone(int tone){
		this.tone=tone;
	}
	public int getTone(){
		return tone;
	}
	public void setToneNote(String toneNote){
		this.toneNote=toneNote;
	}
	public String getToneNote(){
		return toneNote;
	}
	public void setPronunciationOther(String pronunciationOther){
		this.pronunciationOther=pronunciationOther;
	}
	public String getPronunciationOther(){
		return pronunciationOther;
	}
	public void setOther(String other){
		this.other=other;
	}
	public String getOther(){
		return other;
	}
	public void setAcceptService(int acceptService){
		this.acceptService=acceptService;
	}
	public int getAcceptService(){
		return acceptService;
	}
	public void setServicePoint(String servicePoint){
		this.servicePoint=servicePoint;
	}
	public String getServicePoint(){
		return servicePoint;
	}
	public void setSites(String sites){
		this.sites=sites;
	}
	public String getSites(){
		return sites;
	}
	public void setSuggestOther(String suggestOther){
		this.suggestOther=suggestOther;
	}
	public String getSuggestOther(){
		return suggestOther;
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
	public void setInterest(String interest){
		this.interest=interest;
	}
	public String getInterest(){
		return interest;
	}
	public void setHope(String hope){
		this.hope=hope;
	}
	public String getHope(){
		return hope;
	}
	public void setTotalSuggest(String totalSuggest){
		this.totalSuggest=totalSuggest;
	}
	public String getTotalSuggest(){
		return totalSuggest;
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
	@Override
	public String toString(){
		return "TreatmentAssess [assessID="+assessID+",treatmentID="+treatmentID+",custID="+custID+",assessType="+assessType+",assessCategory="+assessCategory+",assessDate="+assessDate+",place="+place+",worker="+worker+",otherWorkers="+otherWorkers+",otherFamily="+otherFamily+",focus="+focus+",eyeContact="+eyeContact+",soundsReply="+soundsReply+",toySkill="+toySkill+",imitation="+imitation+",communicate="+communicate+",conceptual="+conceptual+",ability="+ability+",vocabulary="+vocabulary+",sentenceLen="+sentenceLen+",sentenceOrg="+sentenceOrg+",question="+question+",narrative="+narrative+",storyTell="+storyTell+",interview="+interview+",expressionOther="+expressionOther+",words="+words+",oralOrder="+oralOrder+",questions="+questions+",story="+story+",logical="+logical+",underStandConceptual="+underStandConceptual+",underStandOther="+underStandOther+",vowel="+vowel+",vowelNote="+vowelNote+",beforeConsonant="+beforeConsonant+",beforeConsonantNote="+beforeConsonantNote+",afterConsonant="+afterConsonant+",afterConsonantNote="+afterConsonantNote+",tone="+tone+",toneNote="+toneNote+",pronunciationOther="+pronunciationOther+",other="+other+",acceptService="+acceptService+",servicePoint="+servicePoint+",sites="+sites+",suggestOther="+suggestOther+",communication="+communication+",communicationNote="+communicationNote+",cognitive="+cognitive+",cognitiveNote="+cognitiveNote+",lMuscle="+lMuscle+",lMuscleNote="+lMuscleNote+",sMuscle="+sMuscle+",sMuscleNote="+sMuscleNote+",interpersonal="+interpersonal+",interpersonalNote="+interpersonalNote+",selfAbility="+selfAbility+",selfAbilityNote="+selfAbilityNote+",sensory="+sensory+",sensoryNote="+sensoryNote+",health="+health+",healthNote="+healthNote+",interest="+interest+",hope="+hope+",totalSuggest="+totalSuggest+",assessDate_str="+assessDate_str+"]";
	}
}

