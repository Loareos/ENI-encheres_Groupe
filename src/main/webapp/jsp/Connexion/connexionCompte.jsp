<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8">
	<link rel="stylesheet" href="../../css/styleConnexion.css"/>
	<title>Se connecter à un compte</title>

</head>

<body> 

	<nav>
		<h4>ENI-Enchères</h4>
	</nav>
	
	<form method="post" action="<%=request.getContextPath()%>/jsp/AjoutCompte">
		<label>Identifiant : </label>
        <input type="text" name="texteIdentifiant" value="<%=request.getParameter("texteIdentifiant")!=null?request.getParameter("texteIdentifiant"):""%>" required/>
        <br>
        
        <label>Mot de passe : </label>
        <input type="password" name="password" value="<%=request.getParameter("password")!=null?request.getParameter("password"):""%>" required/>
        <br>
		
		<div class="connexion">
			<input type="submit" value="Connection" />
			
			<div class="connexionOptions">
				<div>
					<input type="checkbox"/>
					<label>Se souvenir de moi</label>
				</div>
				<br>
				<a href="jsp/SERVLET">Mot de passe oublié</a>
			</div>
		</div>
		
	</form>
	
	<form action="<%=request.getContextPath()%>/jsp/Connexion/creationCompte.jsp">
		<button type="submit">Créer un compte</button>
	</form>


</body>

</html>