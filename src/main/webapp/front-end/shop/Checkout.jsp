<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="java.util.* ,com.group6.tibame104.orderlist.model.*, com.group6.tibame104.order.model.*"%>
<html>
<head>
 <title>Mode II 範例程式 - Checkout.jsp</title>
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/front-end/shop/css/ShoppingCart.css">
 </head>
<body>
 <font size="+3">結帳：（Checkout.jsp）</font>
<hr><p>


	
	

	<%
	@SuppressWarnings("unchecked")
	
	Map<OrderVO,List<OrderlistVO>> orderVO_list = (Map<OrderVO,List<OrderlistVO>>) session.getAttribute("orderVO_list");
			
	%>	
	<%
	Set<OrderVO> set = orderVO_list.keySet();
	Iterator<OrderVO> it = set.iterator();
	while (it.hasNext()) {
		OrderVO ordervo = it.next(); 
		List<OrderlistVO> orderlist = orderVO_list.get(ordervo);
		%>	
		 <tr>
		<th width="200">商品名稱</th>
		<th width="100">價格</th>
		<th width="100">數量</th>
		<th width="120"><h3>總價</h3></th>
	</tr>
		
	<%
		for (int i = 0; i < orderlist.size(); i++) {
			OrderlistVO order = orderlist.get(i);
			String name = order.getProductName();	
			Integer price = order.getPrice();
			Integer quantity = order.getQuantity();
			Integer subTotal = price*quantity;
		%>
<table style="margin: auto;">	

    	
	<tr>
		<td width="200"><%=name%>     </td>
		<td width="100"><%=price%>    </td>
		<td width="100"><%=quantity%> </td>
		<td width="120"><%=subTotal%></td>
	</tr>
</table>	
	<%
		}
	%>
	

<table>
	<tr>
		<td colspan="6" style="text-align:right;"> 
		   <font size="+2">總金額： <h4>$<%=ordervo.getOriginalTotal()%></h4> </font>
	    </td>
	</tr>
</table>
       
		
		<p>訂單編號:<%=ordervo.getOrderID()%></p>
		<p>賣場編號:<%=ordervo.getStoreID()%></p>
		<p>賣場名稱:<%=ordervo.getStoreName()%></p>
		<p>會員編號:<%=ordervo.getMemberID()%></p>
		<p>訂單日期:<%=ordervo.getOrderDate().toString().substring(0,19)%></p>
		<p>訂單狀態:<%=ordervo.getOrderStatus()%></p>
		<p>收件者:<%=ordervo.getReceiver()%></p>
		<p>電話號碼:<%=ordervo.getPhone()%></p>
		<p>信用卡號:<%=ordervo.getCreditcardNumber()%></p>
		<p>收件地址:<%=ordervo.getAddress()%></p>
		<p>付款方式:<%=ordervo.getPayType()%></p>
		<p>優惠券ID:<%=ordervo.getCouponID()%></p>
		<p>原價:<%=ordervo.getOriginalTotal()%></p>
		<p>使用購物金:<%=ordervo.getUseShoppingGold()%></p>
		<p>使用優惠券:<%=ordervo.getUseCouponGold()%></p>
		<p>運費:60</p>
		<p>總價:<%=ordervo.getFinalTotal()%></p>
  	<%
		}
	%>     
       <p><a href="EShop.jsp"><font size="+1"> 是 否 繼 續 購 物</font></a>
</body>
</html>