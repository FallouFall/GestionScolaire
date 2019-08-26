<%-- 
    Document   : GererAdmini
    Created on : 25 nov. 2018, 15:10:14
    Author     : Fallou
--%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.text.DecimalFormat"%>
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

                <c:set var="totalCoef" value="0" scope="page"/>
                <c:set var="totalMoy" value="0" scope="page"/>

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


                    <div class="card " id="ue" style=" margin-top: 3px;overflow-x: hidden;">

                        <div class="card-header" style="     background-image: url(images/footer.png)!important;text-align: center;background-color: #fff;color: #1f72b8;">
                            <span style="font-family: titilliumWeb-italic;color: #1f72b8!important;  font-size: 1.3rem;float: left;">
                                GSP


                            </span>
                            <span class="ti-book" style="  color: #1f72b8!important;  font-size: 1.3rem;float: right;">



                            </span>

                            <span style="font-family: dax-bold;  color: #1f72b8!important;  font-size: 2rem;">
                                Bulletin du    ${semestre} 


                            </span> 
                            <br>
                            <span style="font-family: dax-bold;    font-size: 1.7rem;">
                                ${etu.idetudiant.prenom}    ${etu.idetudiant.nom} 
                            </span> <br>


                        </div>


                        <div class="card-body">

                            <span>
                                Classe : ${nomClasse}  ${nomFiliere}
                            </span>
                            <br>



                            <span >
                                Annee : ${acad}
                            </span>
                            <div class="table-responsive" style="margin-top: 10px;">
                                <form method="POST">
                                    <table class="table table-bordered" id="dataTable" width="100%">
                                        <thead>
                                            <tr style="text-align: center;vertical-align: middle;">



                                                <th>Matiere</th>
                                                <th>Controle Con</th>
                                                <th>Composition</th>
                                                <th>Coefficient</th>
                                                <th>Moyenne</th>



                                            </tr>
                                        </thead>

                                        <tbody>

                                            <c:forEach var="etud" items="${notes}">


                                                <tr>

                                                    <td>${etud.idmatiere.nom}</td>
                                                    <td>${ (etud.noteA +etud.note2)/2 }</td>

                                                    <td>${etud.examen}</td>
                                                    <td>${etud.idmatiere.coefficient}</td>
                                                    <td>${ (  ((  (etud.noteA +etud.note2)/2)  + (2*etud.examen)   ) /3) * etud.idmatiere.coefficient }</td>
                                                    <c:set var="totalCoef" value="${totalCoef+etud.idmatiere.coefficient}" scope="page"/>
                                                    <c:set var="totalMoy" value="${totalMoy+(  ((  (etud.noteA +etud.note2)/2)  + (2*etud.examen)   ) /3) * etud.idmatiere.coefficient }" scope="page"/>
                                                </tr>
                                            </c:forEach>

                                            <tr>
                                                <td colspan="5"></td>
                                            </tr>
                                            <tr style="vertical-align: middle;text-align: center; margin-top: 10px;border: none;">


                                                <th style="border: none;">Total General</th>

                                                <th style="border: none;">Moyenne</th>
                                                <th style="border: none;">Retards</th>

                                                <th style="border: none;">Absences</th>
                                                <th style="border: none;">Mention</th>



                                            </tr>
                                      


                                                <tr style="color: #1f72b8;font-family: titilliumWeb-regular;">

                                                    <td style="    border: none;">

                                                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${totalMoy}"/>
                                                    </td>
                                                    <td style="    border: none;">
                                                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${totalMoy/totalCoef}"/>     
                                                    </td>

                                                    <td style="    border: none;">${absences}</td>
                                                    <td style="    border: none;">${retards}</td>
                                                    <c:if test="${totalMoy/totalCoef <8}">
                                                        <td style="border: none;">Faible</td>
                                                    </c:if>
                                                    <c:if test="${totalMoy/totalCoef >8 && totalMoy/totalCoef <11 }">
                                                        <td style="border: none;">Passable</td>
                                                    </c:if>

                                                    <c:if test="${totalMoy/totalCoef >11 && totalMoy/totalCoef <13 }">
                                                        <td style="border: none;">ABien</td>
                                                    </c:if>
                                                    <c:if test="${totalMoy/totalCoef >13 && totalMoy/totalCoef <16 }">
                                                        <td style="border: none;">Bien</td>
                                                    </c:if>
                                                    <c:if test="${totalMoy/totalCoef >15 }">

                                                        <td style="border: none;">Tres Bien</td>
                                                    </c:if>
                                                </tr>
                                      

                                            <tr>
                                                <td style="border: none;"colspan="5"></td>
                                            </tr>
                                            <tr style="vertical-align:right; margin-top: 10px;border: none;">
                                                <td colspan="5" style="border: none;">Le Directeur </td>
                                            </tr>  

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





                        </div>


                    </div>

                    <button id="print" onclick="printContent('ue');" class="btn btn-primary" style="background-color:#1f72b8; font-family: titilliumWeb-regular;margin-top: 25px;">
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
    table{empty-cells: show;}
    table.table-bordered.dataTable tbody th, table.table-bordered.dataTable tbody td {
        text-align: center;
        font-size: 1.3em;
        empty-cells: show;
        font-family: titilliumWeb-light;
        overflow-x: hidden;
    }
    .table-borderless tbody+tbody, .table-borderless td, .table-borderless th, .table-borderless thead th {
        border: 0;
        font-size: 1.3em;
        font-family: titilliumWeb-light;
        overflow-x: hidden;

    }
    span{
        font-family: titilliumWeb-light;
    }
    .pagination{
        visibility: hidden; 
    }
    .dataTables_paginate paging_simple_numbers{
        visibility: hidden;
    }
    .table-responsive{overflow-x: hidden;
    }
    table.table-bordered.dataTable tbody th, table.table-bordered.dataTable tbody td {
        text-align: center;
        overflow-x: hidden;
        empty-cells: show;
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
