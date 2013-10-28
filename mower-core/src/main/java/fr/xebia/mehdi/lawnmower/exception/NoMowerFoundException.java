package fr.xebia.mehdi.lawnmower.exception;

//throw this when the RightCommand isn't defined
public class NoMowerFoundException extends Exception {


	private static final long serialVersionUID = 3214867065186661054L;

	public NoMowerFoundException() {
		super("the command is not recognized , please check the manual for the complete commands list.");
	}

	public NoMowerFoundException(String message) {
		super(message);
	}

	public NoMowerFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoMowerFoundException(Throwable cause) {
		super(cause);
	}

}
