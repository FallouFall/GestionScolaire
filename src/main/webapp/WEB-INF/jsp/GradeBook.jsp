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

    <body id="page-top">



        <%@include file="HeaderUser.jsp" %>
        <div id="wrapper">
            <ul class="sidebar navbar-nav" >
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Tableau de bord</span>
                    </a>
                </li>


                <li class="nav-item">
                    <a class="nav-link" href="professeur.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="ti-calendar"></i>
                        <span>Calendrier </span></a>
                </li>

            </ul>

            <div id="wrapper">



                <div id="content-wrapper">

                    <div class="container-fluid">
                        <div class="loader"><div class="page-loader"></div></div>
                            <c:if test="${findListEtudiants== null}">

                            <div class="card mb-3 " style=" margin-top: 5px;margin-left: 100px;">
                                <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">

                                    <span style="font-family: dax-bold;    font-size: 2rem;">
                                        Fiche de Notes
                                    </span> 
                                </div>
                                <div class="card-body">

                                    <form method="POST">
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class=" form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <input type="text" class=" filiere form-control" name="filiere" id="filiere" placeholder="Filiere"  required="true">
                                                        <span class="input-group-addon">
                                                            <i class="ti-layout"></i>
                                                        </span>
                                                    </div>
                                                </div>

                                                <div class=" form-group col-md-6">
                                                    <div class="input-group with-addon-icon-left">
                                                        <input type="text" class=" classe form-control"  name="classe" data-minlength="6" id="classe" placeholder="Classe" required="true" >
                                                        <span class="input-group-addon">
                                                            <i class="ti-bookmark-alt"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                                <div class=" form-group col-md-6">       
                                                    <button type="submit" class="btn btn-primary">
                                                        <i class="ti-search">

                                                        </i> Chercher</button>
                                                </div>


                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </c:if>




                        <c:if test="${findListEtudiants!= null}">
                            <div class="card mb-3 slide-in " id="ue" style=" margin-top: 17px;">
                                <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">

                                    <span style="font-family: dax-bold;    font-size: 2rem;">
                                        Notes         ${classe}   ${filiere} 


                                    </span>  </div>

                                <div class="card-body">


                                    <div class="table-responsive">
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                                <tr  style="text-align: center;vertical-align: middle;">

                                                    <th>Name</th>
                                                    <th>Note 1</th>
                                                    <th>Note 2</th>
                                                    <th>Note 3</th>
                                                    <th>Examen</th>



                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr style="text-align: center;vertical-align: middle;">

                                                    <th>Name</th>
                                                    <th>Note 1</th>
                                                    <th>Note 2</th>
                                                    <th>Note 3</th>
                                                    <th>Examen</th>




                                                </tr>
                                            </tfoot>
                                            <tbody>

                                                <c:forEach var="etud" items="${findListEtudiants}">


                                                    <tr>
                                                        <td>${etud} </td>
                                                        <td><input type="text" class="form-control" /></td>
                                                        <td><input type="text" class="form-control" /></td>
                                                        <td><input type="text" class="form-control" /></td>
                                                        <td><input type="text" class="form-control" /></td>

                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>

                        </c:if>
                        <c:if test="${findListEtudiants== null}">

                        </c:if>
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
        <c:forEach var="element" items="${filieres}">

        {id: '${element.matricule}', name: '${element.nom}'},
        </c:forEach>

        ],
                autoSelect: true
        });
        $input.change(function () {
        var current = $input.typeahead("getActive");
        if (current) {

        if (current.name == $input.val()) {

        } else {
        // This means it is only a partial match, you can either add a new item
        // or take the active if you don't want new items
        }
        } else {
        // Nothing is active so it is a new value (or maybe empty value)
        }
        });
    </script>

    <script>
        var $input = $(".classe");
        $input.typeahead({
        source: [
        <c:forEach var="element" items="${classes}">
        {id: '${element.matricule}', name: '${element.nom}', inscription: '${element.inscription}'},
        </c:forEach>
        ],
                autoSelect: true
        });
        $input.change(function () {
        var current = $input.typeahead("getActive");
        if (current) {

        if (current.name == $input.val()) {


        } else {
        // This means it is only a partial match, you can either add a new item
        // or take the active if you don't want new items
        }
        } else {
        // Nothing is active so it is a new value (or maybe empty value)
        }
        });
    </script>



</script>

<style>
    input[type=number]::-webkit-inner-spin-button, 
    input[type=number]::-webkit-outer-spin-button { 
        -webkit-appearance: none; 
        margin: 0; 
    }
</style>



</body>

</html>
