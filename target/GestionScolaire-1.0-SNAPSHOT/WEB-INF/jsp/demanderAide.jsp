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

        <title>Ajout Comptable</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/themify-icons.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="css/shards.min.css">
        <link rel="stylesheet" href="css/shards-demo.css?v=1.1.0">
        <link rel="stylesheet" href="./css/cardeffects.css">
        <link rel="shortcut icon" href="images/webIcone.jpg"/>
          <script src="js/popper.js"></script>

    </head>

    <body id="page-top" >
      <%
String userName = null;
Cookie[] cookies = request.getCookies();

if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
      
}
}
if(userName == null) response.sendRedirect("index.htm");
%>

        <%@include file="HeaderUser.jsp" %>

        <div id="wrapper">

            <!-- Sidebar -->
         

 <ul class="sidebar navbar-nav" >
<li class="nav-item" >
                    <a class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">

                        <i class="fas fa-bars">    </i>

                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="etudiant.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-plus"></i>
                        <span>Ajouter </span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="aide.htm">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Tables</span></a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">



                                <div class="card mb-3">
                                    <div class="card-header" style="text-align: center;background-color: #fff;color:#1f72b8;">
                          
                            <span style="font-family: dax-bold;    font-size: 2rem;">
                          Questions & Reclamations
                                  

                            </span>  </div>
                                    <div class="card-body">
                                        <form method="POST">
                                            <div class="form-group">
                                                <div class="form-row">




                                                    <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="text" class="form-control" minlength="10" maxlength="100"  name="question" id="question" placeholder="Soyez Precis avec Votre Question" required="true" >
                                                            <span class="input-group-addon">
                                                                <i class="ti-lock"></i>
                                                            </span>
                                                        </div>
                                                    </div> 
                                                    
                                                     <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="text" class="form-control" minlength="10" maxlength="100"  name="em" id="em" placeholder="Soyez Precis avec Votre Question" value="${id}" hidden="" >
                                                            <span class="input-group-addon">
                                                              
                                                            </span>
                                                        </div>
                                                    </div> 
                                                    

                                                    
                                                    <div class=" form-group col-md-6">       
                                                                  <button type="submit" class="btn btn-primary" style="background-color:#1B81C5; font-family: titilliumWeb-regular;">
                                                            <i class="ti-save">

                                                            </i> Enregistrer</button>
                                                    </div>
                                               
                                            </div>




                                            </div>


                                        </form>

                                    </div>
                                </div>


                      
                      
             


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

    input[type=number]::-webkit-inner-spin-button, 
    input[type=number]::-webkit-outer-spin-button { 
        -webkit-appearance: none; 
        margin: 0; 
    }

        </style>

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js" ></script>
        <script src="js/demo.min.js"></script>
        <script src="js/shards.min.js"></script>


        <script src="js/sb-admin.min.js"></script>





    </body>

</html>
