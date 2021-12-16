<!-- 
@author Clément
Modif by LCB 
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>


<header>
	<div class="logoEnchere">
<!-- 		<img alt="Logo ENI" src=""> -->
		<a class="logoENI" href="AccueilServlet" >
		<h4>ENI-Enchères</h4>
		</a>
	</div>

	<c:if test="${empty utilisateur}">
		<a href="ConnexionServlet" class="lienConnection">Connexion</a>
	</c:if>

	<c:if test="${!empty utilisateur}">
		<div class="liens">
			<a href="AccueilServlet" class="lienConnection">Enchères</a> <a
				href="VenteArticleServlet" class="lienConnection">Vendre un
				article</a>
			<form method="post" action="ProfilServlet">
				<!-- Mettre un hidden après les tests -->
<!-- 				<input name="profilSelectionne" value="${utilisateur.getPseudo()}"></input>  -->
				<input type="submit" value="Mon profil" class="lienConnection" />
			</form>
			<a href="DeconnexionServlet" class="lienConnection">Déconnexion</a>

		</div>
	</c:if>


</header>