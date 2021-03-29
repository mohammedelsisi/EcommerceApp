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
    <%@include file="../toInclude/header.jsp" %>
    </form>
    <form id="orderForm" method="post" onsubmit="makeOrder();return false;">


        <div class="bg-light py-3">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 mb-0"><a href="Home">Home</a> <span class="mx-2 mb-0">/</span> <a
                            href="Cart">Cart</a> <span class="mx-2 mb-0">/</span> <strong
                            class="text-black">Checkout</strong></div>
                </div>
            </div>
        </div>

        <div class="site-section">
            <div class="container">

                <div class="row">
                    <div class="col-md-6 mb-5 mb-md-0">
                        <h2 class="h3 mb-3 text-black">Billing Details</h2>
                        <div class="p-3 p-lg-5 border">

                            <div class="form-group row">
                                <div class="col-md-12">
                                    <label for="c_fname" class="text-black">User Name<span
                                            class="text-danger"></span></label>
                                    <input type="text" class="form-control" id="c_fname"
                                           value="${sessionScope.currentUser.userName}" name="c_fname" disabled>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-12">
                                    <label for="c_companyname" class="text-black">Phone Number</label>
                                    <input value="${sessionScope.currentUser.phoneNumber}" type="text"
                                           class="form-control"
                                           id="c_companyname" name="c_companyname" disabled>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-12">
                                    <label for="c_email_address" class="text-black">Email Address <span
                                            class="text-danger">*</span></label>
                                    <input type="text" class="form-control" id="c_email_address" name="c_email_address"
                                           value="${sessionScope.currentUser.email}" disabled>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="c_country" class="text-black">Address<span
                                        class="text-danger">*</span></label>
                                <select id="c_country" class="form-control" required>
                                    <option value="">Choose Address</option>
                                    <option value="1">First Address</option>
                                    <option value="2">Second Address</option>
                                    <option value="3">Third Address</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="c_ship_different_address" class="text-black" data-toggle="collapse"
                                       href="#ship_different_address" role="button" aria-expanded="false"
                                       aria-controls="ship_different_address"><input onclick="disable()" type="checkbox"
                                                                                                         value="1"
                                                                                                         id="c_ship_different_address">
                                    Ship To
                                    A Different Address?</label>
                                <div class="collapse" id="ship_different_address">
                                    <div class="py-2">
                                        <div class="form-group row">
                                            <div class="col-md-12">
                                                <label for="c_addresssss" class="text-black">Use Custom address<span
                                                        class="text-danger">*</span></label>
                                                <input type="text" class="form-control" id="c_addresssss" name="c_address"
                                                       placeholder="Write you address here in details, please">
                                            </div>
                                        </div>

                                    </div>

                                </div>
                            </div>

                            <div class="form-group">
                                <label for="c_order_notes" class="text-black">Order Notes</label>
                                <textarea name="c_order_notes" id="c_order_notes" cols="30" rows="5"
                                          class="form-control"
                                          placeholder="Write your notes here..."></textarea>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-6">

                        <div class="row mb-5">
                            <div class="col-md-12">
                                <h2 class="h3 mb-3 text-black">Your Order</h2>
                                <div class="p-3 p-lg-5 border">
                                    <table class="table site-block-order-table mb-5">
                                        <thead>
                                        <th>Product</th>
                                        <th>Total</th>
                                        </thead>
                                        <tbody>
                                        <c:set var="count" value="0"/>
                                        <c:forEach var="cartItem" items="${sessionScope.Cart}">
                                            <tr>
                                                <td>${cartItem.itemType}<strong
                                                        class="mx-2">x</strong> ${cartItem.itemQuantity}</td>
                                                <td>$${cartItem.itemPrice*cartItem.itemQuantity}</td>
                                            </tr>
                                            <c:set var="count"
                                                   value="${cartItem.itemPrice*cartItem.itemQuantity+count}"/>
                                        </c:forEach>


                                        <tr>
                                            <td class="text-black font-weight-bold"><strong>Cart Subtotal</strong></td>
                                            <td class="text-black">$${count}</td>
                                        </tr>
                                        <tr>
                                            <td class="text-black font-weight-bold"><strong>Order Total</strong></td>
                                            <td class="text-black font-weight-bold"><strong>$${count+100}</strong></td>
                                        </tr>
                                        </tbody>
                                    </table>

                                    <div class="border p-3 mb-5">

                                        <input type="radio" class="btn-check" name="options" id="option1"
                                               autocomplete="off" checked>
                                        <label class="btn btn-secondary" for="option1"><h3 class="h6 mb-0"><a
                                                class="d-block" data-toggle="collapse" href="#collapsebank"
                                                role="button" aria-expanded="false"
                                                aria-controls="collapsebank">Using Cash</a></h3>
                                        </label>
                                    </div>
                                    <div class="border p-3 mb-5">
                                        <input type="radio" class="btn-check" name="options" id="option2"
                                               autocomplete="off" checked>
                                        <label class="btn btn-secondary" for="option2"><h3 class="h6 mb-0"><a
                                                class="d-block" data-toggle="collapse" href="#collapsebank"
                                                role="button" aria-expanded="false"
                                                aria-controls="collapsebank">Using Your Credit Limit</a></h3>
                                        </label>
                                    </div>


                                    <div class="form-group">
                                        <input type="submit" class="btn btn-primary btn-lg py-3 btn-block"/>
                                    </div>

                                </div>
                            </div>
                        </div>

                    </div>
                </div>
    </form>
    <!-- </form> -->
</div>
</div>
<form>
    <%@include file="../toInclude/footer.jsp" %>
    </div>

    <script src="layout/js/jquery-ui.js"></script>
    <script src="layout/js/jquery-3.3.1.min.js"></script>
    <script src="layout/js/popper.min.js"></script>
    <script src="layout/js/bootstrap.min.js"></script>
    <script src="layout/js/owl.carousel.min.js"></script>
    <script src="layout/js/jquery.magnific-popup.min.js"></script>
    <script src="layout/js/aos.js"></script>

    <script src="layout/js/main.js"></script>

        <script>
            let addressDisable = false;
            function disable() {

                if (!addressDisable){
                    $("#c_country").attr("disabled", true)
                    $("#c_addresssss").attr("required", true)

                    addressDisable=true
                }
                else {
                    $("#c_country").removeAttr("disabled")
                    $("#c_addresssss").removeAttr("required")

                    addressDisable = false;
                }
            }
            function makeOrder(){
                let address;
                if(addressDisable){
                    address  = $("#c_addresssss").val();
                }else {
                    address  = $("#c_country").val();
                }
                console.log(address)
                $.ajax({
                    url:"MakeOrder",
                    method:"POST",
                    data:{
                        "address":address
                    },
                    success:function (){
                        console.log("Hi Received new Order")
                    }

                })
            }
        </script>
</body>
</html>