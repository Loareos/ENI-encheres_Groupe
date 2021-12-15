<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 

<html>

<head> 

	<meta charset="UTF-8">
	<meta author="Clément"/>
	<style type="text/css"><%@include file="../../../css/styleIndex.css"%></style>
	<title>Créer un compte</title>

</head>

<body> 

	<nav>
		<h4>ENI-Enchères</h4>
	</nav>
	
	<form method="post" action="InscriptionServlet" class="formConnexionC">
	
		<div class="formItemConnexionC">
			<label class="label">Pseudo : </label>
       		<input class="input" type="text" name="PseudoI" value="<%=request.getParameter("PseudoI")!=null?request.getParameter("PseudoI"):""%>" required/>
       		
       		<label class="label">Nom : </label>
       		<input class="input" type="text" name="NomI" value="<%=request.getParameter("NomI")!=null?request.getParameter("NomI"):""%>" required/>
		</div> 
		
		<div class="formItemConnexionC">
			<label class="label">Prénom : </label>
       		<input class="input" type="text" name="PrenomI" value="<%=request.getParameter("PrenomI")!=null?request.getParameter("PrenomI"):""%>" required/>
       		
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


</body>

</html>