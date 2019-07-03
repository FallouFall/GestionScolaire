<%-- 
    Document   : GererAdmini
    Created on : 25 nov. 2018, 15:10:14
    Author     : Fallou
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="css/toastNotification.css">
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js" ></script>


    </head>

    <body >

        <%@include file="Header.jsp" %>


    </div>

    <div id="wrapper">



        <div id="content-wrapper">

            <div class="container-fluid ">


                <div class="container" style="margin-top: -30px">



                    <div class="card card-login mx-auto mt-5 " style="    box-shadow: none;  text-align: center;">

                      
                        <div class="card-body">

                            <form method="POST">


                                <br>
                                <div class="form-group">
                                    <div class="input-group with-addon-icon-left">
                                        <span class="input-group-addon">
                                            <i class="ti-user"></i>
                                        </span>
                                        <input type="email" class="form-control "  value=""  name="username" id="nom" placeholder="E-Mail" required="true" minlength="2" maxlength="30">
                                    </div>
                                </div>
                                    
                                    
                                       <div class="form-group">
                                    <div class="input-group with-addon-icon-left">
                                        <span class="input-group-addon">
                                            <i class="ti-user"></i>
                                        </span>
                                        <input type="text" class="form-control "  value=""  name="matricule" id="nom" placeholder="Matricule" required="true" minlength="2" maxlength="30">
                                    </div>
                                </div>

                           



                                <br>
                                <div class="form-group">
                                    <div class="form-label-group">   
                                        <button type="submit" class="btn btn-primary"   style="background-color: #0272bd   ;">
                                            <i class="ti-search">

                                            </i> Aide-Moi </button>  
                                    <button type="reset" class="btn btn-secondary">
                                                            <i class="ti-trash">
                                </i> <a href="index.htm" style="color: #fff;"> Annuler</a></button>
                                    </div>
                                </div>
                                


                            </form>
                        
                               <c:if test="${not empty error}">
                                   <span   style="color: #5a6169;font-family: titilliumWeb-light;font-size: 1.3em;">
                                    
                                       <span style="color: #1f72b8;"> ${error}</span>  
                                   </span>
                         
                            </c:if>
                              <c:if test="${ empty error}">
                                   <span   style="color: #5a6169;font-family: titilliumWeb-light;font-size: 1.3em;">
                                    
                                      ${error}
                                    
                                   </span>
                         
                            </c:if>
                         
                         
                            <br>
                      


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
    <script src="/js/toast.js"></script>
    <script src="js/sb-admin.min.js"></script>
    <script>
                                    function launch_toast() {
                                        var x = document.getElementById("toast");
                                        x.className = "show";
                                        setTimeout(function () {
                                            x.className = x.className.replace("show", "");
                                        }, 5000);
                                    }
    </script>



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
