<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.Timestamp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.group.model.*"%>
<%@ page import="com.groupproduct.model.*"%>
<%@ page import="com.grouporder.model.*"%>
<%@ page import="com.groupdiscount.model.*"%>
<%-- <%@ page import="com.member.model.*"%> --%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
GrouporderVO grouporderVO = (GrouporderVO) request.getAttribute("grouporderVO");
GroupVO groupVO = (GroupVO) request.getAttribute("groupVO"); // 資料庫取出的empVO物件,存入req
GroupproductVO groupproductVO = (GroupproductVO) request.getAttribute("groupproductVO");
Double groupBuyCount = (Double) request.getAttribute("groupBuyCount");
// MemberVO memberVO = (MemberVO) request.getAttribute("memVO");
%>


<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>SYM</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="eCommerce HTML Template Free Download" name="keywords" />
<meta content="eCommerce HTML Template Free Download" name="description" />

<!-- Favicon -->
<link
	href="<%=request.getContextPath()%>/front-end/group/img/logoSYM.jpg"
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
	href="<%=request.getContextPath()%>/front-end/group/lib/slick/slick.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/front-end/group/lib/slick/slick-theme.css"
	rel="stylesheet" />

<!-- Template Stylesheet -->
<link href="<%=request.getContextPath()%>/front-end/group/css/style.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/front-end/group/css/woody.css"
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
						<a href="login.html" class="nav-link">登入/註冊</a>
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
						<a href="index.html"> <img src="img/logoSYM.jpg" alt="Logo" />
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
	<FORM METHOD="post"
		ACTION="<%=request.getContextPath()%>/front-end/grouporder/Grouporder.do"
		name="form1">
		<div class="login">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg">
						<div class="register-form">
							<h4>請填寫以下資料</h4>
							<br />
							<div class="row">
								<div class="col-6">
									<div class="col">
										<label>會員名稱</label> <input class="form-control" type="text"
											placeholder="會員名稱"
											<%--                   value="<%= (grouporderVO==null)? "1" : MemberVO.getUserName()%>" --%>
										 value="假資料"
											readonly />
									</div>
									<div class="col">
										<label>團購編號</label> <input class="form-control" type="text"
											name="groupBuyID" value="<%=groupVO.getGroupBuyID()%>"
											placeholder="團購編號" readonly />
									</div>
									<div class="col">
										<label>聯絡電話</label> <input class="form-control" type="text"
											name="contactNumber"
											<%-- 									value="<%= (grouporderVO==null)? MemberVO.getPhone() : ""%>" --%>
										value="假資料"
											placeholder="聯絡電話" />
									</div>
								</div>

								<div class="col-6">
									<div class="col">
										<label>購買數量</label> <input id="qua" class="form-control"
											name="groupBuyQuantity"
											value="<%=(grouporderVO == null) ? "1" : grouporderVO.getGroupBuyQuantity()%>"
											type="text" placeholder="購買數量" />
									</div>
									<div class="col">
										<label>付款方式</label> <select name="paymentTerm"
											class="form-control">
											<option value="信用卡">信用卡</option>
										</select>
									</div>
									<div class="col">
										<label>寄送地址</label> <select id="city" name="city">
											<option value="">請選擇</option>
										</select>
										<!-- 																		第二層選單(先隱藏，選完第一層後再出現) -->
										<select id="area" name="area" style="display: none;">
											<option value="">請選擇</option>
										</select> <input id="shippingLocation" name="shippingLocation"
											<%-- 									value="<%= (grouporderVO==null)? MemberVO.getAddress() : ""%>" --%>
										value="假資料"
											class="form-control" type="text" placeholder="寄送地址" />
									</div>
								</div>
								<br> <br>
								<div class="col-7"></div>
								<div class="col-3">
									<label>總金額</label> <input id="total" class="form-control"
										name="groupBuyTotal"
										value="<%=groupproductVO.getGroupBuyProductPrice()*groupBuyCount%>"
										type="text" placeholder="總金額" readonly /> <input
										type="hidden" name="action" value="insert"> <input
										type="hidden" name="groupBuyID"
										value="<%=groupVO.getGroupBuyID()%>"> <input
										type="hidden" name="giftVoucher" value=0> <input
										type="hidden" name="groupBuyProductID"
										value="<%=groupVO.getGroupBuyProductID()%>"> <input
										type="hidden" name="administratorID"
										value="<%=groupVO.getAdministratorID()%>">
										<input
										type="hidden" name="paymentState"
										value="1"> <input
										type="hidden" name="memberID" value="2"> <a href="#">
										<button class="btn">送出訂單</button>
									</a>
	</form>
	</div>
	</div>
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
	<script
		src="<%=request.getContextPath()%>/front-end/group/lib/easing/easing.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/group/lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script src="<%=request.getContextPath()%>/front-end/group/js/main.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-end/grouporder/js/address.js"></script>

</body>
<script>
	$("#qua").bind(
			'input propertychange',
			function() {
				// console.log("123")
				//console.log($("#qua").val())
				$("#total").val(
<%=groupproductVO.getGroupBuyProductPrice()%>
	* $("#qua").val()*<%=groupBuyCount%>);
			})
</script>

</html>