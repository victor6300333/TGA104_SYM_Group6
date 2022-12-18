package com.group6.tibame104.groupdiscount.model;

import java.util.List;

public interface GroupdiscountDAO_interface {

	public void insert(GroupdiscountVO groupdiscountVO);

	public void update(GroupdiscountVO groupdiscountVO);

	public void delete(Integer countTableID);

//找單一折扣流水編號
	public GroupdiscountVO findByPrimaryKey(Integer countTableID);

	// 找團購單一編號
	public List<GroupdiscountVO> getAllCount(Integer groupBuyID);
//找全部折扣表
	public List<GroupdiscountVO> getAll();
//用groupBuyID找折扣表
	public List<GroupdiscountVO> getGroupBuyID();
//	
	public List<GroupdiscountVO> getCountTable(Integer groupBuyID);

//	public void insert2(List<GroupdiscountVO> groupdiscountlist);

	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<(GroupproductVO> getAll(Map<String, String[]> map); 
}
