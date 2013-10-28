package fr.xebia.mehdi.lawnmower.model;

import fr.xebia.mehdi.lawnmower.exception.NegativeNumberException;
import fr.xebia.mehdi.lawnmower.math.Direction;
import fr.xebia.mehdi.lawnmower.math.Vector2D;

//Lawn class
public class Lawn {

	//error message
	private static final String CORDINAT_ERROR_MESSAGE = "UpperCorner cordinat must be diffrent from null and greater or equal to zero.";

	//lower x1,y1
	private final Vector2D lowerCorner = Vector2D.ZERO;
	//upper x2,y2
	private Vector2D upperCorner;

	public Vector2D getUpperCorner() {
		return upperCorner;
	}

	public void setUpperCorner(final Vector2D upperCorner)
			throws NegativeNumberException {

		if (upperCorner == null || upperCorner.getX() < 0
				|| upperCorner.getY() < 0) {
			throw new NegativeNumberException(CORDINAT_ERROR_MESSAGE);
		}

		this.upperCorner = upperCorner;
	}

	public Vector2D getLowerCorner() {
		return lowerCorner;
	}
	//check if the mower is in collision with the lawn border
	public boolean isCollid(final Mower mower) {

		final int mower_x = mower.getCurrentPosition().getX();
		final int mower_y = mower.getCurrentPosition().getY();
		final Direction mower_direction = mower.getCurrentPosition()
				.getDirection();

		if ((mower_x == this.lowerCorner.getX() && mower_direction == Direction.WEST)
				|| (mower_x == this.upperCorner.getX() && mower_direction == Direction.EAST)
				|| (mower_y == this.lowerCorner.getY() && mower_direction == Direction.SOUTH)
				|| (mower_y == this.upperCorner.getY() && mower_direction == Direction.NORTH)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		
		return this.lowerCorner + " => " + this.upperCorner;
	}
	
	
}
