<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<article>
		<div class="divImg">
<!-- 			<img class="imgArticle" alt="" src="/imageBase.png"> -->
<%-- 			<%@include file="../../../../" %> --%>
		</div>
	
		<div class="caseTxt">
			<h4>${ArticleVendu.getNomArticle()}</h4>
			<p>Prix: ${Enchere.getMontant_enchere()} points</p>
			<p>Fin de l'enchère: ${ArticleVendu.getDateFinEncheres}</p>
			<p>
				Vendeur: <a href="" name="" value="">${Vendeur.getPseudo()}</a>
			</p>
		</div>
	
	</article>
