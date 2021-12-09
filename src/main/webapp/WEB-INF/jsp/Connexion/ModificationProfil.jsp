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

    <form method="post" action="InscriptionServlet" class="formConnexionC">
	
		<div class="formItemConnexionC">
			<label class="label">Pseudo : </label>
       		<input class="input" type="text" name="PseudoI" value="<%=request.getParameter("PseudoI")!=null?request.getParameter("PseudoI"):""%>" required/>
       		
       		<label class="label">Nom : </label>
       		<input class="input" type="text" name="NomI" value="<%=request.getParameter("NomI")!=null?request.getParameter("NomI"):""%>" required/>
		</div> 
		
		<div class="formItemConnexionC">
			<label class="label">Prénom : </label>
       		<input class="input" type="text" name="PrénomI" value="<%=request.getParameter("PrénomI")!=null?request.getParameter("PrénomI"):""%>" required/>
       		
       		<label class="label">Email : </label>
       		<input class="input" type="email" name="emailI" value="<%=request.getParameter("emailI")!=null?request.getParameter("emailI"):""%>" required/>
		</div>
		
		<div class="formItemConnexionC"> 
			<label class="label">Téléphone : </label>
       		<input class="input" type="tel" pattern="[0-9]{10}" placeholder="0612345678" name="telI" value="<%=request.getParameter("telI")!=null?request.getParameter("numeroI"):""%>" required/>
       		
       		<label class="label">Rue : </label>
       		<input class="input" type="text" name="RueI" value="<%=request.getParameter("RueI")!=null?request.getParameter("RueI"):""%>" required/>
		</div>
		
		<div class="formItemConnexionC">
			<label class="label">Code postal : </label>
       		<input class="input" type="text" name="codePostalI" value="<%=request.getParameter("codePostalI")!=null?request.getParameter("codePostalI"):""%>" required/>
       		
       		<label class="label">Ville : </label>
       		<input class="input" type="text" name="VilleI" value="<%=request.getParameter("VilleI")!=null?request.getParameter("VilleI"):""%>" required/>
		</div>
		
		<div class="formItemConnexionC">
			<label class="label">Mot de passe : </label>
       		<input class="input" type="password" name="passwordI" value="<%=request.getParameter("passwordI")!=null?request.getParameter("passwordI"):""%>" required/>
       		
       		<label class="label">Confirmation : </label>
       		<input class="input" type="password" name="passwordConfirmI" value="<%=request.getParameter("passwordConfirmI")!=null?request.getParameter("passwordConfirmI"):""%>" required/>
		</div>
		
		<div class="btn">
			<input type="submit" value="Créer" />
			<input type="button" name="Annuler" value="Annuler" onClick="window.location.href='<%=request.getContextPath()%>/index.jsp';"/>
		</div>
		
	</form>

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