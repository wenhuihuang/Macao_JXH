package com.jxh.vo;


import java.io.Serializable;

/** GroupDetail
	DETAILID	INT(10)
	CUSTID	VARCHAR(20)
	GSID	VARCHAR(20)
	NOTE	VARCHAR(128)

detailID,custID,gSID,note
?,?,?,?

groupDetail.detailID,groupDetail.custID,groupDetail.gSID,groupDetail.note

detailID=?,custID=?,gSID=?,note=?
*/
public class GroupDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private int detailID;
	private String custID;
	private String gSID;
	private String note;

	public GroupDetail(){
		super();
	}
	public GroupDetail(int detailID, String custID, String gSID, String note ){
		super();
		this.detailID=detailID;
		this.custID=custID;
		this.gSID=gSID;
		this.note=note;
	}
	public void setDetailID(int detailID){
		this.detailID=detailID;
	}
	public int getDetailID(){
		return detailID;
	}
	public void setCustID(String custID){
		this.custID=custID;
	}
	public String getCustID(){
		return custID;
	}
	public void setNote(String note){
		this.note=note;
	}
	public String getNote(){
		return note;
	}
	public String getgSID() {
		return gSID;
	}
	public void setgSID(String gSID) {
		this.gSID = gSID;
	}
	@Override
	public String toString(){
		return "GroupDetail [detailID="+detailID+",custID="+custID+",gSID="+gSID+",note="+note+"]";
	}
}

