package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.BO.Enchere;

public interface EnchereDAO extends DAO<Enchere> {
	
	public Enchere selectById(int idUser, int idArticle) throws BusinessException;
	public void delete(int idUser, int idArticle) throws BusinessException;
	boolean enchereExist(int noUtilisateur, int noArticle) throws BusinessException;
	public Enchere selectById(int idEnchere) throws BusinessException;
	public Enchere selectByIdMontant(int idEnchere, int montant) throws BusinessException;
	public List<Enchere> selectAll(int idArticle) throws BusinessException;
}
