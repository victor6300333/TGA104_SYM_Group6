package com.groupproduct.model;

import java.util.*;

public interface GroupproductDAO_interface {

	public void insert(GroupproductVO groupproductVO);

	public void update(GroupproductVO groupproductVO);

	public void delete(Integer groupbuyProductID);

	public GroupproductVO findByPrimaryKey(Integer groupbuyProductID);

	public List<GroupproductVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<(GroupproductVO> getAll(Map<String, String[]> map); 
}