package fr.eni.projet.BLL;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

/**
 * @author junisaru69
 *	Modif by Etienne
 */
public class UtilisateurManager extends Manager {
	
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

//========  CONNEXION  ===========================================	
	public Utilisateur connexion( String identifiant, String mdp) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		
		Utilisateur user = null;
		
		if (utilisateurDao.pseudoExist(identifiant))
			user = this.utilisateurDao.selectByPseudo(identifiant);

		if (utilisateurDao.mailExist(identifiant))
			user = this.utilisateurDao.selectByMail(identifiant);
		
		if (user != null) 
			if (mdp.equals(user.getMotDePasse())) 
				return user;
			else 
				exception.ajouterErreur(CodesResultatBLL.MOT_DE_PASSE_INCORRECT);
		else	
			exception.ajouterErreur(CodesResultatBLL.IDENTIFIANT_INCORRECT);
				
		throw exception;
	}
	/**
	 * @return un objet Utilisateur en cas de succcès
	 */

	
//========  INSCRIPTION  ===========================================	
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
		if(!user.getPseudo().matches("^[a-zA-Z0-9]*$"))
			exception.ajouterErreur(CodesResultatBLL.PSEUDO_ALPHANUM);
		if(this.utilisateurDao.mailExist(user.getEmail()))
			exception.ajouterErreur(CodesResultatBLL.EXISTING_MAIL);

		
		if(!exception.hasErreurs()) {
			this.utilisateurDao.insert(user);
			return user;
		}else
			throw exception;
	}
	
	
//========  MODIFICATION  ===========================================	

	public Utilisateur modifProfil(Utilisateur user, String pseudo, String nom, String prenom, String email, String rue, String tel, String cp, String ville, String mdp, String verifMdp) throws BusinessException{
		BusinessException exception = new BusinessException();
		
		//Verifie que le mot de passe et la confirmation sont les mêmes
		if(!mdp.equals(verifMdp))
			exception.ajouterErreur(CodesResultatBLL.MDP_VERIF_DIFFERENTS);
		
		if(!user.getPseudo().equals(pseudo)) {
			if(this.utilisateurDao.pseudoExist(user.getPseudo()))
				exception.ajouterErreur(CodesResultatBLL.EXISTING_PSEUDO);
			if(!user.getPseudo().matches("^[a-zA-Z0-9]*$"))
				exception.ajouterErreur(CodesResultatBLL.PSEUDO_ALPHANUM);
		}
		
		if(!user.getEmail().equals(email))
			if(this.utilisateurDao.mailExist(user.getEmail()))
				exception.ajouterErreur(CodesResultatBLL.EXISTING_MAIL);

		Utilisateur userModif = new Utilisateur(user.getNoUtilisateur(), user.getCredit(), pseudo, nom, prenom, email, rue, tel, cp, ville,mdp, user.getAdministrateur());
		verifUser(userModif, exception);	

		if(!exception.hasErreurs()) {
			this.utilisateurDao.update(userModif);
			return userModif;
		}else
			throw exception;
	}
	
//========  SELECT BY SEARCH  ===========================================	
	
	public Utilisateur rechercheUser(String id) throws BusinessException {
		BusinessException exception = new BusinessException();

		if(this.utilisateurDao.pseudoExist(id))
			return this.utilisateurDao.selectByPseudo(id);
		else if (this.utilisateurDao.mailExist(id))
			return this.utilisateurDao.selectByMail(id);
		else
			exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_INCONNU);
		throw exception;
	}
	
	//========  SELECT BY SEARCH  ===========================================	
	
	public Utilisateur rechercheUserId(int id) throws BusinessException {
		BusinessException exception = new BusinessException();

		if(this.utilisateurDao.idExist(id))
			return this.utilisateurDao.selectById(id);
		else
			exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_INCONNU);
		throw exception;
	}
	
	
//========  SUPPRESSION  ===========================================	

	public void suppressionUser(Utilisateur user) throws BusinessException {
		this.utilisateurDao.delete(user.getNoUtilisateur());
	}

	
//========  VERIFICATIONS  ===========================================	
	
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
}
