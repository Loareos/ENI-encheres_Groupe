/**
 * 
 */
package fr.eni.projet.BLL;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Categorie;
import fr.eni.projet.dal.CategorieDAO;
import fr.eni.projet.dal.DAOFactory;

/**
 * @author /!\ /!\ /!\ /!\ /!\ /!\ auteur à mettre /!\ /!\ /!\ /!\ /!\ Modif by
 */
public class CategorieManager extends Manager {

	private CategorieDAO CategorieDao;
	private static CategorieManager instance;
	
	public static CategorieManager getInstance() throws BusinessException{
		if(instance == null) {
			try {
				instance = new CategorieManager();
			} catch (Exception e) {
				e.printStackTrace();
				BusinessException exception = new BusinessException();
				exception.ajouterErreur(CodesResultatBLL.GET_INSTANCE);
				throw exception;
			}
		}
		return instance;
	}
	
	private CategorieManager() throws BusinessException{
		CategorieDao = DAOFactory.getCategorieDAO();
	}

	// ====================== SELECT CATEGORIE =================================

	public List<Categorie> getAllCategorie() throws BusinessException {
		BusinessException exception = new BusinessException();

		List<Categorie> lstCategorieEnCours = new ArrayList<Categorie>();

		if (lstCategorieEnCours.size() != 0)
			return lstCategorieEnCours;
		else
			exception.ajouterErreur(CodesResultatBLL.CATEGORIE_INCONNU);
		throw exception;
	}
}
