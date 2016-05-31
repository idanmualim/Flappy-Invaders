package spaceobjects;

import java.awt.Color;

import field.GameField;
import field.Location;

public class Explosion
{
	
	double velocity;
	Location location;
	
	private Color type;

	public Star(Location loc, GameField field)
	{
		int starColor = (int)(Math.random() * 7);//Start of color selector code
		if (starColor <= 3)
			type = Color.WHITE;
		else if (starColor == 4)
			type = Color.BLUE;
		else if (starColor == 5)
			type = Color.YELLOW;
		else if (starColor == 6)
			type = Color.RED;

		int speedID = (int) (Math.random() * 3);
		if (speedID == 0)
			velocity = SLOW;
		else if (speedID == 1)
			velocity = MEDIUM;
		else if (speedID == 2)
			velocity = FAST;
		
		location = loc;

	}

	public void act() {
		location.setLocation((int)(location.getX() + velocity), location.getY());
	}
	
	public Location getLocation() {
		return location;
	}
	
	public Color getColor() {
		return type;
	}

}
