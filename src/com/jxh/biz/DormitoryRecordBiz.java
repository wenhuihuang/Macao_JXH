package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.jxh.dao.DormitoryRecordDao;
import com.jxh.dao.DormitoryTrainingADPlanDao;
import com.jxh.dao.DormitoryTrainingADPlanDetailDao;
import com.jxh.dao.DormitoryTrainingPlanDao;
import com.jxh.dao.DormitoryTrainingRecordDao;
import com.jxh.dao.DormitoryTrainingRecordDetailDao;
import com.jxh.dao.DormitoryTrainingReviewDao;
import com.jxh.dao.DormitoryTrainingReviewDetailDao;
import com.jxh.dao.DormitoryTrainingReviewFinanceDao;
import com.jxh.dao.DormitoryTrainingReviewSettleDao;
import com.jxh.dao.DormitoryTrainingReviewTargetDao;
import com.jxh.utils.Constants;
import com.jxh.vo.BCustCase;
import com.jxh.vo.BCustCaseSummary;
import com.jxh.vo.BCustCaseSummaryHandle;
import com.jxh.vo.CSSA;
import com.jxh.vo.DormitoryRecord;
import com.jxh.vo.DormitoryTrainingADPlan;
import com.jxh.vo.DormitoryTrainingADPlanDetail;
import com.jxh.vo.DormitoryTrainingPlan;
import com.jxh.vo.DormitoryTrainingRecord;
import com.jxh.vo.DormitoryTrainingRecordDetail;
import com.jxh.vo.DormitoryTrainingReview;
import com.jxh.vo.DormitoryTrainingReviewDetail;
import com.jxh.vo.DormitoryTrainingReviewFinance;
import com.jxh.vo.DormitoryTrainingReviewSettle;
import com.jxh.vo.DormitoryTrainingReviewTarget;


public class DormitoryRecordBiz {
	private DormitoryRecordDao dormitoryRecordDao = new DormitoryRecordDao();
	private DormitoryTrainingPlanDao dormitoryTrainingPlanDao = new DormitoryTrainingPlanDao();
	private DormitoryTrainingADPlanDao dormitoryTrainingADPlanDao = new DormitoryTrainingADPlanDao();
	private DormitoryTrainingRecordDao dormitoryTrainingRecordDao = new DormitoryTrainingRecordDao();
	private DormitoryTrainingReviewDao dormitoryTrainingReviewDao = new DormitoryTrainingReviewDao();
	private DormitoryTrainingADPlanDetailDao dormitoryTrainingADPlanDetailDao = new DormitoryTrainingADPlanDetailDao();
	private DormitoryTrainingRecordDetailDao dormitoryTrainingRecordDetailDao = new DormitoryTrainingRecordDetailDao();
	private DormitoryTrainingReviewTargetDao dormitoryTrainingReviewTargetDao = new DormitoryTrainingReviewTargetDao();
	private DormitoryTrainingReviewFinanceDao dormitoryTrainingReviewFinanceDao = new DormitoryTrainingReviewFinanceDao();
	private DormitoryTrainingReviewSettleDao dormitoryTrainingReviewSettleDao = new DormitoryTrainingReviewSettleDao();
	private DormitoryTrainingReviewDetailDao dormitoryTrainingReviewDetailDao = new DormitoryTrainingReviewDetailDao();

	public String insertDormitoryRecord(DormitoryRecord dormitoryRecord, DormitoryTrainingPlan dormitoryTrainingPlan,
			DormitoryTrainingADPlan dormitoryTrainingADPlan, DormitoryTrainingRecord dormitoryTrainingRecord,
			DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailAdds,
			List<DormitoryTrainingRecordDetail> dormitoryTrainingRecordDetailAdds,
			List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTargetAdds,
			List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinanceAdds,
			List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettleAdds,
			List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetailAdds) throws Exception {
		
		String recordID = dormitoryRecordDao.getPrimaryKey(Constants.CORPID);
		dormitoryRecord.setRecordID(recordID);
		int row = dormitoryRecordDao.insertDormitoryRecord(dormitoryRecord);
		if (row > 0) {
			if (addDormitoryTrainingPlan(dormitoryRecord, dormitoryTrainingPlan) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			
			if (addDormitoryTrainingADPlan(dormitoryRecord, dormitoryTrainingADPlan,dormitoryTrainingADPlanDetailAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			
			if(addDormitoryTrainingRecord(dormitoryRecord,dormitoryTrainingRecord,dormitoryTrainingRecordDetailAdds)<0){
				throw new Exception("新增家庭成員資料失败！");
			}
			
			if(addDormitoryTrainingReview(dormitoryRecord,dormitoryTrainingReview,dormitoryTrainingReviewTargetAdds,dormitoryTrainingReviewFinanceAdds,dormitoryTrainingReviewSettleAdds,dormitoryTrainingReviewDetailAdds)<0){
				throw new Exception("新增綜援記錄失败！");
			}
			
			
		}
		return "操作成功！";
	}

	
	private int addDormitoryTrainingReview(DormitoryRecord dormitoryRecord,
			DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTargetAdds,
			List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinanceAdds,
			List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettleAdds,
			List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetailAdds) throws Exception {
		if (dormitoryTrainingReview == null || "".equals(dormitoryTrainingReview)) {
			return 1;
		}

		String reviewID = dormitoryTrainingReviewDao.getPrimaryKey(Constants.CORPID);
		dormitoryTrainingReview.setReviewID(reviewID);
		dormitoryTrainingReview.setRecordID(dormitoryRecord.getRecordID());
		int row = dormitoryTrainingReviewDao.insertDormitoryTrainingReview(dormitoryTrainingReview);
		
		if(row>0){
			if(addDormitoryTrainingReviewTarget(dormitoryTrainingReview,dormitoryTrainingReviewTargetAdds)<0){
				throw new Exception("新增特津記錄記錄失败！");
			}

			if(addDormitoryTrainingReviewFinance(dormitoryTrainingReview,dormitoryTrainingReviewFinanceAdds)<0){
				throw new Exception("新增特津記錄記錄失败！");
			}

			if(addDormitoryTrainingReviewSettle(dormitoryTrainingReview,dormitoryTrainingReviewSettleAdds)<0){
				throw new Exception("新增特津記錄記錄失败！");
			}
			
			if(addDormitoryTrainingReviewDetail(dormitoryTrainingReview,dormitoryTrainingReviewDetailAdds)<0){
				throw new Exception("新增特津記錄記錄失败！");
			}
		}
		
		return 1;
	}

	private int addDormitoryTrainingReviewDetail(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetailAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (dormitoryTrainingReviewDetailAdds == null || dormitoryTrainingReviewDetailAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingReviewDetail add : dormitoryTrainingReviewDetailAdds) {
			add.setReviewID(dormitoryTrainingReview.getReviewID());
		}

		int[] rows = dormitoryTrainingReviewDetailDao.insertDormitoryTrainingReviewDetail(dormitoryTrainingReviewDetailAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}
	
	private int addDormitoryTrainingReviewSettle(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettleAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (dormitoryTrainingReviewSettleAdds == null || dormitoryTrainingReviewSettleAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingReviewSettle add : dormitoryTrainingReviewSettleAdds) {
			add.setReviewID(dormitoryTrainingReview.getReviewID());
		}

		int[] rows = dormitoryTrainingReviewSettleDao.insertDormitoryTrainingReviewSettle(dormitoryTrainingReviewSettleAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}


	private int addDormitoryTrainingReviewFinance(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinanceAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (dormitoryTrainingReviewFinanceAdds == null || dormitoryTrainingReviewFinanceAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingReviewFinance add : dormitoryTrainingReviewFinanceAdds) {
			add.setReviewID(dormitoryTrainingReview.getReviewID());
		}

		int[] rows = dormitoryTrainingReviewFinanceDao.insertDormitoryTrainingReviewFinance(dormitoryTrainingReviewFinanceAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}


	private int addDormitoryTrainingReviewTarget(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTargetAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (dormitoryTrainingReviewTargetAdds == null || dormitoryTrainingReviewTargetAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingReviewTarget add : dormitoryTrainingReviewTargetAdds) {
			add.setReviewID(dormitoryTrainingReview.getReviewID());
		}

		int[] rows = dormitoryTrainingReviewTargetDao.insertDormitoryTrainingReviewTarget(dormitoryTrainingReviewTargetAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}


	private int addDormitoryTrainingRecordDetail(DormitoryTrainingRecord dormitoryTrainingRecord,
			List<DormitoryTrainingRecordDetail> dormitoryTrainingRecordDetailAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (dormitoryTrainingRecordDetailAdds == null || dormitoryTrainingRecordDetailAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingRecordDetail add : dormitoryTrainingRecordDetailAdds) {
			add.setMasterRecordID(dormitoryTrainingRecord.gettRecordID());
		}

		int[] rows = dormitoryTrainingRecordDetailDao.insertDormitoryTrainingRecordDetail(dormitoryTrainingRecordDetailAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}


	private int addDormitoryTrainingADPlanDetail(DormitoryTrainingADPlan dormitoryTrainingADPlan,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailAdds) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (dormitoryTrainingADPlanDetailAdds == null || dormitoryTrainingADPlanDetailAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingADPlanDetail add : dormitoryTrainingADPlanDetailAdds) {
			add.setPlanMasterID(dormitoryTrainingADPlan.getaPlanID());
		}

		int[] rows = dormitoryTrainingADPlanDetailDao.insertDormitoryTrainingADPlanDetail(dormitoryTrainingADPlanDetailAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addDormitoryTrainingReview(DormitoryRecord dormitoryRecord,
			DormitoryTrainingReview dormitoryTrainingReview) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (dormitoryTrainingReview == null || "".equals(dormitoryTrainingReview)) {
			return 1;
		}

		dormitoryTrainingReview.setRecordID(dormitoryRecord.getRecordID());
		return  dormitoryTrainingReviewDao.insertDormitoryTrainingReview(dormitoryTrainingReview);
	}

	private int addDormitoryTrainingRecord(DormitoryRecord dormitoryRecord,
			DormitoryTrainingRecord dormitoryTrainingRecord,List<DormitoryTrainingRecordDetail> dormitoryTrainingRecordDetailAdds) throws Exception {
		
		if (dormitoryTrainingRecord == null || "".equals(dormitoryTrainingRecord)) {
			return 1;
		}
		
		String recordID = dormitoryTrainingRecordDao.getPrimaryKey(Constants.CORPID);
		dormitoryTrainingRecord.settRecordID(recordID);
		dormitoryTrainingRecord.setRecordID(dormitoryRecord.getRecordID());
		int row = dormitoryTrainingRecordDao.insertDormitoryTrainingRecord(dormitoryTrainingRecord);
		
		if(row > 0 ){
			if(addDormitoryTrainingRecordDetail(dormitoryTrainingRecord, dormitoryTrainingRecordDetailAdds)<0){
				throw new Exception("新增結案記錄失败！");
			}
		}
		return 1;
		
	}

	private int addDormitoryTrainingADPlan(DormitoryRecord dormitoryRecord,
			DormitoryTrainingADPlan dormitoryTrainingADPlan,List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailAdds) throws Exception {
		
		if (dormitoryTrainingADPlan == null || "".equals(dormitoryTrainingADPlan)) {
			return 1;
		}
		String planID = dormitoryTrainingADPlanDao.getPrimaryKey(Constants.CORPID);
		dormitoryTrainingADPlan.setaPlanID(planID);

		dormitoryTrainingADPlan.setRecordID(dormitoryRecord.getRecordID());
		int row = dormitoryTrainingADPlanDao.insertDormitoryTrainingADPlan(dormitoryTrainingADPlan);
		
		if(row > 0 ){
			if(addDormitoryTrainingADPlanDetail(dormitoryTrainingADPlan, dormitoryTrainingADPlanDetailAdds)<0){
				throw new Exception("新增結案記錄失败！");
			}
		}
		return 1;
	}

	private int addDormitoryTrainingPlan(DormitoryRecord dormitoryRecord, DormitoryTrainingPlan dormitoryTrainingPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException, ParseException {
		if (dormitoryTrainingPlan == null || "".equals(dormitoryTrainingPlan)) {
			return 1;
		}

		dormitoryTrainingPlan.setRecordID(dormitoryTrainingPlan.getRecordID());
		return  dormitoryTrainingPlanDao.insertDormitoryTrainingPlan(dormitoryTrainingPlan);
	}

	public String updateDormitoryRecord(DormitoryRecord dormitoryRecord, DormitoryTrainingPlan dormitoryTrainingPlan,
			DormitoryTrainingADPlan dormitoryTrainingADPlan, DormitoryTrainingRecord dormitoryTrainingRecord,
			DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailAdds,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailUpdates,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailDeletes,
			List<DormitoryTrainingRecordDetail> dormitoryTrainingRecordDetailAdds,
			List<DormitoryTrainingRecordDetail> dormitoryTrainingRecordDetailUpdates,
			List<DormitoryTrainingRecordDetail> dormitoryTrainingRecordDetailDeletes,
			List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTargetAdds,
			List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTargetUpdates,
			List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTargetDeletes,
			List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinanceAdds,
			List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinanceUpdates,
			List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinanceDeletes,
			List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettleAdds,
			List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettleUpdates,
			List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettleDeletes,
			List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetailAdds,
			List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetailUpdates,
			List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetailDeletes) {
		// TODO Auto-generated method stub
		return null;
	}
	
}