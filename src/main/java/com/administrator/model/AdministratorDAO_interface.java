package com.administrator.model;

import java.util.List;


public interface AdministratorDAO_interface {

	public void insert(AdministratorVO administratorVO);
	public void update(AdministratorVO administratorVO);
	public void delete(Integer administratorID);
	public AdministratorVO findOneAdmin(Integer administratorID);
	public List<AdministratorVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//	public List<AdministratorVO> getAll(Map<String, String[]> map);
}
