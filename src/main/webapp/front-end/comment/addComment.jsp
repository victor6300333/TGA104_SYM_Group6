<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<%@ page import="com.group6.tibame104.orderlist.model.*, java.util.*"%>



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

<link rel="stylesheet" href="./css/review.css" />

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





	<table>

		<tr>
			<td width="155">�ӫ~�W��</td>
			<td width="155">�ӫ~�Ϥ�</td>
			<td width="125">����</td>

			<td width="105">�ƶq</td>
			<td width="130">�p�p</td>
			<td width="130">����</td>
		</tr>
		<tr>
			<td width="155">${orderlistVO.productName}</td>
			<td width="155"><img
				src="${pageContext.request.contextPath}/product/picServlet?productID=${orderlistVO.productID}"
				style="width: 230px; height: 200px" alt="Product Image"></td>
			<td width="125">${orderlistVO.price}</td>

			<td width="105">${orderlistVO.quantity}</td>
			<td width="130">${orderlistVO.subTotal}</td>
		</tr>

	</table>
 
		<div class="star-mark">
			<span>����</span>
			<ul class="star">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
			<div class="result">
				<span class="mark"></span><span class="detail"></span>
			</div>
			<div class="help-info">
				<span class="mark"></span>&nbsp;<span class="decri"></span><br /> <span
					class="detail"></span>
			</div>
		</div>
	

	<FORM METHOD="post" ACTION="OrderlistServlet">


		
				<p>�R�a����:</p>
				<input type="TEXT" name="buyerComment" size="45" />
			


		<input type="hidden" name="orderDetailID"
			value="${orderlistVO.orderDetailID}" size="45" /> 
			<input type="hidden" name="buyerReview" id="buyerComment" value="" /> 
			<input type="hidden" name="action" value="update"> 
			<input type="submit" value="�e�X�s�W">
	</FORM>
	<br>
	<br>
	<br>


	<form name="checkoutForm" action="Shopping.html" method="POST">

	</form>


	<script src="./js/review.js"></script>
	<script src="./vendors/jquery/jquery-3.4.1.min.js"></script>

</body>



<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->



</html>