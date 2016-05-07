
import java.io.Serializable;
import java.math.*;


/** bTypeCode
	TYPECODE	VARCHAR(30)
	TYPENAME	VARCHAR(20)
	LEVELS	INT(10)
	TYPEPARENTCODE	VARCHAR(30)
	TYPEBASE	VARCHAR(2)
	TYPE2	VARCHAR(2)
	UPDATETIME	VARCHAR(22)
	TYPENAME_ENG	VARCHAR(60)
	COOKTYPE	VARCHAR(20)
	COST	DECIMAL(18,2)
	CYCLE	INT(10)

typeCode,typeName,levels,typeParentCode,typeBase,type2,updateTime,typeNameEng,cookType,cost,cycle
?,?,?,?,?,?,?,?,?,?,?

bTypeCode.typeCode,bTypeCode.typeName,bTypeCode.levels,bTypeCode.typeParentCode,bTypeCode.typeBase,bTypeCode.type2,bTypeCode.updateTime,bTypeCode.typeNameEng,bTypeCode.cookType,bTypeCode.cost,bTypeCode.cycle

typeCode=?,typeName=?,levels=?,typeParentCode=?,typeBase=?,type2=?,updateTime=?,typeNameEng=?,cookType=?,cost=?,cycle=?
*/
public class BTypeCode implements Serializable {
	private static final long serialVersionUID = 1L;
	private String typeCode;
	private String typeName;
	private int levels;
	private String typeParentCode;
	private String typeBase;
	private String type2;
	private String updateTime;
	private String typeNameEng;
	private String cookType;
	private BigDecimal cost;
	private int cycle;

	public BTypeCode(){
		super();
	}
	public BTypeCode(String typeCode, String typeName, int levels, String typeParentCode, String typeBase, String type2, String updateTime, String typeNameEng, String cookType, BigDecimal cost, int cycle ){
		super();
		this.typeCode=typeCode;
		this.typeName=typeName;
		this.levels=levels;
		this.typeParentCode=typeParentCode;
		this.typeBase=typeBase;
		this.type2=type2;
		this.updateTime=updateTime;
		this.typeNameEng=typeNameEng;
		this.cookType=cookType;
		this.cost=cost;
		this.cycle=cycle;
	}
	public void setTypeCode(String typeCode){
		this.typeCode=typeCode;
	}
	public String getTypeCode(){
		return typeCode;
	}
	public void setTypeName(String typeName){
		this.typeName=typeName;
	}
	public String getTypeName(){
		return typeName;
	}
	public void setLevels(int levels){
		this.levels=levels;
	}
	public int getLevels(){
		return levels;
	}
	public void setTypeParentCode(String typeParentCode){
		this.typeParentCode=typeParentCode;
	}
	public String getTypeParentCode(){
		return typeParentCode;
	}
	public void setTypeBase(String typeBase){
		this.typeBase=typeBase;
	}
	public String getTypeBase(){
		return typeBase;
	}
	public void setType2(String type2){
		this.type2=type2;
	}
	public String getType2(){
		return type2;
	}
	public void setUpdateTime(String updateTime){
		this.updateTime=updateTime;
	}
	public String getUpdateTime(){
		return updateTime;
	}
	public void setTypeNameEng(String typeNameEng){
		this.typeNameEng=typeNameEng;
	}
	public String getTypeNameEng(){
		return typeNameEng;
	}
	public void setCookType(String cookType){
		this.cookType=cookType;
	}
	public String getCookType(){
		return cookType;
	}
	public void setCost(BigDecimal cost){
		this.cost=cost;
	}
	public BigDecimal getCost(){
		return cost;
	}
	public void setCycle(int cycle){
		this.cycle=cycle;
	}
	public int getCycle(){
		return cycle;
	}
	@Override
	public String toString(){
		return "BTypeCode [typeCode="+typeCode+",typeName="+typeName+",levels="+levels+",typeParentCode="+typeParentCode+",typeBase="+typeBase+",type2="+type2+",updateTime="+updateTime+",typeNameEng="+typeNameEng+",cookType="+cookType+",cost="+cost+",cycle="+cycle+"]";
	}
}

