package com.groupproduct.model;

import java.util.List;

public class GroupproductService {

	private GroupproductDAO_interface dao;

	public GroupproductService() {
		dao = new GroupproductJDBCDAO();
	}

//新增
	public GroupproductVO addGroupproduct(Integer groupBuyProductPrice, byte[] groupBuyProductPicture,
			String groupBuyProductDescrip) {

		GroupproductVO groupproductVO = new GroupproductVO();

		groupproductVO.setGroupBuyProductPrice(groupBuyProductPrice);
		groupproductVO.setGroupBuyProductPicture(groupBuyProductPicture);
		groupproductVO.setGroupBuyProductDescrip(groupBuyProductDescrip);

		dao.insert(groupproductVO);

		return groupproductVO;
	}

//修改
	public GroupproductVO updateGroupproduct(Integer groupBuyProductPrice, byte[] groupBuyProductPicture, String groupBuyProductDescrip ,Integer groupBuyProductID ) {

		GroupproductVO groupproductVO = new GroupproductVO();
		
		groupproductVO.setGroupBuyProductPrice(groupBuyProductPrice);
		groupproductVO.setGroupBuyProductPicture(groupBuyProductPicture);
		groupproductVO.setGroupBuyProductDescrip(groupBuyProductDescrip);
		groupproductVO.setGroupBuyProductID(groupBuyProductID);

		dao.update(groupproductVO);
		return groupproductVO;
	}

//單一查詢
	public GroupproductVO getOneGroupproduct(Integer groupBuyProductID) {
		return dao.findByPrimaryKey(groupBuyProductID);
	}

//查詢全部
	public List<GroupproductVO> getAll() {
		return dao.getAll();
	}

	public void deleteGroupproduct(Integer groupBuyProductID) {
		dao.delete(groupBuyProductID);
	}

}
