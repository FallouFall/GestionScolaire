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

          <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/webIcone.jpg"/>
        <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link rel="stylesheet" href="css/shards.min.css">
        <link rel="stylesheet" href="css/shards-demo.css?v=1.1.0">
        <link rel="stylesheet" href="css/cardeffects.css">
        <link rel="stylesheet" href="./css/themify-icons.css">



    </head>

    <body>

        <%@include file="Header.jsp" %>


    </div>
    
    <div id="wrapper">



        <div id="content-wrapper">

            <div class="container-fluid ">


                <div class="container" style="margin-top: -30px">

                    <div class="card card-login mx-auto mt-5 " style="    box-shadow: none;  text-align: center;">
                        <div class="card-header" style="background-color: rgba(12,12,12,0.0); ">
                            <span class="ti-rss-alt slide-in"  style="font-size: 4em; color: #5a6169; "></span>
                        </div>
                        <h4 class="slide-in"  style="font-family: titilliumWeb-regular;">Bienvenue</h4>
                        <div class="card-body">

                            <form method="POST">

                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input type="email" id="inputEmail"  required="true" class="form-control" placeholder="Username" name="username"  autofocus="autofocus">
                                        <label for="inputEmail">Email address</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="form-label-group">
                                        <input type="password" id="inputPassword" required="true" name="password" class="form-control" placeholder="Password" >
                                        <label for="inputPassword">Password</label>
                                    </div>
                                </div>



                                   <div class="form-group">
                                    <div class="form-label-group">   
                                        <button type="submit" class="btn btn-primary" style="background-color: #0272bd   ;">
                                        <i class="ti-world">

                                        </i> Connecter</button>
                                </div> 
                                   </div>


                            </form>
                            <br>
                            <div class="text-center">

                                <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                        </div>
                    </div>
                </div>




            </div>
            <!-- /.container-fluid -->

            <!-- Sticky Footer -->

            <footer class="sticky-footer" style="background-color: rgba(12,12,12,0.0); width: 100%;">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span style="font-family: titilliumWeb-light;">Copyright © Fallou Fall 2019</span>
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
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

<script src="vendor/jquery/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js" ></script>
        <script src="js/demo.min.js"></script>
        <script src="js/shards.min.js"></script>
    
        <script src="js/sb-admin.min.js"></script>
  


</body>
<style>
   
    .input{
        border-right: 2em;
    }
</style>
</html>
