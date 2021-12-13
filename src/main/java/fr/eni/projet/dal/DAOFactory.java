package fr.eni.projet.dal;

import fr.eni.projet.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.projet.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.projet.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.projet.dal.jdbc.RetraitDAOJdbcImpl;
import fr.eni.projet.dal.jdbc.UserDAOJdbcImpl;
/**
 * @author Loareos // Etienne
 *
 */

public class DAOFactory {
	public static UtilisateurDAO getUserDAO(){
		return new UserDAOJdbcImpl();
	}
	
	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}

	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}

	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOJdbcImpl();
	}
}
