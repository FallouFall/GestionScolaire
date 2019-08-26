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

        <title>Detail Inscription</title>


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

                                        <c:if test="${inscription.validite == 0}">

                                            Valider Inscription
                                        </c:if>

                                        <c:if test="${inscription.validite == 3}">
                                            En attente de Validation
                                        </c:if>


                                        <c:if test="${inscription.validite == 1}">

                                            Suspendre Inscription
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

                                                        <span style="font-size: 2em">${inscription.iduser.nom} ${inscription.iduser.prenom}</span>   

                                                        <div>

                                                            <div class="text-muted font-13 mb-3">
                                                                <span class="mr-3"><i class="ti-location-pin mr-2"></i>${inscription.iduser.adresse}</span>
                                                                <span><i class="ti-calendar mr-2"></i>12.04.2018</span>
                                                            </div>


                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                                <li class="nav-item">
                                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true"><span class="ti-info"></span>INFORMATION GENERALE</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false"><span class="ti-plus"></span> DESCRIPTION</a>
                                                </li>

                                            </ul>
                                        </div>
                                    </div>
                                    <div class="tab-content" id="myTabContent">
                                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                            <div class="row">


                                                <div class="col-6 text-muted">Matricule:</div>
                                                <div class="col-6">${inscription.matricule}</div>

                                                <div class="col-6 text-muted">Telephone :</div>
                                                <div class="col-6">${inscription.iduser.telephone}</div>



                                                <div class="col-6 text-muted">Fonction :</div>
                                                <div class="col-6">Etudiant</div>

                                                <div class="col-6 text-muted">Classe :</div>
                                                <div class="col-6">${inscription.idclasse.description}</div>




                                                <div class="col-6 text-muted">Date :</div>
                                                <div class="col-6">${inscription.date}</div>

                                                <form method="POST">
                                                    <div class="form-group" >
                                                        <div class="form-row">
                                                            <c:if test="${inscription.validite == 0}">


                                                                <div class=" form-group col-md-6">       
                                                                    <button type="submit" class="btn btn-primary" style="background-color:#1B81C5; font-family: titilliumWeb-regular;">
                                                                        <i class="ti-save">

                                                                        </i> Valider</button>
                                                                </div>
                                                                <div class=" form-group col-md-6">   

                                                                    <button type="submit" class="btn btn-secondary" style="background-color:#5a6169; font-family: titilliumWeb-regular;">
                                                                        <div class="form-label-group">
                                                                            <a class="ti-angle-double-left" style="background-color: #5a6169; color: #fff;"href=validerInscription.htm>  Annuler</a> 
                                                                        </div></button>

                                                                </div>
                                                            </c:if>
                                                            <c:if test="${inscription.validite == 3}">


                                                                <div class=" form-group col-md-6">       
                                                                    <button type="submit" class="btn btn-primary" style="background-color:#1B81C5; font-family: titilliumWeb-regular;">
                                                                        <i class="ti-save">

                                                                        </i> Valider</button>
                                                                </div>
                                                                <div class=" form-group col-md-6">    

                                                                    <c:url var="link" value="cancel.htm">

                                                                        <c:param name="cancel" value="0"/>
                                                                        <c:param name="id" value="${inscription.iduser.id}"/>
                                                                        <c:param name="idInscription" value="${inscription.matricule}"/>
                                                                        <c:param name="profilId" value="${inscription.iduser.idprofil.id}"/>
                                                                        <c:param name="validite" value="${inscription.validite}"/>

                                                                    </c:url>
                                                                    <button type="submit" class="btn btn-secondary" onclick="" style="background-color:#5a6169; font-family: titilliumWeb-regular;">
                                                                        <div class="form-label-group">
                                                                            <a class="ti-angle-double-left" style="background-color: #5a6169; color: #fff;"href="${link}" >  Annuler</a> 
                                                                        </div></button>
                                                                </div>


                                                            </c:if>


                                                            <c:if test="${inscription.validite == 1}">


                                                                <div class=" form-group col-md-6">       
                                                                    <button type="submit" class="btn btn-primary" style="background-color:#0272bd; font-family: titilliumWeb-regular;">
                                                                        <i class="ti-close">

                                                                        </i> Suspendre</button>
                                                                </div>


                                                                <div class=" form-group col-md-6">   

                                                                    <button type="submit" class="btn btn-secondary" style="background-color:#5a6169; font-family: titilliumWeb-regular;">
                                                                        <div class="form-label-group">
                                                                            <a class="ti-angle-double-left" style="background-color: #5a6169; color: #fff;"href=validerInscription.htm>  Annuler</a> 
                                                                        </div>

                                                                </div>
                                                            </c:if>




                                                        </div>

                                                    </div>







                                                </form>




                                            </div>
                                        </div>
                                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                            <p>Lorem Ipsum Aliqua id consequat laborum incididunt adipiscing ut consectetur dolor voluptate non est ex dolore voluptate fugiat adipiscing qui deserunt nisi magna irure tempor non cupidatat amet fugiat est ad sint adipiscing
                                                est officia cillum consectetur reprehenderit non.</p>
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

   nav-tabs .nav-item.show .nav-link, .nav-tabs .nav-link.active {
    color: #fff;

    background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);
  
    border-color: #fff #fff   #fff;
}
        </style>

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>
