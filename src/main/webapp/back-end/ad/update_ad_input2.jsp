<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.ad.model.*"%>

<%
AdVO adVO = (AdVO) request.getAttribute("adVO"); //EmpServlet.java (Concroller) 存入req的advVO物件 (包括幫忙取出的advVO, 也包括輸入資料錯誤時的advVO物件)
%>
<%-- --<%= adVO==null %>--${adVO.groupBuyID()}-- --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>廣告資料修改 - update_ad_input2.jsp</title>
</head>
<body>
<%@ include file="styles.jsp" %>

<div class="container-fluid position-relative bg-white d-flex p-0">
	<!-- Spinner Start -->
<div id="spinner"
	class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
	<div class="spinner-border text-primary"
		style="width: 3rem; height: 3rem" role="status">
		<span class="sr-only">Loading...</span>
	</div>
</div>
<!-- Spinner End -->

<!-- Sidebar Start -->
<div class="sidebar pe-4 pb-3 sym-skin">
	<nav class="navbar sym-skin navbar-light">
		<a href="index.html" class="navbar-brand mx-4 mb-3">
			<h3 class="text-primary">
				<img src="../img/logoSYM.jpg" alt="logo" width="100%" />
			</h3>
		</a>
		<div class="d-flex align-items-center ms-4 mb-4">
			<div class="position-relative">
				<img class="rounded-circle" src="../img/logoSYM3.jpg" alt=""
					style="width: 40px; height: 40px" />
	<div
		class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
</div>
<div class="ms-3">
	<!-- <h4 class="mb-0">歡迎您~</h4> -->
				<span><h5>Admin</h5></span>
			</div>
		</div>
		<div class="navbar-nav w-100">
			<a href="index.html" class="nav-item nav-link active"><i
				class="fa fa-tachometer-alt me-2"></i>管理員資料</a>

			<div class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle"
					data-bs-toggle="dropdown"><i
					class="fa fa-tachometer-alt me-2"></i>公告管理</a>
				<div class="dropdown-menu bg-transparent border-0">
					<a href="typography.html" class="dropdown-item">公告消息管理</a>
				</div>
			</div>

			<div class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle"
					data-bs-toggle="dropdown"><i
					class="fa fa-laptop me-2"></i>商家管理</a>
				<div class="dropdown-menu bg-transparent border-0">
					<a href="button.html" class="dropdown-item">商家審核</a> <a
						href="typography.html" class="dropdown-item">商家查詢</a>
				</div>
			</div>

			<div class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle"
					data-bs-toggle="dropdown"><i
					class="fa fa-th me-2"></i>活動管理</a>
				<div class="dropdown-menu bg-transparent border-0">
					<a href="button.html" class="dropdown-item">廣告設定</a> <a
						href="typography.html" class="dropdown-item">優惠券設定</a>
				</div>
			</div>

			<div class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle"
					data-bs-toggle="dropdown"><i
					class="fa fa-keyboard me-2"></i>會員管理</a>
				<div class="dropdown-menu bg-transparent border-0">
					<a href="button.html" class="dropdown-item">會員查詢</a>
				</div>
			</div>

			<div class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle"
					data-bs-toggle="dropdown"><i
					class="fa fa-table me-2"></i>團購管理</a>
				<div class="dropdown-menu bg-transparent border-0">
					<a href="button.html" class="dropdown-item">團購訂單</a> <a
						href="button.html" class="dropdown-item">商品管理</a>
				</div>
			</div>

			<div class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle"
					data-bs-toggle="dropdown"><i
					class="fa fa-chart-bar me-2"></i>客服中心</a>
				<div class="dropdown-menu bg-transparent border-0">
					<a href="button.html" class="dropdown-item">平台幫助中心</a>
				</div>
			</div>
		</div>
	</nav>
</div>
<!-- Sidebar End -->


<!-- Content Start -->
<div class="content sym-yellow-bk">
	<!-- Navbar Start -->
<nav
	class="navbar navbar-expand sym-skin sticky-top px-4 py-0 mb-2rem">
	<a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
		<h2 class="text-primary mb-0">
			<i class="fa fa-hashtag"></i>
		</h2>
	</a> <a href="#" class="sidebar-toggler flex-shrink-0"> <i
		class="fa fa-bars"></i>
	</a>

	<div class="navbar-nav align-items-center ms-auto">
		<div class="nav-item dropdown">
			<a href="#" class="nav-link dropdown-toggle"
				data-bs-toggle="dropdown"> <i
				class="fa fa-envelope me-lg-2"></i> <span
				class="d-none d-lg-inline-flex">聊聊</span>
			</a>
			<div
				class="dropdown-menu dropdown-menu-end border-0 rounded-0 rounded-bottom m-0">
				<a href="#" class="dropdown-item">
					<div class="d-flex align-items-center">
						<img class="rounded-circle" src="../img/logoSYM3.jpg" alt=""
							style="width: 40px; height: 40px" />
		<div class="ms-2">
			<h6 class="fw-normal mb-0">message</h6>
			<small>15 minutes ago</small>
		</div>
	</div>
</a>
<hr class="dropdown-divider" />
<a href="#" class="dropdown-item">
	<div class="d-flex align-items-center">
		<img class="rounded-circle" src="../img/logoSYM3.jpg" alt=""
			style="width: 40px; height: 40px" />
		<div class="ms-2">
			<h6 class="fw-normal mb-0">message</h6>
			<small>15 minutes ago</small>
		</div>
	</div>
</a>
<hr class="dropdown-divider" />
<a href="#" class="dropdown-item">
	<div class="d-flex align-items-center">
		<img class="rounded-circle" src="../img/logoSYM3.jpg" alt=""
			style="width: 40px; height: 40px" />
				<div class="ms-2">
					<h6 class="fw-normal mb-0">message</h6>
					<small>15 minutes ago</small>
				</div>
			</div>
		</a>
		<hr class="dropdown-divider" />
		<a href="#" class="dropdown-item text-center">所有消息</a>
	</div>
</div>
<div class="nav-item dropdown">
	<a href="#" class="nav-link dropdown-toggle"
		data-bs-toggle="dropdown"> <i
		class="fa fa-bell me-lg-2"></i> <span
		class="d-none d-lg-inline-flex">通知</span>
	</a>
	<div
		class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
		<a href="#" class="dropdown-item">
			<h6 class="fw-normal mb-0">公告消息更新</h6> <small>15 minutes
				ago</small>
		</a>
		<hr class="dropdown-divider" />
		<a href="#" class="dropdown-item">
			<h6 class="fw-normal mb-0">會員審核申請</h6> <small>15 minutes
				ago</small>
		</a>
		<hr class="dropdown-divider" />
		<a href="#" class="dropdown-item">
			<h6 class="fw-normal mb-0">廣告上架更新</h6> <small>15 minutes
				ago</small>
		</a>
		<hr class="dropdown-divider" />
		<a href="#" class="dropdown-item text-center">所有通知</a>
	</div>
</div>
<div class="nav-item dropdown">
	<a href="#" class="nav-link dropdown-toggle"
		data-bs-toggle="dropdown"> <img
		class="rounded-circle me-lg-2" src="../img/logoSYM3.jpg" alt=""
		style="width: 40px; height: 40px" /> <span
				class="d-none d-lg-inline-flex">歡迎您~ Admin</span>
			</a>
			<div
				class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
				<a href="#" class="dropdown-item">個人中心</a> <a href="#"
					class="dropdown-item">設定</a> <a href="#" class="dropdown-item">登出</a>
			</div>
		</div>
	</div>
</nav>
<!-- Navbar End -->

<!-- Content starts-->
<div class="wrapper">
	<header id="header"></header>
	<!-- Main Sidebar Container 主側邊欄-->
<aside id="sidebar"
	class="main-sidebar sidebar-dark-primary elevation-4"></aside>
<!-- Content Wrapper. Contains page content 主頁面欄位-->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
<div class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h2 class="m-0 sym-dark-font">廣告設定 - 修改廣告</h2>
			</div>
			<!-- /.col -->
<div class="col-sm-6 flex-direction">
	<ol class="breadcrumb float-sm-right">
		<li class="breadcrumb-item"><a href="select_page2.jsp">Home</a>
		</li>
		<li class="breadcrumb-item active">廣告設定</li>
	</ol>
</div>
<!-- /.col -->
</div>
<!-- /.row -->
</div>
<!-- /.container-fluid -->
</div>
<!-- /.content-header -->

<!-- Main content -->
<div class="">
	<div class="container-fluid">
		<div class="row">
			<!-- left column -->
<div class="col-md-12">
	<!-- general form elements -->
<div class="card card-primary">
	<div class="card-header sym-darkpurple">
		<h3 class="card-title sym-yellow-font">廣告設定 - 修改廣告</h3>
	</div>
	<!-- /.card-header -->
<!-- form start -->




<FORM METHOD="post" enctype="multipart/form-data"
	ACTION="<%=request.getContextPath()%>/back-end/ad/adServlet"
name="form1"> 

<div class="card-body">
	<div class="form-group">
		<div class="col-sm-4 mg-bottom-2">
			<label class="sym-dark-font sym-dark-font font-m"><h5>廣告編號</h5></label>
			<select class="form-control" id="proCategory">
				<option value="廣告編號"><%=adVO.getAdSerialID()%></option>

	</select>
</div>


<%--             <jsp:useBean id="adSvc" scope="page" class="com.ad.model.AdService" /> --%>
<!-- 			<tr> -->
<!-- 				<td>廣告類別:<font color=red><b>*</b></font></td> -->
<!-- 				<td><select size="1" name="adType"> -->
<%-- 						<c:forEach var="adVO" items="${adSvc.all}"> --%>
<%-- 							<option value="${adVO.adType}" --%>
<%-- 								${(adVO.adSerialID==adVO.adSerialID)?'selected':'' }>${adVO.adType} --%>
<%-- 						</c:forEach> --%>
<!-- 				</select></td> -->
<!-- 			</tr> -->

<div class="row">
	<div class="col-sm-4">
		<div class="form-group">
			<label class="sym-dark-font"><h5>團購編號</h5></label>

			<select class="form-control" id="proCategory">
				<option value="團購編號">1</option>
			</select>
		</div>
	</div>
</div>
<br />



<div class="form-group">
	<div class="display-flex mg-bottom-2">
		<div class="col-sm-4">
			<div class="form-group">
				<label class="sym-dark-font"><h5>開始日期</h5></label>
				<input name="adStartDate" type="date"
					class="form-control" id="start_date"
					placeholder="開始日期" />
			</div>
		</div>
		<div class="col-sm-4 margin-left-1">
			<div class="form-group">
				<label class="sym-dark-font"><h5>結束日期:</h5>
				</label> <input name="adEndDate" type="date"
					class="form-control" id="end_date" placeholder="結束日期" />
			</div>
		</div>
	</div>

	<label for="productNameInput" class="sym-dark-font"><h5>廣告標題</h5></label>
	<input type="TEXT" name="adTitle"
		class="form-control mb-2rem" id="proName"
		placeholder="請輸入標題內容" value="<%=adVO.getAdTitle()%>" />

<div class="row">
	<div class="col-sm-4">
		<div class="form-group">
			<label for="proPrice" class="sym-dark-font"><h5>廣告描述:</h5></label>
			<input type="TEXT" name="adDescribe"
				class="form-control" id="proPrice"
				placeholder="請輸入廣告描述"
				value="<%=adVO.getAdDescribe()%>" /> <br />

<form action="../api/0.01/product/uploadImage"
	method="post" id="upload">

	<div class="form-group">
		<label for="proPicture" class="sym-dark-font"><h5>廣告圖片</h5></label>
		<div class="bg-light color-palette"
			style="border: 1px dashed; height: 180px; text-align: center; line-height: 180px;"
			id="picPreview">預覽圖
		</div>
		<div class="input-group">
				<div class="custom-file">
							<input name="data" type="file"
								class="custom-file-input" name="upfile"
								id="p_file" accept="image/*" />
							<label class="custom-file-label" for="proPicture"></label>
						</div>
				<div class="input-group-append sym-darkpurple">
							<input
								class="input-group-text sym-darkpurple sym-yellow-font btn_style"
								type="submit" />
						</div>
		</div>
	</div>
</form>
		</div>
	</div>
</div>
<!-- /.card-body -->
<div class="card-footer">
	<button
		class="btn sym-darkpurple sym-yellow-font btn_style"
		type="hidden" name="action" value="update">
		送出修改
		</button>
		<input type="hidden" name="adSerialID"
			value="<%=adVO.getAdSerialID()%>" id="addProduct">
<!-- 		<input type="submit" value="送出修改"> -->


	</div>

</div>
<!-- /.card -->
	<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
<font style="color: red">請修正以下錯誤:</font>
<ul>
	<c:forEach var="message" items="${errorMsgs}">
<li style="color: red">${message}</li>
</c:forEach>
</ul>
</c:if>
	</div>
</div>
<!-- /.row -->
</div>
<!-- /.container-fluid -->
</div>

<!-- /.content -->
</div>

</FORM>

<!-- Footer Start -->
<div class="container-fluid pt-4 px-4">
	<div class="bg-light rounded-top p-4">
		<div class="row">
			<div class="col-12 col-sm-6 text-center text-sm-start">
				&copy; <a href="#">Tibame TGA104 第六組 SYM</a>, All Right
				Reserved.
			</div>
			<div class="col-12 col-sm-6 text-center text-sm-end">
				<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
				Designed By <a href="https://htmlcodex.com">HTML Codex</a>
			</div>
		</div>
	</div>
</div>
<!-- Footer End -->
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>


<!-- JavaScript Libraries -->

<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
           theme: '',              //theme: 'dark',
 	       timepicker:false,       //timepicker:true,
 	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
 	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
 		   value: '<%=adVO.getUpdateTime()%>
	', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});

</script>
<script>
	$.datetimepicker.setLocale('zh'); // kr ko ja en
	$(function() {
		$('#start_date').datetimepicker(
				{
					format : 'Y-m-d',
					onShow : function() {
						this.setOptions({
							maxDate : $('#end_date').val() ? $('#end_date')
									.val() : false
						})
					},
					timepicker : false
				});

		$('#end_date').datetimepicker(
				{
					format : 'Y-m-d',
					onShow : function() {
						this.setOptions({
							minDate : $('#start_date').val() ? $('#start_date')
									.val() : false
						})
					},
					timepicker : false
				});
	});
</script>


</html>