<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section>

	<h3 class="titreIndex">Liste des enchères</h3>

	<h4>Filtres :</h4>

	<!-- Servlet à mettre ?  -->
	<form method="post" action="RechercheServlet" class="RechercheServlet">

		<div class="selectionneur">
			<div class="selectionneurSpe">
				<label class="labCategorie">Catégorie : </label> <select
					name="selectionCategorie" class="selectionCategorie" size="1">
					<option>Toutes</option>
					<option>Ameublement</option>
					<option>Informatique</option>
					<option>Sport & Loisirs</option>
					<option>Vetement</option>
				</select>
			</div>
			<input type="text" placeholder="Le nom de l'article contient.."
				class="txtRecherche" />
		</div>

		<!-- PARTIE SI CONNECTÉ  -->
		<c:if test="${!empty utilisateur}">
			<div class="achat">
				<input type="radio" id="achat" name="achatVente" class="achatVente"
					value="achat" checked> <label for="achat">Achats</label> <input
					type="checkbox" id="encheresOuvertes" name="encheres"
					value="encheresOuvertes" checked> <label
					for="scencheresOuvertesales">Enchères ouvertes</label> <input
					type="checkbox" id="encheresEnCours" name="encheres"
					value="encheresEnCours"> <label for="encheresEnCours">Enchères
					en cours</label> <input type="checkbox" id="encheresRemportees"
					name="encheres" value="encheresRemportees"> <label
					for="encheresRemportees">Enchères remportées</label>
			</div>


			<div class="vente">
				<input type="radio" id="vente" name="achatVente" class="achatVente"
					value="vente"> <label for="vente">Mes Ventes</label> <input
					type="checkbox" id="ventesEnCours" name="ventes"
					value="ventesEnCours"> <label for="ventesEnCours">Mes
					ventes en cours</label> <input type="checkbox" id="ventesNonDebutees"
					name="ventes" value="ventesNonDebutees"> <label
					for="ventesNonDebutees">Ventes non débutées</label> <input
					type="checkbox" id="ventesTerminees" name="ventes"
					value="ventesTerminees"> <label for="ventesTerminees">Ventes
					terminées</label>
			</div>
		</c:if>

		<input type="submit" value="Rechercher" class="btnRecherche" />
	</form>


		<%@include file="/WEB-INF/jsp/Vente/ApercuArticle.jsp"%>

</section>