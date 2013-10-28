package fr.xebia.mehdi.lawnmower.exception;

//throw this when the RightCommand isn't defined
public class UnrecognizedCommandException extends Exception {


	private static final long serialVersionUID = 3214867065186661054L;

	public UnrecognizedCommandException() {
		super("the command is not recognized , please check the manual for the complete commands list.");
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
