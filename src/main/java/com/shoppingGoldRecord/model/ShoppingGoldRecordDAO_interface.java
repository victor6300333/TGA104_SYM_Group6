package com.shoppingGoldRecord.model;

import java.util.List;

public interface ShoppingGoldRecordDAO_interface {
    public void insert(ShoppingGoldRecordVO shoppingGoldRecordVO);
    public void update(ShoppingGoldRecordVO shoppingGoldRecordVO);
    public ShoppingGoldRecordVO findByPrimaryKey(Integer shoppingGoldRecordVO);
    public List<ShoppingGoldRecordVO> getAll();
   
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
    public List<ShoppingGoldRecordVO> getAllShoppingGoldRecord(Integer memberID);
}
