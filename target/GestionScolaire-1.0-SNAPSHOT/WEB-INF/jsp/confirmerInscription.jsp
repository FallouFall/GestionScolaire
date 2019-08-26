<%-- 
    Document   : GererAdmini
    Created on : 25 nov. 2018, 15:10:14
    Author     : Fallou
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html" import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Inscription</title>
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
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy ");
            String date = sdf.format(new Date());
        %>
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
                <li class="nav-item" style="margin-top: 20px;">
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
                    <a class="nav-link" href="InscriptionEtudiant.htm">
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


                    <div id="cards" class="container mb-2 " style="padding-bottom: 1px  ;margin-top: -45px;">


                        <div class="example col-md-12 ml-auto mr-auto">
                            <div class="row " >

                                <div class="card card-signin mx-auto mt-5" id="recu" >
                                    <div class="card-header" style="text-align: center;background-color: #fff;color:#1f72b8;">

                                        <span style="font-family: titilliumWeb-italic;color: #1f72b8!important;  font-size: 1.3rem;float: left;">
                                            GSP


                                        </span>
                                        <span class="ti-book" style="  color: #1f72b8!important;  font-size: 1.3rem;float: right;">



                                        </span>

                                        <span style="font-family: dax-bold;  color: #1f72b8!important;  font-size: 2rem;">
                                            Reçu Inscription № ${matri}


                                        </span> 
                                        <hr>
                                    </div>
                                    <div class="card-body" style="    ">


                                        <div class="example col-md-12 ml-auto mr-auto">

                                            <div class="row ">


                                                <section id="team" class="pb-5 " style="margin-top: -90px;">
                                                    <div class="row" style="margin-bottom: -100px; margin-top: 3px;">

                                                        <div class="col-lg-4 col-md-6 col-sm-12 mb-4">

                                                            <a href="domaineById.htm?id=1&amp;annee=2019" style="   text-decoration: none; color: #5a6169;">
                                                                <div class="frontside">
                                                                    <div class="card " style="box-shadow: none;">



                                                                        <div class="card-body text-center">
                                                                            <span class="ti-user" style="font-size: 3em;color: #1f72b8 !important;"></span>

                                                                            <div class="row" style="text-align: left;margin: 20px;" >

                                                                                <span style="font-size: 1.5em; ">Matricule   : </span>
                                                                                <span style="font-size: 1.5em; "> ${matriculeEtu} </span>
                                                                                <span style="font-size: 1.5em; ">Nom   :</span>
                                                                                <span style="font-size: 1.5em; ">${nomEtu}</span><br>
                                                                                <span style="font-size: 1.5em; ">Prenom :</span>
                                                                                <span style="font-size: 1.5em; ">${prenomEtu}</span><br>




                                                                            </div>







                                                                        </div>


                                                                    </div>
                                                                </div>
                                                            </a>


                                                        </div>

                                                        <div class="col-lg-4 col-md-6 col-sm-12 mb-4">

                                                            <a href="domaineById.htm?id=1&amp;annee=2019" style="   text-decoration: none; color: #5a6169;">
                                                                <div class="frontside">
                                                                    <div class="card "  style="box-shadow: none;">



                                                                        <div class="card-body text-center">

                                                                            <span class="ti-infinite" style="font-size: 3em;color: #1f72b8 !important;"></span>
                                                                            <div class="row" style="text-align: left;margin: 20px;">
                                                                                <span style="font-size: 1.5em; ">Dom :</span>
                                                                                <span style="font-size: 1.5em; ">${dmn}</span><br>
                                                                                <span style="font-size: 1.5em; ">Forma :</span>
                                                                                <span style="font-size: 1.5em; ">${frn}</span><br>
                                                                                <span style="font-size: 1.5em;">Cycle :</span>
                                                                                <span style="font-size: 1.5em; ">${cyn}</span><br>



                                                                            </div>







                                                                        </div>


                                                                    </div>
                                                                </div>
                                                            </a>


                                                        </div>
                                                        <div class="col-lg-4 col-md-6 col-sm-12 mb-4">

                                                            <a href="domaineById.htm?id=1&amp;annee=2019" style="   text-decoration: none; color: #5a6169;">
                                                                <div class="frontside">
                                                                    <div class="card " style="box-shadow: none;">



                                                                        <div class="card-body text-center">

                                                                            <span class="ti-home" style="font-size: 3em;color: #1f72b8 !important;"></span>
                                                                            <div class="row" style="text-align: left;margin: 20px;">

                                                                                <span style="font-size: 1.5em; ">Classe :</span>
                                                                                <span style="font-size: 1.5em; ">${classe} ${Filiere}</span><br>
                                                                                <span style="font-size: 1.5em; ">Inscription :</span>
                                                                                <span style="font-size: 1.5em; ">${inscription}</span><br>
                                                                                <span style="font-size: 1.5em;">Mensualite :</span>
                                                                                <span style="font-size: 1.5em; ">${mensualite}</span><br>




                                                                            </div>







                                                                        </div>


                                                                    </div>
                                                                </div>
                                                            </a>


                                                        </div>


                                                    </div>
                                                </section>


                                            </div>
                                        </div>




                                    </div>
                                    <div class="card-footer">
                                        <span style="font-family: titilliumWeb-regular;;  color: #1f72b8!important;  font-size: 1.1rem;text-align: center;">
                                            Par: ${user} le <%= date%>


                                        </span>
                                    </div>

                                </div>


                            </div>
                        </div>

                    </div>
                    <button id="print" onclick="printContent('recu');" class="btn btn-primary" style="background-color:#1f72b8; font-family: titilliumWeb-regular;">
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
            .span{
                font-family: titilliumWeb-light;
                font-size: 1.5rem;
            }
            .avatar-pic {
                width: 150px;
            }
        </style>




    </body>

</html>
