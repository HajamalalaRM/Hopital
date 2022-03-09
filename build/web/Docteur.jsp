<!DOCTYPE html>
<html lang="fr">

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
    <div class="container-fluide">
        <div class="row">
            <div class="col">
                <header>
                    <nav class="navbar navbar-light navbar-expand-lg navigation-clean-search">
                        <div class="container"><a class="navbar-brand" href="#">Hospital Gestion</a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                            <div class="collapse navbar-collapse" id="navcol-1">
                                <ul class="navbar-nav">
                                    <li class="nav-item"><a class="nav-link " href="Patient.jsp">Patient</a></li>
                                    <li class="nav-item"><a class="nav-link active" href="#">Docteur</a></li>
                                    <li class="nav-item"><a class="nav-link" href="Chambre.jsp">Chambre</a></li>
                                </ul>
                                <form class="me-auto search-form" target="_self">
                                    <div class="d-flex align-items-center"><label class="form-label d-flex mb-0" for="search-field"><i class="fa fa-search"></i></label><input class="form-control search-field" type="search" id="search-field" name="search"></div>
                                </form><a class="btn btn-light action-button" role="button" href="#">Déconnexion</a>
                            </div>
                        </div>
                    </nav>
                </header>
            </div>
        </div>
        <div class="row">
            <div class="col-xl-3">
                <div style="text-align: center;margin-top: 110px;margin-bottom: 70px;">
                    <ul class="list-group">
                        <li class="list-group-item"><span><a href="Docteur.jsp?nouveau=true">Nouveau Docteur</a></span></li>
                        <li class="list-group-item"><span><a href="Docteur.jsp?list=true">Listes Docteurs</a></span></li>
                    </ul>
                </div>
            </div>
            <div class="col">
                <%if(request.getParameter("list") != null){%>
                <div class="row">
                    <div class="col">
                        <div>
                            <div class="row">
                                <div class="col-xl-12">
                                    <div style="text-align: center;"><label class="form-label" style="font-size: 30px;margin-top: 20px;">Listes des Docteurs</label></div>
                                    <div>
                                        <div class="dropdown">
                                            <button class="btn btn-primary dropdown-toggle" aria-expanded="false" data-bs-toggle="dropdown" type="submit">Catégories</button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">Infirmière</a>
                                                <a class="dropdown-item" href="#">Généraliste</a>
                                                <a class="dropdown-item" href="#">Spécialiste</a>
                                                <a class="dropdown-item" href="#">Professeur</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div><label class="form-label">Salaire base :&nbsp;</label><label class="form-label"></label></div>
                                    <div style="margin-top: 40px;margin-bottom: 70px;">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>Nom</th>
                                                        <th>Docteur</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>Cell 1</td>
                                                        <td>Cell 1</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                }
                if(request.getParameter("nouveau") != null){
                %>
                <div class="row">
                    <div class="col-xl-6"   style="margin-top: 70px;">
                        <div>
                            <form style="text-align: center;">
                                <p style="font-size: 24px;font-family: cursive;">Ajouter un nouveau Docteur</p>
                                <div><label class="form-label">Nom :&nbsp;</label><input class="form-control" type="text">
                                    <label class="form-label">Salaire :&nbsp;</label><input class="form-control" type="number">
                                    <label class="form-label">Catégories :&nbsp;</label>
                                    <select class="form-select">
                                        
                                            <option value="12" selected="">Infirmière</option>
                                            <option value="13">Généraliste</option>
                                            <option value="14">Spécialiste</option>
                                            <option value="14">Professeur</option>
                                        
                                    </select><br>
                                    <button class="btn btn-success" type="submit">Ajouter</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col" style="width: 100%;height: 100%; margin-top: 70px;">
                        <img src="assets/img/logo1.jpg" style="width: 100%;height: 10.5cm;">
                    </div>
                </div>
                <%}%>
            </div>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>