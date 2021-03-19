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
  <link type="text/css" rel="stylesheet" href="layout/css/jsgrid.min.css" />
  <link type="text/css" rel="stylesheet" href="layout/css/jsgrid-theme.min.css" />
  <!-- Custom fonts for this template-->
  <link type="text/css" rel="stylesheet" href="layout/css/all.min.css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link type="text/css" rel="stylesheet" href="layout/css/sb-admin-2.css" >

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

  <!-- Sidebar -->
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
      <div class="sidebar-brand-icon rotate-n-15">
        <i class="fas fa-paw"></i>
      </div>
      <div class="sidebar-brand-text mx-3">PeTopia</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item">
      <a class="nav-link" href="#">
        <i class="fas fa-fw fa-tachometer-alt"></i>
        <span>Dashboard</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
      Products
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseProducts" aria-expanded="true" aria-controls="collapseProducts">
        <i class="fas fa-cat"></i>
        <span>Products</span>
      </a>
      <div id="collapseProducts" class="collapse" aria-labelledby="headingProducts" data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
          <h6 class="collapse-header">Animals:</h6>
          <a class="collapse-item" href="#">Animals</a>

          <h6 class="collapse-header">Supplies:</h6>
          <a class="collapse-item" href="#">Food</a>
          <a class="collapse-item" href="#">Treats</a>
          <a class="collapse-item" href="#">Supplies</a>
        </div>
      </div>
    </li>

    <!-- Nav Item - Services Collapse Menu -->
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseServices" aria-expanded="true" aria-controls="collapseServices">
        <i class="fas fa-concierge-bell"></i>
        <span>Services</span>
      </a>
      <div id="collapseServices" class="collapse" aria-labelledby="headingServices" data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
          <h6 class="collapse-header">Custom Services:</h6>
          <a class="collapse-item" href="#">Transportation</a>
          <a class="collapse-item" href="#">Shelter finder</a>
          <a class="collapse-item" href="#">Housing</a>
          <a class="collapse-item" href="#">Aquarium</a>
          <a class="collapse-item" href="#">Grooming</a>
          <a class="collapse-item" href="#">Training</a>
        </div>
      </div>
    </li>

    <!-- Nav Item - Orders Collapse Menu -->
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOrders" aria-expanded="true" aria-controls="collapseOrders">
        <i class="fas fa-truck-moving"></i>
        <span>Orders</span>
      </a>
      <div id="collapseOrders" class="collapse" aria-labelledby="headingOrders" data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
          <h6 class="collapse-header">Orders</h6>
          <a class="collapse-item" href="#">Pending Orders</a>
          <a class="collapse-item" href="#">Done Orders</a>

        </div>
      </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
      Users
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item active">
      <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapseUsers" aria-expanded="true" aria-controls="collapseUsers">
        <i class="fas fa-user"></i>
        <span>Users</span>
      </a>
      <div id="collapseUsers" class="collapse show" aria-labelledby="headingUsers" data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
          <h6 class="collapse-header">Login Screens:</h6>
          <a class="collapse-item" href="#">Registed Users</a>
          <a class="collapse-item" href="#">Pending Users</a>

        </div>
      </div>
    </li>



    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
      <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

  </ul>
  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

      <!-- Topbar -->
      <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
          <i class="fa fa-bars"></i>
        </button>

        <!-- Topbar Search -->
        <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
          <div class="input-group">
            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
            <div class="input-group-append">
              <button class="btn btn-primary" type="button">
                <i class="fas fa-search fa-sm"></i>
              </button>
            </div>
          </div>
        </form>

        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">

          <!-- Nav Item - Search Dropdown (Visible Only XS) -->
          <li class="nav-item dropdown no-arrow d-sm-none">
            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-search fa-fw"></i>
            </a>
            <!-- Dropdown - Messages -->
            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
              <form class="form-inline mr-auto w-100 navbar-search">
                <div class="input-group">
                  <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                  <div class="input-group-append">
                    <button class="btn btn-primary" type="button">
                      <i class="fas fa-search fa-sm"></i>
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </li>

          <!-- Nav Item - Alerts -->
          <li class="nav-item dropdown no-arrow mx-1">
            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-bell fa-fw"></i>
              <!-- Counter - Alerts -->
              <span class="badge badge-danger badge-counter">3+</span>
            </a>
            <!-- Dropdown - Alerts -->
            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
              <h6 class="dropdown-header">
                Alerts Center
              </h6>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="mr-3">
                  <div class="icon-circle bg-primary">
                    <i class="fas fa-file-alt text-white"></i>
                  </div>
                </div>
                <div>
                  <div class="small text-gray-500">December 12, 2019</div>
                  <span class="font-weight-bold">A new monthly report is ready to download!</span>
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="mr-3">
                  <div class="icon-circle bg-success">
                    <i class="fas fa-donate text-white"></i>
                  </div>
                </div>
                <div>
                  <div class="small text-gray-500">December 7, 2019</div>
                  $290.29 has been deposited into your account!
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="mr-3">
                  <div class="icon-circle bg-warning">
                    <i class="fas fa-exclamation-triangle text-white"></i>
                  </div>
                </div>
                <div>
                  <div class="small text-gray-500">December 2, 2019</div>
                  Spending Alert: We've noticed unusually high spending for your account.
                </div>
              </a>
              <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
            </div>
          </li>

          <!-- Nav Item - Messages -->
          <li class="nav-item dropdown no-arrow mx-1">
            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-envelope fa-fw"></i>
              <!-- Counter - Messages -->
              <span class="badge badge-danger badge-counter">7</span>
            </a>
            <!-- Dropdown - Messages -->
            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
              <h6 class="dropdown-header">
                Message Center
              </h6>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                  <img class="rounded-circle" src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt="">
                  <div class="status-indicator bg-success"></div>
                </div>
                <div class="font-weight-bold">
                  <div class="text-truncate">Hi there! I am wondering if you can help me with a problem I've been having.</div>
                  <div class="small text-gray-500">Emily Fowler · 58m</div>
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                  <img class="rounded-circle" src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt="">
                  <div class="status-indicator"></div>
                </div>
                <div>
                  <div class="text-truncate">I have the photos that you ordered last month, how would you like them sent to you?</div>
                  <div class="small text-gray-500">Jae Chun · 1d</div>
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                  <img class="rounded-circle" src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
                  <div class="status-indicator bg-warning"></div>
                </div>
                <div>
                  <div class="text-truncate">Last month's report looks great, I am very happy with the progress so far, keep up the good work!</div>
                  <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                  <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
                  <div class="status-indicator bg-success"></div>
                </div>
                <div>
                  <div class="text-truncate">Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</div>
                  <div class="small text-gray-500">Chicken the Dog · 2w</div>
                </div>
              </a>
              <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
            </div>
          </li>

          <div class="topbar-divider d-none d-sm-block"></div>

          <!-- Nav Item - User Information -->
          <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="mr-2 d-none d-lg-inline text-gray-600 small">Ahmed El Sayed</span>
              <img class="img-profile rounded-circle" src="layout/images/img_avatar.png">
            </a>
            <!-- Dropdown - User Information -->
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
              <a class="dropdown-item" href="#">
                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                Profile
              </a>
              <a class="dropdown-item" href="#">
                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                Settings
              </a>
              <a class="dropdown-item" href="#">
                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                Activity Log
              </a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                Logout
              </a>
            </div>
          </li>

        </ul>

      </nav>
      <!-- End of Topbar -->

      <!-- Begin Page Content -->
      <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
          <h1 class="h3 mb-0 text-gray-800"><i class="fas fa-fw fa-tshirt"></i> Products</h1>
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item " aria-current="page">Data Tables</li>
            <li class="breadcrumb-item active" aria-current="page">Products Data</li>
          </ol>

        </div>

        <div id="jsGrid"></div>

      </div>
      <!-- /.container-fluid -->


    </div>
    <!-- End of Main Content -->

    <!-- Footer -->
    <footer class="sticky-footer bg-white">
      <div class="container my-auto">
        <div class="copyright text-center my-auto">
          <span>Copyright &copy; Your Website 2019</span>
        </div>
      </div>
    </footer>
    <!-- End of Footer -->
  </div>
  <!-- End of Content Wrapper -->


</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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



<script type="text/javascript" src="layout/js/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="layout/js/bootstrap.min.js"></script>
<script type="text/javascript" src="layout/js/fontawesome.js"></script>
<script type="text/javascript" src="layout/js/sb-admin-2.js"></script>
<script type="text/javascript" src="layout/js/jsgrid.min.js"></script>
<script>
  var Products = [
    { "ProductID": 1, "Name": "shoes", "Quantity": 1, "Size": 1, "Category": 2,"Price": 25,"img":"layout/images/men.jpg"  },
    { "ProductID": 2, "Name": "Tshirt", "Quantity": 1, "Size": 1, "Category": 1,"Price": 25,"img":"layout/images/men.jpg"  },
    { "ProductID": 3, "Name": "Chemese", "Quantity": 1, "Size": 1, "Category": 3,"Price": 25,"img":"layout/images/men.jpg"  },
    { "ProductID": 4, "Name": "Shirt", "Quantity": 1, "Size": 1, "Category": 1,"Price": 25,"img":"layout/images/men.jpg"  },
    { "ProductID": 5, "Name": "Socks", "Quantity": 1, "Size": 1, "Category": 2,"Price": 25,"img":"layout/images/men.jpg"  },
    { "ProductID": 6, "Name": "Pants", "Quantity": 1, "Size": 1, "Category": 3,"Price": 25,"img":"layout/images/men.jpg"  },

  ];

  var Sizes = [
    { Name: "", Id: 0 },
    { Name: "Small", Id: 1 },
    { Name: "Medium", Id: 2 },
    { Name: "Large", Id: 3 }
  ];
  var Categories = [
    { Name: "", Id: 0 },
    { Name: "Men", Id: 1 },
    { Name: "Women", Id: 2 },
    { Name: "Children", Id: 3 }
  ];

  $("#jsGrid").jsGrid({
    height: "70%",
    width: "100%",
    filtering: true,
    editing: true,
    inserting: true,
    sorting: true,
    paging: true,
    autoload: true,
    pageSize: 15,
    pageButtonCount: 5,
    deleteConfirm: "Do you really want to delete the client?",
    controller: {
      // loadData: function (filter) {
      //   return $.ajax({
      //     type: "GET",
      //     url: "/JsGridEx/ManageCars",
      //     data: filter
      //   });
      // },
      loadData: function(filter) {
        return $.grep(Products, function(prod) {
          return (!filter.Name || prod.Name.indexOf(filter.Name) > -1)
                  && (filter.ProductID === undefined || prod.ProductID === filter.ProductID)
                  && (filter.Quantity === undefined || prod.Quantity === filter.Quantity)
                  && (filter.Size === undefined || prod.Size === filter.Size)
                  && (filter.Category === undefined || prod.Category === filter.Category)
                  && (filter.Price === undefined || prod.Price === filter.Price);
        });
      },

      // insertItem: function (item) {
      //   return $.ajax({
      //     type: "POST",
      //     url: "/JsGridEx/ManageCars",
      //     data: item
      //   });
      // },
      // updateItem: function (item) {
      //   return $.ajax({
      //     type: "PUT",
      //     url: "/JsGridEx/ManageCars",
      //     data: item
      //   });
      // },
      // deleteItem: function (item) {
      //   return $.ajax({
      //     type: "DELETE",
      //     url: "/JsGridEx/ManageCars",
      //     data: item
      //   });
      // }

      insertItem: function(insertingProd) {
        Products.push(insertingProd);
      },

      updateItem: function(updatingProd) { },

      deleteItem: function(deletingProd) {
        var prodIndex = $.inArray(deletingProd, Products);
        Products.splice(prodIndex, 1);
      }

    },

    fields: [
      {
        name: "ProductID",
        type: "number",
        editing: false,
        validate: {
          validator: "min",
          message: "Product ID must be above 0",
          param: 0
        }
      },
      { name: "Name", type: "text", width: 150, validate: "required" },
      {
        name: "Quantity",
        type: "number",
        validate: {
          validator: "min",
          message: "Quantity must be above 0",
          param: 0
        }
      },
      { name: "Size", type: "select", items: Sizes, valueField: "Id", textField: "Name" },
      { name: "Category", type: "select", items: Categories, valueField: "Id", textField: "Name" },
      {
        name: "Price",
        type: "number",
        validate: {
          validator: "min",
          message: "Price must be above 0",
          param: 0
        }
      },
      {
        name: "Img",
        itemTemplate: function(val, item) {
          return $("<img>").attr("src", val).css({ height: 50, width: 50 });
        },
        insertTemplate: function() {
          var insertControl = this.insertControl = $("<input>").prop("type", "file");
          return insertControl;
        },
        insertValue: function() {
          return this.insertControl[0].files[0];
        },
        align: "center",
        width: 120
      },
      { type: "control" }
    ]
  });
</script>
</body>

</html>
