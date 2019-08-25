<%-- 
    Document   : GererAdmini
    Created on : 25 nov. 2018, 15:10:14
    Author     : Fallou
--%>



<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html" import="java.util.*" %>
<!DOCTYPE html>
<html lang="fr">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Bibliotheque</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/themify-icons.css" rel="stylesheet">

        <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="css/shards.min.css">
        <link rel="stylesheet" href="css/shards-demo.css?v=1.1.0">
        <link rel="stylesheet" href="./css/cardeffects.css">

    </head>

    <body id="page-top" >
        <%
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String date = sdf.format(new Date());
            int dateFin = Integer.parseInt(date.substring(6)) + 1;
            String dateFinal = date.substring(0, 6) + "" + dateFin;
        %>
        <%@include file="HeaderUser.jsp" %> 
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav" >


                <li class="nav-item" style="margin-top: 20px;">
                    <a class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">

                        <i class="fas fa-bars">    </i>

                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="comptable.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="bibliotheque.htm">
                        <i class="fas fa-plus"></i>
                        <span>Ajouter </span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="abonnementListe.htm">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Abonnes</span></a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">


                    <div class="card mb-3 ">
                        <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">

                            <span style="font-family: dax-bold;    font-size: 2rem;">
                                Inscription Bibliotheque


                            </span>  </div>
                        <div class="card-body">

                            <form method="GET">
                                <div class="form-group">
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <div class="input-group with-addon-icon-left">
                                                <span class="input-group-addon">
                                                    <i class="ti-tag"></i>
                                                </span>
                                                <input type="text" class="form-control" name="matricule" id="matricule" placeholder="Numero  Etudiant" required="true">
                                            </div>
                                        </div>
                                        <div class=" form-group col-md-6">       
                                            <button type="submit" class="btn btn-primary">
                                                <i class="ti-search">

                                                </i> Chercher</button>
                                        </div>


                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <c:if test="${findEtudiant!= null}">


                        <div class="card  " style="width: 48%;float: left;" >
                            <div class="card-header" style="text-align: center;background-color: #fff;">

                                <div class="ibox-body">
                                    <div class="flexbox" style="text-align: center;">
                                        <div class="flexbox-b">
                                            <div class="ml-5 mr-5">

                                                <span class="ti-user" style="font-size: 3em;color: #1f72b8 ;"></span>

                                            </div>
                                            <span style="font-size: 1.5em;font-family: dax-bold;color: #1f72b8 ;">${findEtudiant.prenom} ${findEtudiant.nom} </span>   

                                        </div>

                                    </div>
                                </div>



                            </div>
                            <div class="card-body">
                                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                    <div class="row">

                                        <div class="col-6 text-muted">Classe :</div>
                                        <div class="col-6">${cls}</div>
                                        <div class="col-6 text-muted">Filiere :</div>
                                        <div class="col-6">${fil}</div>





                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="card  " style="width: 48%;float: right;">
                            <div class="card-header" style="text-align: center;background-color: #fff;">

                                <div class="ibox-body">
                                    <div class="flexbox" style="text-align: center;">
                                        <div class="flexbox-b">
                                            <div class="ml-5 mr-5">

                                                <span class="ti-location-pin" style="font-size: 3em; color: #1f72b8 ;"></span>

                                            </div>
                                            <span style="font-size: 1.5em;font-family: dax-bold;color: #1f72b8 ;">Details </span>   

                                        </div>

                                    </div>
                                </div>



                            </div>
                            <div class="card-body" >
                                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                    <div class="row">

                                        <div class="col-6 text-muted">Classe:</div>
                                        <div class="col-6">${findEtudiant.telephone}</div>
                                        <div class="col-6 text-muted">Adresse :</div>
                                        <div class="col-6">${findEtudiant.adresse}</div>





                                    </div>
                                </div>

                            </div>
                        </div>
                        <form method="POST">
                            <input type="text" value="${id}"  name="idet" hidden="">
                            <input type="text" value=" <%= date%>" name="debut" hidden="">
                            <input type="text" value=" <%= dateFinal%>" name="fin" hidden="">


                            <div class="card  " style="width: 48%;float: left; margin-top:30px;">

                                <div class="card-body" >
                                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                                        <div class="row">

                                            <div class="col-6 text-muted">Date Abonnement :</div>
                                            <div class="col-6"> <%= date%></div>
                                            <div class="col-6 text-muted">Fin Abonnement  :</div>
                                            <div class="col-6">  <%= dateFinal%></div>
                                            <div class="col-6 text-muted">A payer:</div>
                                            <div class="col-6" style="    font-family: dax-bold; font-size: 1.5em;
                                                 color: #1f72b8;">${mensu/2} Fcfa</div>
                                        </div>

                                    </div>

                                </div>
                            </div>
                            <div class="card  " style="width: 48%;float: right; margin-top:30px;">

                                <div class="card-body" >
                                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                                        <div class="row">


                                            <div class="col-6 text-muted">Valider :</div>
                                            <div class="col-6">  <button type="submit" class="btn btn-primary">
                                                    <i class="ti-stamp">

                                                    </i> Payer</button></div>
                                        </div>

                                    </div>

                                </div>
                            </div>
                        </form>

                    </c:if>

                    <c:if test="${findEtudiant== null}">



                    </c:if>
                </div>
                <!-- /.container-fluid -->



            </div>
            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="ti-angle-up"></i>
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
                    <div class="modal-body" style=" font-family: titilliumWeb-regular;">Voulez-Vous quitter ?</div>
                    <div class="modal-footer">

                        <button class="btn btn-secondary" type="button" data-dismiss="modal" style=" font-family: titilliumWeb-regular;">
                            <div class="form-label-group">
                                <a class="ti-close" >  Annuler</a> 
                            </div>
                        </button>


                        <button type="submit" class="btn btn-primary" style="background-color: #0272bd; font-family: titilliumWeb-regular;">
                            <div class="form-label-group">
                                <a class="ti-power-off" style="background-color: #0272bd; color: #fff;" href="deconnecter.htm">  Deconnceter</a> 
                            </div></button>


                    </div>
                </div>
            </div>
        </div>


        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js" ></script>
        <script src="js/demo.min.js"></script>
        <script src="js/shards.min.js"></script>
        <script src="js/sb-admin.min.js"></script>





        <script>
            $("#datepicker-example-1").datepicker({

                format: "MM",
                viewMode: "months",
                minViewMode: "months"


            });
        </script>
        <style>
            .avatar-pic {
                width: 150px;
            }
            .col-6{
                font-family:  titilliumWeb-regular;
            }
            .form-control{
                font-family: titilliumWeb-regular;
            }
            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none; 
                margin: 0; 
            }

        </style>

</html>
</body>
