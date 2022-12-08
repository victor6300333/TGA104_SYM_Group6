package com.product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.product.service.ProductService;

@WebServlet("/product/productPutOff")
public class ProductPutOff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter writer = res.getWriter();
		Integer productID = null;

		try {
			productID = Integer.valueOf(req.getParameter("productID").trim());
		} catch (Exception e) {
			productID = 0;
		}
		Gson gson = new Gson();
		ProductService productService = new ProductService();
		writer.write(gson.toJson(productService.putOff(productID)));

	}

}
