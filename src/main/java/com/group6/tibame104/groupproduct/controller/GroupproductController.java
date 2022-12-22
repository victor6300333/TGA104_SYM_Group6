package com.group6.tibame104.groupproduct.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.groupproduct.model.GroupproductService;
import com.group6.tibame104.groupproduct.model.GroupproductVO;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("/back-end/groupproduct")
@MultipartConfig
public class GroupproductController {
	 @Autowired
	    private GroupproductService groupproductSvc;
	 @GetMapping("getAll")
	 public String getAll(
			 Model model
			 ) {
		 List<GroupproductVO> groupproductVOs = groupproductSvc.getAll();
		 model.addAttribute("groupproductVOs",groupproductVOs);
		 return "back-end/groupproduct/listAllGroupProducts";
	 }
	 
	 @PostMapping("getOneForDisplay")
	 public String getOneForDisplay(
			 Model model,
			 HttpSession session,
			 @RequestParam("groupBuyProductID") Integer groupBuyProductID
			 ) {

			List<String> errorMsgs = new LinkedList<String>();
			model.addAttribute("errorMsgs", errorMsgs);
			
			if (!errorMsgs.isEmpty()) {
				return "front-end/groupproduct/select_page";// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			GroupproductVO groupproductVO = groupproductSvc.getOneGroupproduct(groupBuyProductID);
			 List<GroupproductVO> groupproductVOs = groupproductSvc.getAll();
			 model.addAttribute("groupproductVOs",groupproductVOs);
			if (groupproductVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				return "front-end/groupproduct/select_page";// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			// 瀏覽次數
			Jedis jedis = new Jedis("localhost", 6379);
			
			double count_num = 1;

			Map<String, Double> groupViews = new HashMap<>();
			String strID = groupBuyProductID.toString();
			Double count_current = jedis.zscore("groupViews", strID);
			//如果資料庫沒有資料
			if(count_current == null) {
				count_num = 1;
			}else {
			//有資料 : 1 + 目前瀏覽數	
				count_num += count_current;
			}
			
			groupViews.put(strID, count_num);

			jedis.zadd("groupViews", groupViews);
//			由多到少排序 前五
			
			Set<String> popProducts = jedis.zrevrangeByScore("groupViews", "+inf", "0", 0, 3);
			
			model.addAttribute("popProducts", popProducts);
			
			model.addAttribute("count_num" + groupBuyProductID, count_num);
			
			Integer countNow = jedis.zscore("groupViews", strID).intValue();
			
			model.addAttribute("countNow", countNow);
			
			jedis.close();
			
			model.addAttribute("groupproductVO", groupproductVO); // 資料庫取出的empVO物件,存入req
		 return "back-end/groupproduct/listOneGroupProduct";
	 }
	 
	 @PostMapping("getOneForUpdate")
	 public String getOneForUpdate(
			 Model model,
			 @RequestParam("groupBuyProductID") Integer groupBuyProductID
			 ) {

			List<String> errorMsgs = new LinkedList<String>();
			model.addAttribute("errorMsgs", errorMsgs);


			/*************************** 2.開始查詢資料 ****************************************/
			GroupproductVO groupproductVO = groupproductSvc.getOneGroupproduct(groupBuyProductID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			model.addAttribute("groupproductVO", groupproductVO); // 資料庫取出的empVO物件,存入req
		 return "back-end/groupproduct/update_groupProduct";
	 }
	 @PostMapping("update")
	 public String update(
			 Model model,
			 @RequestParam("groupBuyProductID") Integer groupBuyProductID,
			 @RequestParam("groupBuyProductPrice") Integer groupBuyProductPrice,
			 @RequestParam("groupBuyProductPicture") Part groupBuyProductPicture,
			 @RequestParam("groupBuyProductDescrip") String groupBuyProductDescrip
			 ) throws IOException {
		 List<String> errorMsgs = new LinkedList<String>();
		 
			model.addAttribute("errorMsgs", errorMsgs);
			
			byte[] groupBuyProductPicture1 = null; 
		
				// 圖片相關
				InputStream in = groupBuyProductPicture.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(in);
				groupBuyProductPicture1 = new byte[bis.available()];
				bis.read(groupBuyProductPicture1);
		
			GroupproductVO groupproductVO = new GroupproductVO();

			groupproductVO.setGroupBuyProductPrice(groupBuyProductPrice);
			groupproductVO.setGroupBuyProductPicture(groupBuyProductPicture1);
			groupproductVO.setGroupBuyProductDescrip(groupBuyProductDescrip);
			groupproductVO.setGroupBuyProductID(groupBuyProductID);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				model.addAttribute("errorMsgs", errorMsgs); // 含有輸入格式錯誤的empVO物件,也存入req
				return "emp/update_emp_input."; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			groupproductVO = groupproductSvc.updateGroupproduct(groupBuyProductPrice, groupBuyProductPicture1,
					groupBuyProductDescrip, groupBuyProductID);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			model.addAttribute("groupproductVO", groupproductVO); // 資料庫update成功後,正確的的empVO物件,存入req
		 
		 return getAll(model);
	 }
	 @PostMapping("insert")
	 public String insert(
			 Model model,
			 @RequestParam("groupBuyProductPrice") Integer groupBuyProductPrice,
			 @RequestParam("groupBuyProductPicture") Part groupBuyProductPicture,
			 @RequestParam("groupBuyProductDescrip") String groupBuyProductDescrip
			 
			 ) throws IOException {
			List<String> errorMsgs = new LinkedList<String>();
			model.addAttribute("errorMsgs", errorMsgs);

			byte[] groupBuyProductPicture1 = null; 
			
				// 圖片相關
				InputStream in = groupBuyProductPicture.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(in);
				groupBuyProductPicture1 = new byte[bis.available()];
				bis.read(groupBuyProductPicture1);
			
			
			GroupproductVO groupproductVO = new GroupproductVO();

			groupproductVO.setGroupBuyProductPrice(groupBuyProductPrice);
			groupproductVO.setGroupBuyProductPicture(groupBuyProductPicture1);
			groupproductVO.setGroupBuyProductDescrip(groupBuyProductDescrip);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				model.addAttribute("errorMsgs", errorMsgs); // 含有輸入格式錯誤的empVO物件,也存入req
				return "/back-end/groupproduct/addEmp";
			}

			/*************************** 2.開始新增資料 ***************************************/
			groupproductVO = groupproductSvc.addGroupproduct(groupBuyProductPrice, groupBuyProductPicture1,
					groupBuyProductDescrip);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
		 
		 return getAll(model);
	 }
	 @PostMapping("delete")
	 public String delete(
			 Model model,
			 @RequestParam("groupBuyProductID") Integer groupBuyProductID
			 ) {

			List<String> errorMsgs = new LinkedList<String>();
			model.addAttribute("errorMsgs", errorMsgs);

			/*************************** 2.開始刪除資料 ***************************************/
			groupproductSvc.deleteGroupproduct(groupBuyProductID);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
		 
		 return getAll(model);
	 }
}
