<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group.model.*"%>
<%@ page import="com.groupproduct.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
GroupService groupSvc = new GroupService();
List<GroupVO> list = groupSvc.getAll();
pageContext.setAttribute("list", list);

GroupproductService groupProductSvc = new GroupproductService();
List<GroupproductVO> list2 = groupProductSvc.getAll();
pageContext.setAttribute("list2", list2);
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
		<tr>
			<td>
				<h3>所有員工資料 - listAllEmp.jsp</h3>
				<h4>
					<a
						href="<%=request.getContextPath()%>/front-end/group/select_page.jsp"><img
						src="<%=request.getContextPath()%>/back-end/group/images/back1.gif"
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
			<th>團購商品編號</th>
			<th>團購商品價格</th>
			<th>團購商品圖片</th>
			<th>團購商品敘述</th>

		</tr>

		<c:forEach var="groupVO" items="${list}" varStatus="s">
			<c:forEach var="groupproductVO" items="${list2}">
				<tr>
					<c:if
						test="${groupVO.groupBuyProductID == groupproductVO.groupBuyProductID}"
						var="cc">
						
						<td>${groupVO.groupBuyID}</td>
						<td>${groupVO.groupBuyProductID}</td>
						<td>${groupVO.administratorID}</td>
						<td>${groupVO.groupBuyProductOrderTotal}</td>
						<td>${groupVO.groupBuyingState}</td>
						<td><fmt:formatDate value="${groupVO.groupBuyingOnLoadDate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${groupVO.groupBuyingOffLoadDate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${groupVO.updateTime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${groupproductVO.groupBuyProductID}</td>
						<td>${groupproductVO.groupBuyProductPrice}</td>
						<td><img
							src="${pageContext.request.contextPath}/back-end/groupproduct/DBJPGReader?groupBuyProductID=${groupproductVO.groupBuyProductID}"
							style="width: 50px"></td>
						<td>${groupproductVO.groupBuyProductDescrip}</td>
						<td> 
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/front-end/group/Group.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="groupBuyID" value="${groupVO.groupBuyID}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/front-end/group/Group.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="groupBuyID" value="${groupVO.groupBuyID}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
					</c:if>
			</c:forEach>
		</c:forEach>

	</table>


</body>
</html>