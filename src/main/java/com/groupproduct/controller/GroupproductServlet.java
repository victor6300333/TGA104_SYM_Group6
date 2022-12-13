package com.groupproduct.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.groupproduct.model.GroupproductService;
import com.groupproduct.model.GroupproductVO;
@WebServlet("/front-end/groupproduct/Groupproduct.do")
@MultipartConfig
public class GroupproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GroupproductServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("groupBuyProductID");
//	

			Integer groupBuyProductID = null;
			try {
				groupBuyProductID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("員工編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/groupproduct/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			GroupproductService groupproductSvc = new GroupproductService();
			GroupproductVO groupproductVO = groupproductSvc.getOneGroupproduct(groupBuyProductID);

			if (groupproductVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/groupproduct/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("groupproductVO", groupproductVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/groupproduct/listOneGroupProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer groupBuyProductID = Integer.valueOf(req.getParameter("groupBuyProductID"));

			/*************************** 2.開始查詢資料 ****************************************/
			GroupproductService groupproductSvc = new GroupproductService();
			GroupproductVO groupproductVO = groupproductSvc.getOneGroupproduct(groupBuyProductID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("groupproductVO", groupproductVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/groupproduct/update_groupProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			

			Integer groupBuyProductID = Integer.valueOf(req.getParameter("groupBuyProductID").trim());
			Integer groupBuyProductPrice = Integer.valueOf(req.getParameter("groupBuyProductPrice").trim());
			
			byte[] groupBuyProductPicture = null;
			   // 圖片相關
			   Part part = req.getPart("groupBuyProductPicture");
			   if (part.getSize() == 0) {
				   groupBuyProductPicture = null;
			   } else {
			    InputStream in = part.getInputStream();
			    BufferedInputStream bis = new BufferedInputStream(in);
			    groupBuyProductPicture = new byte[bis.available()];
			    bis.read(groupBuyProductPicture);
			    bis.close();
			    in.close();
			   }
			String groupBuyProductDescrip = req.getParameter("groupBuyProductDescrip").trim();

			

			GroupproductVO groupproductVO = new GroupproductVO();
			
			groupproductVO.setGroupBuyProductPrice(groupBuyProductPrice);
			groupproductVO.setGroupBuyProductPicture(groupBuyProductPicture);
			groupproductVO.setGroupBuyProductDescrip(groupBuyProductDescrip);
			groupproductVO.setGroupBuyProductID(groupBuyProductID);
			

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("groupproductVO", groupproductVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/emp/update_emp_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			GroupproductService groupproductSvc = new GroupproductService();
			groupproductVO = groupproductSvc.updateGroupproduct(groupBuyProductPrice, groupBuyProductPicture,groupBuyProductDescrip,groupBuyProductID);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("groupproductVO", groupproductVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/groupproduct/listAllGroupProducts.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
		
			if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);

					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

				Integer groupBuyProductPrice = Integer.valueOf(req.getParameter("groupBuyProductPrice").trim());
				
				byte[] groupBuyProductPicture = null;
				   // 圖片相關
				   Part part = req.getPart("groupBuyProductPicture");
				   if (part.getSize() == 0) {
					   groupBuyProductPicture = null;
				   } else {
				    InputStream in = part.getInputStream();
				    BufferedInputStream bis = new BufferedInputStream(in);
				    groupBuyProductPicture = new byte[bis.available()];
				    bis.read(groupBuyProductPicture);
				    bis.close();
				    in.close();
				   }
								
				String groupBuyProductDescrip = req.getParameter("groupBuyProductDescrip").trim();
								
				GroupproductVO groupproductVO = new GroupproductVO();

		
				groupproductVO.setGroupBuyProductPrice(groupBuyProductPrice);
				groupproductVO.setGroupBuyProductPicture(groupBuyProductPicture);
				groupproductVO.setGroupBuyProductDescrip(groupBuyProductDescrip);
				

					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
	req.setAttribute("groupproductVO", groupproductVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/back-end/groupproduct/addEmp.jsp");
						failureView.forward(req, res);
						return;
					}
					
					/***************************2.開始新增資料***************************************/
					GroupproductService groupproductSvc = new GroupproductService();
					groupproductVO = groupproductSvc.addGroupproduct(groupBuyProductPrice, groupBuyProductPicture, groupBuyProductDescrip);
					
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					String url = "/back-end/groupproduct/listAllGroupProducts.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
					successView.forward(req, res);				
			}
			if ("delete".equals(action)) { // 來自listAllEmp.jsp

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
		
					/***************************1.接收請求參數***************************************/
					Integer groupBuyProductID = Integer.valueOf(req.getParameter("groupBuyProductID"));
					
					/***************************2.開始刪除資料***************************************/
					GroupproductService groupproductSvc = new GroupproductService();
					groupproductSvc.deleteGroupproduct(groupBuyProductID);
					
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "/back-end/groupproduct/listAllGroupProducts.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
			}
	}
	

}
