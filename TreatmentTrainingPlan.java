
import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** TreatmentTrainingPlan
	PLANID	INT(10)
	TRAININGID	VARCHAR(20)
	ACTNO	VARCHAR(32)
	ACTNAME	VARCHAR(32)
	BILLDATE	DATETIME(23,3)
	ACTDETAIL	VARCHAR(128)
	NOTE	VARCHAR(128)
	TIME	VARCHAR(32)

planID,trainingID,actNO,actName,billDate,actDetail,note,time
?,?,?,?,?,?,?,?

treatmentTrainingPlan.planID,treatmentTrainingPlan.trainingID,treatmentTrainingPlan.actNO,treatmentTrainingPlan.actName,treatmentTrainingPlan.billDate,treatmentTrainingPlan.actDetail,treatmentTrainingPlan.note,treatmentTrainingPlan.time

planID=?,trainingID=?,actNO=?,actName=?,billDate=?,actDetail=?,note=?,time=?
*/
public class TreatmentTrainingPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int planID;
	private String trainingID;
	private String actNO;
	private String actName;
	private Date billDate;
	private String actDetail;
	private String note;
	private String time;

	public TreatmentTrainingPlan(){
		super();
	}
	public TreatmentTrainingPlan(int planID, String trainingID, String actNO, String actName, Date billDate, String actDetail, String note, String time ){
		super();
		this.planID=planID;
		this.trainingID=trainingID;
		this.actNO=actNO;
		this.actName=actName;
		this.billDate=billDate;
		this.actDetail=actDetail;
		this.note=note;
		this.time=time;
	}
	public void setPlanID(int planID){
		this.planID=planID;
	}
	public int getPlanID(){
		return planID;
	}
	public void setTrainingID(String trainingID){
		this.trainingID=trainingID;
	}
	public String getTrainingID(){
		return trainingID;
	}
	public void setActNO(String actNO){
		this.actNO=actNO;
	}
	public String getActNO(){
		return actNO;
	}
	public void setActName(String actName){
		this.actName=actName;
	}
	public String getActName(){
		return actName;
	}
	public void setBillDate(Date billDate){
		this.billDate=billDate;
	}
	public Date getBillDate(){
		return billDate;
	}
	public void setActDetail(String actDetail){
		this.actDetail=actDetail;
	}
	public String getActDetail(){
		return actDetail;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public void setTime(String time){
		this.time=time;
	}
	public String getTime(){
		return time;
	}
	@Override
	public String toString(){
		return "TreatmentTrainingPlan [planID="+planID+",trainingID="+trainingID+",actNO="+actNO+",actName="+actName+",billDate="+billDate+",actDetail="+actDetail+",note="+note+",time="+time+"]";
	}
}

