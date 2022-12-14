<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>
<%
MemberVO memVO = (MemberVO) session.getAttribute("memVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
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
<link href="./img/logoSYM.jpg" rel="icon" />

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
				<a href="#" class="navbar-brand">MENU</a>
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
							<a href="#" class="nav-link" data-toggle="dropdown">客服中心</a>
						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">
						<a href="login.jsp" class="nav-link">登入/註冊</a>
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
	<!-- <div class="breadcrumb-wrap">
      <div class="container-fluid">
        <ul class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item"><a href="#">Products</a></li>
          <li class="breadcrumb-item active">Login & Register</li>
        </ul>
      </div>
    </div> -->
	<!-- Breadcrumb End -->

	<!-- Login Start -->
	<div class="login">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg">
					<div class="register-form">
						<h4>請繼續填寫以下資料</h4>
						<br />
						<FORM METHOD="post"
							ACTION="
							<%=request.getContextPath()%>/member/MemberServlet"
							enctype="multipart/form-data" name="form3">
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
								<div class="col-6">

									<div class="col">
										<label>性別</label> <select name="gender" class="form-control">
											<option value="M" selected>男</option>
											<option value="W">女</option>
											<option value="O">其他</option>
										</select>
									</div>
								</div>

								<div class="col-6">
									<div class="col">
										<label for="birthday">生日</label> <input class="form-control"
											name="birthday" type="date" />
									</div>
								</div>
								<div class="col-6">
									<div class="col">
										<label>身分證號</label> <input class="form-control shop_text"
											type="text" name="idNumber" placeholder="身分證號" />
									</div>
								</div>
								<div class="col-6">
									<div class="col">
										<label>地址</label> <input class="form-control shop_text"
											type="text" name="address" placeholder="地址" />
									</div>
								</div>
								<div class="col-12">
									<hr />
								</div>

								<div class="col">
									<div class="row">
										<div class="col-md-4">是否開通賣家功能</div>
										<div class="col-md-4">
											<input type="radio" name="custom_name" value="1" />是
										</div>
										<div class="col-md-4">
											<input type="radio" name="custom_name" value="2" checked />
											否
										</div>
									</div>
									<br />

									<div id="shop_input_text">

										<div class="col">
											<label>賣場名稱</label> <input class="form-control shop_text"
												type="text" placeholder="賣場名稱" />
										</div>
										<div class="col">
											<label>銀行帳號</label> <input class="form-control shop_text"
												type="text" placeholder="銀行帳號" />
										</div>

									</div>

									<br /> <br />
									<div class="col-md">
										<input type="hidden" name="action" value="update"> <input
											type="hidden" name="memberID" value="${memVO.getMemberID()}">
										<input type="hidden" name="mail" value="${memVO.getMail()}">
										<input class="btn" type="submit" value="註冊">


									</div>
								</div>
								<div class="col">
									<div class="col-12">
										<br /> <br /> <br /> <br />
									</div>
									<div class="row justify-content-center">
										<div
											class="col-6 p-1 align-self-center d-flex justify-content-center">
											<img class="rounded-circle user_img"
												src="${pageContext.request.contextPath}/front-end/member/img/account.jpg"
												alt="" style="width: 200px; height: 200px" />
										</div>
										<div class="w-100"></div>
										<br />
										<div
											class="col-6 py-1 align-self-center d-flex justify-content-center">
											<input id="userPhoto" type="file" name="userPhoto"
												class="btn" value="選擇圖片"> <br /> <br />
										</div>
									</div>
								</div>
							</div>
						</FORM>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Login End -->

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
