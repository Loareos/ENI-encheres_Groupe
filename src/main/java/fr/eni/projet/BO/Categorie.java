/**
 * 
 */
package fr.eni.projet.BO;

/**
 * @author junisaru69
 *
 */
public class Categorie {
	
	private int  noCategorie; 
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
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(int noCategorie, String libelle) {
		this(libelle);
		this.noCategorie = noCategorie;
	}

////////////////////////////////////////////////////////////////
//												Get/Set
//______________________________________________________________
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
		return "Categorie:"+ getNoCategorie() 
							+ ", libel:" + getLibelle()+ "-";
	}
	
	
}
