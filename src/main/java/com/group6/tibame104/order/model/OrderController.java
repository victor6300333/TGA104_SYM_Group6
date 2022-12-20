package com.group6.tibame104.order.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
	@Autowired
	OrderService orderSvc;
}
