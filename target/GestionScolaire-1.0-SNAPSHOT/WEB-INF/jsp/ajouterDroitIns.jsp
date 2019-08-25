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

        <title>Ajouter Droit Inscription</title>
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
                
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdownFiliere" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Droit Inscription</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdownFiliere">

                        <a  class="dropdown-item" href="ajouterDroitIns.htm" >Ajouter Droit Inscription</a>
                        <a class="dropdown-item" href="detailclasseParamClasse.htm">Gerer Droit Inscription</a>


                    </div>
                </li>

            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">


               <div class="card mb-3 ">
                        <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">

                            <span style="font-family: dax-bold;    font-size: 2rem;">
                                Ajouter Droit Inscription


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
                                                <input type="number" class="form-control" name="inscription"  placeholder="Inscription" required="true" min="0" max="100000">
                                            </div>
                                        </div>
                                        
                                           <div class="form-group col-md-6">
                                            <div class="input-group with-addon-icon-left">
                                                <span class="input-group-addon">
                                                    <i class="ti-tag"></i>
                                                </span>
                                                <input type="number" class="form-control" name="mensualite"  placeholder="Mensualite" required="true" min="0" max="60000">
                                            </div>
                                        </div>
                                        <div class=" form-group col-md-6">       
                                            <button type="submit" class="btn btn-primary">
                                                <i class="ti-save">

                                                </i> Enregistrer</button>
                                        </div>


                                    </div>
                                </div>
                            </form>
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
            <c:forEach var="element" items="${annee}">
            {id: '${element.id}', name: '${element.nom}'},
            </c:forEach>
            ],
                    autoSelect: true
            });
            $input.change(function () {
            var current = $input.typeahead("getActive");
            if (current) {

            if (current.name == $input.val()) {
                 document.getElementById("id").value=current.id;

            } else {
            document.getElementById("classe").value="Le domaine  n'existe pas";
            }
            } else {
            // Nothing is active so it is a new value (or maybe empty value)
            }
            });
        </script>
        <style>
            .avatar-pic {
width: 150px;
}
.sidebar{
      font-family: titilliumWeb-regular;
}
  input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none; 
                margin: 0; 
            }

        </style>




    </body>

</html>
