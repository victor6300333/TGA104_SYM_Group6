package com.order.model;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	public List<OrderVO> getAllOrderByComposite(Map<String, String> queryString ) {
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<String, String>> it = queryString.entrySet().iterator();
		int i = 0;
		
		while (it.hasNext()) {
			Entry<String, String> next = it.next();

			if ("orderDate".equals(next.getKey())) {
				if(i==0)
					sb.append(" where " + next.getKey() + " between " + next.getValue());
				else
					sb.append(" and" + next.getValue());
				
			} else if ("orderStatus".equals(next.getKey())) {
				sb.append(" && "+ next.getKey() + " = " + next.getValue());
		
			}
			i++;
		}
		return dao.getAllByComposite(queryString);
	}
	

}
