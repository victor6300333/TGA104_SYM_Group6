package com.orderlist.model;

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
	
	public void updateOrderlist(OrderlistVO orderlistVO) {

		dao.update(orderlistVO);

	}
}
