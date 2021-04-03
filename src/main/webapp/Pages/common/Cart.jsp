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
    <link href="layout/css/bootstrap/bootstrap_5.0.css" rel="stylesheet">

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
    <%@include file="../toInclude/header.jsp" %>

    <div class="bg-light py-3">
        <div class="container">
            <div class="row">
                <div class="col-md-12 mb-0"><a href="Home">Home</a> <span class="mx-2 mb-0">/</span> <strong
                        class="text-black">Cart</strong></div>
            </div>
        </div>
    </div>

    <div class="site-section">
        <div class="container">
            <div class="row mb-5">
                <form class="col-md-12" method="post">
                    <div class="site-blocks-table">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th class="product-thumbnail">Image</th>
                                <th class="product-name">Product</th>
                                <th class="product-price">Price</th>
                                <th class="product-quantity">Quantity</th>
                                <th class="product-total">Total</th>
                                <th class="product-remove">Remove</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${requestScope.CartItems}" var="i">
                                <tr id="${i.productID}">
                                    <td class="product-thumbnail">
                                        <img src=${i.itemImg} alt="Image" class="img-fluid">
                                    </td>
                                    <td class="product-name">
                                        <h2 class="h5 text-black">${i.itemType}</h2>
                                    </td>
                                    <td>$${i.itemPrice}</td>
                                    <td>
                                        <div class="input-group mb-3" style="max-width: 120px;">
                                            <div class="input-group-prepend">
                                                <button class="btn btn-outline-primary js-btn-minus" type="button"
                                                        onclick="updateSubTotal('counter${i.productID}','td${i.productID}',${i.itemPrice})">
                                                    &minus;
                                                </button>
                                            </div>
                                            <input id="counter${i.productID}" name="cartItem" type="text"
                                                   class="form-control text-center cartItem" value="${i.itemQuantity}"
                                                   placeholder="" aria-label="Example text with button addon"
                                                   aria-describedby="button-addon1">
                                            <div class="input-group-append">
                                                <button class="btn btn-outline-primary js-btn-plus" type="button"
                                                        onclick="updateAddTotal('counter${i.productID}','td${i.productID}',${i.itemPrice})">
                                                    &plus;
                                                </button>
                                            </div>
                                        </div>

                                    </td>

                                    <td class="totalItem" id="td${i.productID}">$${i.itemPrice*i.itemQuantity}</td>
                                    <td><input class="btn btn-primary" onclick="removeRow(${i.productID})"
                                               value="Remove" id="${i.productID} "></td>


                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </form>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="row mb-5">
                        <div class="col-md-5 mb-3 mb-md-0">
                            <button onclick="sendCartItems()" class="btn btn-primary btn-sm btn-block">Update Cart
                               </button>
                        </div>
                        <div class="col-md-2 mb-3 mb-md-0">
                            <div id="spinner" class="spinner-border" role="status" style="display:none;"></div>

                        </div>

                        <div class="col-md-5">
                            <a href="Shop" class="btn btn-outline-primary btn-sm btn-block">Continue Shopping
                            </a>

                        </div>
                    </div>

                </div>
                <div class="col-md-6 pl-5">
                    <div class="row justify-content-end">
                        <div class="col-md-7">
                            <div class="row">
                                <div class="col-md-12 text-right border-bottom mb-5">
                                    <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <span class="text-black">Subtotal</span>
                                </div>
                                <div class="col-md-6 text-right">
                                    <strong id="subTotal" class="text-black"></strong>
                                </div>
                            </div>
                            <div class="row mb-5">
                                <div class="col-md-6">
                                    <span class="text-black">Total</span>
                                </div>
                                <div class="col-md-6 text-right">
                                    <strong id="total" class="text-black">$230.00</strong>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <button class="btn btn-primary btn-lg py-3 btn-block"
                                            onclick="goToCheckout()">Checkout
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="../toInclude/footer.jsp" %>
</div>

<script src="layout/js/jquery-ui.js"></script>
<script src="layout/js/JQuery/jquery-3.6.0.js"></script>
<%--<script src="layout/js/popper.min.js"></script>--%>
<script src="layout/js/bootstrap.min.js"></script>
<script src="layout/js/owl.carousel.min.js"></script>
<script src="layout/js/jquery.magnific-popup.min.js"></script>
<script src="layout/js/aos.js"></script>
<script src="layout/js/main.js"></script>
<script src="layout/js/CartScript.js"></script>
<script>
    move = function (){
        <c:if test="${empty sessionScope.currentUser}">
        window.location="Login?checkout=1";
        </c:if>
        <c:if test="${not empty sessionScope.currentUser}">
        window.location="Checkout";
        </c:if>

    }
</script>
</body>
</html>