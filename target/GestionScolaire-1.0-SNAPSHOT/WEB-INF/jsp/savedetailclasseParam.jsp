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

        <title>Parametrage Classe</title>

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="css/themify-icons.css" rel="stylesheet">
    <link href="css/sb-admin.css" rel="stylesheet">
      <link rel="stylesheet" href="css/shards.min.css">
        <link rel="stylesheet" href="css/shards-demo.css?v=1.1.0">
        <link rel="stylesheet" href="./css/cardeffects.css">
         <link rel="shortcut icon" href="images/webIcone.jpg"/>

        <%@include file="HeaderUser.jsp" %>




    </head>

    <body id="page-top">


        
      





        <div id="wrapper">

            <div class="content-wrapper" style="    margin: auto;">

                <div id="cards" class="container mb-2 " style="padding-bottom: 1px ; ">


                    <div class="example col-md-12 ml-auto mr-auto">
                        <div class="row " style="margin-top: -10px;" >

                            <div class="card card-signin mx-auto mt-5" style="margin-top: -15px;">
                                <div class="card-header" style="text-align: center;background-color: #fff;color:#1f72b8;">

                                    <span style="font-family: dax-bold;   font-size: 2rem;">

                                    

                                                  <span > Parametrage ${classes.description}  </span>   
                                        


                                    </span>  </div>
                                <div class="card-body">
                                    <div class="page-header">
                                        <div class="ibox flex-1">
                                            <div class="ibox-body">
                                                <div class="flexbox" style="text-align: center;">
                                                    <div class="flexbox-b">
                                                        <div class="ml-5 mr-5">
                                        
                                                                <span class="ti-settings" style="font-size: 3.8em;"></span>
                                                       
                                                           
                                                        </div>

                                              

                                                        <div>

                                                       


                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                                <li class="nav-item">
                                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true"><span class="ti-info"></span>INFORMATIONS </a>
                                                </li>
                                             

                                            </ul>
                                        </div>
                                    </div>
                                    <div class="tab-content" id="myTabContent">
                                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                            <form method="POST">
                                            <div class="row">

                                                <p style="visibility: hidden;">onsequat laborum incididunt adipiscing ut consectetur dolor voluptate non est ex dolore voluptate fugiat adipiscing qui deserunt nisi magna irure tempor non cupidatat amet fugiat est ad sint adipiscing
                                                </p>
                                                <div class="col-6 text-muted"> Date Ouverture:</div>
                                                <div class="col-6">${ouverture}</div>

                                                <div class="col-6 text-muted">Duree  :</div>
                                                <div class="col-6">${mois}</div>



                                                <div class="col-6 text-muted">Incription :</div>
                                                <div class="col-6">${inscription}</div>


                                                  <div class="col-6 text-muted">Mensualite :</div>
                                                <div class="col-6">${mensualite}</div>
                                                <input type="text" name="idDroit" value="${idDroit}" hidden="">
                                                    <input type="text" name="idClasse" value="${idClasse}" hidden="">

                                                <br><br>
                                             
                                                
                                                                     <div  class="col-6 text-muted">       
                                                                  <button type="submit" class="btn btn-primary" style="background-color:#1B81C5; font-family: titilliumWeb-regular;">
                                                            <i class="ti-save">

                                                            </i> Enregistrer</button>
                                                    </div>
                                                
                                                 <div class="col-6 text-muted">   <button type="reset" class="btn btn-secondary" style="background-color:#5a6169; font-family: titilliumWeb-regular;">
                                                    <div class="form-label-group">
                                                        <a class="ti-back-left" style="background-color: #5a6169; color: #fff;"href=directeur.htm>Retour</a> 
                                                    </div></button></div>





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
                        .col-6 {
    font-family: titilliumWeb-light;
   font-size: 1.3em;
}

  input[type=number]::-webkit-inner-spin-button, 
    input[type=number]::-webkit-outer-spin-button { 
        -webkit-appearance: none; 
        margin: 0; 
    }
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
        <script src="./js/bootstrap.min.js" ></script>
        <script src="js/demo.min.js"></script>
        <script src="js/shards.min.js"></script>


        <script src="js/sb-admin.min.js"></script>

    </body>

</html>
