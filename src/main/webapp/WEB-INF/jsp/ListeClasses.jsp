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

        <title style="font-family: dax-bold;    font-size: 2rem;">LISTE DES CLASSES</title>


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
                    <a class="nav-link" href="directeur.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="gererue.htm">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Tables</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Gerer Classes</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">

                        <a  class="dropdown-item" href="#" data-toggle="modal" data-target="#addClasse">Ajouter</a>
                        <a class="dropdown-item" href="#">Lister</a>


                    </div>
                </li>
                <li class="nav-item active">
                    <a  class="nav-link" href="listeMatiere.htm">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Gerer Matieres</span></a>

                </li>



              

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdownFiliere" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Filiere</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdownFiliere">

                        <a  class="dropdown-item" href="#" data-toggle="modal" data-target="#addFiliere">Ajouter</a>
                        <a class="dropdown-item" href="gererfiliere.htm">Gerer Filieres</a>


                    </div>
                </li>

            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">

                  





                    <!-- DataTables Example -->
                    <div class="card mb-3 " id="ue" style=" margin-top: 17px;">
                        <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">

                            <span style="font-family: dax-bold;    font-size: 2rem;">
                                Classes


                            </span>  </div>

                        <div class="card-body">


                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr  style="text-align: center;vertical-align: middle;">

                                            <th>Matricule</th>
                                            <th>Nom</th>
                                            <th>Date Creation</th>
                                            <th>Description</th>
                                            <th>Filiere</th>
                                             <th>Details</th>



                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr style="text-align: center;vertical-align: middle;">

                                            <th>Matricule</th>
                                            <th>Nom</th>
                                            <th>Date Creation</th>
                                            <th>Description</th>
                                            <th>Filiere</th>
                                              <th>Details</th>
                                           



                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="element" items="${classes}">
                                            
                                 <c:url var="link" value="detailClasse.htm">
                               <c:param name="id" value="${element.id}"/>
                               <c:param name="matricule" value="${element.matricule}"/>
                               <c:param name="nomClasse" value="${element.nom}"/>
                               <c:param name="nomFiliere" value="${element.filiere}"/>
                                  
                              </c:url>
                                            
                                            <tr style="text-align: center;vertical-align: middle;">


                                                <td>${element.matricule}</td>
                                                <td>${element.nom}</td>
                                                <td>${element.creation}</td>
                                                <td>${element.description}</td>
                                                 <td>${element.filiere}</td>


                                                   <td>
                                                    
                                                    <div class="form-label-group">
                                                        <a href="${link}" class="fa fa-users"></a>
                                                    </div>
                                                </td>

                                            </tr>

                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>

                        <button id="print" onclick="printContent('dataTable');" class="btn btn-primary" style="background-color:#1f72b8; font-family: titilliumWeb-regular;">
                                                            <i class="ti-printer">

                    </i> Imprimer</button>

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

        <!-- Bootstrap core JavaScript-->
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

        <div class="modal fade" id="addClasse" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header" >
                        <h5 class="modal-title" id="exampleModalLabel">Ajouter Classe</h5>
                        <br><br>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">

                        </button>

                    </div>
                    <div id="content-wrapper">

                        <div class="container-fluid">
                            <div class="example col-md-12 ml-auto mr-auto">
                                <div class="row " >
                                    <form>
                                        <br>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="form-group col-md-6 ">
                                                    <div class="input-group with-addon-icon-left">
                                                        <span class="input-group-addon">
                                                            <i class="ti-tag"></i>
                                                        </span>
                                                        <input type="text" class="form-control " id="nomClasse" placeholder="Nom " required="true">
                                                    </div>
                                                </div>

                                                <div class=" form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <input type="text" class="form-control" id="datepicker-example-1" placeholder="Date de Creation" >
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
                                                        <input type="text" class="form-control" id="descriptionClasse" placeholder="Description" required="true">
                                                    </div>
                                                </div>

                                                <div class=" form-group col-md-6">               
                                                    <fieldset>
                                                        <select class="custom-select w-100" required="true">

                                                            <option value="">Filiere</option>
                                                            <option value="1">One</option>
                                                            <option value="2">Two</option>
                                                            <option value="3">Three</option>

                                                        </select>
                                                    </fieldset>
                                                </div>

                                                <div class="form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <span class="input-group-addon">
                                                            <i class="ti-money"></i>
                                                        </span>
                                                        <input type="text" class="form-control" id="PrixInscription" placeholder="Prix Inscription" required="true">
                                                    </div>
                                                </div>

                                                <div class="form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <span class="input-group-addon">
                                                            <i class="ti-alert"></i>
                                                        </span>
                                                        <input type="text" class="form-control" id="PrixInscription" placeholder="Condition Admission" >
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

        <div class="modal fade" id="addFiliere"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header" >
                        <h5 class="modal-title" id="exampleModalLabel">Ajouter Filiere</h5>
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
                                                        <input type="text" class="form-control " id="nomMatiere"  name="nomFiliere" placeholder="Nom " required="true">
                                                    </div>
                                                </div>



                                                <div class="form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <span class="input-group-addon">
                                                            <i class="ti-info"></i>
                                                        </span>
                                                        <input type="text" class="form-control"  name="descriptionFiliere" id="descriptionMatiere" placeholder="Description" required="true">
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


    </body>

</html>
