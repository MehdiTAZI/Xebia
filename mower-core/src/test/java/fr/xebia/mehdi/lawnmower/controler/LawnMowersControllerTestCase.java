package fr.xebia.mehdi.lawnmower.controler;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;



import org.junit.Before;
import org.junit.Test;

import fr.xebia.mehdi.lawnmower.exception.FileFormatException;
import fr.xebia.mehdi.lawnmower.exception.NoMowerFoundException;
import fr.xebia.mehdi.lawnmower.exception.UnrecognizedCommandException;
import fr.xebia.mehdi.lawnmower.math.Direction;
import fr.xebia.mehdi.lawnmower.model.Mower;


public class LawnMowersControllerTestCase {

	private LawnMowersController lawnMowersController;
	private String validFileName;
	private String badFileName;
	private String noMowerFileName;
	
	@Before
	public void setup() {
		this.validFileName = "valid_test_entry.txt";
		this.badFileName = "bad_test_entry.txt";
		this.noMowerFileName = "no_mower_test_entry.txt";
		this.lawnMowersController = null;
	}

	@Test
	public void validFileMowersTest() throws IOException, FileFormatException, NoMowerFoundException, UnrecognizedCommandException {
	
		final URL url = Class.class.getResource("/" + this.validFileName);
		final File file = new File(url.getPath());
	 	final String absolutFilePath = file.getAbsolutePath();
	
		
		this.lawnMowersController = new LawnMowersController(absolutFilePath);
	 	this.lawnMowersController.processAll();
		
		Mower mower1 = lawnMowersController.giveMower(0);
		Mower mower2 = lawnMowersController.giveMower(1);

		assertEquals(mower1.getCurrentPosition().getX(), 1);
		assertEquals(mower1.getCurrentPosition().getY(), 3);
		assertEquals(mower1.getCurrentPosition().getDirection(), Direction.NORTH);
		
		assertEquals(mower2.getCurrentPosition().getX(), 5);
		assertEquals(mower2.getCurrentPosition().getY(), 1);
		assertEquals(mower2.getCurrentPosition().getDirection(), Direction.EAST);
	}

	/*
	 * FileFormatException expected
	 * */
	
	@Test(expected = FileFormatException.class)
	public void badFileMowersTest() throws IOException, FileFormatException, NoMowerFoundException, UnrecognizedCommandException {
	
		final URL url = Class.class.getResource("/" + this.badFileName);
		final File file = new File(url.getPath());
	 	final String absolutFilePath = file.getAbsolutePath();
	
		
		this.lawnMowersController = new LawnMowersController(absolutFilePath);
	 	this.lawnMowersController.processAll();

	}
	
	/*
	 * NoMowerFoundException expected
	 * */
	
	@Test(expected = NoMowerFoundException.class)
	public void noMowerFileMowersTest() throws IOException, FileFormatException, NoMowerFoundException, UnrecognizedCommandException {
	
		final URL url = Class.class.getResource("/" + this.noMowerFileName);
		final File file = new File(url.getPath());
	 	final String absolutFilePath = file.getAbsolutePath();
	
		
		this.lawnMowersController = new LawnMowersController(absolutFilePath);
	 	this.lawnMowersController.processAll();
		
	
	}
}
