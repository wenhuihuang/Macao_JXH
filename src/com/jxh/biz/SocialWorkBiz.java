package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.CustomerDao;
import com.jxh.dao.SocialWorkDao;
import com.jxh.utils.Constants;
import com.jxh.vo.BCustomer;
import com.jxh.vo.SocialWork;

public class SocialWorkBiz {

	private SocialWorkDao socialWorkDao = new SocialWorkDao();
	private CustomerDao customerDao = new CustomerDao();
	public String updateSocialWork(SocialWork socialWork, BCustomer bCustomer) throws Exception {
		int row = socialWorkDao.updateSocialWork(socialWork);
		if(row > 0){
			int r = customerDao.updateCustomer(bCustomer);
			if(r < 0){
			}
		}
		
		return "操作成功！";
	}


	public String insertSocialWork(SocialWork socialWork,BCustomer bCustomer) throws Exception {

		String workID = socialWorkDao.getPrimaryKey(Constants.CORPID);
		String custID = customerDao.getPrimaryKey(Constants.CORPID);
		socialWork.setWorkID(workID);
		socialWork.setCustID(custID);
		bCustomer.setCustID(custID);
		bCustomer.setIsSociaWork("1");
		bCustomer.setCustType2("3");
		int row = socialWorkDao.insertSocialWork(socialWork);
		if(row > 0){
			int r = customerDao.insertCustomer(bCustomer);
		}
		return "操作成功！";
		
	}


	public boolean deleteSocialWorkByWorkID(String workID,String custID) throws Exception {
		boolean flag=false;
		int row = socialWorkDao.deleteSocialWorkByWorkID(workID);
		if(row > 0){
			int r = customerDao.deleteCustomer(custID);
		}
		return flag;
	}


}
