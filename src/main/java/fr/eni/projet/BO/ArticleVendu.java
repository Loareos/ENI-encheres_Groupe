/**
 * 
 */
package fr.eni.projet.BO;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import fr.eni.projet.BLL.BLLException;

/**
 * @author junisaru69
 *
 */
public class ArticleVendu {

	private int noUtilisateur;
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private int noCategorie;

	////////////////////////////////////////////////////////////////
	//											Construct
	//______________________________________________________________


	/**
	 * 
	 * Constructeur 
	 * 
	 * @param nomArticle description dateDebutEncheres 
	 * 			dateFinEncheres noUtilisateur noCategorie
	 */
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres,int noUtilisateur, int noCategorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	/**
	 * Constructeur + noArticle
	 * 
	 * @param nomArticle description dateDebutEncheres 
	 * 			dateFinEncheres noUtilisateur noCategorie
	 * 
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description,
			Date dateDebutEncheres,Date dateFinEncheres, int noUtilisateur,
			int noCategorie) {
		this(nomArticle, description, dateDebutEncheres,
				dateFinEncheres, noUtilisateur, noCategorie);
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
	 * @throws BOException si il y a plus de 30 caractères.
	 */
	public void setNomArticle(String nomArticle) throws BLLException {
		int maxCaractère = 30;
		if (verifNombreLettre(nomArticle, maxCaractère)) {
			this.nomArticle = nomArticle;
		}else {
			throw new BLLException(
					"Le nom de l'article dépasse le nombre de caractère autorisé :"+ maxCaractère);
		}
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 * @throws BOException si il y a plus de 300 caractères.
	 */
	public void setDescription(String description) throws BOException {
		int maxCaractère = 300;
		if (verifNombreLettre(description, maxCaractère)) {
			this.description = description;
		}else {
			throw new BOException("La description dépasse le nombre de caractère utilisé"+ maxCaractère);
		}
	}
	/**
	 * @return the dateDebutEncheres
	 */
	public Date getdateDebutEncheres() {
		return dateDebutEncheres;
	}
	/**
	 * @param dateDebutEncheres the dateDebutEncheres to set
	 * @throws BOException verifi que la date soit postérieur à aujourd'hui
	 */
	public void setdateDebutEncheres(String dateDebutEncheres) throws BOException {
		
		Calendar cal = Calendar.getInstance();
		Date dateNow = (Date) cal.getTime();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); 
		
		
		try {
			//On met la date en string entré par l'utilisateur en type date
			Date dateUtilisateur = (Date) df.parse(dateDebutEncheres); 
			// On verifie que a date soit postérieur à aujourd'hui
			if(dateUtilisateur.after(dateNow)){
				this.dateDebutEncheres = dateUtilisateur;
			} 
		} catch (ParseException e) {
			throw new BOException("La date de debut d'enchère est antérieur"
					+ " ou égale à la date d'aujourd'hui");
		}
	}
	/**
	 * @return the dateFinEncheres
	 */
	public Date getdateFinEncheres() {
		return dateFinEncheres;
	}
	/**
	 * @param dateFinEncheres the dateFinEncheres to set
	 */
	public void setdateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	/**
	 * @return the miseAPrix
	 */
	public int getMiseAPrix() {
		return miseAPrix;
	}
	/**
	 * @param miseAPrix the miseAPrix to set
	 * @throws BOException 
	 */
	public void setMiseAPrix(int miseAPrix) throws BOException {
		if ( miseAPrix < 0 ) {
			throw new BOException("Prix inférieur à zero-");
		}else {
			this.miseAPrix = miseAPrix;
		}
	}
	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}
	/**
	 * @param prixVente the prixVente to set
	 * @throws BOException 
	 */
	public void setPrixVente(int prixVente) throws BOException {

		if ( prixVente < this.miseAPrix ) {
			throw new BOException("Prix de vente incorrect");
		}else {
			this.prixVente = prixVente;
		}

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
	
	public boolean verifNombreLettre(String varchar, int nombreLettreMax){
		if (varchar.length()<nombreLettreMax) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Article vendu: No " + getNoArticle()
		+ ", "+ getNomArticle()
		+ ",desc: "+ getDescription()
		+ ", debut enchère: " + getdateDebutEncheres() 
		+ "/fin: " + getdateFinEncheres()
		+ ", Prix départ: " +(getMiseAPrix() != 0 ? getMiseAPrix() + ", " : "")
		+ "/Prix vente: " + (getPrixVente() != 0 ? getMiseAPrix() + ", " : "")
		+ ", No Util: "+ getNoUtilisateur()
		+ ", Caté: " + getNoCategorie() + "-";
	}

}
