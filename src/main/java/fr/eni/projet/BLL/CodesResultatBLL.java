package fr.eni.projet.BLL;

/**
 * @author Loareos // Etienne
 *
 */


public abstract class CodesResultatBLL {
		
	/**
	 * Echec de l'insertion: un parametre obligatoire possède une valeur null
	 */
	public static final int INSERT_OBJET_NULL=20000;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int INSERT_PARAMETER_NULL=20001;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int INSERT_PARAMETER_LENGTH_MAX=20002;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int CREDIT_NEGATIF=20003;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int EXISTING_PSEUDO=20004;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int EXISTING_MAIL=20005;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int GET_INSTANCE=20006;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int MDP_VERIF_DIFFERENTS=20007;
}
