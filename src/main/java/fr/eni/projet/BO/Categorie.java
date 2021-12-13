/**
 * 
 */
package fr.eni.projet.BO;

/**
 * @author junisaru69
 *
 */
public class Categorie {
	
	private Integer  	noCategorie; 
	private String		libelle; 

	
	//======================================================================//
	//								Constructeurs
	//======================================================================//
	
	/**
	 *		Constructeur Vide
	 */
	public Categorie() {
		super();
	}
	
	/**
	 *		Constructeur Complet
	 */
	public Categorie(Integer noCategorie, String libelle) {
		this.noCategorie 	= noCategorie;
		this.libelle 		= libelle;
	}
	/**
	 *		Constructeur sans noCategorie
	 */
	public Categorie(String libelle) {
		this(null,libelle);
	}

	


	//======================================================================//
	//								Getters-Setters 
	//======================================================================/
	
	
	//=================== noCategorie ===================
	//getter
	public Integer getNoCategorie() {
		return noCategorie;
	}
	//Setter
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	//=================== libelle ===================
	//getter
	public String getLibelle() {
		return libelle;
	}
	//Setter
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	//======================toString Categorie======================//
	@Override
	public String toString() {
		return "-Categorie No: " 		+ getNoCategorie()
				+ " /Libelle: " 	+ getLibelle() 
				+ " -";
	}
	
}
