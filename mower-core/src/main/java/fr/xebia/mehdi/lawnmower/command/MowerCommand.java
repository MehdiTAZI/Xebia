package fr.xebia.mehdi.lawnmower.command;

import fr.xebia.mehdi.lawnmower.model.Lawn;
import fr.xebia.mehdi.lawnmower.model.Mower;

//default Command Interface
public interface MowerCommand {
	void updatePosition(Mower mower, Lawn lawn);
}
