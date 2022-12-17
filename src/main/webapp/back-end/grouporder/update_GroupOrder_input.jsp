<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.grouporder.model.*"%>


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
	href="<%=request.getContextPath()%>/back-end/grouporder/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/back-end/grouporder/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link
	href="<%=request.getContextPath()%>/back-end/grouporder/css/bootstrap.min.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->
<link
	href="<%=request.getContextPath()%>/back-end/grouporder/css/style.css"
	rel="stylesheet" />

<!--Admin-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/grouporder/css/admin.css" />

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>


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
						<img
							src="<%=request.getContextPath()%>/back-end/grouporder//img/logoSYM.jpg"
							alt="logo" width="100%" />
					</h3>
				</a>
				<div class="d-flex align-items-center ms-4 mb-4">
					<div class="position-relative">
						<img class="rounded-circle"
							src="<%=request.getContextPath()%>/back-end/grouporder/img/logoSYM3.jpg"
							alt="" style="width: 40px; height: 40px" />
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
					<a href="index.html" class="nav-item nav-link active"><i
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
								href="<%=request.getContextPath()%>/back-end/grouporder/listAllGroupOrder.jsp"
								class="dropdown-item">團購訂單管理</a>
								<a
								href="<%=request.getContextPath()%>/back-end/group/listAllGroup.jsp"
								class="dropdown-item">團購管理</a>
								 <a href="<%=request.getContextPath()%>/back-end/groupproduct/listAllGroupProducts.jsp" class="dropdown-item">商品管理</a>
								 <a href="<%=request.getContextPath()%>/back-end/groupdiscount/listAllGroupDiscount.jsp" class="dropdown-item">折扣管理</a>
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
									<img class="rounded-circle"
										src="<%=request.getContextPath()%>/back-end/grouporder/img/logoSYM3.jpg"
										alt="" style="width: 40px; height: 40px" />
									<div class="ms-2">
										<h6 class="fw-normal mb-0">message</h6>
										<small>15 minutes ago</small>
									</div>
								</div>
							</a>
							<hr class="dropdown-divider" />
							<a href="#" class="dropdown-item">
								<div class="d-flex align-items-center">
									<img class="rounded-circle"
										src="<%=request.getContextPath()%>/back-end/grouporder/img/logoSYM3.jpg"
										alt="" style="width: 40px; height: 40px" />
									<div class="ms-2">
										<h6 class="fw-normal mb-0">message</h6>
										<small>15 minutes ago</small>
									</div>
								</div>
							</a>
							<hr class="dropdown-divider" />
							<a href="#" class="dropdown-item">
								<div class="d-flex align-items-center">
									<img class="rounded-circle"
										src="<%=request.getContextPath()%>/back-end/grouporder/img/logoSYM3.jpg"
										alt="" style="width: 40px; height: 40px" />
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
							class="rounded-circle me-lg-2"
							src="<%=request.getContextPath()%>/back-end/grouporder/img/logoSYM3.jpg"
							alt="" style="width: 40px; height: 40px" /> <span
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
									<h2 class="m-0 sym-dark-font">團購設定 - 編輯團購</h2>
								</div>
								<!-- /.col -->
								<div class="col-sm-6 flex-direction">
									<ol class="breadcrumb float-sm-right">
										<li class="breadcrumb-item"><a href="#">Home</a></li>
										<li class="breadcrumb-item active">編輯團購</li>
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
											<h3 class="card-title sym-yellow-font">團購設定 - 編輯團購</h3>
										</div>
										<!-- /.card-header -->
										<%-- 錯誤表列 --%>
										<c:if test="${not empty errorMsgs}">
											<font style="color: red">請修正以下錯誤:</font>
											<ul>
												<c:forEach var="message" items="${errorMsgs}">
													<li style="color: red">${message}</li>
												</c:forEach>
											</ul>
										</c:if>
										<!-- form start -->
										<form METHOD="post" ACTION="Grouporder.do" name="form1">
											<div class="card-body">
												<div class="form-group">
													<div class="row">
														<div class="col-sm-4 mg-bottom-2">
															<label class="sym-dark-font sym-dark-font font-m"></label>
															<h5>團購訂單編號</h5>
															</label>
															<td>${grouporderVO.groupBuyOrderID}</td>
														</div>
														<div class="row" style="padding-bottom: 20px;">
															<div class="col-sm-4">
																<div class="form-group">
																	<label class="sym-dark-font">
																		<h5>訂單日期</h5>
																	</label> <input type="text" class="form-control"
																		name="orderTime" id="f_date1" placeholder="訂單日期"
																		style="margin-bottom: 30px" readonly unselectable="on" />
																</div>
															</div>
															<div class="row">
																<div class="col-sm-4">
																	<div class="form-group">
																		<label for="memberID" class="sym-dark-font">
																			<h5>會員編號</h5>
																		</label> <input type="text" class="form-control"
																			name="memberID" id="memberID" placeholder="會員編號"
																			value="${grouporderVO.memberID}" /> <br>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-sm-4">
																	<label for="groupBuyID" class="sym-dark-font">
																		<h5>團購編號</h5>
																	</label> <input type="text" class="form-control mb-2rem"
																		id="groupBuyID" name="groupBuyID" placeholder="團購編號"
																		value="${grouporderVO.groupBuyID}" />
																</div>
																<div class="col-sm-4">
																	<label for="groupBuyProductID" class="sym-dark-font">
																		<h5>團購商品ID</h5>
																	</label> <input type="text" class="form-control mb-2rem"
																		id="groupBuyProductID" name="groupBuyProductID"
																		placeholder="團購商品ID"
																		value="${grouporderVO.groupBuyProductID}" />
																</div>
															</div>
															<div class="row">
																<div class="col-sm-4">
																	<div class="form-group">
																		<label for="groupBuyQuantity" class="sym-dark-font">
																			<h5>團購數量</h5>
																		</label> <input type="text" class="form-control"
																			id="groupBuyQuantity" name="groupBuyQuantity"
																			placeholder="請輸入團購數量"
																			value="${grouporderVO.groupBuyQuantity}" />
																	</div>
																</div>
																<div class="col-sm-4">
																	<div class="form-group">
																		<label for="groupBuyTotal" class="sym-dark-font">
																			<h5>總金額</h5>
																		</label> <input type="text" class="form-control"
																			id="groupBuyTotal" name="groupBuyTotal"
																			placeholder="請輸入總金額"
																			value="${grouporderVO.groupBuyTotal}" />
																	</div>
																</div>
																<div class="row">
																	<div class="col-sm-4">
																		<br>
																		<div class="form-group">
																			<label for="paymentTerm" class="sym-dark-font">
																				<h5>付款方式</h5>
																			</label> <input type="text" class="form-control"
																				id="paymentTerm" name="paymentTerm"
																				placeholder="請輸入付款方式"
																				value="${grouporderVO.paymentTerm}" />
																		</div>
																	</div>
																	<div class="col-sm-4">
																		<br>
																		<div class="form-group">
																			<label for="paymentState" class="sym-dark-font">
																				<h5>付款狀態</h5>
																			</label> <input type="text" class="form-control"
																				id="paymentState" name="paymentState"
																				placeholder="請輸入付款狀態"
																				value="${grouporderVO.paymentState}" />
																		</div>
																	</div>
																	<div class="col-sm-4">
																		<br>
																		<div class="form-group">
																			<label for="giftVoucher" class="sym-dark-font">
																				<h5>購物金</h5>
																			</label> <input type="text" class="form-control"
																				id="giftVoucher" name="giftVoucher"
																				placeholder="購物金"
																				value="${grouporderVO.giftVoucher}" />
																		</div>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-sm-4">
																	<br>
																	<div class="form-group">
																		<label for="contactNumber" class="sym-dark-font">
																			<h5>連絡電話</h5>
																		</label> <input type="text" class="form-control"
																			id="contactNumber" name="contactNumber"
																			placeholder="請輸入連絡電話"
																			value="${grouporderVO.contactNumber}" />
																	</div>
																</div>
																<div class="col-sm-4">
																	<br>
																	<div class="form-group">
																		<label for="shippingLocation" class="sym-dark-font">
																			<h5>寄送地址</h5>
																		</label> 
																		<select id = "city" name="city">
																		    <option value = "">請選擇</option>
																		</select>
<!-- 																		第二層選單(先隱藏，選完第一層後再出現) -->
																		<select id = "area" name="area" style="display:none;">
																		    <option value = "">請選擇</option>
																		</select>
																		<input type="text" class="form-control"
																			id="shippingLocation" name="shippingLocation"
																			placeholder="寄送地址"
																			value="${grouporderVO.shippingLocation}" /> <br>
																	</div>
																</div>
															</div>

															<!-- /.card-body -->
															<div class="card-footer">
																<div class="row">


																	<div class="col-sm-9"></div>
																	<div class="col-sm-3">
																		<input type="hidden" name="action" value="update">
																		<input type="hidden" name="groupBuyOrderID"
																			value="${grouporderVO.groupBuyOrderID}">

																		<button
																			class="btn sym-darkpurple sym-yellow-font btn_style">送出編輯</button>
																		<!-- <button class="btn btn-primary">
                                                    儲存並下架
                                                </button>
                                                <button class="btn btn-primary">
                                                    儲存並上架
                                                </button> -->
																		<!-- <button
                                                    class="btn btn-default float-right"
                                                >
                                                    取消
                                                </button> -->
																	</div>
																</div>
															</div>
														</div>
														<!-- /.card -->
													</div>
												</div>
												<!-- /.row -->
											</div>
										</form>
										<!-- /.container-fluid -->
									</div>
									<!-- /.content -->
								</div>
								<!-- ============ Footer段落 ============ -->
								<footer id="footer" class="main-footer"></footer>
								<!-- Control Sidebar -->
								<aside class="control-sidebar control-sidebar-dark">
									<!-- Control sidebar content goes here -->
								</aside>
								<!-- /.control-sidebar -->
								<!-- ============ Footer段落 ============ -->
								<!-- /.content-wrapper -->
							</div>
							<!-- Content ends-->

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

						<!-- Back to Top -->
						<a href="#"
							class="btn btn-lg sym-darkpurple sym-yellow-font btn-lg-square back-to-top btn_style"><i
							class="bi bi-arrow-up"></i></a>
					</div>

					<!-- JavaScript Libraries -->
					<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
					<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
					<script
						src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
					<script
						src="<%=request.getContextPath()%>/back-end/grouporder/lib/chart/chart.min.js"></script>
					<script
						src="<%=request.getContextPath()%>/back-end/grouporder/lib/easing/easing.min.js"></script>
					<script
						src="<%=request.getContextPath()%>/back-end/grouporder/lib/waypoints/waypoints.min.js"></script>
					<script
						src="<%=request.getContextPath()%>/back-end/grouporder/lib/owlcarousel/owl.carousel.min.js"></script>
					<script
						src="<%=request.getContextPath()%>/back-end/grouporder/lib/tempusdominus/js/moment.min.js"></script>
					<script
						src="<%=request.getContextPath()%>/back-end/grouporder/lib/tempusdominus/js/moment-timezone.min.js"></script>
					<script
						src="<%=request.getContextPath()%>/back-end/grouporder/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

					<!-- Template Javascript -->
					<script
						src="<%=request.getContextPath()%>/back-end/grouporder/js/main.js"></script>
						<script
						src="<%=request.getContextPath()%>/back-end/grouporder/js/address.js"></script>
					<link rel="stylesheet" type="text/css"
						href="<%=request.getContextPath()%>/back-end/grouporder/datetimepicker/jquery.datetimepicker.css" />
					<script
						src="<%=request.getContextPath()%>/back-end/grouporder/datetimepicker/jquery.js"></script>
					<script
						src="<%=request.getContextPath()%>/back-end/grouporder/datetimepicker/jquery.datetimepicker.full.js"></script>
						



					<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
           theme: '',              //theme: 'dark',
 	       timepicker:true,       //timepicker:true,
 	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
 	       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
 		   value: '${grouporderVO.orderTime}',
						// value:   new Date(),
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
</body>

</html>