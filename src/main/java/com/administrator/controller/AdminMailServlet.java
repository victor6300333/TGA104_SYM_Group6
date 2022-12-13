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

import com.administrator.model.MailService;
import com.member.model.MemberJDBCDAO;
import com.member.model.MemberVO;
import com.store.model.StoreJDBCDAO;


@WebServlet("/back-end/administrator/AdminMailServlet")
public class AdminMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer memberID = null;
		try {
			memberID =Integer.valueOf(req.getParameter("memberID"));
			StoreJDBCDAO storeJDBCDAO = new StoreJDBCDAO();
			storeJDBCDAO.pass(memberID);
			MemberVO memberVO = new MemberJDBCDAO().findByPrimaryKey(memberID);
			MailService mailService = new MailService();
			
			String to = memberVO.getMail();

			String subject = "賣場開通通知";
			String ch_name = memberVO.getUserName();
            String messageText = "Hello! " + ch_name + " 你的賣場開通囉 \n (已經啟用)";
			
			mailService.sendMail(to, subject, messageText);
			
			String url = "/back-end/administrator/sellerVerify.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, resp);
		} catch(Exception e) {
			
		}
	}
}
