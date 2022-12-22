<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="java.util.* ,com.group6.tibame104.orderlist.model.*, com.group6.tibame104.order.model.*"%>
<html>
<head>
 <title>Mode II �d�ҵ{�� - Checkout.jsp</title>
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/front-end/shop/css/ShoppingCart.css">
 </head>
<body>
 <font size="+3">���b�G�]Checkout.jsp�^</font>
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
		<th width="200">�ӫ~�W��</th>
		<th width="100">����</th>
		<th width="100">�ƶq</th>
		<th width="120"><h3>�`��</h3></th>
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
		   <font size="+2">�`���B�G <h4>$<%=ordervo.getOriginalTotal()%></h4> </font>
	    </td>
	</tr>
</table>
       
		
		<p>�q��s��:<%=ordervo.getOrderID()%></p>
		<p>����s��:<%=ordervo.getStoreID()%></p>
		<p>����W��:<%=ordervo.getStoreName()%></p>
		<p>�|���s��:<%=ordervo.getMemberID()%></p>
		<p>�q����:<%=ordervo.getOrderDate().toString().substring(0,19)%></p>
		<p>�q�檬�A:<%=ordervo.getOrderStatus()%></p>
		<p>�����:<%=ordervo.getReceiver()%></p>
		<p>�q�ܸ��X:<%=ordervo.getPhone()%></p>
		<p>�H�Υd��:<%=ordervo.getCreditcardNumber()%></p>
		<p>����a�}:<%=ordervo.getAddress()%></p>
		<p>�I�ڤ覡:<%=ordervo.getPayType()%></p>
		<p>�u�f��ID:<%=ordervo.getCouponID()%></p>
		<p>���:<%=ordervo.getOriginalTotal()%></p>
		<p>�ϥ��ʪ���:<%=ordervo.getUseShoppingGold()%></p>
		<p>�ϥ��u�f��:<%=ordervo.getUseCouponGold()%></p>
		<p>�B�O:60</p>
		<p>�`��:<%=ordervo.getFinalTotal()%></p>
  	<%
		}
	%>     
       <p><a href="EShop.jsp"><font size="+1"> �O �_ �~ �� �� ��</font></a>
</body>
</html>