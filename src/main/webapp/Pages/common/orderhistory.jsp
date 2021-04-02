<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="P" uri="/WEB-INF/tlds/productLib" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Order History</title>

    <!-- Custom fonts for this template-->
    <link href="layout/css/order.css" rel="stylesheet">


    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
    <!-- to add down arrow to menus -->
    <link rel="stylesheet" href="layout/fonts/icomoon/style.css">
    <link type="text/css" rel="stylesheet" href="layout/css/jsgrid.min.css"/>
    <link type="text/css" rel="stylesheet" href="layout/css/jsgrid-theme.min.css"/>
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
    <link rel="stylesheet" href="layout/fonts/icomoon/style.css">

    <link href="layout/css/bootstrap/bootstrap_5.0.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="layout/css/sb-admin-2.css">
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
<!-- Page Wrapper -->
<body class="site-wrap">

<%@include file="../toInclude/header.jsp" %>
</form>


<div id="wrapper">

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <!-- Begin Page Content -->
            <div class="container-fluid">


            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->
        <div class="container h-100" style="background: #4e73df; ">

            <div class="d-flex justify-content-center h-100" style="padding-top: 60px;">
                <div class="user_card" style="
    width:80%;
    /*margin-top: auto;*/
    margin-bottom: auto;
    background: #ffffff;
    position: relative;
    display: flex;
    flex-direction: column;
    padding: 0 5%;
    padding-top: 6%;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    border-radius: 5px;">
                    <h2 align="center">Orders History</h2>
                    <br>
                    <table class="table table-bordered">
                        <thead class="thead-light">
                        <tr>
                            <th scope="col">Order Id</th>
                            <th scope="col">Date Added</th>
                            <th scope="col">Total Amount</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${requestScope.orders}" var="order">
                            <tr>
                                <th scope="row">${order.id}</th>
                                <td>${order.purchaseDate}</td>
                                <td>$${order.totalAmount}</td>
                                <td align="center">
                                    <button data-target="#myModal${order.id}"  data-toggle="modal" data-placement="top" title="View Order History" class="btn btn-info btn-lg">
                                        <span >  <i class="fas fa-eye"></i></span>
                                    </button>
                                </td>
                            </tr>
                            <div id="myModal${order.id}" class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-body ">
                                            <div class="text-right"> <i class="fa fa-close close" data-dismiss="modal"></i> </div>
                                            <div class="px-4 py-5">
                                                <h5 class="text-uppercase">Order Details </h5>
                                                <h4 class="mt-5 theme-color mb-5">Thanks for your order</h4> <span class="theme-color">Payment Summary</span>
                                                <div class="mb-3">
                                                    <hr class="new1">
                                                </div>
                                                <c:forEach items="${order.items}" var="item">
                                                    <div class="d-flex justify-content-between"> <span class="font-weight-bold">${item.itemType}-(Qty:${item.itemQuantity}) </span> <span class="text-muted">$${item.itemQuantity*item.itemPrice}</span> </div>
                                                </c:forEach>

                                                <div class="d-flex justify-content-between"> <small>Shipping</small> <small>$70.00</small> </div>
                                                <div class="d-flex justify-content-between"> <small>Tax</small> <small>$30.00</small> </div>
                                                <div class="d-flex justify-content-between mt-3"> <span class="font-weight-bold">Total</span> <span class="font-weight-bold theme-color">$${order.totalAmount}</span> </div>
                                                <div class="text-center mt-5"> <button data-dismiss="modal" class="btn btn-primary">Close</button> </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Footer -->
            <%@include file="../toInclude/footer.jsp" %>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true" style="align-self: center">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>
    <!--changePassword Modal-->
    <div class="modal fade" id="changePasswordModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true" style="align-self: center">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel2">Change Password</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>

                <form>
                    <div class="modal-body">
                        Enter your current password and new password to change the password
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <input type="text" class="form-control form-control-user" id="exampleInputPassword"
                                   placeholder="Current password...">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-user" id="exampleInputNewPassword"
                                   placeholder="New password...">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input class="btn btn-secondary" type="submit" value="Ok" data-dismiss="modal"
                               style="background: #4e73df; border: #4e73df"/>
                        <input class="btn btn-secondary" type="reset" value="Cancel" data-dismiss="modal"/>
                    </div>
                </form>


            </div>


        </div>
    </div>
</div>
<script src="layout/js/jquery-ui.js"></script>
<script src="layout/js/JQuery/jquery-3.6.0.js"></script>
<script src="layout/js/popper.min.js"></script>
<script src="layout/js/bootstrap.min.js"></script>
<script src="layout/js/owl.carousel.min.js"></script>
<script src="layout/js/jquery.magnific-popup.min.js"></script>
<script src="layout/js/aos.js"></script>
<script src="layout/js/main.js"></script>

</body>

</html>
