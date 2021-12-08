/**
 * 
 */
package fr.eni.projet.BLL;

import java.util.ArrayList;
import java.util.List;

/**
 * @author junisaru69
 *
 */
public class BLLException extends Exception{
	/**
	 * 
	 * @author junisaru69
	 *
	 * Cette classe permet de recenser l'ensemble des erreurs (par leur code) pouvant survenir lors d'un traitement
	 * quel que soit la couche à l'origine.
	 */
		private static final long serialVersionUID = 1L;
		private List<Integer> listeCodesErreur;
		
		public BLLException() {
			super();
			this.listeCodesErreur=new ArrayList<>();
		}
		

		/**
		 * @param message
		 */
		public BLLException(String message) {
			super(message);
		}

		/**
		 * @param cause
		 */
		public BLLException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}


		/**
		 * @param message
		 * @param cause
		 */
		public BLLException(String message, Throwable cause) {
			super(message, cause);
		}
		
		/**
		 * 
		 * @param code Code de l'erreur. Doit avoir un message associé dans un fichier properties.
		 */
		public void ajouterErreur(int code)
		{
			if(!this.listeCodesErreur.contains(code))
			{
				this.listeCodesErreur.add(code);
			}
		}
		
		public boolean hasErreurs()
		{
			return this.listeCodesErreur.size()>0;
		}
		
		public List<Integer> getListeCodesErreur()
		{
			return this.listeCodesErreur;
		}

}
