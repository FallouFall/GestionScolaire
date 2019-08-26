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

        <title>Ajouter Classe</title>
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
 <ul class="sidebar navbar-nav" >




                <li class="nav-item"  style="margin-top: 20px;">
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
                        <span>Gerer Classe</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">

                        <a  class="dropdown-item" href="addClasse.htm">Ajouter Classe</a>
                        <a class="dropdown-item" href="#">Liste Classes</a>
                           <a class="dropdown-item" href="parametrerClasse.htm">Parametrer Classes</a>


                    </div>
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
                
                   <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdownFiliere" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Filiere</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdownFiliere">

                        <a  class="dropdown-item" href="AjouterFiliere.htm" >Ajouter Filiere</a>
                        <a class="dropdown-item" href="gererfiliere.htm">Gerer Filieres</a>


                    </div>
                </li>

            </ul>


            <div id="content-wrapper">

                <div class="container-fluid">


                    <div id="cards" class="container mb-2 "   style="padding-bottom: 1px  ;margin-top: -45px;">


                        <div class="example col-md-12 ml-auto mr-auto">
                            <div class="row " id="myrow">

                                <div class="card card-signin mx-auto mt-5">
                                    <div class="card-header" style="text-align: center;background-color: #fff;color:#1f72b8;">

                                        <span style="font-family: dax-bold; color: #1f72b8!important;    font-size: 2rem;">
                                         Classe ${nomClasse} ${nomFiliere} 


                                        </span>  </div>
                                    <div class="card-body">


                                        <div class="form-group">
                                            <div class="row" >

                                             
                                                
                                                <div class="col-6 ">Matricule :</div>
                                                <div class="col-6">${matricule}</div>


                                                <div class="col-6 ">Nom :</div>
                                                <div class="col-6">${nom}</div>

                                                <div class="col-6 ">Description :</div>
                                                <div class="col-6">${description}</div>


                                                <div class="col-6">Date :</div>
                                                <div class="col-6">${date}</div>

                                          




                                            </div>


                                    
                                        </div>




                                    </div>
                                                
                                </div>
                                                

                            </div>
                                                
                        </div>
                                                
                    </div>
                                                  <button id="print" onclick="printContent('myrow');" class="btn btn-primary" style="background-color:#1f72b8; font-family: titilliumWeb-regular; margin-left: 20px;">
                                                            <i class="ti-printer">

                    </i> Imprimer</button>

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
   <script>
function printContent(el){
var restorepage = $('body').html();
var printcontent = $('#' + el).clone();
var enteredtext = $('#text').val();
$('body').empty().html(printcontent);
window.print();
$('body').html(restorepage);
$('#text').html(enteredtext);
setTimeout(function (){
    location.reload()
},1);
}

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
