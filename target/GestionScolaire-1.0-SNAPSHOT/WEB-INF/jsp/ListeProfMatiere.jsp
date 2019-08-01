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

    <title>Liste des Professeurs</title>

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
        <link rel="stylesheet" href="css/toastNotification.css">
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js" ></script>
      

  </head>

  <body id="page-top">
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

      <%@include file="HeaderUser.jsp" %>

    <div id="wrapper">

      <!-- Sidebar -->
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
          <a class="nav-link" href="#">
            <i class="fas fa-plus"></i>
            <span>Ajouter </span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href=#">
            <i class="fas fa-fw fa-table"></i>
            <span>Lister</span></a>
        </li>
      </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

                  <div class="loader"><div class="page-loader"></div></div>
                
          <!-- DataTables Example -->
          <div class="card mb-3 ">
                    <div class="card-header" style="text-align: center;background-color: #fff;color: #1f72b8;">
                          
                            <span style="font-family: dax-bold;    font-size: 2rem;">
                              Professeurs
                                  

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
                                            <th>Statut</th>
                                              <th>Choisir</th>

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
                                            <th>Statut</th>
                                              <th>Choisir</th>



                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="element" items="${liste}">
                                <c:url var="link" value="lock.htm">
                               <c:param name="back" value="listeProfeMatiere.htm"/>
                                  <c:param name="statut" value="${element.statut}"/>
                                   <c:param name="profilId" value="${element.idprofil.id}"/>
                                   </c:url>
                                
                                    <c:url var="link2" value="listeMatiereProf.htm">
                              
                                   <c:param name="idProf" value="${element.id}"/>
                               
                                   </c:url>
                                            <tr style="text-align: center;vertical-align: middle;">

                                                <td> 
                                                    <c:if test="${element.imageId != null}">
                                                          <img alt="" class="image--cover" src="data:image/jpeg;base64,${element.imageId} " width="54">
                                                    </c:if>
                                                          
                                                    <c:if test="${element.imageId == null}">
                                                         <span class="ti-user" style="font-size: 1.5em; color: #1f72b8;"></span>
                                                    </c:if>
                                                   

                                                </td>
                                                <td>${element.matricule}</td>
                                                <td>${element.nom}</td>
                                                <td>${element.prenom}</td>
                                                <td>${element.adresse}</td>
                                                <td>${element.telephone}</td>
                                                    <td> 
                                                        <c:if test="${element.statut == 0}">
                                                              <div class="form-label-group">
                                                        <a href="${link}" class="ti-lock"></a>
                                                    </div></c:if>
                                                          
                                                    <c:if test="${element.statut != 0}">
                                                        <a href="${link}" class="ti-unlock"></a>
                                                    </c:if>
                                                </td>

                                              <td> 
                                                     
                                                          
                                                  
                                                        <a href="${link2}" class="ti-plus"></a>
                                                    
                                                </td>

                                            </tr>

                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                              <button id="print" onclick="printContent('dataTable');" class="btn btn-primary" style="background-color:#1f72b8; font-family: titilliumWeb-regular;">
                                                            <i class="ti-printer">

                    </i> Imprimer</button>
                        </div>
             
           
          </div>
    <c:if test="${not empty affecter}">
                                <script>

                                    $(document).ready(function () {
                                        launch_toast();
                                    })
                                </script>


                                <div id="toast" ><div id="img"><i class="ti-key"></i></div><div id="desc"> ${error}</div></div>

                            </c:if>
                            <c:if test="${empty affecter}">



                            </c:if>

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

                            <button type="submit" class="btn btn-primary" style="background-color: #0272bd;">     <a href="deconnecter.htm"  style="   text-decoration: none;  color: #fff;">Deconnceter</a></button>
                    
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
          <script src="/js/toast.js"></script>
           <script>
                                    function launch_toast() {
                                        var x = document.getElementById("toast");
                                        x.className = "show";
                                        setTimeout(function () {
                                            x.className = x.className.replace("show", "");
                                        }, 5000);
                                    }
    </script>
           <script>
function printContent(el){
var restorepage = $('body').html();
var printcontent = $('#' + el).clone();
var enteredtext = $('#text').val();
$('body').empty().html(printcontent);
window.print();
$('body').html(restorepage);
$('#text').html(enteredtext);
setTimeout(function (){
    location.reload()
},1);
}

</script>


  </body>

</html>
