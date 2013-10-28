package fr.xebia.mehdi.lawnmower.command;

import fr.xebia.mehdi.lawnmower.model.Lawn;

import fr.xebia.mehdi.lawnmower.model.Mower;

//When mower must turn go ahead
public class ForwardCommand implements MowerCommand {

	public void updatePosition(Mower mower, Lawn lawn) {
		
		if (!lawn.isCollid(mower)) {
			mower.move();
		}
		
	}
}
