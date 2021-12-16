package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.ArticleVendu;

public interface ArticleDAO extends DAO<ArticleVendu> {

	public ArticleVendu selectByVendeur(Integer idVendeur) throws BusinessException;
	public ArticleVendu selectByCategorie(Integer idCategorie) throws BusinessException;
	public List<ArticleVendu> selectAll() throws BusinessException;
	public boolean idExist(Integer noArticle) throws BusinessException;
}
