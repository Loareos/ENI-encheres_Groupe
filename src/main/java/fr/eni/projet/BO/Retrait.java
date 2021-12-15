/**
 * 
 */
package fr.eni.projet.BO;

/**
 * @author junisaru69
 *	Modif by
 */
public class Retrait {

	private ArticleVendu 	article;
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
	public Retrait(ArticleVendu article, String rue, String code_postal, String ville) {
		this.article 		= article;
		this.rue 			= rue;
		this.code_postal 	= code_postal;
		this.ville 			= ville;
	}

	//======================================================================//
	//								Getters-Setters 
	//======================================================================//

	//=================== noArticle ===================
	//getter
	public ArticleVendu getArticle() {
		return article;
	}
	//Setter
	public void setArticle(ArticleVendu article) {
		this.article = article;
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
		return "Retrait No: " 	+getArticle()
				+ " /Rue: " 	+ getRue()
				+ " /CdP: " 	+ getCode_postal()
				+ " /Ville: " 	+ getVille() 
				+ "-";
	}

	
	
}
