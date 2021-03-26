<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Addresses</title>

    <!-- Custom fonts for this template-->


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

    <link href="css/sb-admin-2.css" rel="stylesheet">
    <link href="layout/css/bootstrap/bootstrap_5.0.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

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
                            <div class="brand-icon rotate-n-15">
                                <i class="fas fa-paw"></i>
                            </div>
                            <div class="brand-text mx-3">PeTopia</div>
                        </a>
                    </div>
                </div>

                <div class="col-6 col-md-4 order-3 order-md-3 text-right">
                    <div class="site-top-icons">
                        <ul>
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
                <li class="has-children active">
                    <a href="index.html">Home</a>
                    <ul class="dropdown">
                        <li><a href="#">Menu One</a></li>
                        <li><a href="#">Menu Two</a></li>
                        <li><a href="#">Menu Three</a></li>
                        <li class="has-children">
                            <a href="#">Sub Menu</a>
                            <ul class="dropdown">
                                <li><a href="#">Menu One</a></li>
                                <li><a href="#">Menu Two</a></li>
                                <li><a href="#">Menu Three</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li class="has-children">
                    <a href="about.html">About</a>
                    <ul class="dropdown">
                        <li><a href="#">Menu One</a></li>
                        <li><a href="#">Menu Two</a></li>
                        <li><a href="#">Menu Three</a></li>
                    </ul>
                </li>
                <li><a href="shop.html">Shop</a></li>
                <li><a href="#">Catalogue</a></li>
                <li><a href="#">New Arrivals</a></li>
                <li><a href="contact.html">Contact</a></li>
            </ul>
        </div>
    </nav>
</header>
<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-light
      accordion" id="accordionSidebar" style="background: white; ">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html ">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-paw"></i>
            </div>
            <div class="sidebar-brand-text mx-3">PeTopia</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item">
            <a class="nav-link" href="ProfileJsp">
                <i class="fas fa-user"></i>
                <span>Profile</span></a>


        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">
        <li class="nav-item">
            <a class="nav-link" href="cart.html">
                <i class="fas fa-shopping-bag"></i>
                <span>Orders</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">
        <li class="nav-item">
            <a class="nav-link" href="#">
                <i class="fas fa-money-bill"></i>
                <span>Payments</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">
        <li class="nav-item">
            <a class="nav-link" href="#">
                <i class="fas fa-wallet"></i>
                <span>Wallet</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">
        <li class="nav-item" style="background-color : #bcbcbc;">
            <a class="nav-link" href="address.jsp">
                <i class="fas fa-map-marker-alt"></i>
                <span>Addresses</span></a>
        </li>


        <li class="nav-item" STYLE=" position: absolute;  bottom: 0;">
            <a class="nav-link" href="#" data-toggle="modal" data-target="#logoutModal">
                <i class="fas fa-sign-out-alt fa-sm fa-fw"></i>
                <span>Logout</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

    </ul>
    <!-- End of Sidebar -->

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
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; ITI 2021</span>
                    </div>
                </div>
            </footer>
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
<script src="js/jquery-3.4.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/fontawesome.js"></script>
<script src="js/sb-admin-2.js"></script>
<script>
    (function () {
        'use strict'
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()

    function appendAddress() {

        var node = document.createElement("LI");

        node.innerHTML = ('<input type="radio" id="address1" name="address" style="margin-top: 10%"> <label for="address1">' + document.getElementById("exampleInputAddress").value + '</label><!-- Divider --><hr class="sidebar-divider my-0">');

        document.getElementById("Addresses").appendChild(node);

    }
</script>

</body>

</html>
