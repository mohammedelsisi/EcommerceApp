<%--
  Created by IntelliJ IDEA.
  User: Hager
  Date: ١٩/٠٣/٢٠٢١
  Time: ٠٥:٢٤ م
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="P" uri="/WEB-INF/tlds/productLib" %>
<html>
<head>
        <title>Shoppers &mdash; Colorlib e-Commerce Template</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
        <!-- to add down arrow to menus -->
        <link rel="stylesheet" href="layout/fonts/icomoon/style.css">

        <link rel="stylesheet" href="layout/css/bootstrap.min.css">
        <!-- <link rel="stylesheet" href="layout/css/magnific-popup.css"> -->
        <link rel="stylesheet" href="layout/css/jquery-ui.css">
        <!-- to let horizontal scrolling -->
        <link rel="stylesheet" href="layout/css/owl.carousel.min.css">
        <!-- to add animations on vertical scrolling -->
        <link rel="stylesheet" href="layout/css/aos.css">
        <!-- main Style file -->
        <link rel="stylesheet" href="layout/css/style.css">
    <link rel="stylesheet" href="layout/css/rangeSlider.css" />
    <link rel="stylesheet" href="layout/css/slider-style.css" />
        <!-- for font awsowome icon -->
        <link href="../../layout/css/all.min.css" rel="stylesheet" type="text/css">
<style>
    /*.slider {*/
    /*    -webkit-appearance: none;*/
    /*    width: 100%;*/
    /*    height: 15px;*/
    /*    border-radius: 5px;*/
    /*    background: #d3d3d3;*/
    /*    outline: none;*/
    /*    opacity: 0.7;*/
    /*    -webkit-transition: .2s;*/
    /*    transition: opacity .2s;*/
    /*}*/

    /*.slider:hover {*/
    /*    opacity: 1;*/
    /*}*/

    /*.slider::-webkit-slider-thumb {*/
    /*    -webkit-appearance: none;*/
    /*    appearance: none;*/
    /*    width: 25px;*/
    /*    height: 25px;*/
    /*    border-radius: 50%;*/
    /*    background: #4CAF50;*/
    /*    cursor: pointer;*/
    /*}*/

    /*.slider::-moz-range-thumb {*/
    /*    width: 25px;*/
    /*    height: 25px;*/
    /*    border-radius: 50%;*/
    /*    background: #4CAF50;*/
    /*    cursor: pointer;*/
    /*}*/
</style>
</head>
<body>
<div class="site-wrap">
    <header class="site-navbar" role="banner">
        <div class="site-navbar-top">
            <div class="container">
                <div class="row align-items-center">

                    <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
                        <form action="" class="site-block-top-search">
                            <span class="icon icon-search2"></span>
                            <input type="text" class="form-control border-0" placeholder="Search">
                        </form>
                    </div>

                    <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
                        <div class="site-logo">
                            <a href="index.html" class="js-logo-clone">
                                <div class="brand-icon ">
                                    <i class="fas fa-store"></i>
                                </div>
                                <div class="brand-text mx-3">Fashion Store</div>
                            </a>
                        </div>
                    </div>

                    <div class="col-6 col-md-4 order-3 order-md-3 text-right">
                        <div class="site-top-icons">
                            <ul>
                                <li><a href="#"></a></li>
                                <li><a href="#"><span class="icon icon-person"></span></a></li>
                                <li><a href="#"><span class="icon icon-heart-o"></span></a></li>
                                <li>
                                    <a href="cart.html" class="site-cart">
                                        <span class="icon icon-shopping_cart"></span>
                                        <span class="count">2</span>
                                    </a>
                                </li>
                                <li class="d-inline-block d-md-none ml-md-0"><a href="#"
                                                                                class="site-menu-toggle js-menu-toggle"><span
                                        class="icon-menu"></span></a></li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <nav class="site-navigation text-right text-md-center" role="navigation">
            <div class="container">
                <ul class="site-menu js-clone-nav d-none d-md-block">
                    <li>
                        <a href="index.html">Home</a>
                    </li>
                    <li>
                        <a href="about.html">About</a>

                    </li>
                    <li><a href="shop.html">Shop</a></li>
                    <li><a href="#">Profile</a></li>
                    <li><a href="#">New Arrivals</a></li>
                    <li><a href="contact.html">Contact</a></li>
                </ul>
            </div>
        </nav>
    </header>

    <div class="bg-light py-3">
        <div class="container">
            <div class="row">
                <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Shop</strong></div>
            </div>
        </div>
    </div>

    <div class="site-section">
        <div class="container">

            <div class="row mb-5">
                <div class="col-md-9 order-2">

                    <div class="row">
                        <div class="col-md-12 mb-5">
                            <div class="float-md-left mb-4"><h2 class="text-black h5">Shop All</h2></div>
                            <div class="d-flex">
                                <div class="dropdown mr-1 ml-md-auto">
                                    <button type="button" class="btn btn-secondary btn-sm dropdown-toggle" id="dropdownMenuOffset" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Latest
                                    </button>
                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                                        <a class="dropdown-item" href="#">Men</a>
                                        <a class="dropdown-item" href="#">Women</a>
                                        <a class="dropdown-item" href="#">Children</a>
                                    </div>
                                </div>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-secondary btn-sm dropdown-toggle" id="dropdownMenuReference" data-toggle="dropdown">Reference</button>
                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuReference">
                                        <a class="dropdown-item" href="#">Relevance</a>
                                        <a class="dropdown-item" href="#">Name, A to Z</a>
                                        <a class="dropdown-item" href="#">Name, Z to A</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#">Price, low to high</a>
                                        <a class="dropdown-item" href="#">Price, high to low</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-5">
                        <c:forEach items="${requestScope.Products}" var="i">
                            <div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
                            <P:product img="${i.firstProdImg}" desc="${i.prodDesc}" src="#" price="${i.prodPrice}"/>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="row" data-aos="fade-up">
                        <div class="col-md-12 text-center">
                            <div class="site-block-27">
                                <ul>
                                    <li><a id="PageBefore" href="#">&lt;</a></li>
                                    <c:set var="Init" value="1"/>
                                    <c:if test="${empty param.page}">
                                        <li class="active"><span id="ActivePage">1</span></li>
                                        <c:set var="Init" value="2"/>
                                    </c:if>
                                    <c:forEach var = "i" begin = "${Init}" end = "${requestScope.Pages}">
                                        <c:choose>
                                            <c:when test="${param.page==i}">
                                                <li class="active"><span id="ActivePage">${i}</span></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li><a href="Shop?page=${i}">${i}</a></li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                    <li><a id="PageAfter" href="#">&gt;</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-3 order-1 mb-5 mb-md-0">
                    <div class="border p-4 rounded mb-4">
                        <h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
                        <ul class="list-unstyled mb-0">
                            <li class="mb-1"><a href="#" class="d-flex"><span>Men</span> <span class="text-black ml-auto">(2,220)</span></a></li>
                            <li class="mb-1"><a href="#" class="d-flex"><span>Women</span> <span class="text-black ml-auto">(2,550)</span></a></li>
                            <li class="mb-1"><a href="#" class="d-flex"><span>Children</span> <span class="text-black ml-auto">(2,124)</span></a></li>
                        </ul>
                    </div>
                    <form>
                    <div class="border p-4 rounded mb-4">
                        <div class="mb-4">
                            <h3 class="mb-3 h6 text-uppercase text-black d-block">Filter by Price</h3>
<%--                            <div class="slidecontainer">--%>
<%--                                <p>Price: <span id="demo"></span></p>--%>
<%--                                <input type="range" min="1" max="100" value="50" class="slider" id="myRange">--%>

<%--                            </div>--%>
                            <div id="anchor2"></div>
                        </div>

                        <div class="mb-4">
                            <h3 class="mb-3 h6 text-uppercase text-black d-block">Size</h3>
                            <label for="s_sm" class="d-flex">
                                <input type="checkbox" id="s_sm" class="mr-2 mt-1"> <span class="text-black">Small (2,319)</span>
                            </label>
                            <label for="s_md" class="d-flex">
                                <input type="checkbox" id="s_md" class="mr-2 mt-1"> <span class="text-black">Medium (1,282)</span>
                            </label>
                            <label for="s_lg" class="d-flex">
                                <input type="checkbox" id="s_lg" class="mr-2 mt-1"> <span class="text-black">Large (1,392)</span>
                            </label>
                        </div>

                        <div class="mb-4">
                            <h3 class="mb-3 h6 text-uppercase text-black d-block">Color</h3>
                            <label for="s_sm" class="d-flex ">
                                <input type="checkbox" id="c_red" class="mr-2 mt-1">  <span class="text-black">Red (2,429)</span>
                            </label>
                            <label for="s_sm" class="d-flex ">
                                <input type="checkbox" id="c_green" class="mr-2 mt-1">  <span class="text-black">Green (2,429)</span>
                            </label>
                            <label for="s_sm" class="d-flex ">
                                <input type="checkbox" id="c_blue" class="mr-2 mt-1">  <span class="text-black">Blue (2,429)</span>
                            </label>
                            <label for="s_sm" class="d-flex ">
                                <input type="checkbox" id="c_purple" class="mr-2 mt-1">  <span class="text-black">Purple (2,429)</span>
                            </label>
                        </div>
                        <input class="btn btn-primary " type="submit" value="Submit">
                    </div>

                    </form>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="site-section site-blocks-2">
                        <div class="row justify-content-center text-center mb-5">
                            <div class="col-md-7 site-section-heading pt-4">
                                <h2>Categories</h2>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 col-md-6 col-lg-4 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="">
                                <a class="block-2-item" href="#">
                                    <figure class="image">
                                        <img src="layout/images/women.jpg" alt="" class="img-fluid">
                                    </figure>
                                    <div class="text">
                                        <span class="text-uppercase">Collections</span>
                                        <h3>Women</h3>
                                    </div>
                                </a>
                            </div>
                            <div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="100">
                                <a class="block-2-item" href="#">
                                    <figure class="image">
                                        <img src="layout/images/children.jpg" alt="" class="img-fluid">
                                    </figure>
                                    <div class="text">
                                        <span class="text-uppercase">Collections</span>
                                        <h3>Children</h3>
                                    </div>
                                </a>
                            </div>
                            <div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="200">
                                <a class="block-2-item" href="#">
                                    <figure class="image">
                                        <img src="layout/images/men.jpg" alt="" class="img-fluid">
                                    </figure>
                                    <div class="text">
                                        <span class="text-uppercase">Collections</span>
                                        <h3>Men</h3>
                                    </div>
                                </a>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>

    <footer class="site-footer border-top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 mb-5 mb-lg-0">
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="footer-heading mb-4">Navigations</h3>
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <ul class="list-unstyled">
                                <li><a href="#">Sell online</a></li>
                                <li><a href="#">Features</a></li>
                                <li><a href="#">Shopping cart</a></li>
                                <li><a href="#">Store builder</a></li>
                            </ul>
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <ul class="list-unstyled">
                                <li><a href="#">Mobile commerce</a></li>
                                <li><a href="#">Dropshipping</a></li>
                                <li><a href="#">Website development</a></li>
                            </ul>
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <ul class="list-unstyled">
                                <li><a href="#">Point of sale</a></li>
                                <li><a href="#">Hardware</a></li>
                                <li><a href="#">Software</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">
                    <h3 class="footer-heading mb-4">Promo</h3>
                    <a href="#" class="block-6">
                        <img src="../../images/hero_1.jpg" alt="Image placeholder" class="img-fluid rounded mb-4">
                        <h3 class="font-weight-light  mb-0">Finding Your Perfect Shoes</h3>
                        <p>Promo from nuary 15 &mdash; 25, 2021</p>
                    </a>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="block-5 mb-5">
                        <h3 class="footer-heading mb-4">Contact Info</h3>
                        <ul class="list-unstyled">
                            <li class="address">203 Fake St. Mountain View, San Francisco, California, USA</li>
                            <li class="phone"><a href="tel://23923929210">+2 392 3929 210</a></li>
                            <li class="email">emailaddress@domain.com</li>
                        </ul>
                    </div>

                    <div class="block-7">
                        <form action="#" method="post">
                            <label for="email_subscribe" class="footer-heading">Subscribe</label>
                            <div class="form-group">
                                <input type="text" class="form-control py-4" id="email_subscribe" placeholder="Email">
                                <input type="submit" class="btn btn-sm btn-primary" value="Send">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="row pt-5 mt-5 text-center">
                <div class="col-md-12">
                    <p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script data-cfasync="false"
                                                src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
                        <script>document.write(new Date().getFullYear());</script>
                        All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i>
                        by <a href="https://colorlib.com" target="_blank" class="text-primary">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p>
                </div>

            </div>
        </div>
    </footer>
</div>

<script src="layout/js/jquery-ui.js"></script>
<script src="layout/js/JQuery/jquery-3.6.0.js"></script>
<script src="layout/js/popper.min.js"></script>
<script src="layout/js/bootstrap.min.js"></script>
<script src="layout/js/owl.carousel.min.js"></script>
<script src="layout/js/jquery.magnific-popup.min.js"></script>
<script src="layout/js/aos.js"></script>
<script src="layout/js/rangeSlider.js"></script>
<script src="layout/js/common.js"></script>
<script src="layout/js/main.js"></script>
<script>
    let activePageNum=+$("#ActivePage").html()
    let beforePage = activePageNum-1;
    let afterPage = activePageNum+1
    let before ="Shop?page="+(beforePage) ;
    let after ="Shop?page="+(afterPage) ;
    if (beforePage ===0) before="#";
    if(afterPage >"${requestScope.Pages}" ) after="#"
    $("#PageBefore").attr('href',before);
    $("#PageAfter").attr('href',after);



    var slider = document.getElementById("myRange");
    var output = document.getElementById("demo");
    output.innerHTML = slider.value;

    slider.oninput = function() {
        output.innerHTML = this.value;
    }

</script>
</body>
</html>
