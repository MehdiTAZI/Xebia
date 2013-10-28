package fr.xebia.mehdi.lawnmower.command;

import java.util.LinkedList;

public class ObjectMowerCommandList implements MowerCommandList {
	
	private LinkedList<MowerCommand> commandList;
	
	public ObjectMowerCommandList(LinkedList<MowerCommand> commandList){
		this.commandList = commandList; 
	}
	
	public LinkedList<MowerCommand> getMowerCommands() {
		return this.commandList;
	}

}
