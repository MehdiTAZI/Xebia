package fr.xebia.mehdi.lawnmower.exception;

//throw this when a positif number recieve a negatif value 
public class NegativeNumberException extends Exception {

	private static final long serialVersionUID = -1655094889053520873L;

	public NegativeNumberException() {
		super("the number must be greater or equal to zero.");
	}

	public NegativeNumberException(String message) {
		super(message);
	}

	public NegativeNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	public NegativeNumberException(Throwable cause) {
		super(cause);
	}

}
