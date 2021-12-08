package fr.eni.projet.BO;

/**
 * @author junisaru69
 * Modif by Etienne
 */
public class Utilisateur {

	private Integer noUtilisateur;
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



//=========================================================	
//					CONSTRUCTEURS
//=========================================================	
	
	
	/**
	 * Constructeur vide
	 */
	public Utilisateur() {
		super();
	}
	
	/**
	 * Constructeur complet
	 */
	public Utilisateur(Integer noUtilisateur, int credit, String pseudo, String nom, String prenom, String email, String rue, String telephone, String codePostal, String ville, String motDePasse, boolean administrateur) {
		this.noUtilisateur 	= noUtilisateur;
		this.credit 		= credit;
		this.pseudo 		= pseudo;
		this.nom 			= nom;
		this.prenom 		= prenom;
		this.email 			= email;
		this.rue 			= rue;
		this.telephone 		= telephone;
		this.codePostal 	= codePostal;
		this.ville 			= ville;
		this.motDePasse 	= motDePasse;
		this.administrateur = administrateur;
	}

	/**
	 * Constructeur sans numero d'identifiant
	 */
	public Utilisateur(int credit, String pseudo, String nom, String prenom, String email, String rue, String telephone, String codePostal, String ville, String motDePasse, boolean administrateur) {
		this(null, credit, pseudo, nom, prenom, email, rue, telephone, codePostal, ville, motDePasse, administrateur);
	}

	/**
	 * Constructeur sans telephone ni numero d'identifiant
	 */
	public Utilisateur(int credit, String pseudo, String nom, String prenom, String email, String rue, String codePostal, String ville, String motDePasse, boolean administrateur) {
		this(null, credit, pseudo, nom, prenom, email, rue, null, codePostal, ville, motDePasse, administrateur);
	}
	
	/**
	 * Constructeur sans téléphone
	 */
	public Utilisateur(Integer noUtilisateur, int credit, String pseudo, String nom, String prenom, String email, String rue, String codePostal, String ville, String motDePasse, boolean administrateur) {
		this(noUtilisateur, credit, pseudo, nom, prenom, email, rue, null, codePostal, ville, motDePasse, administrateur);
	}

//=========================================================	
//					GETTERS - SETTERS
//=========================================================	


//=============== NoUtilisateur =====================
	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

//=============== Credit =====================	
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}

//=============== Pseudo =====================	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo){
		this.pseudo = pseudo;
	}

//=============== Nom =====================	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

//=============== Prenom =====================	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	
//=============== Email =====================	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
//=============== Telephone =====================	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	
//=============== Rue =====================	
	public String getRue() {
		return rue;
	}
	public void setRue(String rue){
		this.rue = rue;
	}

//=============== Code Postal =====================	
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal){
		this.codePostal = codePostal;
	}
	
//=============== Ville =====================	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville){
		this.ville = ville;
	}
	
//=============== Mot de passe =====================	
	public String getMotDePasse() {
		return motDePasse;
	}
	private void setMotDePasse(String motDePasse){
		this.motDePasse = motDePasse;
	}
	
//=============== Administrateur =====================	
	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}
	public Boolean getAdministrateur() {
		return administrateur;
	}

//=========================================================	
//===================== TO STRING =========================
//=========================================================
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
