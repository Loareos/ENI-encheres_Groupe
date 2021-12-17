<!-- 
@author Clément
Modif by LCB 
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<!-- <meta author="Clément" /> -->
<style type="text/css"><%@include file="../../../../css/styleIndex.css"%></style>

<title>Accueil</title>

</head>
<body>

<!--===========================Header==================================-->
		<%@include file="/WEB-INF/jsp/header.jsp" %>
<!--===========================section==================================-->
		
	<section>
		<h3>Nouvelle vente :</h3>
		
		
		<img class="imgArticle" alt="" src="/imageBase.png">

		<form method="post" action="VenteArticleServlet" >
		
		    <div>
			    <label class="label">Article : </label>
       		    <input class="input" type="text" name="Nom" />
		    </div> 
		    
		    <div>
			    <label class="label">Description : </label>
       		    <input class="input" type="text" name="Description" />
		    </div>
		     
            <div>
		        <label class="label">Début de l'enchère : </label>
       		    <input class="input" type="date" name="DateDebut" />
		    </div>
		   <div>
		        <label class="label">Fin de l'enchère : </label>
       		    <input class="input" type="date" name="DateFin" />
		    </div>		

		    <div>
		        <label class="label">Mise à prix : </label>
       		    <input class="input" type="number" name="MiseAPrix" />
		    </div>
		        
			<div class="selectionneur">
				<label class="labCategorie">Catégorie : </label> 
				<select name="Categorie">
					<option value="1">Informatique</option>
					<option value="2">Ameublement</option>
					<option value="3">Vetement</option>
					<option value="4">Sport&Loisirs</option>
				</select>
			</div>
		    
		    <fieldset>
		    
		        <legend>Retrait</legend>
		        <div>
			        <label class="label">Rue : </label>
       		        <input class="input" type="text" name="RueRetrait" value="${utilisateur.getRue()}" />
		        </div> 
		        
		        <div>
			        <label class="label">Code postal : </label>
       		        <input class="input" type="text" name="CodePostalRetrait" value="${utilisateur.getCodePostal()}"/>
       		    </div>
       		    <div>
       	        	<label class="label">Ville : </label>
       		        <input class="input" type="text" name="VilleRetrait" value="${utilisateur.getVille()}"/>
		        </div>
		        
		    </fieldset>
				<div class="divBtRechercher">
					<input type="submit" value="Enregistrer" /> 
				</div>
		</form>
		        <button onclick="history.back()" style="margin-left : 20px">Annuler</button>
	</section>
<!--===========================footer==================================-->
		<%@include file="/WEB-INF/jsp/footer.jsp" %>

</body>
</html>