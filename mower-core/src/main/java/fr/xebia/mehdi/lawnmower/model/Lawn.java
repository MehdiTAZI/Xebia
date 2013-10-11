package fr.xebia.mehdi.lawnmower.model;

import fr.xebia.mehdi.lawnmower.exception.NegativeNumberException;
import fr.xebia.mehdi.lawnmower.math.Vector2D;

public class Lawn {

	private static final String CORDINAT_ERROR_MESSAGE = "UpperCorner cordinat must be diffrent from null and greater or equal to zero.";
	
	private final Vector2D lowerCorner = Vector2D.ZERO;
	private Vector2D upperCorner;
	
	public Vector2D getUpperCorner() {
		return upperCorner;
	}
	public void setUpperCorner(final Vector2D upperCorner) throws NegativeNumberException {
		
		if (upperCorner == null || upperCorner.getX() < 0 || upperCorner.getY() <0) {
			throw new NegativeNumberException(CORDINAT_ERROR_MESSAGE);
		}
		
		this.upperCorner = upperCorner;
	}
	
	public Vector2D getLowerCorner() {
		return lowerCorner;
	}
	
}
