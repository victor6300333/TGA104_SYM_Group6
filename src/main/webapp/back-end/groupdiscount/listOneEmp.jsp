<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.groupdiscount.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
 GroupdiscountVO groupdiscountVO = (GroupdiscountVO) request.getAttribute("groupdiscountVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
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
					<a href="<%=request.getContextPath()%>/front-end/groupdiscount/select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/groupdiscount/images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
		<th>折扣表編號</th>
		<th>團購編號</th>
		<th>團購人數</th>
		<th>折扣數</th>

		</tr>
		<tr>			
			<td><%=groupdiscountVO.getCountTableID()%></td>
			<td><%=groupdiscountVO.getGroupBuyID()%></td>
			<td><%=groupdiscountVO.getGroupBuyProductOrderTotal()%></td>
			<td><%=groupdiscountVO.getGroupBuyCount()%></td>

		</tr>
	</table>

</body>
</html>