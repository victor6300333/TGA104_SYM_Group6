package com.administrator.model;

import java.util.List;


public interface AdministratorDAO_interface {

	public void update(AdministratorVO administratorVO);
	public List<AdministratorVO> getAll();
	public AdministratorVO selectMemberID(Integer memberID);
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//	public List<AdministratorVO> getAll(Map<String, String[]> map);
}
