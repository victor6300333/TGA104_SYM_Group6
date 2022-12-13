package com.product.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.product.model.ProductVO;
import com.product.service.ProductService;

@WebServlet("/product/productUpdate")
public class ProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String saveDirectory = "front-end/images";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);

		System.out.println(req.getReader().readLine());
        Gson gson = new Gson();
        ProductVO fromJson = gson.fromJson(req.getReader(), ProductVO.class);
		System.out.println(fromJson);
		/* 1. 隢����撘��� */
		Integer productID = null;
		try {
			productID = fromJson.getProductID();
		} catch (NumberFormatException e) {
			productID = 0;
			errorMsgs.add("productID銝迤蝣�");
		}

		String productName = fromJson.getProductName();
		String productNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if (productName == null || productName.trim().length() == 0) {
			errorMsgs.add("����迂: 隢蝛箇");
		} else if (!productName.trim().matches(productNameReg)) {
			errorMsgs.add("����迂: ���銝� �摮�� �摮� _ , 銝摨虫�2-10銋��");
		}

		Integer productSec = null;
		try {
			productSec = fromJson.getProductSecID();
		} catch (NumberFormatException e) {
			productSec = 0;
			errorMsgs.add("���活����迤蝣�");
		}

		Integer productStock = null;
		try {
			productStock = fromJson.getProductStock();
		} catch (NumberFormatException e) {
			productStock = 0;
			errorMsgs.add("摨怠��‵�摮�");
		}

		Integer productPrice = null;
		try {
			productPrice = fromJson.getProductPrice();
		} catch (NumberFormatException e) {
			productPrice = 0;
			errorMsgs.add("����隢‵�摮�");
		}

		String productDesc = fromJson.getProductDesc();

		if (productDesc == null || productDesc.trim().length() == 0) {
			errorMsgs.add("����膩: 隢蝛箇");
		}

		String source = fromJson.getSource();

		if (source == null || source.trim().length() == 0) {
			errorMsgs.add("��: 隢蝛箇");
		}


		Boolean productStatus = fromJson.getProductStatus();

		if (new Integer(1).equals(productStatus)) {
			productStatus = true;
		} else {
			productStatus = false;
		}

		/* ����1 */
		/* getServletContext().getRealPath("front-end/images") */
		String realPath = getServletContext().getRealPath(saveDirectory);
//		System.out.println("realPath=" + realPath);
//		File fsaveDirectory = new File(realPath);
//		if (!fsaveDirectory.exists())
//			fsaveDirectory.mkdirs();
//
//		Collection<Part> parts = req.getParts();
//
//		List<String> pList = new ArrayList<String>();
//		List<byte[]> bList = new ArrayList<byte[]>();
//		for (Part part : parts) {
//			String filename = part.getSubmittedFileName();
//			if (filename != null && filename.length() != 0 && part.getContentType() != null) {
//				InputStream inputStream = part.getInputStream();
//				pList.add(part.getName());
//				bList.add(inputStream.readAllBytes());
//			}
//		}

		/* ����2 */
		ProductVO productVO = new ProductVO();
		productVO.setProductID(productID);
		productVO.setProductSecID(productSec);
		productVO.setProductName(productName);
		productVO.setProductStock(productStock);
		productVO.setProductPrice(productPrice);
		productVO.setProductDesc(productDesc);
		productVO.setSource(source);
//		if (pList.contains("upfile1")) {
//			productVO.setProductImg(bList.get(pList.indexOf("upfile1")));
//		}
//		if (pList.contains("upfile2")) {
//			productVO.setProductImg2(bList.get(pList.indexOf("upfile2")));
//		}
//		if (pList.contains("upfile3")) {
//			productVO.setProductImg3(bList.get(pList.indexOf("upfile3")));
//		}
		productVO.setProductStatus(productStatus);
		productVO.setCommentTotal(0);
		productVO.setCommentAvgStar(0.0);

		// Send the use back to the form, if there were errors
		/*
		 * 憒�� 頧 addProduct ��
		 */
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/front-end/product/addProduct.jsp");
			try {
				failureView.forward(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		/***************************
		 * 2.靽格鞈��
		 ***************************************/
		new ProductService().update(productVO);

		/*
		 * 撠�� listOneProduct��
		 */
		req.setAttribute("productVO", productVO);
		String url = "/front-end/product/updateProduct.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);

	}

}
