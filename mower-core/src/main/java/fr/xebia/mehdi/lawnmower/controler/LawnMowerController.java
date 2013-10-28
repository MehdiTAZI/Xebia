package fr.xebia.mehdi.lawnmower.controler;

import java.util.LinkedList;

import fr.xebia.mehdi.lawnmower.command.MowerCommand;
import fr.xebia.mehdi.lawnmower.exception.UnrecognizedCommandException;
import fr.xebia.mehdi.lawnmower.model.Lawn;
import fr.xebia.mehdi.lawnmower.model.Mower;
import fr.xebia.mehdi.lawnmower.model.MowerPosition;

//LawnMower controler class
public class LawnMowerController {

	private Mower mower;
	private Lawn lawn;
	
	public LawnMowerController(final Mower mower,final Lawn lawn) {
		this.mower = mower;
		this.lawn=lawn;
	}
	//for each commandList update MowerPosition with the correct value
	public MowerPosition update(final LinkedList<MowerCommand> commandList) throws UnrecognizedCommandException {
		if (commandList != null) {

			while (!commandList.isEmpty()){
				MowerCommand command = commandList.removeFirst();
				
				if (command != null) {
					command.updatePosition(mower, lawn);
				} else {
					throw new UnrecognizedCommandException();
				}
			}

		}

		return mower.getCurrentPosition();
	}

}
