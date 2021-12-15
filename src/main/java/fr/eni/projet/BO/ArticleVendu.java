/**
 * 
 */
package fr.eni.projet.BO;

import java.time.LocalDate;

/**
 * @author junisaru69 Modif by
 */
public class ArticleVendu {

	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private Integer noVendeur;
	private Integer noAcheteur;
	private Integer noCategorie;
	private Byte imgArticle;

	// =========================================================//
	// CONSTRUCTEURS
	// =========================================================//

	/**
	 * Cnonstructeur vide
	 */
	public ArticleVendu() {
		super();
	}

	/**
	 * Cnonstructeur Complet
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, Integer noVendeur, Integer noAcheteur,
			Integer noCategorie, Byte imgArticle) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.noVendeur = noVendeur;
		this.noAcheteur = noAcheteur;
		this.noCategorie = noCategorie;
		this.imgArticle = imgArticle;
	}

	/**
	 * Constructeur sans noArticle prixVente noAcheteur imgArticle
	 */
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer miseAPrix, Integer noVendeur, Integer noCategorie, Byte imgArticle) {
		this(null, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, null, noVendeur, null,
				noCategorie, imgArticle);
	}

	/**
	 * Constructeur sans noArticle miseAPrix prixVente noAcheteur imgArticle
	 */
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer noVendeur, Integer noCategorie) {
		this(null, nomArticle, description, dateDebutEncheres, dateFinEncheres, null, null, noVendeur, null,
				noCategorie, null);
	}

	// =========================================================//
	// GETTERS - SETTERS
	// =========================================================//

	// =================== noArticle ===================

	// getter
	public Integer getNoArticle() {
		return noArticle;
	}

	// Setter
	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	// =================== nomArticle ===================

	// getter
	public String getNomArticle() {
		return nomArticle;
	}

	// Setter
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	// =================== description ===================

	// getter
	public String getDescription() {
		return description;
	}

	// Setter
	public void setDescription(String description) {
		this.description = description;
	}

	// =================== dateDebutEncheres ===================

	// getter
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	// Setter
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	// =================== dateFinEncheres ===================

	// getter
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	// Setter
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	// =================== miseAPrix ===================

	// getter
	public Integer getMiseAPrix() {
		return miseAPrix;
	}

	// Setter
	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	// =================== prixVente ===================

	// getter
	public Integer getPrixVente() {
		return prixVente;
	}

	// Setter
	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	// =================== noAcheteur ===================
	// getter
	public Integer getNoAcheteur() {
		return noAcheteur;
	}

	// Setter
	public void setNoAcheteur(Integer noAcheteur) {
		this.noAcheteur = noAcheteur;
	}

	// =================== noUtilisateur ===================
	// getter
	public Integer getNoVendeur() {
		return noVendeur;
	}

	// Setter
	public void setNoVendeur(Integer noVendeur) {
		this.noVendeur = noVendeur;
	}

	// =================== noCategorie ===================
	// getter
	public Integer getNoCategorie() {
		return noCategorie;
	}

	// Setter
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	// =================== imgArticle ===================

	// getter
	public Byte getimgArticle() {
		return imgArticle;
	}

	// Setter
	public void setimgArticle(Byte imgArticle) {
		this.imgArticle = imgArticle;
	}

	// ======================toString ArticleVendu.java ======================//
	@Override
	public String toString() {
		return "-ArticleVendu No: " + getNoArticle() + " /Nom: " + getNomArticle() + " /Desc: " + getDescription()
				+ " /Date Enchère: " + getDateDebutEncheres() + ":" + getDateFinEncheres() + ","
				+ (getMiseAPrix() != null ? " $Dép: " + getMiseAPrix() + ", " : "null")
				+ (getPrixVente() != null ? " $Fin: " + getPrixVente() + ", " : "nul")
				+ (getNoAcheteur() != null ? " /NoAcheteur: " + getNoAcheteur() + ", " : "nul") + " /NoUtil: "
				+ getNoVendeur() + " /Catég: " + getNoCategorie() + " /imgArticle: "
				+ (getimgArticle() != null ? "1" : "0") + "-";
	}

}
