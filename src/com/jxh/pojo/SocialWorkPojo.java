package com.jxh.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.math.*;
import java.text.ParseException;

public class SocialWorkPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String workID;
	private String workName;
	private int sex;
	private int age;
	private String phone;
	private Date birthday;
	private String work;
	private String workNO;
	private String note;

	private String custID;
	private String job;

	private String birthday_str;

	private String custNO;
	private String custNewNO;

	public SocialWorkPojo() {
		super();
	}

	public SocialWorkPojo(String workID, String workName, int sex, int age, String phone, Date birthday, String work,
			String workNO, String note, String birthday_str, String custID, String custNO, String custNewNO,
			String job) {
		super();
		this.workID = workID;
		this.workName = workName;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.birthday = birthday;
		this.work = work;
		this.workNO = workNO;
		this.note = note;
		this.birthday_str = birthday_str;
		this.custID = custID;
		this.custNO = custNO;
		this.custNewNO = custNewNO;
		this.job = job;
	}

	public void setWorkID(String workID) {
		this.workID = workID;
	}

	public String getWorkID() {
		return workID;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getWorkName() {
		return workName;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSex() {
		return sex;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getWork() {
		return work;
	}

	public void setWorkNO(String workNO) {
		this.workNO = workNO;
	}

	public String getWorkNO() {
		return workNO;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getBirthday_str() {
		try {
			return birthday == null || "".equals(birthday) ? ""
					: ToolsUtils.getDateStringByFormat(birthday, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setBirthday_str(String birthday_str) {
		this.birthday_str = birthday_str;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getCustNO() {
		return custNO;
	}

	public void setCustNO(String custNO) {
		this.custNO = custNO;
	}

	public String getCustNewNO() {
		return custNewNO;
	}

	public void setCustNewNO(String custNewNO) {
		this.custNewNO = custNewNO;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "SocialWork [workID=" + workID + ",workName=" + workName + ",sex=" + sex + ",age=" + age + ",phone="
				+ phone + ",birthday=" + birthday + ",work=" + work + ",workNO=" + workNO + ",note=" + note
				+ ",birthday_str=" + birthday_str + ",custID=" + custID + ",custNO=" + custNO + ",custNewNO="
				+ custNewNO + ",job=" + job + "]";
	}

}
