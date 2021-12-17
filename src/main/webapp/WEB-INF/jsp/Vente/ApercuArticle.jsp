<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<article>
		<div class="divImg">
<!-- 			<img class="imgArticle" alt="" src="/imageBase.png"> -->
<%-- 			<%@include file="../../../../" %> --%>
		</div>
	
		<div class="caseTxt">
			<a href="AfficherArticleServlet?id=${art.getNoArticle()}">${art.getNomArticle()}</a>
			<p>Prix de départ: ${Newarticles.get(1).getMiseAPrix()} points</p>
			<p>Fin de l'enchère: ${art.getDateFinEncheres()}</p>
			<p>
				Vendeur: <a href="ProfilServlet?id=${art.getVendeur().getPseudo()}">${art.getVendeur().getPseudo()}</a>
			</p>
		</div>
	
	</article>
