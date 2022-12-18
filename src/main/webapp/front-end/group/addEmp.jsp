<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.group6.tibame104.grouporder.model.*"%>
<%@ page import="com.group6.tibame104.group.model.*"%>


<%
GrouporderVO grouporderVO = (GrouporderVO) request.getAttribute("grouporderVO");
GroupVO groupVO = (GroupVO) request.getAttribute("groupVO");

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
				<h3>員工資料新增 - addEmp.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="<%=request.getContextPath()%>/front-end/grouporder/select_page.jsp"><img src="images/back1.gif"
						width="100" height="100" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/grouporder/Grouporder.do" name="form1">
		<table>
			<tr>
				<td>團購編號:</td>
				<td><input type="TEXT" name="groupBuyID" size="45"
					value="<%= (grouporderVO==null)? "1" : grouporderVO.getGroupBuyID()%>" /></td>
			</tr>
			<tr>
				<td>會員編號:</td>
				<td><input type="TEXT" name="memberID" size="45"
					value="<%= (grouporderVO==null)? "1" : grouporderVO.getMemberID()%>" /></td>
			</tr>
			<tr>
				<td>團購商品編號:</td>
				<td><input type="TEXT" name="groupBuyProductID" size="45"
					value="<%= (grouporderVO==null)? "1" : grouporderVO.getGroupBuyProductID()%>" /></td>
			</tr>
			<tr>
				<td>團購數量:</td>
				<td><input type="TEXT" name="groupBuyQuantity" size="45"
					value="<%= (grouporderVO==null)? "100" : grouporderVO.getGroupBuyQuantity()%>" /></td>
			</tr>
			<tr>
				<td>總金額:</td>
				<td><input type="TEXT" name="groupBuyTotal" size="45"
					value="<%= (grouporderVO==null)? "20000" : grouporderVO.getGroupBuyTotal()%>" /></td>
			</tr>
			<tr>
				<td>訂單日期:</td>
				<td><input name="orderTime" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>付款方式:</td>
				<td><input type="TEXT" name="paymentTerm" size="45"
					value="<%= (grouporderVO==null)? "信用卡" : grouporderVO.getPaymentTerm()%>" /></td>
			</tr>
			<tr>
				<td>付款狀態:</td>
				<td><input type="TEXT" name="paymentState" size="45"
					value="<%= (grouporderVO==null)? "0" : grouporderVO.getPaymentState()%>" /></td>
			</tr>
			<tr>
				<td>購物金:</td>
				<td><input type="TEXT" name="giftVoucher" size="45"
					value="<%= (grouporderVO==null)? "50" : grouporderVO.getGiftVoucher()%>" /></td>
			</tr>
			<tr>
				<td>連絡電話:</td>
				<td><input type="TEXT" name="contactNumber" size="45"
					value="<%= (grouporderVO==null)? "0932223567" : grouporderVO.getContactNumber()%>" /></td>
			</tr>
			<tr>
				<td>運送地點:</td>
				<td><input type="TEXT" name="shippingLocation" size="45"
					value="<%= (grouporderVO==null)? "高雄市" : grouporderVO.getShippingLocation()%>" /></td>
			</tr>
		</table>
		<br> <input type="hidden" name="action" value="insert"> 
			<input	type="hidden" name="groupBuyID"
			value="<%=groupVO.getGroupBuyID()%>"> 
			<input	type="hidden" name="groupBuyProductID"
			value="<%=groupVO.getGroupBuyProductID()%>"> 
			<input	type="hidden" name="administratorID"
			value="<%=groupVO.getAdministratorID()%>"> 
			<input type="submit" value="送出新增">
	</FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%
Timestamp orderTime = null;
try {
	orderTime = grouporderVO.getOrderTime();
} catch (Exception e) {
	orderTime = new Timestamp(System.currentTimeMillis());
}
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-end/grouporder/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/back-end/grouporder/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/back-end/grouporder/datetimepicker/jquery.datetimepicker.full.js"></script>


<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:true,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
		   value: '<%=orderTime%>', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});

	// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

	//      1.以下為某一天之前的日期無法選擇
	//      var somedate1 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      2.以下為某一天之後的日期無法選擇
	//      var somedate2 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
	//      var somedate1 = new Date('2017-06-15');
	//      var somedate2 = new Date('2017-06-25');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//		             ||
	//		            date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});
</script>
</html>