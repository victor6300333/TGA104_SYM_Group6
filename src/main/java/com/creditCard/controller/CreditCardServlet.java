package com.creditCard.controller;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.creditCard.model.CreditCardService;
import com.creditCard.model.CreditCardVO;
import com.member.model.MemberService;
import com.member.model.MemberVO;
import com.creditCard.model.*;

@WebServlet("/member/CreditCardServlet")
public class CreditCardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			CreditCardService cardSvc = new CreditCardService();

			String creditCardNumber = req.getParameter("creditCardNumber");
			String securityCode = req.getParameter("securityCode").trim();
			java.sql.Date exDate = null;
			exDate = java.sql.Date.valueOf(req.getParameter("exDate"));
			Integer creditCardId = Integer.valueOf(req.getParameter("creditCardId"));

			CreditCardVO cardVO = new CreditCardVO();
			cardVO.setCreditCardNumber(creditCardNumber);
			cardVO.setSecurityCode(securityCode);
			cardVO.setExDate(exDate);
			cardVO.setCreditCardId(creditCardId);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("cardVO", cardVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/member/update_member_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			cardVO = cardSvc.updateCreditCard(creditCardNumber, securityCode, exDate, creditCardId);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("cardVO", cardVO); // 資料庫update成功後,正確的的memVO物件,存入req
			String url = "/front-end/member/register2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);

		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			Integer memberId = Integer.valueOf(req.getParameter("memberId"));
			String creditCardNumber = req.getParameter("creditCardNumber").trim();
			String securityCode = req.getParameter("securityCode").trim();

			java.sql.Date exDate = null;

			exDate = java.sql.Date.valueOf(req.getParameter("exDate"));

			MemberVO memVO = new MemberVO();
			CreditCardVO cardVO = new CreditCardVO();
			cardVO.setMemberId(memberId);
			cardVO.setCreditCardNumber(creditCardNumber);
			cardVO.setSecurityCode(securityCode);
			cardVO.setExDate(exDate);

			// Send the use back to the form, if there were errors
			req.setAttribute("cardVO", cardVO); // 含有輸入格式錯誤的empVO物件,也存入req
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/login.jsp");

				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			CreditCardService cardSvc = new CreditCardService();
//			System.out.println("memberID = " + memberID);
			cardVO = cardSvc.addCreditCard(memberId, creditCardNumber, securityCode, exDate);

			MemberService memSvc = new MemberService();
			memVO = memSvc.getOneMem(memberId);

			req.setAttribute("memVO2", memVO);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/front-end/member/my-account.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交register2.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer creditCardId = Integer.valueOf(req.getParameter("creditCardId"));
			Integer memberId = Integer.valueOf(req.getParameter("memberId"));

			MemberVO memVO = new MemberVO();
			memVO.setMemberId(memberId);

			/*************************** 2.開始刪除資料 ***************************************/
			CreditCardService cardSvc = new CreditCardService();
			cardSvc.deletecreditCard(creditCardId);
			MemberService memSvc = new MemberService();
			memVO = memSvc.getOneMem(memberId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			req.setAttribute("memVO2", memVO);
			String url = "/front-end/member/my-account.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

	}

}
