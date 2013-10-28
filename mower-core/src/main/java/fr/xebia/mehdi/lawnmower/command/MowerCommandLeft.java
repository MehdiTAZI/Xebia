package fr.xebia.mehdi.lawnmower.command;

import fr.xebia.mehdi.lawnmower.math.Direction;
import fr.xebia.mehdi.lawnmower.model.Lawn;
import fr.xebia.mehdi.lawnmower.model.Mower;

//Mower behavior when it must turn left
public class MowerCommandLeft implements MowerCommand {

	public void updatePosition(Mower mower, Lawn lawn) {
		final Direction direction = mower.getCurrentPosition().getDirection();
		
		//mower changing direction
		if (direction == Direction.NORTH) {
			mower.getCurrentPosition().setDirection(Direction.WEST);
		} else if (direction == Direction.WEST) {
			mower.getCurrentPosition().setDirection(Direction.SOUTH);
		} else if (direction == Direction.SOUTH) {
			mower.getCurrentPosition().setDirection(Direction.EAST);
		} else if (direction == Direction.EAST) {
			mower.getCurrentPosition().setDirection(Direction.NORTH);
		}
	}
	
	//for debuging purpose
	@Override
	public String toString() {
		return "Left";
	}
}
