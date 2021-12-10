package fr.eni.projet.BLL;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

/**
 * @author junisaru69
 *	Modif by Etienne
 */
public class UtilisateurManager {
	
	private UtilisateurDAO utilisateurDao;
	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() throws BusinessException{
		if(instance == null) {
			try {
				instance = new UtilisateurManager();
			} catch (Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatBLL.GET_INSTANCE);
				throw businessException;
			}
		}
		return instance;
	}
	
	private UtilisateurManager() throws BusinessException{
		utilisateurDao = DAOFactory.getUserDAO();
	}
	
	
	/**
	 * @return un objet Utilisateur en cas de succcès
	 */
	public void ajouterUtilisateurStandard(Utilisateur utilisateurStrd) throws BusinessException{
		BusinessException exception = new BusinessException();
		if(verifUser(utilisateurStrd, exception)) {		
//			if(this.utilisateurDao.pseudoExist(utilisateurStrd.getPseudo()))
//				exception.ajouterErreur(CodesResultatBLL.EXISTING_PSEUDO);
//		
//			if(this.utilisateurDao.mailExist(utilisateurStrd.getEmail()))
//				exception.ajouterErreur(CodesResultatBLL.EXISTING_MAIL);
		}
		
		if(!exception.hasErreurs())
			this.utilisateurDao.insert(utilisateurStrd);
		else
			throw exception;
	}
	
	private static boolean verifUser(Utilisateur user, BusinessException exception) {
		verifStringNombreEtVide(user.getPseudo(), 30 ,exception);
		verifStringNombreEtVide(user.getNom(), 30 ,exception);
		verifStringNombreEtVide(user.getPrenom(), 30 ,exception);
		verifStringNombreEtVide(user.getEmail(), 40 ,exception);
		verifStringNombreEtVide(user.getRue(), 30 ,exception);
		verifStringNombreEtVide(user.getCodePostal(), 10 ,exception);
		verifStringNombreEtVide(user.getVille(), 30 ,exception);
		verifStringNombreEtVide(user.getMotDePasse(), 30 ,exception);
		if(user.getTelephone() != null && user.getTelephone().length() > 15)
			exception.ajouterErreur(CodesResultatBLL.INSERT_PARAMETER_LENGTH_MAX);
		if(user.getCredit() < 0)
			exception.ajouterErreur(CodesResultatBLL.CREDIT_NEGATIF);
		
		if(!exception.hasErreurs())
			return true;
		else
			return false;
	}
	
	
	/**
	 * Cette méthode permet de vérifier 
	 * les règles à respecter sur le nombre de caractère et qu'il ne soit pas vide.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BLLException.
	 * @param utilisateurStrd
	 * @throws BLLException 
	 * @param BLLException 
	 */
	private static void verifStringNombreEtVide(String test, int max,BusinessException exception){
		if(test == null || test.length() == 0)
			exception.ajouterErreur(CodesResultatBLL.INSERT_PARAMETER_NULL);
		if(test.length() > max)
			exception.ajouterErreur(CodesResultatBLL.INSERT_PARAMETER_LENGTH_MAX);
	}
}
