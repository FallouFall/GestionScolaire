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

        <title>Faqs</title>


        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/sb-admin.css" rel="stylesheet">

        <%@include file="HeaderUser.jsp" %>




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





        <div id="wrapper">

            <div class="content-wrapper" style="    margin: auto;">

                <div id="cards" class="container mb-2 " style="padding-bottom: 1px ; ">


                    <div class="example col-md-12 ml-auto mr-auto">
                        <div class="row " style="margin-top: -10px;" >

                            <div class="card card-signin mx-auto mt-5" style="margin-top: -15px;">
                                <div class="card-header" style="text-align: center;background-color: #fff;color:#1f72b8;">

                                    <span style="font-family: dax-bold;   font-size: 2rem;">

                                        <c:if test="${questions.statut == 0}">

                                            En attente de reponse
                                        </c:if>

                                        <c:if test="${questions.statut == 1}">
                                            Question deja repondue
                                        </c:if>



                                    </span>  </div>
                                <div class="card-body">
                                    <div class="page-header">
                                        <div class="ibox flex-1">
                                            <div class="ibox-body">
                                                <div class="flexbox" style="text-align: center;">
                                                    <div class="flexbox-b">
                                                        <div class="ml-5 mr-5">
                                                            <c:if test="${photoEtudiant != null}">
                                                                <img alt="" class="image--cover "  style="  width: 100px;
                                                                     height: 100px;"src="data:image/jpeg;base64,${photoEtudiant} " >
                                                            </c:if>

                                                            <c:if test="${photoEtudiant == null}">
                                                                <span class="ti-user" style="font-size: 3.8em;"></span>
                                                            </c:if>

                                                        </div>

                                                        <span style="font-size: 2em">${questions.iduser.nom} ${questions.iduser.prenom}</span>   

                                                        <div>

                                                            <div class="text-muted font-13 mb-3">
                                                                <span class="mr-3"><i class="ti-location-pin mr-2"></i>${questions.iduser.adresse}</span>
                                                                <span><i class="ti-calendar mr-2"></i>12.04.2018</span>
                                                            </div>


                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                                <li class="nav-item">
                                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">INFORMATION GENERALE </a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">DESCRIPTION</a>
                                                </li>

                                            </ul>
                                        </div>
                                    </div>
                                    <div class="tab-content" id="myTabContent">
                                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                            <div class="row">

                                                <p style="visibility: hidden;">onsequat laborum incididunt adipiscing ut consectetur dolor voluptate non est ex dolore voluptate fugiat adipiscing qui deserunt nisi magna irure tempor non cupidatat amet fugiat est ad sint adipiscing
                                                </p>
                                                <div class="col-6 text-muted">Matricule:</div>
                                                <div class="col-6">${questions.matricule}</div>

                                                <div class="col-6 text-muted">Telephone :</div>
                                                <div class="col-6">${questions.iduser.telephone}</div>



                                                <div class="col-6 text-muted">Fonction :</div>
                                                <div class="col-6">Etudiant</div>




                                                <div class="col-6 text-muted">Date :</div>
                                                <div class="col-6">${questions.date}</div>

                                                <br><br>
                                                <button type="submit" class="btn btn-secondary" style="background-color:#5a6169; font-family: titilliumWeb-regular;">
                                                    <div class="form-label-group">
                                                        <a class="ti-back-left" style="background-color: #5a6169; color: #fff;"href=faqResponseSec.htm>Retour</a> 
                                                    </div></button>





                                            </div>
                                        </div>
                                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">

                                            <p style="visibility: hidden;">onsequat laborum incididunt adipiscing ut consectetur dolor voluptate non est ex dolore voluptate fugiat adipiscing qui deserunt nisi magna irure tempor non cupidatat amet fugiat est ad sint adipiscing
                                            </p>

                                            <form method="POST">
                                                <div class="form-group" >
                                                    <div class="form-row">
                                                        <c:if test="${questions.statut == 0}">


                                                            <div class="form-group col-md-6 " style="font-size: 1.3em;">
                                                                <div class="input-group with-addon-icon-left">
                                                                    <span class="input-group-addon">
                                                                        <i class="ti-help" style="color: #1f72b8;"></i>
                                                                        <span style=" font-family: dax; color:#1f72b8;"> Question : </span> 
                                                                    </span>

                                                                </div>
                                                            </div>

                                                            <p  style=" font-family: dax; color:#1f72b8;font-size: 1.2em;" >${questions.description}</p>


                                                            <div class="form-group col-md-6 "  style="font-size: 1.3em;">
                                                                <div class="input-group with-addon-icon-left">
                                                                    <span class="input-group-addon">
                                                                        <i class="ti-light-bulb" style="color: #1f72b8;"></i>
                                                                      <span style=" font-family: dax; color:#1f72b8;"> Reponse :</span> 
                                                                    </span>

                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-6 ">
                                                                <div class="input-group with-addon-icon-left">
                                                                    <span class="input-group-addon">
                                                                        <i class="ti-shine"></i>
                                                                    </span>
                                                                    <input type="text" name="reponse" class="form-control " id="reponse" placeholder="Reponse" required="true">
                                                                </div>
                                                            </div>




                                                            <div class=" form-group col-md-6">       
                                                                <button type="submit" class="btn btn-primary" style="background-color:#1B81C5; font-family: titilliumWeb-regular;">
                                                                    <i class="ti-save">

                                                                    </i> Repondre</button>
                                                            </div>
                                                            <div class=" form-group col-md-6">   

                                                                <button type="submit" class="btn btn-secondary" style="background-color:#5a6169; font-family: titilliumWeb-regular;">
                                                                    <div class="form-label-group">
                                                                        <a class="ti-reload" style="background-color: #5a6169; color: #fff;"href=faqResponseSec.htm>  Annuler</a> 
                                                                    </div></button>

                                                            </div>


                                                        </c:if>
                                                        <c:if test="${questions.statut == 1}">



                                                            <div class="form-group col-md-6 " style="font-size: 1.3em;">
                                                                <div class="input-group with-addon-icon-left">
                                                                    <span class="input-group-addon">
                                                                        <i class="ti-help" style="color: #1f72b8;"></i>
                                                                        <span style=" font-family: dax; color:#1f72b8; ">Question :</span> 
                                                                    </span>

                                                                </div>
                                                            </div>

                                                          <p style="font-size: 1.2em;">${questions.description}</p>


                                                      
                                                            <div class="form-group col-md-6 " style="font-size: 1.3em;">
                                                                <div class="input-group with-addon-icon-left">
                                                                    <span class="input-group-addon">
                                                                        <i class="ti-light-bulb" style="color: #1f72b8;"></i>
                                                                        <span style=" font-family: dax; color:#1f72b8; ">Reponse :</span> 
                                                                    </span>

                                                                </div>
                                                            </div>

                                                            
                                                            
                                                            <div class="form-group col-md-6 ">
                                                                <div class="input-group with-addon-icon-left">

                                                                    <p style="font-size: 1.2em;">${questions.reponse}</p>
                                                                </div>
                                                            </div>




                                                            <br>



                                                            <div class=" form-group col-md-6">   

                                                                <button type="submit" class="btn btn-secondary" style="background-color:#5a6169; font-family: titilliumWeb-regular;">
                                                                    <div class="form-label-group">
                                                                        <a class="ti-back-left" style="background-color: #5a6169; color: #fff;"href=faqResponseSec.htm>  Deja Repondue</a> 
                                                                    </div></button>

                                                            </div>



                                                        </c:if>







                                                    </div>

                                                </div>







                                            </form>
                                        </div>

                                    </div>

                                </div>
                            </div>


                        </div>
                    </div>
                </div>



            </div>

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

                        <button type="submit" class="btn btn-primary" style="background-color: #0272bd;">     <a href="deconnecter.htm"  style="   text-decoration: none;  color: #fff;">Deconnceter</a></button>

                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
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

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>
