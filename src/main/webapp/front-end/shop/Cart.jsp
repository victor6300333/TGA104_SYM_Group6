<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.* ,com.orderlist.model.Product"%>
<html>
<head>
<title>Mode II 嚙範嚙課程嚙踝蕭 - Cart.jsp</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ShoppingCart.css">
</head>
<body>

	<br>
	<%
	@SuppressWarnings("unchecked")
	Vector<Product> buylist = (Vector<Product>) session.getAttribute("shoppingcart");
	%>

	<img src="images/tomcat.gif">
	<font size="+3">嚙諍前嚙褊迎蕭嚙踝蕭嚙踝蕭嚙踝蕭嚙箴嚙緘嚙磊嚙瘦嚙稽Cart.jsp嚙稷</font>

	<table id="table-1">
		<tr>
			<td width="140">嚙諉品嚙磕嚙踝蕭</td>
			<td width="120">嚙踝蕭嚙踝蕭</td>
			<td width="95">嚙複量</td>
			<td width="110">嚙踝蕭嚙畿</td>
			<td width="120"><img src="images/view-cart.png"></td>
		</tr>
	</table>
	<table>


		<%
		if (buylist != null && (buylist.size() > 0)) {
		%>




		<%
		for (int index = 0; index < buylist.size(); index++) {
			Product order = buylist.get(index);
		%>





		<tr id="my-car-tr">
			<td width="140"><%=order.getName()%></td>
			<td width="110"><%=order.getPrice()%></td>

			<td id="minus"><input type="button"
				onclick="minuser<%=index + 1%>()" value="-" /></td>
			<td id="<%=index + 1%>"><%=order.getQuantity()%></td>
			<td id="plus"><input type="button" onclick="adder<%=index + 1%>()"
				value="+" /></td>

			<td class="my-car-td" width="120" align="center" valign="middle"
				id="<%=-index - 1%>"><%=order.getPrice() * order.getQuantity()%></td>




			<script src="./jquery/jquery-3.6.1.min.js"></script>
			<script>
		
		function adder<%=index + 1%>() {
			var count = document.getElementById("<%=index + 1%>").innerHTML;
			var sum = document.getElementById("<%=-index - 1%>").innerHTML;
			count = parseInt(count) + 1;
			sum = <%=order.getPrice()%> * count;
			document.getElementById("<%=index + 1%>").innerHTML = count;
			document.getElementById("<%=-index - 1%>").innerHTML = sum;
			
		}
		function minuser<%=index + 1%>() {
			var count = document.getElementById("<%=index + 1%>").innerHTML;
			var sum = document.getElementById("<%=-index - 1%>").innerHTML;
			if (count <= 0) {
				count = 0;
				sum = 0;
			} else {
				count = parseInt(count) - 1;
				sum = <%=order.getPrice()%> * count;
			}

			
			document.getElementById("<%=index + 1%>").innerHTML = count;
			document.getElementById("<%=-index - 1%>").innerHTML = sum;
		}
		
		document.getElementById("total").innerHTML = total;
		
		if (document.getElementById("<%=index + 1%>").innerHTML == 0){
			 $("tr").remove();
		}
	</script>

		</tr>


		<%
		}
		%>


	</table>



	<td id="total" colspan="6" style="text-align: right;"><font
		size="+2"><h4 id="count"></h4> </font></td>
	<table>

	</table>



	<form name="checkoutForm" action="ShopServlet" method="POST">

		<b>收件者: </b><input type="text" name="receiver"> <br>
		<b>電話號碼: </b><input type="text" name="phone"> <br>
		<b>收件地址: </b><input type="text" name="address"> <br>
		<b>付款方式: </b> <input type="radio" name="paytype" value="信用卡">信用卡
		<input type="radio" name="paytype" value="atm轉帳">atm轉帳 
		<input type="radio" name="paytype" value="貨到付款">貨到付款 <br>
		<b>使用購物金: </b> <input type=text name="useShoppingGold">
		<br> <b>使用優惠券: </b> <select name="couponID">
			<option value="0.85">85折</option>
			<option value="0.75">75折</option>
		</select> <br> <input type="hidden" name="action" value="CHECKOUT">
		<input type="submit" value="嚙瘢嚙誹蛛蕭嚙箭" class="button">
	</form>
	<%
	}
	%>


	<script type="text/javascript">
const count = document.querySelector('#count')
// 
const carList = document.querySelectorAll('.my-car-td')
// init total
let total = 0;



function addTotal(){
// for td total
carList.forEach((e)=>{ 
	total += e.textContent
})
// result
count.textContent = total
}

addTotal()

// console.log(total);
// console.log(carList);
</script>


</body>
</html>