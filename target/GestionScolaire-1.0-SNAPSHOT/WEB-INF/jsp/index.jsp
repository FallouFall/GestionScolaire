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

        <title>Bienvenue</title>

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

    <body >

        <%@include file="Header.jsp" %>


    </div>

    <div id="wrapper">



        <div id="content-wrapper">

            <div class="container-fluid ">


                <div class="container" style="margin-top: -30px">

                    <div class="card card-login mx-auto mt-5 " style="    box-shadow: none;  text-align: center;">
                        <div class="card-header" style="background-color: rgba(12,12,12,0.0); ">
                            <span class="ti-face-smile slide-in" style="font-size: 3em; color: #1f72b8;"></span>
                        </div>
                        <h4 class="slide-in "  style="color: #54a2d9;font-family: titilliumWeb-light;font-size: 3em;"><b style="font-size: 1.5em;font-family: titilliumWeb-light; ">B</b>onjour</h4>
                        <div class="card-body">

                            <form method="POST">


                                <br>
                                <div class="form-group">
                                    <div class="input-group with-addon-icon-left">
                                        <span class="input-group-addon">
                                            <i class="ti-user"></i>
                                        </span>
                                        <input type="email" class="form-control "  value="${login}"  name="username" id="nom" placeholder="E-Mail" required="true" minlength="2" maxlength="30">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="input-group with-addon-icon-left">
                                        <span class="input-group-addon">
                                            <i class="ti-lock"></i>
                                        </span>
                                        <input type="password"   value="${password}" class="form-control " name="password" id="password" placeholder="Mot de passe" required="true" minlength="2" maxlength="30">
                                    </div>
                                </div>



                                <br>
                                <div class="form-group">
                                    <div class="form-label-group">   
                                        <button type="submit" class="btn btn-primary"  style="background-color: #0272bd   ;">
                                            <i class="ti-world">

                                            </i>Se Connecter</button>
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

            <footer class="sticky-footer" style=" width: 100%;background-color: #fff;   height: 120px;">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span style="font-family: titilliumWeb-light;margin-top: 20px;margin-left: -70px;position: absolute;">Copyright © Fallou Fall 2019</span>
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

    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="./js/bootstrap.min.js" ></script>
    <script src="js/demo.min.js"></script>
    <script src="js/shards.min.js"></script>

    <script src="js/sb-admin.min.js"></script>



</body>
<style>
    footer{
        background-image: url("images/footer.png");
        background-repeat: round;
        background-color: transparent;

        color: #fff;

    }
    .input{
        border-right: 2em;
    }
</style>
</html>
