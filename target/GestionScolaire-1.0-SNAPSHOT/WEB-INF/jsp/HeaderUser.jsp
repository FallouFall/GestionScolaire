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

    </head>
    <body >
           <%
String userName = null;
Cookie[] cookies = request.getCookies();

if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
      
}
}
if(userName == null) response.sendRedirect("index.htm");
%>

        <nav class="navbar navbar-expand  static-top" style="    height: 12vh;background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);">

            <a class="navbar-brand mr-1" href="administration.htm" style="color: #fff; font-family: titilliumWeb-italic;    font-size: 4vh;   letter-spacing: .5rem; " >ISI</a>
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
                        <span  >
                               <img alt="" class="image--cover" src="data:image/jpeg;base64,${photo} " width="54">
                        </span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">

                        <a class="dropdown-item"  href="#" data-toggle="modal">
                               <span class="ti-user"> </span>
                               <c:forEach var="img" items="${user}">
                                     ${img}
                               </c:forEach>
                            

                        
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="index.htm" data-toggle="modal" data-target="#logoutModal">
                            <span class="ti-direction"> </span>
                            Se deconncter
                        </a>
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
            .dropdown:hover>.dropdown-menu {
  display: block;
}
.navbar-expand .navbar-nav .dropdown-menu {
    position: absolute;
    margin-top: -10px;
}
        </style>
    </body>
</html>
