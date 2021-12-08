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

	private int noUtilisateur;
	private int noArticles;
	private int montant_enchere;
	private LocalDateTime dateEnchere;

	////////////////////////////////////////////////////////////////
	//											Construct
	//______________________________________________________________

	/**
	 * 
	 * Contruct + no
	 * 
	 * @param noUtilisateur
	 * @param noArticles
	 * @param montant_enchere
	 * @param dateEnchere
	 */
	public Enchere(int noUtilisateur, int noArticles, int montant_enchere,
				LocalDateTime dateEnchere) {
		this(noArticles,montant_enchere,dateEnchere);
		this.noUtilisateur = noUtilisateur;
	}

	/**
	 * @param noUtilisateur
	 * @param noArticles
	 * @param montant_enchere
	 * @param dateEnchere
	 */
	public Enchere(int noArticles, int montant_enchere, LocalDateTime dateEnchere) {
		this.noArticles = noArticles;
		this.montant_enchere = montant_enchere;
		this.dateEnchere = dateEnchere;
	}
	
	////////////////////////////////////////////////////////////////
	//											Get/Set
	//______________________________________________________________

	/**
	 * @return the noUtilisateur
	 */
	public int getNo_utilisateur() {
		return noUtilisateur;
	}

	/**
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setNo_utilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	/**
	 * @return the noArticles
	 */
	public int getNo_articles() {
		return noArticles;
	}

	/**
	 * @param noArticles the noArticles to set
	 */
	public void setNo_articles(int noArticles) {
		this.noArticles = noArticles;
	}

	/**
	 * @return the montant_enchere
	 */
	public int getMontant_enchere() {
		return montant_enchere;
	}

	/**
	 * @param montant_enchere the montant_enchere to set
	 */
	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	/**
	 * @return the dateEnchere
	 */
	public LocalDateTime getDate_enchere() {
		return dateEnchere;
	}

	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDate_enchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	@Override
	public String toString() {
		return ":Enchere: No Util:" + getNo_utilisateur()
						+ ", Art:" + getNo_articles()
						+ " à " + getMontant_enchere()
						+" £ le " + getDate_enchere()+ "-";
	}
	
	
}
