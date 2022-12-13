<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.grouporder.model.*"%>

<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
 GrouporderVO grouporderVO = (GrouporderVO) request.getAttribute("grouporderVO"); //EmpServlet.java(Concroller), 存入req的empVO物件

%>

<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>

	<h4>此頁暫練習採用 Script 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>員工資料 - ListOneEmp.jsp</h3>
				<h4>
					<a href="<%=request.getContextPath()%>/front-end/grouporder/select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/grouporder/images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
		<th>團購訂單編號</th>
		<th>團購編號</th>
		<th>會員編號</th>
		<th>團購商品編號</th>
		<th>團購數量</th>
		<th>總金額</th>
		<th>訂單時間</th>
		<th>付款方式</th>
		<th>付款狀態</th>
		<th>購物金</th>
		<th>連絡電話</th>
		<th>運送地點</th>
		</tr>
		<tr>			
			<td><%=grouporderVO.getGroupBuyOrderID()%></td>
			<td><%=grouporderVO.getGroupBuyID()%></td>
			<td><%=grouporderVO.getMemberID()%></td>
			<td><%=grouporderVO.getGroupBuyProductID()%></td>
			<td><%=grouporderVO.getGroupBuyQuantity()%></td>
			<td><%=grouporderVO.getGroupBuyTotal()%></td>
			<td><%=grouporderVO.getOrderTime()%></td>
			<td><%=grouporderVO.getPaymentTerm()%></td>
			<td><%=grouporderVO.getPaymentState()%></td>
			<td><%=grouporderVO.getGiftVoucher()%></td>
			<td><%=grouporderVO.getContactNumber()%></td>
			<td><%=grouporderVO.getShippingLocation()%></td>
		</tr>
	</table>

</body>
</html>