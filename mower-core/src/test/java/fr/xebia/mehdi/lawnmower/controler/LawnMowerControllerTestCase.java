package fr.xebia.mehdi.lawnmower.controler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.xebia.mehdi.lawnmower.exception.MowerOutOfLawnBoundaryException;
import fr.xebia.mehdi.lawnmower.exception.NegativeNumberException;
import fr.xebia.mehdi.lawnmower.exception.NotValidDirectionException;
import fr.xebia.mehdi.lawnmower.exception.UnrecognizedCommandException;
import fr.xebia.mehdi.lawnmower.math.Direction;
import fr.xebia.mehdi.lawnmower.model.MowerPosition;

public class LawnMowerControllerTestCase {

	private LawnMowerController lawnMowerController;
	private String lawnConfiguration;
	@Before
	public void setup() {
		this.lawnConfiguration = "5 5";
		this.lawnMowerController = null;

	}

	/* 
	 * test mower using the given example :
	 * lawn upperCordinate = 5,5
	 * lawn initial position  : 1,2
	 * lawn looking direction : North
	 * commandList : GAGAGAGAA
	 * expect result :
	 * lawn position 1,3
	 * lawn lookAt : North
	*/
	@Test
	public void firstMowerTest() throws MowerOutOfLawnBoundaryException {

		try {
			this.lawnMowerController =  new LawnMowerController("1 2 N", "GAGAGAGAA",lawnConfiguration);
		} catch (NumberFormatException e1) {
			fail();
		} catch (NegativeNumberException e1) {
			fail();
		} catch (UnrecognizedCommandException e1) {
			fail();
		} catch (NotValidDirectionException e1) {
			fail();
		}
		try {
			this.lawnMowerController.process();
		} catch (UnrecognizedCommandException e) {
			fail();
		}
		
		MowerPosition currentPosition = this.lawnMowerController.getMower().getCurrentPosition();
		
		assertEquals(currentPosition.getX(), 1);
		assertEquals(currentPosition.getY(), 3);
		assertEquals(currentPosition.getDirection(), Direction.NORTH);
	}

	
	/* 
	 * test mower using the given example :
	 * lawn upperCordinate = 5,5
	 * lawn initial position  : 3,3
	 * lawn looking direction : EAST
	 * commandList : AADAADADDA
	 * expect result :
	 * lawn position 5,1
	 * lawn lookAt : EAST
	*/
	@Test
	public void secondMowerTest() throws MowerOutOfLawnBoundaryException {

		try {
			this.lawnMowerController =  new LawnMowerController("3 3 E", "AADAADADDA",lawnConfiguration);
		} catch (NumberFormatException e1) {
			fail();
		} catch (NegativeNumberException e1) {
			fail();
		} catch (UnrecognizedCommandException e1) {
			fail();
		} catch (NotValidDirectionException e1) {
			fail();
		}
		try {
			this.lawnMowerController.process();
		} catch (UnrecognizedCommandException e) {
			fail();
		}
		
		MowerPosition currentPosition = this.lawnMowerController.getMower().getCurrentPosition();
		
		assertEquals(currentPosition.getX(), 5);
		assertEquals(currentPosition.getY(), 1);
		assertEquals(currentPosition.getDirection(), Direction.EAST);
	}
	

	/*
	 * UnrecognizedCommandException expected
	 * */
	
	@Test(expected = UnrecognizedCommandException.class)
	public void UnRecognizedCommandTest() throws NumberFormatException, NegativeNumberException, UnrecognizedCommandException, NotValidDirectionException, MowerOutOfLawnBoundaryException {
			this.lawnMowerController =  new LawnMowerController("3 3 E", "AADNADADDA",lawnConfiguration);
	}
	
	/*
	 * NegativeNumberException expected
	 * */
	
	@Test(expected = NegativeNumberException.class)
	public void NegativeNumberTest() throws NumberFormatException, NegativeNumberException, UnrecognizedCommandException, NotValidDirectionException, MowerOutOfLawnBoundaryException {
			this.lawnMowerController =  new LawnMowerController("-3 3 E", "AADADADDA",lawnConfiguration);
	}
	
	@Test(expected = MowerOutOfLawnBoundaryException.class)
	public void OutOfLawnBoundaryTest() throws NumberFormatException, NegativeNumberException, UnrecognizedCommandException, NotValidDirectionException, MowerOutOfLawnBoundaryException {
			this.lawnMowerController =  new LawnMowerController("7 3 E", "AADADADDA",lawnConfiguration);
	}
	
}
