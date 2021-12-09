package fr.eni.projet.dal;

/**
 * @author Loareos // Etienne
 *
 */
public abstract class CodesResultatDAL {
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int OBJET_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;

	/**
	 * Echec général quand erreur non gérée à l'update
	 */
	public static final int UPDATE_OBJET_ECHEC=10002;
	
	/**
	 * Echec général quand erreur non gérée à la selection
	 */
	public static final int SELECT_OBJET_ECHEC=10003;

	/**
	 * Echec général quand erreur non gérée à la selection
	 */
	public static final int DELETE_OBJET_ECHEC=10004;

	/**
	 * Echec général quand erreur non gérée à la selection
	 */
	public static final int IS_EXISTING_OBJET_ECHEC=10005;
}
