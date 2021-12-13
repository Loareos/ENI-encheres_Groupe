/**
 * 
 */
package fr.eni.projet.BO;

import java.time.LocalDateTime;

/**
 * @author junisaru69
 *
 */
public class ArticleVendu {

	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime dateDebutEncheres;
	private LocalDateTime dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private Integer noAcheteur;
	private Integer noVendeur;
	private int noCategorie;

	//=========================================================//
	//						CONSTRUCTEURS			
	//=========================================================//	

	/**
	 * 	Cnonstructeur vide
	 */
	public ArticleVendu() {
		super();
	}
	
	/**
	 * 	Cnonstructeur Complet
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, Integer noAcheteur, Integer noVendeur,
			int noCategorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.noAcheteur = noAcheteur;
		this.noVendeur = noVendeur;
		this.noCategorie = noCategorie;
	}

	/**
	 * Constructeur sans noArticle
	 */
	public ArticleVendu(String nomArticle, String description,LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, int miseAPrix, int prixVente,Integer noAcheteur,Integer noVendeur,int noCategorie) {
		this( null, nomArticle, description, dateDebutEncheres,
				dateFinEncheres,miseAPrix,prixVente,noAcheteur,noVendeur, noCategorie);
	}

	//=========================================================//
	//					GETTERS - SETTERS
	//=========================================================//




	//=================== noArticle ===================

	//getter
	public Integer getNoArticle() {
		return noArticle;
	}

	//Setter
	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	

	
	//=================== nomArticle ===================
	
	//getter
	public String getNomArticle() {
		return nomArticle;
	}
	//Setter
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	
	//=================== description ===================
	
	//getter
	public String getDescription() {
		return description;
	}
	//Setter
	public void setDescription(String description) {
		this.description = description;
	}

	
	//=================== dateDebutEncheres ===================
	
	//getter
	public LocalDateTime getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	//Setter
	public void setDateDebutEncheres(LocalDateTime dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	
	//=================== dateFinEncheres ===================
	
	//getter
	public LocalDateTime getDateFinEncheres() {
		return dateFinEncheres;
	}
	//Setter
	public void setDateFinEncheres(LocalDateTime dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	
	//=================== miseAPrix ===================
	
	//getter
	public int getMiseAPrix() {
		return miseAPrix;
	}
	//Setter
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	
	//=================== prixVente ===================
	
	//getter
	public int getPrixVente() {
		return prixVente;
	}
	//Setter
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	
	//=================== noAcheteur ===================
	//getter
	public Integer getNoAcheteur() {
		return noAcheteur;
	}
	//Setter
	public void setNoAcheteur(Integer noAcheteur) {
		this.noAcheteur = noAcheteur;
	}
	
	//=================== noVendeur ===================
	//getter
	public Integer getNoVendeur() {
		return noVendeur;
	}
	//Setter
	public void setNoVendeur(Integer noVendeur) {
		this.noVendeur = noVendeur;
	}

	//=================== noCategorie ===================
	//getter
	public int getNoCategorie() {
		return noCategorie;
	}
	//Setter
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	//======================toString ArticleVendu.java ======================//
	@Override
	public String toString() {
		return "-ArticleVendu: " 
				+ (getNoArticle() != null ? " No: " + getNoArticle() + ", " : "")
				+ (getNomArticle() != null ? " Nom: " + getNomArticle() + ", " : "")
				+ (getDescription() != null ? " Desc: " + getDescription() + ", " : "")
				+ (getDateDebutEncheres() != null ? " DateDebut: " + getDateDebutEncheres() + ", " : "")
				+ (getDateFinEncheres() != null ? " DateFin: " + getDateFinEncheres() + ", " : "")
				+ " Prix Départ" + getMiseAPrix() 
				+ " Prix Vente: " + getPrixVente() + ", "
				+ (getNoAcheteur() != null ? " Acheteur: " + getNoAcheteur() + ", " : "")
				+ (getNoVendeur() != null ? " Vendeur: " + getNoVendeur() + ", " : "")
				+ " Categorie: "+ getNoCategorie() + "-";
	}

	

}
