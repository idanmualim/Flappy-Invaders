

public class Location {

	private int xPos;
	private int yPos;
	
	public Location(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public void setLocation(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public boolean equals(Object other) {
		Location loc = (Location)other;
		return (loc.getX() == xPos) && (loc.getY() == yPos);
	}
	
}
