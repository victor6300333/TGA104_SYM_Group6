package com.memberBlockList.model;

import java.util.List;

import com.store.model.StoreVO;

public interface MemberBlockListVO_interface {

	public void insert(MemberBlockListVO memberBlockListVO);

	public void delete(Integer blockListID);

	public List<ViewMemberBlockListVO> getAll(Integer memberID);
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 

}
