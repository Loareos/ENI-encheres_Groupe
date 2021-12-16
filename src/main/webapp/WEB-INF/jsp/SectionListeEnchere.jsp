<!-- 
@author Clément
Modif by LCB 
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="SectionListeEnchere">

	<h3>Liste des enchères</h3>

	<h4>Filtres :</h4>

	<!-- Servlet à mettre ?  -->
	<form method="post" action="RechercheServlet" class="RechercheServlet">

		<div class="selectionneur">
					<div class="selectionneurSpe">
							<label class="labCategorie">Catégorie : </label>
							<select name="selectionCategorie" class="selectionCategorie" size="1">
								<option>Toutes</option>
								<option>Ameublement</option>
								<option>Informatique</option>
								<option>Sport & Loisirs</option>
								<option>Vetement</option>
							</select>
						<input type="text" placeholder="Recherche"class="txtRecherche" />
					</div>
					<!-- PARTIE SI CONNECTÉ  -->
			<c:if test="${!empty utilisateur}">
					<div class="achatVente">
						<div class="achat">
							<div class="labelAchat">
									<label class="labelTitreAchat" for="achat">Achats</label>
								<input type="radio" id="achat" name="achatVente" class="btnMesAchat" value="achat" checked>
							</div>
							<div class="labelAchat">
									<label for="encheresOuvertes">Enchères ouvertes</label>
								<input type="checkbox" id="encheresOuvertes" name="encheres" value="encheresOuvertes" checked class="achats">
							</div>
							<div class="labelAchat">
									<label for="encheresEnCours">Enchères en cours</label>
								<input type="checkbox" id="encheresEnCours" name="encheres" value="encheresEnCours" class="achats">
							</div>
							<div class="labelAchat">
									<label for="encheresRemportees">Enchères remportées</label>
								<input type="checkbox" id="encheresRemportees" name="encheres" value="encheresRemportees" class="achats">
							</div>
						</div>
						<div class="vente">
							
							<div class="labelVente">
									<label class="labelTitreVente" for="vente">Mes Ventes</label>
								<input type="radio" id="vente" name="achatVente" class="btnMesVentes" value="vente">
							</div>
							<div class="labelVente">
									<label for="ventesEnCours">Mes ventes en cours</label>
								<input type="checkbox" id="ventesEnCours" name="ventes" value="ventesEnCours" class="ventes">
							</div>
							<div class="labelVente">
									<label for="ventesNonDebutees">Ventes non débutées</label>
								<input type="checkbox" id="ventesNonDebutees" name="ventes" value="ventesNonDebutees" class="ventes">
							</div>
							<div class="labelVente">
									<label for="ventesTerminees">Ventes terminées</label>
								<input type="checkbox" id="ventesTerminees" name="ventes" value="ventesTerminees" class="ventes">
						</div>
						
						</div>
					</div>
							
			</c:if>
		</div>
		
		<div class="divBtRechercher">
			<input type="submit" value="Rechercher" class="btnRecherche" />
		</div>

	</form>
		<div class="annonces">
			<c:forEach items="${listeArticles}" var="art">
				<%@include file="/WEB-INF/jsp/Vente/ApercuArticle.jsp"%>
			</c:forEach>
		</div>
		
</section>