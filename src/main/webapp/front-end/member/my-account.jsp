<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>
<%@ page import="com.creditCard.model.*"%>
<%
MemberVO memVO = (MemberVO) session.getAttribute("memVO");

CreditCardService cardSvc = new CreditCardService();
List<CreditCardVO> list = cardSvc.getAll(memVO.getMemberId());
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>SYM</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="eCommerce HTML Template Free Download" name="keywords" />
<meta content="eCommerce HTML Template Free Download" name="description" />

<!-- Favicon -->
<link
	href="${pageContext.request.contextPath}/front-end/img/logoSYM.jpg"
	rel="icon" />

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
	rel="stylesheet" />

<!-- CSS Libraries -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/lib/slick/slick.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/lib/slick/slick-theme.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->
<link
	href="${pageContext.request.contextPath}/front-end/member/css/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/woody.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/coupon.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/table.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/front-end/member/css/signupDay.css"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/bc79e44e11.js"
	crossorigin="anonymous"></script>
</head>

<body>

	<!-- Top bar Start -->
	<!-- <div class="top-bar">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-6">
            <i class="fa fa-envelope"></i>
            support@email.com
          </div>
          <div class="col-sm-6">
            <i class="fa fa-phone-alt"></i>
            +012-345-6789
          </div>
        </div>
      </div>
    </div> -->
	<!-- Top bar End -->

	<!-- Nav Bar Start -->
	<div class="nav">
		<div class="container-fluid">
			<nav class="navbar navbar-expand-md bg-dark navbar-dark">
				<!-- <a href="#" class="navbar-brand">MENU</a> -->
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto">
						<a href="index.html" class="nav-item nav-link">首頁</a> <a
							href="product-list.html" class="nav-item nav-link">我的賣場</a>

						<div class="nav-item dropdown">
							<a href="#" class="nav-link " data-toggle="dropdown">客服中心</a>


						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">

						<a href="my-account.html" class="nav-link dropdown-toggle"
							data-toggle="dropdown"> <img class="rounded-circle "
							src="${pageContext.request.contextPath}/member/DBGifReader?memberId=${memVO.memberId}"
							alt="" style="width: 40px; height: 40px" /> <%=memVO.getUserName()%>
						</a>
						<div class="dropdown-menu">
							<a href="${pageContext.request.contextPath}/front-end/member/my-account.jsp" class="dropdown-item">我的帳號</a>	
							<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/MemberServlet"> 
							<input type="hidden" name="action" value="getOne_For_LogOut">
							<input class="dropdown-item" type="submit" name="action" value="登出"></a>
							</FORM>

						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Nav Bar End -->

	<!-- Bottom Bar Start -->
	<div class="bottom-bar">
		<div class="container-fluid">
			<div class="row align-items-center">
				<div class="col-md-3">
					<div class="logo">
						<a href="index.html"> <img
							src="${pageContext.request.contextPath}/front-end/member/img/logo.png"
							alt="Logo" />
						</a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="search">
						<input type="text" placeholder="商品搜尋
              " />
						<button>
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<div class="col-md-3">
					<div class="user">
						<!-- <a href="wishlist.html" class="btn wishlist">
                <i class="fa fa-heart"></i>
                <span>(0)</span>
              </a> -->
						<a href="cart.html" class="btn cart"> <i
							class="fa fa-shopping-cart"></i> <span>(0)</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bottom Bar End -->

	<!-- Breadcrumb Start -->
	<div class="breadcrumb-wrap">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Home</a></li>
				<li class="breadcrumb-item"><a href="#">Products</a></li>
				<li class="breadcrumb-item active">My Account</li>
			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- My Account Start -->
	<div class="my-account">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					<div class="nav flex-column nav-pills" role="tablist"
						aria-orientation="vertical">
						<a class="nav-link active" id="account-nav" data-toggle="pill"
							href="#account-tab" role="tab" aria-selected="true"><i
							class="fa fa-user"></i>我的帳戶</a> <a class="nav-link" id="password-nav"
							data-toggle="pill" href="#password-tab" role="tab"><i
							class="fa-solid fa-lock-open"></i>修改密碼</a> <a class="nav-link"
							id="cards-nav" data-toggle="pill" href="#cards-tab" role="tab"><i
							class="fa-solid fa-credit-card"></i>信用卡管理</a> <a class="nav-link"
							id="orders-nav" data-toggle="pill" href="#orders-tab" role="tab"><i
							class="fa fa-shopping-bag"></i>訂單管理</a> <a class="nav-link"
							id="payment-nav" data-toggle="pill" href="#payment-tab"
							role="tab"><i class="fa-solid fa-coins"></i>我的購物金</a> <a
							class="nav-link" id="address-nav" data-toggle="pill"
							href="#coupon-tab" role="tab"><i class="fa-solid fa-ticket"></i></i>我的優惠券</a>
						<a class="nav-link" id="blocklist-nav" data-toggle="pill"
							href="#blocklist-tab" role="tab"><i
							class="fa-solid fa-user-xmark"></i>封鎖名單</a>
						<!-- <a class="nav-link" href="index.html"
                ><i class="fa fa-sign-out-alt"></i>登出</a
              > -->
					</div>
				</div>
				<div class="col-md-9">
					<div class="tab-content">
						<div class="tab-pane fade" id="dashboard-tab" role="tabpanel"
							aria-labelledby="orders-nav">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead class="thead-dark">
										<tr>
											<th>No</th>
											<th>Product</th>
											<th>Date</th>
											<th>Price</th>
											<th>Status</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Product Name</td>
											<td>01 Jan 2020</td>
											<td>$99</td>
											<td>Approved</td>
											<td><button class="btn">View</button></td>
										</tr>
										<tr>
											<td>2</td>
											<td>Product Name</td>
											<td>01 Jan 2020</td>
											<td>$99</td>
											<td>Approved</td>
											<td><button class="btn">View</button></td>
										</tr>
										<tr>
											<td>3</td>
											<td>Product Name</td>
											<td>01 Jan 2020</td>
											<td>$99</td>
											<td>Approved</td>
											<td><button class="btn">View</button></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="tab-pane fade" id="orders-tab" role="tabpanel"
							aria-labelledby="orders-nav">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead class="thead-dark">
										<tr>
											<th>No</th>
											<th>商品名稱</th>
											<th>日期</th>
											<th>價格</th>
											<th>出貨狀態</th>
											<th>查看明細</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Product Name</td>
											<td>01 Jan 2020</td>
											<td>$99</td>
											<td>Approved</td>
											<td><button class="btn">View</button></td>
										</tr>
										<tr>
											<td>2</td>
											<td>Product Name</td>
											<td>01 Jan 2020</td>
											<td>$99</td>
											<td>Approved</td>
											<td><button class="btn">View</button></td>
										</tr>
										<tr>
											<td>3</td>
											<td>Product Name</td>
											<td>01 Jan 2020</td>
											<td>$99</td>
											<td>Approved</td>
											<td><button class="btn">View</button></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="tab-pane fade" id="cards-tab" role="tabpanel"
							aria-labelledby="cards-nav">
							<div class="table-responsive">

								<table class="table table-bordered">
									<div class="col-md py-1">




										<FORM METHOD="post"
											ACTION="<%=request.getContextPath()%>/member/CreditCardServlet"
											style="margin-bottom: 0px;">

											<div class="row">
												<div class="col-md py-1">
													<label>信用卡卡號</label><input class="form-control" type="text"
														name="creditCardNumber" placeholder="信用卡卡號" />
												</div>

											</div>
											<div class="row">
												<div class="col-md py-1">
													<label for="birthday">到期日</label> <input
														class="form-control" name="exDate" type="date" />
												</div>
												<div class="col-md py-1">
													<label>安全碼</label><input class="form-control" type="text"
														name="securityCode" placeholder="安全碼" />
												</div>
											</div>

											<input type="hidden" name="memberId"
												value="${memVO.getMemberId() }"> <input
												type="hidden" name="action" value="insert"> <input
												class="btn" type="submit" value="新增信用卡"> <br /> <br />
										</FORM>
										<hr>
										<thead class="thead-dark">
											<tr>

												<th>信用卡卡號</th>
												<th>安全碼</th>
												<th>到期日</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="cardVO" items="${list}">
												<tr>

													<td>${cardVO.creditCardNumber}</td>
													<td>${cardVO.securityCode}</td>
													<td>${cardVO.exDate}</td>

													<td>
														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>/member/CreditCardServlet"
															style="margin-bottom: 0px;">
															<input type="hidden" name="creditCardId"
																value="${cardVO.creditCardId}"> <input
																type="hidden" name="memberId"
																value="${memVO.getMemberId()}"> <input
																type="hidden" name="action" value="delete"> <input
																class="btn" type="submit" value="刪除">
														</FORM>
													</td>
												</tr>
											</c:forEach>
										</tbody>
								</table>


							</div>
						</div>
						<div class="tab-pane fade" id="payment-tab" role="tabpanel"
							aria-labelledby="payment-nav">
							<div
								style="display: flex; flex-direction: column; align-items: center;">
								<div style="display: flex;">
									<div>我的購物金:</div>
									<div id="shoppingGold">50</div>
									<div>元</div>
								</div>
							</div>

							<div class="daysContainer">
								<div>購物金簽到</div>
								<div class="dayRow">
									<div class="dayBlock">Day1</div>
									<div class="dayBlock">Day2</div>
									<div class="dayBlock">Day3</div>
									<div class="dayBlock">Day4</div>
									<div class="dayBlock">Day5</div>
									<div class="dayBlock">Day6</div>
									<div class="dayBlock">Day7</div>
								</div>
								<div>完成實名認證即可領取購物金</div>
							</div>
							<div class="table-outbox">
								<table>
									<thead>
										<tr>
											<th>日期</th>
											<th>會員ID</th>
											<th>購物金異動金額</th>
											<th>使用/獲得</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>test-1</td>
											<td>test-1</td>
											<td>test-1</td>
											<td>test-1</td>
										</tr>

										<tr>
											<td>test-2</td>
											<td>test-2</td>
											<td>test-2</td>
											<td>test-2</td>
										</tr>

										<tr>
											<td>test-3</td>
											<td>test-3</td>
											<td>test-3</td>
											<td>test-3</td>
										</tr>

										<tr>
											<td>test-4</td>
											<td>test-4</td>
											<td>test-4</td>
											<td>test-4</td>
										</tr>

									</tbody>
								</table>
							</div>
						</div>
						<div class="tab-pane fade" id="blocklist-tab" role="tabpanel"
							aria-labelledby="blocklist-nav">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead class="thead-dark">
										<tr>
											<th>No</th>
											<th>賣場名稱</th>

											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>賣場名稱</td>
											<td><button class="btn">解除封鎖</button></td>
										</tr>
										<tr>
											<td>2</td>
											<td>賣場名稱</td>

											<td><button class="btn">解除封鎖</button></td>
										</tr>
										<tr>
											<td>3</td>
											<td>賣場名稱</td>

											<td><button class="btn">解除封鎖</button></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="tab-pane fade" id="coupon-tab" role="tabpanel"
							aria-labelledby="coupon-nav">
							<div class="quan" v-for="(item,i) in couponList" : key="i">
								<div class="quanInfo">
									<text class="couponMpoey">$200元<text
										class="couponMpoeyInfo"> 滿1500元折抵200元</text></text>
									<text class="couponName">全館滿額折抵200</text>
									<text class="couponTime">2022-11-14~2022-11-25</text>
								</div>
								<div class="receiveBtn">
									<div>
										<button class="receive">使用</button>
									</div>
								</div>
							</div>
							<div class="quan" v-for="(item,i) in couponList" : key="i">
								<div class="quanInfo">
									<text class="couponMpoey">85折<text
										class="couponMpoeyInfo"> 不限購買金額</text></text>
									<text class="couponName">全館優惠85折</text>
									<text class="couponTime">2022-11-11~2022-11-22</text>
								</div>
								<div class="receiveBtn">
									<div>
										<button class="receive">使用</button>
									</div>
								</div>
							</div>
							<div class="quan" v-for="(item,i) in couponList" : key="i">
								<div class="quanInfo">
									<text class="couponMpoey">$100元<text
										class="couponMpoeyInfo"> 滿1000元折抵100元</text></text>
									<text class="couponName">全館滿額折抵100</text>
									<text class="couponTime">2022-11-13~2022-11-24</text>
								</div>
								<div class="receiveBtn">
									<div>
										<button class="receive">使用</button>
									</div>
								</div>
							</div>
							<div class="table-outbox">
								<table>
									<thead>
										<tr>
											<th>使用日期</th>
											<th>會員ID</th>
											<th>優惠券ID</th>
											<th>使用紀錄</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>test-1</td>
											<td>test-1</td>
											<td>test-1</td>
											<td>test-1</td>
										</tr>

										<tr>
											<td>test-2</td>
											<td>test-2</td>
											<td>test-2</td>
											<td>test-2</td>
										</tr>

										<tr>
											<td>test-3</td>
											<td>test-3</td>
											<td>test-3</td>
											<td>test-3</td>
										</tr>

										<tr>
											<td>test-4</td>
											<td>test-4</td>
											<td>test-4</td>
											<td>test-4</td>
										</tr>

									</tbody>
								</table>
							</div>
						</div>
						<div class="tab-pane fade active show" id="account-tab"
							role="tabpanel" aria-labelledby="account-nav">
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/member/MemberServlet"
								enctype="multipart/form-data" name="form1">
								<h4>帳戶明細</h4>
								<%-- 錯誤表列 --%>
								<c:if test="${not empty errorMsgs}">
									<font style="color: red">請修正以下錯誤:</font>
									<ul>
										<c:forEach var="message" items="${errorMsgs}">
											<li style="color: red">${message}</li>
										</c:forEach>
									</ul>
								</c:if>
								<div class="row">
									<div class="col">
										<div class="row">
											<div class="col-md py-1">
												<input class="form-control" type="text" name="userName"
													placeholder="姓名"
													value="<%=(memVO.getUserName() == null) ? "" : memVO.getUserName()%>" />
											</div>
											<div class="col-md py-1">
												<input class="form-control" type="text" name="userAccount"
													placeholder="帳號"
													value="<%=(memVO.getUserAccount() == null) ? "" : memVO.getUserAccount()%>" />
											</div>
										</div>
										<div class="row">
											<div class="col-md py-1">
												<input class="form-control" type="text" name="phone"
													placeholder="手機號碼"
													value="<%=(memVO.getPhone() == null) ? "" : memVO.getPhone()%>" />
											</div>
											<div class="col-md py-1">
												<input class="form-control" type="text" name="mail"
													placeholder="電子信箱"
													value="<%=(memVO.getMail() == null) ? "" : memVO.getMail()%>" />
											</div>
										</div>

										<br> <br> <br>


										<div class="row">
											<div class="col-md py-1">
												<input type="hidden" name="action" value="updateOne">
												<input type="hidden" name="memberId"
													value="<%=(memVO == null) ? "" : memVO.getMemberId()%>">
												<input class="btn" type="submit" value="更新資料"> <br />
												<br />
											</div>
										</div>
									</div>



									<div class="col">
										<div class="row justify-content-center">
											<div
												class="col-6 p-1 align-self-center d-flex justify-content-center">
												<img class="rounded-circle user_img"
													src="${pageContext.request.contextPath}/member/DBGifReader?memberId=${memVO.memberId}"
													alt="" style="width: 160px; height: 160px" />
											</div>
											<div class="w-100"></div>
											<br>

											<div
												class="col-6 py-1 align-self-center d-flex justify-content-center">
												<input id="userPhoto" type="file" name="userPhoto"
													class="btn" value="選擇圖片"> <br /> <br />
											</div>
										</div>

									</div>
								</div>
							</FORM>







							<hr>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/member/MemberServlet"
								name="form1">
								<h4>賣場資訊</h4>
								<div class="row">
									<div class="col-md-6">
										<input class="form-control" type="text" placeholder="身分證號" />
									</div>
									<div class="col-md-6">
										<input class="form-control" type="text" placeholder="賣場名稱" />
									</div>
									<div class="col-md-6">
										<input class="form-control" type="text" placeholder="銀行帳號" />
									</div>
									<div class="col-md-6">
										<input class="form-control" type="text" placeholder="賣場地址" />
									</div>
									<div class="col-md-12">
										<button class="btn">送出</button>
									</div>
								</div>
							</FORM>
						</div>
						<div class="tab-pane fade" id="password-tab" role="tabpanel"
							aria-labelledby="password-nav">


							<h4>變更密碼</h4>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/member/MemberServlet"
								style="margin-bottom: 0px;">
								
								<div class="row">
								<%-- 錯誤表列 --%>
								<c:if test="${not empty errorMsgs}">
									<font style="color: red">請修正以下錯誤:</font>
									<ul>
										<c:forEach var="message" items="${errorMsgs}">
											<li style="color: red">${message}</li>
										</c:forEach>
									</ul>
								</c:if>
									<div class="col-md-12">
										<input class="form-control" type="password"
											placeholder="請輸入舊密碼" />
									</div>
									<div class="col-md-6">
										<input class="form-control" type="password"
											name="userPassword" placeholder="請輸入新密碼" />
									</div>
									<div class="col-md-6">
										<input class="form-control" type="password"
											placeholder="請再輸入一次新密碼" />
									</div>
									<div class="col-md-12">
										<input type="hidden" name="action" value="updateOnePassword">
										<input type="hidden" name="memberId"
											value="<%=memVO.getMemberId()%>"> <input class="btn"
											type="submit" value="送出">
									</div>
								</div>
							</FORM>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- My Account End -->

	<!-- Footer Start -->
	<div class="footer">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h5>網站介紹</h5>
						<ul>
							<li><a href="#">關於SYM</a></li>
							<li><a href="#">SYM團隊成員介紹</a></li>
							<!-- <li><a href="#">Terms & Condition</a></li> -->
						</ul>
					</div>
				</div>

				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h5>聯絡我們</h5>
						<div class="contact-info">
							<p>
								<i class="fa fa-map-marker"></i>台北商業大學
							</p>
							<!-- <p><i class="fa fa-envelope"></i>email@example.com</p>
                <p><i class="fa fa-phone"></i>+123-456-7890</p> -->
						</div>
					</div>
				</div>

				<!-- <div class="col-lg-3 col-md-6">
            <div class="footer-widget">
              <h2>Follow Us</h2>
              <div class="contact-info">
                <div class="social">
                  <a href=""><i class="fab fa-twitter"></i></a>
                  <a href=""><i class="fab fa-facebook-f"></i></a>
                  <a href=""><i class="fab fa-linkedin-in"></i></a>
                  <a href=""><i class="fab fa-instagram"></i></a>
                  <a href=""><i class="fab fa-youtube"></i></a>
                </div>
              </div>
            </div>
          </div> -->

				<div class="col-lg-3 col-md-6">
					<div class="footer-widget">
						<h5>常見問題</h5>
						<ul>
							<li><a href="#">前往客服中心</a></li>
							<!-- <li><a href="#">Shipping Policy</a></li>
                <li><a href="#">Return Policy</a></li> -->
						</ul>
					</div>
				</div>
			</div>

			<!-- <div class="row payment align-items-center">
          <div class="col-md-6">
            <div class="payment-method">
              <h2>We Accept:</h2>
              <img src="img/payment-method.png" alt="Payment Method" />
            </div>
          </div>
          <div class="col-md-6">
            <div class="payment-security">
              <h2>Secured By:</h2>
              <img src="img/godaddy.svg" alt="Payment Security" />
              <img src="img/norton.svg" alt="Payment Security" />
              <img src="img/ssl.svg" alt="Payment Security" />
            </div>
          </div>
        </div> -->
		</div>
	</div>
	<!-- Footer End -->

	<!-- Footer Bottom Start -->
	<div class="footer-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-6 copyright">
					<p>
						Copyright &copy; <a href="#">SYM</a>. All Rights Reserved
					</p>
				</div>

				<div class="col-md-6 template-by">
					<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
					<!-- <p>Designed By <a href="https://htmlcodex.com">HTML Codex</a></p> -->
				</div>
			</div>
		</div>
	</div>
	<!-- Footer End -->

	<!-- Back to Top -->
	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/front-end/member/js/main.js"></script>
	<script
		src="${pageContext.request.contextPath}/front-end/member/js/woody.js"></script>
</body>

</html>