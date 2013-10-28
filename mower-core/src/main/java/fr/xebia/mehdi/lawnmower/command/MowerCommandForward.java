package fr.xebia.mehdi.lawnmower.command;

import fr.xebia.mehdi.lawnmower.model.Lawn;

import fr.xebia.mehdi.lawnmower.model.Mower;

//Mower behavior when it must go straight
public class MowerCommandForward implements MowerCommand {

	public void updatePosition(Mower mower, Lawn lawn) {
		//check for any collision before moving the mower
		if (!lawn.isCollid(mower)) {
			mower.move();
		}
		
	}
}
