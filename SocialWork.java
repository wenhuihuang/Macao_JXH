
import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** SocialWork
	WORKID	VARCHAR(20)
	WORKNAME	VARCHAR(32)
	SEX	INT(10)
	AGE	INT(10)
	PHONE	VARCHAR(32)
	BIRTHDAY	DATETIME(23,3)
	WORK	VARCHAR(128)
	WORKNO	VARCHAR(20)
	CUSTNO	VARCHAR(20)
	CUSTNEWNO	VARCHAR(20)

workID,workName,sex,age,phone,birthday,work,workNO,custNO,custNewNO
?,?,?,?,?,?,?,?,?,?

socialWork.workID,socialWork.workName,socialWork.sex,socialWork.age,socialWork.phone,socialWork.birthday,socialWork.work,socialWork.workNO,socialWork.custNO,socialWork.custNewNO

workID=?,workName=?,sex=?,age=?,phone=?,birthday=?,work=?,workNO=?,custNO=?,custNewNO=?
*/
public class SocialWork implements Serializable {
	private static final long serialVersionUID = 1L;
	private String workID;
	private String workName;
	private int sex;
	private int age;
	private String phone;
	private Date birthday;
	private String work;
	private String workNO;
	private String custNO;
	private String custNewNO;

	public SocialWork(){
		super();
	}
	public SocialWork(String workID, String workName, int sex, int age, String phone, Date birthday, String work, String workNO, String custNO, String custNewNO ){
		super();
		this.workID=workID;
		this.workName=workName;
		this.sex=sex;
		this.age=age;
		this.phone=phone;
		this.birthday=birthday;
		this.work=work;
		this.workNO=workNO;
		this.custNO=custNO;
		this.custNewNO=custNewNO;
	}
	public void setWorkID(String workID){
		this.workID=workID;
	}
	public String getWorkID(){
		return workID;
	}
	public void setWorkName(String workName){
		this.workName=workName;
	}
	public String getWorkName(){
		return workName;
	}
	public void setSex(int sex){
		this.sex=sex;
	}
	public int getSex(){
		return sex;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setBirthday(Date birthday){
		this.birthday=birthday;
	}
	public Date getBirthday(){
		return birthday;
	}
	public void setWork(String work){
		this.work=work;
	}
	public String getWork(){
		return work;
	}
	public void setWorkNO(String workNO){
		this.workNO=workNO;
	}
	public String getWorkNO(){
		return workNO;
	}
	public void setCustNO(String custNO){
		this.custNO=custNO;
	}
	public String getCustNO(){
		return custNO;
	}
	public void setCustNewNO(String custNewNO){
		this.custNewNO=custNewNO;
	}
	public String getCustNewNO(){
		return custNewNO;
	}
	@Override
	public String toString(){
		return "SocialWork [workID="+workID+",workName="+workName+",sex="+sex+",age="+age+",phone="+phone+",birthday="+birthday+",work="+work+",workNO="+workNO+",custNO="+custNO+",custNewNO="+custNewNO+"]";
	}
}

