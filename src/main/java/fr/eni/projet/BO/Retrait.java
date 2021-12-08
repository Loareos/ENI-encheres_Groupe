/**
 * 
 */
package fr.eni.projet.BO;

/**
 * @author junisaru69
 *
 */
public class Retrait {
	
	private int noArticle;
	private String rue;
	private String code_postal;
	private String ville;
	
	////////////////////////////////////////////////////////////////
	//											Construct
	//______________________________________________________________


	/**
	 * @param no_article
	 * @param rue
	 * @param code_postal
	 * @param ville
	 */
	public Retrait(int no_article, String rue, String code_postal, String ville) {
		this(rue, code_postal, ville);
		this.noArticle = no_article;
	}
	/**
	 * @param rue
	 * @param code_postal
	 * @param ville
	 */
	public Retrait(String rue, String code_postal, String ville) {
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}
	////////////////////////////////////////////////////////////////
	//											Get/Set
	//______________________________________________________________
	/**
	 * @return the no_article
	 */
	public int getNo_article() {
		return noArticle;
	}
	/**
	 * @param no_article the no_article to set
	 */
	public void setNo_article(int no_article) {
		this.noArticle = no_article;
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
	public void setRue(String rue){
		this.rue = rue;
	}
	/**
	 * @return the code_postal
	 */
	public String getCode_postal() {
		return code_postal;
	}
	/**
	 * @param code_postal the code_postal to set
	 * @throws BOException 
	 */
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
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
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	@Override
	public String toString() {
		return "Retrait : no " + getNo_article()
							+ ", " + getRue()
							+ " "+ getCode_postal()
							+ " " + getVille()+ "-";
	}
	
	
	
}
