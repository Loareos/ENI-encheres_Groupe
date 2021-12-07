/**
 * 
 */
package fr.eni.projet.BO;

import java.util.Arrays;

/**
 * @author junisaru69
 *
 */
public class BOException extends Exception {

	/**
	 * constructor VIDE
	 */
	public BOException() {
		super();
	}

	/**
	 * @param message ,cause
	 */
	public BOException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public BOException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BOException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return "BOException:" + (getMessage() != null ? " Message:" + getMessage() + ", " : "")
				+ (getClass() != null ? "getClass()=" + getClass() + ", " : "") + "hashCode()=" + hashCode() + "]"
				+ (getLocalizedMessage() != null ? "getLocalizedMessage()=" + getLocalizedMessage() + ", " : "")
				+ (getCause() != null ? "getCause()=" + getCause() + ", " : "")
				+ (getStackTrace() != null ? "getStackTrace()=" + Arrays.toString(getStackTrace()) + ", " : "");
	}
	
	

}
