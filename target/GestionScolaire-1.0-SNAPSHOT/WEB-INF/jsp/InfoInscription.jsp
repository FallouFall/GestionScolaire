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

        <title>Inscription</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/themify-icons.css" rel="stylesheet">

      <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="css/shards.min.css">
        <link rel="stylesheet" href="css/shards-demo.css?v=1.1.0">
        <link rel="stylesheet" href="./css/cardeffects.css">
        <link rel="shortcut icon" href="images/webIcone.jpg"/>

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
                    <a class="nav-link" href="#">
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
 <ol class="breadcrumb" style="font-family: dax-bold;
                            box-shadow: 0 0.46875rem 2.1875rem rgba(90,97,105,.1), 0 0.9375rem 1.40625rem rgba(90,97,105,.1), 0 0.25rem 0.53125rem rgba(90,97,105,.12), 0 0.125rem 0.1875rem rgba(90,97,105,.1);
                            background-color: #fff;border-radius: 10px;color: #1f72b8; margin-top: 5px;
                            ">
                            <li class="breadcrumb-item">
                                 <span>Annee : ${annee}  <span class="ti-arrow-right" style="color: #5a6169;"> </span> Etudiant : ${matriculeEtu} <span class="ti-arrow-right" style="color: #5a6169;"> </span>  Domaine : ${dmn}<span class="ti-arrow-right" style="color: #5a6169;"> </span>   Formation : ${frn} <span class="ti-arrow-right" style="color: #5a6169;"> </span>  Cycle : ${cyn} <span class="ti-arrow-right" style="color: #5a6169;"> </span> Filiere : ${filiere} <span class="ti-arrow-right" style="color: #5a6169;"> </span> Classe : ${classe}</span>
                            </li>
                           

                        </ol>

                    <div id="cards" class="container mb-2 " style="padding-bottom: 1px ;margin-top: -40px; ">


                        <div class="example col-md-12 ml-auto mr-auto">
                            <div class="row " >

                                <div class="card card-signin mx-auto mt-5">
                                     <div class="card-header" style="text-align: center;background-color: #fff;color:#1f72b8;">
                          
                            <span style="font-family: dax-bold;    font-size: 2rem;">
                           Inscription 
                                  

                            </span>  </div>
                                    <div class="card-body">
                                           <form method="POST">
                                            <div class="form-group">
                                                <div class="form-row">



                                                    <div class="form-group col-md-6 ">
                                                        <div class="input-group with-addon-icon-left">
                                                            <span class="input-group-addon">
                                                                <i class="ti-user"></i>
                                                            </span>
                                                            <input type="text" name="nom" class="form-control " id="nom" placeholder="Nom" required="true">
                                                        </div>
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="text" class="form-control" name="prenom" id="prenom" placeholder="Prenom" required="true">
                                                            <span class="input-group-addon">
                                                                <i class="ti-user"></i>
                                                            </span>
                                                        </div>
                                                    </div>

                                                    <div class="form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <span class="input-group-addon">
                                                                <i class="ti-home"></i>
                                                            </span>
                                                            <input type="text" class="form-control" name="adresse" id="adresse" placeholder="Adresse" required="true">
                                                        </div>
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="email" class="form-control"  name="mail" id="inputEmail4" placeholder="Email">
                                                            <span class="input-group-addon">
                                                                <i class="ti-email"></i>
                                                            </span>
                                                        </div>
                                                    </div>
                                                                                              <div class=" form-group col-md-6"> 
                                                        <fieldset>
                                                            <select class="custom-select w-100" name="genre" required="true">

                                                                <option value="" >Genre</option>
                                                                <option value="Masculin">Masculin</option>
                                                                <option value="Feminin">Feminin</option>
                                                            </select>
                                                        </fieldset>
                                                    </div>

                                                    <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="text"  class="form-control" name="info" id="info" placeholder="Info Supp" >
                                                            <span class="input-group-addon">
                                                                <i class="ti-calendar"></i>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="text" class="form-control" name="naissance" id="datepicker-example-1" placeholder="Date de Naissance" >
                                                            <span class="input-group-addon">
                                                                <i class="ti-calendar"></i>
                                                            </span>
                                                        </div>
                                                    </div>

                                                    <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="number" class="form-control" name="telephone" id="telephone" placeholder="Telephone"    >
                                                            <span class="input-group-addon">
                                                                <i class="ti-mobile"></i>
                                                            </span>
                                                        </div>
                                                    </div>
                                                
                                                   






                                                    <div class=" form-group col-md-6">       
                                                        <button type="submit" class="btn btn-primary">
                                                            <i class="ti-save">

                                                            </i> Enregistrer</button>
                                                    </div>
                                                    <div class=" form-group col-md-6">   
                                                        <button type="reset"  class="btn btn-secondary">
                                                            <i class="ti-trash">

                                                            </i> Annuler</button>
                                                    </div>





                                                </div>
                                            </div>







                                        </form>

                                </div>

   <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                     
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current sessionsss.</div>
                    <div class="modal-footer">
                        <form method="POST">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    
                        <button type="submit" class="btn btn-primary">Logout</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                            </div>
                        </div>
                    </div>


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

    
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js" ></script>
        <script src="js/demo.min.js"></script>
        <script src="js/shards.min.js"></script>


        <script src="js/sb-admin.min.js"></script>
<style>
    input[type=number]::-webkit-inner-spin-button, 
    input[type=number]::-webkit-outer-spin-button { 
        -webkit-appearance: none; 
        margin: 0; 
    }
  
</style>

    </body>

</html>
