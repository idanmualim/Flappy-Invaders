package spaceobjects;

import field.Location;

public class Bullet extends SpaceObject {

	private final int SPEED; //Horizontal speed of bullet
	private final int WIDTH; //Horizontal length of bullet
	private final int HEIGHT; //Vertical length of bullet
	
	public Bullet(Location loc, GameField field, boolean firedByPlayer) {
		if(firedByPlayer)
			super(loc, SPEED, 0, field, WIDTH, HEIGHT)
		else
			super(loc, -SPEED, 0, field, WIDTH, HEIGHT)
	}
	
}
