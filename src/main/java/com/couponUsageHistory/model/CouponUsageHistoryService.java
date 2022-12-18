package com.couponUsageHistory.model;

import java.sql.Timestamp;
import java.util.List;

import com.shoppingGoldRecord.model.ShoppingGoldRecordVO;
 
public class CouponUsageHistoryService {
	
	private CouponUsageHistoryDAO_interface dao;
	public CouponUsageHistoryService() {
		dao = new CouponUsageHistoryJDBCDAO();
	}
	
	public CouponUsageHistoryVO addCouponUsageHistory(Integer memberID, Integer couponID, Integer usageRecord, Timestamp useDate) {

		CouponUsageHistoryVO couponUsageHistoryVO = new CouponUsageHistoryVO();

		couponUsageHistoryVO.setMemberID(memberID);
		couponUsageHistoryVO.setCouponID(couponID);
		couponUsageHistoryVO.setUsageRecord(usageRecord);
		couponUsageHistoryVO.setUseDate(useDate);

		
		
		dao.insert(couponUsageHistoryVO);

		return couponUsageHistoryVO;
	}
	
//	public List<CouponUsageHistoryVO> getOneCouponUsageHistory(Integer memberID) {
//		return dao.getAllCouponUsageHistory(memberID);
//	}

	public List<CouponUsageHistoryVO> getAll(Integer memberID) {
		return dao.getAll(memberID);
	}
	
	public List<CouponUsageHistoryVO> getAll2() {
		return dao.getAll2();
	}
	
}
