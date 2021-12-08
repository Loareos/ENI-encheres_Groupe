<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 

<html>

<head> 

	<meta charset="UTF-8">
	<meta author="Clément"/>
	<style type="text/css"><%@include file="../../../css/styleConnexion.css"%></style>
	<title>Créer un compte</title>

</head>

<body> 

	<nav>
		<h4>ENI-Enchères</h4>
	</nav>
	
	<form method="post" action="<%=request.getContextPath()%>/jsp/Connexion/InscriptionServlet" class="formConnexion">
	
		<div class="formItemConnexion">
			<label>Pseudo : </label>
       		<input type="text" name="PseudoI" value="<%=request.getParameter("PseudoI")!=null?request.getParameter("PseudoI"):""%>" required/>
       		
       		<label>Nom : </label>
       		<input type="text" name="NomI" value="<%=request.getParameter("NomI")!=null?request.getParameter("NomI"):""%>" required/>
		</div> 
		
		<div class="formItemConnexion">
			<label>Prénom : </label>
       		<input type="text" name="PrénomI" value="<%=request.getParameter("PrénomI")!=null?request.getParameter("PrénomI"):""%>" required/>
       		
       		<label>Email : </label>
       		<input type="email" name="emailI" value="<%=request.getParameter("emailI")!=null?request.getParameter("emailI"):""%>" required/>
		</div>
		
		<div class="formItemConnexion"> 
			<label>Téléphone : </label>
       		<input type="tel" pattern="[0-9]{10}" placeholder="0612345678" name="telI" value="<%=request.getParameter("telI")!=null?request.getParameter("numeroI"):""%>" required/>
       		
       		<label>Rue : </label>
       		<input type="text" name="RueI" value="<%=request.getParameter("RueI")!=null?request.getParameter("RueI"):""%>" required/>
		</div>
		
		<div class="formItemConnexion">
			<label>Code postal : </label>
       		<input type="text" name="codePostalI" value="<%=request.getParameter("codePostalI")!=null?request.getParameter("codePostalI"):""%>" required/>
       		
       		<label>Ville : </label>
       		<input type="text" name="VilleI" value="<%=request.getParameter("VilleI")!=null?request.getParameter("VilleI"):""%>" required/>
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