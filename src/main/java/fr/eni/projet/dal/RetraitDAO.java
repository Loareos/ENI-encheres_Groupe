package fr.eni.projet.dal;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Retrait;

public interface RetraitDAO extends DAO<Retrait> {
	
	public boolean verifRetrait(int noArticle) throws BusinessException;

}
