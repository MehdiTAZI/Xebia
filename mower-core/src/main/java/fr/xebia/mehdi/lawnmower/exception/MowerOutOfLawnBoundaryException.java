package fr.xebia.mehdi.lawnmower.exception;

//throw this when a mower is out of Lawn Boundary
public class MowerOutOfLawnBoundaryException extends Exception {


	private static final long serialVersionUID = -6867814659841640824L;

	public MowerOutOfLawnBoundaryException() {
		super("the mower cordinates are out of lawn boundary, please change the mower position or the lawn map size.");
	}

	public MowerOutOfLawnBoundaryException(String message) {
		super(message);
	}

	public MowerOutOfLawnBoundaryException(String message, Throwable cause) {
		super(message, cause);
	}

	public MowerOutOfLawnBoundaryException(Throwable cause) {
		super(cause);
	}

}
