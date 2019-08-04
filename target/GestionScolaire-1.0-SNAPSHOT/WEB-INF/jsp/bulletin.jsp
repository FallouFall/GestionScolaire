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

        <title>Imprimer  Bulletin</title>
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

            <ul class="sidebar navbar-nav " >




                <li class="nav-item" style="margin-top: 20px;">
                    <a class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">

                        <i class="fas fa-bars">    </i>

                    </a>
                </li>




                <li class="nav-item">
                    <a class="nav-link" href="secretaire.htm">
                        <i class=" fas fa-home"></i>
                        <span>Accueil </span></a>
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
                                            Imprimer Bulletin

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
                                                            <input type="text" class=" classe form-control" name="acad" id="classe" placeholder="Choisir Annee Scolaire" required="true">
                                                        </div>
                                                    </div>




                                                    <div class=" form-group col-md-6"> 

                                                        <select class="custom-select w-100" name="semestre" required="true">

                                                            <option value="" >Choisir Semestre</option>
                                                            <option value="1">Premier Semestre</option>
                                                            <option value="2">Second Semestre</option>
                                                        </select>

                                                    </div>

                                                  
                                                    
                                                    <div class="form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">

                                                            <input type="text" class=" classe form-control" name="idAnnee" id="idAnnee"   >
                                                        </div>
                                                    </div>
                                                    
                                                      <div class="form-group col-md-6">
                                                        <div class="input-group with-addon-icon-left">

                                                            <input type="text" class=" classe form-control" name="semestre" id="semestre"  >
                                                        </div>
                                                    </div>

                                                    



                                                    <div class=" form-group col-md-6">       
                                                        <button type="submit" class="btn btn-primary" style="background-color:#1B81C5; font-family: titilliumWeb-regular;">
                                                            <i class="ti-direction">

                                                            </i> Suivant</button>
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
            $('select').change(function(){
var val1 = $('select').val();
document.getElementById("semestre").value=val1;
});
            </script>
<script>
    var $input = $(".classe");
    $input.typeahead({
        source: [
    <c:forEach var="element" items="${annees}">
            {id: '${element.id}', name: '${element.nom}'},
    </c:forEach>
        ],
        autoSelect: true
    });
    $input.change(function () {
        var current = $input.typeahead("getActive");
        if (current) {

            if (current.name == $input.val()) {
                document.getElementById("idAnnee").value = current.id;

            } else {
                document.getElementById("classe").value = "L'annee n'est pas bonne";
             
            }
        } else {
            // Nothing is active so it is a new value (or maybe empty value)
        }
    });
</script>








</body>

</html>
