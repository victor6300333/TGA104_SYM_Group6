<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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


	------------------------------------------
	<h1>更多查詢</h1>
	<FORM METHOD="post"
		ACTION="${pageContext.request.contextPath}/SearchServlet" >
	
		<div>
			<label>商品名稱：</label> 
			<input type="text" id="p_name" class="form-control" name="productName" />
		</div>
		<!-- 
		<input type="hidden" name="action" value="getAll_For_More_Display">
		-->
		<input type="submit" value="送出查詢"> 
	</FORM>
</body>



</html>