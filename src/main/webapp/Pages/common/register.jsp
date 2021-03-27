<%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 3/17/2021
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Register</title>

    <!-- Custom fonts for this template-->
    <link href="layout/css/bootstrap/bootstrap_5.0.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="layout/css/sb-admin-2.css" rel="stylesheet">
    <link href="layout/css/new_all.min/all.min.css">
    <script src="layout/js/JQuery/jquery-3.6.0.js"></script>


    <link href="layout/css/registration.css" rel="stylesheet">

    <!--     to add the multiple selection plugin -->
    <link href="layout/css/filter_multi_select.css" rel="stylesheet">
    <script src="layout/js/filter-multi-select-bundle.js"></script>


    <script src="layout/js/fontawesome.js" async></script>
    <script src="layout/js/sb-admin-2.js" async></script>
    <script src="layout/js/JQuery/jquery.validate.js" async></script>


</head>

<body class="bg-gradient-primary">

<div class="container">
    <div class="card o-hidden border-0 shadow-lg my-5">


        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
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
                            <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                        </div>
                        <form id="signUpForm" class="user needs-validation" method="post" id="registrationForm" action="SignUp" novalidate>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0 form-floating">
                                    <input name="userName" type="text" class="form-control form-control-user" id="exampleFirstName"
                                           placeholder="Your Name" minlength="3" required>
                                    <label style="padding-left:25px;color: grey" for="exampleFirstName">Your
                                        Name</label>
                                    <div style="padding-left: 25px" class="valid-feedback">
                                        Looks good!
                                    </div>
                                    <div style="padding-left: 25px" class="invalid-feedback">
                                        User Name at least 3 letters.
                                    </div>
                                </div>

                                <div class="col-sm-6 mb-3 mb-sm-0 form-floating">
                                    <input name="creditLimit" type="number" class="form-control form-control-user" id="exampleCreditLimit"
                                           placeholder="Credit Limit" min="0">
                                    <label style="padding-left:25px;color: grey" for="exampleCreditLimit">Credit
                                        Limit</label>

                                </div>
                            </div>
                            <div class="form-floating mb-3">
                                <input name="phoneNumber" type="text" class="form-control form-control-user" id="phoneNumber"
                                       placeholder="Phone Number" minlength="10" required pattern="^\d{11}$">
                                <label style="padding-left:25px;color: grey" for="exampleFirstName">Phone Number</label>
                                <div style="padding-left: 25px" class="valid-feedback">
                                    Looks good!
                                </div>
                                <div style="padding-left: 25px" class="invalid-feedback">
                                    Please enter a valid phone number
                                </div>
                            </div>

                            <div class="form-floating mb-3">
                                <input name="email" type="email" class="form-control form-control-user" id="exampleInputEmail2"
                                       placeholder="Email Address" pattern="\S+@\S+\.\S+" required>
                                <label style="color: grey" for="exampleInputEmail2">Email address</label>
                                <div id="validEmailDiv" style="padding-left: 25px" class="valid-feedback">
                                    Looks good!
                                </div>
                                <div id="invalidEmailDiv" style="padding-left: 25px" class="invalid-feedback">
                                    Email must be at format xx@xx.xx
                                </div>
                            </div>

                            <div class="form-floating mb-3">
                                <input name="job" type="text" class="form-control form-control-user" id="userJobId"
                                       placeholder="Your Job">
                                <label style="color: grey" for="exampleInputEmail2">Job</label>
                            </div>


                            <div class="form-group">
                                <input name="birthDate" type="date" class="form-control form-control-user" id="userDateId"
                                       placeholder="Birthday" max="2010-01-01" value="1990-01-01" required>
                            </div>



                            <!--                            <div class="form-group row">-->
                            <!--                                <label class="col-2 col-form-label" for="interests">Interests</label>-->
                            <div class="form-group">
                                <select style="border-radius: 10rem;" multiple name="interests" id="interests" class="filter-multi-select form-control">
                                    <option value="Men">Men</option>
                                    <option value="Woman">Woman</option>
                                    <option value="Children">Children</option>
                                    <option value="Shoes">Shoes</option>
                                    <option value="Accessories">Accessories</option>
                                    <option value="Watches">Watches</option>
                                    <option value="Bags">Bags</option>
                                    <option value="Sports">Sports</option>
                                </select>
                            </div>







                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0 form-floating">
                                    <input name="password" type="password" class="form-control form-control-user"
                                           id="exampleInputPassword" placeholder="Password" minlength="6" required>
                                    <label style="padding-left:25px;color: grey"
                                           for="exampleInputPassword">Password</label>
                                    <div style="padding-left: 25px" class="valid-feedback">
                                        Looks good!
                                    </div>
                                    <div style="padding-left: 25px" class="invalid-feedback">
                                        Password must be at least 6 characters.
                                    </div>

                                </div>
                                <div class="col-sm-6 form-floating">
                                    <input type="password" class="form-control form-control-user"
                                           id="exampleRepeatPassword" placeholder="Repeat Password" minlength="6" required>
                                    <label style="padding-left:25px;color: grey" for="exampleRepeatPassword">Repeat
                                        Password</label>
                                    <div id="validPass" style="padding-left: 25px" class="valid-feedback">
                                        Passwords Matched!
                                    </div>
                                    <div id="invalidPass" style="padding-left: 25px" class="invalid-feedback">
                                        Passwords must match!
                                    </div>
                                </div>
                            </div>
                            <div style="margin-right:2px; margin-left: 2px" class="form-group row">
                                <button type="submit" class="btn btn-primary btn-user btn-block">Create Account</button>
                            </div>
                            <hr>
                            <a href="index.html" class="btn btn-google btn-user btn-block">
                                <i class="fab fa-google fa-fw"></i> Register with Google
                            </a>
                            <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                            </a>
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="forgot-password.html">Forgot Password?</a>
                        </div>
                        <div class="text-center">
                            <a class="small" href="Login">Already have an account? Login!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="layout/js/registration.js" async></script>

</body>

</html>
