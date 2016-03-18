package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.jxh.dao.DormitoryRecordDao;
import com.jxh.dao.DormitoryTrainingADPlanDao;
import com.jxh.dao.DormitoryTrainingADPlanDetailDao;
import com.jxh.dao.DormitoryTrainingPlanDao;
import com.jxh.dao.DormitoryTrainingRecordDao;
import com.jxh.dao.DormitoryTrainingRecordDetailBottomDao;
import com.jxh.dao.DormitoryTrainingRecordDetailTopDao;
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
import com.jxh.vo.DormitoryTrainingRecordDetailBottom;
import com.jxh.vo.DormitoryTrainingRecordDetailTop;
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
	private DormitoryTrainingRecordDetailTopDao dormitoryTrainingRecordDetailTopDao = new DormitoryTrainingRecordDetailTopDao();
	private DormitoryTrainingRecordDetailBottomDao dormitoryTrainingRecordDetailBottomDao = new DormitoryTrainingRecordDetailBottomDao();
	private DormitoryTrainingReviewTargetDao dormitoryTrainingReviewTargetDao = new DormitoryTrainingReviewTargetDao();
	private DormitoryTrainingReviewFinanceDao dormitoryTrainingReviewFinanceDao = new DormitoryTrainingReviewFinanceDao();
	private DormitoryTrainingReviewSettleDao dormitoryTrainingReviewSettleDao = new DormitoryTrainingReviewSettleDao();
	private DormitoryTrainingReviewDetailDao dormitoryTrainingReviewDetailDao = new DormitoryTrainingReviewDetailDao();

	public String insertDormitoryRecord(DormitoryRecord dormitoryRecord, DormitoryTrainingPlan dormitoryTrainingPlan,
			DormitoryTrainingADPlan dormitoryTrainingADPlan, DormitoryTrainingRecord dormitoryTrainingRecord,
			DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailAdds,
			List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTopAdds,
			List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottomAdds,
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

			if (addDormitoryTrainingADPlan(dormitoryRecord, dormitoryTrainingADPlan,
					dormitoryTrainingADPlanDetailAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}

			if (addDormitoryTrainingRecord(dormitoryRecord, dormitoryTrainingRecord,
					dormitoryTrainingRecordDetailTopAdds, dormitoryTrainingRecordDetailBottomAdds) < 0) {
				throw new Exception("新增家庭成員資料失败！");
			}

			if (addDormitoryTrainingReview(dormitoryRecord, dormitoryTrainingReview, dormitoryTrainingReviewTargetAdds,
					dormitoryTrainingReviewFinanceAdds, dormitoryTrainingReviewSettleAdds,
					dormitoryTrainingReviewDetailAdds) < 0) {
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

		if (row > 0) {
			if (addDormitoryTrainingReviewTarget(dormitoryTrainingReview, dormitoryTrainingReviewTargetAdds) < 0) {
				throw new Exception("新增特津記錄記錄失败！");
			}

			if (addDormitoryTrainingReviewFinance(dormitoryTrainingReview, dormitoryTrainingReviewFinanceAdds) < 0) {
				throw new Exception("新增特津記錄記錄失败！");
			}

			if (addDormitoryTrainingReviewSettle(dormitoryTrainingReview, dormitoryTrainingReviewSettleAdds) < 0) {
				throw new Exception("新增特津記錄記錄失败！");
			}

			if (addDormitoryTrainingReviewDetail(dormitoryTrainingReview, dormitoryTrainingReviewDetailAdds) < 0) {
				throw new Exception("新增特津記錄記錄失败！");
			}
		}

		return 1;
	}

	private int addDormitoryTrainingReviewDetail(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetailAdds)
					throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
					ParseException, IOException, SQLException {
		if (dormitoryTrainingReviewDetailAdds == null || dormitoryTrainingReviewDetailAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingReviewDetail add : dormitoryTrainingReviewDetailAdds) {
			add.setReviewID(dormitoryTrainingReview.getReviewID());
		}

		int[] rows = dormitoryTrainingReviewDetailDao
				.insertDormitoryTrainingReviewDetail(dormitoryTrainingReviewDetailAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addDormitoryTrainingReviewSettle(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettleAdds)
					throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
					ParseException, IOException, SQLException {
		if (dormitoryTrainingReviewSettleAdds == null || dormitoryTrainingReviewSettleAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingReviewSettle add : dormitoryTrainingReviewSettleAdds) {
			add.setReviewID(dormitoryTrainingReview.getReviewID());
		}

		int[] rows = dormitoryTrainingReviewSettleDao
				.insertDormitoryTrainingReviewSettle(dormitoryTrainingReviewSettleAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addDormitoryTrainingReviewFinance(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinanceAdds)
					throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
					ParseException, IOException, SQLException {
		if (dormitoryTrainingReviewFinanceAdds == null || dormitoryTrainingReviewFinanceAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingReviewFinance add : dormitoryTrainingReviewFinanceAdds) {
			add.setReviewID(dormitoryTrainingReview.getReviewID());
		}

		int[] rows = dormitoryTrainingReviewFinanceDao
				.insertDormitoryTrainingReviewFinance(dormitoryTrainingReviewFinanceAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addDormitoryTrainingReviewTarget(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTargetAdds)
					throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
					ParseException, IOException, SQLException {
		if (dormitoryTrainingReviewTargetAdds == null || dormitoryTrainingReviewTargetAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingReviewTarget add : dormitoryTrainingReviewTargetAdds) {
			add.setReviewID(dormitoryTrainingReview.getReviewID());
		}

		int[] rows = dormitoryTrainingReviewTargetDao
				.insertDormitoryTrainingReviewTarget(dormitoryTrainingReviewTargetAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addDormitoryTrainingRecordDetailTop(DormitoryTrainingRecord dormitoryTrainingRecord,
			List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTopAdds)
					throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
					ParseException, IOException, SQLException {
		if (dormitoryTrainingRecordDetailTopAdds == null || dormitoryTrainingRecordDetailTopAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingRecordDetailTop add : dormitoryTrainingRecordDetailTopAdds) {
			add.setMasterRecordID(dormitoryTrainingRecord.gettRecordID());
		}

		int[] rows = dormitoryTrainingRecordDetailTopDao
				.insertDormitoryTrainingRecordDetailTop(dormitoryTrainingRecordDetailTopAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addDormitoryTrainingRecordDetailBottom(DormitoryTrainingRecord dormitoryTrainingRecord,
			List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottomAdds)
					throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
					ParseException, IOException, SQLException {
		if (dormitoryTrainingRecordDetailBottomAdds == null || dormitoryTrainingRecordDetailBottomAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingRecordDetailBottom add : dormitoryTrainingRecordDetailBottomAdds) {
			add.setMasterRecordID(dormitoryTrainingRecord.gettRecordID());
		}

		int[] rows = dormitoryTrainingRecordDetailBottomDao
				.insertDormitoryTrainingRecordDetailBottom(dormitoryTrainingRecordDetailBottomAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addDormitoryTrainingADPlanDetail(DormitoryTrainingADPlan dormitoryTrainingADPlan,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailAdds)
					throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
					ParseException, IOException, SQLException {
		if (dormitoryTrainingADPlanDetailAdds == null || dormitoryTrainingADPlanDetailAdds.size() <= 0) {
			return 1;
		}

		for (DormitoryTrainingADPlanDetail add : dormitoryTrainingADPlanDetailAdds) {
			add.setPlanMasterID(dormitoryTrainingADPlan.getaPlanID());
		}

		int[] rows = dormitoryTrainingADPlanDetailDao
				.insertDormitoryTrainingADPlanDetail(dormitoryTrainingADPlanDetailAdds);
		for (int i : rows) {
			if (i < 1) {
				return i;
			}
		}

		return 1;
	}

	private int addDormitoryTrainingReview(DormitoryRecord dormitoryRecord,
			DormitoryTrainingReview dormitoryTrainingReview) throws NoSuchFieldException, SecurityException,
					IllegalArgumentException, IllegalAccessException, ParseException, IOException, SQLException {
		if (dormitoryTrainingReview == null || "".equals(dormitoryTrainingReview)) {
			return 1;
		}

		dormitoryTrainingReview.setRecordID(dormitoryRecord.getRecordID());
		return dormitoryTrainingReviewDao.insertDormitoryTrainingReview(dormitoryTrainingReview);
	}

	private int addDormitoryTrainingRecord(DormitoryRecord dormitoryRecord,
			DormitoryTrainingRecord dormitoryTrainingRecord,
			List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTopAdds,
			List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottomAdds) throws Exception {

		if (dormitoryTrainingRecord == null || "".equals(dormitoryTrainingRecord)) {
			return 1;
		}

		String recordID = dormitoryTrainingRecordDao.getPrimaryKey(Constants.CORPID);
		dormitoryTrainingRecord.settRecordID(recordID);
		dormitoryTrainingRecord.setRecordID(dormitoryRecord.getRecordID());
		int row = dormitoryTrainingRecordDao.insertDormitoryTrainingRecord(dormitoryTrainingRecord);

		if (row > 0) {
			if (addDormitoryTrainingRecordDetailTop(dormitoryTrainingRecord,
					dormitoryTrainingRecordDetailTopAdds) < 0) {
				throw new Exception("新增結案記錄失败！");
			}
			if (addDormitoryTrainingRecordDetailBottom(dormitoryTrainingRecord,
					dormitoryTrainingRecordDetailBottomAdds) < 0) {
				throw new Exception("新增失败！");
			}
		}
		return 1;

	}

	private int addDormitoryTrainingADPlan(DormitoryRecord dormitoryRecord,
			DormitoryTrainingADPlan dormitoryTrainingADPlan,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailAdds) throws Exception {

		if (dormitoryTrainingADPlan == null || "".equals(dormitoryTrainingADPlan)) {
			return 1;
		}
		String planID = dormitoryTrainingADPlanDao.getPrimaryKey(Constants.CORPID);
		dormitoryTrainingADPlan.setaPlanID(planID);

		dormitoryTrainingADPlan.setRecordID(dormitoryRecord.getRecordID());
		int row = dormitoryTrainingADPlanDao.insertDormitoryTrainingADPlan(dormitoryTrainingADPlan);

		if (row > 0) {
			if (addDormitoryTrainingADPlanDetail(dormitoryTrainingADPlan, dormitoryTrainingADPlanDetailAdds) < 0) {
				throw new Exception("新增結案記錄失败！");
			}
		}
		return 1;
	}

	private int addDormitoryTrainingPlan(DormitoryRecord dormitoryRecord, DormitoryTrainingPlan dormitoryTrainingPlan)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
			SQLException, IOException, ParseException {
		if (dormitoryTrainingPlan == null || "".equals(dormitoryTrainingPlan)) {
			return 1;
		}

		dormitoryTrainingPlan.setRecordID(dormitoryRecord.getRecordID());
		return dormitoryTrainingPlanDao.insertDormitoryTrainingPlan(dormitoryTrainingPlan);
	}

	public String updateDormitoryRecord(DormitoryRecord dormitoryRecord, DormitoryTrainingPlan dormitoryTrainingPlan,
			DormitoryTrainingADPlan dormitoryTrainingADPlan, DormitoryTrainingRecord dormitoryTrainingRecord,
			DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailAdds,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailUpdates,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailDeletes,
			List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTopAdds,
			List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTopUpdates,
			List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTopDeletes,
			List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottomAdds,
			List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottomUpdates,
			List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottomDeletes,
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
			List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetailDeletes) throws Exception {
		int row = dormitoryRecordDao.updateDormitoryRecord(dormitoryRecord);
		if (row > 0) {

			if (updateDormitoryTrainingPlan(dormitoryRecord, dormitoryTrainingPlan) < 0) {
				throw new Exception("智障登記保存失败！");
			}

			if (updateDormitoryTrainingADPlan(dormitoryRecord, dormitoryTrainingADPlan) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			if (addDormitoryTrainingADPlanDetail(dormitoryTrainingADPlan, dormitoryTrainingADPlanDetailAdds) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			if (updateDormitoryTrainingADPlanDetail(dormitoryTrainingADPlan,
					dormitoryTrainingADPlanDetailUpdates) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			if (deleteDormitoryTrainingADPlanDetail(dormitoryTrainingADPlan,
					dormitoryTrainingADPlanDetailDeletes) < 0) {
				throw new Exception("智障登記保存失败！");
			}

			if (updateDormitoryTrainingRecord(dormitoryRecord, dormitoryTrainingRecord) < 0) {
				throw new Exception("新增家庭成員資料失败！");
			}
			if (addDormitoryTrainingRecordDetailTop(dormitoryTrainingRecord,
					dormitoryTrainingRecordDetailTopAdds) < 0) {
				throw new Exception("新增家庭成員資料失败！");
			}
			if (updateDormitoryTrainingRecordDetailTop(dormitoryTrainingRecord,
					dormitoryTrainingRecordDetailTopUpdates) < 0) {
				throw new Exception("新增家庭成員資料失败！");
			}
			if (deleteDormitoryTrainingRecordDetailTop(dormitoryTrainingRecord,
					dormitoryTrainingRecordDetailTopDeletes) < 0) {
				throw new Exception("新增家庭成員資料失败！");
			}
			if (addDormitoryTrainingRecordDetailBottom(dormitoryTrainingRecord,
					dormitoryTrainingRecordDetailBottomAdds) < 0) {
				throw new Exception("新增家庭成員資料失败！");
			}
			if (updateDormitoryTrainingRecordDetailBottom(dormitoryTrainingRecord,
					dormitoryTrainingRecordDetailBottomUpdates) < 0) {
				throw new Exception("新增家庭成員資料失败！");
			}
			if (deleteDormitoryTrainingRecordDetailBottom(dormitoryTrainingRecord,
					dormitoryTrainingRecordDetailBottomDeletes) < 0) {
				throw new Exception("新增家庭成員資料失败！");
			}

			if (updateDormitoryTrainingReview(dormitoryRecord, dormitoryTrainingReview) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}
			if (addDormitoryTrainingReviewTarget(dormitoryTrainingReview, dormitoryTrainingReviewTargetAdds) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}
			if (updateDormitoryTrainingReviewTarget(dormitoryTrainingReview,
					dormitoryTrainingReviewTargetUpdates) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}
			if (deleteDormitoryTrainingReviewTarget(dormitoryTrainingReview,
					dormitoryTrainingReviewTargetDeletes) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}
			if (addDormitoryTrainingReviewFinance(dormitoryTrainingReview, dormitoryTrainingReviewFinanceAdds) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}
			if (updateDormitoryTrainingReviewFinance(dormitoryTrainingReview,
					dormitoryTrainingReviewFinanceUpdates) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}
			if (deleteDormitoryTrainingReviewFinance(dormitoryTrainingReview,
					dormitoryTrainingReviewFinanceDeletes) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}

			if (addDormitoryTrainingReviewSettle(dormitoryTrainingReview, dormitoryTrainingReviewSettleAdds) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}
			if (updateDormitoryTrainingReviewSettle(dormitoryTrainingReview,
					dormitoryTrainingReviewSettleUpdates) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}
			if (deleteDormitoryTrainingReviewSettle(dormitoryTrainingReview,
					dormitoryTrainingReviewSettleDeletes) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}

			if (addDormitoryTrainingReviewDetail(dormitoryTrainingReview, dormitoryTrainingReviewDetailAdds) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}
			if (updateDormitoryTrainingReviewDetail(dormitoryTrainingReview,
					dormitoryTrainingReviewDetailUpdates) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}
			if (deleteDormitoryTrainingReviewDetail(dormitoryTrainingReview, dormitoryTrainingReviewDetailDeletes) < 0) {
				throw new Exception("新增綜援記錄失败！");
			}

		}
		return "操作成功！";
	}

	private int deleteDormitoryTrainingReviewDetail(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetailDeletes) throws IOException, SQLException {
		if(dormitoryTrainingReviewDetailDeletes == null || dormitoryTrainingReviewDetailDeletes.size() <= 0){
			return 1;
		}
		return dormitoryTrainingReviewDetailDao.deleteDormitoryTrainingReviewDetail(dormitoryTrainingReviewDetailDeletes);
	}

	private int updateDormitoryTrainingReviewDetail(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewDetail> dormitoryTrainingReviewDetailUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if(dormitoryTrainingReviewDetailUpdates == null || dormitoryTrainingReviewDetailUpdates.size() <= 0){
			return 1;
		}
		return dormitoryTrainingReviewDetailDao.updateDormitoryTrainingReviewDetail(dormitoryTrainingReviewDetailUpdates);
	}

	private int deleteDormitoryTrainingReviewSettle(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettleDeletes) throws IOException, SQLException {
		if(dormitoryTrainingReviewSettleDeletes == null || dormitoryTrainingReviewSettleDeletes.size() <= 0){
			return 1;
		}
		return dormitoryTrainingReviewSettleDao.deleteDormitoryTrainingReviewSettle(dormitoryTrainingReviewSettleDeletes);
	}

	private int updateDormitoryTrainingReviewSettle(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettleUpdates) throws IOException, SQLException {
		if(dormitoryTrainingReviewSettleUpdates == null || dormitoryTrainingReviewSettleUpdates.size() <= 0){
			return 1;
		}
		return dormitoryTrainingReviewSettleDao.deleteDormitoryTrainingReviewSettle(dormitoryTrainingReviewSettleUpdates);
	}

	private int deleteDormitoryTrainingReviewFinance(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinanceDeletes) throws IOException, SQLException {
		if(dormitoryTrainingReviewFinanceDeletes == null || dormitoryTrainingReviewFinanceDeletes.size() <= 0){
			return 1;
		}
		return dormitoryTrainingReviewFinanceDao.deleteDormitoryTrainingReviewFinance(dormitoryTrainingReviewFinanceDeletes);
	}

	private int updateDormitoryTrainingReviewFinance(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinanceUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if(dormitoryTrainingReviewFinanceUpdates == null || dormitoryTrainingReviewFinanceUpdates.size() <= 0){
			return 1;
		}
		return dormitoryTrainingReviewFinanceDao.updateDormitoryTrainingReviewFinance(dormitoryTrainingReviewFinanceUpdates);
	}

	private int deleteDormitoryTrainingReviewTarget(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTargetDeletes) throws IOException, SQLException {
		if(dormitoryTrainingReviewTargetDeletes == null || dormitoryTrainingReviewTargetDeletes.size() <= 0){
			return 1;
		}
		return dormitoryTrainingReviewTargetDao.deleteDormitoryTrainingReviewTarget(dormitoryTrainingReviewTargetDeletes);
	}

	private int updateDormitoryTrainingReviewTarget(DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTargetUpdates) throws IOException, SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException {
		if(dormitoryTrainingReviewTargetUpdates == null || dormitoryTrainingReviewTargetUpdates.size() <= 0){
			return 1;
		}
		return dormitoryTrainingReviewTargetDao.updateDormitoryTrainingReviewTarget(dormitoryTrainingReviewTargetUpdates);
	}

	private int updateDormitoryTrainingReview(DormitoryRecord dormitoryRecord,
			DormitoryTrainingReview dormitoryTrainingReview) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if(dormitoryTrainingReview == null || "".equals(dormitoryTrainingReview)){
			return 1;
		}
		return dormitoryTrainingReviewDao.updateDormitoryTrainingReview(dormitoryTrainingReview);
	}

	private int deleteDormitoryTrainingRecordDetailBottom(DormitoryTrainingRecord dormitoryTrainingRecord,
			List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottomDeletes) throws IOException, SQLException {
		if(dormitoryTrainingRecordDetailBottomDeletes == null || dormitoryTrainingRecordDetailBottomDeletes.size() <= 0){
			return 1;
		}
		return dormitoryTrainingRecordDetailBottomDao.deleteDormitoryTrainingRecordDetailBottom(dormitoryTrainingRecordDetailBottomDeletes);
	}

	private int updateDormitoryTrainingRecordDetailBottom(DormitoryTrainingRecord dormitoryTrainingRecord,
			List<DormitoryTrainingRecordDetailBottom> dormitoryTrainingRecordDetailBottomUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if(dormitoryTrainingRecordDetailBottomUpdates ==null || dormitoryTrainingRecordDetailBottomUpdates.size() <= 0){
			return 1;
		}
		return dormitoryTrainingRecordDetailBottomDao.updateDormitoryTrainingRecordDetailBottom(dormitoryTrainingRecordDetailBottomUpdates);
	}

	private int deleteDormitoryTrainingRecordDetailTop(DormitoryTrainingRecord dormitoryTrainingRecord,
			List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTopDeletes) throws IOException, SQLException {
		if(dormitoryTrainingRecordDetailTopDeletes == null || dormitoryTrainingRecordDetailTopDeletes.size() <= 0){
			return 1;
		}
		return dormitoryTrainingRecordDetailTopDao.deleteDormitoryTrainingRecordDetailTop(dormitoryTrainingRecordDetailTopDeletes);
	}

	private int updateDormitoryTrainingRecordDetailTop(DormitoryTrainingRecord dormitoryTrainingRecord,
			List<DormitoryTrainingRecordDetailTop> dormitoryTrainingRecordDetailTopUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if(dormitoryTrainingRecordDetailTopUpdates == null || dormitoryTrainingRecordDetailTopUpdates.size() <= 0){
			return 1;
		}
		return dormitoryTrainingRecordDetailTopDao.updateDormitoryTrainingRecordDetailTop(dormitoryTrainingRecordDetailTopUpdates);
	}

	private int updateDormitoryTrainingRecord(DormitoryRecord dormitoryRecord,
			DormitoryTrainingRecord dormitoryTrainingRecord) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if(dormitoryTrainingRecord == null || "".equals(dormitoryTrainingRecord)){
			return 1;
		}
		return dormitoryTrainingRecordDao.updateDormitoryTrainingRecord(dormitoryTrainingRecord);
	}

	private int deleteDormitoryTrainingADPlanDetail(DormitoryTrainingADPlan dormitoryTrainingADPlan,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailDeletes) throws IOException, SQLException {
		if(dormitoryTrainingADPlanDetailDeletes==null || dormitoryTrainingADPlanDetailDeletes.size() <= 0){
			return 1;
		}
		return dormitoryTrainingADPlanDetailDao.deleteDormitoryTrainingADPlanDetail(dormitoryTrainingADPlanDetailDeletes);
	}

	private int updateDormitoryTrainingADPlanDetail(DormitoryTrainingADPlan dormitoryTrainingADPlan,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailUpdates) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if(dormitoryTrainingADPlanDetailUpdates ==null || dormitoryTrainingADPlanDetailUpdates.size() <= 0){
			return 1;
		}
		return dormitoryTrainingADPlanDetailDao.updateDormitoryTrainingADPlanDetail(dormitoryTrainingADPlanDetailUpdates);
	}

	private int updateDormitoryTrainingADPlan(DormitoryRecord dormitoryRecord,
			DormitoryTrainingADPlan dormitoryTrainingADPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, ParseException, IOException {
		if(dormitoryTrainingADPlan == null || "".equals(dormitoryTrainingADPlan)){
			return 1;
		}
		return dormitoryTrainingADPlanDao.updateDormitoryTrainingADPlan(dormitoryTrainingADPlan);
	}

	private int updateDormitoryTrainingPlan(DormitoryRecord dormitoryRecord,
			DormitoryTrainingPlan dormitoryTrainingPlan) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException, SQLException, ParseException {
		if(dormitoryTrainingPlan == null || "".equals(dormitoryTrainingPlan)){
			return 1;
		}
		return dormitoryTrainingPlanDao.updateDormitoryTrainingPlan(dormitoryTrainingPlan);
	}

	public boolean deleteDormitoryRecordByRecordID(String recordID, String aPlanID, String tRecordID, String reviewID)
			throws Exception {
		boolean flag = false;
		int row = dormitoryRecordDao.deleteDormitoryRecordByRecordID(recordID);
		if (row > 0) {

			if (deleteDormitoryTrainingPlan(recordID) < 0) {
				throw new Exception("個案轉介評估刪除失敗！");
			}

			if (deleteDormitoryTrainingADPlan(aPlanID) < 0) {
				throw new Exception("個案轉介評估刪除失敗！");
			}

			if (deleteDormitoryTrainingRecord(tRecordID) < 0) {
				throw new Exception("個案轉介評估刪除失敗！");
			}

			if (deleteDormitoryTrainingReview(reviewID) < 0) {
				throw new Exception("結案摘要刪除失敗！");
			}

			flag = true;

		}
		return flag;
	}

	private int deleteDormitoryTrainingReview(String reviewID) throws SQLException, IOException {
		if (reviewID != null && !"".equals(reviewID)) {
			dormitoryTrainingReviewTargetDao.deleteDormitoryTrainingReviewTargetByReviewID(reviewID);
			dormitoryTrainingReviewFinanceDao.deleteDormitoryTrainingReviewFinanceByReviewID(reviewID);
			dormitoryTrainingReviewDetailDao.deleteDormitoryTrainingReviewDetailByReviewID(reviewID);
			dormitoryTrainingReviewSettleDao.deleteDormitoryTrainingReviewSettleByReviewID(reviewID);
		}
		return dormitoryTrainingReviewDao.deleteDormitoryTrainingReviewByRecordID(reviewID);
	}

	private int deleteDormitoryTrainingRecord(String tRecordID) throws SQLException, IOException {
		if (tRecordID != null && !"".equals(tRecordID)) {
			dormitoryTrainingRecordDetailTopDao.deleteDormitoryTrainingRecordDetailTopByMasterRecordID(tRecordID);
			dormitoryTrainingRecordDetailBottomDao.deleteDormitoryTrainingRecordDetailBottomByMasterRecordID(tRecordID);
		}
		return dormitoryTrainingRecordDao.deleteDormitoryTrainingRecordByTRecordID(tRecordID);
	}

	private int deleteDormitoryTrainingADPlan(String aPlanID) throws SQLException, IOException {
		if (aPlanID != null && !"".equals(aPlanID)) {
			dormitoryTrainingADPlanDetailDao.deleteDormitoryTrainingADPlanDetailByAPlanID(aPlanID);
		}

		return dormitoryTrainingADPlanDao.deleteDormitoryTrainingADPlanByAPlanID(aPlanID);
	}

	private int deleteDormitoryTrainingPlan(String recordID) throws SQLException, IOException {
		return dormitoryTrainingPlanDao.deleteDormitoryTrainingPlanByRecordID(recordID);
	}

}