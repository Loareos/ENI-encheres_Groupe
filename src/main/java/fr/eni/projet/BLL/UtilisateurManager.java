/**
 * 
 */
package fr.eni.projet.BLL;

import fr.eni.projet.BO.BOException;
import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.dal.DAO;
import fr.eni.projet.dal.DAOFactory;

/**
 * @author junisaru69
 *
 */
public class UtilisateurManager {
	
	private DAO<Utilisateur> UtilisateurDao;
	
	public UtilisateurManager() {
		this.UtilisateurDao = DAOFactory.getUserDAO();
	}
	
	/**
	 * @return un objet Utilisateur en cas de succcès
	 * @throws BoException 
	 */
	public Utilisateur ajouterUtilisateurStandard() throws BOException
	{
		BusinessException exception = new BusinessException();
		
		Utilisateur utilisateurStrd = new Utilisateur(noUtilisateur,credit,pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse,administrateur);
		
		this.validerNote(utilisateurStrd,exception);
		this.validerDescription(utilisateurStrd,exception);

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
	 * Cette méthode permet de vérifier les règles à respecter sur la variable membre note.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param utilisateurStrd
	 * @param businessException 
	 */
	private void validerNote(Utilisateur utilisateurStrd, BusinessException businessException)
	{
		if(utilisateurStrd.getNote()<1 || utilisateurStrd.getNote()>5)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_AVIS_NOTE_ERREUR);
		}
	}
	
	/**
	 * Cette méthode permet de vérifier les règles à respecter sur la variable membre description.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param utilisateurStrd
	 * @param businessException
	 */
	private void validerDescription(Utilisateur utilisateurStrd, BusinessException businessException)
	{
		if(utilisateurStrd.getDescription()==null  || utilisateurStrd.getDescription().equals("")|| utilisateurStrd.getDescription().length()>150)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_AVIS_DESCRIPTION_ERREUR);
		}
	}
}
