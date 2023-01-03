<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.group6.tibame104.announcement.model.*"%>
<%@ include file="/back-end/group/header.jsp"%>

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
									<h1 class="m-0 sym-dark-font">公告查詢</h1>
								</div>
								<!-- /.col -->
								<div class="col-sm-6 flex-direction">
									<ol class="breadcrumb float-sm-right">
										<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
										<li class="breadcrumb-item active">公告查詢</li>
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
											<h3 class="card-title sym-yellow-font">搜尋列表</h3>
										</div>
										
										<!-- /.card-header -->
										<!-- form start -->

										<!-- form start -->
										<form id="memberSearch" METHOD="post"
											ACTION="${pageContext.request.contextPath}/Announcement/search">
											<div class="card-body">
												<div class="row">
													<div class="col-sm-12">
														<div class="form-group">
															<div class="row">
																<div class="col-6 mb-2rem">
																	<label class="sym-dark-font"><h5>搜尋類別</h5></label>
																	<select id="searchID" name="searchID"
																		class="form-control">
																		<option value="1">公告編號</option>
																		<option value="2">公告標題</option>
																		<option value="3">上架狀態</option>
																		<option value="4">首頁/賣場</option>
																		<option value="5">全部公告</option>
																		<!--                                       <option value="">上架日期</option> -->
																		<!--                                       <option value="">下架日期</option> -->
																		<!--                                       <option value="">更新日期</option> -->

																	</select>
																</div>
																<div class="col-6">
																	<label class="sym-dark-font"><h5>輸入欄位</h5></label>
																	<input type="text" class="form-control"
																		id="searchValue" name="searchValue" />
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
<!-- 											<div class="table-responsive"> -->
<!-- 					            <input type="text" class="form-control border-1" id="reserve_search" type="search" placeholder="輸入欲查詢的團購編號" onkeyup="searchFunction()"> -->
<!-- 					            </div> -->
											<!-- /.card-body -->
											<div class="card-footer">
												<button type="submit"
													class="btn sym-darkpurple sym-yellow-font mb-2rem btn_style">
													<i class="fa fa-search"></i> 搜尋
												</button>
												<button type = "button"
													class="btn sym-darkpurple sym-yellow-font mb-2rem btn_style"
													onclick="window.location.href='${pageContext.request.contextPath}/back-end/announcement/addAnnouncement.jsp'">新增公告
												</button>
												
<!-- 												<button -->
<!--                             id="resetTable" -->
<!--                             class="btn btn-default float-right" -->
<!--                           > -->
<!--                             重置 -->
<!--                           </button> -->
											</div>
										</form>
												
										<div class="col-md-12">
											<div class="card card-primary">
												<div class="card-header sym-darkpurple">
													<h3 class="card-title sym-yellow-font">查詢結果</h3>
												</div>
												<!-- /.card-header -->
												<div class="card-body">
													<table id="memberTable"
														class="table table-bordered table-hover">
														<thead>
															<tr>
																<th>公告編號</th>
																<th>管理員編號</th>
																<th>標題</th>
																<th>描述</th>
																<th>上架日期</th>
																<th>下架日期</th>
																<th>更新日期</th>
																<th>上架狀態</th>
																<th>首頁(true)<br>/賣場(false)</th>
																<th>修改</th>
																<th>刪除</th>
															</tr>
														</thead>
														<tbody id="memberList">
															<!-- javascript render memberlist -->
															<c:forEach var="announcementVO" items="${list}">
																<tr>
																	<FORM METHOD="post"
																		ACTION="${pageContext.request.contextPath}/Announcement/update"
																		style="margin-bottom: 0px">
																		<td style="width: 20px">${announcementVO.announcementSerialID}</td>
																		<td><input type="text" name="administratorID"
																			value="${announcementVO.administratorID}"
																			style="width: 20px"></td>
																		<td><input type="text" name="announcementTitle"
																			value="${announcementVO.announcementTitle}"
																			style="width: 100px"></td>
																		<td><input type="text" name="announcementContent"
																			value="${announcementVO.announcementContent}"
																			style="width: 120px"></td>
																		<td><input type="text" name="startDate"
																			value="${announcementVO.startDate}"
																			style="width: 100px"></td>
																		<td><input type="text" name="endDate"
																			value="${announcementVO.endDate}"
																			style="width: 100px"></td>
																		<td style="width: 100px">${announcementVO.updateTime}</td>
																		<td><input type="text" name="offLoadStatus"
																			value="${announcementVO.offLoadStatus}"
																			style="width: 50px"></td>
																		<td><input type="text" name="showStatus"
																			value="${announcementVO.showStatus}"
																			style="width: 50px"></td>
																		<td><input type="submit"
																			class="btn sym-darkpurple sym-yellow-font btn_style"
																			value="修改"> <input type="hidden"
																			name="announcementSerialID"
																			value="${announcementVO.announcementSerialID}">
																	</FORM>
																	
																	<td>
																		<FORM METHOD="post"
																			ACTION="${pageContext.request.contextPath}/Announcement/delete"
																			style="margin-bottom: 0px;">
																			<input type="submit"
																				class="btn sym-darkpurple sym-yellow-font btn_style" value="刪除">
																			<input type="hidden" name="announcementSerialID"
																				value="${announcementVO.announcementSerialID}">
																			<input type="hidden" name="action" value="delete">
																		</FORM>
																</tr>
															</c:forEach>


														</tbody>
													</table>
												</div>
												<!-- /.card-body -->
											</div>
										</div>
										<!-- /.card-body -->
<!-- 										<div class="card-footer mb-2rem"> -->
<!-- 											<button class="btn sym-darkpurple sym-yellow-font btn_style" -->
<%-- 												id="addProduct" onclick="window.location.href='${pageContext.request.contextPath}/Announcement/getAll'">重置</button> --%>
											<!-- <button class="btn sym-purple sym-yellow-font">
                                                儲存並下架
                                            </button>
                                            <button class="btn sym-purple sym-yellow-font">
                                                儲存並上架
                                            </button> -->
											<!-- <button
                                                class="btn btn-default float-right"
                                            >
                                                取消
                                            </button> -->
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
			</div>
			<!-- Content ends-->

			<!-- Footer Start -->
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
		src="${pageContext.request.contextPath}/back-end/group/lib/chart/chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/easing/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/waypoints/waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/owlcarousel/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/tempusdominus/js/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/back-end/group/js/main.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/group/js/admin.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-end/announcement/js/search.js"></script>
</body>
</html>