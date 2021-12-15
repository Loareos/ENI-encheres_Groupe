<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<article>
		<div class="divImg">
			<img class="imgArticle" alt="Image appareill photo" src="../../../../imageBase.png">
		</div>
	
		<div class="caseTxt">
			<h4>${art.getNomArticle()}</h4>
			<p>Prix: ${art.getMiseAPrix()} points</p>
			<p>Fin de l'enchère: ${art.getDateFinEncheres()}</p>
			<p>
				Vendeur: <a href="" name="" value="">${art.getVendeur().getPseudo()}</a>
			</p>
		</div>
	
	</article>
