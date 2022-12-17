<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.group.model.*"%>



<!DOCTYPE html>
<html lang="en">

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
	href="<%=request.getContextPath()%>/back-end/group/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/back-end/group/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link
	href="<%=request.getContextPath()%>/back-end/group/css/bootstrap.min.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->
<link href="<%=request.getContextPath()%>/back-end/group/css/style.css"
	rel="stylesheet" />

<!--Admin-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/group/css/admin.css" />
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
							src="<%=request.getContextPath()%>/back-end/group/img/logoSYM.jpg"
							alt="logo" width="100%" />
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
									<img class="rounded-circle"
										src="<%=request.getContextPath()%>/back-end/group/img/logoSYM3.jpg"
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
										<li class="breadcrumb-item active">團購設定</li>
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
										<!-- form start -->
										<form>
											<div class="card-body">
												<div class="form-group">
													<div class="display-flex mg-bottom-2">
														<div class="col-sm-4">
															<div class="form-group">
																<label class="sym-dark-font">
																	<h5>開始日期</h5>
																</label> <input type="text" name="groupBuyingOnLoadDate" class="form-control" id="f_date1"
																	placeholder="開始日期" />
															</div>
														</div>
														<div class="col-sm-4 margin-left-1">
															<div class="form-group">
																<label class="sym-dark-font">
																	<h5>結束日期</h5>
																</label> <input type="text" name="groupBuyingOffLoadDate" class="form-control" id="f_date2"
																	placeholder="結束日期" />
															</div>
														</div>
														<div class="col-sm-3 margin-left-1">
															<label class="sym-dark-font">
																<h5>管理員編號</h5>
															</label> <input type="text"
																value="${groupVO.administratorID}"
																class="form-control" id="administratorID" readonly />
														</div>
													</div>
												</div>
												<jsp:useBean id="groupproductSvc" scope="page" class="com.groupproduct.model.GroupproductService" />
												<div class="row">
													<div class="col-sm-4">
														<div class="form-group">
														<h5>團購商品編號</h5>
															<select class="form-select mb-3" name="groupBuyProductID" id="groupBuyProductID">
																<c:forEach var="groupproductVO"
																	items="${groupproductSvc.all}">
																	<option value="${groupproductVO.groupBuyProductID}">${groupproductVO.groupBuyProductID}
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="col-sm-4">
														<h5>團購狀態</h5>
														<p></p>
														<input type="radio" name="groupBuyingState" value="true"
															ID="Choice1" checked /> <label for="Choice1">上架&emsp;</label>
														<input type="radio" name="groupBuyingState" value="false"
															ID="Choice2" /> <label for="Choice2">下架&emsp;</label>
														</td>
													</div>

													<div class="col-sm-4">
														<label class="sym-dark-font">
															<h5>團購編號</h5>
														</label> <input type="text" value="${groupVO.groupBuyID}"
															class="form-control" id="groupBuyID" readonly />
													</div>
												</div>
												<br>
												<div class="col-sm-4">
													<label class="sym-dark-font">
														<h5>更新日期</h5>
													</label> <input type="text" class="form-control" id="f_date3"
														placeholder="更新日期" readonly />
												</div>
												<br>
												<!-- <div class="row">                      
                        <div class="col-sm-4">
                          <br>
                          <div class="form-group">
                            <label class="sym-dark-font">
                              <h5>團購商品編號</h5>
                            </label>
                            <select class="form-select mb-3" id="groupBuyProductID">
                              <option value="請選擇團購商品" selected disabled>請選擇</option>
                              <option value="1">團購商品1</option>
                              <option value="2">團購商品2</option>
                            </select>
                            <label for="proPrice" class="sym-dark-font">
                              <h5>商品定價</h5>
                            </label>
                            <input type="text" class="form-control" id="proPrice" readonly/>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-sm-6">
                            <br />
                            <form action="../api/0.01/product/uploadImage" method="post" id="upload">
                              <div class="form-group">
                                <label for="proPicture" class="sym-dark-font">
                                  <h5>團購商品圖片</h5>
                                </label>
                                <div class="bg-light color-palette" style="
                                    border: 1px dashed;
                                    height: 180px;
                                    text-align: center;
                                    line-height: 180px;
                                  " id="picPreview">
                                  預覽圖
                                </div>
                                <div class="input-group">
                                  <div class="custom-file">
                                    <!-- <input type="file" class="custom-file-input" name="groupBuyProductPicture" id="p_file"
                                      accept="image/*" /> -->
												<!-- <label class="custom-file-label" for="proPicture"></label>
                                  </div>
                                  <div class="input-group-append sym-darkpurple">
                                  </div>
                                </div>
                              </div>
                            </form>
                          </div>
                        </div> -->
												<!-- </div> -->
												<!-- <br>
                      <div class="row">
                        <div class="col-sm-12">
                          <div class="form-floating">
                            <textarea class="form-control" placeholder="商品描述" id="floatingTextarea"
                              style="height: 150px;" readonly ></textarea>
                            <label for="floatingTextarea">商品描述</label>
                          </div>
                        </div>
                      </div>
                    </div> -->

												<!-- /.card-body -->
												<div class="card-footer">
													<div class="row">
														<div class="col-sm-9"></div>
														<div class="col-sm-3">
															<input type="hidden" name="action" value="update">
															<input type="hidden" name="groupBuyID"
																value="${groupVO.groupBuyID}"> <input
																type="hidden" name="groupBuyProductOrderTotal"
																value="${groupVO.groupBuyProductOrderTotal}">
															<input	type="hidden" name="administratorID"
																value="${groupVO.administratorID}"> 

															<button
																class="btn sym-darkpurple sym-yellow-font btn_style"
																id="addProduct">送出修改</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						<!-- /.card -->
					</div>
				</div>
				<!-- /.row -->
			</div>
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
	<!-- Content End -->

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
		src="<%=request.getContextPath()%>/back-end/group/lib/chart/chart.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-end/group/lib/easing/easing.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-end/group/lib/waypoints/waypoints.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-end/group/lib/owlcarousel/owl.carousel.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-end/group/lib/tempusdominus/js/moment.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-end/group/lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-end/group/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script src="<%=request.getContextPath()%>/back-end/group/js/main.js"></script>
	<script>

  </script>
</body>

</html>
<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back-end/group/datetimepicker/jquery.datetimepicker.css" />
<script
	src="<%=request.getContextPath()%>/back-end/group/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/back-end/group/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
if(${groupVO.groupBuyingState}){
	document.querySelector('input[ID="Choice1"]').checked = true;
}else{
	document.querySelector('input[ID="Choice2"]').checked = true;
};



$.datetimepicker.setLocale('zh');
$('#f_date1').datetimepicker({
   theme: '',              //theme: 'dark',
    timepicker:false,       //timepicker:true,
    step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
    format:'Y-m-d H:i:s',        //format:'Y-m-d H:i:s',
	   value:'${groupVO.groupBuyingOnLoadDate}',
// value:   new Date(),
//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
//startDate:	            '2017/07/10',  // 起始日
//minDate:               '-1970-01-01', // 去除今日(不含)之前
//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
});
$.datetimepicker.setLocale('zh');
$('#f_date2').datetimepicker({
   theme: '',              //theme: 'dark',
    timepicker:false,       //timepicker:true,
    step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
    format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
	   value: '${groupVO.groupBuyingOffLoadDate}',
// value:   new Date(),
//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
//startDate:	            '2017/07/10',  // 起始日
//minDate:               '-1970-01-01', // 去除今日(不含)之前
//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
});
$.datetimepicker.setLocale('zh');
$('#f_date3').datetimepicker({
   theme: '',              //theme: 'dark',
    timepicker:false,       //timepicker:true,
    step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
    format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
	   value: '${groupVO.updateTime}	',
	// value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});

	// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

	// //      1.以下為某一天之前的日期無法選擇
	//      var somedate1 =  $('#f_date2')
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	// 		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	// 		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	// //      2.以下為某一天之後的日期無法選擇
	//      var somedate2 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() >  somedate2.getYear() || 
	// 		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	// 		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
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