<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css"><%@include file="../../../css/styleApercuArticle.css"%></style>
<title>Apercu d'un article</title>
</head>
<body>

	<div class="case">
		<div class="caseImg">
			<img src="">
		</div>
		
		<div class="caseTxt">
			<h4>${ArticleVendu.getNomArticle()}</h4>
			<p>Prix: ${Enchere.getMontant_enchere()} points</p>
			<p>Fin de l'enchère: ${ArticleVendu.getDateFinEncheres}</p>
			<p>Vendeur: <a href="" name="" value="">${Vendeur.getPseudo()}</a></p>
		</div>
	</div>

</body>
</html>