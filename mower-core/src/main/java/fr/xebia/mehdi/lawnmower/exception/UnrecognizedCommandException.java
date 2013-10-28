package fr.xebia.mehdi.lawnmower.exception;

//throw this when the mower command is not valid.
public class UnrecognizedCommandException extends Exception {


	private static final long serialVersionUID = 3214867065186661054L;

	public UnrecognizedCommandException() {
		super("there is no such mower command , please check the manual for the completed mower command list.");
	}

	public UnrecognizedCommandException(String message) {
		super(message);
	}

	public UnrecognizedCommandException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnrecognizedCommandException(Throwable cause) {
		super(cause);
	}

}
