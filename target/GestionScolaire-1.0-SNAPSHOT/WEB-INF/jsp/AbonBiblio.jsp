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

        <title>Liste des Abonnes Bibliotheques</title>


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

                 




                    <!-- DataTables Example -->
                    <div class="card mb-3  ">
                        <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">

                            <span style="font-family: dax-bold;    font-size: 2rem;">
                                Abonnenemts Bibliotheque


                            </span>  </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" >
                                    <thead>
                                        <tr  style="text-align: center;vertical-align: middle;">
                                       
                                           <th>Etudiant</th>
                                            <th>Matricule</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Adresse</th>
                                            <th>Telephone</th>
                                               <th>Details</th>

                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr style="text-align: center;vertical-align: middle;">
                                        
                                            <th>Etudiant</th>
                                            <th>Matricule</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Adresse</th>
                                            <th>Telephone</th>
                                                <th>Details</th>


                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="element" items="${liste}">


                                            <tr style="text-align: center;vertical-align: middle;">

                                             
                                                <td>${element.inscription.matricule}</td>
                                                  <td>${element.matricule}</td>
                                                <td>${element.inscription.nom}</td>
                                                <td>${element.inscription.prenom}</td>
                                                <td>${element.inscription.adresse}</td>
                                                <td>${element.inscription.telephone}</td>
                                                      <td>
                                                    
                                                    <div class="form-label-group">
                                                        <a href="#" class="ti-id-badge"></a>
                                                    </div>
                                                </td>



                                            </tr>

                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <button id="print" onclick="printContent('dataTable');" class="btn btn-primary" style="background-color:#1f72b8; font-family: titilliumWeb-regular;">
                                                            <i class="ti-printer">

                    </i> Imprimer</button>
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
            <i class="ti-angle-up"></i>
        </a>

      <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Se Deconnecter?</h5>
                        
                    </div>
                    <div class="modal-body" style=" font-family: titilliumWeb-regular;">
                        
                        <span  class="ti-alert" style="font-size: 1.5em;">
                            
                        </span>Voulez-Vous quitter ?</div>
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



    </body>

</html>
