<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<%@ page import="java.util.*"%>
<%@ page import="com.orderlist.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>






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


<table id="table-1">
	<tr><td>
		 <h3>已送出評價</h3>
		
	</td></tr>
</table>

<table>
	<tr>
		<th>訂單明細ID</th>
		<th>訂單ID</th>
		<th>商品ID</th>
		<th>數量</th>
		<th>單價</th>
		<th>小計</th>
		<th>買家評價</th>
		<th>買家評論</th>
	</tr>
		
		<tr>
			<td>${orderlistVO.getOrderDetailID()}</td>
			<td>${orderlistVO.getOrderID()}</td>
			<td>${orderlistVO.getProductID()}</td>
			<td>${orderlistVO.getQuantity()}</td>
			<td>${orderlistVO.getPrice()}</td>
			<td>${orderlistVO.getSubTotal()}</td> 
		
			<td>${orderlistVO.getBuyerReview()}</td>
			<td>${orderlistVO.getBuyerComment()}</td>
			
		</tr>
		

</table>


</body>
</html>