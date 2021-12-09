package fr.eni.projet.BLL;

/**
 * @author Loareos // Etienne // Copie exacte d'un ancien TP
 *
 */


public abstract class CodesResultatBLL {
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
	
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int INSERT_UTILISATEUR_ECHEC_MAX=20001;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int INSERT_UTILISATEUR_NULL=20000;
}
