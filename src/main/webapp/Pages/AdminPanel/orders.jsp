<%@taglib prefix="B" uri="/WEB-INF/tlds/breadcrumbLib" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>admin pannel</title>

  <!-- Custom Style for JS Grid datatables-->
  <link type="text/css" rel="stylesheet" href="layout/css/jsgrid.min.css"/>
  <link type="text/css" rel="stylesheet" href="layout/css/jsgrid-theme.min.css"/>
  <!-- Custom fonts for this template-->
  <link type="text/css" rel="stylesheet" href="layout/css/all.min.css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

<%--  for custom field--%>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/cupertino/jquery-ui.css">


  <!-- Custom styles for this template-->
  <link type="text/css" rel="stylesheet" href="layout/css/sb-admin-2.css">
  <style>
    #products {
      font-family: Arial, Helvetica, sans-serif;
      border-collapse: collapse;
      width: 100%;
      text-align: center;
    }

    #products td, #products th {
      border: 1px solid #ddd;
      padding: 8px;
    }

    #products tr:nth-child(even){background-color: #f2f2f2;}

    #products tr:hover {background-color: #ddd;}

    #products th {
      padding-top: 12px;
      padding-bottom: 12px;
      background-color: #4e73df;
      color: white;
    }
     .txt{
       word-wrap: break-word;
       resize: none;
     }
  </style>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

  <%@include file="../toInclude/adminSideBar.jsp" %>

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

      <!-- Topbar Code -->
      <%@include file="../toInclude/adminTopBar.jsp"%>

      <!-- Begin Page Content -->
      <div class="container-fluid">

        <%--TODO Make Home points to DashBoard                --%>
        <!-- Breadcramb navigation-->
        <B:BreadCrumb dir="Orders" parentDir="DataTables" fontIcon="fas fa-truck-moving"
                      pageTitle="Orders"/>

        <%--Page Content Goes here--%>
        <div id="jsGrid"></div>

          <div id="detailsDialog">
          <div id="proddata"></div>
          </div>

      </div>
      <!-- /.container-fluid -->


    </div>
    <!-- End of Main Content -->

    <%-- Include footer and styling Scripts --%>
    <%@include file="../toInclude/adminFooter.jsp" %>

  </div>
  <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<%--logout modal that appears when user logs out--%>
<%@include file="../toInclude/logoutModal.jsp" %>


<script type="text/javascript" src="layout/js/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="layout/js/bootstrap.min.js"></script>
<script type="text/javascript" src="layout/js/fontawesome.js"></script>
<script type="text/javascript" src="layout/js/sb-admin-2.js"></script>
<%-- Page custom scritps--%>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="layout/js/jsgrid.min.js"></script>

<script type="text/javascript" src="layout/js/ordersTableManager.js"></script>


</body>

</html>
