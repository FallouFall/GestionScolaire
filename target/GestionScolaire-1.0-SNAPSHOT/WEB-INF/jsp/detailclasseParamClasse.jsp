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

                                    

                                                  <span > Parametrage  de la classe ${classes.description} </span>   
                                        


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
                                                <li class="nav-item">
                                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false"><span class="ti-pencil-alt"></span> INSCRIPTION</a>
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
                                                <div class="col-6">${classes.matricule}</div>

                                                <div class="col-6 text-muted">Nom :</div>
                                                <div class="col-6">${classes.nom}</div>



                                                <div class="col-6 text-muted">Date :</div>
                                                <div class="col-6">${classes.creation}</div>




                                               

                                                <br><br>
                                                 <div class=" form-group col-md-6">   
                                         <button type="reset" class="btn btn-secondary" style="background-color: #5a6169; font-family: titilliumWeb-regular;">
                                                            <div class="form-label-group">
                                                                <a class="ti-angle-double-left" style="background-color: #5a6169; color: #fff;" href="directeur.htm">  Retour</a> 
                                                   </div></button>
                                                    </div>

                                                



                                            </div>
                                        </div>
                                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">

                                            
                                            
                                            <div class="row">

                                                <p style="visibility: hidden;">onsequat laborum incididunt adipiscing ut consectetur dolor voluptate non est ex dolore voluptate fugiat adipiscing qui deserunt nisi magna irure tempor non cupidatat amet fugiat est ad sint adipiscing
                                                </p>
                                                <div class="col-6 text-muted" hidden="">Matricule:</div>
                                                <div class="col-6" hidden=""></div>

                                                <div class="col-6 text-muted" hidden="">Nom :</div>
                                                <div class="col-6" hidden=""></div>



                                                <div class="col-6 text-muted" hidden="">Date :</div>
                                                <div class="col-6"hidden="">2019-06-04</div>




                                               

                                                <br><br>
                                              





                                            
                                            
                                            
                                                <form method="POST">
                                                <div class="form-group">
                                                <div class="form-row">

                                                    
                                                         
                                                <div class="form-group col-md-6 ">
                                                    <div class="input-group with-addon-icon-left">
                                                      
                                                        <input type="text" class="form-control " hidden="">
                                                    </div>
                                                </div> 
                                                    
                                                    
                                                    <div class="form-group col-md-6 ">
                                                    <div class="input-group with-addon-icon-left">
                                                      
                                                        <input type="text" class="form-control " hidden="">
                                                    </div>
                                                </div>
                                                    
                                                 
                                                     <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="text" class="form-control" name="ouverture" id="datepicker-example-1" placeholder="Date d'Ouverture" >
                                                            <span class="input-group-addon">
                                                                <i class="ti-calendar"></i>
                                                            </span>
                                                        </div>
                                                    </div>



                                                

                                                    
                                                      <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="number" class=" classe form-control"  name="nbmois"  id="nbr mois" placeholder="Nbr de mois " >
                                                            <span class="input-group-addon">
                                                                <i class="ti-bookmark-alt"></i>
                                                            </span>
                                                        </div>
                                                    </div>
                                                
                                                  <div class="form-group col-md-6 ">
                                                    <div class="input-group with-addon-icon-left">
                                                      
                                                        <input type="text" class="form-control " hidden="">
                                                    </div>
                                                </div> 
                                                  

                                        

                                  
                                                    
                                                    
                                                    
                                                             <div class="form-group col-md-6 ">
                                                        <div class="input-group with-addon-icon-left">
                                                          
                                                            <input type="text" class="form-control " hidden="" id="id" name="idClasse" value="${idclasse}" >
                                                        </div>
                                                    </div>
                                                      



                                                    <div class=" form-group col-md-6">       
                                                        <button type="submit" class="btn btn-primary" style="background-color:#1B81C5; font-family: titilliumWeb-regular;">
                                                            <i class="ti-plus">

                                                            </i> Ajouter</button>
                                                    </div>
                                               <div class=" form-group col-md-6">   
                                         <button type="reset" class="btn btn-secondary" style="background-color: #5a6169; font-family: titilliumWeb-regular;">
                                                            <div class="form-label-group">
                                                                <a class="ti-angle-double-left" style="background-color: #5a6169; color: #fff;" href="directeur.htm">  Retour</a> 
                                                   </div></button>
                                                    </div>




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
