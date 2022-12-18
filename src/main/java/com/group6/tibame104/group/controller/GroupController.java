package com.group6.tibame104.group.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.group6.tibame104.group.model.GroupService;
import com.group6.tibame104.group.model.GroupVO;
import com.group6.tibame104.groupproduct.model.GroupproductService;
import com.group6.tibame104.groupproduct.model.GroupproductVO;

@Controller
@RequestMapping("/front-end/group")
public class GroupController {
	@Autowired
	private GroupService groupSvc;
	@Autowired
	private GroupproductService groupproductSvc;

	@PostMapping("/getOne_For_Display")
	public String getOneForDisplay(Model model, @RequestParam("groupBuyID") String str) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);
		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("請輸入折扣表編號");
		}
		if (!errorMsgs.isEmpty()) {
			return "front-end/groupdiscount/select_page";
		}

		Integer groupBuyID = null;
		try {
			groupBuyID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("折扣表格式不正確");
		}
		if (!errorMsgs.isEmpty()) {
			return "front-end/groupdiscount/select_page";
		}
		
		GroupVO groupVO = groupSvc.getOneGroup(groupBuyID);
		if (groupVO == null) {
			errorMsgs.add("查無資料");
		}
		if (!errorMsgs.isEmpty()) {
			return "front-end/grouporder/select_page";
		}

		model.addAttribute("groupVO", groupVO);
		return "back-end/group/listOneEmp";
	}
	
	@PostMapping("/addOrder")
	public String addOrder(
			HttpSession session,
			Model model,
			@RequestParam("groupBuyID") String str,
			@RequestParam("groupBuyProductID") String str2,
			@RequestParam("groupBuyCount") String str3
		) {
		List<String> errorMsgs = new LinkedList<String>();
		model.addAttribute("errorMsgs", errorMsgs);

		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("請輸入折扣表編號");
		}
		if (!errorMsgs.isEmpty()) {
			return "front-end/groupdiscount/select_page";
		}

		Integer groupBuyID = null;
		try {
			groupBuyID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("折扣表格式不正確1");
		}
		if (!errorMsgs.isEmpty()) {
			return "front-end/groupdiscount/select_page";
		}
		
		Integer groupBuyProductID = null;
		try {
			groupBuyProductID = Integer.valueOf(str2);
		} catch (Exception e) {
			errorMsgs.add("團購編號錯了");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "front-end/groupdiscount/select_page";
		}
		
		Double groupBuyCount = null;
		try {
			groupBuyCount = Double.valueOf(str3);
		} catch (Exception e) {
			errorMsgs.add("折扣表格不正確");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "front-end/groupdiscount/select_page";// 程式中斷
		}

		GroupVO groupVO = groupSvc.getOneGroup(groupBuyID);
		GroupproductVO groupproductVO = groupproductSvc.getOneGroupproduct(groupBuyProductID);

		if (groupVO == null) {
			errorMsgs.add("查無資料");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "front-end/grouporder/select_page";// 程式中斷
		}

		/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
		session.setAttribute("groupVO", groupVO); // 資料庫取出的empVO物件,存入req
		session.setAttribute("groupBuyCount", groupBuyCount);
		session.setAttribute("groupproductVO", groupproductVO);

		return "front-end/group/addOrder";
	}
}
