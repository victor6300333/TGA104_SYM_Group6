<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<%@ page import="com.group6.tibame104.orderlist.model.*, java.util.*"%>



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

<link rel="stylesheet" href="./css/review.css" />

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





	<table>

		<tr>
			<td width="155">商品名稱</td>
			<td width="155">商品圖片</td>
			<td width="125">價格</td>

			<td width="105">數量</td>
			<td width="130">小計</td>
			<td width="130">評價</td>
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
			<span>評價</span>
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


		
				<p>買家評論:</p>
				<input type="TEXT" name="buyerComment" size="45" />
			


		<input type="hidden" name="orderDetailID"
			value="${orderlistVO.orderDetailID}" size="45" /> 
			<input type="hidden" name="buyerReview" id="buyerComment" value="" /> 
			<input type="hidden" name="action" value="update"> 
			<input type="submit" value="送出新增">
	</FORM>
	<br>
	<br>
	<br>


	<form name="checkoutForm" action="Shopping.html" method="POST">

	</form>


	<script src="./js/review.js"></script>
	<script src="./vendors/jquery/jquery-3.4.1.min.js"></script>

</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->



</html>