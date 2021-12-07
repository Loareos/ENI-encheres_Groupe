<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head> 

	<meta charset="UTF-8">
	<link rel="stylesheet" href="../../css/styleConnexion.css"/>
	<title>Créer un compte</title>

</head>

<body> 

	<nav>
		<h4>ENI-Enchères</h4>
	</nav>
	
	<form method="post" action="<%=request.getContextPath()%>/jsp/AjoutCompte" class="formConnexion">
	
		<div class="formItemConnexion">
			<label>Identifiant : </label>
       		<input type="text" name="texteIdentifiant" value="<%=request.getParameter("texteIdentifiant")!=null?request.getParameter("texteIdentifiant"):""%>" required/>
       		
       		<label>Nom : </label>
       		<input type="text" name="texteNom" value="<%=request.getParameter("texteNom")!=null?request.getParameter("texteNom"):""%>" required/>
		</div>
		
		<div class="formItemConnexion">
			<label>Prénom : </label>
       		<input type="text" name="textePrénom" value="<%=request.getParameter("textePrénom")!=null?request.getParameter("textePrénom"):""%>" required/>
       		
       		<label>Email : </label>
       		<input type="email" name="email" value="<%=request.getParameter("email")!=null?request.getParameter("email"):""%>" required/>
		</div>
		
		<div class="formItemConnexion">
			<label>Téléphone : </label>
       		<input type="text" name="numero" value="<%=request.getParameter("numero")!=null?request.getParameter("numero"):""%>" required/>
       		
       		<label>Rue : </label>
       		<input type="text" name="texteRue" value="<%=request.getParameter("texteRue")!=null?request.getParameter("texteRue"):""%>" required/>
		</div>
		
		<div class="formItemConnexion">
			<label>Code postal : </label>
       		<input type="text" name="codePostal" value="<%=request.getParameter("codePostal")!=null?request.getParameter("codePostal"):""%>" required/>
       		
       		<label>Ville : </label>
       		<input type="text" name="texteVille" value="<%=request.getParameter("texteVille")!=null?request.getParameter("texteVille"):""%>" required/>
		</div>
		
		<div class="formItemConnexion">
			<label>Mot de passe : </label>
       		<input type="password" name="password" value="<%=request.getParameter("password")!=null?request.getParameter("password"):""%>" required/>
       		
       		<label>Confirmation : </label>
       		<input type="password" name="passwordConfirm" value="<%=request.getParameter("passwordConfirm")!=null?request.getParameter("passwordConfirm"):""%>" required/>
		</div>
		
		<div>
			<input type="submit" value="Connection" />
			
			
		</div>
		
	</form>
	
	<form action="<%=request.getContextPath()%>/index.html">
			<button type="submit">Annuler</button>
	</form>

</body>

</html>