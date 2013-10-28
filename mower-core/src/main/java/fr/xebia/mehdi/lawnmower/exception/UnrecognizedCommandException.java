package fr.xebia.mehdi.lawnmower.exception;

//throw this when the RightCommand isn't defined
public class UnrecognizedCommandException extends Exception {


	private static final long serialVersionUID = 3214867065186661054L;

	public UnrecognizedCommandException() {
		super("there is no mower configuration on the configuration file , please check the file content");
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
