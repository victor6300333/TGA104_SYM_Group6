package com.search.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.ProductVO;
import com.product.service.ProductService;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doPost(req,res);
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		    req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html; charset=UTF-8");

		

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}

			/*
			 * 轉去 listAllProduct 頁面
			 */
			req.setAttribute("productVOall", productVOall);
			String url = "/front-end/product/listAllProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}


}
