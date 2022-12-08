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
   <tr><td><h3>會員查詢: Home</h3><h4>select_page.jsp ( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Emp: Home</p>

<h3>查詢列表:</h3>
	
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
  <li><a href='listAllEmp.jsp'>所有會員.</a><br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/Administrator/AdministratorServlet" >
        <b>輸入會員編號 :</b>
        <input type="text" name="memberID">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>


  <jsp:useBean id="adminSVC" scope="page" class="com.administrator.model.AdministratorService"/>
  
  <%
           	com.administrator.model.AdministratorJDBCDAO dao = new com.administrator.model.AdministratorJDBCDAO();
            pageContext.setAttribute("dao", dao);
    %>
  

</ul>


<h3>廠商管理</h3>

<ul>
  <li><a href='update_emp_input.jsp'>賣場審核.</a></li>
</ul>

</body>
</html>