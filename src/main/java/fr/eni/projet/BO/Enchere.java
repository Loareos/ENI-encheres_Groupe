/**
 * 
 */
package fr.eni.projet.BO;

import java.time.LocalDateTime;

/**
 * @author junisaru69
 *	Modif by
 */
public class Enchere {

	private Utilisateur 		vendeur;
	private Utilisateur 		acheteur;
	private ArticleVendu 		article;
	private LocalDateTime 		dateEnchere;
	private Integer 			montant_enchere;
	
	//======================================================================//
	//								Constructeurs
	//======================================================================//
	
	
	/**
	 *		Constructeur Vide
	 */
	public Enchere() {
		super();
	}

	/**
	 *		Constructeur Complet
	 */
	public Enchere(Utilisateur vendeur, Utilisateur acheteur, ArticleVendu article,
					LocalDateTime dateEnchere, Integer montant_enchere) {
		
		this.vendeur 			= vendeur;
		this.acheteur 			= acheteur;
		this.article 			= article;
		this.dateEnchere 		= dateEnchere;
		this.montant_enchere 	= montant_enchere;
	}
	
	/**
	 *		Constructeur sans noAcheteur 
	 */
	
	public Enchere(Utilisateur vendeur, ArticleVendu article, LocalDateTime dateEnchere,
					Integer montant_enchere) {
		this(vendeur,null,article,dateEnchere,montant_enchere);
	}
	
	/**
	 *		Constructeur sans noUtilisateur noAcheteur
	 */
	public Enchere(ArticleVendu article, LocalDateTime dateEnchere,Integer montant_enchere) {
		this(null,null,article, dateEnchere, montant_enchere);
	}
	
	

	//======================================================================//
	//								Getters-Setters 
	//======================================================================//

	
	//=================== noUtilisateur ===================
	//getter
	public Utilisateur getVendeur() {
		return vendeur;
	}
	//Setter
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}
	
	//=================== noAcheteur ===================
	//getter
	public Utilisateur getAcheteur() {
		return acheteur;
	}
	//Setter
	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}
	
	//=================== noArticle ===================
	//getter
	public ArticleVendu getArticle() {
		return article;
	}
	//Setter
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}
	
	//=================== dateEnchere ===================
	//getter
	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}
	//Setter
	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	
	//=================== montant_enchere ===================
	//getter
	public Integer getMontant_enchere() {
		return montant_enchere;
	}
	//Setter
	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	//======================toString Enchere.java ======================//
	@Override
	public String toString() {
		return "-Enchere NoUtil: " 	+ getVendeur()
				+ " /NoAcheteur: " 	+ getAcheteur()
				+ " /NoArt: " 		+ getArticle()
				+ " /DateEnch: " 	+ getDateEnchere()
				+ " /$: " 			+ getMontant_enchere()
				+ "-"; 
	}
	
	
	
	
}
