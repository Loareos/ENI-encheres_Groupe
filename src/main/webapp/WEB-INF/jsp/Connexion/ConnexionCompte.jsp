<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8">
	<style type="text/css"><%@include file="../../../css/styleConnexion.css"%></style>
	<title>Se connecter à un compte</title>

</head>

<body> 

	<nav>
		<h4>ENI-Enchères</h4>
	</nav> 
	
	<form method="post" action="<%=request.getContextPath()%>/jsp/Connexion/ConnexionServlet" class="formConnexion">
	
		<div class="formItemConnexion">
			<label>Identifiant : </label>
       		<input type="text" name="texteIdentifiantC" value="<%=request.getParameter("texteIdentifiantC")!=null?request.getParameter("texteIdentifiantC"):""%>" required/>
		</div>
		
        <br>
        
        <div class="formItemConnexion">
       		<label>Mot de passe : </label>
        	<input type="password" name="passwordC" value="<%=request.getParameter("passwordC")!=null?request.getParameter("passwordC"):""%>" required/>
        </div>
        
		<br>
		
		<div class="connexion">
			<input type="submit" value="Connection" />
			
			<div class="connexionOptions">
				<div>
					<input type="checkbox"/>
					<label>Se souvenir de moi</label>
				</div>
				<br>
				<a href="jsp/SERVLET"> Mot de passe oublié</a> 
			</div>
		</div>
		
	</form>
	
	<form action="InscriptionServlet" class="formConnexion">
		<button type="submit">Créer un compte</button>
	</form>


</body>

</html>