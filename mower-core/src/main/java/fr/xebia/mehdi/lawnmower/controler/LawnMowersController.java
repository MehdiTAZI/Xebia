package fr.xebia.mehdi.lawnmower.controler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import fr.xebia.mehdi.lawnmower.exception.FileFormatException;
import fr.xebia.mehdi.lawnmower.exception.NoMowerFoundException;
import fr.xebia.mehdi.lawnmower.exception.UnrecognizedCommandException;
import fr.xebia.mehdi.lawnmower.model.Mower;


public class LawnMowersController {

	private List<LawnMowerController> lawnMowerControllers;

	//get a given mower
	public Mower giveMower(int index){
		if (index >= lawnMowerControllers.size()){
			throw new ArrayIndexOutOfBoundsException("the mower you'r asking for , doesn't exist.");
		}
		return lawnMowerControllers.get(index).getMower();
	}
	
	//initialise all the Mowers and the single lawn by the given filename
	public LawnMowersController(final String fileName) throws IOException,FileFormatException, NoMowerFoundException {
		lawnMowerControllers = new ArrayList<LawnMowerController>();
		String lawnConfiguration = null;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

		String currentLine = null;
		currentLine = reader.readLine();
		
		if (currentLine != null) {
			lawnConfiguration = new String(currentLine);
		}
		
		int mowersCount = 0;
		
		while ((currentLine = reader.readLine()) != null) {
			String mowerPositionAndDirection = new String(currentLine);
			currentLine = reader.readLine();
			if (currentLine == null) {
				reader.close();
				throw new FileFormatException();
			}
			String mowerCommandList =  new String(currentLine);
			
			try {
				lawnMowerControllers.add(new LawnMowerController(mowerPositionAndDirection,mowerCommandList,lawnConfiguration));
			} catch (Exception e){
				reader.close();
				throw new FileFormatException();
			}
			
			mowersCount++;
		}
		
		if (mowersCount ==0 ){
			reader.close();
			throw new NoMowerFoundException();
		}
		reader.close();
	}

	//process all the lawnMowerControllers
	public void processAll() throws UnrecognizedCommandException {
		for (LawnMowerController lawnMowerController : lawnMowerControllers) {
			lawnMowerController.process();
		}
	}

}
