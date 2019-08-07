<%-- 
    Document   : Header.jsp
    Created on : 20 nov. 2017, 21:00:12
    Author     : Fallou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/shards.min.css">
        <link rel="shortcut icon" href="images/webIcone.jpg"/>
        <link rel="stylesheet" href="./css/cardeffects.css">
        <link href="css/sb-admin.css" rel="stylesheet">


    </head>
    <body >

        <div class="navig">
            <nav class="navbar navbar-expand  static-top" style=" 
                 box-shadow: 0 0.46875rem 2.1875rem rgba(90,97,105,.1), 0 0.9375rem 1.40625rem rgba(90,97,105,.1), 0 0.25rem 0.53125rem rgba(90,97,105,.12), 0 0.125rem 0.1875rem rgba(90,97,105,.1);
                 height: 12vh;background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);">

                <a class="navbar-brand mr-1" href="#" style="color: #fff; font-family: titilliumWeb-italic;    font-size: 4vh;   letter-spacing: .5rem; " >GSP</a>
                <!-- Navbar Search -->
                <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                    <div class="input-group">

                        <div class="input-group-append">

                        </div>
                    </div>
                </form>

                <!-- Navbar -->
                <ul class="navbar-nav ml-auto ml-md-0">

                    <li class=" dropdown"  >
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown"  role="button"  data-toggle="dropdown" >
                            <c:if test="${photo != null}">
                                <span >
                                    <img alt="" class="image--cover" src="data:image/jpeg;base64,${photo} " width="54">
                                </span>
                            </c:if>

                            <c:if test="${photo == null}">
                                <span class="ti-user" style="font-size: 2.8em;color: #fff;"></span>
                            </c:if>



                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">

                            <a class="dropdown-item"  href="#" data-toggle="modal" style="font-family: titilliumWeb-light;"> 
                                <span class="ti-user"> </span>
                                <c:forEach var="img" items="${user}">
                                    ${img}
                                </c:forEach>



                            </a>
                            <div class="dropdown-divider"></div>
                            <form >
                                <a class="dropdown-item" href="profil.htm" style="font-family: titilliumWeb-light;">
                                    <span class="ti-star" > </span>
                                    Mon Profil
                                </a>
                                <a class="dropdown-item" style="font-family: titilliumWeb-light;
                                   "href="headerUser.htm" data-toggle="modal" data-target="#logoutModal">
                                    <span class="ti-power-off" style="color: red; "> </span>
                                    Se deconncter
                                </a>
                            </form>
                        </div>
                    </li>
                </ul>

            </nav>
        </div>
        <style>



            .modal-header{
                background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%
                    ,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);
                height: 50px;


            }
            .sidebar{
                margin-top: 17px;
                border-radius: 0px  0.625rem 0px 0px;
                font-family: titilliumWeb-regular;
                 color: #fff;
            }
  
            .sidebar .nav-item :hover{
                background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);
                color: #fff;
            }
      .sidebar         .dropdown-menu {
                background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);
                color: #fff;
            }
           .sidebar .nav-item .nav-link {
    color: rgba(255, 255, 255, 0.6);
}
           
         
            .table-responsive {
                font-family: dax;

            }
            table.table-bordered.dataTable tbody th, table.table-bordered.dataTable tbody td {

                font-family: titilliumWeb-regular;
            }
            .modal-title{
                font-family: dax-bold;    font-size: 1.4rem;
                color: #fff;
            }
            .modal-content{
                margin-top: 100px;
            }
            .dropdown:hover>.dropdown-menu {
                display: block;
            }
            .navbar-expand .navbar-nav .dropdown-menu {
                position: absolute;
                margin-top: -10px;
            }
            .image--cover {
                width: 70px;
                height: 70px;
                border-radius: 50%;
                border: 2px solid #fff;
                margin: 5px;

                object-fit: cover;
                object-position: center right;
            }
            .dropdown-item:hover
            {
                color: #fff;
                background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);
            }




        </style>



    </body>
</html>
