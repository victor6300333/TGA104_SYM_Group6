package com.group6.tibame104.orderlist.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.group6.tibame104.orderlist.model.OrderlistService;
import com.group6.tibame104.orderlist.model.OrderlistVO;

//import redis.clients.jedis.Jedis;

@WebServlet("/front-end/comment/OrderlistServlet")
public class OrderlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	OrderlistService orderlistSvc;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

	
		
		if ("do_buyercomment".equals(action)) {

			Integer orderID = Integer.parseInt(req.getParameter("orderID"));
			
			

			List<OrderlistVO> list = orderlistSvc.searchOrderlist(orderID);
			req.setAttribute("list", list);
			String url = "/front-end/comment/addComment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); 
			successView.forward(req, res);
		}
		if ("update".equals(action)) {
			
			String index = req.getParameter("comment");
			String buyerReview = req.getParameter("buyerReview");
			String buyerComment = req.getParameter("buyerComment");
			Integer orderDetailID = Integer.parseInt(req.getParameter("orderDetailID"));
			
		
			
			
		
		
			orderlistSvc.updateOrderlist(orderDetailID, buyerReview, buyerComment);
			
			OrderlistVO orderlistVO = orderlistSvc.findByOrderlistID(orderDetailID);
		
			
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
