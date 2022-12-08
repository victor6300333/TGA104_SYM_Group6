<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="java.util.* ,com.orderlist.model.Product"%>
<html>
<head>
 <title>Mode II 範例程式 - Checkout.jsp</title>
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/front-end/shop/css/ShoppingCart.css">
 </head>
<body>
<img src="images/tomcat.gif"> <font size="+3">網路書店 - 結帳：（Checkout.jsp）</font>
<hr><p>




<table id="table-1" style="margin: auto;">
	<tr>
		<th width="200">商品名稱</th>
		<th width="100">價格</th>
		<th width="100">數量</th>
		<th width="120"><h3>總價</h3></th>
	</tr></table><table style="margin: auto;">

	<%
	@SuppressWarnings("unchecked")
			Vector<Product> buylist = (Vector<Product>) session.getAttribute("shoppingcart");
			String amount =  (String) request.getAttribute("amount");
	%>	
	<%
		for (int i = 0; i < buylist.size(); i++) {
			Product order = buylist.get(i);
			String name = order.getName();		
			Integer price = order.getPrice();
			Integer quantity = order.getQuantity();
			Integer subTotal = price*quantity;
		%>
	<tr>
		<td width="200"><%=name%>     </td>
		<td width="100"><%=price%>    </td>
		<td width="100"><%=quantity%> </td>
		<td width="120"><%=subTotal%></td>
	</tr>
	<%
		}
	%>

	<tr>
		<td colspan="6" style="text-align:right;"> 
		   <font size="+2">總金額： <h4>$<%=amount%></h4> </font>
	    </td>
	</tr>
</table>
       
		
		<p>訂單編號:${orderprint.orderID}</p>
		<p>賣場編號:${orderprint.storeID}</p>
		<p>會員編號:${orderprint.memberID}</p>
		<p>訂單日期:${orderprint.orderDate}</p>
		<p>訂單狀態:${orderprint.orderStatus}</p>
		<p>收件者:${orderprint.receiver}</p>
		<p>電話號碼:${orderprint.phone}</p>
		<p>信用卡號:${orderprint.creditcardNumber}</p>
		<p>收件地址:${orderprint.address}</p>
		<p>付款方式:${orderprint.payType}</p>
		<p>優惠券ID:${orderprint.couponID}</p>
		<p>原價:${orderprint.originalTotal}</p>
		<p>使用購物金:${orderprint.useShoppingGold}</p>
		<p>使用優惠券:${orderprint.useCouponGold}</p>
		<p>運費:60</p>
		<p>總價:${orderprint.finalTotal}</p>
       
       <p><a href="EShop.jsp"><font size="+1"> 是 否 繼 續 購 物</font></a>
</body>
</html>