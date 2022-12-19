package com.group6.tibame104.orderlist.model;

import java.util.List;

public class OrderlistService {
	private OrderlistDAO_interface dao;

	public OrderlistService() {
		dao = new OrderlistDAO();
	}

	public void addOrderlist(OrderlistVO orderlistVO) {

		dao.insert(orderlistVO);

	}

	public List<OrderlistVO> searchOrderlist(Integer orderID) {
		
		return dao.findByOrderID(orderID);

	}
	
	public void updateOrderlist(Integer orderDetailID, String buyerReview, String buyerComment) {

		dao.update(orderDetailID, buyerReview, buyerComment);

	}
	
	public OrderlistVO findByOrderlistID(Integer OrderlistID) {
		
		return dao.findByOrderlistID(OrderlistID);
		
	}
	public List<OrderlistVO> findByProductID(Integer productID) {
		
		return dao.findByProductID(productID);
		
	}
}
