<!-- 
@author Clément
Modif by LCB 
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<meta author="Clément"/>
	<style type="text/css"><%@include file="../../../css/styleIndex.css"%></style>
	<title>Profil</title> 
	
</head>
<body>
<!--===========================Header==================================-->
		<%@include file="/WEB-INF/jsp/header.jsp" %>
<!--===================================================================-->
 
	<!-- Comparer les id -->
    <c:if test="${!user}">   
	   <h3>${profil.getPseudo()}</h3> 
    </c:if>
    
    <c:if test="${user}">   
	   <h3>Mon profil</h3> 
    </c:if>

	<div class="profilInfos">
	   <!-- Mon profil personnel -->
		<c:if test="${!empty utilisateur}">
		    <div class="profil">
		    	<label>Pseudo : </label> 
		    	<label>${profil.getPseudo()}</label>
		    </div>
			<div class="profil">
				<label>Crédit : </label> 
				<label>${profil.getCredit()}</label>
			</div>
			<div class="profil">
				<label>Nom : </label> 
				<label>${profil.getNom()}</label>
			</div>
			<div class="profil">
				<label>Prénom : </label> 
				<label>${profil.getPrenom()}</label>
			</div>
			<div class="profil">
				<label>Email : </label> 
				<label>${profil.getEmail()}</label>
			</div>
			<div class="profil">
				<label>Téléphone : </label> 
				<label>${profil.getTelephone()}</label>
			</div>
			<div class="profil">
				<label>Rue : </label> 
				<label>${profil.getRue()}</label>
			</div>
		</c:if>

		<div class="profil">
			<label>Code postal : </label> 
			<label>${profil.getCodePostal()}</label>
		</div>
		<div class="profil">
			<label>Ville : </label> 
			<label>${profil.getVille()}</label>
		</div>		
	</div>



	<!-- Comparer les id -->
	 <c:if test="${!empty utilisateur}">
        <form action="ModifProfilServlet" class="btn"><!-- SERVLET a rajouter -->
		    <button type="submit">Modifier</button>
	    </form>
     </c:if>
     
     <form action="ModificationProfil" class="btnRetour">
		    <button type="submit" onclick="history.back()">Retour</button>
	 </form>
	 
<!--===========================footer==================================-->
		<%@include file="/WEB-INF/jsp/footer.jsp" %>
<!--===================================================================-->

</body>
</html>