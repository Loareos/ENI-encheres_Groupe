/**
 * 
 */
package fr.eni.projet.BO;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author junisaru69
 *	Modif by Clement
 */
public class Enchere {

	private Utilisateur 		acheteur;
	private ArticleVendu 		article;
	private LocalDate 		    dateEnchere;
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
	public Enchere(Utilisateur acheteur, ArticleVendu article,
					LocalDate dateEnchere, Integer montant_enchere) {
		
		this.acheteur 			= acheteur;
		this.article 			= article;
		this.dateEnchere 		= dateEnchere;
		this.montant_enchere 	= montant_enchere;
	}	
	

	//======================================================================//
	//								Getters-Setters 
	//======================================================================//

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
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	//Setter
	public void setDateEnchere(LocalDate dateEnchere) {
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
		return "-Enchere Acheteur: "+ getAcheteur()
				+ " /NoArt: " 		+ getArticle()
				+ " /DateEnch: " 	+ getDateEnchere()
				+ " /$: " 			+ getMontant_enchere()
				+ "-"; 
	}
	
	
	
	
}
