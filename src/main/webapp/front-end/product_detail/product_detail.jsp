<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.* ,com.orderlist.model.Product"%>
	
<%
	Map<Integer, List<Product>> check = (Map<Integer, List<Product>>)session.getAttribute("check");
	Integer count_num = (Integer)session.getAttribute("count_num");
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
<link href="${pageContext.request.contextPath}/front-end/product_detail/img/logoSYM.jpg" rel="icon" />

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
<link href="${pageContext.request.contextPath}/front-end/product_detail/lib/slick/slick.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/front-end/product_detail/lib/slick/slick-theme.css" rel="stylesheet" />

<!-- Template Stylesheet -->
<link href="${pageContext.request.contextPath}/front-end/product_detail/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/front-end/product_detail/css/woody.css" rel="stylesheet" />
</head>

<body>
	<!-- Top bar Start -->
	<!-- <div class="top-bar">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-6">
            <i class="fa fa-envelope"></i>
            support@email.comh
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
							<a href="#" class="nav-link " data-toggle="dropdown">客服中心</a>


						</div>
					</div>
				</div>
				<div class="navbar-nav ml-auto">
					<div class="nav-item dropdown">
						<!-- 登入前 -->
						<a href="#" class="nav-link dropdown-toggle"
							data-toggle="dropdown"> 登入/註冊</a>
						<div class="dropdown-menu">
							<a href="#" class="dropdown-item">登入</a> <a href="#"
								class="dropdown-item">註冊</a>
						</div>
						<!-- 登入後 -->
						<!-- <a
                    href="#"
                    class="nav-link dropdown-toggle"
                    data-toggle="dropdown"
                    >
                    <img
                        class="rounded-circle "
                        src="img/account.jpg"
                        alt=""
                        style="width: 40px; height: 40px"
                      />
                    帳號名稱</a
                  >
                  <div class="dropdown-menu">
                    <a href="#" class="dropdown-item">我的帳號</a>
                    <a href="#" class="dropdown-item">註冊</a>
                  </div> -->
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
						<a href="index.html"> <img src="${pageContext.request.contextPath}/front-end/product_detail/img/logoSYM.jpg" alt="Logo" />
						</a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="search">
						<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/SearchServlet">
							<input type="hidden" name="action"  value="getAll_For_Display" />
							<input type="text" placeholder="商品搜尋" name="productName" />
							<button>
								<i class="fa fa-search"></i>
							</button>
						</FORM>
					</div>
				</div>
				<div class="col-md-3">
					<div class="user">
						<!-- <a href="wishlist.html" class="btn wishlist">
                  <i class="fa fa-heart"></i>
                  <span>(0)</span>
                </a> -->
						<a href="cart.html" class="btn cart"> <i
							class="fa fa-shopping-cart"></i> <span>(<%=count_num %>)</span>
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
				<li class="breadcrumb-item"><a href="#">商品大分類</a></li>
				<li class="breadcrumb-item"><a href="#">商品中分類</a></li>
				<li class="breadcrumb-item active">商品名稱</li>
			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Product Detail Start -->
	<div class="product-detail">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<div class="product-detail-top">
						<div class="row align-items-center">
							<div class="col-md-5">
								<div class="product-slider-single normal-slider">
									<img src="img/product-1.jpg" alt="Product Image"> <img
										src="img/product-3.jpg" alt="Product Image"> <img
										src="img/product-5.jpg" alt="Product Image"> <img
										src="img/product-7.jpg" alt="Product Image"> <img
										src="img/product-9.jpg" alt="Product Image"> <img
										src="img/product-10.jpg" alt="Product Image">
								</div>
								<div class="product-slider-single-nav normal-slider">
									<div class="slider-nav-img">
										<img src="img/product-1.jpg" alt="Product Image">
									</div>
									<div class="slider-nav-img">
										<img src="img/product-3.jpg" alt="Product Image">
									</div>
									<div class="slider-nav-img">
										<img src="img/product-5.jpg" alt="Product Image">
									</div>
									<div class="slider-nav-img">
										<img src="img/product-7.jpg" alt="Product Image">
									</div>
									<div class="slider-nav-img">
										<img src="img/product-9.jpg" alt="Product Image">
									</div>
									<div class="slider-nav-img">
										<img src="img/product-10.jpg" alt="Product Image">
									</div>
								</div>
							</div>
							<div class="col-md-7">
								<div class="product-content">
									<div class="title">
										<h2>${productVO.productName}</h2>
									</div>
									<div class="ratting">
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i>
									</div>
									<div class="price">
										<h4>價格:</h4>
										<p>
											${productVO.productPrice} 
										</p>
									</div>


									<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/front-end/shop/ShopServlet">

									<div class="quantity">
										<h4>數量:</h4>
										<div class="qty">
											<button  type="button" class="btn-minus">
												<i class="fa fa-minus"></i>
											</button>
											<input type="text" id="quantity" name="quantity" value="1">
											<button type="button" class="btn-plus">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
									<div class="stock">
										<h4>庫存:</h4>
										<div >
										   ${productVO.productStock}
										</div>
									</div>
									<div class="action">
									
									
						
			
										
										<input type="hidden" name="name"  value="${productVO.productName}" />
										<input type="hidden" name="storeName"  value="${productVO.storeID}" />
										<input type="hidden" name="quantity"  value="${productVO.productName}" />
									
										<input type="hidden" name="price"  value="${productVO.productPrice}" />
										<input type="hidden" name="productID"  value="${productVO.productID}" />
										<input type="hidden" name="storeID"  value="${productVO.storeID}" />
						
										<input type="hidden" name="action"  value="ADD" />
										<input type="hidden" id="method" name="method"  value="" />
										
										<button  class="btn" id="bag" href="#"><i class="fa fa-shopping-bag" ></i>直接購買</button>
										<button   class="btn" id="cart" href="#"><i class="fa fa-shopping-cart"></i>加入購物車</button>
								
									</FORM>		
									</div>
<script>
var bag = document.getElementById('bag');
var cart = document.getElementById('cart');
var method = document.getElementById('method');


bag.addEventListener('click', (event) => {	
	  method.value ="bag";
  }
)
cart.addEventListener('click', (event) => {	
	  method.value ="cart";
  }
)
</script>
				
								</div>
							</div>
						</div>
					</div>
					<div class="row product-detail-bottom">
						<div class="col-lg-12">
							<ul class="nav nav-pills nav-justified align-items-center"
								id="account-sv">
								<li class="nav-item col-lg-2"><a class="nav-link active"
									data-toggle="pill" href="#description"> <img
										src="img/account.jpg" alt="沒惹" srcset="img/account.jpg 80w"
										sizes="(max-width: 100px) 50px, 1vw" />
								</a></li>
								<li class="nav-item col-lg-4"><a class="nav-link active"
									data-toggle="pill" href="#description">企鵝的家</a> <a
									class="nav-link active" data-toggle="pill" href="#description">100分鐘前上線</a>
									<a class="btn" href="#">聊聊</a> <a class="btn" href="#">查看賣場</a>
								</li>
								<li class="nav-item col-lg-2"><a class="nav-link active"
									data-toggle="pill" href="#specification">商品評價</a> <a
									class="nav-link active" data-toggle="pill"
									href="#specification">商品數量</a></li>
								<li class="nav-item col-lg-2"><a class="nav-link active"
									data-toggle="pill" href="#specification">聊聊回應率</a> <a
									class="nav-link active" data-toggle="pill"
									href="#specification">回應速度</a></li>
								<li class="nav-item col-lg-2"><a class="nav-link active"
									data-toggle="pill" href="#specification">加入時間</a> <a
									class="nav-link active" data-toggle="pill"
									href="#specification">粉絲</a></li>
							</ul>

						</div>
					</div>
					<div class="row product-detail-bottom">
						<div class="col-lg-12">
							<ul class="nav nav-pills nav-justified">
								<li class="nav-item"><a class="nav-link active"
									data-toggle="pill" href="#description">商品詳情</a></li>
								<li class="nav-item"><a class="nav-link" data-toggle="pill"
									href="#reviews">評論(數量)</a></li>
							</ul>

							<div class="tab-content">
								<div id="description" class="container tab-pane active">
									<h4>Product description</h4>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										In condimentum quam ac mi viverra dictum. In efficitur ipsum
										diam, at dignissim lorem tempor in. Vivamus tempor hendrerit
										finibus. Nulla tristique viverra nisl, sit amet bibendum ante
										suscipit non. Praesent in faucibus tellus, sed gravida lacus.
										Vivamus eu diam eros. Aliquam et sapien eget arcu rhoncus
										scelerisque. Suspendisse sit amet neque neque. Praesent
										suscipit et magna eu iaculis. Donec arcu libero, commodo ac
										est a, malesuada finibus dolor. Aenean in ex eu velit semper
										fermentum. In leo dui, aliquet sit amet eleifend sit amet,
										varius in turpis. Maecenas fermentum ut ligula at consectetur.
										Nullam et tortor leo.</p>
								</div>
								<div id="reviews" class="container tab-pane fade">
									<div class="reviews-submitted">
										<div class="reviewer">
											Phasellus Gravida - <span>01 Jan 2020</span>
										</div>
										<div class="ratting">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
										<p>Sed ut perspiciatis unde omnis iste natus error sit
											voluptatem accusantium doloremque laudantium, totam rem
											aperiam.</p>
									</div>
									<div class="reviews-submit">
										<h4>Give your Review:</h4>
										<div class="ratting">
											<i class="far fa-star"></i> <i class="far fa-star"></i> <i
												class="far fa-star"></i> <i class="far fa-star"></i> <i
												class="far fa-star"></i>
										</div>
										<div class="row form">
											<div class="col-sm-6">
												<input type="text" placeholder="Name">
											</div>
											<div class="col-sm-6">
												<input type="email" placeholder="Email">
											</div>
											<div class="col-sm-12">
												<textarea placeholder="Review"></textarea>
											</div>
											<div class="col-sm-12">
												<button>Submit</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="product">
						<div class="section-header">
							<h1>Related Products</h1>
						</div>

						<div
							class="row align-items-center product-slider product-slider-3">
							<div class="col-lg-3">
								<div class="product-item">
									<div class="product-title">
										<a href="#">Product Name</a>
										<div class="ratting">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
									</div>
									<div class="product-image">
										<a href="product-detail.html"> <img
											src="img/product-10.jpg" alt="Product Image">
										</a>
										<div class="product-action">
											<a href="#"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
												class="fa fa-heart"></i></a> <a href="#"><i
												class="fa fa-search"></i></a>
										</div>
									</div>
									<div class="product-price">
										<h3>
											<span>$</span>99
										</h3>
										<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
											Now</a>
									</div>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="product-item">
									<div class="product-title">
										<a href="#">Product Name</a>
										<div class="ratting">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
									</div>
									<div class="product-image">
										<a href="product-detail.html"> <img
											src="img/product-8.jpg" alt="Product Image">
										</a>
										<div class="product-action">
											<a href="#"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
												class="fa fa-heart"></i></a> <a href="#"><i
												class="fa fa-search"></i></a>
										</div>
									</div>
									<div class="product-price">
										<h3>
											<span>$</span>99
										</h3>
										<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
											Now</a>
									</div>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="product-item">
									<div class="product-title">
										<a href="#">Product Name</a>
										<div class="ratting">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
									</div>
									<div class="product-image">
										<a href="product-detail.html"> <img
											src="img/product-6.jpg" alt="Product Image">
										</a>
										<div class="product-action">
											<a href="#"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
												class="fa fa-heart"></i></a> <a href="#"><i
												class="fa fa-search"></i></a>
										</div>
									</div>
									<div class="product-price">
										<h3>
											<span>$</span>99
										</h3>
										<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
											Now</a>
									</div>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="product-item">
									<div class="product-title">
										<a href="#">Product Name</a>
										<div class="ratting">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
									</div>
									<div class="product-image">
										<a href="product-detail.html"> <img
											src="img/product-4.jpg" alt="Product Image">
										</a>
										<div class="product-action">
											<a href="#"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
												class="fa fa-heart"></i></a> <a href="#"><i
												class="fa fa-search"></i></a>
										</div>
									</div>
									<div class="product-price">
										<h3>
											<span>$</span>99
										</h3>
										<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
											Now</a>
									</div>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="product-item">
									<div class="product-title">
										<a href="#">Product Name</a>
										<div class="ratting">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
									</div>
									<div class="product-image">
										<a href="product-detail.html"> <img
											src="img/product-2.jpg" alt="Product Image">
										</a>
										<div class="product-action">
											<a href="#"><i class="fa fa-cart-plus"></i></a> <a href="#"><i
												class="fa fa-heart"></i></a> <a href="#"><i
												class="fa fa-search"></i></a>
										</div>
									</div>
									<div class="product-price">
										<h3>
											<span>$</span>99
										</h3>
										<a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy
											Now</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
	<!-- Product Detail End -->

	<!-- Brand Start -->
	<div class="brand">
		<div class="container-fluid">
			<div class="brand-slider">
				<div class="brand-item">
					<img src="img/brand-1.png" alt="">
				</div>
				<div class="brand-item">
					<img src="img/brand-2.png" alt="">
				</div>
				<div class="brand-item">
					<img src="img/brand-3.png" alt="">
				</div>
				<div class="brand-item">
					<img src="img/brand-4.png" alt="">
				</div>
				<div class="brand-item">
					<img src="img/brand-5.png" alt="">
				</div>
				<div class="brand-item">
					<img src="img/brand-6.png" alt="">
				</div>
			</div>
		</div>
	</div>
	<!-- Brand End -->

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
	<script src="${pageContext.request.contextPath}/front-end/product_detail/lib/easing/easing.min.js"></script>
	<script src="${pageContext.request.contextPath}/front-end/product_detail/lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script src="${pageContext.request.contextPath}/front-end/product_detail/js/main.js"></script>
</body>
</html>
