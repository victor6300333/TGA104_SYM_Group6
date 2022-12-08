package com.orderlist.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.order.model.OrderService;
import com.order.model.OrderVO;
import com.orderlist.model.OrderlistService;
import com.orderlist.model.OrderlistVO;

//import redis.clients.jedis.Jedis;

@WebServlet("/front-end/comment/OrderlistServlet")
public class OrderlistServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");


	
		if ("update".equals(action)) {
			String buyerReview = req.getParameter("buyerReview");
			String buyerComment = req.getParameter("buyerComment");
			
		}
		
		
		
		if ("do_buyercomment".equals(action)) {

			String orderID = req.getParameter("orderID");
			OrderlistService orderlistService = new OrderlistService();	
			

			List<OrderlistVO> list = orderlistService.searchOrderlist(Integer.parseInt(orderID));
			req.setAttribute("list", list);
			String url = "/front-end/comment/addComment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); 
			successView.forward(req, res);
		}
		if ("update".equals(action)) {
			
			String index = req.getParameter("comment");
			String buyerReview = req.getParameter("buyerReview");
			String buyerComment = req.getParameter("buyerComment");
			String orderDetailID = req.getParameter("orderDetailID");
			String orderID = req.getParameter("orderID");
			String productID = req.getParameter("productID");
			String quantity = req.getParameter("quantity");
			String price = req.getParameter("price");
			String subTotal = req.getParameter("subTotal");
	
		
			
			OrderlistVO orderlistVO = new OrderlistVO();
			orderlistVO.setBuyerReview(buyerReview);
			orderlistVO.setBuyerComment(buyerComment);
//			orderlistVO.setShopComment("null");
//			orderlistVO.setShopComment("null");
			
			orderlistVO.setOrderDetailID(Integer.parseInt(orderDetailID));
			orderlistVO.setOrderID(Integer.parseInt(orderID));
			orderlistVO.setProductID(Integer.parseInt(productID));
			orderlistVO.setQuantity(Integer.parseInt(quantity));
			orderlistVO.setPrice(Integer.parseInt(price));
			orderlistVO.setSubTotal(Integer.parseInt(subTotal));
			
			
			
			OrderlistService orderlistService = new OrderlistService();
			orderlistService.updateOrderlist(orderlistVO);
			req.setAttribute("orderlistVO", orderlistVO);
			
			String url = "/front-end/comment/listComment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); 
			successView.forward(req, res);
			
		}
		
		
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
		
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer orderDetailID = Integer.valueOf(req.getParameter("orderDetailID"));
			Integer orderID = Integer.valueOf(req.getParameter("orderID"));
			Integer productID = Integer.valueOf(req.getParameter("productID"));
			Integer quantity = Integer.valueOf(req.getParameter("quantity"));
			Integer price = Integer.valueOf(req.getParameter("price"));
			Integer subTotal = Integer.valueOf(req.getParameter("subTotal"));

			String shopReview = req.getParameter("shopReview");
			String shopComment = req.getParameter("shopComment");
			String buyerReview = req.getParameter("buyerReview");
			String buyerComment = req.getParameter("buyerComment");

			// Send the use back to the form, if there were errors

			/*************************** 2.開始新增資料 ***************************************/
			OrderlistService orderlistSvc = new OrderlistService();
			OrderlistVO orderlistVO = new OrderlistVO();

			orderlistVO.setOrderDetailID(orderDetailID);
			orderlistVO.setOrderID(orderID);
			orderlistVO.setProductID(productID);
			orderlistVO.setQuantity(quantity);
			orderlistVO.setPrice(price);
			orderlistVO.setSubTotal(subTotal);
			orderlistVO.setShopReview(shopReview);
			orderlistVO.setShopComment(shopComment);
			orderlistVO.setBuyerReview(buyerReview);
			orderlistVO.setBuyerComment(buyerComment);
			
			orderlistSvc.addOrderlist(orderlistVO);
			
			req.setAttribute("orderlistVO", orderlistVO);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/comment/listComment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}


	}
}
