<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détails de la vente</title>
</head>
<body>
	<h2>Détails de la vente</h2>
	
	<img class="imgArticle" alt="" src="/imageBase.png">

		<form method="get" action="VenteArticleServlet" >
		
		    <div>
			    <label class="label">${utilisateur.getPseudo()}</label>
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