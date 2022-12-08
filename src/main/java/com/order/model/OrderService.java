package com.order.model;

import java.sql.Date;
import java.util.List;

import com.orderlist.model.OrderlistVO;
import com.orderlist.model.Product;

public class OrderService {
	private OrderDAO_interface dao;

	public OrderService() {
		dao = new OrderDAO();
	}

	public void addOrder(OrderVO orderVO, List<OrderlistVO> buylist) {
		dao.insert(orderVO, buylist);
		
	}


	public OrderVO getOrder(Integer orderID) {
	
		return dao.getbyOrderID(orderID);
	}
	public List<OrderVO> getAllOrder() {
		return dao.getAll();
	}

}
