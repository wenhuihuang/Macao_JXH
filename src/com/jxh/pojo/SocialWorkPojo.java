package com.jxh.pojo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.fg.utils.ToolsUtils;

import java.math.*;
import java.text.ParseException;

public class SocialWorkPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String workID;
	private String work;
	private String workNO;
	private String note;
	private String custID;
	
	private String fullName;
	private int sex;
	private String age;
	private String mobileTelNO;
	private Date birthday_Chn;
	private String job;

	private String birthday_ChnStr;

	private String custType;
	private String custCode;
	
	private String custNO;
	private String custNewNO;

	public SocialWorkPojo() {
		super();
	}

	public SocialWorkPojo(String workID, String fullName, int sex, String age, String mobileTelNO, Date birthday_Chn, String work,
			String workNO, String note, String birthday_ChnStr, String custID, String custType, String custCode,
			String job,String custNO,String custNewNO) {
		super();
		this.workID = workID;
		this.fullName = fullName;
		this.sex = sex;
		this.age = age;
		this.mobileTelNO = mobileTelNO;
		this.birthday_Chn = birthday_Chn;
		this.work = work;
		this.workNO = workNO;
		this.note = note;
		this.birthday_ChnStr = birthday_ChnStr;
		this.custID = custID;
		this.custType = custType;
		this.custCode = custCode;
		this.job = job;
		this.custNO=custNO;
		this.custNewNO=custNewNO;
	}

	public void setWorkID(String workID) {
		this.workID = workID;
	}

	public String getWorkID() {
		return workID;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSex() {
		return sex;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
	public  String getAge(Date birthday_Chn) throws Exception { 
        Calendar cal = Calendar.getInstance(); 

        if (cal.before(birthday_Chn)) { 
            throw new IllegalArgumentException( 
                "The birthday_Chn is before Now.It's unbelievable!"); 
        } 

        int yearNow = cal.get(Calendar.YEAR); 
        int monthNow = cal.get(Calendar.MONTH)+1; 
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); 
        
        cal.setTime(birthday_Chn); 
        int yearBirth = cal.get(Calendar.YEAR); 
        int monthBirth = cal.get(Calendar.MONTH); 
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH); 

        int age = yearNow - yearBirth; 

        if (monthNow <= monthBirth) { 
            if (monthNow == monthBirth) { 
                //monthNow==monthBirth 
                if (dayOfMonthNow < dayOfMonthBirth) { 
                    age--; 
                } 
            } else { 
                //monthNow>monthBirth 
                age--; 
            } 
        } 
        System.out.println("age="+age);
        return age +""; 
    }

	public void setMobileTelNO(String mobileTelNO) {
		this.mobileTelNO = mobileTelNO;
	}

	public String getMobileTelNO() {
		return mobileTelNO;
	}

	public void setBirthday_Chn(Date birthday_Chn) {
		this.birthday_Chn = birthday_Chn;
	}

	public Date getBirthday_Chn() {
		return birthday_Chn;
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

	public String getBirthday_ChnStr() {
		try {
			return birthday_Chn == null || "".equals(birthday_Chn) ? ""
					: ToolsUtils.getDateStringByFormat(birthday_Chn, null, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setBirthday_ChnStr(String birthday_ChnStr) {
		this.birthday_ChnStr = birthday_ChnStr;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	public String getCustNO() {
		if ("0".equals(custType)) {
			custNO = "";
		} else if ("1".equals(custType) || "2".equals(custType)) {
			custNO = custCode;
		}
		return custNO;
	}

	public void setCustNO(String custNO) {
		if ("1".equals(custType) || "2".equals(custType)) {
			this.custCode = custNO;
		}
		this.custNO = custNO;
	}

	public String getCustNewNO() {
		if ("0".equals(custType)) {
			custNewNO = custCode;
		} else if ("1".equals(custType) || "2".equals(custType)) {
			custNewNO = "";
		}
		return custNewNO;
	}

	public void setCustNewNO(String custNewNO) {
		if ("0".equals(custType)) {
			this.custCode = custNewNO;
		}
		this.custNewNO = custNewNO;
	}

	@Override
	public String toString() {
		return "SocialWork [workID=" + workID + ",fullName=" + fullName + ",sex=" + sex + ",age=" + age + ",mobileTelNO="
				+ mobileTelNO + ",birthday_Chn=" + birthday_Chn + ",work=" + work + ",workNO=" + workNO + ",note=" + note
				+ ",birthday_ChnStr=" + birthday_ChnStr + ",custID=" + custID + ",custType=" + custType + ",custCode="
				+ custCode + ",job=" + job + ",custNO="+custNO+",custNewNO="+custNewNO+"]";
	}

}
