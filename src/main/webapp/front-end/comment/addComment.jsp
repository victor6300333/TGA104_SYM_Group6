<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<%@ page import="com.orderlist.model.*, java.util.*"%>


<%
@SuppressWarnings("unchecked")
List<OrderlistVO> list = (List<OrderlistVO>) request.getAttribute("list");
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>���u��Ʒs�W - addEmp.jsp</title>

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
				<h3>�q�����</h3>
			</td>

		</tr>
	</table>

	<h3>��Ʒs�W:</h3>




	<%
	for (int index = 0; index < list.size(); index++) {
		OrderlistVO order = list.get(index);
	%>
<table >	

<tr>
	<td width="200">�q�����</td>
	<td width="200">�q��s��</td>
	<td width="200">�ӫ~�s��</td>
	<td width="200">�ƶq</td>
	<td width="200">����</td>
	<td width="200">�p�p</td>
</tr>	
<tr> 
	<td width="200"><%=order.getOrderDetailID()%></td>
	<td width="200"><%=order.getOrderID()%></td>
	<td width="200"><%=order.getProductID()%></td>
	<td width="200"><%=order.getQuantity()%></td>
	<td width="200"><%=order.getPrice()%></td>
	<td width="200"><%=order.getSubTotal()%></td>
</tr> 




	<FORM METHOD="post" ACTION="OrderlistServlet.do" >
		<table>

			<tr>
				<td>�R�a����:</td>
				<td><input type="TEXT" name="buyerReview" size="45" /></td>
			</tr>
			<tr>
				<td>�R�a����:</td>
				<td><input type="TEXT" name="buyerComment" size="45" /></td>
			</tr>

		</table>
	

	<input type="hidden" name="orderDetailID" value="<%=order.getOrderDetailID()%>" size="45" />
	<input type="hidden" name="orderID" value="<%=order.getOrderID()%>" size="45" />
	<input type="hidden" name="productID" value="<%=order.getProductID()%>" size="45" />
	<input type="hidden" name="quantity" value="<%=order.getQuantity()%>" size="45" />
	<input type="hidden" name="price" value="<%=order.getPrice()%>" size="45" />
	<input type="hidden" name="subTotal" value="<%=order.getSubTotal()%>" size="45" />
	<input type="hidden" name="comment" value="<%=index%>" size="45" />
	<input type="hidden" name="action" value="update"> 
	<input type="submit" value="�e�X�s�W">
	</FORM>
	<br> <br> <br>
	</table>	
	<%
	}
	%>

		<form name="checkoutForm" action="Shopping.html" method="POST">
			
		</form>
		
</body>



<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->


</script>
</html>