package com.group6.tibame104.groupdiscount.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.groupdiscount.model.GroupdiscountService;
import com.group6.tibame104.groupdiscount.model.GroupdiscountVO;

@Controller
@RequestMapping("/Groupdiscount")
public class GroupdiscountController {
	@Autowired
	private GroupdiscountService groupdiscountSvc;

	@PostMapping("/getOne_For_Display")
	public String getOneForDisplay(Model model, @RequestParam("countTableID") String str) {
	    List<String> errorMsgs = new LinkedList<String>();
	    model.addAttribute("errorMsgs", errorMsgs);

	    if (str == null || (str.trim()).length() == 0) {
	        errorMsgs.add("請輸入折扣表編號");
	    }
	    if (!errorMsgs.isEmpty()) {
	        return "/front-end/groupdiscount/select_page.jsp";
	    }

	    Integer countTableID = null;
	    try {
	        countTableID = Integer.valueOf(str);
	    } catch (Exception e) {
	        errorMsgs.add("折扣表格式不正確");
	    }

	    if (!errorMsgs.isEmpty()) {
	        return "/front-end/groupdiscount/select_page.jsp";
	    }

	    GroupdiscountVO groupdiscountVO = groupdiscountSvc.getOneGroupdiscount(countTableID);

	    if (groupdiscountVO == null) {
	        errorMsgs.add("查無資料");
	    }

	    if (!errorMsgs.isEmpty()) {
	        return "/front-end/groupdiscount/select_page.jsp";
	    }

	    model.addAttribute("groupdiscountVO", groupdiscountVO);
	    return "/front-end/groupdiscount/listOneEmp.jsp";
	}


	@PostMapping("/getGroup_For_Display")
	public String getGroupForDisplay(Model model, @RequestParam("groupBuyID") String str) {
	    List<String> errorMsgs = new LinkedList<String>();
	    model.addAttribute("errorMsgs", errorMsgs);
	    if (str == null || (str.trim()).length() == 0) {
	        errorMsgs.add("請輸入折扣表編號");
	    }
	    if (!errorMsgs.isEmpty()) {
	        return "/front-end/groupdiscount/select_page.jsp";
	    }
	    Integer groupBuyID = null;
	    try {
	        groupBuyID = Integer.valueOf(str);
	    } catch (Exception e) {
	        errorMsgs.add("折扣表格式不正確");
	    }
	    if (!errorMsgs.isEmpty()) {
	        return "/front-end/groupdiscount/select_page.jsp";
	    }
	    List<GroupdiscountVO> groupdiscountVO = groupdiscountSvc.getAllCount(groupBuyID);
	    if (groupdiscountVO.isEmpty()) {
	        errorMsgs.add("查無資料");
	    }
	    if (!errorMsgs.isEmpty()) {
	        return "/front-end/grouporder/select_page.jsp";
	    }
	    model.addAttribute("groupdiscountVO", groupdiscountVO);
	    return "/back-end/groupdiscount/listAllGroup.jsp";
	}


	@PostMapping("/getOne_For_Update")
	public String getOneForUpdate(Model model, @RequestParam("countTableID") String str) {
	    List<String> errorMsgs = new LinkedList<String>();
	    model.addAttribute("errorMsgs", errorMsgs);

	    Integer countTableID = null;
	    try {
	        countTableID = Integer.parseInt(str);
	    } catch (NumberFormatException e) {
	        errorMsgs.add("輸入的參數格式不正確");
	        return "/back-end/groupdiscount/update_discount.jsp";
	    }
	    GroupdiscountVO groupdiscountVO = groupdiscountSvc.getOneGroupdiscount(countTableID);

	    model.addAttribute("groupdiscountVO", groupdiscountVO);
	    return "/back-end/groupdiscount/update_discount.jsp";
	}

	
	
	
	@PostMapping("/update")
	public String update(Model model,
	        @RequestParam("countTableID") String str1,
	        @RequestParam("groupBuyID") String str2,
	        @RequestParam("groupBuyProductOrderTotal") String str3,
	        @RequestParam("groupBuyCount") String str4) {
	    List<String> errorMsgs = new LinkedList<String>();
	    model.addAttribute("errorMsgs", errorMsgs);

	    Integer countTableID = null;
	    Integer groupBuyID = null;
	    Integer groupBuyProductOrderTotal = null;
	    Double groupBuyCount = null;

	    try {
	        countTableID = Integer.parseInt(str1);
	        groupBuyID = Integer.parseInt(str2);
	        groupBuyProductOrderTotal = Integer.parseInt(str3);
	        groupBuyCount = Double.parseDouble(str4);
	    } catch (NumberFormatException e) {
	        errorMsgs.add("輸入的參數格式不正確");
	    }

	    GroupdiscountVO groupdiscountVO = new GroupdiscountVO();

	    if (!errorMsgs.isEmpty()) {
	        model.addAttribute("groupdiscountVO", groupdiscountVO);
	        return "/back-end/groupdiscount/updateGroupDiscount.jsp";
	    }

	    groupdiscountVO = groupdiscountSvc.updateGroupdiscount(countTableID, groupBuyID, groupBuyProductOrderTotal, groupBuyCount);

	    if (groupdiscountVO == null) {
	        errorMsgs.add("更新失敗");
	        model.addAttribute("groupdiscountVO", groupdiscountVO);
	        return "/back-end/groupdiscount/updateGroupDiscount.jsp";
	    }

	    model.addAttribute("groupdiscountVO", groupdiscountVO);
	    return "/back-end/groupdiscount/listAllGroupDiscount.jsp";
	}

	

	@PostMapping("/insert")
	public String insert(Model model,
	        @RequestParam("groupBuyID") String str1,
	        @RequestParam("groupBuyProductOrderTotal") String str2,
	        @RequestParam("groupBuyCount") String str3) {
	    List<String> errorMsgs = new LinkedList<String>();
	    model.addAttribute("errorMsgs", errorMsgs);

	    Integer groupBuyID = null;
	    Integer groupBuyProductOrderTotal = null;
	    Double groupBuyCount = null;

	    try {
	        groupBuyID = Integer.parseInt(str1);
	    } catch (NumberFormatException e) {
	        errorMsgs.add("Group buy ID 必須是整數");
	    }

	    try {
	        groupBuyProductOrderTotal = Integer.parseInt(str2);
	    } catch (NumberFormatException e) {
	        errorMsgs.add("Group buy product order total 必須是整數");
	    }

	    try {
	        groupBuyCount = Double.parseDouble(str3);
	    } catch (NumberFormatException e) {
	        errorMsgs.add("Group buy count 必須是數字");
	    }

	    GroupdiscountVO groupdiscountVO = new GroupdiscountVO();
	    groupdiscountVO.setGroupBuyID(groupBuyID);
	    groupdiscountVO.setGroupBuyProductOrderTotal(groupBuyProductOrderTotal);
	    groupdiscountVO.setGroupBuyCount(groupBuyCount);

	    if (!errorMsgs.isEmpty()) {
	        model.addAttribute("groupdiscountVO", groupdiscountVO);
	        return "/back-end/groupdiscount/addEmp.jsp";
	    }

	    groupdiscountSvc.addGroupdiscount(groupBuyID, groupBuyProductOrderTotal,groupBuyCount);
	    return "/back-end/groupdiscount/addSuccess.jsp";
	}

	
	
	
	
	@PostMapping("/delete")
	public String delete(Model model, @RequestParam("countTableID")String str) {
	    List<String> errorMsgs = new LinkedList<String>();
	    model.addAttribute("errorMsgs", errorMsgs);

	    Integer countTableID = null;

	    try {
	        countTableID = Integer.parseInt(str);
	    } catch (NumberFormatException e) {
	        errorMsgs.add("輸入的參數格式不正確");
	    }

	    if (!errorMsgs.isEmpty()) {
	        return "/back-end/groupdiscount/listAllGroupDiscount.jsp";
	    }

	    groupdiscountSvc.deleteGroupdiscount(countTableID);
	    return "/back-end/groupdiscount/listAllGroupDiscount.jsp";

	}
}