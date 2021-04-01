<%--
  Created by IntelliJ IDEA.
  User: Hager
  Date: ٢٢/٠٣/٢٠٢١
  Time: ٠٧:٠٦ م
  To change this template use File | Settings | File Templates.
--%>

<head>
    <style>
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            padding: 6px 8px;
            z-index: 1;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
</head>
<header class="site-navbar" role="banner">
    <c:if test="${param.error=='-'}">
        <div class="shadow-lg p-2 mb-4 bg-white rounded" style="position: fixed; z-index:5">
            <div class="card-header">
                Cookies are disabled
            </div>
            <div class="card-body">
                <blockquote class="blockquote mb-0">
                    Please Enable Your Cookies to Enjoy Naseej Website full features
                </blockquote>
            </div>
        </div>
    </c:if>

    <div class="site-navbar-top">
        <div class="container">
            <div class="row align-items-center">

                <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
                    <form method="post" action="Shop" class="site-block-top-search">
                        <span class="icon icon-search2"></span>
                        <input name="Search" id="searchField" type="text" class="form-control border-0"
                               placeholder="Search">
                        <input name="minPrice" type="hidden" value="0" id="minValue">
                        <input name="maxPrice" type="hidden" value="2000" id="maxValue">

                </div>

                <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
                    <div class="site-logo">
                        <a href="Home" class="js-logo-clone">
                            <div class="brand-icon ">
                                <i class="fas fa-store"></i>
                            </div>
                            <div class="brand-text mx-3">Naseej Store</div>
                        </a>
                    </div>
                </div>

                <div class="col-6 col-md-4 order-3 order-md-3 text-right">
                    <div class="site-top-icons">
                        <ul>
                            <li><a href="#"></a></li>
                            <c:choose>
                                <c:when test="${sessionScope.login==true}">
                                    <li><a href="#"><span class="icon icon-person"></span></a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="#"></a>
                                        <div class="dropdown">
                                            <a style="background-color: #e6e7e9" class="btn btn-light dropdown-toggle"
                                               role="button" id="dropdownMenuLink" data-toggle="dropdown"
                                               aria-haspopup="true" aria-expanded="false">
                                                Hello! Log in
                                            </a>
                                            <div style="text-align: center" class="dropdown-menu"
                                                 aria-labelledby="dropdownMenuLink">
                                                <a class="btn btn-primary" style="color:white" href="Login">Log In</a>
                                                <div class="dropdown-divider"></div>
                                                <label class="dropdown-item">Don't Have an Account?</label>
                                                <a style="text-align: center" class="dropdown-item" href="Register">Sign
                                                    Up</a>
                                            </div>
                                        </div>
                                    </li>
                                </c:otherwise>
                            </c:choose>


                            <li>
                                <a href="Cart" class="site-cart">
                                    <span class="icon icon-shopping_cart"></span>
                                    <span class="count">${sessionScope.Cart.size()}</span>
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
                    <a href="Home">Home</a>
                </li>
                <li>
                    <a href="About">About</a>
                </li>
                <li><a href="Shop">Shop</a></li>
                <div class="dropdown">
                    <a href="#">PROFILE</a>
                    <div class="dropdown-content">
                        <lu style="list-style-type: none;">
                            <li class="nav-item" style="background: #bcbcbc;">
                                <a class="nav-link" href="Profile">
                                    <i class="fas fa-user"></i>
                                    <span>Profile</span></a></li>
                            <!-- Divider -->
                            <hr class="sidebar-divider">
                            <li class="nav-item">
                                <a class="nav-link" href="AddressesJsp">
                                    <i class="fas fa-map-marker-alt"></i>
                                    <span>Addresses</span></a>
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
                                <a class="nav-link" href="cart.html">
                                    <i class="fas fa-shopping-bag"></i>
                                    <span>Orders</span></a>
                            </li>
                            <!-- Divider -->
                            <hr class="sidebar-divider">
                            <li class="nav-item">
                                <a class="nav-link" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw"></i>
                                    <span>Logout</span></a>
                            </li>
                        </lu>
                    </div>
                </div>
                <li><a href="#">New Arrivals</a></li>
                <li><a href="contact.html">Contact</a></li>
            </ul>
        </div>
    </nav>
</header>


