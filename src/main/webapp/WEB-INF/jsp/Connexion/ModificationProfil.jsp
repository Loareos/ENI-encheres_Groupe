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
       		<input class="input" type="text" name="PseudoI" value="${utilisateur.getPseudo()}"/>
       		
       		<label class="label">Nom : </label>
       		<input class="input" type="text" name="NomI" value="${utilisateur.getNom()}"/>
		</div> 
		
		<div class="formItemConnexionC">
			<label class="label">Prénom : </label>
       		<input class="input" type="text" name="PrenomI" value="${utilisateur.getPrenom()}"/>
       		
       		<label class="label">Email : </label>
       		<input class="input" type="email" name="emailI" value="${utilisateur.getEmail()}"/>
		</div>
		
		<div class="formItemConnexionC"> 
			<label class="label">Téléphone : </label>
       		<input class="input" type="tel" pattern="[0-9]{10}" placeholder="0612345678" name="telI" value="${utilisateur.getTelephone()}"/>
       		
       		<label class="label">Rue : </label> 
       		<input class="input" type="text" name="RueI" value="${utilisateur.getRue()}"/>
		</div>
		
		<div class="formItemConnexionC">
			<label class="label">Code postal : </label>
       		<input class="input" type="text" name="codePostalI" value="${utilisateur.getCodePostal()}"/>
       		
       		<label class="label">Ville : </label>
       		<input class="input" type="text" name="VilleI" value="${utilisateur.getVille()}"/>
		</div>
		
		<div class="formItemConnexionC" hidden="true">
			<label class="label"hidden="true">Mot de passe : </label>
       		<input class="input" type="password" name="ancienPasswordI" value=""hidden="true"/>
       
			<label class="label" style="width: 265px;"hidden="true"></label>
        </div>
		
		<div class="formItemConnexionC">
			<label class="label">Nouveau mdp : </label>
       		<input class="input" type="password" name="PasswordI" value=""/>
       		
       		<label class="label">Confirmation : </label>
       		<input class="input" type="password" name="PasswordConfirmI" value=""/>
		</div>
		
		<div class="btn">
			<input type="submit" name="enregistrer" value="Enregistrer" style="margin-right : 20px" />
			<input type="submit" name="supprimer" value="Supprimer mon compte" style="margin-right : 20px;margin-left : 20px" />
		    <button type="submit" onclick="history.back()" style="margin-left : 20px">Retour</button>
		</div>

	</form>
	
	
</body>
</html>