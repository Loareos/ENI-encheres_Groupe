<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<meta author="Clément"/>
	<style type="text/css"><%@include file="../../../css/styleConnexion.css"%></style>
	<title>Modification Profil</title> 
	
</head>

<header>

    <nav>
		<h4>ENI-Enchères</h4> 
		
	</nav>
	
</header>
<body>


	<h3>Mon profil</h3> 

    <div class="profilInfos">
    <div class="profil">
        <label>Pseudo : </label>
        <label><%=request.getParameter("pseudo")%></label>
    </div>
    <br>
    <div class="profil">
        <label>Nom : </label>
        <label><%=request.getParameter("Nom")%></label>
    </div>
    <div class="profil">
        <label>Prénom : </label>
        <label><%=request.getParameter("Prenom")%></label>
    </div>
    <div class="profil">
        <label>Email : </label>
        <label><%=request.getParameter("Email")%></label>
    </div>
    <div class="profil">
        <label>Téléphone : </label>
        <label><%=request.getParameter("Telephone")%></label>
    </div>
    <div class="profil">
        <label>Rue : </label>
        <label><%=request.getParameter("Rue")%></label>
    </div>
    <div class="profil">
        <label>Code postal : </label>
        <label><%=request.getParameter("CodePostal")%></label>
    </div>
    <div class="profil">
        <label>Ville : </label>
        <label><%=request.getParameter("Ville")%></label>
    </div>
    <div class="profil">
        <label>Mot de passe actuel : </label>
        <label><%=request.getParameter("MdpActuel")%></label>
    </div>
    <div class="profil">
        <label>Nouveau mot de passe : </label>
        <label><%=request.getParameter("MdpNew")%></label>
    </div>
    <div class="profil">
        <label>Confirmation : </label>
        <label><%=request.getParameter("MdpNewConfirm")%></label>
    </div>
	</div>
	
	
	
	
	 <c:if test="${!empty moi}">
         
     </c:if>
	
</body>
</html>