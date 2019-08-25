<%-- 
    Document   : GererAdmini
    Created on : 25 nov. 2018, 15:10:14
    Author     : Fallou
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Inscription Etudiant</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/themify-icons.css" rel="stylesheet">
        <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link rel="shortcut icon" href="images/webIcone.jpg"/>
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="css/shards.min.css">
        <link rel="stylesheet" href="css/shards-demo.css?v=1.1.0">
        <link rel="stylesheet" href="./css/cardeffects.css">

    </head>

    <body id="page-top" >

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
                    <a class="nav-link" href="#">
                        <i class="fas fa-plus"></i>
                        <span>Ajouter </span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ListeInscription.htm">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Tables</span></a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid" style="    margin-top: -40px;">
                    <ol class="breadcrumb" style="font-family: dax-bold;
                        box-shadow: 0 0.46875rem 2.1875rem rgba(90,97,105,.1), 0 0.9375rem 1.40625rem rgba(90,97,105,.1), 0 0.25rem 0.53125rem rgba(90,97,105,.12), 0 0.125rem 0.1875rem rgba(90,97,105,.1);
                        background-color: #fff;border-radius: 10px;color: #1f72b8; margin-top: 40px;
                        ">
                        <li class="breadcrumb-item">
                            <span>Annee : ${annee}  <span class="ti-arrow-right" style="color: #5a6169;"> </span> Etudiant : ${matriculeEtu} <span class="ti-arrow-right" style="color: #5a6169;"> </span>  Domaine : ${dmn}</span>
                        </li>

                    </ol>

                    <div id="cards" class="container mb-2 " style="padding-bottom: 1px  ">


                        <div class="example col-md-12 ml-auto mr-auto">

                            <div class="row "  >


                                <section id="team" class="pb-5 " style="margin-top: -30px;">
                                    <div class="row" style="margin-bottom: -100px; margin-top: 3px;">
                                        <c:forEach var="element" items="${formations}">
                                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                                <c:url var="link" value="cycleInscription.htm">
                                                    <c:param name="annee" value="${annee}"/>
                                                    <c:param name="domaine" value="${domaine}"/>
                                                    <c:param name="formation" value="${element.id}"/>
                                                    <c:param name="frn" value="${element.nom}"/>

                                                </c:url>
                                                <a href="${link}"  style="   text-decoration: none; color: #5a6169;">
                                                    <div class="frontside">
                                                        <div class="card ">

                                                            <div class="card-body text-center">


                                                                <p>     <span class="ti-desktop"   style="font-size: 3em;"></span></p>



                                                                <span >    <h5 class="card-title"> ${element.nom}</h5></span> 

                                                                <div class="row" style="text-align: left;">

                                                                    <div class="col-6 text-muted">Matricule :</div>
                                                                    <div class="col-6">${element.matricule}</div>



                                                                    <div class="col-6 text-muted">Nom :</div>
                                                                    <div class="col-6">${element.nom}</div>

                                                                    <div class="col-6 text-muted"></div>
                                                                    <div class="col-6"></div>
                                                                    <div class="col-6 text-muted"></div>
                                                                    <div class="col-6"></div>
                                                                    <div class="col-6 text-muted"></div>
                                                                    <div class="col-6"></div>
                                                                    <div class="col-6 text-muted"></div>
                                                                    <div class="col-6"></div>
                                                                    <div class="col-6 text-muted"></div>
                                                                    <div class="col-6"></div>
                                                                    <div class="col-6 text-muted"></div>
                                                                    <div class="col-6"></div>
                                                                    <div class="col-6 text-muted"></div>
                                                                    <div class="col-6"></div>

                                                                    <div class="col-6 text-muted"></div>
                                                                    <div class="col-6"></div>
                                                                    <div class="col-6 text-muted"></div>
                                                                    <div class="col-6"></div>
                                                                    <div class="col-6 text-muted"></div>
                                                                    <div class="col-6"></div>


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
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->


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

                <button type="submit" class="btn btn-primary" style="background-color: #0272bd;">     <a href="index.htm"  style="   text-decoration: none;  color: #fff;">Deconnceter</a></button>

            </div>
        </div>
    </div>
</div>


<script src="vendor/jquery/jquery.min.js"></script>
<script src="./js/bootstrap.min.js" ></script>
<script src="js/demo.min.js"></script>
<script src="js/shards.min.js"></script>
<script src="js/sb-admin.min.js"></script>
<script src="js/bootstrap3-typeahead.js"></script>








</body>

</html>
