<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.grouporder.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    GrouporderService grouporderSvc = new GrouporderService();
    List<GrouporderVO> list = grouporderSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有員工資料 - listAllEmp.jsp</title>

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
		 <h3>所有員工資料 - listAllEmp.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/grouporder/select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/grouporder/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
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
		<th>修改</th>
		<th>刪除</th>
		
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="grouporderVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${grouporderVO.groupBuyOrderID}</td>
			<td>${grouporderVO.groupBuyID}</td>
			<td>${grouporderVO.memberID}</td>
			<td>${grouporderVO.groupBuyProductID}</td>
			<td>${grouporderVO.groupBuyQuantity}</td>
			<td>${grouporderVO.groupBuyTotal}</td> 
			<td>${grouporderVO.orderTime}</td>
			<td>${grouporderVO.paymentTerm}</td>
			<td>${grouporderVO.paymentState}</td>
			<td>${grouporderVO.giftVoucher}</td>
			<td>${grouporderVO.contactNumber}</td>
			<td>${grouporderVO.shippingLocation}</td>
			
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/grouporder/Grouporder.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="groupBuyOrderID"  value="${grouporderVO.groupBuyOrderID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/grouporder/Grouporder.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="groupBuyOrderID"  value="${grouporderVO.groupBuyOrderID}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>