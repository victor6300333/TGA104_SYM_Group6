package com.product.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.product.model.ProductVO;
import com.product.service.ProductService;

@WebServlet("/product/productSearchProduct")
public class ProductSearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String saveDirectory = "front-end/images";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = res.getWriter();
		
		/*queryString*/
		Map<String, String>  queryString = new HashMap<String,String>();
		
		/*JSON*/
		Gson gson = new Gson();
		
		/* 1. 請求參數的格式整理 */
		
		queryString.put("storeID", req.getParameter("storeID"));

		Integer productID = null;
		try {
			productID = Integer.valueOf(req.getParameter("productID").trim());
			queryString.put("productID", productID+"");
		} catch (Exception e) {
			System.out.println("錯誤");
		}


		Integer productSecID = null;
		try {
			productSecID = Integer.valueOf(req.getParameter("productSecID").trim());
			queryString.put("productSecID", productSecID+"");
		} catch (Exception e) {
			System.out.println("錯誤");
		}

		
		queryString.put("productStatus", req.getParameter("productStatus"));

		
		/***************************
		 * 搜尋資料
		 ***************************************/
		System.out.println("queryString = " + queryString);
		List<ProductVO> allByCond = new ProductService().getAllByCondFront(queryString);

		String json = gson.toJson(allByCond);
		writer.write(json);

	}

}
