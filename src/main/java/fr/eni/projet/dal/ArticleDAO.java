package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.BO.Categorie;
import fr.eni.projet.BO.Utilisateur;

public interface ArticleDAO extends DAO<ArticleVendu> {

	boolean vendeurExiste(Utilisateur Vendeur);
	boolean categorieExiste(Categorie Categorie);
	public ArticleVendu selectByVendeur(Utilisateur vendeur) throws BusinessException;
	public ArticleVendu selectByCategorie(Categorie Categorie) throws BusinessException;
	public List<ArticleVendu> selectAll() throws BusinessException;
}
