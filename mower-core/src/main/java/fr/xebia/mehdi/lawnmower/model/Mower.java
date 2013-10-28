
package fr.xebia.mehdi.lawnmower.model;

//Mower class
public class Mower {

	//mower position and orientation
	private MowerPosition position;


	public Mower() {
	}

	
	public MowerPosition getCurrentPosition() {
		return position;
	}

	
	public void setCurrentPosition(final MowerPosition position) {
		this.position = position;
	}

	//move the mower corresponding to the 
	public void move(){
		this.getCurrentPosition().move();
	}


	@Override
	public String toString() {
		return "("+this.position.getX()+","+this.position.getY()+") LookAt : " + this.position.getDirection();
	}
	
	
}
