<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="P" uri="/WEB-INF/tlds/productLib" %>
<!DOCTYPE html>
<html>
<head>
  <title>The page you were looking for doesn't exist (404)</title>
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>Shoppers &mdash; Colorlib e-Commerce Template</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


  <style>
  body {
    background-color: #EFEFEF;
    color: #2E2F30;
    text-align: center;
    font-family: arial, sans-serif;
    margin: 0;
  }

  div.dialog {
    width: 95%;
    max-width: 33em;
    margin: 4em auto 0;
  }

  div.dialog > div {
    border: 1px solid #CCC;
    border-right-color: #999;
    border-left-color: #999;
    border-bottom-color: #BBB;
    border-top: #B00100 solid 4px;
    border-top-left-radius: 9px;
    border-top-right-radius: 9px;
    background-color: white;
    padding: 7px 12% 0;
    box-shadow: 0 3px 8px rgba(50, 50, 50, 0.17);
  }



  div.dialog > p {
    margin: 0 0 1em;
    padding: 1em;
    background-color: #F7F7F7;
    border: 1px solid #CCC;
    border-right-color: #999;
    border-left-color: #999;
    border-bottom-color: #999;
    border-bottom-left-radius: 4px;
    border-bottom-right-radius: 4px;
    border-top-color: #DADADA;
    color: #666;
    box-shadow: 0 3px 8px rgba(50, 50, 50, 0.17);
  }
  </style>

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
  <link href="layout/css/about.css" rel="stylesheet" type="text/css">
  <style>
    h1 {
      font-size: 100%;
      color: #730E15;
      line-height: 1.5em;
    }
  </style>
</head>

<body>
<%@include file="../toInclude/header.jsp" %>

  <!-- This file lives in public/404.html -->
  <div class="dialog">
    <div>
      <h1>The page you were looking for doesn't exist.</h1>
      <p>You may have mistyped the address or the page may have moved.</p>
    </div>
    <p>If you are the application owner check the logs for more information.</p>
  </div>
<%@include file="../toInclude/footer.jsp"%>

</body>
</html>
