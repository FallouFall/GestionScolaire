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

        <title>Ajouter Cycles</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/themify-icons.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/webIcone.jpg"/>

        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="css/shards.min.css">
        <link rel="stylesheet" href="css/shards-demo.css?v=1.1.0">
        <link rel="stylesheet" href="./css/cardeffects.css">
        <link rel="stylesheet"  type="text/css" href="./css/police.css" >

    </head>

    <body id="page-top" >
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
                    <a class="nav-link" href="directeur.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>


                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Gerer Domaines</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">

                        <a  class="dropdown-item" href="ajouterDomaines.htm">Ajouter Domaine</a>
                        <a class="dropdown-item" href="gererdomaines.htm">Liste Domaines</a>


                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Gerer Cycles</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">

                        <a  class="dropdown-item" href="ajouterCycles.htm">Ajouter Cycle</a>
                        <a class="dropdown-item" href="gerercycles.htm">Liste Cycle</a>


                    </div>
                </li>



            </ul>


            <div id="content-wrapper">

                <div class="container-fluid">


                    <div id="cards" class="container mb-2 " style="padding-bottom: 1px  ;margin-top: -45px;">


                        <div class="example col-md-12 ml-auto mr-auto">
                            <div class="row " >

                                <div class="card card-signin mx-auto mt-5">
                                    <div class="card-header" style="text-align: center;background-color: #fff;color:#1f72b8;">

                                        <span style="font-family: dax-bold;    font-size: 2rem;">
                                            Confirmer Classe  ${nomFiliere} ?


                                        </span>  </div>
                                    <div class="card-body">


                                        <div class="form-group">
                                            <div class="row">

                                                <div class="col-6 " style="color: #1f72b8;font-family: dax;">Matricule :</div>
                                                <div class=" form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <input type="text" class="form-control" id="mat" placeholder="Matricule"  required="true" value="${matricule}" name="matricule">
                                                        <span class="input-group-addon">
                                                            <i class="ti-tag"></i>
                                                        </span>
                                                    </div>
                                                </div>



                                                <div class="col-6 ">Nom :</div>
                                                <div class="col-6">${nom}</div>

                                                <div class="col-6 ">Description :</div>
                                                <div class="col-6">${description}</div>


                                                <div class="col-6">Date :</div>
                                                <div class="col-6">${date}</div>

                                          




                                            </div>


                                            <div class="form-row">




                                                <div class="form-group col-md-6 ">
                                                    <div class="input-group with-addon-icon-left">

                                                        <input type="text" class="form-control " disabled="" required="true" value="${nom}" hidden="">
                                                    </div>
                                                </div>

                                                <div class=" form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <input type="text" class="form-control" id="datepicker-example-1" placeholder="Date de Creation" disabled="" required="true" value="${date}" hidden="">

                                                    </div>
                                                </div>

                                                <div class="form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">

                                                        <input type="text" class="form-control" id="descriptionClasse" placeholder="Description" disabled="" required="true" value="${description}" hidden="">
                                                    </div>
                                                </div>



                                                <div class="form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">

                                                        <input type="text" class="form-control" id="PrixInscription" placeholder="Prix Inscription" required="true" value="${inscription}" hidden="" name="inscription">
                                                    </div>
                                                </div>

                                                <div class="form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">

                                                        <input type="text" class="form-control" id="mensualite" value="${mensualite}" name="mensualite" hidden="">
                                                    </div>
                                                </div>

                                                <div class="form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">

                                                        <input type="text" class="form-control"  hidden="">
                                                    </div>
                                                </div>
                                                <c:url var="link" value="confirmerClasse.htm">

                                                    <c:param name="date" value="${date}"/>
                                                    <c:param name="idFiliere" value="${idFiliere}"/>
                                                    <c:param name="matricule" value="${matricule}"/>
                                                    <c:param name="description" value="${description}"/>
                                                    <c:param name="nom" value="${nom}"/>
                                                    <c:param name="inscription" value="${inscription}"/>
                                                    <c:param name="mensualite" value="${mensualite}"/>
                                                </c:url>
                                                <div class=" form-group col-md-6">       
                                                    <button type="reset" class="btn btn-primary">
                                                        <i class="ti-stamp">

                                                        </i> <a href="${link}" style="color: #fff;"> Valider</a></button>
                                                </div>
                                                <div class=" form-group col-md-6">   
                                                    <button type="reset" type="button" data-dismiss="modal" class="btn btn-secondary">
                                                        <i class="ti-trash">

                                                        </i> 
                                                    <a href="addClasse.htm" style="color: #fff;"> Annuler</a>
                                                    </button>
                                                </div>

                                            </div>
                                        </div>




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
        <script>
            var $input = $(".classe");
            $input.typeahead({
                source: [
            <c:forEach var="element" items="${domaine}">
                    {id: '${element.id}', name: '${element.nom}'},
            </c:forEach>
                ],
                autoSelect: true
            });
            $input.change(function () {
                var current = $input.typeahead("getActive");
                if (current) {

                    if (current.name == $input.val()) {
                        document.getElementById("id").value = current.id;

                    } else {
                        document.getElementById("classe").value = "Le cycle n'existe pas";
                    }
                } else {
                    // Nothing is active so it is a new value (or maybe empty value)
                }
            });
        </script>

        <style>
            .col-6{
                font-family: titilliumWeb-light;
                font-size: 1.5rem;
            }
            .avatar-pic {
                width: 150px;
            }
        </style>




    </body>

</html>
