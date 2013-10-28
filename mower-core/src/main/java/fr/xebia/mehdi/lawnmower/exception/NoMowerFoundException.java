package fr.xebia.mehdi.lawnmower.exception;

//throw this when no mower exist in mower file configuration
public class NoMowerFoundException extends Exception {


	private static final long serialVersionUID = 3214867065186661054L;

	public NoMowerFoundException() {
		super("there is no mower identified into the file configuration, please check the file content.");
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
