package com.member.controller;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.member.model.*;

@WebServlet("/member/MemberServlet")
@MultipartConfig(fileSizeThreshold = 100 * 1024 * 1024, maxFileSize = 100 * 1024 * 1024, maxRequestSize = 100 * 100
		* 1024 * 1024)
// 當數據量大於fileSizeThreshold值時，內容將被寫入磁碟 (一段(1m)一段存，避免斷線)
// 上傳過程中無論是單個文件超過maxFileSize值，或者上傳的總量大於maxRequestSize 值都會拋出IllegalStateException 異常(檔案大小限制)
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("memberId");
//			if (str == null || (str.trim()).length() == 0) {
//				errorMsgs.add("請輸入員工編號");
//			}
			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/emp/select_page.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}

			Integer memberId = null;
//			try {
			memberId = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.add("員工編號格式不正確");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/emp/select_page.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}

			/*************************** 2.開始查詢資料 *****************************************/
			MemberService memSvc = new MemberService();
			MemberVO memVO = memSvc.getOneMem(memberId);
//			if (memVO == null) {
//				errorMsgs.add("查無資料");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/emp/select_page.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("memVO", memVO); // 資料庫取出的empVO物件,存入req
			String url = "/member/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer memberId = Integer.valueOf(req.getParameter("memberId"));

			/*************************** 2.開始查詢資料 ****************************************/
			MemberService memSvc = new MemberService();
			MemberVO memVO = memSvc.getOneMem(memberId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("memVO", memVO); // 資料庫取出的empVO物件,存入req
			String url = "/member/update_member_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			MemberService memSvc = new MemberService();

			String gender = req.getParameter("gender");

			java.sql.Date birthday = null;
			try {
				birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
			} catch (IllegalArgumentException e) {
				birthday = null;
				errorMsgs.add("請輸入日期!");
			}

			byte[] userPhoto = null;

			// 圖片相關
			Part part = req.getPart("userPhoto");
			if (part.getSize() == 0) {
				userPhoto = null;
			} else {
				InputStream in = part.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(in);
				userPhoto = new byte[bis.available()];
				bis.read(userPhoto);
				bis.close();
				in.close();
			}

			Boolean mailCertification = false;

			String idNumber = req.getParameter("idNumber").trim(); // ^[A-Z]\d{9}$
			String idNumberReg = "^[A-Z]\\d{9}$";
			if (idNumber == null || idNumber.trim().length() == 0) {
				idNumber = "";
			} else if (!idNumber.trim().matches(idNumberReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("請輸入正確的身分證字號");
			}

			String address = req.getParameter("address").trim();

			Boolean sellerAuditApprovalState = false;

			Integer currentShoppingCoin = 0;

			Integer memberId = memSvc.getOne();

			String mail = req.getParameter("mail");

			MemberVO memVO = new MemberVO();
			memVO.setGender(gender);
			memVO.setBirthday(birthday);
			memVO.setUserPhoto(userPhoto);
			memVO.setMailCertification(mailCertification);
			memVO.setIdNumber(idNumber);
			memVO.setAddress(address);
			memVO.setSellerAuditApprovalState(sellerAuditApprovalState);
			memVO.setCurrentShoppingCoin(currentShoppingCoin);
			memVO.setMemberId(memberId);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/register2.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			memSvc.updateMember(memberId, gender, birthday, userPhoto, mailCertification, idNumber, address,
					sellerAuditApprovalState, currentShoppingCoin);

			memVO = memSvc.loginOneMem(mail);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/

			HttpSession session = req.getSession();
			session.setAttribute("memVO", memVO); // 資料庫update成功後,正確的的memVO物件,存入req
			String url = "/front-end/member/my-account.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);

		}

		if ("updateOne".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			MemberService memSvc = new MemberService();

			String userName = req.getParameter("userName");
			String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (userName == null || userName.trim().length() == 0) {
				errorMsgs.add("使用者姓名: 請勿空白");
			} else if (!userName.trim().matches(userNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("使用者姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String userAccount = req.getParameter("userAccount");
			String userAccountReg = "^[(a-zA-Z0-9_)]{5,10}$";
			if (userAccount == null || userAccount.trim().length() == 0) {
				errorMsgs.add("使用者帳號: 請勿空白");
			} else if (!userAccount.trim().matches(userAccountReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("使用者帳號: 只能是英文字母、數字和_ , 且長度必需在5到10之間");
			}

			String phone = req.getParameter("phone");
			String phoneReg = "^09\\d{8}$";
			if (phone == null || phone.trim().length() == 0) {
				phone = "";
			} else if (!phone.trim().matches(phoneReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("請輸入正確的手機號碼");
			}

			String mail = req.getParameter("mail");
			String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
			if (mail == null || mail.trim().length() == 0) {
				errorMsgs.add("使用者信箱: 請勿空白");
			} else if (!mail.trim().matches(mailReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("請輸入正確的信箱格式！");
			}

			byte[] userPhoto = null;
			// 圖片相關
			Part part = req.getPart("userPhoto");
			if (part.getSize() == 0) {
				userPhoto = null;
			} else {
				InputStream in = part.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(in);
				userPhoto = new byte[bis.available()];
				bis.read(userPhoto);
				bis.close();
				in.close();
			}

			Integer memberId = Integer.valueOf(req.getParameter("memberId"));

			MemberVO memVO = new MemberVO();
			memVO.setUserName(userName);
			memVO.setUserAccount(userAccount);
			memVO.setPhone(phone);
			memVO.setMail(mail);
			memVO.setUserPhoto(userPhoto);
			memVO.setMemberId(memberId);

			HttpSession session = req.getSession();

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				session.setAttribute("memVO", memVO);// 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/my-account.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			memVO = memSvc.updateOneMember(memberId, userName, userAccount, phone, mail, userPhoto);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			session.setAttribute("memVO", memVO); // 資料庫update成功後,正確的的memVO物件,存入req
			String url = "/front-end/member/my-account.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);

		}

		if ("updateOnePassword".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			MemberService memSvc = new MemberService();

			String userPassword = req.getParameter("userPassword").trim();
//			System.out.println("userPassword = " + userPassword);
			String userPasswordReg = "^[(a-zA-Z0-9)]{2,10}$";
			if (userPassword == null || userPassword.trim().length() == 0) {
				errorMsgs.add("使用者密碼: 請勿空白");
			} else if (!userPassword.trim().matches(userPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("使用者密碼: 只能是英文字母和數字 , 且長度必需在2到10之間");
			}

			Integer memberId = Integer.valueOf(req.getParameter("memberId"));

			MemberVO memVO = new MemberVO();
			memVO.setMemberId(memberId);
			memVO.setUserPassword(userPassword);

			HttpSession session = req.getSession();

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/my-account.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			memSvc.updateMemberPassword(memberId, userPassword);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
//			session.setAttribute("memVO", memVO); // 資料庫update成功後,正確的的memVO物件,存入req
			String url = "/front-end/member/my-account.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);

		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String userAccount = req.getParameter("userAccount").trim();
			String userAccountReg = "^[(a-zA-Z0-9_)]{5,10}$";
			if (userAccount == null || userAccount.trim().length() == 0) {
				errorMsgs.add("使用者帳號: 請勿空白");
			} else if (!userAccount.trim().matches(userAccountReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("使用者帳號: 只能是英文字母、數字和_ , 且長度必需在5到10之間");
			}

			String userPassword = req.getParameter("userPassword").trim();
//			System.out.println("userPassword = " + userPassword);
			String userPasswordReg = "^[(a-zA-Z0-9)]{2,10}$";
			if (userPassword == null || userPassword.trim().length() == 0) {
				errorMsgs.add("使用者密碼: 請勿空白");
			} else if (!userPassword.trim().matches(userPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("使用者密碼: 只能是英文字母和數字 , 且長度必需在2到10之間");
			}

			String userName = req.getParameter("userName").trim();
			String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (userName == null || userName.trim().length() == 0) {
				errorMsgs.add("使用者姓名: 請勿空白");
			} else if (!userName.trim().matches(userNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("使用者姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String phone = req.getParameter("phone").trim();
			String phoneReg = "^09\\d{8}$";
			if (phone == null || phone.trim().length() == 0) {
				phone = "";
			} else if (!phone.trim().matches(phoneReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("請輸入正確的手機號碼");
			}
//				
			String mail = req.getParameter("mail").trim();
			String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
			if (mail == null || mail.trim().length() == 0) {
				errorMsgs.add("使用者信箱: 請勿空白");
			} else if (!mail.trim().matches(mailReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("請輸入正確的信箱格式！");
			}

			// 獲得時間戳記
			Timestamp registrationTime = new Timestamp(System.currentTimeMillis());// 獲取系統當前時間
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr = df.format(registrationTime);
			registrationTime = Timestamp.valueOf(timeStr);

			Boolean mailCertification = false;
			Boolean sellerAuditApprovalState = false;
			Integer currentShoppingCoin = 0;

			MemberVO memVO = new MemberVO();
			memVO.setUserAccount(userAccount);
			memVO.setUserPassword(userPassword);
			memVO.setUserName(userName);
			memVO.setPhone(phone);
			memVO.setMail(mail);
			memVO.setRegistrationTime(registrationTime);
			memVO.setMailCertification(mailCertification);
			memVO.setSellerAuditApprovalState(sellerAuditApprovalState);
			memVO.setCurrentShoppingCoin(currentShoppingCoin);
			// Send the use back to the form, if there were errors
			req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/login.jsp");

				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			MemberService memSvc = new MemberService();
//			System.out.println("memberID = " + memberID);
			memVO = memSvc.addMember(userAccount, userPassword, userName, phone, mail, registrationTime,
					mailCertification, sellerAuditApprovalState, currentShoppingCoin);

			req.setAttribute("memVO", memVO);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/front-end/member/register2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交register2.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer memberId = Integer.valueOf(req.getParameter("memberId"));

			/*************************** 2.開始刪除資料 ***************************************/
			MemberService memSvc = new MemberService();
			memSvc.deleteMember(memberId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/member/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

		if ("getOne_For_Login".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs1 = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs1", errorMsgs1);

			/*************************** 1.接收請求參數 ****************************************/
			String mail = req.getParameter("mail").trim();
			String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
			if (mail == null || mail.trim().length() == 0) {
				errorMsgs1.add("使用者信箱: 請勿空白");
			} else if (!mail.trim().matches(mailReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs1.add("請輸入正確的信箱格式！");
			}

			String userPassword = req.getParameter("userPassword").trim();
			String userPasswordReg = "^[(a-zA-Z0-9)]{2,10}$";
			if (userPassword == null || userPassword.trim().length() == 0) {
				errorMsgs1.add("使用者密碼: 請勿空白");
			} else if (!userPassword.trim().matches(userPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs1.add("使用者密碼: 只能是英文字母和數字 , 且長度必需在2到10之間");
			}

			MemberVO memVO = new MemberVO();
			memVO.setMail(mail);
			memVO.setUserPassword(userPassword);

			// Send the use back to the form, if there were errors
			if (!errorMsgs1.isEmpty()) {
				req.setAttribute("memVO2", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/login.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			MemberService memSvcLogin = new MemberService();

			System.out.println(memSvcLogin.getOneForLogin(mail, userPassword));
			if (!(memSvcLogin.getOneForLogin(mail, userPassword))) { // 【帳號 , 密碼無效時】

				errorMsgs1.add("使用者帳號或密碼錯誤");
				if (!errorMsgs1.isEmpty()) {
					req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/login.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

			} else { // 【帳號 , 密碼有效時, 才做以下工作】
				HttpSession session = req.getSession();
				session.setAttribute("mail", mail); // *工作1: 才在session內做已經登入過的標識

				try {
					String location = (String) session.getAttribute("location");
					if (location != null) {
						session.removeAttribute("location"); // *工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
						res.sendRedirect(location);
						return;
					}
				} catch (Exception ignored) {
				}

				MemberService memSvc = new MemberService();
				memVO = memSvc.loginOneMem(mail);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				session.setAttribute("memVO", memVO); // 資料庫取出的empVO物件,存入req
				res.sendRedirect(req.getContextPath() + "/front-end/member/my-account.jsp"); // *工作3:
																								// (-->如無來源網頁:則重導至login_success.jsp)
			}

		}

		if ("getOne_For_LogOut".equals(action)) {

			HttpSession session = req.getSession();
			// 登出操作，清除用戶的登入狀態
			session.removeAttribute("mail");

			// 重定向到登入頁面
			res.sendRedirect(req.getContextPath() + "/front-end/member/login.jsp");

		}

	}

}
