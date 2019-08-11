<%-- 
    Document   : GererAdmini
    Created on : 25 nov. 2018, 15:10:14
    Author     : Fallou
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Gestion des Administrateurs</title>


        <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/webIcone.jpg"/>
        <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link rel="stylesheet" href="css/shards.min.css">
        <link rel="stylesheet" href="css/shards-demo.css?v=1.1.0">
        <link rel="stylesheet" href="css/cardeffects.css">
        <link rel="stylesheet" href="./css/themify-icons.css">






    </head>

    <body id="page-top">
        <%
            String userName = null;
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        userName = cookie.getValue();
                    }

                }
            }
            if (userName == null) {
                response.sendRedirect("index.htm");
            }
        %>


        <%@include  file="HeaderUser.jsp" %>


        <div id="wrapper">

            <!-- Sidebar -->

            <ul class="sidebar navbar-nav" >




                <li class="nav-item" >
                    <a class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">

                        <i class="fas fa-bars">    </i>

                    </a>
                </li>


                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Tableau de bord</span>
                    </a>
                </li>


                <li class="nav-item">
                    <a class="nav-link" href="professeur.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>
           
                <li class="nav-item active">
                    <a class="nav-link" href="documents.htm">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Categories</span></a>
                </li>
                
                
                 <li class="nav-item active">
                    <a class="nav-link" href="AjouterDocuments.htm">
                        <i class="fas fa-fw fa-plus"></i>
                        <span>Ajouter</span></a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">

 




                    <!-- DataTables Example -->
                    <div class="card mb-3  ">
                        <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">

                            <span style="font-family: dax-bold;    font-size: 2rem;">
                                Documents Mathematiques


                            </span>  </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" >
                                    <thead>
                                        <tr  style="text-align: center;vertical-align: middle;">
                                          <th></th>
                                            <th>Matricule</th>
                                            <th>Publue</th>
                                            <th>nom</th>
                                            <th>Date</th>
                                            <th>Telecharger</th>
                                   

                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr style="text-align: center;vertical-align: middle;">
                                            <th></th>
                                           <th>Matricule</th>
                                            <th>Publue</th>
                                            <th>nom</th>
                                            <th>Date</th>
                                            <th>Telecharger</th>
                                   



                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        
                                        <c:forEach var="element" items="${documents}">

                                            <tr style="text-align: center;vertical-align: middle;">

                                                <td> 
                                                    <c:if test="${element.cover != null}">
                                                        <img alt="" class="image-cover" style="" src="data:image/jpeg;base64,${element.cover} " width="24">
                                                    </c:if>
                                                          
                                                    <c:if test="${element.cover == null}">
                                                        <span class="ti-book" style="font-size: 0.5em; color: #1f72b8;"></span>
                                                    </c:if>
                                                   

                                                </td>
                                                <td>${element.matricule}</td>
                                                <td>${element.publue}</td>
                                                <td>${element.nom}</td>
                                                <td>${element.date}</td>
                                            
                                                <td> <a class="ti-download" href="update"></a> </td>



                                            </tr>

                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>


                </div>
                <!-- /.container-fluid -->



            </div>
            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

      <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Se Deconnecter?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Voulez-Vous quitter ?</div>
                    <div class="modal-footer">
                  
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Annuler</button>

                            <button type="submit" class="btn btn-primary" style="background-color: #0272bd;">     <a href="deconnecter.htm"  style="   text-decoration: none;  color: #fff;">Deconnceter</a></button>
                    
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->






        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js" ></script>
        <script src="js/demo.min.js"></script>
        <script src="js/shards.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="vendor/datatables/jquery.dataTables.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
        <script src="js/sb-admin.min.js"></script>
        <script src="js/demo/datatables-demo.js"></script>

        <style>
            .image-cover {
               width: 50px;
    height: 50px;

            }

        </style>



    </body>

</html>
