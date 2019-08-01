<%-- 
    Document   : GererAdmini
    Created on : 25 nov. 2018, 15:10:14
    Author     : Fallou
--%>



<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html" import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Statistiques</title>
        <link rel="shortcut icon" href="images/webIcone.jpg"/>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/sb-admin.css" rel="stylesheet">
        <link href="css/police.css" rel="stylesheet">

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js" ></script>

        <script src="js/shards.min.js"></script>
        <script src="js/sb-admin.min.js"></script>

        <script src="vendor/jquery/jquery.min.js"></script>
        <script async="" src="//www.google-analytics.com/analytics.js"></script>

        <script src="js/dist/Chart.min.js"></script>
        <script src="js/dist/utils.js"></script>
        <style type="text/css">/* Chart.js */
            @keyframes chartjs-render-animation{from{opacity:.99}to{opacity:1}}.chartjs-render-monitor{animation:chartjs-render-animation 1ms}.chartjs-size-monitor,.chartjs-size-monitor-expand,.chartjs-size-monitor-shrink{position:absolute;direction:ltr;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1}.chartjs-size-monitor-expand>div{position:absolute;width:1000000px;height:1000000px;left:0;top:0}.chartjs-size-monitor-shrink>div{position:absolute;width:200%;height:200%;left:0;top:0}
        </style>
        <style>
            canvasLine{
                -moz-user-select: none;
                -webkit-user-select: none;
                -ms-user-select: none;
            }
            canvasBar{
                -moz-user-select: none;
                -webkit-user-select: none;
                -ms-user-select: none;
            }
        </style>


    </head>

    <body id="page-top">

        <%@include file="HeaderUser.jsp" %>
        <%
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy ");
            String date = sdf.format(new Date());
        %>
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">

                <li class="nav-item active">
                    <a class="nav-link" href="directeur.htm">
                        <i class="fas fa-home"></i>
                        <span>Accueil</span>
                    </a>
                </li>


                <li class="nav-item active">
                    <a class="nav-link" href="#">
                        <i class="ti-stats-up"></i>
                        <span>Stats</span></a>
                </li>

            </ul>


            <div id="content-wrapper">

                <div id="content-wrapper">

                    <div class="container-fluid">

                        <div class="loader"><div class="page-loader"></div></div>
                        <!-- Breadcrumbs-->
                        <ol class="breadcrumb" style="font-family: dax-bold;margin-top: -10px;
                            box-shadow: 0 0.46875rem 2.1875rem rgba(90,97,105,.1), 0 0.9375rem 1.40625rem rgba(90,97,105,.1), 0 0.25rem 0.53125rem rgba(90,97,105,.12), 0 0.125rem 0.1875rem rgba(90,97,105,.1);
                            background-color: #fff;border-radius: 10px;color: #1f72b8;
                            ">
                            <li class="breadcrumb-item">
                                <span>Statistiques</span>
                            </li>

                        </ol>

                        <!-- Area Chart Example-->
                        <div class="card mb-3">
                            <div class="card-header"  style="background-color: #fff;font-family: titilliumWeb-light;">
                                <i class="fas fa-chart-area"></i>
                                Effectif Par Classe</div>
                            <div class="card-body"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>


                                <canvas id="canvasLine" style="display: block; width: 723px; height: 361px;" width="2169" height="1083" class="chartjs-render-monitor"></canvas>
                            </div>
                            <div class="card-footer small text-muted">Mise à jour  <%= date%>

                            </div>
                        </div>





                        <div class="card mb-3">
                            <div class="card-header" style="background-color: #fff;font-family: titilliumWeb-light;">
                                <i class="fas fa-chart-bar"></i>
                                Diagramme en Barre</div>
                            <div class="card-body"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                                <canvas id="bar-chart"  style="display: block; width: 804px; height: 402px;" width="1608" height="804" class="chartjs-render-monitor"></canvas>
                            </div>
                            <div class="card-footer small text-muted">Mise à jour  <%= date%></div>
                        </div>

                        <div class="card mb-3">
                            <div class="card-header" style="background-color: #fff;font-family: titilliumWeb-light;">
                                <i class="fas fa-chart-pie"></i>
                                Partition</div>
                            <div class="card-body"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                                <canvas id="pie-chart" style="display: block; width: 804px; height: 402px;" width="1608" height="804" class="chartjs-render-monitor"></canvas>
                            </div>
                            <div class="card-footer small text-muted">Mise à jour  <%= date%></div>
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




        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Se Deconnecter?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Voulez-Vous quitter ?</div>
                    <div class="modal-footer">

                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Annuler</button>

                        <button type="submit" class="btn btn-primary" style="background-color: #0272bd;">     <a href="index.htm"  style="   text-decoration: none;  color: #fff;">Deconnceter</a></button>

                    </div>
                </div>
            </div>
        </div>






        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js" ></script>

        <script src="js/shards.min.js"></script>
        <script src="js/sb-admin.min.js"></script>
   
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>


        <script>
            var listeClasse = new Array();
            <c:forEach var="element" items="${classes}">
            listeClasse.push('${element.description}');
            </c:forEach>


            var nbParClas = new Array();
            var max = new Array();
            <c:forEach var="nombre" items="${nbParClasse}">
            nbParClas.push('${nombre}');
            max.push('8');
            </c:forEach>

            var MONTHS = listeClasse;
            var config = {
                type: 'line',
                data: {
                    labels: listeClasse,
                    datasets: [{
                            label: 'NBr Inscritions par Classes',
                            backgroundColor: window.chartColors.blue,
                            borderColor: window.chartColors.blue,
                            data: nbParClas
                            ,
                            fill: false,
                        }, {
                            label: 'Limite Inscription (8)',
                            fill: false,
                            backgroundColor: window.chartColors.red,
                            borderColor: window.chartColors.red,
                            data: max,
                        }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: ''
                    },
                    tooltips: {
                        mode: 'index',
                        intersect: false,
                    },
                    hover: {
                        mode: 'nearest',
                        intersect: true
                    },
                    scales: {
                        xAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Classes'
                                }
                            }],
                        yAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Effectif'
                                }
                            }]
                    }
                }
            };

            window.onload = function () {
                var ctx = document.getElementById('canvasLine').getContext('2d');
                window.myLine = new Chart(ctx, config);
            };

            document.getElementById('randomizeData').addEventListener('click', function () {
                config.data.datasets.forEach(function (dataset) {
                    dataset.data = dataset.data.map(function () {
                        return randomScalingFactor();
                    });

                });

                window.myLine.update();
            });

            var colorNames = Object.keys(window.chartColors);
            document.getElementById('addDataset').addEventListener('click', function () {
                var colorName = colorNames[config.data.datasets.length % colorNames.length];
                var newColor = window.chartColors[colorName];
                var newDataset = {
                    label: 'Dataset ' + config.data.datasets.length,
                    backgroundColor: newColor,
                    borderColor: newColor,
                    data: [],
                    fill: false
                };

                for (var index = 0; index < config.data.labels.length; ++index) {
                    newDataset.data.push(randomScalingFactor());
                }

                config.data.datasets.push(newDataset);
                window.myLine.update();
            });

            document.getElementById('addData').addEventListener('click', function () {
                if (config.data.datasets.length > 0) {
                    var month = MONTHS[config.data.labels.length % MONTHS.length];
                    config.data.labels.push(month);

                    config.data.datasets.forEach(function (dataset) {
                        dataset.data.push(randomScalingFactor());
                    });

                    window.myLine.update();
                }
            });

            document.getElementById('removeDataset').addEventListener('click', function () {
                config.data.datasets.splice(0, 1);
                window.myLine.update();
            });

            document.getElementById('removeData').addEventListener('click', function () {
                config.data.labels.splice(-1, 1); // remove the label first

                config.data.datasets.forEach(function (dataset) {
                    dataset.data.pop();
                });

                window.myLine.update();
            });





        </script>

        <script>
            var listeFiliere = new Array();
            <c:forEach var="element" items="${filieres}">
            listeFiliere.push('${element.nom}');
            </c:forEach>

            var nbInscriptions = new Array();
            <c:forEach var="nombreInscrit" items="${nbInscriptions}">
            nbInscriptions.push('${nombreInscrit}');
            </c:forEach>



            new Chart(document.getElementById("bar-chart"), {
                type: 'bar',
                data: {
                    labels: listeFiliere,

                    datasets: [
                        {
                            label: "Nombre d'Inscription ",
                            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                            data: nbInscriptions
                        }
                    ]
                },
                options: {
                    legend: {display: false},
                    title: {
                        display: true,
                        text: 'Nbr Inscriptions par Filiere'
                    }
                }
            });
        </script>

        <script>
            new Chart(document.getElementById("pie-chart"), {
                type: 'pie',
                data: {
                    labels: listeFiliere,
                    datasets: [{
                            label: "Population par filiere",
                            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                            data: nbInscriptions
                        }]
                },
                options: {
                    title: {
                        display: true,
                        text: 'Repartitions par filiere'
                    }
                }
            });
        </script>

        <script>
            function printContent(el) {
                var restorepage = $('body').html();
                var printcontent = $('#' + el).clone();
                var enteredtext = $('#text').val();
                $('body').empty().html(printcontent);
                window.print();
                $('body').html(restorepage);
                $('#text').html(enteredtext);
                setTimeout(function () {
                    location.reload()
                }, 1);
            }

        </script>

    </body>

</html>
