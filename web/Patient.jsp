<%@page import="java.util.Vector"%>
<%@page import="models.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                        <li class="nav-item"><a class="nav-link active" href="#">Patient</a></li>
                                        <li class="nav-item"><a class="nav-link" href="Docteur.jsp">Docteur</a></li>
                                        <li class="nav-item"><a class="nav-link" href="Chambre.jsp">Chambre</a></li>
                                    </ul>
                                    <form class="me-auto search-form" target="_self">
                                        <div class="d-flex align-items-center" style="/*float: right;*/"><label class="form-label d-flex mb-0" for="search-field"><i class="fa fa-search"></i></label><input class="form-control search-field" type="search" id="search-field" name="search"></div>
                                    </form><a class="btn btn-light action-button" role="button" href="#">Déconnexion</a>
                                </div>
                            </div>
                        </nav>
                    </header>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-3">
                    <div style="text-align: center;margin-top: 70px;margin-bottom: 70px;">
                        <ul class="list-group">
                            <li class="list-group-item"><span><a href="Patient.jsp?nouveau=true">Ajouter un(e) Patient(e)</a></span></li>
                            <form action='PatientController'method='POST'>
                                <input type="hidden" name="act" value="list">
                                <li class="list-group-item"><span><input type='submit' value='liste patient actuel'> </span></li>
                            </form>
                        </ul>
                    </div>
                </div>
                <div class="col">
                    <%
                        if(request.getParameter("nouveau") != null){
                    %>
                    <div class="row">
                        <div class="col-xl-6" style="margin-top: 1.5cm">
                            <div>
                                <form style="text-align: left;" method="POST" action="PatientController">
                                    <input type="hidden" name="act" value="insert">
                                    <p style="font-size: 24px;font-family: cursive;">Ajouter une nouvelle patient</p>
                                    <div>
                                        <label class="form-label">Nom :&nbsp;</label><input name="nom" class="form-control" type="text">
                                        <label class="form-label">Prénom :&nbsp;</label><input name="prenom" class="form-control" type="text">
                                        <label class="form-label">Date de naissance :&nbsp;</label><input name="datenaissance" class="form-control" type="date">
                                         <label class="form-label">Sexe :&nbsp;
                                         <select class="form-select" name="sexe">
                                                <option value="m" selected="">m</option>
                                                <option value="f">f</option>
                                         </select></label></br> 
                                        <label class="form-label">Contact :&nbsp;</label><input name="contact" class="form-control" type="number">
                                        <button class="btn btn-success" type="submit">Ajouter</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col" style="width: 100%;height: 100%; margin-top: 1.5cm"><img src="assets/img/logo2.jpg" style="width: 100%;height: 10.5cm;"></div>
                    </div>
                     <%}
                    if(request.getParameter("patient") != null){
                    Patient p = (Patient)request.getAttribute("patient");
                    %>
                    <div class="row">
                        <div class="col-xl-6" style="margin-top: 1.5cm">
                            <div>
                                <form style="text-align: left;" method="POST" action="PatientController">
                                    <input type="hidden" name="act" value="entre">
                                    <p style="font-size: 24px;font-family: cursive;">Ajouter une nouvelle patient</p>
                                    <div>
                                        <input type="hidden" name="id" value="<%= p.getId() %>">                                        
                                        <label class="form-label">Nom :&nbsp;</label><%= p.getNom() %></br>
                                        <label class="form-label">Prénom :&nbsp;</label><%= p.getPrenom()%></br>
                                        <label class="form-label">Date de naissance :&nbsp;</label><%= p.getDate_naissance()%></br>
                                         <label class="form-label">Sexe :&nbsp;<%= p.getSexe()%></br>
                                        <label class="form-label">Contact :&nbsp;</label><%= p.getContact()%></br>
                                        <input type="checkbox" required>payement 200 000Ar
                                        <button class="btn btn-success" type="submit">Ajouter malade</button>                                        
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col" style="width: 100%;height: 100%; margin-top: 1.5cm"><img src="assets/img/logo2.jpg" style="width: 100%;height: 10.5cm;"></div>
                    </div>
                    
                    
                    <%}
                    if(request.getParameter("list") != null){
                    Vector<Patient> vect = (Vector<Patient>)request.getAttribute("listepatientactu");
                    %>
                    <div class="row">
                        <div class="col">
                            <div>
                                <div class="row">
                                    <div class="col-xl-8">
                                        <div style="text-align: center;"><label class="form-label" style="font-size: 30px;/*text-align: center;*//*margin-left: 5cm;*/margin-top: 20px;">Liste des Patients&nbsp;</label></div>
                                        <div>
                                            <div class="dropdown"><button class="btn btn-primary dropdown-toggle" aria-expanded="false" data-bs-toggle="dropdown" type="submit">Listes patients</button>
                                                <div class="dropdown-menu">
                                                    <a class="dropdown-item" href="#">Actuels</a>
                                                    <a class="dropdown-item" href="#">Tous</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div style="margin-top: 40px;margin-bottom: 70px;">
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>Nom</th>
                                                            <th>Prénom</th>
                                                            <th>sexe</th>
                                                            <th>Chambre</th>
                                                            <th>Date d'entrée</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <% for(int i=0;i<vect.size();i++){%>
                                                        <tr>
                                                            <td><%= vect.get(i).getNom() %></td>
                                                            <td><%= vect.get(i).getPrenom()%></td>
                                                            <td><%= vect.get(i).getSexe() %></td>
                                                            <td><%= vect.get(i).getChambrenumero() %></td>
                                                            <td><%= vect.get(i).getDatyentre() %></td> 
                                                        <form action='PatientController' method='POST'>
                                                            <input type="hidden" name="act" value="sortir">
                                                            <input type='hidden' name='idservice' value='<%= vect.get(i).getIdservice() %>'>
                                                            <td><button type='submit'>sortir</td>
                                                        </form>
                                                        </tr>
                                                        <%}%>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
<!--                                    <div class="col">
                                        <div style="text-align: center;">
                                            <p style="font-size: 30px;margin-top: 20px;">Détails du patient</p>
                                        </div>
                                        <div style="border-style: groove;">
                                            <label class="form-label">Nom :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><label></label><br>
                                            <label class="form-label">Prénom :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label></label><br>
                                                <label class="form-label">Age :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label></label><br>
                                                    <label class="form-label">Docteur :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><label></label><br>
                                                    </div>
                                                    <div style="border-style: groove;margin-top: 30px">
                                                        <label class="form-label">Chambre :&nbsp;</label><label></label><br>
                                                        <label class="form-label">Etat chambre :&nbsp;</label><label></label><br>
                                                        <label class="form-label">Motifs:&nbsp;</label><label></label><br>
                                                    </div>
                                                    <div style="border-style: groove; margin-top: 30px">
                                                        <div class="row">
                                                            <div class="col">
                                                                <div>
                                                                    <div style="text-align: left;">
                                                                        <div class="row">
                                                                            <div class="col">
                                                                                <div style="text-align: left;"><label class="form-label" style="/*float: left;*/">Médicament</label>
                                                                                    <ul>
                                                                                        <lu>Item 1</lu>
                                                                                        <li>Item 2</li>
                                                                                        <li>Item 3</li>
                                                                                        <li>Item 4</li>
                                                                                    </ul>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col">
                                                                                <div style="text-align: center;"><label class="form-label" style="/*float: right;*/">Prix</label>
                                                                                    <ul>
                                                                                        <li>Item 1</li>
                                                                                        <li>Item 2</li>
                                                                                        <li>Item 3</li>
                                                                                        <li>Item 4</li>
                                                                                    </ul>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    </div>-->
                                                    </div>
                                                    </div>
                                                    </div>
                                                    </div>
                                                    <%}%>
                                                    </div>
                                                    </div>
                                                    </div>
                                                    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
                                                    </body>

                                                    </html>