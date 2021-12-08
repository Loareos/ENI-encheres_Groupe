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
	
	private static DAO<Utilisateur> UtilisateurDao;
	private static UtilisateurManager instance;
	
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
	 * @throws BoException 
	 */
	public Utilisateur ajouterUtilisateurStandard(Utilisateur utilisateurStrd) throws BLLException
	{
		BLLException exception = new BLLException();
		
		this.validerNote(utilisateurStrd,exception);
		this.validerDescription(utilisateurStrd,exception);

		if(!exception.hasErreurs())
		{
			try {
				this.UtilisateurDao.insert(utilisateurStrd);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return utilisateurStrd;
	}
	
	/**
	 * Cette méthode permet de vérifier les règles à respecter sur la variable membre note.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param utilisateurStrd
	 * @param bLLException 
	 */
	private void validerNote(Utilisateur utilisateurStrd, BLLException bLLException)
	{
		if(utilisateurStrd.getNote()<1 || utilisateurStrd.getNote()>5)
		{
			bLLException.ajouterErreur(CodesResultatBLL.REGLE_AVIS_NOTE_ERREUR);
		}
	}
	
	/**
	 * Cette méthode permet de vérifier les règles à respecter sur la variable membre description.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param utilisateurStrd
	 * @param bLLException
	 */
	private void validerDescription(Utilisateur utilisateurStrd, BLLException bLLException)
	{
		if(utilisateurStrd.getDescription()==null  || utilisateurStrd.getDescription().equals("")|| utilisateurStrd.getDescription().length()>150)
		{
			bLLException.ajouterErreur(CodesResultatBLL.REGLE_AVIS_DESCRIPTION_ERREUR);
		}
	}
}
