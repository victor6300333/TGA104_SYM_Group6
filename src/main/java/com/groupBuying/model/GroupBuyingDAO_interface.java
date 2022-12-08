package com.groupBuying.model;

import java.util.List;


public interface GroupBuyingDAO_interface {
	public void insert(GroupBuyingVO groupBuyingVO);
    public void update(GroupBuyingVO groupBuyingVO);
    public void delete(Integer groupBuyID);
    public GroupBuyingVO findByPrimaryKey(Integer groupBuyID);
    public List<GroupBuyingVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<AnnouncementVO> getAll(Map<String, String[]> map); 
}
