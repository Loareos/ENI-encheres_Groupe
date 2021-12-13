<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<meta author="Clément"/>
	<style type="text/css"><%@include file="../../../css/styleConnexion.css"%></style>
	<title>Profil</title> 
	
</head>

<header>

    <nav>
		<h4>ENI-Enchères</h4> 
		
	</nav>
	
</header>
<body>

	<!-- Comparer les id -->
    <c:if test="${empty MonProfil}">   
	   <h3>${profilSelectionneUser.getPseudo()}</h3> 
    </c:if>
    
    <c:if test="${!empty MonProfil}">   
	   <h3>Mon profil</h3> 
    </c:if>

	<div class="profilInfos">
	   <!-- Mon profil personnel -->
		<c:if test="${!empty MonProfil}">
		    <div class="profil">
		    	<label>Pseudo : </label> 
		    	<label>${utilisateur.getPseudo()}</label>
		    </div>
			<div class="profil">
				<label>Nom : </label> 
				<label>${utilisateur.getNom()}</label>
			</div>
			<div class="profil">
				<label>Prénom : </label> 
				<label>${utilisateur.getPrenom()}</label>
			</div>
			<div class="profil">
				<label>Email : </label> 
				<label>${utilisateur.getEmail()}</label>
			</div>
			<div class="profil">
				<label>Téléphone : </label> 
				<label>${utilisateur.getTelephone()}</label>
			</div>
			<div class="profil">
				<label>Rue : </label> 
				<label>${utilisateur.getRue()}</label>
			</div>
			<div class="profil">
				<label>Code postal : </label> 
				<label>${utilisateur.getCodePostal()}</label>
			</div>
			<div class="profil">
				<label>Ville : </label> 
				<label>${utilisateur.getVille()}</label>
			</div>
			<div class="profil">
				<label>Crédit : </label> 
				<label>${utilisateur.getCredit()}</label>
			</div>
		</c:if>
		
		<!-- Profil public d'un user -->
		<c:if test="${empty MonProfil}">
		    <div class="profil">
		    	<label>Pseudo : </label> 
		    	<label>${profilSelectionneUser.getPseudo()}</label>
		    </div>
			<div class="profil">
				<label>Code postal : </label> 
				<label>${profilSelectionneUser.getCodePostal()}</label>
			</div>
			<div class="profil">
				<label>Ville : </label> 
				<label>${profilSelectionneUser.getVille()}</label>
			</div>
		</c:if>
		
	</div>



	<!-- Comparer les id -->
	 <c:if test="${!empty MonProfil}">
        <form action="ModifProfilServlet" class="btn"><!-- SERVLET a rajouter -->
		    <button type="submit">Modifier</button>
	    </form>
     </c:if>
     
     <form action="ModificationProfil" class="btnRetour">
		    <button type="submit" onclick="history.back()">Retour</button>
	 </form>
	
</body>
</html>