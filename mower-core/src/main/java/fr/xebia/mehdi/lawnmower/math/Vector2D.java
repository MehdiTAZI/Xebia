package fr.xebia.mehdi.lawnmower.math;

//Math Vector2D class
public class Vector2D {

	//some defaut values
	public final static Vector2D ZERO = new Vector2D(0,0);
	public final static Vector2D ONE = new Vector2D(1,1);
	
	public final static Vector2D NORTH = new Vector2D(0,1);
	public final static Vector2D SOUTH = new Vector2D(0,-1);
	public final static Vector2D WEST = new Vector2D(-1,0);
	public final static Vector2D EAST = new Vector2D(1,0);

	
	private int x;
	private int y;
	
	
	public Vector2D() {
		x = 0;
		y = 0;
	}

	public Vector2D(final int x , final int y) {
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public void setX(final int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(final int y)  {
		this.y = y;
	}

	public Vector2D add(final Vector2D vector) {
		return new Vector2D(this.x+vector.x, this.y+vector.y);
	}
	
	public Vector2D substract(final Vector2D vector) {
		return new Vector2D(this.x-vector.x, this.y-vector.y);
	}
	
	//Creates a unit vector from the specified vector. The result is a vector one unit in length.
	public Vector2D normalize(){
		// TODO : DIVISION BY ZERO Exception
		return new Vector2D(this.x/(this.x+this.y), this.y/(this.x+this.y));
	}

	public boolean equals(Vector2D vector) {
		return this.x == vector.x && this.y == vector.y;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("( ").append(x).append(" , ").append(y).append(" )");
		return buffer.toString();
	}
	
	
	
}
