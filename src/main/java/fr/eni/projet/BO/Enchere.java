/**
 * 
 */
package fr.eni.projet.BO;

import java.time.LocalDateTime;

/**
 * @author junisaru69
 *
 */
public class Enchere {

	private Integer 			noUtilisateur;
	private Integer 			noAcheteur;
	private Integer 			noArticle;
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
	public Enchere(Integer noUtilisateur, Integer noAcheteur, Integer noArticle,
					LocalDateTime dateEnchere, Integer montant_enchere) {
		
		this.noUtilisateur 		= noUtilisateur;
		this.noAcheteur 		= noAcheteur;
		this.noArticle 			= noArticle;
		this.dateEnchere 		= dateEnchere;
		this.montant_enchere 	= montant_enchere;
	}
	
	/**
	 *		Constructeur sans noAcheteur 
	 */
	
	public Enchere(Integer noUtilisateur, Integer noArticle, LocalDateTime dateEnchere,
					Integer montant_enchere) {
		this(noUtilisateur,null,noArticle,dateEnchere,montant_enchere);
	}
	
	/**
	 *		Constructeur sans noUtilisateur noAcheteur
	 */
	public Enchere(Integer noArticle, LocalDateTime dateEnchere,Integer montant_enchere) {
		this(null,null,noArticle, dateEnchere, montant_enchere);
	}
	
	

	//======================================================================//
	//								Getters-Setters 
	//======================================================================//

	
	//=================== noUtilisateur ===================
	//getter
	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}
	//Setter
	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
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
	
	//=================== noArticle ===================
	//getter
	public Integer getNoArticle() {
		return noArticle;
	}
	//Setter
	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
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
		return "-Enchere NoUtil: " + getNoUtilisateur()
				+ " /NoAcheteur: " 	+ getNoAcheteur()
				+ " /NoArt: " 		+ getNoArticle()
				+ " /DateEnch: " 	+ getDateEnchere()
				+ " /$: " 			+ getMontant_enchere()
				+ "-"; 
	}
	
	
	
	
}
