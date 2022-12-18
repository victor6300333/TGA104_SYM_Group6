package com.coupon.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.coupon.model.CouponJDBCDAO;
import com.coupon.model.CouponService;
import com.coupon.model.CouponVO;
import com.google.gson.Gson;

@WebServlet("/CouponUpdate")
public class CouponUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);

		String str = req.getParameter("couponID");
		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("couponID不正確");
		}

		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/front-end/coupon/select_page.jsp");
			failureView.forward(req, res);
			return;
		}

		Integer couponID = null;
		try {
			couponID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("couponID無法轉換成整數");
		}
	
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/front-end/coupon/select_page.jsp");
			failureView.forward(req, res);
			return;
		}

		/*2*/
		CouponService couponSvc = new CouponService();
		CouponVO couponVO = couponSvc.getOneCoupon(couponID);
		if (couponVO == null) {
			errorMsgs.add("找不到");
		}

		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/front-end/coupon/select_page.jsp");
			failureView.forward(req, res);
			return;
		}

		/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
		req.setAttribute("couponVO", couponVO); // ��Ʈw���X��empVO����,�s�Jreq
		String url = "/back-end/coupon/updateCoupon2.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
		successView.forward(req, res);
	}


}
