package com.order.model;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
		Set<String> set = queryString.keySet();
		Iterator<String> it = set.iterator();
		int i = 0;
		
		while (it.hasNext()) {
			String next = it.next();

			if ("orderDate".equals(next)) {
				if(i==0)
					sb.append(" where " + next + " between " + queryString.get(next));
				else
					sb.append(" and" + queryString.get(next));
				
			} else if ("orderStatus".equals(next)) {
				sb.append(" && "+ next + "  " + queryString.get(next));
		
			}
			i++;
		}
		return dao.getAllByComposite(queryString);
	}
	

}
