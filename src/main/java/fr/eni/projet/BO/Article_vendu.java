/**
 * 
 */
package fr.eni.projet.BO;

/**
 * @author junisaru69
 *
 */
public class Article_vendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private int dateDebutEncheres;
	private int dateFinEnchere;
	private int miseAPrix;
	private int prixVente;
	private int noUtilisateur;
	private int noCategorie;
	
	////////////////////////////////////////////////////////////////
	//											Construct
	//______________________________________________________________

	
	/**
	 * 
	 * Constructeur 
	 * 
	 * @param nomArticle description dateDebutEncheres 
	 * 			dateFinEnchere noUtilisateur noCategorie
	 */
	public Article_vendu(String nomArticle, String description, int dateDebutEncheres,
						int dateFinEnchere,int noUtilisateur, int noCategorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEnchere = dateFinEnchere;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	/**
	 * Constructeur + noArticle
	 * 
	 * @param nomArticle description dateDebutEncheres 
	 * 			dateFinEnchere noUtilisateur noCategorie
	 * 
	 */
	public Article_vendu(int noArticle, String nomArticle, String description,
						int dateDebutEncheres,int dateFinEnchere, int noUtilisateur,
						int noCategorie) {
		this(nomArticle, description, dateDebutEncheres,
				dateFinEnchere, noUtilisateur, noCategorie);
		this.noArticle = noArticle;
	}
	
	////////////////////////////////////////////////////////////////
	//											Get/Set
	//______________________________________________________________
	
	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}
	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	/**
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}
	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the dateDebutEncheres
	 */
	public int getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	/**
	 * @param dateDebutEncheres the dateDebutEncheres to set
	 */
	public void setDateDebutEncheres(int dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	/**
	 * @return the dateFinEnchere
	 */
	public int getDateFinEnchere() {
		return dateFinEnchere;
	}
	/**
	 * @param dateFinEnchere the dateFinEnchere to set
	 */
	public void setDateFinEnchere(int dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}
	/**
	 * @return the miseAPrix
	 */
	public int getMiseAPrix() {
		return miseAPrix;
	}
	/**
	 * @param miseAPrix the miseAPrix to set
	 */
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}
	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	/**
	 * @return the noUtilisateur
	 */
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	/**
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	/**
	 * @return the noCategorie
	 */
	public int getNoCategorie() {
		return noCategorie;
	}
	/**
	 * @param noCategorie the noCategorie to set
	 */
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	@Override
	public String toString() {
		return "Article vendu: No " + getNoArticle()
				+ ", "+ (getNomArticle() != null ? getNomArticle() + ", " : "")
				+ (getDescription() != null ? getDescription() + ", " : "")
				+ "date enchere debut: " + getDateDebutEncheres() 
				+ "/fin: " + getDateFinEnchere()
				+ ", Prix debut: " +(getMiseAPrix() != 0 ? getMiseAPrix() + ", " : "")
				+ "/fin: " + (getPrixVente() != 0 ? getMiseAPrix() + ", " : "")
				+ ", No Util: "+ getNoUtilisateur()
				+ ", Caté: " + getNoCategorie() + "-";
	}
	
}
