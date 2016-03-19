package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.SocialWorkDao;
import com.jxh.utils.Constants;
import com.jxh.vo.SocialWork;

public class SocialWorkBiz {

	private SocialWorkDao socialWorkDao = new SocialWorkDao();
	public String updateSocialWork(SocialWork socialWork) throws Exception {
		int row = socialWorkDao.updateSocialWork(socialWork);
		return "操作成功！";
	}


	public String insertSocialWork(SocialWork socialWork) throws Exception {

		String workID = socialWorkDao.getPrimaryKey(Constants.CORPID);
		socialWork.setWorkID(workID);
		int row = socialWorkDao.insertSocialWork(socialWork);
		return "操作成功！";
		
	}


	public boolean deleteSocialWorkByWorkID(String workID) throws Exception {
		boolean flag=false;
		int row = socialWorkDao.deleteSocialWorkByWorkID(workID);
		return flag;
	}


}
