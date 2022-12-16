package com.couponUsageHistory.model;

import java.util.List;

public interface CouponUsageHistoryDAO_interface {
	public void insert(CouponUsageHistoryVO couponUsageHistoryVO);
	public CouponUsageHistoryVO findByPrimaryKey(Integer memberID);
	public List<CouponUsageHistoryVO> getAll(Integer memberID);
	public List<CouponUsageHistoryVO> getAll2();
}
