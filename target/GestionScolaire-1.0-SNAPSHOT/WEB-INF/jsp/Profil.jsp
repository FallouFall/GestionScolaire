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

        <title>Centre Administration</title>


        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/sb-admin.css" rel="stylesheet">

        <%@include file="HeaderUser.jsp" %>




    </head>

    <body id="page-top">


        <%
            String userName = null;
            Cookie[] cookies = request.getCookies();
            
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        userName = cookie.getValue();
                    }

                }
            }
            if (userName == null) {
                response.sendRedirect("index.htm");
            }
        %>





        <div id="wrapper">
            
            <div class="form-label-group" style="margin-top: 100px;margin-left: 50px;position: absolute;font-size: 1.3em;">
           <a class="ti-back-left" style="color: #1f72b8;text-decoration: none;" href="${url}">  Retour</a> 
      
     </div>
            <div class="content-wrapper" style="    margin: auto;">
  
                <div id="cards" class="container mb-2 " style="padding-bottom: 1px ; ">


                    <div class="example col-md-12 ml-auto mr-auto">
                        <div class="row " style="margin-top: -10px;" >

                            <div class="card card-signin mx-auto mt-5" style="margin-top: -15px;">
                                <div class="card-header" style="text-align: center;background-color: #fff;color:#1f72b8;">

                                    <span style="font-family: dax-bold;    font-size: 2rem;">
                                        Mon Profil


                                    </span>  </div>
                                <div class="card-body">
                                    <div class="page-header">
                                        <div class="ibox flex-1">
                                            <div class="ibox-body">
                                                <div class="flexbox" style="text-align: center;">
                                                    <div class="flexbox-b">
                                                        <div class="ml-5 mr-5">
                                                          <c:if test="${photo != null}">
                                                              <img alt="" class="image--cover "  style="  width: 100px;
                                                       height: 100px;"src="data:image/jpeg;base64,${photo} " >
                                                     </c:if>
                                                          
                                                    <c:if test="${photo == null}">
                                                        <span class="ti-user" style="font-size: 3.8em;"></span>
                                                    </c:if>
                                                   
                                                        </div>
                                                      
                                                        <span style="font-size: 2em">${user}</span>   
                                                      
                                                        <div>
                                                           
                                                            <div class="text-muted font-13 mb-3">
                                                                <span class="mr-3"><i class="ti-location-pin mr-2"></i>${adresse}</span>
                                                                <span><i class="ti-calendar mr-2"></i>12.04.2018</span>
                                                            </div>
                                                               <div class="form-label-group">
                                                                   <a class="ti-reload" style="color: #1f72b8;" href="updateUser.htm">  Modifier</a> 
                                                              </div>

                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                                <li class="nav-item">
                                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">INFORMATION GENERALE</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">DESCRIPTION</a>
                                                </li>

                                            </ul>
                                        </div>
                                    </div>
                                    <div class="tab-content" id="myTabContent">
                                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                             <div class="row">
                                         
                                                <div class="col-6 text-muted">Telephone :</div>
                                                <div class="col-6">${telephone}</div>
                                       

                                         
                                                <div class="col-6 text-muted">Fonction :</div>
                                                <div class="col-6">${profil}</div>
                                                
                                                  <div class="col-6 text-muted">Login :</div>
                                                <div class="col-6">${login}</div>
                                           
                                         
                                                <div class="col-6 text-muted">Password :</div>
                                                <div class="col-6">${password}</div>
                                       

                                         
                                          
                                        </div>
                                    </div>
                                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">   <p>Lorem Ipsum Aliqua id consequat laborum incididunt adipiscing ut consectetur dolor voluptate non est ex dolore voluptate fugiat adipiscing qui deserunt nisi magna irure tempor non cupidatat amet fugiat est ad sint adipiscing
                                                est officia cillum consectetur reprehenderit non.</p></div>

                                    </div>

                                </div>
                            </div>


                        </div>
                    </div>
                </div>



            </div>

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
