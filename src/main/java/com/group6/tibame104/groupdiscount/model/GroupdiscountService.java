package com.group6.tibame104.groupdiscount.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GroupdiscountService {
	@Autowired
	private GroupdiscountDAO_interface dao;
	
	// 新增
	public GroupdiscountVO addGroupdiscount(Integer groupBuyID, Integer groupBuyProductOrderTotal,
			Double groupBuyCount) {

		GroupdiscountVO groupdiscountVO = new GroupdiscountVO();

		groupdiscountVO.setGroupBuyID(groupBuyID);
		groupdiscountVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupdiscountVO.setGroupBuyCount(groupBuyCount);

		dao.insert(groupdiscountVO);

		return groupdiscountVO;
	}

	// 修改
	public GroupdiscountVO updateGroupdiscount(Integer countTableID, Integer groupBuyID, Integer groupBuyProductOrderTotal,
			Double groupBuyCount) {

		GroupdiscountVO groupdiscountVO = new GroupdiscountVO();

		groupdiscountVO.setCountTableID(countTableID);
		groupdiscountVO.setGroupBuyID(groupBuyID);
		groupdiscountVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
		groupdiscountVO.setGroupBuyCount(groupBuyCount);

		dao.update(groupdiscountVO);
		return groupdiscountVO;
	}

	// 單一查詢
	public GroupdiscountVO getOneGroupdiscount(Integer countTableID) {
		return dao.findByPrimaryKey(countTableID);
	}
	// 
		public List<GroupdiscountVO> getAllCount(Integer groupBuyID) {
			return dao.getAllCount(groupBuyID);
		}

	// 查詢全部
	public List<GroupdiscountVO> getAll() {
		return dao.getAll();
	}
	//只找groupID不重複
	public List<GroupdiscountVO> getGroupBuyID() {
		return dao.getGroupBuyID();
	}
	// 查詢全部
	public List<GroupdiscountVO> getCountTable(Integer groupBuyID) {
		return dao.getCountTable(groupBuyID);
	}
	
	public void deleteGroupdiscount(Integer countTableID) {
		dao.delete(countTableID);
	}

}