package com.orderlist.model;

import java.util.List;


public interface OrderlistDAO_interface {
	public void insert(OrderlistVO orderlistVO);
	
    public void update(OrderlistVO orderVO);

    public List<OrderlistVO> findByOrderID(Integer orderID);

}
