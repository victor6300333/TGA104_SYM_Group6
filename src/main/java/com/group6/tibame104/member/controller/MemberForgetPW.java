package com.group6.tibame104.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.group6.tibame104.member.model.MailService;
import com.group6.tibame104.member.model.MemberService;
import com.group6.tibame104.member.model.MemberVO;

@WebServlet("/member/MemberForgetPW")
public class MemberForgetPW extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memSvc;
	private MailService mailService;

	@Override
	public void init() throws ServletException {
		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		memSvc = applicationContext.getBean(MemberService.class);
		mailService = applicationContext.getBean(MailService.class);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		/*************************** 1.接收請求參數 ****************************************/

		Gson gson = new Gson();

		PrintWriter writer = res.getWriter();

		MemberVO memVO = new MemberVO();

		String mail = req.getParameter("mail").trim();

//		System.out.println(tomail);
		memVO = memSvc.loginOneMem(mail);

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
		memVO = memSvc.loginOneMem(mail);

		// 把該會員的亂數密碼在資料庫做更新
		Integer memberID = memVO.getMemberID();
		memSvc.updateMemberPassword(memberID, passRandom);

		// 傳送訊息通知使用者
		String subject = "SYM密碼更新通知!";

		String username = memVO.getUserName();

		String messageText = "Hello! " + username + " 請謹記此密碼: " + passRandom + "\n" + " (已經啟用)" + "\n"
				+ "請使用此密碼進行登入及修改密碼";

		mailService.sendMail(mail, subject, messageText);

		String json = gson.toJson(mail);
		writer.write(json);
	}

}
