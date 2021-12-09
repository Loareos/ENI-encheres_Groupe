/**
 * 
 */
package fr.eni.projet.BLL;

import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAO;
import fr.eni.projet.dal.DAOFactory;

/**
 * @author junisaru69
 *	Modif by Etienne
 */
public class UtilisateurManager {
	
	private DAO<Utilisateur> UtilisateurDao;
	private static UtilisateurManager instance;
	private BLLException exception = new BLLException();
	
	public static UtilisateurManager getInstance() throws BLLException{
		if(instance == null) {
			try {
				instance = new UtilisateurManager();
			} catch (Exception e) {
				throw new BLLException(e);
			}
		}
		return instance;
	}
	
	private UtilisateurManager() throws BLLException{
		UtilisateurDao = DAOFactory.getUserDAO();
	}
	/**
	 * @return un objet Utilisateur en cas de succcès
	 * @throws BLLException 
	 * @throws DALException 
	 */
	public Utilisateur ajouterUtilisateurStandard(Utilisateur utilisateurStrd)
												throws BLLException, DALException{
		String test;
		
		test = utilisateurStrd.getPseudo();
		this.verifStringNombreEtVide(test, 30,exception);
		test = utilisateurStrd.getNom();
		this.verifStringNombreEtVide(test, 30,exception);
		test = utilisateurStrd.getPrenom();
		this.verifStringNombreEtVide(test, 30,exception);
		test = utilisateurStrd.getEmail();
		this.verifStringNombreEtVide(test, 20,exception);
		test = utilisateurStrd.getTelephone();
		this.verifStringNombreEtVide(test, 15,exception);
		test = utilisateurStrd.getRue();
		this.verifStringNombreEtVide(test, 30,exception);
		test = utilisateurStrd.getCodePostal();
		this.verifStringNombreEtVide(test, 10,exception);
		test = utilisateurStrd.getVille();
		this.verifStringNombreEtVide(test, 30,exception);
		test = utilisateurStrd.getMotDePasse();
		this.verifStringNombreEtVide(test, 30,exception);
		
		
		
		if(!exception.hasErreurs())
		{
				this.UtilisateurDao.insert(utilisateurStrd);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return utilisateurStrd;
	}
	
	/**
	 * Cette méthode permet de vérifier 
	 * les règles à respecter sur le nombre de caractère et su'il ne soit pas vide.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BLLException.
	 * @param utilisateurStrd
	 * @throws BLLException 
	 * @param BLLException 
	 */
	public void verifStringNombreEtVide(String test, int max,BLLException exception)
			throws BLLException {
		
		if (test.trim().length()>max ? false: true ) {
			exception.ajouterErreur(CodesResultatBLL.INSERT_UTILISATEUR_ECHEC_MAX);
		}
		if (test.trim().length() == 0? false: true ) {
			exception.ajouterErreur(CodesResultatBLL.INSERT_UTILISATEUR_NULL);
		}
	}
	/**
	 * Cette méthode permet de vérifier 
	 * les règles à respecter sur le nombre de caractère et su'il ne soit pas vide.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BLLException.
	 * @param utilisateurStrd
	 * @throws BLLException 
	 * @param BLLException 
	 */
	public void verifTelephone(String test, int max,BLLException exception)
			throws BLLException {
		Boolean bool;
		
		if (bool = test.trim().length()>max ? false: true ) {
			exception.ajouterErreur(CodesResultatBLL.INSERT_UTILISATEUR_ECHEC_MAX);
		}
	}
	
	/**
	 * Cette méthode permet de vérifier 
	 * les règles à respecter sur le nombre de caractère et su'il ne soit pas vide.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BLLException.
	 * @param utilisateurStrd
	 * @throws BLLException 
	 * @param BLLException 
	 */
	public void verifCredit(int credit, int max,BLLException exception)
												throws BLLException {
		Boolean bool;
		
		if (bool = credit<0 ? false: true ) {
			exception.ajouterErreur(CodesResultatBLL.INSERT_UTILISATEUR_NULL);
		}
		
	}
	
	
	
}
