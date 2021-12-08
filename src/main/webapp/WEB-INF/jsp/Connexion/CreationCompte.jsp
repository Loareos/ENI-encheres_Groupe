<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head> 

	<meta charset="UTF-8">
	<link rel="stylesheet" href="../../../css/styleConnexion.css"/>
	<title>Créer un compte</title>

</head>

<body> 

	<nav>
		<h4>ENI-Enchères</h4>
	</nav>
	
	<form method="post" action="<%=request.getContextPath()%>/jsp/Connexion/InscriptionServlet" class="formConnexion">
	
		<div class="formItemConnexion">
			<label>Pseudo : </label>
       		<input type="text" name="textePseudoI" value="<%=request.getParameter("textePseudoI")!=null?request.getParameter("textePseudoI"):""%>" required/>
       		
       		<label>Nom : </label>
       		<input type="text" name="texteNomI" value="<%=request.getParameter("texteNomI")!=null?request.getParameter("texteNomI"):""%>" required/>
		</div> 
		
		<div class="formItemConnexion">
			<label>Prénom : </label>
       		<input type="text" name="textePrénomI" value="<%=request.getParameter("textePrénomI")!=null?request.getParameter("textePrénomI"):""%>" required/>
       		
       		<label>Email : </label>
       		<input type="email" name="emailI" value="<%=request.getParameter("emailI")!=null?request.getParameter("emailI"):""%>" required/>
		</div>
		
		<div class="formItemConnexion"> 
			<label>Téléphone : </label>
       		<input type="tel" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" name="numeroI" value="<%=request.getParameter("numeroI")!=null?request.getParameter("numeroI"):""%>" required/>
       		
       		<label>Rue : </label>
       		<input type="text" name="texteRueI" value="<%=request.getParameter("texteRueI")!=null?request.getParameter("texteRueI"):""%>" required/>
		</div>
		
		<div class="formItemConnexion">
			<label>Code postal : </label>
       		<input type="text" name="codePostalI" value="<%=request.getParameter("codePostalI")!=null?request.getParameter("codePostalI"):""%>" required/>
       		
       		<label>Ville : </label>
       		<input type="text" name="texteVilleI" value="<%=request.getParameter("texteVilleI")!=null?request.getParameter("texteVilleI"):""%>" required/>
		</div>
		
		<div class="formItemConnexion">
			<label>Mot de passe : </label>
       		<input type="password" name="passwordI" value="<%=request.getParameter("passwordI")!=null?request.getParameter("passwordI"):""%>" required/>
       		
       		<label>Confirmation : </label>
       		<input type="password" name="passwordConfirmI" value="<%=request.getParameter("passwordConfirmI")!=null?request.getParameter("passwordConfirmI"):""%>" required/>
		</div>
		
		<div class="btnConnexion">
			<input type="submit" value="Créer" />
			<input type="button" name="Annuler" value="Annuler" onClick="window.location.href='<%=request.getContextPath()%>/index.jsp';"/>
		</div>
		
	</form>


</body>

</html>