package fr.eni.groupe2.messages;

public class DALException extends Exception {

	private static final long serialVersionUID = 1L;

	public DALException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DALException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String getMessage() {
		return "couche DAL " + super.getMessage();
	}
	
	
}
