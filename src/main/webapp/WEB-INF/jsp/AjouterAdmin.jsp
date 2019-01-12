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

        <title>SB Admin - Tables</title>
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
String userName = null;
Cookie[] cookies = request.getCookies();

if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
      
}
}
if(userName == null) response.sendRedirect("index.htm");
%>

        <nav class="navbar navbar-expand  static-top" style="    height: 12vh;background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);">

            <a class="navbar-brand mr-1" href="administration.htm" style="color: #fff;    font-family: titilliumWeb-italic; font-size: 4vh;   letter-spacing: .5rem; " >ISI</a>


            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">

                    <div class="input-group-append">

                    </div>
                </div>
            </form>

            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0" >

                <li class="nav-item dropdown no-arrow">
                   
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">

                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
                    </div>
                </li>
            </ul>

        </nav>

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav" >
                <li class="nav-item">
                    <a class="nav-link" href="GererAdmin.htm">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Tableau de bord</span>
                    </a>
                </li>


                <li class="nav-item">
                    <a class="nav-link" href="administration.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-plus"></i>
                        <span>Ajouter </span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="GererAdmin.htm">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Tables</span></a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">


                    <div id="cards" class="container mb-2 " style="padding-bottom: 1px  ">


                        <div class="example col-md-12 ml-auto mr-auto">
                            <div class="row " >

                                <div class="card card-signin mx-auto mt-5">
                                    <div class="card-header" style="text-align: center;background-color: #fff;color:#1f72b8;">
                          
                            <span style="font-family: dax-bold;    font-size: 2rem;">
                            Ajouter administrateur
                                  

                            </span>  </div>
                                    <div class="card-body">
                                        <form>
                                            <div class="form-group">
                                                <div class="form-row">



                                                    <div class="form-group col-md-6 ">
                                                        <div class="input-group with-addon-icon-left">
                                                            <span class="input-group-addon">
                                                                <i class="ti-user"></i>
                                                            </span>
                                                            <input type="text" class="form-control " id="nom" name="nom" placeholder="Nom" required="true">
                                                        </div>
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prenom" required="true">
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
                                                            <input type="email" class="form-control" name="mail" id="inputEmail4" placeholder="Email">
                                                            <span class="input-group-addon">
                                                                <i class="ti-email"></i>
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
                                                            <input type="number" class="form-control" id="telephone" name="telephone" placeholder="Telephone" min="6" max="9"      >
                                                            <span class="input-group-addon">
                                                                <i class="ti-mobile"></i>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="email" class="form-control" name="username" id="login" placeholder="Login"  required="true">
                                                            <span class="input-group-addon">
                                                                <i class="ti-link"></i>
                                                            </span>
                                                        </div>
                                                    </div>

                                                    <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="password" class="form-control" name="password"data-minlength="6" id="password" placeholder="Password" required="true" >
                                                            <span class="input-group-addon">
                                                                <i class="ti-lock"></i>
                                                            </span>
                                                        </div>
                                                    </div>



                                                    <div class=" form-group col-md-6">       
                         <button type="submit" class="btn btn-primary" style="background-color:#1B81C5; font-family: titilliumWeb-regular;">
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

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.html">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="js/sb-admin.min.js"></script>



        


    </body>

</html>
