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
//	
//	/**
//	 * @return un objet Utilisateur en cas de succcès
//	 * @throws BLLException 
//	 * @throws DALException 
//	 */
//	public Categorie ajouterUtilisateurStandard(Categorie Categorie)
//												throws BLLException, DALException{
//		String test;
//		
//		test = Categorie.getLibelle();
//		this.verifStringNombreEtVide(test, 30,exception);
//		
//		if(!exception.hasErreurs())
//		{
//				this.CategorieDao.insert(Categorie);
//		}
//		
//		if(exception.hasErreurs())
//		{
//			throw exception;
//		}
//		return Categorie;
//	}
//	
//	/**
//	 * Cette méthode permet de vérifier 
//	 * les règles à respecter sur le nombre de caractère et qu'il ne soit pas vide.
//	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BLLException.
//	 * @param Categorie
//	 * @throws BLLException 
//	 * @param BLLException 
//	 */
//	public void verifStringNombreEtVide(String test, int max,BLLException exception){
//		
//		if (test.trim().length()>max ? false: true ) {
//			exception.ajouterErreur(CodesResultatBLL.INSERT_OBJET_ECHEC_MAX);
//		}
//		if (test.trim().length() == 0? false: true ) {
//			exception.ajouterErreur(CodesResultatBLL.INSERT_OBJET_NULL);
//		}
//	}

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
