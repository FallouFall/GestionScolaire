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
        <%
            String message = "BONJOUR";
            String login ;
            String password ;
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("MSG")) {
                        message = cookie.getValue();

                    }
                      if (cookie.getName().equals("login")) {
                        login = cookie.getValue();

                    }
                        if (cookie.getName().equals("password")) {
                        password = cookie.getValue();

                    }
                    

                }
            }

        %>

        <%@include file="Header.jsp" %>


    </div>

    <div id="wrapper">



        <div id="content-wrapper">

            <div class="container-fluid ">


                <div class="container" style="margin-top: -30px">



                    <div class="card card-login mx-auto mt-5 " style="    box-shadow: none;  text-align: center;">

                        <h4 class="slide-in "  style="color: #54a2d9;font-family: titilliumWeb-light;font-size: 2.5em;"><%= message%></h4>
                        <div class="card-body">

                            <form method="POST" >


                                <br>
                                <div class="form-group">
                                    <div class="input-group with-addon-icon-left">
                                        <span class="input-group-addon">
                                            <i class="ti-user"></i>
                                        </span>
                                        <input type="email" class="form-control "   value="${login}"  name="username" id="nom" placeholder="E-Mail" required="true" minlength="2" maxlength="30">
                                    </div>
                                </div>

                       <div class="form-group">
                                    <div class="input-group with-addon-icon-left">
                                        <span class="input-group-addon">
                                            <i class="ti-lock"></i>
                                        </span>
                                        <input type="password" class="form-control "   value="${password}"  name="password" id="password" placeholder="Mot de passe" required="true" minlength="2" maxlength="30">
                                    </div>
                                </div>



                                <br>
                                <div class="form-group">
                                    <div class="form-label-group">   
                                        <button type="submit" class="btn btn-primary"   style="background-color: #0272bd   ;">
                                            <i class="ti-world">

                                            </i>Se Connecter</button>


                                    </div>
                                </div>


                            </form>


                            <c:if test="${not empty error}">
                                <script>

                                    $(document).ready(function () {
                                        launch_toast();
                                    })
                                </script>


                                <div id="toast" ><div id="img"><i class="ti-key"></i></div><div id="desc"> ${error}</div></div>

                            </c:if>
                            <c:if test="${empty error}">



                            </c:if>
                            <br>
                            <div class="text-center">

                                <a class="" href="forget.htm"  style="font-family: titilliumWeb-light;">Mot De Passe Oublie ?</a>
                            </div>


                        </div>
                    </div>
                </div>




            </div>
            <!-- /.container-fluid -->

            <!-- Sticky Footer -->
<footer class="page-footer font-small special-color-dark pt-4">

  <!-- Footer Elements -->
  <div class="container" style="margin-top: 50px;">

    <!--Grid row-->
    <div class="row">

      <!--Grid column-->
      <div class="col-md-6 mb-4">

        <!-- Form -->
        <form class="form-inline">
          <div class="input-group with-addon-icon-left">
                                                            <input type="text" class="form-control" name="annee" id="datepicker-example-1" placeholder="2019" >
                                                            <span class="input-group-addon">
                                                                <i class="ti-calendar"></i>
                                                            </span>
                                                        </div>
        
        </form>
        <!-- Form -->

      </div>
      <!--Grid column-->

      <!--Grid column-->
      <div class="col-md-6 mb-4">

         <div class="footer-copyright text-center py-3" style="font-family: titilliumWeb-light;" > Copyright © Fallou Fall 2019
   
  </div>
  <!-- Copyright

      </div>
      <!--Grid column-->

    </div>
    <!--Grid row-->

  </div>
  <!-- Footer Elements -->
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
            $("#datepicker-example-1").datepicker({

                format: "yyyy",
                viewMode: "years",
                minViewMode: "years"
           
                
               
            });
        </script>
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
    .datepicker-dropdown {
  border-color: #54a2d9;
  
}
    body{
        overflow-y: hidden;
    }
    .form-control{
        font-family: titilliumWeb-regular;
    }
    footer{
        background-image: url("images/footer.png");
        background-repeat: round;
        background-color: transparent;
    height: 130px;
        color: #fff;
  position: fixed;
    bottom: 0;
    width: 100%;
    }
    .input{
        border-right: 2em;
    }
</style>
</html>
