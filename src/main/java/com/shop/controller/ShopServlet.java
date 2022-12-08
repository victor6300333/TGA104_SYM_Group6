package com.shop.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.commons.pool2.*;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.order.model.OrderService;
import com.order.model.OrderVO;
import com.orderlist.model.OrderlistVO;
import com.orderlist.model.Product;

//import redis.clients.jedis.Jedis;

//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;

//import redis.clients.jedis.JedisPool;

//@WebServlet("/front-end/shop/ShopServlet")

@WebServlet("/front-end/shop/ShopServlet")
public class ShopServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		@SuppressWarnings("unchecked")
		List<Product> buylist = (Vector<Product>) session.getAttribute("shoppingcart");
		HashMap<Integer, List<Product>> check = new HashMap<Integer, List<Product>>();
		
		String action = req.getParameter("action");

		if (!action.equals("CHECKOUT")) {
//			Jedis jedis = new Jedis("localhost", 6379);
//			jedis.select(5);

			// 刪除購物車中的書籍
			if (action.equals("DELETE")) {
				String del = req.getParameter("del");
		
				
				int d = Integer.parseInt(del);
				buylist.remove(d);
			}
			// 新增書籍至購物車中
			else if (action.equals("ADD")) {

				// 取得後來新增的書籍
				Product product = getProduct(req);

				if (buylist == null) {

					buylist = new Vector<Product>();
					buylist.add(product);
//					check.put(product.getStoreID(), buylist);
//					jedis.hset("1", product.getName(), product.getQuantity().toString());

				} else {
					

					if (buylist.contains(product)) {

						Product innerBOOK = buylist.get(buylist.indexOf(product));
						innerBOOK.setQuantity(innerBOOK.getQuantity() + product.getQuantity());

//						jedis.hset("1", product.getName(), innerBOOK.getQuantity().toString());

					} else {
						buylist.add(product);
//						jedis.hset("1", product.getName(), product.getQuantity().toString());
					}
				}
//        product.setQuantity(Integer.parseInt(jedis.get(product.getMemberID().toString())));
				check.put(product.getStoreID(), buylist);
			}
			
//			jedis.hvals(1)

			session.setAttribute("shoppingcart", buylist);
			session.setAttribute("check", check);

			String url = "/front-end/shop/Cart.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}

		// 結帳，計算購物車書籍價錢總數
		else if (action.equals("CHECKOUT")) {
			int total = 0;
			List<OrderlistVO> orderlist = new ArrayList<OrderlistVO>();
			for (int i = 0; i < buylist.size(); i++) {
				Product order = buylist.get(i);
				Integer price = order.getPrice();
				Integer quantity = order.getQuantity();
				Integer productID = order.getProductID();
				
				total += (price * quantity);

				
				OrderlistVO list = new OrderlistVO();

				list.setProductID(productID);
				list.setPrice(price);
				list.setQuantity(quantity);
				list.setSubTotal(price*quantity);
			
//				list.setShopReview("none");
//				list.setShopComment("none");
//				list.setBuyerReview("none");
//				list.setBuyerComment("none");
				orderlist.add(list);
		
			}
//			OrderlistService orderlistService = new OrderlistService();
//			orderlistService.addOrderlist(orderlist);
		

			String amount = String.valueOf(total);
			req.setAttribute("amount", amount);

			OrderVO ordervo = new OrderVO();

			String receiver = req.getParameter("receiver");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String paytype = req.getParameter("paytype");

			Integer useShoppingGold = Integer.valueOf(req.getParameter("useShoppingGold"));
			Double count = Double.valueOf(req.getParameter("couponID"));

			ordervo.setMemberID(1);
			ordervo.setStoreID(2);
			ordervo.setCreditcardNumber("10");
			ordervo.setPayType(paytype);
			ordervo.setReceiver(receiver);
			ordervo.setOrderStatus(0);
			ordervo.setPhone(phone);
			ordervo.setAddress(address);
			ordervo.setOrderDate(new Timestamp(System.currentTimeMillis()));
			ordervo.setOriginalTotal(total);
			ordervo.setCouponID(1);
			ordervo.setUseCouponGold((int) (total * (1 - count)));
			ordervo.setUseShoppingGold(useShoppingGold);
			ordervo.setFinalTotal((int) (total * count - useShoppingGold));


			OrderService ordsvc = new OrderService();
			ordsvc.addOrder(ordervo, orderlist);

			req.setAttribute("orderprint", ordervo);

			String url = "/front-end/shop/Checkout.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);

			session.removeAttribute("shoppingcart");

//			receiver:input, phone:input, address:input
//			creditcard:信用卡, atm: atm轉帳, arrive:貨到付款, coupon:85 75, 

//			ordervo.setCreditcardNumber(paytype);

//			ordervo.setMemberID(null);

//			ordervo.setOriginalTotal(null);
//			ordervo.setUseShoppingGold(null);
//			ordervo.setCouponGold();
//			ordervo.setFinalTotal(null);

		}
	}

	private Product getProduct(HttpServletRequest req) {
//		req.getAttribute(name);
//		String memberID = req.getParameter("memberID");
		String quantity = req.getParameter("quantity");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String productID = req.getParameter("productID");
		String storeID = req.getParameter("storeID");
//		String storeID = req.getParameter("storeID");

		Product product = new Product();

		product.setProductID(Integer.parseInt(productID));
		product.setName(name);
		product.setPrice(new Integer(price));
		product.setQuantity((new Integer(quantity)).intValue());
		product.setStoreID(Integer.parseInt(storeID));
		return product;
	}

//	static void addCart(Long userID, Long productID, int num) {
//		Jedis jedis = new Jedis("localhost",6379);
//		String product = jedis.hget("cart" + userID, String.valueOf(productID));
//		if(product!=null || !"".equals(product)) {
//			jedis.hincrBy("cart:"+userID, String.valueOf(productID), num);
//		} else {
//			jedis.hset("cart:"+userID, String.valueOf(productID), String.valueOf(num));
//		}
//		
//		jedis.close();
//	}

}
