package fr.xebia.mehdi.lawnmower.command;

import java.util.LinkedList;

import fr.xebia.mehdi.lawnmower.exception.UnrecognizedCommandException;

public class StringMowerCommandList extends ObjectMowerCommandList {

	public StringMowerCommandList(String mowercommandList) throws UnrecognizedCommandException {
		super(null);
		
		LinkedList<MowerCommand> mowerCommands = new LinkedList<MowerCommand>();
		for (int i =0;i<mowercommandList.length();i++){
			char command = mowercommandList.charAt(i);
			
			switch(command){
			case 'G':
				mowerCommands.add(new LeftCommand());
				break;
			case 'D':
				mowerCommands.add(new RightCommand());
				break;
			case 'A' : 
				mowerCommands.add(new ForwardCommand());
				break;
			default:
				throw new UnrecognizedCommandException();
			}
		}
		
	}

}
