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
         <link rel="shortcut icon" href="images/webIcone.jpg"/>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/sb-admin.css" rel="stylesheet">
        <link href="css/police.css" rel="stylesheet">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/shards.min.js"></script>
        <script src="js/demo.min.js"></script>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


    </head>

    <body id="page-top">
   <div class="loader"><div class="page-loader"></div></div>
            <nav class="navbar navbar-expand  static-top" style="    height: 12vh;background-image: linear-gradient(to right,#75b5e4 0,#73b4e3 11%,#6cb0e1 23%,#54a2d9 48%,#2989ca 78%,#0272bd 100%);">

           <a class="navbar-brand mr-1" href="Comptable.htm" style="color: #fff;    font-family: titilliumWeb-italic; font-size: 4vh;   letter-spacing: .5rem; " >ISI</a>

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
        
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
          </div>
        </li>
      </ul>

    </nav>

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Comptable.htm">
                         <i class="fas fa-home"></i>
                        <span>Accueil</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="InscriptionEtudiant.htm">
                        <i class="fas fa-plus"></i>
                        <span>Ajouter </span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ListeInscription.htm">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Tables</span></a>
                </li>

            </ul>


            <div id="content-wrapper">

                <div id="content-wrapper">

                    <div class="container-fluid">
                        
                 <div class="loader"><div class="page-loader"></div></div>
                        <!-- Breadcrumbs-->
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                                <a href="#">Statistiques</a>
                            </li>

                        </ol>

                        <!-- Area Chart Example-->
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fas fa-chart-area"></i>
                                Area Chart Example</div>
                            <div class="card-body"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                                <canvas id="myAreaChart" width="522" height="156" class="chartjs-render-monitor" style="display: block; width: 522px; height: 156px;"></canvas>
                            </div>
                            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                        </div>

                        <div class="row">
                            <div class="col-lg-8">
                                <div class="card mb-3">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar"></i>
                                        Bar Chart Example</div>
                                    <div class="card-body"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                                        <canvas id="myBarChart" width="522" height="261" class="chartjs-render-monitor" style="display: block; width: 522px; height: 261px;"></canvas>
                                    </div>
                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="card mb-3">
                                    <div class="card-header">
                                        <i class="fas fa-chart-pie"></i>
                                        Pie Chart Example</div>
                                    <div class="card-body"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                                        <canvas id="myPieChart" width="522" height="522" class="chartjs-render-monitor" style="display: block; width: 522px; height: 522px;"></canvas>
                                    </div>
                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                </div>
                            </div>
                        </div>


                    </div>
                    <!-- /.container-fluid -->

                    <!-- Sticky Footer -->
                    

                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->


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

        <div class="modal fade" id="logoutModalClasse" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelClasse" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabelClasse">Ready to Leave?</h5>
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








        <div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                        <a class="btn btn-primary" href="/GestionScolaire">Logout</a>
                    </div>
                </div>
            </div>
        </div>


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









 
    
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="js/sb-admin.min.js"></script>
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="js/demo/chart-area-demo.js"></script>
        <script src="js/demo/chart-bar-demo.js"></script>
        <script src="js/demo/chart-pie-demo.js"></script>






    </body>

</html>
