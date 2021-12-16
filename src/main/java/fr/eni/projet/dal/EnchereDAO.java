package fr.eni.projet.dal;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Enchere;

public interface EnchereDAO extends DAO<Enchere> {
	
	public Enchere selectById(int idUser, int idArticle) throws BusinessException;
	public void delete(int idUser, int idArticle) throws BusinessException;
	boolean enchereExist(int noUtilisateur, int noArticle) throws BusinessException;
}
