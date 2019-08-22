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

        <title>Annonces</title>


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
                    <a class="nav-link" href="secretaire.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>
                
                <li class="nav-item">
                  <a  class="nav-link" href="#" data-toggle="modal" data-target="#addClasse">
                       <i class=" fas fa-plus"></i>
                        <span>Ajouter </span></a>
              
                </li>
                
                
                <li class="nav-item active">
                    <a class="nav-link" href="Annonces.htm">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Lister</span></a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">

                




                    <!-- DataTables Example -->
                  <section id="team" class="pb-5 " style="margin-top: -60px;">
                     

                        <div class="row" style="margin-bottom: -100px; margin-top: 3px;">
                          <c:forEach var="element" items="${evenements}">
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="#"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        
                                        <div class="card-body text-center">
                                            <p>     <span class="ti-blackboard "   style="font-size: 3em;"></span></p>
                                                      <span >    <h5 class="card-title">${element.titre}</h5></span> 
                                            
                                                      <div class="row" style="text-align: left;">
                                         
                                                <div class="col-6 text-muted">Titre :</div>
                                               <div class="col-6">${element.soustitre}</div>
                                       

                                         
                                                <div class="col-6 text-muted">Lieu :</div>
                                            <div class="col-6">${element.lieu}</div>
                                                
                                                  <div class="col-6 text-muted">Description</div>
                                                 <div class="col-6">${element.description}</div>
                                           
                                         
                                                <div class="col-6 text-muted">Debut</div>
                                            <div class="col-6">${element.debut}</div>
                                       
   
                                                <div class="col-6 text-muted">Fin</div>
                                             <div class="col-6">${element.fin}</div>
                                  
                                         
                                          
                                        </div>
                                            
                                            
                                            
                                            
                                            
                                      

                                        </div>
                                       
                                    </div>
                                </div>
                                    </a>


                            </div>
                                  </c:forEach>
                     
                        </div>

                    </section>

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
     
        <div class="modal fade" id="addClasse" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header" >
                        <h5 class="modal-title" id="exampleModalLabel">Ajouter Evenement</h5>
                        <br><br>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">

                        </button>

                    </div>
                    <div id="content-wrapper">

                        <div class="container-fluid">
                            <div class="example col-md-12 ml-auto mr-auto">
                                <div class="row " >
                                    <form method="POST">
                                        <br>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="form-group col-md-6 ">
                                                    <div class="input-group with-addon-icon-left">
                                                        <span class="input-group-addon">
                                                            <i class="ti-tag"></i>
                                                        </span>
                                                        <input type="text"  name="titre" class="form-control " id="titre" placeholder="Titre " required="true">
                                                    </div>
                                                </div>
                                                
                                                
                                                 <div class="form-group col-md-6 ">
                                                    <div class="input-group with-addon-icon-left">
                                                        <span class="input-group-addon">
                                                            <i class="ti-tag"></i>
                                                        </span>
                                                        <input type="text" class="form-control " name="soustitre" id="soustitre" placeholder="Sous Titre " required="true">
                                                    </div>
                                                </div>
                                                
                                                
                                                    <div class="form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <span class="input-group-addon">
                                                            <i class="ti-home"></i>
                                                        </span>
                                                        <input type="text" name="lieu" class="form-control" id="lieu" placeholder="Lieu" required="true">
                                                    </div>
                                                </div>

                                                <div class=" form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <input type="text" class="form-control" name="debut" id="datepicker-example-1" placeholder="Debut" >
                                                        <span class="input-group-addon">
                                                            <i class="ti-calendar"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                                
                                                
                                                     <div class=" form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <input type="text" class="form-control" name="fin" id="datepicker-example-2" placeholder="Fin" >
                                                        <span class="input-group-addon">
                                                            <i class="ti-calendar"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <span class="input-group-addon">
                                                            <i class="ti-info"></i>
                                                        </span>
                                                        <input type="text" class="form-control"  name="description" id="descriptionClasse" placeholder="Description" required="true">
                                                    </div>
                                                </div>




                                                <div class=" form-group col-md-6">       
                                                    <button type="submit" class="btn btn-primary">
                                                        <i class="ti-save">

                                                        </i> Enregistrer</button>
                                                </div>
                                                <div class=" form-group col-md-6">   
                                                    <button type="reset" type="button" data-dismiss="modal" class="btn btn-secondary">
                                                        <i class="ti-trash">

                                                        </i> Annuler</button>
                                                </div>

                                            </div>
                                        </div>


                                    </form>
                                    <br>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
   
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
            .image--cover {
                width: 70px;
                height: 70px;
                border-radius: 50%;
                border: 2px solid #fff;
                margin: 5px;

                object-fit: cover;
                object-position: center right;
            }

        </style>



    </body>

</html>
