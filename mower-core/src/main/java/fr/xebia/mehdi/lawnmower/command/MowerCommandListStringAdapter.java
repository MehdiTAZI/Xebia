package fr.xebia.mehdi.lawnmower.command;

import java.util.LinkedList;

import fr.xebia.mehdi.lawnmower.exception.UnrecognizedCommandException;

//Fill mowerCommandListObject using string 
public class MowerCommandListStringAdapter extends MowerCommandListObject {

	public MowerCommandListStringAdapter(String mowercommandList) throws UnrecognizedCommandException {
		super(null);
		
		LinkedList<MowerCommand> mowerCommands = new LinkedList<MowerCommand>();
		for (int i =0;i<mowercommandList.length();i++){
			char command = mowercommandList.charAt(i);
			
			switch(command){
			case 'G':
				mowerCommands.add(new MowerCommandLeft());
				break;
			case 'D':
				mowerCommands.add(new MowerCommandRight());
				break;
			case 'A' : 
				mowerCommands.add(new MowerCommandForward());
				break;
			default:
				throw new UnrecognizedCommandException();
			}
		}
		
		this.commandList = mowerCommands;
		
	}

}
