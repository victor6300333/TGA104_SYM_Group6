package com.administrator.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.administrator.model.AdministratorService;
import com.administrator.model.AdministratorVO;

@WebServlet("/administrator/AdministratorServlet")
public class AdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("administratorID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入管理員編號");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/administrator/listAllAdmin.jsp");
				failureView.forward(req, res);
				return;
			}
			Integer administratorID = null;
			try {
				administratorID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/administrator/listAllAdmin.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始查詢資料 *****************************************/

			AdministratorService adminSvc = new AdministratorService();
			AdministratorVO administratorVO = adminSvc.getOneAdmin(administratorID);
			if (administratorID == null) {
				errorMsgs.add("查無資料");
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/

			req.setAttribute("administratorVO", administratorVO);
			String url = "/back-end/administrator/update_admin_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// update_admin_input.jsp
			successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // listAllAdmin.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer administratorID = Integer.valueOf(req.getParameter("administratorID"));
				
				/***************************2.開始查詢資料 *****************************************/
				AdministratorService adminSvc = new AdministratorService();
				AdministratorVO administratorVO = adminSvc.getOneAdmin(administratorID);
								
				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("administratorVO", administratorVO);        
				String url = "/back-end/administrator/update_admin_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // update_admin_input.jsp
				successView.forward(req, res);
		}
		

		if ("update".equals(action)) { // update_admin_input.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer administratorID = Integer.valueOf(req.getParameter("administratorID"));
			String administratorPassword = req.getParameter("administratorPassword");
			String administratorAccount = req.getParameter("administratorAccount");
			String administratorName = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (administratorName == null || administratorName.trim().length() == 0) {
				errorMsgs.add("請勿空白");
			} else if (!administratorName.trim().matches(administratorName)) { // (regular-expression)
				errorMsgs.add("格式不正確");
			}

			AdministratorVO administratorVO = new AdministratorVO();
			administratorVO.setAdministratorID(administratorID);
			administratorVO.setAdministratorPassword(administratorPassword);
			administratorVO.setAdministratorAccount(administratorAccount);
			administratorVO.setAdministratorName(administratorName);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("administratorVO", administratorVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/administrator/update_admin_input.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始查詢資料 ****************************************/

			AdministratorService adminSvc = new AdministratorService();
			administratorVO = adminSvc.updateAdmin(administratorName, administratorAccount, administratorName);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/

			req.setAttribute("administratorVO", administratorVO); //
			String url = "/back-end/administrator/listAllAdmin.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); //
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // addAdmin.jsp
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer administratorID = Integer.valueOf(req.getParameter("administratorID"));
			String administratorName = req.getParameter("administratorName");
			String administratorAccount = req.getParameter("administratorAccount");
			String administratorPassword = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (administratorPassword == null || administratorPassword.trim().length() == 0) {
				errorMsgs.add("請勿空白");
			} else if (!administratorPassword.trim().matches(administratorPassword)) { // (regular-expression)
				errorMsgs.add("格式不正確");
			}

			AdministratorVO administratorVO = new AdministratorVO();
			administratorVO.setAdministratorID(administratorID);
			administratorVO.setAdministratorName(administratorName);
			administratorVO.setAdministratorAccount(administratorAccount);
			administratorVO.setAdministratorPassword(administratorPassword);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("administratorVO", administratorVO); // addAdmin.jsp
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/administrator/addAdmin.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始修改資料 *****************************************/
			AdministratorService adminSvc = new AdministratorService();
			administratorVO = adminSvc.updateAdmin(administratorName, administratorAccount, administratorName);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			String url = "/back-end/administrator/listAllAdmin.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // listAllAdmin.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // listAllAdmin.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer administratorID = Integer.valueOf(req.getParameter("administratorID"));

			/*************************** 2.開始刪除資料 ***************************************/
			AdministratorService adminSvc = new AdministratorService();
			adminSvc.delete(administratorID);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/administrator/listAllAdmin.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
	}
}
