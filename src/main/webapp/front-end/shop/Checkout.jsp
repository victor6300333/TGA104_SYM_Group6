<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="java.util.* ,com.orderlist.model.Product"%>
<html>
<head>
 <title>Mode II �d�ҵ{�� - Checkout.jsp</title>
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/front-end/shop/css/ShoppingCart.css">
 </head>
<body>
<img src="images/tomcat.gif"> <font size="+3">�����ѩ� - ���b�G�]Checkout.jsp�^</font>
<hr><p>




<table id="table-1" style="margin: auto;">
	<tr>
		<th width="200">�ӫ~�W��</th>
		<th width="100">����</th>
		<th width="100">�ƶq</th>
		<th width="120"><h3>�`��</h3></th>
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
		   <font size="+2">�`���B�G <h4>$<%=amount%></h4> </font>
	    </td>
	</tr>
</table>
       
		
		<p>�q��s��:${orderprint.orderID}</p>
		<p>����s��:${orderprint.storeID}</p>
		<p>�|���s��:${orderprint.memberID}</p>
		<p>�q����:${orderprint.orderDate}</p>
		<p>�q�檬�A:${orderprint.orderStatus}</p>
		<p>�����:${orderprint.receiver}</p>
		<p>�q�ܸ��X:${orderprint.phone}</p>
		<p>�H�Υd��:${orderprint.creditcardNumber}</p>
		<p>����a�}:${orderprint.address}</p>
		<p>�I�ڤ覡:${orderprint.payType}</p>
		<p>�u�f��ID:${orderprint.couponID}</p>
		<p>���:${orderprint.originalTotal}</p>
		<p>�ϥ��ʪ���:${orderprint.useShoppingGold}</p>
		<p>�ϥ��u�f��:${orderprint.useCouponGold}</p>
		<p>�B�O:60</p>
		<p>�`��:${orderprint.finalTotal}</p>
       
       <p><a href="EShop.jsp"><font size="+1"> �O �_ �~ �� �� ��</font></a>
</body>
</html>