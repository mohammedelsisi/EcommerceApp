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

    <title>Addresses</title>

    <!-- Custom fonts for this template-->
    <link href="layout/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link rel="stylesheet" href="layout/css/all.min.css"/>
    <link rel="stylesheet" href="layout/css/style.css"/>
    <link href="layout/css/sb-admin-2.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
    <!-- to add down arrow to menus -->
    <link rel="stylesheet" href="layout/fonts/icomoon/style.css">
    <link rel="stylesheet" href="layout/css/jquery-ui.css">
    <!-- to let horizontal scrolling -->
    <link rel="stylesheet" href="layout/css/owl.carousel.min.css">
    <!-- to add animations on vertical scrolling -->
    <link rel="stylesheet" href="layout/css/aos.css">
    <!--     to add the multiple selection plugin -->
    <link href="layout/css/filter_multi_select.css" rel="stylesheet">

    <script src="layout/js/filter-multi-select-bundle.js"></script>
    <script src="layout/js/bootstrap.min.js"></script>


</head>

<body class="site-wrap">


<%@include file="../toInclude/header.jsp" %>
</form>

<!-- Page Wrapper -->
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
        <div class="container h-100 " style="background: #4e73df;  ">

            <div class="d-flex justify-content-center h-100" style="padding-top: 70px; ">
                <div class="user_card" style="
    height: 1000px;
    width: 500px;
    /*margin-top: auto;*/
    /*margin-bottom: auto;*/
    background: #ffffff;
    position: relative;
    display: flex;
    flex-direction: column;
    padding: 0 5%;
    padding-top: 10%;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    border-radius: 5px;">
                    <div>
                        <h1 class="h4 text-gray-900 mb-4" STYLE="text-align: center; "> Addresses</h1>
                        <form class="user">
                            <ul id="Addresses" style=" list-style-type: none;">
                                <c:forEach items="${sessionScope.currentUser.addresses}" var="address">
                                    <li><label style="margin-top: 10%">${address}</label>
                                        <hr class="sidebar-divider my-0">
                                    </li>
                                    <%--                                    <input type="radio" id="address1" name="address" style="margin-top: 10%">--%>
                                </c:forEach>
                            </ul>


                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                       id="exampleInputAddress" STYLE=" position: absolute;  bottom: 100px; width: 85%"
                                       placeholder="Address...">
                            </div>


                        </form>
                        <div class="form-group">

                            <table STYLE=" position: absolute;  bottom: 0;">
                                <tr>
                                    <td style="padding-right: 50px;">


                                    </td>

                                    <td style="padding-left: 110px">

                                        <div class="form-group">
                                            <button onclick="appendAddress()"
                                                    class="btn btn-primary btn-user btn-block "
                                                    style="margin-top: 10%">Add
                                            </button>

                                        </div>

                                    </td>

                                </tr>
                            </table>

                        </div>
                    </div>

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
<script src="js/sb-admin-2.js"></script>
<script src="layout/js/addressScript.js"></script>

</body>
</html>
