<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.couponUsageHistory.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
CouponUsageHistoryService couponUsageHistorySvc = new CouponUsageHistoryService();
    List<CouponUsageHistoryVO> list = couponUsageHistorySvc.getAll2();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>優惠券紀錄資料All - listAllEmp.jsp</title>

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
	width: 800px;
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

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>優惠券紀錄資料All - listAllEmp.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/couponUsageHistory/select_page.jsp"><img src="images/tomcat.png" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>會員ID</th>
		<th>優惠券ID</th>
		<th>使用紀錄</th>
		<th>使用日期</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="couponUsageHistoryVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${couponUsageHistoryVO.memberID}</td>
			<td>${couponUsageHistoryVO.couponID}</td>
			<td>${couponUsageHistoryVO.usageRecord}</td>
			<td>${couponUsageHistoryVO.useDate}</td>
			
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>