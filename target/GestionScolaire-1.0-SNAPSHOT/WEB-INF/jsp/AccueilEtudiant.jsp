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
          <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/shards.min.css">
        <link rel="shortcut icon" href="images/webIcone.jpg"/>
        <link rel="stylesheet" href="./css/cardeffects.css">

      



    </head>

    <body id="page-top">

        <%@include  file="HeaderUser.jsp" %>


        <div id="wrapper">
            <div id="content-wrapper">

                <div class="container-fluid ">


                    <section id="team" class="pb-5 " style="margin-top: -30px;">


                        <div class="row" style="margin-bottom: -100px; margin-top: 3px;">
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="#"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p>     <span class="ti-timer "   style="font-size: 3em;"></span></p>
                                            <h4 class="card-title">Emploi du temps</h4>


                                        </div>
                                    </div>
                                </div>
                                    </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="#"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p>     <span class="ti-calendar"   style="font-size: 3em;"></span></p>
                                                <h4 class="card-title">Calendrier</h4>


                                        </div>
                                    </div>
                                </div>
                                    </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="#"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p> <span class="ti-pencil-alt" style="font-size: 3em;"  ></span></p>
                                            <h4 class="card-title">Notes</h4>


                                        </div>
                                    </div>
                                </div>
                                </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="GradeBook.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card " >
                                        <div class="card-body text-center">
                                            <p>    <span class="ti-money"style="font-size: 3em;"  ></span></p>
                                            <h4 class="card-title">Payement</h4>


                                        </div>
                                    </div>
                                </div>
                                   </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            
                                <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="#"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p>   <span class="ti-files" style="font-size: 3em;" ></span></p>
                                            <h4 class="card-title">Documents</h4>


                                        </div>
                                    </div>
                                </div>
                                   </a>


                            </div>
                            
                            
                            
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="#"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p>      <span class="ti-stats-up"  style="font-size: 3em;"></span></p>
                                            <h4 class="card-title">Statistiques</h4>


                                        </div>
                                    </div>
                                </div>
                                </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                        
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
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="index.htm">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->

        
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
     <style>
            .modal-header{
             background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%
                 ,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);
          
             
            }
         
            .modal-title{
                font-family: dax-bold;    font-size: 1.4rem;
                color: #fff;
            }
            .modal-content{
                margin-top: 100px;
            }
        </style>
    </body>

</html>
