<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta author="Clement">
<title>Détails de la vente</title>
</head>
<body>
	<h2>Détails de la vente</h2>
	
	<img class="imgArticle" alt="" src="/imageBase.png">

		<form method="get" action="VenteArticleServlet" >
		
		    <div>
			    <label class="label">${article.getNomArticle()}</label>
		    </div> 
		    
		    <div>
			    <label class="label">Description : </label>
                <label class="label">${article.getDescription()}</label>
		    </div>
		     
            <div>
			    <label class="label">Catégorie : </label>
                <label class="label">${article.getCategorie().getLibelle()}</label>
		    </div>
		    
		    <div>
		    
			    <label class="label">Meilleure offre : </label>
			    
			    <c:if test="${!empty acheteur.getAcheteur()}"> 
                    <label class="label">${acheteur.getMontant_enchere()} pts par ${acheteur.getAcheteur()} </label>
			    </c:if>
			    
			    <c:if test="${empty acheteur.getAcheteur()}"> 
                    <label class="label">Personne n'a encore fait de proposition </label>
			    </c:if>
			    
		    </div>
		    
            <div>
			    <label class="label">Mise à prix : </label>
                <label class="label">${article.getMiseAPrix()} points </label>
		    </div>
		    
            <div>
			    <label class="label">Fin de l'enchère : </label>
                <label class="label">${article.getDateFinEncheres()}</label>
		    </div>
		    
            <div>
			    <label class="label">Retrait : </label>
			    <div>
                    <label class="label">${article.getVendeur().getRue()}</label>
                    <label class="label">${article.getVendeur().getCodePostal()} ${article.getVendeur().getVille()}</label>
			    </div>
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
			
			<!-- 
			<div>
			    <label class="label">Photo de l'article : </label>
			    <button>Uploader</button>
		    </div> 
			 -->
		    
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
		
			<div class="btn">
				<input type="submit" value="Enregistrer" /> 
			</div>
		</form>
        
        <button onclick="history.back()" style="margin-left : 20px">Annuler</button>
	
</body>
</html>