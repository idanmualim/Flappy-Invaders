package spaceobjects;

import field.Location;

public class Bullet extends SpaceObject {

	private final int DEFAULT_SPEED = 1;
	
	public Bullet(Location loc, boolean firedByPlayer) {
		setLocation(loc);
		if(firedByPlayer)
			setXVel(DEFAULT_SPEED);
		else
			setXVel(-DEFAULT_SPEED);
	}
	
}
