<%-- 
    Document   : GererAdmini
    Created on : 25 nov. 2018, 15:10:14
    Author     : Fallou
--%>



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

        <title>Programme</title>


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


        <%@include  file="HeaderUser.jsp" %>


        <div id="wrapper">

            <!-- Sidebar -->

            <ul class="sidebar navbar-nav" >




                <li class="nav-item" style="margin-top: 20px;" >
                    <a class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">

                        <i class="fas fa-bars">    </i>

                    </a>
                </li>





                <li class="nav-item">
                    <a class="nav-link" href="directeur.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="#">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Tables</span></a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#addToProgramme">
                        <i class="fas fa-plus"></i>
                        <span>Ajouter </span></a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">






                    <!-- DataTables Example -->
                    <div class="card mb-3 ">
                        <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">

                            <span style="font-family: dax-bold;    font-size: 2rem;">
                                Programme ${classe} 


                            </span>  </div>

                        <div class="card-body">


                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" >
                                    <thead>
                                        <tr  style="text-align: center;vertical-align: middle;">


                                            <th>Matricule</th>
                                            <th>Heures</th>
                                            <th>Matiere</th>
                                                  <th>Choisir</th> 


                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr style="text-align: center;vertical-align: middle;">



                                            <th>Matricule</th>
                                            <th>Heures</th>
                                            <th>Matiere</th>
                                                  <th>Choisir</th> 
                                             





                                        </tr>
                                    </tfoot>
                                    <tbody>

                                        <c:forEach var="element" items="${programme}">
                                                 <c:url var="link" value="plageHoraire.htm">

                                                <c:param name="idMatiere" value="${element.idmatiere.id}"/>
                                                 <c:param name="nomMatiere" value="${element.idmatiere.nom}"/>
                                                 <c:param name="idClasse" value="${idClasse}"/>
                                                  <c:param name="classe" value="${classe}"/>
                                                
                                            </c:url>
                                            <tr style="text-align: center;vertical-align: middle;">


                                                <td>${element.idmatiere.matricule}</td>
                                                <td>${element.heures}</td>
                                                <td>${element.idmatiere.nom}</td>
                                                  <td>  <div class="form-label-group">
                                                            <a href="${link}" class="ti-plus"></a>
                                                        </div></td>



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


        <!-- Bootstrap core JavaScript-->


        <div class="modal fade" id="addToProgramme"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header" >
                        <h5 class="modal-title" id="exampleModalLabel">Ajouter une matiere</h5>
                        <br><br>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">

                        </button>

                    </div>
                    <div id="content-wrapper">

                        <div class="container-fluid">
                            <div class="example col-md-12 ml-auto mr-auto">
                                <div class="row " >
                                    <form method="POST">
                                        <br>
                                        <div class="form-group">
                                            <div class="form-row">


                                                <div class=" form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <input type="text" class=" filiere form-control" name="nomMatiere" id="filiere" placeholder="Filiere"  required="true">
                                                        <span class="input-group-addon">
                                                            <i class="ti-layout"></i>
                                                        </span>
                                                    </div>
                                                </div>



                                                <div class="form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <span class="input-group-addon">
                                                            <i class="ti-time"></i>
                                                        </span>
                                                        <input type="text" class="form-control"  name="heures" id="descriptionMatiere" placeholder="Nombres d'heures" required="true">
                                                    </div>
                                                </div>



                                                <div class=" form-group col-md-6">       
                                                    <button type="submit" class="btn btn-primary">
                                                        <i class="ti-save">

                                                        </i> Enregistrer</button>
                                                </div>
                                                <div class=" form-group col-md-6">   
                                                    <button type="reset" type="button" data-dismiss="modal" class="btn btn-secondary">
                                                        <i class="ti-trash">

                                                        </i> Annuler</button>
                                                </div>
                                            </div>
                                        </div>

                                    </form>
                                    <br>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <c:forEach var="element" items="${matiere}">

        <tr style="text-align: center;vertical-align: middle;">


            <td>${element.matricule}</td>
            <td>${element.nom}</td>
            <td>${element.creation}</td>
            <td>${element.description}</td>





        </tr>

    </c:forEach>
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
    <script src="js/bootstrap3-typeahead.js"></script>
    <script>
        var $input = $(".filiere");
        $input.typeahead({
            source: [
        <c:forEach var="element" items="${matieres}">
                {id: '${element.matricule}', name: '${element.nom}'},
        </c:forEach>

            ],
            autoSelect: true
        });
        $input.change(function () {
            var current = $input.typeahead("getActive");
            if (current) {

                if (current.name == $input.val()) {
                    console.log(current['name']);
                } else {
                    // This means it is only a partial match, you can either add a new item
                    // or take the active if you don't want new items
                }
            } else {
                // Nothing is active so it is a new value (or maybe empty value)
            }
        });
    </script>


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
        .table-responsive {
    font-family: dax;
    
}
         table.table-bordered.dataTable tbody th, table.table-bordered.dataTable tbody td {
  
    font-family: titilliumWeb-regular;
}


    </style>



</body>

</html>
