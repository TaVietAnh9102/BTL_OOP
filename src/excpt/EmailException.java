package excpt;

import java.beans.ExceptionListener;

public class EmailException extends Exception {
	/**
	 * 
	 */
	private String email;
	
	public EmailException(String email) {
		this.email = email;
	}
	
}
