/**
 * 
 */
package fr.eni.projet.BO;

/**
 * @author junisaru69
 *
 */
public class Utilisateur {
	
	private int noUtilisateur;
	private int credit;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private Boolean administrateur;
	
	
	
	////////////////////////////////////////////////////////////////
	//											Construct
	//______________________________________________________________

	/**
	 * 
	 * Constructeur
	 * 
	 * @param noUtilisateur credit pseudo nom prenom email
	 * codePostal ville motDePasse administrateur
	 */
	public Utilisateur(int credit, String pseudo, String nom,
					String prenom, String email,String rue,
					String codePostal,String ville, String motDePasse,
					Boolean administrateur) {
		this.credit = credit;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.administrateur = administrateur;
	}
	
	/**
	 * Constructeur + telephone
	 * 
	 * @param noUtilisateur credit pseudo nom prenom email telephone
	 * codePostal ville motDePasse administrateur
	 */
	public Utilisateur(int credit, String pseudo,
			String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville,String motDePasse,
			Boolean administrateur) {
		this(credit,pseudo,nom,prenom,email,rue,codePostal,ville,motDePasse,administrateur);
		this.telephone = telephone;
	}
	
	/**
	 * Constructeur no utilisateur
	 * 
	 * @param noUtilisateur credit pseudo nom prenom email telephone
	 * codePostal ville motDePasse administrateur
	 */
	public Utilisateur(int noUtilisateur, int credit, String pseudo,
			String nom, String prenom, String email, String rue,
			String codePostal, String ville,String motDePasse,
			Boolean administrateur) {
		this(credit,pseudo,nom,prenom,email,rue,codePostal,ville,motDePasse,administrateur);
		this.noUtilisateur = noUtilisateur;
	}
	/**
	 * Constructeur + no utilisateur + telephone
	 * 
	 * @param noUtilisateur credit pseudo nom prenom email telephone
	 * codePostal ville motDePasse administrateur
	 */
	public Utilisateur(int noUtilisateur, int credit, String pseudo,
			String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville,String motDePasse,
			Boolean administrateur) {
		this(credit,pseudo,nom,prenom,email,rue,codePostal,ville,motDePasse,administrateur);
		this.noUtilisateur = noUtilisateur;
		this.telephone = telephone;
	}
	
	
	
	
	////////////////////////////////////////////////////////////////
	//											Get/Set
	//______________________________________________________________

	/**
	 * 
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
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * @param pseudo the pseudo to set
	 * @throws BOException 
	 */
	public void setPseudo(String pseudo) throws BOException {
		int maxCaractère = 30;
		if (verifNombreLettre(pseudo, maxCaractère)) {
			this.pseudo = pseudo;
		}else {
			throw new BOException(
					"Le pseudo de l'utilisateur dépasse le nombre de caractère autorisé :"+maxCaractère);
		}
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 * @throws BOException 
	 */
	public void setNom(String nom) throws BOException {
		int maxCaractère = 30;
		if (verifNombreLettre(nom, maxCaractère)) {
			this.nom = nom;
		}else {
			throw new BOException(
					"Le nom de l'utilisateur dépasse le nombre de caractère autorisé :"+maxCaractère);
		}
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 * @throws BOException 
	 */
	public void setPrenom(String prenom) throws BOException {
		int maxCaractère = 30;
		if (verifNombreLettre(prenom, maxCaractère)) {
			this.prenom = prenom;
		}else {
			throw new BOException(
					"Le prénom de l'utilisateur dépasse le nombre de caractère autorisé :"+maxCaractère);
		}
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 * @throws BOException 
	 */
	public void setEmail(String email) throws BOException {
		int maxCaractère = 20;
		if (verifNombreLettre(email, maxCaractère)) {
			this.email = email;
		}else {
			throw new BOException(
					"L'email de l'utilisateur dépasse le nombre de caractère autorisé :"+maxCaractère);
		}
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 * @throws BOException 
	 */
	public void setTelephone(String telephone) throws BOException {
		int maxCaractère = 15;
		if (verifNombreLettre(telephone, maxCaractère)) {
			this.telephone = telephone;
		}else {
			throw new BOException(
					"Le numéro de mobile de l'utilisateur dépasse le nombre de caractère autorisé :"+maxCaractère);
		}
	}
	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 * @throws BOException 
	 */
	public void setRue(String rue) throws BOException {
		int maxCaractère = 30;
		if (verifNombreLettre(rue, maxCaractère)) {
			this.rue = rue;
		}else {
			throw new BOException(
					"La description de la rue de l'utilisateur dépasse le nombre de caractère autorisé :"+maxCaractère);
		}
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 * @throws BOException 
	 */
	public void setCodePostal(String codePostal) throws BOException {
		int maxCaractère = 10;
		if (verifNombreLettre(pseudo, maxCaractère)) {
			this.codePostal = codePostal;
		}else {
			throw new BOException(
					"Le code postal de l'utilisateur dépasse le nombre de caractère autorisé :"+maxCaractère);
		}
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 * @throws BOException 
	 */
	public void setVille(String ville) throws BOException {
		int maxCaractère = 30;
		if (verifNombreLettre(ville, maxCaractère)) {
			this.ville = ville;
		}else {
			throw new BOException(
					"La ville de l'utilisateur dépasse le nombre de caractère autorisé :"+maxCaractère);
		}
	}
	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/**
	 * @param motDePasse the motDePasse to set
	 * @throws BOException 
	 */
	private void setMotDePasse(String motDePasse) throws BOException {
		int maxCaractère = 30;
		if (verifNombreLettre(motDePasse, maxCaractère)) {
			this.motDePasse = motDePasse;
		}else {
			throw new BOException(
					"Le mot de passe de l'utilisateur dépasse le nombre de caractère autorisé :"+maxCaractère);
		}
	}
	/**
	 * @return the administrateur
	 */
	public Boolean getAdministrateur() {
		return administrateur;
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
		return "Utilisateur: no " + getNoUtilisateur() 
				+ " Psd: " + getPseudo()
				+ " Cdt: " + getCredit()
				+ " " + getNom()
				+ ", " + getPrenom()
				+ " Email" + getEmail()
				+ " Tel: " +(getTelephone() != null ? getTelephone() + ", " : "")
				+ " Addr: "+ getCodePostal()
				+ " "+ getCodePostal()
				+ " " + getVille()
				+ ", MDP" + getMotDePasse()
				+ " Admin: " + getAdministrateur() + "-";
	}
	
	
}
