package com.administrator.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/back-end/administrator/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 取得前端使用者帳密
	 * */
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		
		/**
		 * 根據使用者查詢資料庫，如果沒有結果，說明用戶名稱不存在
		 * 如果查詢到了，再比對密碼，密碼不對，返回錯誤提示
		 * 密碼正確，跳轉到主頁
		 * admin, 666666
		 * */
		if ("admin".equals(username) && "666666".equals(password)) {
			// 密碼正確，跳轉到主頁
			req.setAttribute("username", username);
			req.getRequestDispatcher("/indexAdmin.jsp").forward(req, resp);
		} else {
			// 帳號或密碼錯誤
			req.setAttribute("username", username);
			req.setAttribute("error", "帳號或密碼錯誤, 請重新輸入!");
			req.getRequestDispatcher("/").forward(req, resp);
//			resp.sendRedirect("/loginAdm.jsp");
		}
		
	}
	
}
