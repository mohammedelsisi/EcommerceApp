<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
    <!-- for font awsowome icon -->
    <link href="layout/css/all.min.css" rel="stylesheet" type="text/css">

</head>
<body>

<div class="site-wrap">
    <%@include file="../toInclude/header.jsp"%>
    </form>

    <div class="bg-light py-3">
        <div class="container">
            <div class="row">
                <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <a href="index.html">Shop</a> <span class="mx-2 mb-0">/</span><strong class="text-black">Tank Top T-Shirt</strong></div>
            </div>
        </div>
    </div>

    <div class="site-section">
        <div class="container">
            <div class="row">
                <div class="col-md-6">





                    <c:set value="${requestScope.ProductItem}" var="item"/>
                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>

                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="d-block w-100" src="${item.secondProdImg}" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="${item.firstProdImg}" alt="Second slide">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>






                </div>
                <div class="col-md-6">
                    <h2 class="text-black">${item.prodType}</h2>
                    <p>${item.prodDescription}</p>
                    <p><strong class="text-primary h4">$${item.productPrice}</strong></p>
                   <form id="formCart" onsubmit="sendData();return false;">


                    <div class="mb-5">
                        <div class="input-group mb-3" style="max-width: 120px;">
                            <div class="input-group-prepend">
                                <button class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button>
                            </div>
                            <input type="hidden" value="${param.id}" name="productID">
                            <input name="Quantity" type="text" class="form-control text-center" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                            <div class="input-group-append">
                                <button class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button>
                            </div>
                        </div>

                    </div>
                    <p><input type="submit" value="Add To Cart" class="buy-now btn btn-sm btn-primary"/>
                    </p>
                   </form>
                </div>
            </div>
        </div>
    </div>

    <div
            class="modal fade"
            id="exampleModal"
            tabindex="-1"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
   style="margin-top: 12%">
        <div class="modal-dialog" >
            <div class="modal-content">
                <div class="modal-header">
                </div>
                <div style="text-align: center" class="modal-body">${item.prodType} was added to your cart</div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Continue Shopping</button>
                    <a href="Cart" type="button" class="btn btn-primary">Go to Cart</a>
                </div>
            </div>
        </div>
    </div>

<form>
    <%@include file="../toInclude/footer.jsp"%>

</div>


<script src="layout/js/jquery-3.3.1.min.js"></script>
<script src="layout/js/popper.min.js"></script>
<script src="layout/js/bootstrap.min.js"></script>
<script src="layout/js/owl.carousel.min.js"></script>
<script src="layout/js/jquery.magnific-popup.min.js"></script>
<script src="layout/js/aos.js"></script>
<script src="layout/js/JQuery/addCartScript.js"></script>

<script src="layout/js/main.js"></script>

</body>
</html>