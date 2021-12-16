package fr.eni.projet.BLL;

/**
 * @author Loareos // Etienne
 *
 */

public abstract class CodesResultatBLL {

	/**
	 * Echec de l'insertion: un parametre obligatoire possède une valeur null
	 */
	public static final int INSERT_OBJET_NULL = 20000;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int INSERT_PARAMETER_NULL = 20001;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int INSERT_PARAMETER_LENGTH_MAX = 20002;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int CREDIT_NEGATIF = 20003;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int EXISTING_PSEUDO = 20004;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int EXISTING_MAIL = 20005;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int GET_INSTANCE = 20006;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int MDP_VERIF_DIFFERENTS = 20007;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int IDENTIFIANT_INCORRECT = 20008;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int MOT_DE_PASSE_INCORRECT = 20009;
	/**
	 * Echec de l'insertion d'un avis à cause de la note
	 */
	public static final int UTILISATEUR_INCONNU = 20010;

	public static final int DATE_DEBUT_ENCHERE_INVALIDE = 20011;

	public static final int VENDEUR_INCONNU = 20012;

	public static final int CATEGORIE_INCONNU = 20013;

	public static final int DATE_FIN_ENCHERE_INVALIDE = 20014;
	
	public static final int RETRAIT_EXIST = 20015;
	
	public static final int AUCUN_ARTICLE_EN_VENTE = 20016;
	
	public static final int POINT_RETRAIT_INCONNU = 20017;
	
	public static final int PSEUDO_ALPHANUM = 20018;
	
}
