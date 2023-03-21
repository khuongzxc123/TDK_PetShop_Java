<%-- 
    Document   : ManageAccount
    Created on : Mar 16, 2023, 8:09:53 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">

        <!-- =======================================================
        * Template Name: NiceAdmin - v2.5.0
        * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
    </head>
    <body>
        <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="/PetShop/home" class="logo d-flex align-items-center">
        <img src="assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">NiceAdmin</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
      <form class="search-form d-flex align-items-center" method="POST" action="#">
        <input type="text" name="query" placeholder="Search" title="Enter search keyword">
        <button type="submit" title="Search"><i class="bi bi-search"></i></button>
      </form>
    </div><!-- End Search Bar -->

    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">

        <li class="nav-item d-block d-lg-none">
          <a class="nav-link nav-icon search-bar-toggle " href="#">
            <i class="bi bi-search"></i>
          </a>
        </li><!-- End Search Icon-->
            <!-- End Notification Nav -->
            <!-- End Messages Nav -->
            <li class="nav-item dropdown pe-3">
              <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                <img src="${sessionScope.account.userImg}" alt="Profile" class="rounded-circle">
                <span class="d-none d-md-block dropdown-toggle ps-2"></span>
              </a><!-- End Profile Image Icon -->

              <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                            <i class="bi bi-person"></i>
                            <span>Hello ${sessionScope.account.accountName}</span>
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                            <i class="bi bi-person"></i>
                            <span>My Profile</span>
                        </a>
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                            <i class="bi bi-gear"></i>
                            <span>Account Settings</span>
                        </a>
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="logout">
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Sign Out</span>
                        </a>
                    </li>
              </ul><!-- End Profile Dropdown Items -->
            </li><!-- End Profile Nav -->
      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">
        <li class="nav-item">
            <a class="nav-link " href="home">
                <i class="bi bi-grid"></i>
                <span>Home</span>
            </a>
        </li><!-- End Dashboard Nav -->
            <c:if test="${sessionScope.account.roleId == 1}">
                <li class="nav-item">
                    <a class="nav-link " href="product">
                        <i class="bi bi-grid"></i>
                        <span>Manage Product</span>
                    </a>
                </li><!-- End Dashboard Nav -->

                <li class="nav-item">
                    <a class="nav-link " href="#">
                        <i class="bi bi-grid"></i>
                        <span>Manage Account</span>
                    </a>
                </li><!-- End Dashboard Nav -->
            </c:if>
      <!-- End Components Nav -->

      <!-- End Forms Nav -->

      <!-- End Tables Nav -->

      <!-- End Charts Nav -->

      <!-- End Icons Nav -->
      
            <li class="nav-heading">Pages</li>

            <!-- End Profile Page Nav -->

            <!-- End F.A.Q Page Nav -->

            <!-- End Contact Page Nav -->
        <c:if test="${sessionScope.account.userName == null}">
            <li class="nav-item">
              <a class="nav-link collapsed" href="Signup.jsp">
                <i class="bi bi-card-list"></i>
                <span>Register</span>
              </a>
            </li><!-- End Register Page Nav -->
            <li class="nav-item">
              <a class="nav-link collapsed" href="Login.jsp">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Login</span>
              </a>
            </li><!-- End Login Page Nav -->
        </c:if>
      <!-- End Error 404 Page Nav -->

      <!-- End Blank Page Nav -->

    </ul>

  </aside><!-- End Sidebar-->
        <main id="main" class="main">
        <div class="pagetitle">
          <h1>TRANG CHỦ</h1>
          <nav>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="index.html">Home</a></li>
              <li class="breadcrumb-item active">Dashboard</li>
            </ol>
          </nav>
        </div>
        <div class="card">
            <div class="card-body">

            <table class="table table-stripped">
                <thead>
                  <h1>Manage Account</h1>
                  <tr>
                      <th scope="col" >Id</th>
                    <th scope="col" style="text-align: center">UserName</th>
                    <th scope="col" style="text-align: center">Password</th>
                    <th scope="col" style="text-align: center">AccountName</th>
                    <th scope="col" style="text-align: center">UserImg</th>
                  </tr>
                </thead>

                <tbody>
                    <c:forEach var="account" items="${listA}">
                      <tr>
                      <th scope='row' style="text-align: center">${account.userId}</th>
                      
                      <th scope='row' style="text-align: center">${account.userName}</th>
                      <th scope='row' style="text-align: center">${account.pass}</th>
                      <th scope='row' style="text-align: center">${account.accountName}</th>
                      <th scope='row' style="text-align: center"><img src="${account.userImg}" style="width: 100px; height: 100px"></th>
                      
                      </tr>
                    </c:forEach>
                </tbody>
            </table>
            </div>
        </div>
        </main>
    </body>
</html>
