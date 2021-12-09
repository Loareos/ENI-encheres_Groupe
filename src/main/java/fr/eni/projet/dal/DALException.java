package fr.eni.projet.dal;
/**
 * @author Loareos // Etienne // Copie exacte d'un ancien TP
 *
 */


public class DALException extends Exception {
	public DALException() {
		super();
	}

	public DALException(String message) {
		super(message);
	}

	public DALException(Throwable cause) {
		super(cause);
	}

	public DALException(String message, Throwable cause) {
		super(message, cause);
	}
	
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche DAL - ");
		sb.append(super.getMessage());
		return sb.toString() ;
	}	
}


