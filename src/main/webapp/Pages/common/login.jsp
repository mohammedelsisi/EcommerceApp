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

  <title>Login</title>

  <!-- Custom fonts for this template-->
  <link href="layout/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="layout/css/sb-admin-2.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Chango&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Chango&family=Oswald&display=swap" rel="stylesheet">
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

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>

              <div class="col-lg-6">

                  <div class="p-5">
                      <div class="row align-items-center">
                          <div class="col-12 mb-md-0 order-1 order-md-2 text-center">
                              <div class="site-logo">
                                  <a href="Home" class="js-logo-clone">
                                      <div class="brand-icon ">
                                          <i class="fas fa-store"></i>
                                      </div>
                                      <h2 class="brand-text mx-3">Naseej Store</h2>
                                  </a>
                              </div>
                          </div>
                      </div>
                      <br>


                      <div class="text-center">

                        <c:choose>
                          <c:when test="${not empty param.email}">
                              <h1 class="h4 text-gray-900 mb-4" style="font-family: Oswald,serif"> Registration Success</h1>

                          </c:when>
                          <c:when test="${not empty param.invalid}">
                              <h1 class="h4 text-gray-900 mb-4" style="font-family: Oswald,serif"> Welcome!</h1>
                              <label class="alert-danger" role="alert">
                                Invalid Email or password please try again!
                              </label>
                          </c:when>
                          <c:otherwise>
                              <h1 class="h4 text-gray-900 mb-4"  style="font-family: Chango,serif">Welcome!</h1>
                          </c:otherwise>
                      </c:choose>


                  </div>
                  <form class="user" action="SignIn" method="post">
                    <div class="form-group">
                        <c:choose>
                            <c:when test="${not empty param.email}">
                                <input value="${param.email}" type="email" name="userEmail" class="form-control form-control-user" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter Email Address..." required>
                                <script>
                                    window.onload = function() {
                                        document.getElementById("exampleInputPassword").focus();
                                    }
                                </script>
                            </c:when>
                            <c:when test="${empty param.email}">
                                <input type="email" name="userEmail" class="form-control form-control-user" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter Email Address..." required autofocus>
                            </c:when>
                        </c:choose>
                    </div>
                    <div class="form-group">
                      <input type="password" name="userPassword" class="form-control form-control-user" id="exampleInputPassword" placeholder="Password" required>
                    </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input name="rememberMe" type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">Remember Me</label>
                      </div>
                    </div>
                      <div>
                          <button type="submit" value="Login" class="btn btn-primary btn-user btn-block">Login</button>
                      </div>
                    <hr>
                    <a href="#" data-toggle="modal" data-target="#exampleModal" class="btn btn-google btn-user btn-block">
                      <i class="fab fa-google fa-fw"></i> Login with Google
                    </a>
                    <a href="#" data-toggle="modal" data-target="#exampleModal" class="btn btn-facebook btn-user btn-block">
                      <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                    </a>
                  </form>
                  <hr>
                  <div class="text-center">
                    <a class="small" data-toggle="modal" data-target="#exampleModal" href="#">Forgot Password?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="Register">Create an Account!</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>
  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
          <div class="modal-content">
              <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Feature to Come</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                  </button>
              </div>
              <div class="modal-body">
                  This Feature will be available Soon :)
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              </div>
          </div>
      </div>
  </div>

  <script src="layout/js/jquery-3.4.0.min.js"></script>
  <script src="layout/js/bootstrap.min.js"></script>
  <script src="layout/js/fontawesome.js"></script>
  <script src="layout/js/sb-admin-2.js"></script>
</body>

</html>
