/**
 * 
 */
package fr.eni.projet.BO;

/**
 * @author junisaru69
 *
 */
public class Retrait {

	private Integer 	noArticle;
	private String 		rue;
	private String 		code_postal;
	private String 		ville;
	
	//======================================================================//
	//								Constructeurs
	//======================================================================//
	
	/**
	 *		Constructeur Vide
	 */
	public Retrait() {
		super();
	}
	
	/**
	 *		Constructeur Complet
	 */
	public Retrait(Integer noArticle, String rue, String code_postal, String ville) {
		this.noArticle 		= noArticle;
		this.rue 			= rue;
		this.code_postal 	= code_postal;
		this.ville 			= ville;
	}

	/**
	 *		Constructeur sans NoArticle
	 */
	public Retrait(String rue, String code_postal, String ville) {
		this(null,rue,code_postal,ville);
	}

	//======================================================================//
	//								Getters-Setters 
	//======================================================================//
	
	//=================== noArticle ===================
	//getter
	public Integer getNoArticle() {
		return noArticle;
	}
	//Setter
	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}
	
	//=================== rue ===================
	//getter
	public String getRue() {
		return rue;
	}
	//Setter
	public void setRue(String rue) {
		this.rue = rue;
	}

	//=================== code_postal ===================
	//getter
	public String getCode_postal() {
		return code_postal;
	}
	//Setter
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	//=================== ville ===================
	//getter
	public String getVille() {
		return ville;
	}

	//=================== ville ===================
	//Setter
	public void setVille(String ville) {
		this.ville = ville;
	}

	//======================toString Retrait.java ======================//
	@Override
	public String toString() {
		return "Retrait No: " 			+ getNoArticle() 
				+ " /Rue: " 			+ getRue()
				+ " /CdP: " 			+ getCode_postal()
				+ " /Ville: " 		+ getVille() 
				+ "-";
	}

	
	
}
