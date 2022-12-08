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

@WebServlet("/back-end/administrator/AdministratorServlet")
public class AdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("memberID");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入會員編號");
				}

			// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/ad/select_page2.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				Integer memberID = null;

				try {
					memberID = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/ad/select_page2.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
			/*************************** 2.開始查詢資料 *****************************************/
			AdministratorService adminSvc = new AdministratorService();
			AdministratorVO AdministratorVO = adminSvc.getOneAd(memberID);
				if (AdministratorVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/ad/select_page2.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("AdministratorVO", AdministratorVO); // 資料庫取出的advVO物件,存入req
			String url = "/back-end/administrator/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
Integer memberID = Integer.valueOf(req.getParameter("memberID"));
			/*************************** 2.開始查詢資料 ****************************************/
			AdministratorService adminSvc = new AdministratorService();
			AdministratorVO AdministratorVO = adminSvc.getOneAd(memberID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("AdministratorVO", AdministratorVO); // 資料庫取出的advVO物件,存入req
			String url = "/back-end/ad/update_ad_input2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
Integer storeAuditStatus = Integer.valueOf(req.getParameter("storeAuditStatus").trim());


			AdministratorVO AdministratorVO = new AdministratorVO();
			
			AdministratorVO.setStoreAuditStatus(storeAuditStatus);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("AdministratorVO", AdministratorVO); // 含有輸入格式錯誤的advVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/ad/update_ad_input2.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			AdministratorService adminSvc = new AdministratorService();
			AdministratorVO = adminSvc.updateAd(storeAuditStatus);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("AdministratorVO", AdministratorVO); // 資料庫update成功後,正確的的advVO物件,存入req
			String url = "/back-end/administrator/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

	}	
}
