<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<%@ page import="com.orderlist.model.*, java.util.*"%>


<%
@SuppressWarnings("unchecked")
List<OrderlistVO> list = (List<OrderlistVO>) request.getAttribute("list");
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
				<h3>訂單評價</h3>
			</td>

		</tr>
	</table>

	<h3>資料新增:</h3>




	<%
	for (int index = 0; index < list.size(); index++) {
		OrderlistVO order = list.get(index);
	%>
<table >	

<tr>
	<td width="200">訂單明細</td>
	<td width="200">訂單編號</td>
	<td width="200">商品編號</td>
	<td width="200">數量</td>
	<td width="200">價錢</td>
	<td width="200">小計</td>
</tr>	
<tr> 
	<td width="200"><%=order.getOrderDetailID()%></td>
	<td width="200"><%=order.getOrderID()%></td>
	<td width="200"><%=order.getProductID()%></td>
	<td width="200"><%=order.getQuantity()%></td>
	<td width="200"><%=order.getPrice()%></td>
	<td width="200"><%=order.getSubTotal()%></td>
</tr> 




	<FORM METHOD="post" ACTION="OrderlistServlet" >
		<table>

			<tr>
				<td>買家評價:</td>
				<td><input type="TEXT" name="buyerReview" size="45" /></td>
			</tr>
			<tr>
				<td>買家評論:</td>
				<td><input type="TEXT" name="buyerComment" size="45" /></td>
			</tr>

		</table>
	

	<input type="hidden" name="orderDetailID" value="<%=order.getOrderDetailID()%>" size="45" />
	<input type="hidden" name="comment" value="<%=index%>" size="45" />
	
	
	
	<input type="hidden" name="action" value="update"> 
	<input type="submit" value="送出新增">
	</FORM>
	<br> <br> <br>
	</table>	
	<%
	}
	%>

		<form name="checkoutForm" action="Shopping.html" method="POST">
			
		</form>
		
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->


</script>
</html>