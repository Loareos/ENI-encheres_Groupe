<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta author="Clément" />
<style type="text/css"><%@include file="css/styleIndex.css"%></style>

<title>Accueil</title>

</head>

<header>

	<nav>
		<h4>ENI-Enchères</h4>

		<c:if test="${empty utilisateur}">
			<a href="ConnexionServlet" class="lienConnection">S'inscrire - Se connecter</a>
		</c:if>

		<c:if test="${!empty utilisateur}">
			<div class="liens">
				<a href="SERVLET" class="lienConnection">Enchères</a> 
				<a href="SERVLET" class="lienConnection">Vendre un article</a> 
				<form method="post" action="ProfilServlet">
				    <input name="profilSelectionne" value="${utilisateur.getPseudo()}" ></input>
					<input type="submit" value="Mon profil" class="lienConnection" />
				</form>
				<a href="DeconnexionServlet" class="lienConnection">Déconnexion</a>
			</div>
		</c:if>

	</nav>

</header>
<body>

	<h3 class="titreIndex">Liste des enchères</h3>

	<h4>Filtres :</h4>

	<!-- Servlet à mettre ?  -->
	<form method="post" action="RechercheServlet" class="RechercheServlet">
		
		<div class="selectionneur" >
		  <div class="selectionneurSpe">
		    <label class="labCategorie">Catégorie : </label>
			<select name="selectionCategorie" class="selectionCategorie" size="1">
				<option>Toutes</option>
				<option>Ameublement</option>
				<option>Informatique</option>
				<option>Sport & Loisirs</option>
				<option>Vetement</option>
			</select>
	      </div>
		<input type="text" placeholder="Le nom de l'article contient.." class="txtRecherche" />
		</div>

		<input type="submit" value="Rechercher" class="btnRecherche"/>
	</form>



</body>
</html>