<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.groupdiscount.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    GroupdiscountService groupdiscountSvc = new GroupdiscountService();
    List<GroupdiscountVO> list = groupdiscountSvc.getAll();
    pageContext.setAttribute("list",list);
    
%>


<html>
<head>
<title>所有員工資料 - listAllEmp.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    bordert: 2px solid black;
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
		 <h4><a href="<%=request.getContextPath()%>/front-end/groupdiscount/select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/groupdiscount/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>折扣表編號</th>
		<th>團購編號</th>
		<th>團購總數</th>
		<th>折扣數</th>
		<th>修改</th>
		<th>刪除</th>

		
	</tr>
	
	<c:forEach var="groupdiscountVO" items="${list}" >
		
		<tr>
			<td>${groupdiscountVO.countTableID}</td>
			<td>${groupdiscountVO.groupBuyID}</td>
			<td>${groupdiscountVO.groupBuyProductOrderTotal}</td>
			<td>${groupdiscountVO.groupBuyCount}</td>
			
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/groupdiscount/Groupdiscount.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="countTableID"  value="${groupdiscountVO.countTableID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/groupdiscount/Groupdiscount.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="countTableID"  value="${groupdiscountVO.countTableID}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>


</body>
</html>