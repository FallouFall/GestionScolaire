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

        <title>Professeur</title>


        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/webIcone.jpg"/>

      



    </head>
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
    <body id="page-top">

        <%@include file="HeaderUser.jsp" %>


        <div id="wrapper">
            <div id="content-wrapper">

                <div class="container-fluid ">


                    <section id="team" class="pb-5 " style="margin-top: -30px;">


                        <div class="row" style="margin-bottom: -100px; margin-top: 3px;">
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="programmeProf.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p>     <span class="ti-menu-alt "   style="font-size: 3em;"></span></p>
                                            <h4 class="card-title">Programme</h4>


                                        </div>
                                    </div>
                                </div>
                                    </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="coursProf.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p>     <span class="ti-book"   style="font-size: 3em;"></span></p>
                                                <h4 class="card-title">Cours</h4>


                                        </div>
                                    </div>
                                </div>
                                    </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="tableauProf.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p> <span class="ti-info-alt" style="font-size: 3em;"  ></span></p>
                                            <h4 class="card-title">Informations</h4>


                                        </div>
                                    </div>
                                </div>
                                </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="gererNote.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card " >
                                        <div class="card-body text-center">
                                            <p>    <span class="ti-clipboard"style="font-size: 3em;"  ></span></p>
                                            <h4 class="card-title">Notes</h4>


                                        </div>
                                    </div>
                                </div>
                                   </a>


                            </div>
                            <!-- ./Team member -->
                            <!-- Team member -->
                            
                                <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                                <a href="documentsProf.htm"  style="   text-decoration: none; color: #5a6169;">
                                <div class="frontside">
                                    <div class="card ">
                                        <div class="card-body text-center">
                                            <p>   <span class="ti-briefcase" style="font-size: 3em;" ></span></p>
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
      <a class="scroll-to-top rounded" href="#page-top">
            <i class="ti-angle-up"></i>
        </a>

      <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Se Deconnecter?</h5>
                        
                    </div>
                    <div class="modal-body" style=" font-family: titilliumWeb-regular;">
                        
                        <span  class="ti-alert" style="font-size: 1.5em;">
                            
                        </span>Voulez-Vous quitter ?</div>
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
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
     
    </body>

</html>
