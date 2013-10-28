package fr.xebia.mehdi.lawnmower.command;

import java.util.LinkedList;

public class MowerCommandListObject implements MowerCommandList {
	
	protected LinkedList<MowerCommand> commandList;
	
	public MowerCommandListObject(LinkedList<MowerCommand> commandList){
		this.commandList = commandList; 
	}
	
	public LinkedList<MowerCommand> getMowerCommands() {
		return this.commandList;
	}

}
