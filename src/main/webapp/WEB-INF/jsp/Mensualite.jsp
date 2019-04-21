<%-- 
    Document   : GererAdmini
    Created on : 25 nov. 2018, 15:10:14
    Author     : Fallou
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin - Tables</title>
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

        <%@include file="HeaderUser.jsp" %> 
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav" >
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Tableau de bord</span>
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

                <div class="container-fluid">


                    <div class="card mb-3 ">
                        <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">

                            <span style="font-family: dax-bold;    font-size: 2rem;">
                                Mensualite


                            </span>  </div>
                        <div class="card-body">

                            <form method="POST">
                                <div class="form-group">
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <div class="input-group with-addon-icon-left">
                                                <span class="input-group-addon">
                                                    <i class="ti-tag"></i>
                                                </span>
                                                <input type="text" class="form-control" name="matricule" id="matricule" placeholder="Matricule de l'etudiant" required="true">
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

                                                <span class="ti-user" style="font-size: 3em;"></span>

                                            </div>
                                            <span style="font-size: 1.5em;font-family: dax-bold;">${findEtudiant.prenom} ${findEtudiant.nom} </span>   

                                        </div>

                                    </div>
                                </div>



                            </div>
                            <div class="card-body">
                                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                    <div class="row">

                                        <div class="col-6 text-muted">Telephone :</div>
                                        <div class="col-6">${findEtudiant.telephone}</div>
                                        <div class="col-6 text-muted">Adresse :</div>
                                        <div class="col-6">${findEtudiant.adresse}</div>





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

                                                <span class="ti-stats-up" style="font-size: 3em;"></span>

                                            </div>
                                            <span style="font-size: 1.5em;font-family: dax-bold;">Historiques </span>   

                                        </div>

                                    </div>
                                </div>



                            </div>
                            <div class="card-body" >
                                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                    <div class="row">

                                        <div class="col-6 text-muted">Telephone :</div>
                                        <div class="col-6">${findEtudiant.telephone}</div>
                                        <div class="col-6 text-muted">Adresse :</div>
                                        <div class="col-6">${findEtudiant.adresse}</div>





                                    </div>
                                </div>

                            </div>
                        </div>
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
                        <a class="btn btn-primary" href="index.htm">Logout</a>
                    </div>
                </div>
            </div>
        </div>


        <div class="modal fade" id="payeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Confirmer le payement?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="col-lg-4 col-md-6 col-sm-12 mb-4" style="    margin-left: 20%;
                             text-align: center;">


                            <span class="ti-user" style="font-size: 3em; text-align: "></span>

                        </div>
                        <h4 class="card-title" style="text-align: center;font-family:titilliumWeb-bold;; color: #1f72b8;">Mat :09162937</h4>
                        <p class="card-text">Nom &  Prenom: Fall Fallou </p>                      
                        <p class="card-text">Filiere & Classe : Gl  Master</p>


                        <p class="card-text" style="font-family: titilliumWeb-semi-bold;">Paye le: 21/08/1993  </p>
                        <p class="card-text" style="font-family: titilliumWeb-semi-bold;">Paye le: 100. 000 F </p>



                    </div>
                    <div class="modal-footer">

                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="Mensualite.htm">Logout</a>
                    </div>
                </div>
            </div>
        </div>



        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="js/sb-admin.min.js"></script>
        <script src="js/bootstrap3-typeahead.js"></script>
        <script>
            var $input = $(".classe");

            $input.typeahead({
                source: [
                    {id: "someId1", name: "jQueryScript.Net"},
                    {id: "someId2", name: "Angular Components"},
                    {id: "someId3", name: "React Components"},
                    {id: "someId4", name: "Vue.js Components"},
                    {id: "someId5", name: "Native JavaScript"},
                    {id: "someId6", name: "jQuery Plugins"},
                    {id: "someId7", name: "Vanilla JavaScript"}
                ],
                autoSelect: true
            });
            $input.change(function () {
                var current = $input.typeahead("getActive");
                if (current) {

                    if (current.name == $input.val()) {
                        console.log(current['name']);

                    } else {
                        // This means it is only a partial match, you can either add a new item
                        // or take the active if you don't want new items
                    }
                } else {
                    // Nothing is active so it is a new value (or maybe empty value)
                }
            });
        </script>

        <script>
            var $input = $(".filiere");

            $input.typeahead({
                source: [
                    {id: "someId1", name: "jQueryScript.Net"},
                    {id: "someId2", name: "Angular Components"},
                    {id: "someId3", name: "React Components"},
                    {id: "someId4", name: "Vue.js Components"},
                    {id: "someId5", name: "Native JavaScript"},
                    {id: "someId6", name: "jQuery Plugins"},
                    {id: "someId7", name: "Vanilla JavaScript"}
                ],
                autoSelect: true
            });
            $input.change(function () {
                var current = $input.typeahead("getActive");
                if (current) {

                    if (current.name == $input.val()) {

                    } else {
                        // This means it is only a partial match, you can either add a new item
                        // or take the active if you don't want new items
                    }
                } else {
                    // Nothing is active so it is a new value (or maybe empty value)
                }
            });
        </script>

        <script>
            $("#datepicker-example-1").datepicker({

                format: "MM",
                viewMode: "months",
                minViewMode: "months"
            });
        </script>
    </body>

</html>
