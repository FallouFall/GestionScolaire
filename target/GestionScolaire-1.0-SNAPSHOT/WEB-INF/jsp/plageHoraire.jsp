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

        <title>Inscription Etudiant</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/themify-icons.css" rel="stylesheet">
        <link rel="stylesheet"  type="text/css" href="./css/police.css" >
        <link rel="shortcut icon" href="images/webIcone.jpg"/>
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="css/shards.min.css">
        <link rel="stylesheet" href="css/shards-demo.css?v=1.1.0">
        <link rel="stylesheet" href="./css/cardeffects.css">

    </head>

    <body id="page-top" >

        <%@include file="HeaderUser.jsp" %>

        <div id="wrapper">
    <ul class="sidebar navbar-nav" >




                <li class="nav-item"  style="margin-top: 20px;">
                    <a class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">

                        <i class="fas fa-bars">    </i>

                    </a>
                </li>




                <li class="nav-item">
                    <a class="nav-link" href="directeur.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
                </li>
                
                  <li class="nav-item">
                    <a class="nav-link" href="planifierCour.htm">
                        <i class=" ti-timer"></i>
                        <span>Planifier Cour </span></a>
                </li>
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Gerer Classe</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">

                        <a  class="dropdown-item" href="addClasse.htm">Ajouter Classe</a>
                        <a class="dropdown-item" href="#">Liste Classes</a>


                    </div>
                </li>

                
                
                
                
               

            </ul>

            <div id="content-wrapper">

                <div class="container-fluid" style="    margin-top: -40px;">

          <div id="cards" class="container mb-2 " style="padding-bottom: 1px  ">


                        <div class="example col-md-12 ml-auto mr-auto">
                            <div class="row " >

                                <div class="card card-signin mx-auto mt-5">
                                    <div class="card-header" style="text-align: center;background-color: #fff;color:#1f72b8;">

                                        <span style="font-family: dax-bold;    font-size: 2rem;">
                                            Plage Horaire


                                        </span>  </div>
                                    <div class="card-body">
                                        <form method="POST">
                                            <div class="form-group">
                                                <div class="form-row">




                                                   

                                                    <div class="form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <span class="input-group-addon">
                                                                <i class="ti-calendar"></i>
                                                            </span>
                                                          <input type="text" class=" classe form-control" name="jour" id="classe" placeholder="Jour" required="true">
                                                        </div>
                                                    </div>


                                                     <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="text" class=" filiere form-control" name="heure" id="filiere" placeholder="Heure"  required="true">
                                                            <span class="input-group-addon">
                                                                <i class="ti-time"></i>
                                                            </span>
                                                        </div>
                                                    </div>
                                                 
                                                         <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="text" class=" filiere form-control" name="idClasse" value="${idClasse}" hidden="">
                                                       
                                                        </div>
                                                    </div>
                                                                 <div class=" form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">
                                                            <input type="text" class=" filiere form-control"  hidden="">
                                                       
                                                        </div>
                                                    </div>

                                                    <div class=" form-group col-md-6">       
                                                        <button type="submit" class="btn btn-primary" style="background-color:#1B81C5; font-family: titilliumWeb-regular;">
                                                            <i class="ti-plus">

                                                            </i> Enregistrer</button>
                                                    </div>
                                                    <div class=" form-group col-md-6">   
                                                        <button type="reset"  class="btn btn-secondary">
                                                            <i class="ti-trash">

                                                            </i> Annuler</button>
                                                    </div>




                                                </div>
                                            </div>





                                        </form>

                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>


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
<script src="js/demo.min.js"></script>
<script src="js/shards.min.js"></script>
<script src="js/sb-admin.min.js"></script>
<script src="js/bootstrap3-typeahead.js"></script>





<script>
    var $input = $(".classe");
    $input.typeahead({
    source: [
  
    {id: '1', name: 'Lundi'},
    {id: '2', name: 'Mardi'},
    {id: '3', name: 'Mercredi'},
    {id: '4', name: 'Jeudi'},
    {id: '5', name: 'Vendredi'}
  
   

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
      document.getElementById("classe").value="Le jour choisi est incorrecte";
    }
    } else {
    // Nothing is active so it is a new value (or maybe empty value)
    }
    });
</script>

<script>
    var $input = $(".filiere");
    $input.typeahead({
    source: [
  
    {id: '8', name: '8H-9H'},
    {id: '9', name: '9H-10H'},
    {id: '10', name: '10H-11H'},
    {id: '11', name: '11H-12H'},
    {id: '12', name: '12H-13H'},
      {id: '13', name: '13H-14H'},
    {id: '14', name: '14H-15H'},
    {id: '15', name: '15H-16H'},
     {id: '16', name: '15H-17H'}
   

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
         document.getElementById("filiere").value="L 'heure choisie est incorrecte";
    }
    } else {
    // Nothing is active so it is a new value (or maybe empty value)
    }
    });
</script>



</body>

</html>
