<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Emp: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM Emp: Home</h3>
   <a href="<%=request.getContextPath()%>/front-end/grouporder/select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/grouporder/images/back1.gif"
width="100" height="32" border="0">回首頁</a>
<h4>( MVC )</h4></td></tr>
   
</table>

<p>This is the Home page for IBM Emp: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
<li><a href='<%=request.getContextPath()%>/back-end/grouporder/listAllGroupOrder.jsp'>List</a> all Emps.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION='<%=request.getContextPath()%>/front-end/grouporder/Grouporder.do' >
        <b>輸入團購訂單編號 (如1):</b>
        <input type="text" name="groupBuyOrderID">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="grouporderSvc" scope="page" class="com.grouporder.model.GrouporderService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/grouporder/Grouporder.do" >
       <b>選擇團購訂單編號:</b>
       <select size="1" name="groupBuyOrderID">
         <c:forEach var="grouporderVO" items="${grouporderSvc.all}" > 
          <option value="${grouporderVO.groupBuyOrderID}">${grouporderVO.groupBuyOrderID}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
    <FORM METHOD="post" ACTION='<%=request.getContextPath()%>/front-end/grouporder/Grouporder.do' >
        <b>輸入會員編號 (如1):</b>
        <input type="text" name="memberID">
        <input type="hidden" name="action" value="getOrder_By_Mem">
        <input type="submit" value="送出">
    </FORM>
  </li>
</ul>


<h3>員工管理</h3>


<ul>
  <li><a href="<%=request.getContextPath()%>/back-end/grouporder/addEmp.jsp">Add</a> a new Emp.</li>
</ul>

</body>
</html>