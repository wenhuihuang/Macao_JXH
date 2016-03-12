package com.jxh.vo;


import java.io.Serializable;

/** CourseSettingDetail

detailID,courseID,time,content,place,leader,assistant,note
?,?,?,?,?,?,?,?

courseSettingDetail.detailID,courseSettingDetail.courseID,courseSettingDetail.time,courseSettingDetail.content,courseSettingDetail.place,courseSettingDetail.leader,courseSettingDetail.assistant,courseSettingDetail.note

detailID=?,courseID=?,time=?,content=?,place=?,leader=?,assistant=?,note=?
*/
public class CourseSettingDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private int detailID;
	private String courseID;
	private String time;
	private String content;
	private String place;
	private String leader;
	private String assistant;
	private String note;

	public CourseSettingDetail(){
		super();
	}
	public CourseSettingDetail(int detailID, String courseID, String time, String content, String place, String leader, String assistant, String note ){
		super();
		this.detailID=detailID;
		this.courseID=courseID;
		this.time=time;
		this.content=content;
		this.place=place;
		this.leader=leader;
		this.assistant=assistant;
		this.note=note;
	}
	public void setDetailID(int detailID){
		this.detailID=detailID;
	}
	public int getDetailID(){
		return detailID;
	}
	public void setCourseID(String courseID){
		this.courseID=courseID;
	}
	public String getCourseID(){
		return courseID;
	}
	public void setTime(String time){
		this.time=time;
	}
	public String getTime(){
		return time;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
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
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	@Override
	public String toString(){
		return "CourseSettingDetail [detailID="+detailID+",courseID="+courseID+",time="+time+",content="+content+",place="+place+",leader="+leader+",assistant="+assistant+",note="+note+"]";
	}
}

