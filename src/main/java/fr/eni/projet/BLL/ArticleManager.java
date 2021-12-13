package fr.eni.projet.BLL;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Categorie;
import fr.eni.projet.dal.ArticleDAO;
import fr.eni.projet.dal.DAOFactory;

/*
 * @author /!\ /!\ /!\ /!\ /!\ /!\ auteur à mettre /!\ /!\ /!\ /!\ /!\ (robin)
 * 	Modif by
 */
public class ArticleManager {
	private ArticleDAO articleDao;
	private static ArticleManager instance;

	public static ArticleManager getInstance() throws BusinessException {
		if (instance == null) {
			try {
				instance = new ArticleManager();
			} catch (Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatBLL.GET_INSTANCE);
				throw businessException;
			}
		}
		return instance;
	}

	private ArticleManager() throws BusinessException {
		articleDao = DAOFactory.getArticleDAO();
	}

	// ========== CREATION ARTICLE=========

	// public Article ajouterArticleStandard(String nom, String description, String
	// prix) {
	// BusinessException exception = new BusinessException();

	// Article art = new Article(nom, description, prix);

	// ============CATEGORIE=============

	public Categorie ajouterCategorie(String informatique, String utilitaire, String manutention) {
		BusinessException exception = new BusinessException();
		return null;

	}

//================MODIF CATEGORIE===============
	public Categorie modifCategorie(String nom, String description, String prix) {
		BusinessException exception = new BusinessException();
		return null;

	}
}
