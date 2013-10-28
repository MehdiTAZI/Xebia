package fr.xebia.mehdi.lawnmower.math;

//direction enumeratin
public enum Direction {
	
	// the values match with the four main cardinal orientations.
	NORTH('N',Vector2D.NORTH),
	EAST('E',Vector2D.EAST),
	WEST('W',Vector2D.WEST),
	SOUTH('S',Vector2D.SOUTH);

	private Vector2D value;
	private char letter;
	
	Direction(final char letter,final Vector2D value){
		this.value=value;
		this.letter = letter;
	}
	
	public Vector2D getValue() {
		return value;
	}

	public void setValue(Vector2D value) {
		this.value = value;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public static Direction getDirectionByLeeter(final char letter){
		switch(letter){
			case 'N' : return NORTH ;
			case 'E' : return EAST ;
			case 'W' : return WEST ;
			case 'S' : return SOUTH ;
			
			default : return null;
		}
	}
	
}
