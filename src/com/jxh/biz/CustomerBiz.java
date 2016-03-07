package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.jxh.dao.CSSADao;
import com.jxh.dao.CustomerDao;
import com.jxh.dao.RetardedDao;
import com.jxh.dao.SpecialAllowanceDao;
import com.jxh.utils.Constants;
import com.jxh.vo.BCustomer;
import com.jxh.vo.CSSA;
import com.jxh.vo.Retarded;
import com.jxh.vo.SpecialAllowance;

public class CustomerBiz {
	private CustomerDao customerDao = new CustomerDao();
	private RetardedDao retardedDao = new RetardedDao();
	private CSSADao cssaDao = new CSSADao();
	private SpecialAllowanceDao specialAllowanceDao = new SpecialAllowanceDao();
	

	/**
	 * 更新会员信息
	 * @param cust
	 * @param retardedAdds
	 * @param retardedUpdates
	 * @param retardedDeletes
	 * @param familyAdds
	 * @param familyUpdates
	 * @param familyDeletes
	 * @param cSSADeletes 
	 * @param cSSAUpdates 
	 * @param cSSAAdds 
	 * @param specialAllowanceDeletes 
	 * @param specialAllowanceUpdates 
	 * @param specialAllowanceAdds 
	 * @return
	 * @throws Exception
	 */
	public String updateCustomer(BCustomer cust, List<Retarded> retardedAdds,List<Retarded> retardedUpdates,List<Retarded> retardedDeletes, List<BCustomer> familyAdds, List<BCustomer> familyUpdates, List<BCustomer> familyDeletes, List<CSSA> cSSAAdds, List<CSSA> cSSAUpdates, List<CSSA> cSSADeletes, List<SpecialAllowance> specialAllowanceAdds, List<SpecialAllowance> specialAllowanceUpdates, List<SpecialAllowance> specialAllowanceDeletes) throws Exception {

		int row = customerDao.updateCustomer(cust);
		if (row > 0) {
			//新增智障登记资料
			if (addRetarded(cust, retardedAdds) < 0) {
				throw new Exception("智障登記保存失敗！");
			}
			//修改智障登记资料
			if(updateRetarded(cust, retardedUpdates) < 0){
				throw new Exception("智障登記更新失敗！");
			}
			//删除智障登记资料
			if(deleteRetarded(cust, retardedDeletes) < 0){
				throw new Exception("智障登記刪除失敗！");
			}
			
			//新增家庭成員
			if(addFamily(cust,familyAdds)<0){
				throw new Exception("新增家庭成員資料失败！");
			}
			
			//编辑家庭成员资料失败
			if(updateFamily(cust,familyUpdates)<0){
				throw new Exception("編輯家庭成員資料失败！");
			}
			
			//編輯家庭成員資料失败
			if(deleteFamily(cust,familyDeletes)<0){
				throw new Exception("刪除家庭成員資料失败！");
			}
			
			
			//CSSA相关
			if(addCSSA(cust,cSSAAdds)<0){
				throw new Exception("新增綜援記錄失败！");
			}
			
			if(updateCSSA(cust,cSSAUpdates)<0){
				throw new Exception("編輯綜援記錄失败！");
			}
			if(deleteCSSA(cust,cSSADeletes)<0){
				throw new Exception("刪除綜援記錄失败！");
			}
			
			
			
			//津貼記錄相關
			if(addSpecialAllowance(cust,specialAllowanceAdds)<0){
				throw new Exception("新增特津記錄記錄失败！");
			}
			
			if(updateSpecialAllowance(cust,specialAllowanceUpdates)<0){
				throw new Exception("編輯特津記錄記錄失败！");
			}
			
			if(deleteSpecialAllowance(cust,specialAllowanceDeletes)<0){
				throw new Exception("刪除特津記錄記錄失败！");
			}
			
			
			
			
		}
		return "操作成功！";
	}


	


	/**
	 * 删除特津记录
	 * @param cust
	 * @param specialAllowanceDeletes
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	private int deleteSpecialAllowance(BCustomer cust, List<SpecialAllowance> specialAllowanceDeletes) throws IOException, SQLException {
		// TODO Auto-generated method stub
		if (specialAllowanceDeletes == null || specialAllowanceDeletes.size() <= 0) {
			return 1;
		}
		return specialAllowanceDao.deleteSpecialAllowance(specialAllowanceDeletes);
	}





	/**
	 * 更新
	 * @param cust
	 * @param specialAllowanceUpdates
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	private int updateSpecialAllowance(BCustomer cust, List<SpecialAllowance> specialAllowanceUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		// TODO Auto-generated method stub
		if (specialAllowanceUpdates == null || specialAllowanceUpdates.size() <= 0) {
			return 1;
		}
		return specialAllowanceDao.updateSpecialAllowance(specialAllowanceUpdates);
	}






	private int deleteCSSA(BCustomer cust, List<CSSA> cSSADeletes) throws IOException, SQLException {
		// TODO Auto-generated method stub
		if (cSSADeletes == null || cSSADeletes.size() <= 0) {
			return 1;
		}
		return cssaDao.deleteCSSA(cSSADeletes);
	}






	private int updateCSSA(BCustomer cust, List<CSSA> cSSAUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		// TODO Auto-generated method stub
		if (cSSAUpdates == null || cSSAUpdates.size() <= 0) {
			return 1;
		}
		return cssaDao.updateCSSA(cSSAUpdates);
		
	}






	/**
	 * 新增会员信息
	 * @param cust
	 * @param retardedAdds
	 * @param familyAdds
	 * @param cSSAAdds 
	 * @param specialAllowanceAdds 
	 * @return
	 * @throws Exception
	 */
	public String insertCustomer(BCustomer cust, List<Retarded> retardedAdds, List<BCustomer> familyAdds, List<CSSA> cSSAAdds, List<SpecialAllowance> specialAllowanceAdds) throws Exception {
		String custId = customerDao.getPrimaryKey(Constants.CORPID);
		cust.setCustId(custId);
		int row = customerDao.insertCustomer(cust);
		if (row > 0) {
			if (addRetarded(cust, retardedAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			
			if(addFamily(cust,familyAdds)<0){
				throw new Exception("新增家庭成員資料失败！");
			}
			
			if(addCSSA(cust,cSSAAdds)<0){
				throw new Exception("新增綜援記錄失败！");
			}
			
			if(addSpecialAllowance(cust,specialAllowanceAdds)<0){
				throw new Exception("新增特津記錄記錄失败！");
			}
			
		}
		return "操作成功！";
	}

	
	
	
	/*
	 * ==================================================================================================================================
	 * ==================================================================================================================================
	 * ==================================================================================================================================
	 * ==================================================================================================================================
	 */
	
	
	
	/**
	 * 新增特津记录
	 * @param cust
	 * @param specialAllowanceAdds
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 * @throws IOException
	 * @throws SQLException
	 */
	private int addSpecialAllowance(BCustomer cust, List<SpecialAllowance> specialAllowanceAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		// TODO Auto-generated method stub
		if (specialAllowanceAdds == null || specialAllowanceAdds.size() <= 0) {
			return 1;
		}

		for (SpecialAllowance add : specialAllowanceAdds) {
			add.setSpecialAllowanceCustID(cust.getCustId());
		}

		return specialAllowanceDao.insertSpecialAllowance(specialAllowanceAdds);
		
	}






	/**
	 * 新增CSSA
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	private int addCSSA(BCustomer cust, List<CSSA> cSSAAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		// TODO Auto-generated method stub
		if (cSSAAdds == null || cSSAAdds.size() <= 0) {
			return 1;
		}

		for (CSSA add : cSSAAdds) {
			add.setCSSACustID(cust.getCustId());
		}

		int[] rows = cssaDao.insertCSSA(cSSAAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}






	/**
	 * 新增家庭成員
	 * @param cust
	 * @param familyAdds
	 * @return
	 * @throws SQLException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws ParseException
	 */
	private int addFamily(BCustomer cust, List<BCustomer> familyAdds) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException, ParseException {
		// TODO Auto-generated method stub
		if (familyAdds == null || familyAdds.size() <= 0) {
			return 1;
		}

		for (BCustomer add : familyAdds) {
			String custId = customerDao.getPrimaryKey(Constants.CORPID);
			add.setCustCode(cust.getCustCode());
			add.setCustId(custId);
			add.setCustType2("2");
			add.setGuardianCustID(cust.getCustId());
		}

		int[] rows = customerDao.insertCustomerBatch(familyAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	/**
	 * 更新家庭成员资料
	 * @param cust
	 * @param familyUpdates
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ParseException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	private int updateFamily(BCustomer cust, List<BCustomer> familyUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, SQLException, IOException {
		// TODO Auto-generated method stub
		if (familyUpdates == null || familyUpdates.size() <= 0) {
			return 1;
		}
		
		for (BCustomer update : familyUpdates) {
			
			update.setCustCode(cust.getCustCode());
			update.setCustType2("2");
			update.setGuardianCustID(cust.getCustId());
		}
		
		int [] rows =customerDao.updateCustomerBatch(familyUpdates);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}
	
	

	/**
	 * 删除家庭成员
	 * @param cust
	 * @param familyDeletes
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	private int deleteFamily(BCustomer cust, List<BCustomer> familyDeletes) throws IOException, SQLException {
		// TODO Auto-generated method stub
		if (familyDeletes == null || familyDeletes.size() <= 0) {
			return 1;
		}

		int[] rows = customerDao.deleteCustomerBatch(familyDeletes);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}

	
	
	

	/**
	 * 批量增加智障记录
	 * 
	 * @param cust
	 * @param adds
	 * @return
	 * @throws SQLException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws ParseException 
	 */
	public int addRetarded(BCustomer cust, List<Retarded> adds) throws SQLException, NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException, IOException, ParseException {

		if (adds == null || adds.size() <= 0) {
			return 1;
		}

		for (Retarded add : adds) {
			String retardedId = retardedDao.getPrimaryKey("RETARDED", Constants.CORPID, 20);
			add.setRetardedID(retardedId);
			add.setCustId(cust.getCustId());
		}

		int[] rows = retardedDao.insertRetarded(adds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}
	
	
	/**
	 * 修改智障登记资料
	 * @param cust
	 * @param retardedUpdates
	 * @return
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws ParseException 
	 */
	private int updateRetarded(BCustomer cust, List<Retarded> retardedUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException, SQLException, ParseException {
		
		if (retardedUpdates == null || retardedUpdates.size() <= 0) {
			return 1;
		}
		
		
		int [] rows =retardedDao.updateRetarded(retardedUpdates);
		
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}
	

	/**
	 * 删除智障登记资料
	 * @param cust
	 * @param retardedUpdates
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	private int deleteRetarded(BCustomer cust, List<Retarded> retardedDeletes) throws SQLException, IOException {
		
		if (retardedDeletes == null || retardedDeletes.size() <= 0) {
			return 1;
		}

		
		int[] rows = retardedDao.deleteRetardedById(retardedDeletes);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}
		return 1;
	}
}
