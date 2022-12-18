<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group6.tibame104.groupproduct.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
GroupproductVO groupproductVO = (GroupproductVO) request.getAttribute("groupproductVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
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
					<a
						href="<%=request.getContextPath()%>/front-end/groupproduct/select_page.jsp"><img
						src="<%=request.getContextPath()%>/back-end/groupproduct/images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>團購商品編號</th>
			<th>團購商品價格</th>
			<th>團購照片</th>
			<th>團購商品描述</th>

		</tr>
		<tr>
			<td><%=groupproductVO.getGroupBuyProductID()%></td>
			<td><%=groupproductVO.getGroupBuyProductPrice()%></td>
			<td><img
				src="${pageContext.request.contextPath}/back-end/groupproduct/DBJPGReader?groupBuyProductID=${groupproductVO.groupBuyProductID}"
				style="width: 50px"></td>
			<td><%=groupproductVO.getGroupBuyProductDescrip()%></td>

		</tr>
	</table>

</body>
</html>