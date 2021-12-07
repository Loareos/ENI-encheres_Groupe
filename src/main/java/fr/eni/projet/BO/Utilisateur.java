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
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
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
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/**
	 * @param motDePasse the motDePasse to set
	 */
	private void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	/**
	 * @return the administrateur
	 */
	public Boolean getAdministrateur() {
		return administrateur;
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
