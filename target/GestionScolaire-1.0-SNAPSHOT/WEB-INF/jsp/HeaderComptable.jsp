<%-- 
    Document   : Header.jsp
    Created on : 20 nov. 2017, 21:00:12
    Author     : Fallou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
 
    </head>
    <body >

    <nav class="navbar navbar-expand  static-top" style="    height: 12vh;background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);">

        <a class="navbar-brand mr-1" href="Comptable.htm" style="color: #fff; font-family: titilliumWeb-italic;    font-size: 4vh;   letter-spacing: .5rem; " >ISI</a>



         

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">

                    <div class="input-group-append">

                    </div>
                </div>
            </form>

            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">

                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="ti-user" style="font-size:2em; color: #fff"></span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">


                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="index.htm" data-toggle="modal" data-target="#logoutModal">Se deconncter</a>
                    </div>
                </li>
            </ul>

        </nav>
         <style>
            .modal-header{
             background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%
                 ,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);
          
             
            }
         
            .modal-title{
                font-family: dax-bold;    font-size: 1.4rem;
                color: #fff;
            }
            .modal-content{
                margin-top: 100px;
            }
        </style>
    </body>
</html>
