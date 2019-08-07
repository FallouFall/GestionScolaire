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

        <title>    ${nomClasse} ${nomFiliere}</title>


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


            <ul class="sidebar navbar-nav" >




                <li class="nav-item" style="margin-top: 20px;" >

                    <a class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">

                        <i class="fas fa-bars">    </i>

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

                <li class="nav-item active">
                    <a  class="nav-link" href="listeMatiere.htm">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Gerer Matieres</span></a>

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

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdownFiliere" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Filiere</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdownFiliere">

                        <a  class="dropdown-item" href="#" data-toggle="modal" data-target="#addFiliere">Ajouter</a>
                        <a class="dropdown-item" href="#">Gerer Filieres</a>


                    </div>
                </li>

            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">







                    <!-- DataTables Example -->
                    <div class="card mb-3  " id="ue" style=" margin-top: 17px;">
                        <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">

                            <span style="font-family: dax-bold;    font-size: 2rem; margin-right: 100px;">
                                ${nomClasse} ${nomFiliere}


                            </span>  </div>

                        <div class="row">
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <div style=" margin-left: 5%; font-size: 2.2em; font-family: titilliumWeb-regular;">

                                    <span class="fa fa-users" style="color:#5a6169  ; ">
                                        ${effectif} 
                                    </span>
                                    <span class="fa fa-male " style="color: #0272bd;">
                                        ${nbFeminin} 
                                    </span>
                                    <span class="fa fa-female" style="color: #75b5e4 ;">
                                        ${nbMasculin} 
                                    </span>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <c:url var="linkProgramme" value="gererProgramme.htm">

                                    <c:param name="id" value="${classeId}"/>
                                    <c:param name="classe" value="${nomClasse}"/>
                                    <c:param name="filiere" value="${nomFiliere}"/>
                                </c:url>
                                
                                 <c:url var="linkCalendar" value="calendrierClasse.htm">
                                        <c:param name="nomClasse" value="${nomClasse}"/>
                                    <c:param name="nomFiliere" value="${nomFiliere}"/>
                                    <c:param name="id" value="${classeId}"/>
                                   
                                </c:url>
                                <a href="${linkProgramme}" >
                                    <button type="button" class="btn btn-primary" style=" color:#1B81C5;background-color:#fff; font-family: titilliumWeb-regular; ">
                                        <i class="ti-menu">

                                        </i> Programme</button>
                                </a>  



                                <a href="${linkCalendar}" >
                                    <button type="button" class="btn btn-primary" style=" color:#1B81C5;background-color:#fff; font-family: titilliumWeb-regular;">
                                        <i class="ti-timer">

                                        </i> Calendrier</button>
                                </a>      

                            </div>






                        </div>





                        <div class="card-body">


                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr  style="text-align: center;vertical-align: middle;">
                                            <th>Matricule</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Inscription</th>
                                            <th>Date</th>

                                            <th>Details</th>




                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr style="text-align: center;vertical-align: middle;">

                                            <th>Matricule</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Inscription</th>
                                            <th>Date</th>

                                            <th>Details</th>



                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="element" items="${inscriptions}">
                                            <c:url var="link" value="detailInscription.htm">

                                                <c:param name="id" value="${element.iduser.id}"/>
                                                <c:param name="idInscription" value="${element.matricule}"/>
                                                <c:param name="profilId" value="${element.iduser.idprofil.id}"/>
                                                <c:param name="validite" value="${element.validite}"/>
                                                <c:param name="cancel" value="1"/>
                                            </c:url>

                                            <tr style="text-align: center;vertical-align: middle;">


                                                <td>${element.iduser.matricule}</td>
                                                <td>${element.iduser.nom}</td>
                                                <td>${element.iduser.prenom}</td>
                                                <td>${element.matricule}</td>
                                                <td>${element.date}</td>
                                                <td>
                                                    <div class="form-label-group">
                                                        <a href="${link}" class="ti-id-badge"></a>
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
        function printContent(el) {
            var restorepage = $('body').html();
            var printcontent = $('#' + el).clone();
            var enteredtext = $('#text').val();
            $('body').empty().html(printcontent);
            window.print();
            $('body').html(restorepage);
            $('#text').html(enteredtext);
            setTimeout(function () {
                location.reload()
            }, 1);
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
            .sidebar{
      font-family: titilliumWeb-regular;
}
      .table-responsive {
    font-family: dax;
    
}
         table.table-bordered.dataTable tbody th, table.table-bordered.dataTable tbody td {
  
    font-family: titilliumWeb-regular;
}
        </style>

      


    </body>

</html>
