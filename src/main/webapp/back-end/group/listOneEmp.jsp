<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
 GroupVO groupVO = (GroupVO) request.getAttribute("groupVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
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
					<a href="<%=request.getContextPath()%>/front-end/group/select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/group/images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
		<th>團購編號</th>
		<th>團購商品編號</th>
		<th>管理員編號</th>
		<th>團購總人數</th>
		<th>團購狀態</th>
		<th>團購開始日</th>
		<th>團購結束日</th>
		<th>最後更新</th>

		</tr>
		<tr>			
			<td><%=groupVO.getGroupBuyID()%></td>
			<td><%=groupVO.getGroupBuyProductID()%></td>
			<td><%=groupVO.getAdministratorID()%></td>
			<td><%=groupVO.getGroupBuyProductOrderTotal()%></td>
			<td><%=groupVO.getGroupBuyingState()%></td>
			<td><%=groupVO.getGroupBuyingOnLoadDate()%></td>
			<td><%=groupVO.getGroupBuyingOffLoadDate()%></td>
			<td><%=groupVO.getUpdateTime()%></td>

		</tr>
	</table>

</body>
</html>