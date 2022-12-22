package com.group6.tibame104.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.order.model.OrderService;
import com.group6.tibame104.order.model.OrderVO;

@Controller
@RequestMapping("/front-end/order")
public class OrderController {
	@Autowired
	OrderService orderSvc;
	
	
	@PostMapping("/select_by_OrderID")
    public String selectByOrderID(Model model, @RequestParam("orderID") String str) {
		Integer orderID = Integer.valueOf(str);
		
		
		OrderVO orderVO_orderID = orderSvc.getOrder(orderID);
		
		model.addAttribute("orderVO_orderID", orderVO_orderID); // 資料庫取出的empVO物件,存入req
		model.addAttribute("orderID", orderID); 
		return "front-end/order/listOrder_One";
		
	}
	
	@PostMapping("/select_Order")
	public String selectOrder(Model model, @RequestParam Map<String,String> map
			) {
		
		
		List<OrderVO> list  = orderSvc.getAllOrderByComposite(map);
		model.addAttribute("list", list);
	
				return "/front-end/order/listOrder";
		
	}
}
