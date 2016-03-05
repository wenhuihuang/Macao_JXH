package com.jxh.biz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.jxh.dao.DormitoryRecordDao;
import com.jxh.dao.DormitoryTrainingPlanDao;
import com.jxh.utils.Constants;
import com.jxh.vo.DormitoryRecord;
import com.jxh.vo.DormitoryTrainingADPlan;
import com.jxh.vo.DormitoryTrainingADPlanDetail;
import com.jxh.vo.DormitoryTrainingPlan;
import com.jxh.vo.DormitoryTrainingRecord;
import com.jxh.vo.DormitoryTrainingRecordDetail;
import com.jxh.vo.DormitoryTrainingReview;
import com.jxh.vo.DormitoryTrainingReviewFinance;
import com.jxh.vo.DormitoryTrainingReviewSettle;
import com.jxh.vo.DormitoryTrainingReviewTarget;


public class DormitoryRecordBiz {
	private DormitoryRecordDao dormitoryRecordDao = new DormitoryRecordDao();
	private DormitoryTrainingPlanDao dormitoryTrainingPlanDao = new DormitoryTrainingPlanDao();

	public String insertDormitoryRecord(DormitoryRecord dormitoryRecord, DormitoryTrainingPlan dormitoryTrainingPlan,
			DormitoryTrainingADPlan dormitoryTrainingADPlan, DormitoryTrainingRecord dormitoryTrainingRecord,
			DormitoryTrainingReview dormitoryTrainingReview,
			List<DormitoryTrainingADPlanDetail> dormitoryTrainingADPlanDetailAdds,
			List<DormitoryTrainingRecordDetail> dormitoryTrainingRecordDetailAdds,
			List<DormitoryTrainingReviewTarget> dormitoryTrainingReviewTargetAdds,
			List<DormitoryTrainingReviewFinance> dormitoryTrainingReviewFinanceAdds,
			List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettleAdds) {
		
		String recordID = dormitoryRecordDao.getPrimaryKey(Constants.CORPID);
		dormitoryRecord.setRecordID(recordID);
		int row = dormitoryRecordDao.insertDormitoryRecord(dormitoryRecord);
		if (row > 0) {
			if (addDormitoryTrainingPlan(dormitoryRecord, dormitoryTrainingPlan) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			
			if (addDormitoryTrainingADPlan(dormitoryRecord, dormitoryTrainingADPlan) < 0) {
				throw new Exception("智障登記保存失败！");
			}
			
			if(addDormitoryTrainingRecord(dormitoryRecord,dormitoryTrainingRecord)<0){
				throw new Exception("新增家庭成員資料失败！");
			}
			
			if(addDormitoryTrainingReview(dormitoryRecord,dormitoryTrainingReview)<0){
				throw new Exception("新增綜援記錄失败！");
			}
			
			if(addDormitoryTrainingADPlanDetail(dormitoryRecord,dormitoryTrainingADPlanDetailAdds)<0){
				throw new Exception("新增特津記錄記錄失败！");
			}
			
			if(addDormitoryTrainingRecordDetail(dormitoryRecord,dormitoryTrainingRecordDetailAdds)<0){
				throw new Exception("新增特津記錄記錄失败！");
			}
			
			if(addDormitoryTrainingReviewTarget(dormitoryRecord,dormitoryTrainingReviewTargetAdds)<0){
				throw new Exception("新增特津記錄記錄失败！");
			}

			if(addDormitoryTrainingReviewFinance(dormitoryRecord,dormitoryTrainingReviewFinanceAdds)<0){
				throw new Exception("新增特津記錄記錄失败！");
			}

			if(addDormitoryTrainingReviewSettle(dormitoryRecord,dormitoryTrainingReviewSettleAdds)<0){
				throw new Exception("新增特津記錄記錄失败！");
			}
			
		}
		return "操作成功！";
	}

	private int addDormitoryTrainingPlan(DormitoryRecord dormitoryRecord, DormitoryTrainingPlan dormitoryTrainingPlan) {
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
			List<DormitoryTrainingReviewSettle> dormitoryTrainingReviewSettleDeletes) {
		// TODO Auto-generated method stub
		return null;
	}
	
}