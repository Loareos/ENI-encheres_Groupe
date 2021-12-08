<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<meta author="Clément"/>
	<link rel="stylesheet" href="css/styleIndex.css"/>
	<title>Accueil</title> 
	
</head>

<header>

    <nav>
		<h4>ENI-Enchères</h4> 
		
		<c:if test="${empty utilisateur}">
		    <a href="ConnexionServlet" class="lienConnection">S'inscrire - Se connecter</a>
        </c:if>
        
        <c:if test="${empty utilisateur}">
            <div class="liens">
		        <a href="SERVLET" class="lienConnection">Enchères</a>
	    	    <a href="SERVLET" class="lienConnection">Vendre un article</a>
		        <a href="ProfilServlet" class="lienConnection">Mon profil</a>
		        <a href="DeconnexionServlet" class="lienConnection">Déconnexion</a>
		    </div>
        </c:if>
		
	</nav>
	
</header>
<body>

	<h3 class="titreIndex">Liste des enchères</h3>
	
	<h4>Filtres : </h4>
	
	
	
	
	
</body>
</html>