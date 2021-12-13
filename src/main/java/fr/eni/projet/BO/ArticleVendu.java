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
	private Integer noUtilisateur;
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
	 * 	Cnonstructeur complet
	 */
	public ArticleVendu( Integer noArticle, String nomArticle, String description,LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, int miseAPrix, int prixVente,Integer noUtilisateur,int noCategorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}

	/**
	 * Constructeur sans noArticle
	 */
	public ArticleVendu(String nomArticle, String description,LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, int miseAPrix, int prixVente,Integer noUtilisateur,int noCategorie) {
		this( null, nomArticle, description, dateDebutEncheres,
				dateFinEncheres,miseAPrix,prixVente, noUtilisateur, noCategorie);
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

	
	//=================== noUtilisateur ===================
	
	//getter
	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}
	//Setter
	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
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

	//======================toString ArticleVendu ======================
	@Override
	public String toString() {
		return "Article vendu: No " + getNoArticle()
		+ ", "+ getNomArticle()
		+ ",desc: "+ getDescription()
		+ ", debut enchère: " + getDateDebutEncheres() 
		+ "/fin: " + getDateFinEncheres()
		+ ", Prix départ: " +(getMiseAPrix() != 0 ? getMiseAPrix() + ", " : "")
		+ "/Prix vente: " + (getPrixVente() != 0 ? getMiseAPrix() + ", " : "")
		+ ", No Util: "+ getNoUtilisateur()
		+ ", Caté: " + getNoCategorie() + "-";
	}

}
