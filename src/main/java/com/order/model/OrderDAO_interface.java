package com.order.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.orderlist.model.OrderlistVO;

//import com.emp.model.EmpVO;

public interface OrderDAO_interface {
	
	 public void insert(OrderVO orderVO, List<OrderlistVO> buylist);

   
     public OrderVO getbyOrderID(Integer orderID);
     
     public List<OrderVO> getAll();
     
     public List<OrderVO> getAllByComposite(Map<String, String> queryString );

     
}
