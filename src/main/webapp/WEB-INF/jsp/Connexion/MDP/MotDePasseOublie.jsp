<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
	<style type="text/css"><%@include file="../../../../css/styleConnexion.css"%></style>
    <title>Mot de passe oublié</title>
</head>

<body>

	<h2>Mot de passe oublié ?</h2>

	<form method="post" action="ConnexionServlet" class="formConnexion">
		<div class="formGroupeItemConnexion">

			<div class="formItemConnexion">
				<label>Mail pour renouveler le mot de passe : </label> 
				<input type="text" name="identifiantC" required />
			</div>

		</div>
		<br> <br>
		<div class="connexion">
			<input type="submit" value="Envoyer" />
		</div>
	</form>

</body>
</html>