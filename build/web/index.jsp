<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Hospital</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets/css/Article-List.css">
    <link rel="stylesheet" href="assets/css/Form-Search.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="assets/css/Navigation-with-Search.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <div class="container-fluide" >
        <div class="row">
            <div class="col">
                <section class="login-clean">
                    <form method="post" style="background-color: lightgreen;" action="AdminController">
                        <div style="text-align: center;/*font-size: 30px;*//*font-family: cursive;*/">
                            <p style="font-size: 30px;font-family: cursive;">Hospital Gestion</p>
                        </div>
                        <h2 class="visually-hidden">Login Form</h2>
                        <div class="illustration"><i class="icon ion-ios-heart" style="color: #eb3b60;"></i></div>
                        <div class="mb-3"><input class="form-control" type="text" name="nom" placeholder="Nom d'utilisateur"></div>
                        <div class="mb-3"><input class="form-control" type="password" name="password" placeholder="Votre mot de passe"></div>
                         <%
                        if(request.getParameter("erreur") != null){%> 
                        <div class="mb-3"><p style="color: red;">Erreur</p></div>
                        <% }%>
                            
                        <div class="mb-3"><button class="btn btn-primary d-block w-100" type="submit">Connection</button></div>
                    </form>
                </section>
            </div>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>