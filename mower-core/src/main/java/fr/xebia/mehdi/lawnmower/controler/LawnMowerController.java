package fr.xebia.mehdi.lawnmower.controler;

import java.util.LinkedList;

import fr.xebia.mehdi.lawnmower.command.MowerCommandList;
import fr.xebia.mehdi.lawnmower.command.MowerCommand;
import fr.xebia.mehdi.lawnmower.command.MowerCommandListStringAdapter;
import fr.xebia.mehdi.lawnmower.exception.NegativeNumberException;
import fr.xebia.mehdi.lawnmower.exception.NotValidDirectionException;
import fr.xebia.mehdi.lawnmower.exception.UnrecognizedCommandException;
import fr.xebia.mehdi.lawnmower.math.Vector2D;
import fr.xebia.mehdi.lawnmower.model.Lawn;
import fr.xebia.mehdi.lawnmower.model.Mower;
import fr.xebia.mehdi.lawnmower.model.MowerPosition;

//LawnMower controler class
public class LawnMowerController {

	private Mower mower;
	private Lawn lawn;
	private MowerCommandList mowerCommandList;
	
	public Mower getMower() {
		return mower;
	}

	public void setMower(Mower mower) {
		this.mower = mower;
	}

	public Lawn getLawn() {
		return lawn;
	}

	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}
	

	public MowerCommandList getMowerCommandList() {
		return mowerCommandList;
	}

	public void setMowerCommandList(MowerCommandList mowerCommandList) {
		this.mowerCommandList = mowerCommandList;
	}

	public LawnMowerController(final Mower mower, final Lawn lawn,final MowerCommandList mowerCommandList) {
		this.mower = mower;
		this.lawn = lawn;
		this.mowerCommandList=mowerCommandList;
	}
	
	public LawnMowerController(final Mower mower, final Lawn lawn) {
		this.mower = mower;
		this.lawn = lawn;
	}
	
	public LawnMowerController(final String mowerPositionconfig,final String mowerCommandListconfig) throws NumberFormatException, NegativeNumberException, UnrecognizedCommandException, NotValidDirectionException {
		load(mowerPositionconfig,mowerCommandListconfig);
	}
	
	public LawnMowerController(final String mowerPositionconfig,final String mowerCommandListconfig,final String lawnConfig) throws NumberFormatException, NegativeNumberException, UnrecognizedCommandException, NotValidDirectionException {
		load(mowerPositionconfig,mowerCommandListconfig,lawnConfig);
	}
	
	public void load(final String mowerPositionconfig,final String mowerCommandListconfig,final String lawnConfig) throws NumberFormatException, NegativeNumberException, UnrecognizedCommandException, NotValidDirectionException {

		String[] upperCordinate = lawnConfig.split(" ");
		String[] mowerPositionAndDirection = mowerPositionconfig.split(" ");
		String mowerCommandList = mowerCommandListconfig;
		
		this.lawn = new Lawn();
		this.mower = new Mower();
		
		this.lawn.setUpperCorner(new Vector2D(Integer.parseInt(upperCordinate[0]),Integer.parseInt(upperCordinate[1])));
		this.mower.setCurrentPosition(new MowerPosition(Integer.parseInt(mowerPositionAndDirection[0]), Integer.parseInt(mowerPositionAndDirection[1]), mowerPositionAndDirection[2].charAt(0)));
		this.mowerCommandList = new MowerCommandListStringAdapter(mowerCommandList);
	}
	public void load(final String mowerPositionconfig,final String mowerCommandListconfig) throws NumberFormatException, NegativeNumberException, UnrecognizedCommandException, NotValidDirectionException {

		String[] mowerPositionAndDirection = mowerPositionconfig.split(" ");
		String mowerCommandList = mowerCommandListconfig;
		
		this.lawn = new Lawn();
		this.mower = new Mower();
		
		this.mower.setCurrentPosition(new MowerPosition(Integer.parseInt(mowerPositionAndDirection[0]), Integer.parseInt(mowerPositionAndDirection[1]), mowerPositionAndDirection[2].charAt(0)));
		this.mowerCommandList = new MowerCommandListStringAdapter(mowerCommandList);
	}
	
	// for each commandList update MowerPosition with the correct value
	public void process() throws UnrecognizedCommandException {
		if (this.mowerCommandList != null) {

			LinkedList<MowerCommand> mowerCommands = this.mowerCommandList
					.getMowerCommands();

			if (mowerCommands != null) {
				while (!mowerCommands.isEmpty()) {

					MowerCommand command = mowerCommands.removeFirst();

					if (command != null) {
						command.updatePosition(mower, lawn);
					} else {
						throw new UnrecognizedCommandException();
					}
				}
			}

		}
	}

}
