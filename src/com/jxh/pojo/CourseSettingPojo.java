package com.jxh.pojo;


import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** CourseSetting

courseID,courseNO,courseName,beginDate,endDate,courseDate,place,leader,assistant,pay,qty,note,classHour,classNote
?,?,?,?,?,?,?,?,?,?,?,?,?,?

courseSetting.courseID,courseSetting.courseNO,courseSetting.courseName,courseSetting.beginDate,courseSetting.endDate,courseSetting.courseDate,courseSetting.place,courseSetting.leader,courseSetting.assistant,courseSetting.pay,courseSetting.qty,courseSetting.note,courseSetting.classHour,courseSetting.classNote

courseID=?,courseNO=?,courseName=?,beginDate=?,endDate=?,courseDate=?,place=?,leader=?,assistant=?,pay=?,qty=?,note=?,classHour=?,classNote=?
*/
public class CourseSettingPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int courseID;
	private String courseNO;
	private String courseName;
	private Date beginDate;
	private Date endDate;
	private Date courseDate;
	private String place;
	private String leader;
	private String assistant;
	private BigDecimal pay;
	private int qty;
	private String note;
	private String classHour;
	private String classNote;

	public CourseSettingPojo(){
		super();
	}
	public CourseSettingPojo(int courseID, String courseNO, String courseName, Date beginDate, Date endDate, Date courseDate, String place, String leader, String assistant, BigDecimal pay, int qty, String note, String classHour, String classNote ){
		super();
		this.courseID=courseID;
		this.courseNO=courseNO;
		this.courseName=courseName;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.courseDate=courseDate;
		this.place=place;
		this.leader=leader;
		this.assistant=assistant;
		this.pay=pay;
		this.qty=qty;
		this.note=note;
		this.classHour=classHour;
		this.classNote=classNote;
	}
	public void setCourseID(int courseID){
		this.courseID=courseID;
	}
	public int getCourseID(){
		return courseID;
	}
	public void setCourseNO(String courseNO){
		this.courseNO=courseNO;
	}
	public String getCourseNO(){
		return courseNO;
	}
	public void setCourseName(String courseName){
		this.courseName=courseName;
	}
	public String getCourseName(){
		return courseName;
	}
	public void setBeginDate(Date beginDate){
		this.beginDate=beginDate;
	}
	public Date getBeginDate(){
		return beginDate;
	}
	public void setEndDate(Date endDate){
		this.endDate=endDate;
	}
	public Date getEndDate(){
		return endDate;
	}
	public void setCourseDate(Date courseDate){
		this.courseDate=courseDate;
	}
	public Date getCourseDate(){
		return courseDate;
	}
	public void setPlace(String place){
		this.place=place;
	}
	public String getPlace(){
		return place;
	}
	public void setLeader(String leader){
		this.leader=leader;
	}
	public String getLeader(){
		return leader;
	}
	public void setAssistant(String assistant){
		this.assistant=assistant;
	}
	public String getAssistant(){
		return assistant;
	}
	public void setPay(BigDecimal pay){
		this.pay=pay;
	}
	public BigDecimal getPay(){
		return pay;
	}
	public void setQty(int qty){
		this.qty=qty;
	}
	public int getQty(){
		return qty;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public void setClassHour(String classHour){
		this.classHour=classHour;
	}
	public String getClassHour(){
		return classHour;
	}
	public void setClassNote(String classNote){
		this.classNote=classNote;
	}
	public String getClassNote(){
		return classNote;
	}
	@Override
	public String toString(){
		return "CourseSetting [courseID="+courseID+",courseNO="+courseNO+",courseName="+courseName+",beginDate="+beginDate+",endDate="+endDate+",courseDate="+courseDate+",place="+place+",leader="+leader+",assistant="+assistant+",pay="+pay+",qty="+qty+",note="+note+",classHour="+classHour+",classNote="+classNote+"]";
	}
}

