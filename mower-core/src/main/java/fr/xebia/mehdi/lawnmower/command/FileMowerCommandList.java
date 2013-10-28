package fr.xebia.mehdi.lawnmower.command;

import java.util.LinkedList;

public class FileMowerCommandList extends ObjectMowerCommandList {

	public FileMowerCommandList(String fileName) {
		super(null);
		LinkedList<MowerCommand> mowerCommands = new LinkedList<MowerCommand>();
	}
}
