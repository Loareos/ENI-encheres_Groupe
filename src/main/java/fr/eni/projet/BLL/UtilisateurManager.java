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
	
	public Utilisateur ajouterUtilisateurStandard(String pseudo, String nom, String prenom, String email, String rue, String tel, String cp, String ville, String mdp, String verifMdp) throws BusinessException{
		BusinessException exception = new BusinessException();
		
		//Verifie que le mot de passe et la confirmation sont les mêmes
		if(!mdp.equals(verifMdp))
			exception.ajouterErreur(CodesResultatBLL.MDP_VERIF_DIFFERENTS);
		
		Utilisateur user = new Utilisateur(0, pseudo, nom, prenom, email, rue, tel, cp, ville,mdp, false);

		//Verifie les autres critères
		verifUser(user, exception);	
		if(this.utilisateurDao.pseudoExist(user.getPseudo()))
			exception.ajouterErreur(CodesResultatBLL.EXISTING_PSEUDO);
		if(this.utilisateurDao.mailExist(user.getEmail()))
			exception.ajouterErreur(CodesResultatBLL.EXISTING_MAIL);

		
		if(!exception.hasErreurs()) {
			this.utilisateurDao.insert(user);
			return user;
		}else
			throw exception;
	}
	
	private static void verifUser(Utilisateur user, BusinessException exception) {
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
	}
	
	
	/**
	 * Cette méthode permet de vérifier 
	 * les règles à respecter sur le nombre de caractère et qu'il ne soit pas vide.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BLLException.
	 * @param utilisateurStrd
	 * @throws BusinessException 
	 * @param BusinessException 
	 */
	private static void verifStringNombreEtVide(String test, int max,BusinessException exception){
		if(test == null || test.length() == 0)
			exception.ajouterErreur(CodesResultatBLL.INSERT_PARAMETER_NULL);
		if(test.length() > max)
			exception.ajouterErreur(CodesResultatBLL.INSERT_PARAMETER_LENGTH_MAX);
	}
}
