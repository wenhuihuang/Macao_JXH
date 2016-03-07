package com.jxh.vo;


import java.io.Serializable;

/** DormitoryTrainingRecordDetail
	DETAILID	INT(10)
	MASTERRECORDID	INT(10)
	CONTENT	VARCHAR(32)
	YM	INT(10)

detailID,masterRecordID,content,yM
?,?,?,?

dormitoryTrainingRecordDetail.detailID,dormitoryTrainingRecordDetail.masterRecordID,dormitoryTrainingRecordDetail.content,dormitoryTrainingRecordDetail.yM

detailID=?,masterRecordID=?,content=?,yM=?
*/
public class DormitoryTrainingRecordDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private int detailID;
	private String masterRecordID;
	private String content;
	private int yM;

	public DormitoryTrainingRecordDetail(){
		super();
	}
	public DormitoryTrainingRecordDetail(int detailID, String masterRecordID, String content, int yM ){
		super();
		this.detailID=detailID;
		this.masterRecordID=masterRecordID;
		this.content=content;
		this.yM=yM;
	}
	public void setDetailID(int detailID){
		this.detailID=detailID;
	}
	public int getDetailID(){
		return detailID;
	}
	public void setMasterRecordID(String masterRecordID){
		this.masterRecordID=masterRecordID;
	}
	public String getMasterRecordID(){
		return masterRecordID;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setYM(int yM){
		this.yM=yM;
	}
	public int getYM(){
		return yM;
	}
	@Override
	public String toString(){
		return "DormitoryTrainingRecordDetail [detailID="+detailID+",masterRecordID="+masterRecordID+",content="+content+",yM="+yM+"]";
	}
}

