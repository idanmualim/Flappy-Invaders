package spaceobjects;

import field.Location;

public class Bullet extends SpaceObject {

	private final static int SPEED = 15; //Horizontal speed of bullet
	private final static int WIDTH = 5; //Horizontal length of bullet
	private final static int HEIGHT = 2; //Vertical length of bullet
	
	public Bullet(Location loc, GameField field, boolean firedByPlayer) {
		if(firedByPlayer)
			super(loc, SPEED, 0, field, WIDTH, HEIGHT)
		else
			super(loc, -SPEED, 0, field, WIDTH, HEIGHT)
	}
	
}
