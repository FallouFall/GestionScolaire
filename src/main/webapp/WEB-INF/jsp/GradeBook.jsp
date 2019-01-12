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



        <nav class="navbar navbar-expand  static-top" style="    height: 12vh;background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);">

            <a class="navbar-brand mr-1" href="AccueilProfesseur.htm" style="color: #fff;    font-family: titilliumWeb-italic; font-size: 4vh;   letter-spacing: .5rem; " >ISI</a>


            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">

                    <div class="input-group-append">

                    </div>
                </div>
            </form>

            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0" >

                <li class="nav-item dropdown no-arrow">

                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">

                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
                    </div>
                </li>
            </ul>

        </nav>

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
                    <a class="nav-link" href="AccueilProfesseur.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-plus"></i>
                        <span>Ajouter </span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="GradeBook.htm">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Tables</span></a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">

                    <div class="loader"><div class="page-loader"></div></div>

                 


                    <!-- DataTables Example -->
                    <div class="card mb-3 slide-in ">
                        <div class="card-header" style="background-color: #5a6169;color: #fff;">
                            <i class="fas fa-table"></i>
                            <span style="font-family: dax-bold;">
                               Fiche de Note 


                            </span>  </div>

                        <div class="card-body">
                            
                               <form>
                                                 <div class="form-group col-md-6">
                                            <div class="input-group with-addon-icon-left">
                                                <span class="input-group-addon">
                                                    <i class="ti-tag"></i>
                                                </span>
                                                <input type="text" class="form-control" id="matricule" placeholder="Classe" required="true">
                                            </div>
                                        </div>
                         
                                         <div class=" form-group col-md-6">
                                            <div class="input-group with-addon-icon-left">
                                                <input type="text" class="form-control" id="datepicker-example-1" placeholder="Filiere">
                                                <span class="input-group-addon">
                                                    <i class="ti-calendar"></i>
                                                </span>
                                            </div>
                                        </div>
                         <div class=" form-group col-md-6">
                                <button class="btn btn-primary" data-toggle="modal" data-target="#payeModal">
                                    <i class="ti-save">
                                    </i> Rechercher</button>
                               </div>
                       </form>
                            
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Note 1</th>
                                            <th>Note 2</th>
                                            <th>Note 3</th>
                                            <th>Examen</th>

                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Name</th>
                                            <th>Note 1</th>
                                            <th>Note 2</th>
                                            <th>Note 3</th>
                                            <th>Examen</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                           
                                           
                                        <tr>
                                            <td>Tiger Nixon</td>
                                            <td><input type="text" class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>

                                        </tr>

                                        <tr>
                                            <td>Cedric Kelly</td>
                                            <td><input type="text"  class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>

                                        </tr>
                                        <tr>
                                            <td>Airi Satou</td>
                                            <td><input type="number" min="0" max="20" class="form-control" /></td>
                                            <td><input type="number" class="form-control" /></td>
                                            <td><input type="number" class="form-control" /></td>
                                            <td><input type="number" class="form-control" /></td>

                                        </tr>


                                        <tr>
                                            <td>Brenden Wagner</td>
                                            <td><input type="number"  class="form-control" /></td>
                                            <td><input type="number" class="form-control" /></td>
                                            <td><input type="number" class="form-control" /></td>
                                            <td><input type="number" class="form-control" /></td>

                                        </tr>
                                        <tr>
                                            <td>Fiona Green</td>
                                            <td><input type="number" class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>

                                        </tr>

                                        <tr>
                                            <td> Donna Snider</td>
                                            <td><input id ="myTextBox" type="number" class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>
                                            <td><input type="text" class="form-control" /></td>

                                        </tr>
                                          
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
        <script src="js/demo/datatables-demo.js">
            
          
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
