package fr.eni.projet.dal;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Categorie;

public interface CategorieDAO extends DAO<Categorie> {

	public boolean idExist(Integer id) throws BusinessException;
}
