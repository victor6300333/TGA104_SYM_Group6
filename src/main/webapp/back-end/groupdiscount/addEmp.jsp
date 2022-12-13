<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.groupdiscount.model.*"%>

<%
GroupdiscountVO groupdiscountVO = (GroupdiscountVO) request.getAttribute("groupdiscountVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>員工資料新增 - addEmp.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>員工資料新增 - addEmp.jsp</h3>
			</td>
			<td>
				<h4>
					<a
						href="<%=request.getContextPath()%>/front-end/groupdiscount/select_page.jsp"><img
						src="<%=request.getContextPath()%>/back-end/groupdiscount/images/back1.gif"
						width="100" height="100" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post"
		ACTION="<%=request.getContextPath()%>/front-end/groupdiscount/Groupdiscount.do"
		name="form1">
		<table>
			<tr>
				<td>團購編號:</td>
				<td><input type="TEXT" name="groupBuyID"
					size="45"
					value="<%=(groupdiscountVO == null) ? "1" : groupdiscountVO.getGroupBuyID()%>" /></td>
				
			</tr>
			<tr>
				<td>團購人數:</td>
				<td><input type="TEXT" name="groupBuyProductOrderTotal"
					size="45"
					value="<%=(groupdiscountVO == null) ? "999" : groupdiscountVO.getGroupBuyProductOrderTotal()%>" /></td>
			</tr>
			<tr>
				<td>團購折數:</td>
				<td><input type="TEXT" name="groupBuyCount" size="45"
					value="<%=(groupdiscountVO == null) ? "0.95" : groupdiscountVO.getGroupBuyCount()%>" /></td>
			</tr>
		
		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->


</script>
</html>