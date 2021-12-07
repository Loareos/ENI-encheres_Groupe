package fr.eni.projet.dal;

/**
 * @author Loareos // Etienne // Copie exacte d'un ancien TP
 *
 */


public abstract class CodesResultatDAL {
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
	public static final int INSERT_AVIS_NOTE_ECHEC=10002;
}
