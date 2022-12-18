package com.group6.tibame104.administrator.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.group6.tibame104.store.model.StoreJDBCDAO;
import com.group6.tibame104.store.model.StoreVO;

@WebServlet("/back-end/administrator/administratorServlet")
public class AdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = res.getWriter();
		
		/*GSON*/
		Gson gson = new Gson();
		
		/*搜尋資料  待審核*/
		 List<StoreVO> findAllByAudit0 = new  StoreJDBCDAO().findAllByAudit0();
		 String json = gson.toJson(findAllByAudit0);
		 writer.write(json);
	}
	
}
