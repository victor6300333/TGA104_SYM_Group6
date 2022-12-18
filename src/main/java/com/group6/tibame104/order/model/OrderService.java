package com.group6.tibame104.order.model;

import java.util.List;
import java.util.Map;

import com.group6.tibame104.orderlist.model.OrderlistVO;

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
	public List<OrderVO> getAllOrderByComposite(Map<String, String[]> map ) {
		

		return  dao.getAllByComposite( map );
	}
	

}
