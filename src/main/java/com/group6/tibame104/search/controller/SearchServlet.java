package com.group6.tibame104.search.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group6.tibame104.orderlist.model.OrderlistService;
import com.group6.tibame104.orderlist.model.OrderlistVO;
import com.group6.tibame104.product.model.ProductVO;
import com.group6.tibame104.product.service.ProductService;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doPost(req,res);
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		    req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html; charset=UTF-8");
		    
		    String action = req.getParameter("action");
		
		if("getAll_For_Display".equals(action)) {

		    Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*
			 * 商品名稱取值
			 */
			String productName = req.getParameter("productName");

			List<ProductVO> productVOall;

			/*
			 * 搜尋 商品名稱 為空 全部 不為空 有條件
			 */
			if (productName.trim().length() == 0) {
				productVOall = new ProductService().getAll();
			} else {
				productVOall = new ProductService().getAll(productName);
			}

			/*
			 * 如果報錯 轉去 addProduct 頁面
			 */
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/product/addProduct.jsp");
				try {
					failureView.forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
				return;
			}

			/*
			 * 轉去 listAllProduct 頁面
			 */
			req.setAttribute("productVOall", productVOall);
			String url = "/front-end/product_detail/listAllProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		
		if("getOne_For_Display".equals(action)) {
			
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			String str = req.getParameter("productID");
			
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("productID", "請輸入正常的數字");
			}
 
			/*
			 * 如果報錯 轉去 addProduct 頁面
			 */
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/product/addProduct.jsp");
				try {
					failureView.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}

			Integer productID = null;
			try {
				productID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("productID", "請輸入正常的數字");
			}
			/*
			 * 如果報錯 轉去 addProduct 頁面
			 */
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/product/addProduct.jsp");
				try {
					failureView.forward(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}
			/*
			 * 取得資料
			 * 
			 */
			ProductVO productVO = new ProductService().findByPrimaryKey(productID);
			List<OrderlistVO> list = new OrderlistService().findByProductID(productID);
			/*
			 * 導向 listOneProduct頁面
			 */
			req.setAttribute("productVO", productVO);
			req.setAttribute("list", list);
			String url = "/front-end/product_detail/product_detail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
	}


}
