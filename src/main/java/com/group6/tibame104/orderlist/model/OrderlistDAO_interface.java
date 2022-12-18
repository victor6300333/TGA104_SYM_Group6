package com.group6.tibame104.orderlist.model;

import java.util.List;


public interface OrderlistDAO_interface {
	public void insert(OrderlistVO orderlistVO);
	
    public void update(Integer orderDetailID, String buyerReview, String buyerComment);

    public List<OrderlistVO> findByOrderID(Integer orderID);
    
    public OrderlistVO findByOrderlistID(Integer orderlistID);

}
