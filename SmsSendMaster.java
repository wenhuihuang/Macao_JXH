
import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** SmsSendMaster
	BILLMASTERID	VARCHAR(20)
	BILLDATE	DATETIME(23,3)
	BILLNO	VARCHAR(32)
	CORPID	CHAR(4)
	SMS	VARCHAR(250)
	TELNOCOUNT	INT(10)
	SUCCEEDQTY	INT(10)
	FAILUREQTY	INT(10)
	NOTE	VARCHAR(128)
	MAKEUSERID	VARCHAR(16)
	STATE	INT(10)
	SMSTYPE	VARCHAR(16)
	FGRADE	INT(10)

billMasterID,billDate,billNO,corpID,sms,telNOCount,succeedQty,failureQty,note,makeUserID,state,smsType,fGrade
?,?,?,?,?,?,?,?,?,?,?,?,?

smsSendMaster.billMasterID,smsSendMaster.billDate,smsSendMaster.billNO,smsSendMaster.corpID,smsSendMaster.sms,smsSendMaster.telNOCount,smsSendMaster.succeedQty,smsSendMaster.failureQty,smsSendMaster.note,smsSendMaster.makeUserID,smsSendMaster.state,smsSendMaster.smsType,smsSendMaster.fGrade

billMasterID=?,billDate=?,billNO=?,corpID=?,sms=?,telNOCount=?,succeedQty=?,failureQty=?,note=?,makeUserID=?,state=?,smsType=?,fGrade=?
*/
public class SmsSendMaster implements Serializable {
	private static final long serialVersionUID = 1L;
	private String billMasterID;
	private Date billDate;
	private String billNO;
	private String corpID;
	private String sms;
	private int telNOCount;
	private int succeedQty;
	private int failureQty;
	private String note;
	private String makeUserID;
	private int state;
	private String smsType;
	private int fGrade;

	public SmsSendMaster(){
		super();
	}
	public SmsSendMaster(String billMasterID, Date billDate, String billNO, String corpID, String sms, int telNOCount, int succeedQty, int failureQty, String note, String makeUserID, int state, String smsType, int fGrade ){
		super();
		this.billMasterID=billMasterID;
		this.billDate=billDate;
		this.billNO=billNO;
		this.corpID=corpID;
		this.sms=sms;
		this.telNOCount=telNOCount;
		this.succeedQty=succeedQty;
		this.failureQty=failureQty;
		this.note=note;
		this.makeUserID=makeUserID;
		this.state=state;
		this.smsType=smsType;
		this.fGrade=fGrade;
	}
	public void setBillMasterID(String billMasterID){
		this.billMasterID=billMasterID;
	}
	public String getBillMasterID(){
		return billMasterID;
	}
	public void setBillDate(Date billDate){
		this.billDate=billDate;
	}
	public Date getBillDate(){
		return billDate;
	}
	public void setBillNO(String billNO){
		this.billNO=billNO;
	}
	public String getBillNO(){
		return billNO;
	}
	public void setCorpID(String corpID){
		this.corpID=corpID;
	}
	public String getCorpID(){
		return corpID;
	}
	public void setSms(String sms){
		this.sms=sms;
	}
	public String getSms(){
		return sms;
	}
	public void setTelNOCount(int telNOCount){
		this.telNOCount=telNOCount;
	}
	public int getTelNOCount(){
		return telNOCount;
	}
	public void setSucceedQty(int succeedQty){
		this.succeedQty=succeedQty;
	}
	public int getSucceedQty(){
		return succeedQty;
	}
	public void setFailureQty(int failureQty){
		this.failureQty=failureQty;
	}
	public int getFailureQty(){
		return failureQty;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public void setMakeUserID(String makeUserID){
		this.makeUserID=makeUserID;
	}
	public String getMakeUserID(){
		return makeUserID;
	}
	public void setState(int state){
		this.state=state;
	}
	public int getState(){
		return state;
	}
	public void setSmsType(String smsType){
		this.smsType=smsType;
	}
	public String getSmsType(){
		return smsType;
	}
	public void setFGrade(int fGrade){
		this.fGrade=fGrade;
	}
	public int getFGrade(){
		return fGrade;
	}
	@Override
	public String toString(){
		return "SmsSendMaster [billMasterID="+billMasterID+",billDate="+billDate+",billNO="+billNO+",corpID="+corpID+",sms="+sms+",telNOCount="+telNOCount+",succeedQty="+succeedQty+",failureQty="+failureQty+",note="+note+",makeUserID="+makeUserID+",state="+state+",smsType="+smsType+",fGrade="+fGrade+"]";
	}
}

