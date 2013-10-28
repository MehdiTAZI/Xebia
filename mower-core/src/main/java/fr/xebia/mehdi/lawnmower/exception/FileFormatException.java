package fr.xebia.mehdi.lawnmower.exception;

//throw this when a the file configuration format is not valid
public class FileFormatException extends Exception {

	private static final long serialVersionUID = -1322863455165888096L;

	public FileFormatException() {
		super("the mower file structure is not correct, please check the file content.");
	}

	public FileFormatException(String message) {
		super(message);
	}

	public FileFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileFormatException(Throwable cause) {
		super(cause);
	}

}
