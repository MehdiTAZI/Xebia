package fr.xebia.mehdi.lawnmower.model;

import fr.xebia.mehdi.lawnmower.model.helper.MowerPosition;

public class Mower {


	private MowerPosition position;


	public Mower() {
	}

	
	public MowerPosition getCurrentPosition() {
		return position;
	}

	
	public void setCurrentPosition(final MowerPosition position) {
		this.position = position;
	}

}
