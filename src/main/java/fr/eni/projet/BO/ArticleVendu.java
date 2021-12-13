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

	private Integer 		noArticle;
	private String 			nomArticle;
	private String 			description;
	private LocalDateTime 	dateDebutEncheres;
	private LocalDateTime 	dateFinEncheres;
	private Integer 		miseAPrix;
	private Integer 		prixVente;
	private Integer 		noAcheteur;
	private Integer 		noUtilisateur;
	private Integer 		noCategorie;

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
	public ArticleVendu(Integer noArticle, String nomArticle, String description,
			LocalDateTime dateDebutEncheres,LocalDateTime dateFinEncheres, Integer miseAPrix,
			Integer prixVente,Integer noAcheteur, Integer noUtilisateur,Integer noCategorie) {
		this.noArticle 			= noArticle;
		this.nomArticle 		= nomArticle;
		this.description		= description;
		this.dateDebutEncheres 	= dateDebutEncheres;
		this.dateFinEncheres 	= dateFinEncheres;
		this.miseAPrix 			= miseAPrix;
		this.prixVente 			= prixVente;
		this.noAcheteur 		= noAcheteur;
		this.noUtilisateur 		= noUtilisateur;
		this.noCategorie 		= noCategorie;
	}

	/**
	 * Constructeur sans noArticle
	 */
	public ArticleVendu(String nomArticle, String description,LocalDateTime dateDebutEncheres,
						LocalDateTime dateFinEncheres, Integer miseAPrix, Integer prixVente,
						Integer noAcheteur,Integer noUtilisateur,Integer noCategorie) {
		
		this( null, nomArticle, description, dateDebutEncheres,dateFinEncheres,
				miseAPrix,prixVente,noAcheteur,noUtilisateur, noCategorie);
	}
	
	/**
	 *		Constructeur sans noArticle miseAPrix prixVente noUtilisateur
	 */
	
	public ArticleVendu(String nomArticle, String description, LocalDateTime dateDebutEncheres,
					LocalDateTime dateFinEncheres, Integer noUtilisateur,Integer noCategorie) {
		
		this(nomArticle,description,dateDebutEncheres,dateFinEncheres,
				null,null,null,noUtilisateur, noCategorie);
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
	public Integer getMiseAPrix() {
		return miseAPrix;
	}
	//Setter
	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	
	//=================== prixVente ===================
	
	//getter
	public Integer getPrixVente() {
		return prixVente;
	}
	//Setter
	public void setPrixVente(Integer prixVente) {
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
	public Integer getNoCategorie() {
		return noCategorie;
	}
	//Setter
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	//======================toString ArticleVendu.java ======================//
	@Override
	public String toString() {
		return "-ArticleVendu:  No: " 	+ getNoArticle()
				+ " /Nom: " 			+ getNomArticle()
				+ " /Desc: "			+ getDescription()
				+ " /Date Enchère: " 	+ getDateDebutEncheres()
				+ " : " 				+ getDateFinEncheres()+","
				+ (getMiseAPrix() 	!= null ? " $Dép: " 		+ getMiseAPrix() + ", " : "")
				+ (getPrixVente() 	!= null ? " $Fin: " 			+ getPrixVente() + ", " : "nul")
				+ (getNoAcheteur() 	!= null ? " /NoAcheteur: " 	+ getNoAcheteur() + ", " : "nul")
				+ " /NoUtil: " 			+ getNoUtilisateur()
				+ " /Catég: " 			+ getNoCategorie()+ "-";
	}

}
