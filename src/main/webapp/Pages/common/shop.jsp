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
    <link rel="stylesheet" href="layout/css/rangeSlider.css"/>
    <link rel="stylesheet" href="layout/css/slider-style.css"/>
    <!-- for font awsowome icon -->
    <link href="layout/css/all.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/rSlider.min.css">
    <link rel="stylesheet" href="layout/css/rSlider.min.css"/>
    <link rel="stylesheet" href="layout/css/rSlider.css"/>

</head>
<body>
<div class="site-wrap">
    <%@include file="../toInclude/header.jsp"%>

    <div class="bg-light py-3">
        <div class="container">
            <div class="row">
                <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong
                        class="text-black">Shop</strong></div>
            </div>
        </div>
    </div>

    <div class="site-section">
        <div class="container">

            <div class="row mb-5">
                <div class="col-md-9 order-2">

                    <div class="row mb-5">
                        <c:forEach items="${requestScope.Products}" var="i">
                            <div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
                                <P:product img="${i.firstProdImg}" desc="${i.prodDescription}" src="ProductItem?id=${i.prodID}" price="${i.productPrice}"/>
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
                                    <c:forEach var="i" begin="${Init}" end="${requestScope.Pages}">
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
                            <li class="mb-1"><a href="#" class="d-flex"><span>Men</span> <span
                                    class="text-black ml-auto">(2,220)</span></a></li>
                            <li class="mb-1"><a href="#" class="d-flex"><span>Women</span> <span
                                    class="text-black ml-auto">(2,550)</span></a></li>
                            <li class="mb-1"><a href="#" class="d-flex"><span>Children</span> <span
                                    class="text-black ml-auto">(2,124)</span></a></li>
                        </ul>
                    </div>
                    <%@include file="../toInclude/sizeAndColorForm.jsp" %>
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

    <%@include file="../toInclude/footer.jsp"%>
</div>

<script src="layout/js/jquery-ui.js"></script>
<script src="layout/js/JQuery/jquery-3.6.0.js"></script>
<script src="layout/js/popper.min.js"></script>
<script src="layout/js/bootstrap.min.js"></script>
<script src="layout/js/owl.carousel.min.js"></script>
<script src="layout/js/jquery.magnific-popup.min.js"></script>
<script src="layout/js/aos.js"></script>

<script src="layout/js/rangeSlider.js"></script>
<script src="layout/js/common.js" async></script>
<script src="layout/js/main.js"></script>
<script src="layout/js/rSlider.js"></script>
<script src="js/rSlider.min.js"></script>
<script src="layout/js/rSlider.min.js"></script>
<%--<script src="layout/js/shopscript.js"></script>--%>
<script>
    let activePageNum = +$("#ActivePage").html()
    let beforePage = activePageNum - 1;
    let afterPage = activePageNum + 1
    let before = "Shop?page=" + (beforePage);
    let after = "Shop?page=" + (afterPage);
    if (beforePage === 0) before = "#";
    if (afterPage > "${requestScope.Pages}") after = "#"
    $("#PageBefore").attr('href', before);
    $("#PageAfter").attr('href', after);

</script>
<script>
    (function () {
        'use strict';

        var init = function () {
            var minPrice = +"${sessionScope.Filters.minPrice}" == 0 ? 0 : +"${sessionScope.Filters.minPrice}";
            var maxPrice = +"${sessionScope.Filters.maxPrice}" == 0 ? 2000 : +"${sessionScope.Filters.maxPrice}";

            slider = new rSlider({
                target: '#slider',
                values: [0, 250, 500, 750, 1000, 1250, 1500, 1750, 2000],
                range: true,
                labels: false,
                set: [minPrice, maxPrice],
                onChange: function (vals) {
                    let prices = vals.split(",");
                    $("#minValue").val(prices[0]);
                    $("#maxValue").val(prices[1]);

                }
            });
        };
        window.onload = init;
    })();

</script>
<script>
    <c:forEach items="${sessionScope.Filters.colors}" var="color">
    $("input[name=Color]").each(function () {
        if (this.id == "${color}") {
            this.setAttribute("checked", true);
        }
        ;
    })
    </c:forEach>
    <c:forEach items="${sessionScope.Filters.sizes}" var="size">
    $("input[name=Size]").each(function () {
        if (this.id == "${size}") {
            this.setAttribute("checked", true);
        }
        ;
    })
    </c:forEach>

    $("#searchField").val("${sessionScope.Filters.search}");
</script>
</body>
</html>
