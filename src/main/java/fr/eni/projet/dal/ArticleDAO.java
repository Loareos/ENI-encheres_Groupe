package fr.eni.projet.dal;

import fr.eni.projet.BO.ArticleVendu;

public interface ArticleDAO extends DAO<ArticleVendu> {

	boolean vendeurExiste(Integer noVendeur);

	boolean categorieExiste(Integer noCategorie);

}
