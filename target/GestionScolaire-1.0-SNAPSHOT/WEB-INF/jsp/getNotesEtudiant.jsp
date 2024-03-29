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

        <title>    Notes   ${nomClasse}   ${nomFiliere} en ${nomMatiere} du ${semestre} ${acad}</title>
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
            <ul class="sidebar navbar-nav " >




                <li class="nav-item" style="margin-top: 20px;">
                    <a class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">

                        <i class="fas fa-bars">    </i>

                    </a>
                </li>




                <li class="nav-item">
                    <a class="nav-link" href="secretaire.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>



            </ul>


            <div id="content-wrapper">

                <div class="container-fluid">


                    <div class="card " id="ue" style=" margin-top: 3px;">
                        <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">

                            <span style="font-family: dax-bold;    font-size: 1.7rem;">
                                ${etu.idetudiant.prenom}    ${etu.idetudiant.nom} 
                            </span> <br>
                            <span>
                                Classe : ${nomClasse}  ${nomFiliere}
                            </span>
                            <br>
                            <span>
                                Semestre :
                            </span>
                            <span >
                                ${semestre} 
                            </span>
                            <br>

                            <span >
                                Annee : ${acad}
                            </span>

                        </div>


                        <div class="card-body">


                            <div class="table-responsive">
                                <form method="POST">
                                    <table class="table table-bordered" id="dataTable" width="100%">
                                        <thead>
                                            <tr style="text-align: center;vertical-align: middle;">

                                           
                                                <th>Matiere</th>
                                                <th>Note 1</th>
                                                <th>Note 2</th>
                                                <th>Examen</th>



                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr style="text-align: center;vertical-align: middle;">

                                             
                                                <th>Matiere</th>
                                                <th>Note 1</th>
                                                <th>Note 2</th>
                                                <th>Examen</th>




                                            </tr>
                                        </tfoot>
                                        <tbody>

                                            <c:forEach var="etud" items="${notes}">


                                                <tr>
                                                  
                                                    <td>${etud.idmatiere.nom}</td>
                                                    <td>${etud.noteA}</td>
                                                    <td>${etud.note2}</td>
                                                    <td>${etud.examen}</td>


                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <input type="text" id="data"  name="data"  hidden="">
                                    <input type="text" id="idUser"  name="idUser" hidden="" >
                                    <input type="text" id="idMatiere"  name="idMatiere" hidden=""  value="${idMatiere}" >
                                    <input type="text" id="idClasse"  name="classeId"   hidden="" value="${classeId}" >

                                    <input type="text" id="idSemestre"  name="semestre"  hidden="" value="${numSemestre}" >
                                    <input type="text" id="idSemestre"  name="annee"  hidden="" value="${annee}" >
                                    <input type="text" id="idAcad"  name="idAcad"   value="${idAcad}" hidden="" >

                                </form>
                            </div>
                           <button  class="btn btn-primary" style=" font-family: titilliumWeb-regular;">
                                                            <div class="form-label-group">
                                                                <a class="ti-notepad" style=" color: #fff;" href="getBulletinEtudiant.htm">  Bulletin</a> 
                         </div></button>

                        </div>

                    </div>


                </div>

            </div>


        </div>
        <!-- /.container-fluid -->



    </div>
    <!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

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
<script src="js/bootstrap3-typeahead.js"></script>









</script>

<style>
 
    input[type=number]::-webkit-inner-spin-button, 
    input[type=number]::-webkit-outer-spin-button { 
        -webkit-appearance: none; 
        margin: 0; 
    }
    .dataTables_length{
        visibility: hidden;
    }
    .dataTables_filter{
        visibility: hidden;
    }
    .dataTables_info{
        visibility: hidden;
    }
    .paginate_button page-item previous disabled{
        visibility: hidden;
    }
    .form-control{
        background-color: #fff;

        border: 0px solid #ffffff;
    }
    .pagination{
        visibility: hidden; 
    }
    .dataTables_paginate paging_simple_numbers{
        visibility: hidden;
    }
    table.table-bordered.dataTable tbody th, table.table-bordered.dataTable tbody td {
        text-align: center;
    }
</style>
<script>

                                var $listeUser = new Array();
    <c:forEach var="element" items="${findListEtudiants}">
                                $listeUser.push('${element.iduser.id}');
    </c:forEach>
                                document.getElementById("idUser").value = $listeUser;


                                var $data = "";
                                $('input').on('change', function () {
                                    if (this)
                                    {

                                        $data = $data.concat(this.value).concat('-');
                                    } else
                                    {
                                        $data = $data.concat('00').concat('-');
                                    }
                                    document.getElementById("data").value = $data;

                                });

</script>

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
</body>

</html>
