package br.com.caelum.jdbc.exception;

public class DAOException extends RuntimeException {

	private static final long serialVersionUID = -322092917794758086L;

	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
}
