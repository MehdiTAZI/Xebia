package fr.xebia.mehdi.lawnmower.model;

import fr.xebia.mehdi.lawnmower.exception.NegativeNumberException;
import fr.xebia.mehdi.lawnmower.exception.NotValidDirectionException;
import fr.xebia.mehdi.lawnmower.math.Direction;
import fr.xebia.mehdi.lawnmower.math.Vector2D;

//MowerPosition use Facade design pattern in order to make the use of api easier 
public class MowerPosition {
	
	//Error messages
	private static final String POISITION_ERROR_MESSAGE = "LawnMower current position must be greater or equal to zero.";
	private static final String DIRECTION_ERROR_MESSAGE = "direction must be different from null , use N for North , E for Est , S for South , W for West.";

	// the currentPosition of the mower
	private Vector2D currentPosition;

	// the cardinal orientation of the Mower
	private Direction currentDirection;

	//Constructors
	public MowerPosition(final Vector2D mowerPosition, final Direction mowerDirection) throws NegativeNumberException {
		
		if (mowerPosition == null || mowerPosition.getX() < 0 || mowerPosition.getY() <0) {
			throw new NegativeNumberException(POISITION_ERROR_MESSAGE);
		}
			
		if (currentDirection == null) {
			throw new NullPointerException(DIRECTION_ERROR_MESSAGE);
		}
		
		this.currentPosition=mowerPosition;
		this.currentDirection=mowerDirection;	
	}
	
	public MowerPosition(final int x, final int y, final char directionLetter) throws NegativeNumberException, NotValidDirectionException {
		if (x < 0 || y <0 ) {
			throw new NegativeNumberException(POISITION_ERROR_MESSAGE);
		}
		
		this.currentPosition = new Vector2D(x,y);
		
		this.currentDirection = Direction.getDirectionByLeeter(directionLetter);
		if (currentDirection == null) {
			throw new NullPointerException(DIRECTION_ERROR_MESSAGE);
		}
	}
	

	public int getX() {
		return this.currentPosition.getX();
	}

	public void setX(int x) throws NegativeNumberException {
		if (x < 0) {
			throw new NegativeNumberException(POISITION_ERROR_MESSAGE);
		}
		this.currentPosition.setX(x);
	}

	public int getY() {
		return this.currentPosition.getY();
	}

	public void setY(int y) throws NegativeNumberException {
		if (y < 0) {
			throw new NegativeNumberException(POISITION_ERROR_MESSAGE);
		}
		this.currentPosition.setX(y);
	}

	public Direction getDirection() {
		return this.currentDirection;
	}

	public void setDirection(Direction direction) {
		if (direction == null) {
			throw new NullPointerException(DIRECTION_ERROR_MESSAGE);
		}
		this.currentDirection = direction;
	}

	public void setDirection(final char directionLetter) throws NotValidDirectionException {
		this.currentDirection = Direction.getDirectionByLeeter(directionLetter);
		if (currentDirection == null) {
			throw new NullPointerException(DIRECTION_ERROR_MESSAGE);
		}
	}
	
	// move the mower in the corresponding direction
	protected void move(){
		this.currentPosition = this.currentPosition.add(this.currentDirection.getValue());
	}

}
