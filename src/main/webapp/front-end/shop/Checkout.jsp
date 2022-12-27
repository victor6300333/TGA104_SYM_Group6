<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page
	import="java.util.* ,com.group6.tibame104.orderlist.model.OrderlistVO, com.group6.tibame104.order.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Mode II �d�ҵ{�� - Checkout.jsp</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/front-end/shop/css/ShoppingCart.css">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
	rel="stylesheet" />

<!-- CSS Libraries -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/order/lib/slick/slick.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/order/lib/slick/slick-theme.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/front-end/order/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/front-end/order/css/woody.css" />
</head>
<body>
	<font size="+2">�q�槹��</font>
	<hr>
	<p>





		<%
		@SuppressWarnings("unchecked")

		Map<OrderVO, List<OrderlistVO>> orderVO_list = (Map<OrderVO, List<OrderlistVO>>) session.getAttribute("orderVO_list");
		%>
		<%
		Set<OrderVO> set = orderVO_list.keySet();
		Iterator<OrderVO> it = set.iterator();
		while (it.hasNext()) {
			OrderVO ordervo = it.next();
			List<OrderlistVO> orderlist = orderVO_list.get(ordervo);
		%>
	
	<table id="table-1">
		<tr>
			<th width="200">�ӫ~�W��</th>
			<th width="155">�ӫ~�Ϥ�</th>
			<th width="100">����</th>
			<th width="100">�ƶq</th>
			<th width="120">�`��</th>
		</tr>
	</table>
	<table>
	<c:forEach var="orderlistVO" items="<%=orderlist%>">
		<tr>
			<td width="200">${orderlistVO.productName}</td>
			<td width="200"><img
				src="${pageContext.request.contextPath}/product/picServlet?productID=${orderlistVO.productID}"
				style="width: 140px; height: 120px" alt="Product Image"></td>
			<td width="100">${orderlistVO.price}</td>
			<td width="100">${orderlistVO.quantity}</td>
			<td width="120">${orderlistVO.subTotal}</td>
		</tr>

	</c:forEach>
	
		<tr>
			<td colspan="3" style="text-align: right"></td>
			<td colspan="5" style="text-align: right">�`���B:<%=ordervo.getOriginalTotal()%></td>
		</tr>
	
	
	</table>

	<p>
		�q��s��:<%=ordervo.getOrderID()%></p>
	<p>
		����s��:<%=ordervo.getStoreID()%></p>
	<p>
		����W��:<%=ordervo.getStoreName()%></p>
	<p>
		�|���s��:<%=ordervo.getMemberID()%></p>
	<p>
		�q����:<%=ordervo.getOrderDate().toString().substring(0, 19)%></p>
	<p>
		�q�檬�A:<%=ordervo.getOrderStatus()%></p>
	<p>
		�����:<%=ordervo.getReceiver()%></p>
	<p>
		�q�ܸ��X:<%=ordervo.getPhone()%></p>
	<p>
		�H�Υd��:<%=ordervo.getCreditcardNumber()%></p>
	<p>
		����a�}:<%=ordervo.getAddress()%></p>
	<p>
		�I�ڤ覡:<%=ordervo.getPayType()%></p>
	<p>
		�u�f��ID:<%=ordervo.getCouponID()%></p>
	<p>
		���:<%=ordervo.getOriginalTotal()%></p>
	<p>
		�ϥ��ʪ���:<%=ordervo.getUseShoppingGold()%></p>
	<p>
		�ϥ��u�f��:<%=ordervo.getUseCouponGold()%></p>
	<p>�B�O:60</p>
	<p>
		�`��:<%=ordervo.getFinalTotal()%></p>
	<%
	}
	%>
	<p>
		<a href="${pageContext.request.contextPath}/"><font size="+1">  �~ �� �� ��</font></a>
</body>
</html>