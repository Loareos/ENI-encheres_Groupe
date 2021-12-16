/**
 * 
 */
package fr.eni.projet.BLL;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Categorie;

//import fr.eni.projet.BO.Utilisateur;
//import fr.eni.projet.dal.DALException;
//import fr.eni.projet.dal.DAOFactory;
//import fr.eni.projet.dal.CategorieDao;

/**
 * @author /!\ /!\ /!\ /!\ /!\ /!\ auteur à mettre /!\ /!\ /!\ /!\ /!\ Modif by
 */
public class CategorieManager {

//	private CategorieDAO CategorieDao;
//	private static CategorieManager instance;
//	private BLLException exception = new BLLException();
//	
//	public static CategorieManager getInstance() throws BLLException{
//		if(instance == null) {
//			try {
//				instance = new CategorieManager();
//			} catch (Exception e) {
//				throw new BLLException(e);
//			}
//		}
//		return instance;
//	}
//	
//	private CategorieManager() throws BLLException{
//		CategorieDao = DAOFactory.getCategorieDAO();
//	}
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
//	/**
//	 * Cette méthode vérifie 
//	 * les règles à respecter sur le nombre de caractère du telephone.
//	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BLLException.
//	 * @param test max
//	 * @param BLLException 
//	 * @throws BLLException 
//	 */
//	public void verifTelephone(String test, int max,BLLException exception){
//		
//		if (test.trim().length()>max ? false: true ) {
//			exception.ajouterErreur(CodesResultatBLL.INSERT_OBJET_ECHEC_MAX);
//		}

	// ====================== SELECT CATEGORIE =================================

	public List<Categorie> getCategorie() throws BusinessException {
		BusinessException exception = new BusinessException();

		List<Categorie> lstCategorieEnCours = new ArrayList<Categorie>();

		if (lstCategorieEnCours.size() != 0)
			return lstCategorieEnCours;
		else
			exception.ajouterErreur(CodesResultatBLL.CATEGORIE_INCONNU);
		throw exception;

	}
////	
//	/**
//	 * Cette méthode permet de vérifier 
//	 * les règles à respecter sur le crédit inferr à 0.
//	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BLLException.
//	 * @param credit max
//	 * @param BLLException 
//	 * @throws BLLException 
//	 */
//	public void verifCredit(int credit, int max,BLLException exception){
//		
//		if (credit<0 ? false: true ) {
//			exception.ajouterErreur(CodesResultatBLL.INSERT_OBJET_NULL);
//		}
//		
//	}
//	
//	
//	
//	
}
