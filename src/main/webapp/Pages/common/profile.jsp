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

    <title>Profile</title>

    <!-- Custom fonts for this template-->

    <link href="layout/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link rel="stylesheet" href="layout/css/all.min.css"/> <!--removed the logo-->
    <link rel="stylesheet" href="layout/css/style.css"/> <!--the top bar style-->
    <link href="layout/css/sb-admin-2.css" rel="stylesheet">
    <link href="layout/css/ProfileCss/changephoto.css" rel="stylesheet"> <!--the image-->


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Custom fonts for this template-->
    <link href="layout/css/ProfileCss/bootstrap/bootstrap_5.0.css" rel="stylesheet"> <!--the main card place-->

    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="layout/css/ProfileCss/sb-admin-2.css" rel="stylesheet"> <!--side bar-->
    <link href="layout/css/new_all.min/all.min.css"> <!--no change-->


    <!--     to add the multiple selection plugin -->
    <link href="layout/css/filter_multi_select.css" rel="stylesheet"> <!--footer-->


    <style>
        .nav-item {
            background-color: #ffffff;
        }

        .background_selected {
            background-color: #bcbcbc;
        }
    </style>
</head>

<body class="bg-gradient-primary">


<%@include file="../toInclude/header.jsp"%>
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
        <li class="nav-item" style="background: #bcbcbc;">
            <a class="nav-link" href="profile.jsp">
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
        <li class="nav-item">
            <a class="nav-link" href="AddressesJsp">
                <i class="fas fa-map-marker-alt"></i>
                <span>Addresses</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">
        <li class="nav-item" >
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

            <div class="d-flex justify-content-center h-100" style="padding-top: 70px;">
                <div class="user_card" style="
    height: 650px;
    width: 500px;
    margin-top: auto;
    margin-bottom: auto;
    background: #ffffff;
    position: relative;
    display: flex;
    justify-content: center;
    flex-direction: column;
    padding: 10px;
    margin-bottom: 10px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    border-radius: 5px;">

                    <!-- Outer Row -->


                    <!-- Nested Row within Card Body -->

                    <div class="d-flex justify-content-center">

                        <div class="brand_logo_container" style="  position: absolute;
  height: 170px;
  width: 170px;
  top: -75px;
  border-radius: 50%;
  background: #4e73df;
  padding: 10px;
  text-align: center;">

                            <%--                            <input type="File" name="ChosenUserimage" id="ChosenUserimag2e">--%>

                            <form id="imageData" method="post" enctype="multipart/form-data">
                                <label for="ChosenUserimage">
                                    <div class="profile-pic" id="UserImage"
                                         style="background-image: url('layout/images/img_avatar2.png')">
                                        <div style="">
                                            <span class="fas fa-camera"></span>
                                            <span>Change Image</span>
                                        </div>
                                        <input type="File" name="ChosenUserImageName" id="ChosenUserimage" hidden>

                                    </div>
                                </label>
                                </label>
                            </form>

                        </div>
                    </div>
                    <form class="user needs-validation" id="ProfileForm"
                          enctype="multipart/form-data" novalidate style="margin-top: 60px"
                          onsubmit="sendData();return false">
                        <h1 class="h4 text-gray-900 mb-4"
                            STYLE="text-align: center">${sessionScope.currentUser.email}</h1>

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control form-control-user" id="usernameInputExample"
                                   placeholder="User Name..." value="${sessionScope.currentUser.userName}">
                            <label style="color: grey">User Name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control form-control-user" id="phoneNumber"
                                   placeholder="Your Phone Number" value="${sessionScope.currentUser.phoneNumber}">
                            <label style="color: grey">Phone Number</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="date" class="form-control form-control-user" id="userDateId"
                                   placeholder="Your Birthdate .. " max="2010-01-01"
                                   value="${sessionScope.currentUser.birthday}" required>
                            <label style="color: grey">Birth Date</label>
                        </div>


                        <div class="form-floating mb-3">
                            <input type="text" class="form-control form-control-user" id="exampleInputCreditLimit"
                                   placeholder="Your Credit Limit" value="${sessionScope.currentUser.creditLimit}">
                            <label style="color: grey">Credit Limit</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control form-control-user" id="userJobId"
                                   placeholder="Your Job" value="${sessionScope.currentUser.job}">
                            <label style="color: grey">Job</label>
                        </div>
                        <center>
                            <table>
                                <td>
                                    <div style="margin-right:2px; margin-left: 2px;" class="form-group row">
                                        <button type="submit" class="btn btn-primary btn-user btn-block">Save Changes
                                        </button>
                                    </div>
                                </td>
                                <td>
                                    <div style="margin-right:2px; margin-left: 2px;" class="form-group row">
                                        <a href="#" class="btn btn-primary btn-user btn-block"
                                           data-toggle="modal" data-target="#changePasswordModal">
                                            Change Password</a></div>
                                </td>
                            </table>

                        </center>
                    </form>

                </div>


            </div>


        </div>

        </footer>
        <%@include file="../toInclude/footer.jsp"%>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<%--confrim send data modal--%>
<div class="modal fade" id="changeInfoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true" style="align-self: center">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Changing Your Profile</h5>
            </div>
            <div style="text-align: center" class="modal-body" id="confirmChange"></div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">OK</button>
            </div>
        </div>
    </div>
</div>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true" style="align-self: center">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.jsp">Logout</a>
            </div>
        </div>
    </div>
</div>
<!--changePassword Modal-->
<div class="modal fade" id="changePasswordModal" tabindex="0" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true" style="align-self: center">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">Change Password</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">x</span>
                </button>
            </div>
            <form class="user" id="registrationForm"
                  style="margin-left: 10px; margin-right: 10px;"
                  enctype="multipart/form-data" onsubmit="changePassword();return false;">
                <div class="modal-body">
                    Enter your current password and new password to change the password
                </div>
                <div class="form-group row">
                    <div class="form-group">
                        <input type="password" class="form-control form-control-user" id="exampleInputNPassword"
                               placeholder="Current password..." required>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control form-control-user"
                               id="exampleInputPassword" placeholder="Password" minlength="6" required>
                        <div style="padding-left: 25px" class="valid-feedback">
                            Looks good!
                        </div>
                        <div style="padding-left: 25px" class="invalid-feedback">
                            Password must be at least 6 characters.
                        </div>

                    </div>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control form-control-user"
                           id="exampleRepeatPassword" placeholder="Repeat Password" minlength="6" required>
                </div>
                <div class="modal-footer">
                    <input class="btn btn-secondary" type="submit" value="Ok"
                           style="background: #4e73df; border: #4e73df"/>
                    <input class="btn btn-secondary" type="reset" value="Cancel" data-dismiss="modal"/>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="layout/js/jquery-3.4.0.min.js"></script>
<script src="layout/js/bootstrap.min.js"></script>
<script src="layout/js/fontawesome.js"></script>
<script src="layout/js/sb-admin-2.js"></script>
<script src="layout/js/sb-admin-2.js"></script>
<script src="layout/js/profileScript.js"></script>
<script src="layout/js/filter-multi-select-bundle.js"></script>
<script src="layout/js/JQuery/jquery-3.6.0.js"></script>

</body>

</html>
