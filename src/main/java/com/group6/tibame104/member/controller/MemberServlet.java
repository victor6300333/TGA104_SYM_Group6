package com.group6.tibame104.member.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import com.group6.tibame104.member.model.MailService;
import com.group6.tibame104.member.model.MemberService;
import com.group6.tibame104.member.model.MemberVO;
import com.group6.tibame104.store.model.StoreJDBCDAO;
import com.group6.tibame104.store.model.StoreVO;

import redis.clients.jedis.Jedis;

@WebServlet("/member/MemberServlet")
@MultipartConfig(fileSizeThreshold = 100 * 1024 * 1024, maxFileSize = 100 * 1024 * 1024, maxRequestSize = 100 * 100
		* 1024 * 1024)
// 當數據量大於fileSizeThreshold值時，內容將被寫入磁碟 (一段(1m)一段存，避免斷線)
// 上傳過程中無論是單個文件超過maxFileSize值，或者上傳的總量大於maxRequestSize 值都會拋出IllegalStateException 異常(檔案大小限制)
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MemberService memSvc;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 後台使用

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("memberID");

			Integer memberID = null;
			memberID = Integer.valueOf(str);

			/*************************** 2.開始查詢資料 *****************************************/
			MemberVO memVO = memSvc.getOneMem(memberID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			session.setAttribute("memVO", memVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/member/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 後台使用

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer memberID = Integer.valueOf(req.getParameter("memberID"));

			/*************************** 2.開始查詢資料 ****************************************/
			MemberVO memVO = memSvc.getOneMem(memberID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("memVO", memVO); // 資料庫取出的empVO物件,存入req
			String url = "/member/update_member_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("updateOne".equals(action)) { // 會員中心修改會員資料

			List<String> errorMsgsForupdate = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgsForupdate);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String userName = req.getParameter("userName");
			String userNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (userName == null || userName.trim().length() == 0) {
				errorMsgsForupdate.add("使用者姓名: 請勿空白");
			} else if (!userName.trim().matches(userNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgsForupdate.add("使用者姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String userAccount = req.getParameter("userAccount");
			String userAccountReg = "^[(a-zA-Z0-9_)]{5,10}$";
			if (userAccount == null || userAccount.trim().length() == 0) {
				errorMsgsForupdate.add("使用者帳號: 請勿空白");
			} else if (!userAccount.trim().matches(userAccountReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgsForupdate.add("使用者帳號: 只能是英文字母、數字和_ , 且長度必需在5到10之間");
			}

			String phone = req.getParameter("phone");
			String phoneReg = "^09\\d{8}$";
			if (phone == null || phone.trim().length() == 0) {
				phone = "";
			} else if (!phone.trim().matches(phoneReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgsForupdate.add("請輸入正確的手機號碼");
			}

			String mail = req.getParameter("mail");
			String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
			if (mail == null || mail.trim().length() == 0) {
				errorMsgsForupdate.add("使用者信箱: 請勿空白");
			} else if (!mail.trim().matches(mailReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgsForupdate.add("請輸入正確的信箱格式！");
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

			String idNumber = req.getParameter("idNumber").trim(); // ^[A-Z]\d{9}$
			String idNumberReg = "^[A-Z]\\d{9}$";
			if (idNumber == null || idNumber.trim().length() == 0) {
				idNumber = "";
			} else if (!idNumber.trim().matches(idNumberReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgsForupdate.add("請輸入正確的身分證字號");
			}

			String address = req.getParameter("address").trim();

			Integer memberID = Integer.valueOf(req.getParameter("memberID"));

			MemberVO memVO = new MemberVO();
			memVO.setUserName(userName);
			memVO.setUserAccount(userAccount);
			memVO.setPhone(phone);
			memVO.setMail(mail);
			memVO.setUserPhoto(userPhoto);
			memVO.setIdNumber(idNumber);
			memVO.setAddress(address);
			memVO.setMemberID(memberID);

			HttpSession session = req.getSession();

			// Send the use back to the form, if there were errors
			if (!errorMsgsForupdate.isEmpty()) {
				session.setAttribute("memVO", memVO);// 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/my-account.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			memSvc.updateOneMember(memberID, userName, userAccount, phone, mail, userPhoto, idNumber, address);
			memVO = memSvc.loginOneMem(mail);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			session.setAttribute("memVO", memVO); // 資料庫update成功後,正確的的memVO物件,存入req
			String url = "/front-end/member/my-account.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);

		}

		if ("updateOnePassword".equals(action)) { // 修改密碼

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer memberID = Integer.valueOf(req.getParameter("memberID"));
			MemberVO memVO = new MemberVO();
			memVO = memSvc.getOneMem(memberID);

			String userPassword = req.getParameter("userPassword").trim();
//			System.out.println("userPassword = " + userPassword);
			String userPasswordReg = "^[(a-zA-Z0-9)]{2,10}$";
			if (userPassword == null || userPassword.trim().length() == 0) {
				errorMsgs.add("使用者密碼: 請勿空白");
			} else if (!userPassword.trim().matches(userPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("使用者密碼: 只能是英文字母和數字 , 且長度必需在2到10之間");
			}

			String oldPassword = req.getParameter("oldPassword").trim();
			if (!(memVO.getUserPassword()).equals(oldPassword)) {
				errorMsgs.add("舊密碼輸入錯誤!!!!");
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/my-account.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			memSvc.updateMemberPassword(memberID, userPassword);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/

//			PrintWriter out = res.getWriter();
//			out.println("<meta http-equiv='refresh' content='1;URL=" + req.getContextPath()
//		      + "/front-end/member/my-account.jsp'>");
//		    out.println("<script> alert('註冊成功!');</script>");
			String url = "/front-end/member/my-account.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);

		}

		if ("insert".equals(action)) { // 註冊帳號

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

			if ((memSvc.findMemberByMail(mail))) { // 【帳號 , 密碼無效時】
				errorMsgs.add("此信箱已有人使用");

			}

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/login.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			// 產生亂數密碼
			// 建立一個新的Random物件
			Random rand = new Random();

			// 生成一個8位的亂數碼
			String passRandom = "";
			for (int i = 0; i < 8; i++) {
				int randomNumber = rand.nextInt(36);
				if (randomNumber < 10) {
					// 生成一個0-9的數字
					passRandom += randomNumber;
				} else {
					// 生成一個A-Z的英文字母
					passRandom += (char) (randomNumber + 55);
				}
			}

			// 傳送訊息通知使用者
			String subject = "SYM驗證碼";

			String messageText = "Hello! " + mail + " 此次驗證碼: " + passRandom + "\n" + "請使用此驗證碼進行註冊流程" + "\n"
					+ "此驗證碼只保留五分鐘";

			MailService mailSvc = new MailService();
			mailSvc.sendMail(mail, subject, messageText);

			// 存進Redis裏
			Jedis jedis = new Jedis("localhost", 6379);
			jedis.set("passRandom", passRandom);
			jedis.expire("passRandom", 60 * 5);

			jedis.close();

			/*************************** 2.開始新增資料 ***************************************/
//			MemberService memSvc = new MemberService();
//			memVO = memSvc.addMember(userAccount, userPassword, userName, phone, mail, registrationTime,
//					mailCertification, sellerAuditApprovalState, currentShoppingCoin);

			HttpSession session = req.getSession();
			session.setAttribute("memVO", memVO);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/front-end/member/register.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交register2.jsp
			successView.forward(req, res);
		}

		if ("mailVerification".equals(action)) { // 信箱驗證

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			// 假設會員輸入驗證碼
			Jedis jedis = new Jedis("localhost", 6379);

			String passRandom = jedis.get("passRandom");

			String vCode = req.getParameter("vCode").trim();

			if (passRandom == null) {
				errorMsgs.add("連結信已逾時，請重新申請");
			} else if (!(vCode.equals(passRandom))) {
				errorMsgs.add("驗證有誤，請重新輸入");
			} else if (vCode.equals(passRandom))
				jedis.close();

			HttpSession session = req.getSession();

			MemberVO memVO = (MemberVO) session.getAttribute("memVO");
			String userAccount = memVO.getUserAccount();
			String userPassword = memVO.getUserPassword();
			String userName = memVO.getUserName();
			String phone = memVO.getPhone();
			String mail = memVO.getMail();
			Timestamp registrationTime = memVO.getRegistrationTime();
			Boolean mailCertification = memVO.getMailCertification();
			Boolean sellerAuditApprovalState = memVO.getSellerAuditApprovalState();
			Integer currentShoppingCoin = memVO.getCurrentShoppingCoin();

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/register.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			mailCertification = true;// 驗證成功

			/*************************** 2.開始新增資料 ***************************************/
			memVO = memSvc.addMember(userAccount, userPassword, userName, phone, mail, registrationTime,
					mailCertification, sellerAuditApprovalState, currentShoppingCoin);

			memVO = memSvc.loginOneMem(mail);

			session.setAttribute("memVO", memVO);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//			PrintWriter out = res.getWriter();
//			out.println("<meta http-equiv='refresh' content='1;URL=" + req.getContextPath()
//		      + "/front-end/member/register2.jsp'>");
//		    out.println("<script> alert('註冊成功!');</script>");
			String url = "/front-end/member/register2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交register2.jsp
			successView.forward(req, res);

		}

		if ("update".equals(action)) { // 註冊帳號第二階段

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

			String gender = req.getParameter("gender");

			java.sql.Date birthday = null;
			try {
				birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
			} catch (IllegalArgumentException e) {
				birthday = null;
				errorMsgs.add("請選擇生日！");
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

			Boolean mailCertification = true;

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

			Integer memberID = memSvc.getOne();

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
			memVO.setMemberID(memberID);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/register2.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			memSvc.updateMember(memberID, gender, birthday, userPhoto, mailCertification, idNumber, address,
					sellerAuditApprovalState, currentShoppingCoin);

			memVO = memSvc.loginOneMem(mail);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			session.setAttribute("memVO", memVO); // 資料庫update成功後,正確的的memVO物件,存入req
			String url = "/front-end/member/my-account.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);

		}

		if ("delete".equals(action)) { // 刪除

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer memberID = Integer.valueOf(req.getParameter("memberID"));

			/*************************** 2.開始刪除資料 ***************************************/
			memSvc.deleteMember(memberID);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/member/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

		if ("getOne_For_Login".equals(action)) { // 登入

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

			System.out.println(memSvc.getOneForLogin(mail, userPassword));
			if (!(memSvc.getOneForLogin(mail, userPassword))) { // 【帳號 , 密碼無效時】

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

					memVO = memSvc.loginOneMem(mail);
					session.setAttribute("memVO", memVO); // 資料庫取出的empVO物件,存入req
					String location = (String) session.getAttribute("location");
					if (location != null) {
						session.removeAttribute("location"); // *工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
						res.sendRedirect(location);
						return;
					}
				} catch (Exception ignored) {
				}

				StoreJDBCDAO storeJDBCDAO = new StoreJDBCDAO();
				StoreVO storeVO2 = storeJDBCDAO.findByPrimaryKey(memVO.getMemberID());

				// 有賣場名稱才執行
				if (storeVO2 != null && storeVO2.getStoreName() != null) {
					String storeName = storeVO2.getStoreName();
					session.setAttribute("storeName", storeName);
				}
				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/

				session.setAttribute("storeVO2", storeVO2);// 資料庫取出的storeVO物件,存入req
				res.sendRedirect(req.getContextPath() + "/index.jsp"); // *工作3:
																		// (-->如無來源網頁:則重導至login_success.jsp)
			}

		}

		if ("getOne_For_LogOut".equals(action)) { // 登出

			HttpSession session = req.getSession();
			// 登出操作，清除用戶的登入狀態
			session.removeAttribute("mail");

			// 重定向到登入頁面
			res.sendRedirect(req.getContextPath() + "/front-end/member/login.jsp");

		}

		if ("forgetPassword".equals(action)) { // 忘記密碼

			List<String> errorMsgs1 = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs1", errorMsgs1);

			/*************************** 1.接收請求參數 ****************************************/
			String tomail = req.getParameter("mail").trim();
			String mailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
			if (tomail == null || tomail.trim().length() == 0) {
				errorMsgs1.add("使用者信箱: 請勿空白");
			} else if (!tomail.trim().matches(mailReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs1.add("請輸入正確的信箱格式！");
			}

			MemberVO memVO = new MemberVO();
			memVO.setMail(tomail);

			if (!(memSvc.findMemberByMail(tomail))) { // 【帳號 , 密碼無效時】
				errorMsgs1.add("使用者信箱錯誤或查無此信箱");

			}

			if (!errorMsgs1.isEmpty()) {
				req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/login.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			// 產生亂數密碼
			// 建立一個新的Random物件
			Random rand = new Random();

			// 生成一個8位的亂數碼
			String passRandom = "";
			for (int i = 0; i < 8; i++) {
				int randomNumber = rand.nextInt(36);
				if (randomNumber < 10) {
					// 生成一個0-9的數字
					passRandom += randomNumber;
				} else {
					// 生成一個A-Z的英文字母
					passRandom += (char) (randomNumber + 55);
				}
			}

			// 取得該會員所有資料
			MemberService memSvc = new MemberService();
			memVO = memSvc.loginOneMem(tomail);

			// 把該會員的亂數密碼在資料庫做更新
			Integer memberID = memVO.getMemberID();
			memSvc.updateMemberPassword(memberID, passRandom);

			// 傳送訊息通知使用者
			String subject = "SYM密碼更新通知!";

			String username = memVO.getUserName();

			String messageText = "Hello! " + username + " 請謹記此密碼: " + passRandom + "\n" + " (已經啟用)" + "\n"
					+ "請使用此密碼進行登入及修改密碼";

			MailService mailSvc = new MailService();
			mailSvc.sendMail(tomail, subject, messageText);
		}

		if ("registerForShop".equals(action)) { // 註冊賣場資格

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			StoreVO storeVO = new StoreVO();
			StoreJDBCDAO dao = new StoreJDBCDAO();

			Integer memberID = Integer.valueOf(req.getParameter("memberID"));
			String storeDelBankCode = req.getParameter("storeDelBankCode");
			String taxID = req.getParameter("taxID");
			String phoneNumber = req.getParameter("phoneNumber");
			String storeBankAccount = req.getParameter("storeBankAccount");
			String storeName = req.getParameter("storeName");
			String storeAddress = req.getParameter("storeAddress");

			storeVO.setMemberID(memberID);
			storeVO.setStoreDelBankCode(storeDelBankCode);
			storeVO.setTaxID(taxID);
			storeVO.setPhoneNumber(phoneNumber);
			storeVO.setStoreBankAccount(storeBankAccount);
			storeVO.setStoreName(storeName);
			storeVO.setStoreAddress(storeAddress);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("storeVO", storeVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/registerForShop.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			dao.insert(storeVO);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			session.setAttribute("storeVO", storeVO); // 資料庫update成功後,正確的的memVO物件,存入req
			String url = "/front-end/store/myStore.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);

		}

	}

}
