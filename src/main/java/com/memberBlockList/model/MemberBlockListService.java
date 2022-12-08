package com.memberBlockList.model;

import java.sql.Date;
import java.util.List;

public class MemberBlockListService {
	private MemberBlockListVO_interface dao;

	public MemberBlockListService() {
		dao = new MemberBlockListJDBCDAO();
	}

	public MemberBlockListVO addBlock(Integer memberId, Integer storeID) {

		MemberBlockListVO memberBlockListVO = new MemberBlockListVO();

		memberBlockListVO.setMemberID(memberId);
		memberBlockListVO.setStoreID(storeID);
		dao.insert(memberBlockListVO);

		return memberBlockListVO;
	}

	public void delete(Integer blockListID) {
		dao.delete(blockListID);
	}

	public List<MemberBlockListVO> getAll(Integer memberId) {
		return dao.getAll(memberId);
	}

//	public static void main(String[] args) {
//		MemberBlockListService memberBlockListService = new MemberBlockListService();
//
//		memberBlockListService.addBlock(3, 2);
//
//	}

}
