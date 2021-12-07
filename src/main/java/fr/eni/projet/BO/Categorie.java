/**
 * 
 */
package fr.eni.projet.BO;

/**
 * @author junisaru69
 *
 */
public class Categorie {
	
	private int  no_categorie; 
	private String libelle; 

////////////////////////////////////////////////////////////////
//												Construct
//______________________________________________________________
	
	/**
	 * 
	 */
	public Categorie( String libelle) {
		this.libelle = libelle;
	}
	
/**
	 * @param no_categorie
	 * @param libelle
	 */
	public Categorie(int no_categorie, String libelle) {
		this(libelle);
		this.no_categorie = no_categorie;
	}

////////////////////////////////////////////////////////////////
//												Get/Set
//______________________________________________________________
	/**
	 * @return the no_categorie
	 */
	public int getNo_categorie() {
		return no_categorie;
	}
	
	/**
	 * @param no_categorie the no_categorie to set
	 */
	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}
	
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie:"+ getNo_categorie() 
							+ ", libel:" + getLibelle()+ "-";
	}
	
	
}
