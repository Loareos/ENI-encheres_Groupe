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

    <form method="post" action="ModifProfilServlet" class="formConnexionC">
	
		<div class="formItemConnexionC">
			<label class="label">Pseudo : </label>
       		<input class="input" type="text" name="PseudoI" value="<%=request.getParameter("PseudoI")!=null?request.getParameter("PseudoI"):""%>"/>
       		
       		<label class="label">Nom : </label>
       		<input class="input" type="text" name="NomI" value="<%=request.getParameter("NomI")!=null?request.getParameter("NomI"):""%>"/>
		</div> 
		
		<div class="formItemConnexionC">
			<label class="label">Prénom : </label>
       		<input class="input" type="text" name="PrénomI" value="<%=request.getParameter("PrénomI")!=null?request.getParameter("PrénomI"):""%>"/>
       		
       		<label class="label">Email : </label>
       		<input class="input" type="email" name="emailI" value="<%=request.getParameter("emailI")!=null?request.getParameter("emailI"):""%>"/>
		</div>
		
		<div class="formItemConnexionC"> 
			<label class="label">Téléphone : </label>
       		<input class="input" type="tel" pattern="[0-9]{10}" placeholder="0612345678" name="telI" value="<%=request.getParameter("telI")!=null?request.getParameter("numeroI"):""%>"/>
       		
       		<label class="label">Rue : </label>
       		<input class="input" type="text" name="RueI" value="<%=request.getParameter("RueI")!=null?request.getParameter("RueI"):""%>"/>
		</div>
		
		<div class="formItemConnexionC">
			<label class="label">Code postal : </label>
       		<input class="input" type="text" name="codePostalI" value="<%=request.getParameter("codePostalI")!=null?request.getParameter("codePostalI"):""%>"/>
       		
       		<label class="label">Ville : </label>
       		<input class="input" type="text" name="VilleI" value="<%=request.getParameter("VilleI")!=null?request.getParameter("VilleI"):""%>"/>
		</div>
		
		<div class="formItemConnexionC">
			<label class="label">Mot de passe : </label>
       		<input class="input" type="password" name="passwordI" value="<%=request.getParameter("passwordI")!=null?request.getParameter("passwordI"):""%>"/>
       
			<label class="label" style="width: 265px;"></label>
        </div>
		
		<div class="formItemConnexionC">
			<label class="label">Nouveau mdp : </label>
       		<input class="input" type="password" name="newPasswordI" value="<%=request.getParameter("newPasswordI")!=null?request.getParameter("newPasswordI"):""%>"/>
       		
       		<label class="label">Confirmation : </label>
       		<input class="input" type="password" name="newPasswordConfirmI" value="<%=request.getParameter("newPasswordConfirmI")!=null?request.getParameter("newPasswordConfirmI"):""%>"/>
		</div>
		
		<div class="btn">
			<input type="submit" value="Modifier" style="margin-right : 20px" />
		    <button type="submit" onclick="history.back()" style="margin-left : 20px">Retour</button>
		</div>

	</form>
	
	
</body>
</html>