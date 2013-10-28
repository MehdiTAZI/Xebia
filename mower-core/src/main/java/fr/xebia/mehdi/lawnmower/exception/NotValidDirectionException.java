package fr.xebia.mehdi.lawnmower.exception;

//throw this when a selected direction is not correct.
public class NotValidDirectionException extends Exception {


	private static final long serialVersionUID = 3214867065186661054L;

	public NotValidDirectionException() {
		super("the direction you selected doesn't exist. please verify your data content.");
	}

	public NotValidDirectionException(String message) {
		super(message);
	}

	public NotValidDirectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotValidDirectionException(Throwable cause) {
		super(cause);
	}

}
