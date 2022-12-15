package com.order.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import java.util.LinkedHashMap;
//import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.order.model.OrderService;
import com.order.model.OrderVO;
import com.product.model.ProductVO;
import com.product.service.ProductService;

@WebServlet("/front-end/order/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("select_Order".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
		
			req.setAttribute("errorMsgs", errorMsgs);
			Map<String, String[]> map = req.getParameterMap();
			OrderService orderSvc = new OrderService();
			List<OrderVO> list  = orderSvc.getAllOrderByComposite(map);
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				
//				Integer orderID = Integer.valueOf(req.getParameter("orderID"));
//				Map<String, String> queryString = new LinkedHashMap<String, String>();
//				
//				Date orderfromdate = Date.valueOf(req.getParameter("fromdate").trim());
//				Timestamp fromdate = new Timestamp(orderfromdate.getTime());
//		
//					queryString.put("orderDate", "" + fromdate);
//			
//				Date ordertodate = Date.valueOf(req.getParameter("todate").trim()); 
//				Timestamp todate = new Timestamp(ordertodate.getTime());
//					queryString.put("orderDate", "" + todate);
//			
//			
//				Integer status =Integer.parseInt(req.getParameter("status")) ;
//			
//					queryString.put("orderStatus", "" + status);
//				
//				
//				
						
			
			
					
					req.setAttribute("list", list);
					String url = "/front-end/order/listOrder.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
					successView.forward(req, res);
					System.out.println("哈哈");
				
//				OrderVO orderVO = orderSvc.getOrder(orderID,orderfromdate,ordertodate,todate,status);

				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			// 資料庫取出的empVO物件,存入req
//				req.setAttribute("orderID", orderID); // 資料庫取出的empVO物件,存入req
//				String url = "/front-end/order/listOrder.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//				successView.forward(req, res);
		}
		if ("select_by_OrderID".equals(action)) {
			Integer orderID = Integer.parseInt(req.getParameter("orderID"));
			
			OrderService orderSvc = new OrderService();
			OrderVO orderVO_orderID = orderSvc.getOrder(orderID);
			
			req.setAttribute("orderVO_orderID", orderVO_orderID); // 資料庫取出的empVO物件,存入req
			req.setAttribute("orderID", orderID); 
			String url = "/front-end/order/listOrder_One.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}
		}
	}


