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

		<form method="post" action="AfficherArticleServlet" >
		
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
			    
			    <c:if test="${empty RAS}"> 
                    <label class="label">${acheteur.getMontant_enchere()} pts par ${acheteur.getAcheteur().getPseudo()} </label>
			    </c:if>
			    
			    <c:if test="${!empty RAS}"> 
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
		    
            <div>
			    <label class="label">Vendeur : </label>
                <a class="label" href="ProfilServlet?id=${article.getVendeur().getPseudo()}">${article.getVendeur().getPseudo()}</a>
		    </div>
		    
		    <c:if test="${user}"> 
                <div>
			        <label class="label">Ma proposition : </label>
                    <input class="label" type="number" name="montant" min="${article.getMiseAPrix() + 1}" required/>
                    <input class="label" name="id" value="${article.getNoArticle()}" hidden/>
                    <input type="submit" value="Enchérir" /> 
                </div>
			</c:if>
			<c:if test="${!user}"> 
			    <label class="label">Merci de vous connecter </label>   
			    <a href="ConnexionServlet" class="lienConnection">(en cliquant ici)</a>
			    <label> pour pouvoir enchérir.</label> 
			</c:if>
		    
		        
		</form>
        
        <button onclick="window.location.href='AccueilServlet';" style="margin-left : 20px">Annuler</button>
	
</body>
</html>