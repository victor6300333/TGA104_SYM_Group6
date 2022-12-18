package com.group6.tibame104.product.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group6.tibame104.product.model.ProductVO;
import com.group6.tibame104.product.service.ProductService;

@WebServlet("/product/productGetOne")
public class ProductGetOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
		req.setAttribute("errorMsgs", errorMsgs);

		String str = req.getParameter("productID");
		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.put("productID", "請輸入正常的數字");
		}

		/*
		 * 如果報錯 轉去 Error 頁面
		 */
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/front-end/store/Error.jsp");
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
		 * 如果報錯 轉去 Error 頁面
		 */
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/front-end/store/Error.jsp");
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

		/* 
		 * 導向 productUpdate頁面
		 */
		req.setAttribute("productVO", productVO);
		String url = "/front-end/product/updateProduct.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
	}

}
