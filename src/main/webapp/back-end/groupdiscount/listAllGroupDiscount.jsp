<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group6.tibame104.groupdiscount.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>




<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>DASHMIN - Bootstrap Admin Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="keywords" />
<meta content="" name="description" />

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon" />

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
	rel="stylesheet" />

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet" />

<!-- Libraries Stylesheet -->
<link
	href="${pageContext.request.contextPath}/back-end/groupdiscount/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/back-end/groupdiscount/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link
	href="${pageContext.request.contextPath}/back-end/groupdiscount/css/bootstrap.min.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->
<link
	href="${pageContext.request.contextPath}/back-end/groupdiscount/css/style.css"
	rel="stylesheet" />

<!--Admin-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/back-end/groupdiscount//css/admin.css" />
</head>

<body>
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
						<img src="./img/logoSYM.jpg" alt="logo" width="100%" />
					</h3>
				</a>
				<div class="d-flex align-items-center ms-4 mb-4">
					<div class="position-relative">
						<img class="rounded-circle" src="./img/logoSYM3.jpg" alt=""
							style="width: 40px; height: 40px" />
						<div
							class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1">
						</div>
					</div>
					<div class="ms-3">
						<!-- <h4 class="mb-0">歡迎您~</h4> -->
						<span>
							<h5>Admin</h5>
						</span>
					</div>
				</div>
				<div class="navbar-nav w-100">
					<a href="index.html" class="nav-item nav-link "><i
						class="fa fa-tachometer-alt me-2"></i>管理員資料</a>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i
							class="fa fa-tachometer-alt me-2"></i>公告管理</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="./announcement.html" class="dropdown-item">公告消息管理</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>商家管理</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="button.html" class="dropdown-item">商家審核</a> <a
								href="typography.html" class="dropdown-item">商家查詢</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i class="fa fa-th me-2"></i>活動管理</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="./advertise.html" class="dropdown-item">廣告設定</a> <a
								href="typography.html" class="dropdown-item">優惠券設定</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i class="fa fa-keyboard me-2"></i>會員管理</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="./member.html" class="dropdown-item">會員查詢</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle active"
							data-bs-toggle="dropdown"><i class="fa fa-table me-2"></i>團購管理</a>
						<div class="dropdown-menu bg-transparent border-0 show">
						<a
								href="${pageContext.request.contextPath}/back-end/grouporder/listAllGroupOrder.jsp"
								class="dropdown-item">團購訂單管理</a>
								<a
								href="${pageContext.request.contextPath}/back-end/group/listAllGroup.jsp"
								class="dropdown-item">團購管理</a>
								 <a href="href="${pageContext.request.contextPath}/back-end/groupproduct/listAllGroupProducts.jsp" class="dropdown-item">商品管理</a>
								 <a href="href="${pageContext.request.contextPath}/back-end/groupdiscount/listAllGroupDiscount.jsp" class="dropdown-item">折扣管理</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i class="fa fa-chart-bar me-2"></i>客服中心</a>
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
							data-bs-toggle="dropdown"> <i class="fa fa-envelope me-lg-2"></i>
							<span class="d-none d-lg-inline-flex">聊聊</span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end border-0 rounded-0 rounded-bottom m-0">
							<a href="#" class="dropdown-item">
								<div class="d-flex align-items-center">
									<img class="rounded-circle" src="./img/logoSYM3.jpg" alt=""
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
									<img class="rounded-circle" src="./img/logoSYM3.jpg" alt=""
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
									<img class="rounded-circle" src="./img/logoSYM3.jpg" alt=""
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
							data-bs-toggle="dropdown"> <i class="fa fa-bell me-lg-2"></i>
							<span class="d-none d-lg-inline-flex">通知</span>
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
							class="rounded-circle me-lg-2" src="./img/logoSYM3.jpg" alt=""
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

			<!-- Table Start -->

			<!-- Recent Sales Start -->
			<div class="container-fluid pt-4 px-4">
				<!-- Content Header (Page header) -->
				<div class="content-header">
					<div class="container-fluid">
						<div class="row mb-2">
							<div class="col-sm-6">
								<h2 class="m-0 sym-dark-font">團購管理 / 折扣設定</h2>
							</div>
							<!-- /.col -->
							<div class="col-sm-6 flex-direction">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item active">新增 / 修改折扣</li>
								</ol>
							</div>
							<!-- /.col -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.container-fluid -->
				</div>
				<!-- /.content-header -->
				<div class="sym-yellow-bk text-center rounded p-4">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<a
							class="btn btn-sm card-header sym-darkpurple sym-yellow-font font-m btn_style"
							href="${pageContext.request.contextPath}/back-end/groupdiscount/addGroupDiscount.jsp">新增折扣</a>
					</div>
					<div class="table-responsive">
					            <input type="text" class="form-control border-1" id="reserve_search" type="search" placeholder="輸入欲查詢的團購編號" onkeyup="searchFunction()">
						<br>
						<div class="card card-primary">
							<table
								class="table text-start align-middle table-bordered table-hover mb-0"
								id="reserver_detail">
								<thead>
									<tr class="text-dark">
										<th scope="col">折扣編號</th>
										<th scope="col">團購編號</th>
										<th scope="col">團購人數</th>
										<th scope="col">折扣數</th>
										<th scope="col">修改</th>
										<th scope="col">刪除</th>
									</tr>
								</thead>
								<tbody>
								
									<c:forEach var="groupdiscountVOs" items="${groupdiscountVOs}">

										<tr>
											<td>${groupdiscountVOs.countTableID}</td>
											<FORM METHOD="post"
													ACTION="${pageContext.request.contextPath}/Groupdiscount/update"
													style="margin-bottom: 0px;">
											<td><input type="text" name="groupBuyID" value="${groupdiscountVOs.groupBuyID}"></td>
											<td><input type="text" name="groupBuyProductOrderTotal" value="${groupdiscountVOs.groupBuyProductOrderTotal}"></td>
											<td><input type="text" name="groupBuyCount" value="${groupdiscountVOs.groupBuyCount}"></td>
											<td>
												
													<input type="submit" class="btn sym-darkpurple sym-yellow-font btn_style" value="修改"> <input
														type="hidden" name="countTableID"
														value="${groupdiscountVOs.countTableID}"> 
												</FORM>
											</td>
											<td>
												<FORM METHOD="post"
													ACTION="${pageContext.request.contextPath}/Groupdiscount/delete"
													style="margin-bottom: 0px;">
													<input type="submit" class="btn sym-darkpurple sym-yellow-font btn_style" value="刪除" > <input
														type="hidden" name="countTableID"
														value="${groupdiscountVOs.countTableID}"> <input
														type="hidden" name="action" value="delete">
												</FORM>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- Recent Sales End -->
			<!-- Table End -->
			<!--content end-->

			<!--session start-->
			<div class="col-sm-12 col-md-7">
				<div class="dataTables_paginate paging_simple_numbers"
					id="example2_paginate"></div>
			</div>
			<!--session ends-->

			<!-- Footer Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="bg-light rounded-top p-4">
					<div class="row">
						<div class="col-12 col-sm-6 text-center text-sm-start">
							&copy; <a href="#">Tibame TGA104 第六組 SYM</a>, All Right Reserved.
						</div>
						<div class="col-12 col-sm-6 text-center text-sm-end">
							<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
							Designed By <a href="https://htmlcodex.com">HTML Codex</a>
						</div>
					</div>
				</div>
			</div>
			<!-- Footer End -->
		</div>

		<!-- Back to Top -->
		<a href="#"
			class="btn btn-lg sym-darkpurple sym-yellow-font btn-lg-square back-to-top btn_style"><i
			class="bi bi-arrow-up"></i></a>
	</div>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/chart/chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/easing/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/waypoints/waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/owlcarousel/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/tempusdominus/js/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/js/main.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/js/admin.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/groupdiscount/js/search.js"></script>
		
		
</body>

</html>