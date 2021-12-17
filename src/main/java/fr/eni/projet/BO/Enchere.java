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
	private Integer 	        idAcheteur;
	private Integer 	        idArticle;
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
	 *		Constructeur Intermédiaire
	 */
	public Enchere(Integer idAcheteur, Integer idArticle,
					LocalDate dateEnchere, Integer montant_enchere) {
		
		this.idAcheteur 		= idAcheteur;
		this.idArticle 			= idArticle;
		this.dateEnchere 		= dateEnchere;
		this.montant_enchere 	= montant_enchere;
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
	
	//=================== noidAcheteur ===================
		//getter
		public Integer getidAcheteur() {
			return idAcheteur;
		}
		//Setter
		public void setidAcheteur(Integer idAcheteur) {
			this.idAcheteur = idAcheteur;
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
	
	//=================== noidArticle ===================
		//getter
		public int getidArticle() {
			return idArticle;
		}
		//Setter
		public void setidArticle(Integer idArticle) {
			this.idArticle = idArticle;
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
	
	public String toStringId() {
		return "-Enchere Acheteur: "+ getidAcheteur()
				+ " /NoArt: " 		+ getidArticle()
				+ " /DateEnch: " 	+ getDateEnchere()
				+ " /$: " 			+ getMontant_enchere()
				+ "-"; 
	}
	
	
	
}
