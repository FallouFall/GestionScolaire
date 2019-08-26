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

        <title>Matiere Assignee (s)</title>
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
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdownFiliere" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Matiere</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdownFiliere">
                    
                        <a  class="dropdown-item" href="#" data-toggle="modal" data-target="#addFiliere">Ajouter</a>
                        <a class="dropdown-item" href="#">Liste Matieres</a>


                    </div>
                </li>
             
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdownFiliere" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Matiere</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdownFiliere">
                    
                        <a  class="dropdown-item" href="#" data-toggle="modal" data-target="#addFiliere">Ajouter</a>
                        <a class="dropdown-item" href="#">Liste Matieres</a>


                    </div>
                </li>
                
                
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdownFiliere" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Classe</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdownFiliere">
                    
                 
                        <a class="dropdown-item" href="gererClasses.htm">Gerer Classes</a>


                    </div>
                </li>
              <li class="nav-item active">
                       <a  class="nav-link" href="gererfiliere.htm">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Gerer Filieres</span></a>
                   
                </li>
                
                  <li class="nav-item active">
                       <a  class="nav-link" href="listeProfeMatiere.htm">
                        <i class="fas fa-fw fa-user-plus"></i>
                        <span>Ajout Matiere Professeur</span></a>
                   
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
                                           Matiere Assignée (s)


                                        </span>  </div>
                                    <div class="card-body" id="myrecu">

                                         <span class="ti-user" style="font-size: 4em;color: #1f72b8!important;"></span>
                                        <div class="form-group">
                                            <div class="row">

                                           
                                               


                                                <div class="col-6 ">Professeur :</div>
                                                <div class="col-6">${matriculeProf}</div>

                                                <div class="col-6 ">Prenom :</div>
                                                <div class="col-6">${nomProf}</div>
                                                
                                                 <div class="col-6 ">Prenom :</div>
                                                <div class="col-6">${prenomProf}</div>


                                             <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%">
                                    <thead>
                                        <tr  style="text-align: center;vertical-align: middle;">

                                            <th>Matricule</th>
                                            <th>Nom</th>
                                          
                                            <th>Description</th>
                                              <th>Coefficient</th>
                                             

                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr style="text-align: center;vertical-align: middle;">

                                              <th>Matricule</th>
                                            <th>Nom</th>
                                          
                                            <th>Description</th>
                                              <th>Coefficient</th>


                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="element" items="${matAssi}">

                                            <tr style="text-align: center;vertical-align: middle;">


                                                <td>${element.matricule}</td>
                                                <td>${element.nom}</td>
                                                   <td>${element.description}</td>
                                                <td>${element.coefficient}</td>
                                            
                                              




                                            </tr>

                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>




                                            </div>


                                           
                                        </div>




                                    </div>
                                </div>


                            </div>
                        </div>
                                     
                    </div>
                <button id="print" onclick="printContent('myrecu');" class="btn btn-primary" style="background-color:#1f72b8; font-family: titilliumWeb-regular;">
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
        <script src="js/bootstrap3-typeahead.js"></script>
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
