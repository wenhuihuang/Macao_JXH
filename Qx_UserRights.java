
import java.io.Serializable;

/** qx_UserRights
	USERRIGHTSID	INT(10)
	USERID	VARCHAR(16)
	FUNCID	VARCHAR(32)
	FVIEW	CHAR(1)
	FADD	CHAR(1)
	FMODIFY	CHAR(1)
	FDELETE	CHAR(1)
	FVIEWPRICE	CHAR(1)
	FPRINT	CHAR(1)
	FDESIGNREPORT	CHAR(1)
	FEXPORTDATA	CHAR(1)
	FCHECK	CHAR(1)
	FUNCHECK	CHAR(1)
	FDISUSE	CHAR(1)
	FUNDISUSE	CHAR(1)
	FEXECUTE	CHAR(1)
	ALLCORPRIGHT	CHAR(1)

userRightsID,userID,funcID,fView,fAdd,fModify,fDelete,fViewPrice,fPrint,fDesignReport,fExportData,fCheck,fUnCheck,fDisuse,fUnDisuse,fExecute,allCorpRight
?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?

qx_UserRights.userRightsID,qx_UserRights.userID,qx_UserRights.funcID,qx_UserRights.fView,qx_UserRights.fAdd,qx_UserRights.fModify,qx_UserRights.fDelete,qx_UserRights.fViewPrice,qx_UserRights.fPrint,qx_UserRights.fDesignReport,qx_UserRights.fExportData,qx_UserRights.fCheck,qx_UserRights.fUnCheck,qx_UserRights.fDisuse,qx_UserRights.fUnDisuse,qx_UserRights.fExecute,qx_UserRights.allCorpRight

userRightsID=?,userID=?,funcID=?,fView=?,fAdd=?,fModify=?,fDelete=?,fViewPrice=?,fPrint=?,fDesignReport=?,fExportData=?,fCheck=?,fUnCheck=?,fDisuse=?,fUnDisuse=?,fExecute=?,allCorpRight=?
*/
public class Qx_UserRights implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userRightsID;
	private String userID;
	private String funcID;
	private String fView;
	private String fAdd;
	private String fModify;
	private String fDelete;
	private String fViewPrice;
	private String fPrint;
	private String fDesignReport;
	private String fExportData;
	private String fCheck;
	private String fUnCheck;
	private String fDisuse;
	private String fUnDisuse;
	private String fExecute;
	private String allCorpRight;

	public Qx_UserRights(){
		super();
	}
	public Qx_UserRights(int userRightsID, String userID, String funcID, String fView, String fAdd, String fModify, String fDelete, String fViewPrice, String fPrint, String fDesignReport, String fExportData, String fCheck, String fUnCheck, String fDisuse, String fUnDisuse, String fExecute, String allCorpRight ){
		super();
		this.userRightsID=userRightsID;
		this.userID=userID;
		this.funcID=funcID;
		this.fView=fView;
		this.fAdd=fAdd;
		this.fModify=fModify;
		this.fDelete=fDelete;
		this.fViewPrice=fViewPrice;
		this.fPrint=fPrint;
		this.fDesignReport=fDesignReport;
		this.fExportData=fExportData;
		this.fCheck=fCheck;
		this.fUnCheck=fUnCheck;
		this.fDisuse=fDisuse;
		this.fUnDisuse=fUnDisuse;
		this.fExecute=fExecute;
		this.allCorpRight=allCorpRight;
	}
	public void setUserRightsID(int userRightsID){
		this.userRightsID=userRightsID;
	}
	public int getUserRightsID(){
		return userRightsID;
	}
	public void setUserID(String userID){
		this.userID=userID;
	}
	public String getUserID(){
		return userID;
	}
	public void setFuncID(String funcID){
		this.funcID=funcID;
	}
	public String getFuncID(){
		return funcID;
	}
	public void setFView(String fView){
		this.fView=fView;
	}
	public String getFView(){
		return fView;
	}
	public void setFAdd(String fAdd){
		this.fAdd=fAdd;
	}
	public String getFAdd(){
		return fAdd;
	}
	public void setFModify(String fModify){
		this.fModify=fModify;
	}
	public String getFModify(){
		return fModify;
	}
	public void setFDelete(String fDelete){
		this.fDelete=fDelete;
	}
	public String getFDelete(){
		return fDelete;
	}
	public void setFViewPrice(String fViewPrice){
		this.fViewPrice=fViewPrice;
	}
	public String getFViewPrice(){
		return fViewPrice;
	}
	public void setFPrint(String fPrint){
		this.fPrint=fPrint;
	}
	public String getFPrint(){
		return fPrint;
	}
	public void setFDesignReport(String fDesignReport){
		this.fDesignReport=fDesignReport;
	}
	public String getFDesignReport(){
		return fDesignReport;
	}
	public void setFExportData(String fExportData){
		this.fExportData=fExportData;
	}
	public String getFExportData(){
		return fExportData;
	}
	public void setFCheck(String fCheck){
		this.fCheck=fCheck;
	}
	public String getFCheck(){
		return fCheck;
	}
	public void setFUnCheck(String fUnCheck){
		this.fUnCheck=fUnCheck;
	}
	public String getFUnCheck(){
		return fUnCheck;
	}
	public void setFDisuse(String fDisuse){
		this.fDisuse=fDisuse;
	}
	public String getFDisuse(){
		return fDisuse;
	}
	public void setFUnDisuse(String fUnDisuse){
		this.fUnDisuse=fUnDisuse;
	}
	public String getFUnDisuse(){
		return fUnDisuse;
	}
	public void setFExecute(String fExecute){
		this.fExecute=fExecute;
	}
	public String getFExecute(){
		return fExecute;
	}
	public void setAllCorpRight(String allCorpRight){
		this.allCorpRight=allCorpRight;
	}
	public String getAllCorpRight(){
		return allCorpRight;
	}
	@Override
	public String toString(){
		return "Qx_UserRights [userRightsID="+userRightsID+",userID="+userID+",funcID="+funcID+",fView="+fView+",fAdd="+fAdd+",fModify="+fModify+",fDelete="+fDelete+",fViewPrice="+fViewPrice+",fPrint="+fPrint+",fDesignReport="+fDesignReport+",fExportData="+fExportData+",fCheck="+fCheck+",fUnCheck="+fUnCheck+",fDisuse="+fDisuse+",fUnDisuse="+fUnDisuse+",fExecute="+fExecute+",allCorpRight="+allCorpRight+"]";
	}
}

