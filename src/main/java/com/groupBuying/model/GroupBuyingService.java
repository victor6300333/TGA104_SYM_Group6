package com.groupBuying.model;

import java.sql.Timestamp;
import java.util.List;

public class GroupBuyingService {

	private GroupBuyingDAO_interface dao;
	
	public GroupBuyingService() {
		dao = new GroupBuyingJDBCDAO();
	}
	
	public GroupBuyingVO addGroup(Integer groupBuyProductID, Integer administratorID, Integer groupBuyProductOrderTotal, Boolean groupBuyingState, java.sql.Date groupBuyingOnLoadDate,
			java.sql.Date groupBuyingOffLoadDate, Timestamp updateTime) {
		
		GroupBuyingVO groupBuyingVO = new GroupBuyingVO();

		groupBuyingVO.setGroupBuyProductID(groupBuyProductID);
		groupBuyingVO.setAdministratorID(administratorID);
		groupBuyingVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupBuyingVO.setGroupBuyingState(groupBuyingState);
		groupBuyingVO.setGroupBuyingOnLoadDate(groupBuyingOnLoadDate);
		groupBuyingVO.setGroupBuyingOffLoadDate(groupBuyingOffLoadDate);
		groupBuyingVO.setUpdateTime(updateTime);
		dao.insert(groupBuyingVO);

		return groupBuyingVO;
	}
	
	public GroupBuyingVO updateGroup(Integer groupBuyProductID, Integer administratorID, Integer groupBuyProductOrderTotal, Boolean groupBuyingState, java.sql.Date groupBuyingOnLoadDate,
			java.sql.Date groupBuyingOffLoadDate, Timestamp updateTime) {

		GroupBuyingVO groupBuyingVO = new GroupBuyingVO();

		groupBuyingVO.setGroupBuyProductID(groupBuyProductID);
		groupBuyingVO.setAdministratorID(administratorID);
		groupBuyingVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupBuyingVO.setGroupBuyingState(groupBuyingState);
		groupBuyingVO.setGroupBuyingOnLoadDate(groupBuyingOnLoadDate);
		groupBuyingVO.setGroupBuyingOffLoadDate(groupBuyingOffLoadDate);
		groupBuyingVO.setUpdateTime(updateTime);
		dao.update(groupBuyingVO);

		return groupBuyingVO;
	}
	
	
	public void deleteEmp(Integer groupBuyID) {
		dao.delete(groupBuyID);
	}

	public GroupBuyingVO getOneEmp(Integer groupBuyID) {
		return dao.findByPrimaryKey(groupBuyID);
	}

	public List<GroupBuyingVO> getAll() {
		return dao.getAll();
	}
	
	
	
}
