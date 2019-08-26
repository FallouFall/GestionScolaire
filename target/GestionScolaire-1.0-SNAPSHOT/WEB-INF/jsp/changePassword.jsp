<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Coming Soon - Start Bootstrap Theme</title>
   <link rel="shortcut icon" href="images/webIcone.jpg"/>
		<link rel="stylesheet"  type="text/css" href="./css/police.css" >
  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="./css/themify-icons.css">
        <link rel="stylesheet" href="css/toastNotification.css">
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js" ></script>
  <!-- Custom fonts for this template -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Merriweather:300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="css/coming-soon.min.css" rel="stylesheet">

</head>

<body>

  <div class="overlay"></div>
  <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
    <source src="mp4/bg.mp4" type="video/mp4">
  </video>

  <div class="masthead">
    <div class="masthead-bg"></div>
    <div class="container h-100">
      <div class="row h-100">
        <div class="col-12 my-auto">
          <div class="masthead-content text-white py-5 py-md-0">
              <h1 class="mb-3 ">Bonjour <span class="ti-face-smile" style="font-size: 2em;"></span></h1>
            <p class="mb-5">Le Groupe Scolaire Le Phare vous souhaite le bienvenu (e)</p>
         
                    <form method="POST" >
                                <input type="text" class="form-control " hidden="" id="id" name="idUpdate"  value="${id}">
                                <input type="text" class="form-control " hidden=""   id="idprofil" name="profilUpdate"  value="${idprofil}" >
                                <br>
                                <div class="form-group">
                                    <div class="input-group with-addon-icon-left">
                                    
                                        <input type="password" class="form-control "     name="password" id="nom" placeholder="Nouveau Mot de passe" required="true" minlength="2" maxlength="30">
                                    </div>
                                </div>

                       <div class="form-group">
                                    <div class="input-group with-addon-icon-left">
                                     
                                        <input type="password" class="form-control "     name="confirme" id="password" placeholder="Confirmer Mot de passe" required="true" minlength="2" maxlength="30">
                                    </div>
                                </div>
                                   <div class="form-group">
                                    <div class="form-label-group">   
                                        <button type="submit" class="btn btn-primary"   style="background-color: #0272bd   ;">
                                            <i class="ti-reload">

                                            </i>Changer</button>


                                    </div>
                                </div>
                    </form>
                                
                            <c:if test="${not empty errorchange}">
                                <script>

                                    $(document).ready(function () {
                                        launch_toast();
                                    })
                                </script>


                                <div id="toast" ><div id="img"><i class="ti-key"></i></div><div id="desc"> ${errorchange}</div></div>

                            </c:if>
                            <c:if test="${empty errorchange}">



                            </c:if>
          </div>
        </div>
      </div>
    </div>
  </div>


  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/coming-soon.min.js"></script>
      <script>
                                    function launch_toast() {
                                        var x = document.getElementById("toast");
                                        x.className = "show";
                                        setTimeout(function () {
                                            x.className = x.className.replace("show", "");
                                        }, 5000);
                                    }
    </script>


</body>
<style>
    .datepicker-dropdown {
  border-color: #54a2d9;
  
}
.sidebar {
    background-image: url(images/d.jpg);
     background-repeat: round;
    background-color: transparent;
}
    body{
        overflow-y: hidden;
    }
    .form-control{
        font-family: titilliumWeb-regular;
    }
    footer{
        background-image: url("images/footer.png");
        background-repeat: round;
        background-color: transparent;
    height: 130px;
        color: #fff;
  position: fixed;
    bottom: 0;
    width: 100%;
    }
    .input{
        border-right: 2em;
    }
</style>
</html>
