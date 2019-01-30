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

    <title>Gestion des Secretaires</title>

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

  <body id="page-top">

      <%@include file="HeaderUser.jsp" %>

    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav" >
        <li class="nav-item">
          <a class="nav-link" href="#">
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
          <a class="nav-link" href="AjouterSecretaire.htm">
            <i class="fas fa-plus"></i>
            <span>Ajouter </span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="GererSecretaire.htm">
            <i class="fas fa-fw fa-table"></i>
            <span>Tables</span></a>
        </li>
      </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

                  <div class="loader"><div class="page-loader"></div></div>
                
          <!-- DataTables Example -->
          <div class="card mb-3 ">
                    <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">
                          
                            <span style="font-family: dax-bold;    font-size: 2rem;">
                              Secretaire
                                  

                            </span>  </div>
                 
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr  style="text-align: center;vertical-align: middle;">
                                          <th></th>
                                              <th>Matricule</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Adresse</th>
                                            <th>Telephone</th>
                                            <th>Modifier</th>

                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr style="text-align: center;vertical-align: middle;">
                                            <th></th>
                                            <th>Matricule</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Adresse</th>
                                            <th>Telephone</th>
                                            <th>Modifier</th>



                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="element" items="${liste}">

                                            <tr style="text-align: center;vertical-align: middle;">

                                                <td> 
                                                    <c:if test="${element.imageId != null}">
                                                          <img alt="" class="image--cover" src="data:image/jpeg;base64,${element.imageId} " width="54">
                                                    </c:if>
                                                          
                                                    <c:if test="${element.imageId == null}">
                                                        <span class="ti-user" style="font-size: 3.8em;"></span>
                                                    </c:if>
                                                   

                                                </td>
                                                <td>${element.matricule}</td>
                                                <td>${element.nom}</td>
                                                <td>${element.prenom}</td>
                                                <td>${element.adresse}</td>
                                                <td>${element.telephone}</td>
                                                <td> <a class="ti-reload" href="update"></a> </td>



                                            </tr>

                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
           
          </div>


        </div>
        <!-- /.container-fluid -->

     

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
        <script src="./js/bootstrap.min.js" ></script>
        <script src="js/demo.min.js"></script>
        <script src="js/shards.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="vendor/datatables/jquery.dataTables.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
        <script src="js/sb-admin.min.js"></script>
        <script src="js/demo/datatables-demo.js"></script>


  </body>

</html>
