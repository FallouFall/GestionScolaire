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
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/webIcone.jpg"/>

      



    </head>

    <body id="page-top">
        
        
     
      
        <%@include file="HeaderUser.jsp" %>


        <div id="wrapper">
            <div id="content-wrapper">

                <div class="container-fluid ">


                    <section id="team" class="pb-5 " style="margin-top: -30px;">


                        <div class="row" style="margin-bottom: -100px; margin-top: 3px;">
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="GererAdmin.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p>     <span class="ti-settings "   style="font-size: 3em;"></span></p>
                                            <h4 class="card-title">Administrateurs</h4>


                                        </div>
                                    </div>
                                </div>
                                    </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="GererProfesseur.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p>     <span class=" ti-id-badge"   style="font-size: 3em;"></span></p>
                                            <h4 class="card-title">Professeurs</h4>


                                        </div>
                                    </div>
                                </div>
                                    </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="GererSecretaire.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p> <span class="ti-headphone-alt" style="font-size: 3em;"  ></span></p>
                                            <h4 class="card-title">Secretaires</h4>


                                        </div>
                                    </div>
                                </div>
                                </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="GererComptable.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card " >
                                        <div class="card-body text-center">
                                            <p>    <span class="ti-stats-up"style="font-size: 3em;"  ></span></p>
                                            <h4 class="card-title">Comptables</h4>


                                        </div>
                                    </div>
                                </div>
                                   </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="GererDirecteur.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p>      <span class="ti-eye"  style="font-size: 3em;"></span></p>
                                            <h4 class="card-title">Directeurs</h4>


                                        </div>
                                    </div>
                                </div>
                                </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="GererRessources.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p>   <span class="ti-server" style="font-size: 3em;" ></span></p>
                                            <h4 class="card-title">Ressources</h4>


                                        </div>
                                    </div>
                                </div>
                                   </a>


                            </div>
                            <!-- ./Team member -->

                        </div>

                    </section>


                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->

                <footer class="sticky-footer" style="background-color: rgba(12,12,12,0.0); margin: 10px; width: 100%;">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span style="font-family: titilliumWeb-light;" >Copyright © Fallou Fall 2019</span>
                        </div>
                    </div>
                </footer>
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
