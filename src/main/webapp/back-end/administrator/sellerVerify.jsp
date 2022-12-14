<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.administrator.model.*"%>

<html>
<head>
<title>商家審核 - listAllAd2.jsp</title>
</head>
<body>
	<%@ include file="styles.jsp"%>
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
			<nav class="navbar sym-skin navbar-light mb-2rem">
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
							<a href="button.html" class="dropdown-item">廣告設定</a> <a
								href="typography.html" class="dropdown-item">優惠券設定</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i class="fa fa-keyboard me-2"></i>會員管理</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="button.html" class="dropdown-item">會員查詢</a>
						</div>
					</div>

					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"><i class="fa fa-table me-2"></i>團購管理</a>
						<div class="dropdown-menu bg-transparent border-0">
							<a href="button.html" class="dropdown-item">團購訂單</a> <a
								href="button.html" class="dropdown-item">商品管理</a>
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
									<h1 class="m-0 sym-dark-font">賣場申請</h1>
								</div>
								<!-- /.col -->
								<div class="col-sm-6 flex-direction">
									<ol class="breadcrumb float-sm-right">
										<li class="breadcrumb-item"><a href="#">Home</a></li>
										<li class="breadcrumb-item active">會員賣場申請</li>
									</ol>
								</div>
							</div>
						</div>
					</div>
					<!-- /.content-header -->



					<!-- main start -->

					<!-- Main content -->
					<div class="">
						<div class="container-fluid">
							<div class="row">
								<!-- left column -->
								<div class="col-md-12">
									<!-- general form elements -->
									<div class="card card-primary">
										<div class="card-header sym-darkpurple">
											<h3 class="card-title sym-yellow-font">搜尋列表</h3>
										</div>
										<!-- /.card-header -->

										<!-- form start -->
										<form id="memberSearch" METHOD="post"
											ACTION="${pageContext.request.contextPath}/back-end/administrator/administratorServlet">
											<div class="card-body">
												<div class="row">
													<div class="col-sm-12">
														<div class="form-group">
															<div class="row">
																<div class="col-sm-4">
																	<div class="form-group">
																		<div class="row">
																			<div class="col-6 mb-2rem">

																				<label for="cars" class="sym-dark-font "><h5>帳號狀態
																						:</h5></label><br> <select id="cars" name="cars"
																					class="form-control mb-2rem">
																					<option value="volvo">待審核</option>
																					<option value="saab">審核</option>
																				</select> <input id="btnSearchSeller"
																					class="btn sym-darkpurple sym-yellow-font btn_style"
																					value="送出">

																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<!-- /.card-body -->
										</form>

										<div class="col-md-12">
											<div class="card card-primary">
												<div class="card-header sym-darkpurple">
													<h3 class="card-title sym-yellow-font">查詢結果</h3>
												</div>
												<!-- /.card-header -->
												<div class="card-body">
													<table id="searchSeller"
														class="table table-bordered table-hover">
														<thead>
															<tr>
																<!-- 																<th>會員帳號</th> -->
																<!-- 																<th>賣場名稱</th> -->
																<!-- 																<th>賣場地址</th> -->
																<!-- 																<th>連絡電話</th> -->
																<!-- 																<th>創建日期</th> -->
																<!-- 																<th>更新日期</th> -->
																<!-- 																<th>統一編號</th> -->
																<!-- 																<th>審核狀態</th> -->
																<!-- 																<th>審核</th> -->
															</tr>
														</thead>
														<tr>

															<td>
																<!-- 																<FORM METHOD="post" enctype="multipart/form-data" -->
																<%-- 																	ACTION="<%=request.getContextPath()%>/member/MemberServlet" --%>
																<!-- 																	style="margin-bottom: 0px;"> -->
																<button onclick="popupWindow()"
																	class="btn sym-darkpurple sym-yellow-font btn_style">審核</button>

																<!-- 																</FORM> -->
															</td>
														</tr>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>


					<!-- Main content -->
					<div class="">
						<div class="container-fluid">
							<div class="row">
								<!-- left column -->
								<div class="col-md-12">
									<!-- /.card-header -->
									<!-- 									<div class="col-md-12"> -->
									<!-- 										<div class="card card-primary"> -->
									<!-- 											<div class="card-footer mb-2rem"> -->
									<!-- 												<button class="btn sym-darkpurple sym-yellow-font btn_style" -->
									<!-- 													id="addProduct">重置</button> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 									</div> -->
									<!-- /.card-body -->
									<div class="card-footer mb-2rem">

										<!-- /.card-body -->


									</div>
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
						</div>
					</div>
				</div>
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
			</div>
			<!-- Content End -->
		</div>
		<script type="text/javascript" src="script.js"></script>
		<script
			src="${pageContext.request.contextPath}/JQ/jquery-3.6.1.min.js"></script>
		<script>
		function popupWindow() {
		    window.open("popup.jsp", "Popup Window", "width=500,height=500,modal=yes");
		}

		</script>

		<script>
	$(function() {
		var template = 
		`<table class="table table-striped col-sm-12">
			<tr>
			<th>會員帳號</th>
			<th>賣場名稱</th>
			<th>賣場地址</th>
			<th>連絡電話</th>
			<th>創建日期</th>
			<th>更新日期</th>
			<th>統一編號</th>
			<th>審核狀態</th>
			<th>審核</th>
		</tr>
		`;
		
		var str=``;
		function bbb(data){
			str=``;
			let status ='';
			for(let i=0;i<data.length;i++){
				let templateList =   `
					<tr>
						<td>`+data[i].memberID+`</td>
						<td>`+data[i].storeName+`</td>
						<td>`+data[i].storeAddress+`</td>
						<td>`+data[i].phoneNumber+`</td>
						<th>`+data[i].createDate+`</th>
						<td>`+data[i].updateDate+`</td>
						<td>`+data[i].taxID+`</td>
						<td>待審核</td>
						<th><a href="${pageContext.request.contextPath}/back-end/administrator/AdminMailServlet?memberID=`+data[i].memberID+`"><button class="btn sym-darkpurple sym-yellow-font btn_style mg-bottom-2 margin-left-2">送出</button></a></th>
					</tr>
				`;
				str = str + templateList;
			}
		}
		var str2=`</table>`;
		
		
		$("#btnSearchSeller")
				.click(
						function() {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/back-end/administrator/administratorServlet",
										// 資料請求的網址
										type : "GET", // GET | POST | PUT | DELETE | PATCH
										dataType : "json", // 預期會接收到回傳資料的格式： json | xml | html
										success : function(data) {
											// request 成功取得回應後執行
											console.log(data);
											bbb(data);
											//console.log(str);
											//console.log(data[0].productID+"哭啊");
											console.log(data.length);
											$("#searchSeller").html("<h2>搜尋結果總共有"+data.length+"筆</h2>"+template+str+str2);
										},
										error : function(XMLHttpRequest) {
											if (XMLHttpRequest.status >= 400) {
												alert("出現錯誤");
											}
										}
									});
						});
	});
</script>
</body>
</html>